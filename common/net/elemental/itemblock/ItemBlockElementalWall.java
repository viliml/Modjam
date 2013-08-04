package net.elemental.itemblock;

import net.elemental.lib.GeneralHelper;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockElementalWall extends ItemBlock {

	public ItemBlockElementalWall(int id) {
		super(id);
		hasSubtypes = true;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return super.getUnlocalizedName() + "_" + GeneralHelper.ELEMENTS[itemstack.getItemDamage() % 4];
	}

	@Override
	public int getMetadata(int meta)
	{
		return meta;
	}

}
