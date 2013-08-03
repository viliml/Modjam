package net.elemental.client.render.block;

import net.elemental.block.BlockElementalOre;
import net.elemental.block.Blocks;
import net.elemental.client.render.RenderHandlers;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderOre implements ISimpleBlockRenderingHandler 
{
	public static int renderPass;

	@Override
	public void renderInventoryBlock(Block block, int meta, int modelID,
			RenderBlocks renderer)
	{
		if (renderPass == 0)
		{
			renderer.setOverrideBlockTexture(Blocks.elementalStoneBlock.getIcon(1, meta & 3));
			renderer.renderBlockAsItem(Blocks.elementalStoneBlock, meta & 3, 1F);
			renderer.clearOverrideBlockTexture();
		}
		else
		{
			int icon = meta / 4;
			if (block.blockID == Blocks.elementalOreBlock2.blockID)
				icon += 4;
			renderer.setOverrideBlockTexture(BlockElementalOre.overlays[icon]);
			renderer.renderBlockAsItem(Blocks.elementalStoneBlock, meta, 1F);
			renderer.clearOverrideBlockTexture();
		}
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer)
	{
		int meta = world.getBlockMetadata(x, y, z);
		//!!!!!!!!! Look at the console output!
		/*if (renderPass == 0)
		{
			renderer.setOverrideBlockTexture(Blocks.elementalStoneBlock.getIcon(1, meta & 3));
			System.out.println(Blocks.elementalStoneBlock.getIcon(1, meta & 3));
			renderer.renderAllFaces = true;
			//renderer.renderStandardBlock(block, x, y, z);
			renderer.clearOverrideBlockTexture();
		}
		else*/
		{
			int icon = meta / 4;
			if (block.blockID == Blocks.elementalOreBlock2.blockID)
				icon += 4;
			System.out.println(BlockElementalOre.overlays[icon]);
			renderer.setOverrideBlockTexture(BlockElementalOre.overlays[icon]);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.renderAllFaces = false;
			renderer.clearOverrideBlockTexture();
		}
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory()
	{
		return true;
	}

	@Override
	public int getRenderId()
	{
		return RenderHandlers.RENDER_ORE_RENDER_ID;
	}
}
