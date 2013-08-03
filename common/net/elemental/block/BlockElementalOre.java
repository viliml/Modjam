package net.elemental.block;

import java.util.List;

import net.elemental.lib.GeneralHelper;
import net.elemental.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockElementalOre extends Block {

	private Icon[] icons;
	private boolean second;

	public BlockElementalOre(int id, boolean isSecond) {
		super(id, Material.rock);
		setCreativeTab(CreativeTabs.tabBlock);
		second = isSecond;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void getSubBlocks(int id, CreativeTabs tab, List list)
	{
		for (int i = 0; i < 16; ++i)
			list.add(new ItemStack(id, 1, i));
	}

	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		icons = new Icon[16];
		int i, j;
		if (second)
			for (i = 0; i < 4; ++i)
				for (j = 0; j < 4; ++j)
					icons[i * 4 + j] = iconRegister.registerIcon(
						Reference.MOD_ID + ":" +
							GeneralHelper.ELEMENTS[j].toLowerCase() + "_" +
							GeneralHelper.ORES[i + 4].toLowerCase() + "_ore");
		else
			for (i = 0; i < 4; ++i)
				for (j = 0; j < 4; ++j)
					icons[i * 4 + j] = iconRegister.registerIcon(
						Reference.MOD_ID + ":" +
								GeneralHelper.ELEMENTS[j].toLowerCase() + "_" +
								GeneralHelper.ORES[i].toLowerCase() + "_ore");
		//Register the active redstone icons. Simpler than to make an if in getIcon()
		if (second)
			for (i = 0; i < 4; i++) icons[12 + i] = icons[i];
	}
	
	@Override
	public Icon getIcon(int side, int meta)
	{
		return icons[meta];
	}

	@SideOnly(Side.CLIENT)
	@Override
	public int getLightValue(IBlockAccess world, int x, int y, int z)
	{
		if (second && (world.getBlockMetadata(x, y, z) >> 3) == 3)
			return 15;
		return 0;
	}

	@Override
	public int damageDropped(int meta)
	{
		return meta;
	}
}
