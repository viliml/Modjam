package net.elemental.itemblock;

import net.elemental.block.Blocks;
import net.elemental.lib.GeneralHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockElementalStone extends ItemBlock
{
	public ItemBlockElementalStone(int id)
	{
		super(id);
		hasSubtypes = true;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return Blocks.BOWL_BLOCK_UNLOCALIZED_NAME + ":" + GeneralHelper.ELEMENTS[itemstack.getItemDamage()];
	}
	
	@Override
	public CreativeTabs getCreativeTab()
	{
		return CreativeTabs.tabBlock;
	}
	
	@Override
	public int getMetadata(int meta)
    {
        return meta;
    }
}
