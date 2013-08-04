package net.elemental.client.render.block;

import net.elemental.block.BlockBowl;
import net.elemental.client.render.RenderHandlers;
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
		Tessellator tessellator = Tessellator.instance;
		tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
		float f = 1F;
		int l = block.colorMultiplier(world, x, y, z);
		float f1 = (float)(l >> 16 & 255) / 255F;
		float f2 = (float)(l >> 8 & 255) / 255F;
		float f3 = (float)(l & 255) / 255F;
		float f4;

		if (EntityRenderer.anaglyphEnable)
		{
			float f5 = (f1 * 30F + f2 * 59F + f3 * 11F) / 100F;
			f4 = (f1 * 30F + f2 * 70F) / 100F;
			float f6 = (f1 * 30F + f3 * 70F) / 100F;
			f1 = f5;
			f2 = f4;
			f3 = f6;
		}

		tessellator.setColorOpaque_F(f * f1, f * f2, f * f3);
		Icon icon = block.getBlockTextureFromSide(2);
		
		f4 = .125F;
		renderer.renderFaceXPos(block, (double)((float)x - 1F + f4), (double)y, (double)z, icon);
		renderer.renderFaceXNeg(block, (double)((float)x + 1F - f4), (double)y, (double)z, icon);
		renderer.renderFaceZPos(block, (double)x, (double)y, (double)((float)z - 1F + f4), icon);
		renderer.renderFaceZNeg(block, (double)x, (double)y, (double)((float)z + 1F - f4), icon);
		//Icon icon1 = BlockBowl.func_94375_b("inner");
		
		//renderer.renderFaceYPos(block, (double)x, (double)((float)y - 5F / 16F + .25F), (double)z, icon1);
		//renderer.renderFaceYNeg(block, (double)x, (double)((float)y + 1F - .75F), (double)z, icon1);
		int meta = world.getBlockMetadata(x, y, z);
		
		Icon content = null;
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
		renderer.renderFaceYPos(block, (double)x, (double)((float)y - 5F / 16F + 4F / 16F), (double)z, content);

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
