package net.elemental.itemblock;

import net.elemental.Elemental;
import net.elemental.block.Blocks;
import net.elemental.lib.GeneralHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;

public class ItemBlockElementalDoubleSlab extends ItemSlab {

	public ItemBlockElementalDoubleSlab(int id) {
		super(id, Blocks.elementalSingleSlabBlock, Blocks.elementalDoubleSlabBlock, false);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return Blocks.ELEMENTAL_SINGLE_SLAB_UNLOCALIZED_NAME + "_" +
				GeneralHelper.ELEMENTS[itemstack.getItemDamage() % 4] +
				(itemstack.getItemDamage() & 7);
	}

	@Override
	public CreativeTabs getCreativeTab()
	{
		return Elemental.creativeTabElemental;
	}
}
