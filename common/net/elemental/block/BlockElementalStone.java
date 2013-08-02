package net.elemental.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.elemental.lib.GeneralHelper;
import net.elemental.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class BlockElementalStone extends Block
{
	private Icon[] icons;
	
	public BlockElementalStone(int id)
	{
		super(id, Material.rock);
		
		icons = new Icon[16];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta)
	{
		return icons[meta];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconregistry)
    {
		int temp = 0;
		
		for(int i = 0; i < 4; ++i, ++temp)
			icons[temp] = iconregistry.registerIcon(Reference.MOD_ID + ":" + "stone_" + GeneralHelper.ELEMENTS[i].toLowerCase());
		for(int i = 0; i < 4; ++i, ++temp)
			icons[temp] = iconregistry.registerIcon(Reference.MOD_ID + ":" + "cobblestone_" + GeneralHelper.ELEMENTS[i].toLowerCase());
		for(int i = 0; i < 4; ++i, ++temp)
			icons[temp] = iconregistry.registerIcon(Reference.MOD_ID + ":" + "stonebrick_" + GeneralHelper.ELEMENTS[i].toLowerCase());
		for(int i = 0; i < 4; ++i, ++temp)
			icons[temp] = iconregistry.registerIcon(Reference.MOD_ID + ":" + "stonebrick_carved_" + GeneralHelper.ELEMENTS[i].toLowerCase());
    }
	
	@Override
	public int damageDropped(int meta)
	{
		if(meta < 4)
			return meta + 4;
		
		return meta;
	}
	
	@Override
	public void getSubBlocks(int id, CreativeTabs creativeTab, List list)
    {
        for(int i = 0; i < 16; ++i)
        	list.add(new ItemStack(id, 0, i));
    }
}
