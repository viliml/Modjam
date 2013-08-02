package net.elemental.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.Icon;

public class BlockElementalStone extends Block
{
	public BlockElementalStone(int id, Material material)
	{
		super(id, material);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta)
	{
		return this.blockIcon;
	}
	
	public int damageDropped(int meta)
	{
		return meta;
	}
}
