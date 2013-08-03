package net.elemental.itemblock;

import java.util.List;

import net.elemental.block.Blocks;
import net.elemental.lib.GeneralHelper;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

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
<<<<<<< HEAD
		return Blocks.ELEMENTAL_STONE_UNLOCALIZED_NAME + "_" + GeneralHelper.ELEMENTS[itemstack.getItemDamage() % 4] + itemstack.getItemDamage();
=======
		return Blocks.ELEMENTAL_STONE_UNLOCALIZED_NAME + "_" + GeneralHelper.ELEMENTS[itemstack.getItemDamage() % 4];
>>>>>>> 4852e48dc3f783573ccadf8358b8f291e4da0ed8
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

	@Override
	public Icon getIconFromDamage(int meta)
	{
		return Block.blocksList[getBlockID()].getIcon(1, meta);
	}
<<<<<<< HEAD
	
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getSubItems(int par1, CreativeTabs creativeTab, List list)
	{
		for(int i = 0; i < 16; ++i)
		{
			list.add(new ItemStack(getBlockID(), 0, i));
		}
	}
=======
>>>>>>> 4852e48dc3f783573ccadf8358b8f291e4da0ed8
}
