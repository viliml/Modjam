package net.elemental.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockElementalWall extends BlockWall
{

	public BlockElementalWall(int id)
	{
		super(id, Blocks.elementalStoneBlock);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public Icon getIcon(int side, int meta)
    {
        return Blocks.elementalStoneBlock.getIcon(side, 4 + meta);
    }
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void getSubBlocks(int id, CreativeTabs tab, List list)
    {
		for (int i = 0; i < 4; ++i)
			list.add(new ItemStack(id, 1, i));
    }
}
