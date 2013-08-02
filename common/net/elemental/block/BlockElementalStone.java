package net.elemental.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class BlockElementalStone extends Block
{
	public BlockElementalStone(int id)
	{
		super(id, Material.rock);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta)
	{
		return this.blockIcon;
	}
	
	@Override
	public int damageDropped(int meta)
	{
		return meta;
	}
	
	@Override
	public void getSubBlocks(int id, CreativeTabs creativeTab, List list)
    {
        for(int i = 0; i < 16; ++i)
        	list.add(new ItemStack(id, 0, i));
    }
}
