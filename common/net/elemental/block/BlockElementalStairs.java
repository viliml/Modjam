package net.elemental.block;

import net.elemental.Elemental;
import net.minecraft.block.BlockStairs;

public class BlockElementalStairs extends BlockStairs
{
	public BlockElementalStairs(int id, int meta)
	{
		super(id, Blocks.elementalStoneBlock, meta);
		useNeighborBrightness[id] = true;
		setCreativeTab(Elemental.creativeTabElemental);
	}
}
