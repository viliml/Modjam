package net.elemental.itemblock;

import net.elemental.Elemental;
import net.elemental.block.Blocks;
import net.elemental.lib.GeneralHelper;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ItemBlockElementalOre2 extends ItemBlock
{
	public ItemBlockElementalOre2(int id)
	{
		super(id);
		hasSubtypes = true;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return Blocks.ELEMENTAL_ORE_UNLOCALIZED_NAME + "_" +
				GeneralHelper.ELEMENTS[itemstack.getItemDamage() % 4] +
				itemstack.getItemDamage() + 4;
	}

	@Override
	public CreativeTabs getCreativeTab()
	{
		return Elemental.creativeTabElemental;
	}

	@Override
	public int getMetadata(int meta)
	{
		return meta;
	}

	@Override
	public Icon getIconFromDamage(int meta)
	{
		return Block.blocksList[getBlockID()].getIcon(1, meta);
	}
}
