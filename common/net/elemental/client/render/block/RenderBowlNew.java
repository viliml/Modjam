package net.elemental.client.render.block;

import net.elemental.client.render.RenderHandlers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFluid;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderBowlNew implements ISimpleBlockRenderingHandler
{
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {

	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
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
		
		int meta = world.getBlockMetadata(x, y, z);
		if (meta == 0)
			return true;
		
		Icon content = null;
		
		switch (meta - 1)
		{
		case 0:
			//Earth
			content = Block.dirt.getIcon(1, 0);
			break;
		case 1:
			//Air
			//Smoke particles
			return true;
		case 2:
			//Fire
			//Flame particles
			return true;
		case 3:
			//Water
			content = BlockFluid.func_94424_b("water_still");
			break;
		}
		renderer.enableAO = false;
		
		renderer.colorRedBottomLeft = 1F;
		renderer.colorRedBottomRight = 1F;
		renderer.colorRedTopLeft = 1F;
		renderer.colorRedTopRight = 1F;
		
		renderer.colorGreenBottomLeft = 1F;
		renderer.colorGreenBottomRight = 1F;
		renderer.colorGreenTopLeft = 1F;
		renderer.colorGreenTopRight = 1F;
		
		renderer.colorBlueBottomLeft = 1F;
		renderer.colorBlueBottomRight = 1F;
		renderer.colorBlueTopLeft = 1F;
		renderer.colorBlueTopRight = 1F;
		
		GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		
		renderer.renderFaceYPos(block, (double)x, (double)((float)y - 5F / 16F + 4F / 16F + 0.01F), (double)z, content);
		
		GL11.glDisable(GL11.GL_BLEND);

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
