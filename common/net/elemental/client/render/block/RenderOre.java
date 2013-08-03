package net.elemental.client.render.block;

import net.elemental.block.BlockElementalOre;
import net.elemental.block.Blocks;
import net.elemental.client.render.RenderHandlers;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderOre implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int meta, int modelID,
			RenderBlocks renderer)
	{
		renderer.renderBlockAsItem(Blocks.elementalStoneBlock, meta & 3, 1F);
		renderer.renderBlockAsItem(block, meta, 1F);
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer)
	{
		int meta = world.getBlockMetadata(x, y, z);
		renderer.setOverrideBlockTexture(Blocks.elementalStoneBlock.getIcon(1, meta & 3));
		renderer.renderAllFaces = true;
		renderer.renderStandardBlock(block, x, y, z);
		int icon = meta / 4;
		if (block.blockID == Blocks.elementalOreBlock2.blockID)
			icon += 4;
		renderer.setOverrideBlockTexture(BlockElementalOre.overlays[icon]);
		renderer.renderStandardBlock(block, x, y, z);
		renderer.renderAllFaces = false;
		renderer.clearOverrideBlockTexture();
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
