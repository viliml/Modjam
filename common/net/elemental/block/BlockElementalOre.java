package net.elemental.block;

import java.util.List;

import net.elemental.client.render.RenderHandlers;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class BlockElementalOre extends Block {

	public BlockElementalOre(int par1, Material par2Material) {
		super(par1, par2Material);
	}

	@Override
	public int getRenderType()
	{
		return RenderHandlers.RENDER_ORE_RENDER_ID;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void getSubBlocks(int id, CreativeTabs tab, List list)
	{
		for (int i = 0; i < 16; ++i)
			list.add(new ItemStack(id, 1, i));
	}
}
