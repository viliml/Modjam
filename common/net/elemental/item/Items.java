package net.elemental.item;

import net.elemental.Elemental;
import net.elemental.lib.Reference;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Items 
{
	public static final String WING_NAME = "Wing";
	public static final String WING_UNLOCALIZED_NAME = Reference.MOD_ID + ":" + WING_NAME;
	public static final String WING_ACTUAL_NAME = "Wing";
	public static int WING_ITEM_ID = 10000; 
	public static Item itemWing;

	public static final String STAFF_NAME = "Staff";
	public static final String STAFF_UNLOCALIZED_NAME = Reference.MOD_ID + ":" + STAFF_NAME;
	public static final String STAFF_ACTUAL_NAME = "Aang's Staff";
	public static int STAFF_ITEM_ID = 10001;
	public static Item itemStaff;

	public static void initItems()
	{
		itemWing = new Item(WING_ITEM_ID)
		.setUnlocalizedName(WING_UNLOCALIZED_NAME)
		.setCreativeTab(Elemental.creativeTabElemental);
		LanguageRegistry.addName(itemWing, WING_ACTUAL_NAME);
		
		itemStaff = new Item(STAFF_ITEM_ID)
		.setUnlocalizedName(STAFF_UNLOCALIZED_NAME)
		.setCreativeTab(Elemental.creativeTabElemental);
		LanguageRegistry.addName(itemStaff, STAFF_ACTUAL_NAME);
	}
}
