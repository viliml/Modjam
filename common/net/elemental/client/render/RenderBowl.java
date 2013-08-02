package net.elemental.client.render;

import net.elemental.block.BlockBowl;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFluid;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderBowl implements ISimpleBlockRenderingHandler
{
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {

	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
		renderer.renderStandardBlock(block, x, y, z);
		System.out.println("Statring bowl rendering.");
		Tessellator tessellator = Tessellator.instance;
		tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
		float f = 1.0F;
		int l = block.colorMultiplier(world, x, y, z);
		float f1 = (float)(l >> 16 & 255) / 255.0F;
		float f2 = (float)(l >> 8 & 255) / 255.0F;
		float f3 = (float)(l & 255) / 255.0F;
		float f4;

		if (EntityRenderer.anaglyphEnable)
		{
			float f5 = (f1 * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F;
			f4 = (f1 * 30.0F + f2 * 70.0F) / 100.0F;
			float f6 = (f1 * 30.0F + f3 * 70.0F) / 100.0F;
			f1 = f5;
			f2 = f4;
			f3 = f6;
		}

		tessellator.setColorOpaque_F(f * f1, f * f2, f * f3);
		Icon icon = block.getBlockTextureFromSide(2);
		System.out.println(icon);
		f4 = 0.125F;
		renderer.renderFaceXPos(block, (double)((float)x - 1.0F + f4), (double)y, (double)z, icon);
		renderer.renderFaceXNeg(block, (double)((float)x + 1.0F - f4), (double)y, (double)z, icon);
		renderer.renderFaceZPos(block, (double)x, (double)y, (double)((float)z - 1.0F + f4), icon);
		renderer.renderFaceZNeg(block, (double)x, (double)y, (double)((float)z + 1.0F - f4), icon);
		Icon icon1 = BlockBowl.func_94375_b("inner");
		System.out.println(icon1);
		renderer.renderFaceYPos(block, (double)x, (double)((float)y - 1.0F + 0.25F), (double)z, icon1);
		renderer.renderFaceYNeg(block, (double)x, (double)((float)y + 1.0F - 0.75F), (double)z, icon1);
		int meta = world.getBlockMetadata(x, y, z);
		System.out.println(meta);
		Icon content = null; //default
		switch (meta)
		{
		case 0:
			//Earth
			content = Block.dirt.getIcon(1, 0);
			break;
		case 1:
			//Air
			//NOOP
			return true;
		case 2:
			//Fire
			content = BlockFluid.func_94424_b("lava_still");
			break;
		case 3:
			//Water
			content = BlockFluid.func_94424_b("water_still");
			break;
		}
		System.out.println(content);
		renderer.renderFaceYPos(block, (double)x, (double)((float)y + 1.0F + 4F / 16.0F), (double)z, content);

		return true;
	}

	@Override
	public boolean shouldRender3DInInventory()
	{
		return false;
	}

	@Override
	public int getRenderId()
	{
		return RenderHandlers.RENDER_BOWL_RENDER_ID;
	}
}
