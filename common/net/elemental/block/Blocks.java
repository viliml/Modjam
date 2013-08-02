package net.elemental.block;

import net.elemental.itemblock.ItemBlockBowl;
import net.elemental.lib.GeneralHelper;
import net.elemental.lib.Reference;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Blocks 
{
	public static BlockBowl bowlBlock;
	public static int BOWL_BLOCK_ID;
	public static final int BOWL_BLOCK_DEFAULT_ID = 4000;
	public static final String BOWL_BLOCK_NAME = "bowlBlock";
	public static final String BOWL_BLOCK_UNLOCALIZED_NAME = Reference.MOD_ID + ":" + BOWL_BLOCK_NAME;
	public static final String BOWL_BLOCK_ACTUAL_NAME = "Elemental Bowl Block";
	
	public static BlockElementalPortal portalBlock;
	public static int PORTAL_BLOCK_ID;
	public static final int PORTAL_BLOCK_DEFAULT_ID = 4000;
	public static final String PORTAL_BLOCK_NAME = "bowlBlock";
	public static final String PORTAL_BLOCK_UNLOCALIZED_NAME = Reference.MOD_ID + ":" + BOWL_BLOCK_NAME;
	public static final String PORTAL_BLOCK_ACTUAL_NAME = "Elemental Bowl Block";
	
	public static void initBlocks()
	{
		bowlBlock = (BlockBowl) new BlockBowl(BOWL_BLOCK_ID)
			.setUnlocalizedName(BOWL_BLOCK_UNLOCALIZED_NAME)
			.func_111022_d(BOWL_BLOCK_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(bowlBlock, ItemBlockBowl.class, BOWL_BLOCK_NAME);
		for (int i = 0; i < GeneralHelper.ELEMENTS.length; ++i)
			LanguageRegistry.addName(new ItemStack(bowlBlock.blockID, 0, i),  BOWL_BLOCK_ACTUAL_NAME + ": " + GeneralHelper.ELEMENTS[i]);
		
		portalBlock = (BlockElementalPortal) new BlockElementalPortal(PORTAL_BLOCK_ID)
			.setUnlocalizedName(PORTAL_BLOCK_UNLOCALIZED_NAME)
			.func_111022_d(PORTAL_BLOCK_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(portalBlock, PORTAL_BLOCK_NAME);
		LanguageRegistry.addName(portalBlock, PORTAL_BLOCK_ACTUAL_NAME);
		
	}
}
