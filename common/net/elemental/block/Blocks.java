package net.elemental.block;

import net.elemental.itemblock.ItemBlockBowl;
import net.elemental.itemblock.ItemBlockElementalStone;
import net.elemental.lib.GeneralHelper;
import net.elemental.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Blocks 
{
	public static BlockBowl bowlBlock;
	public static int BOWL_BLOCK_ID = 4000;
	public static final String BOWL_BLOCK_NAME = "bowlBlock";
	public static final String BOWL_BLOCK_UNLOCALIZED_NAME = Reference.MOD_ID + ":" + BOWL_BLOCK_NAME;
	public static final String BOWL_BLOCK_ACTUAL_NAME = "Elemental Bowl Block";

	public static BlockElementalPortal portalBlock;
	public static int PORTAL_BLOCK_ID = 4001;
	public static final String PORTAL_BLOCK_NAME = "portalBlockElemental";
	public static final String PORTAL_BLOCK_UNLOCALIZED_NAME = Reference.MOD_ID + ":" + PORTAL_BLOCK_NAME;
	public static final String PORTAL_BLOCK_ACTUAL_NAME = "Portal Block";

	public static Block elementalStoneBlock;
	public static int ELEMENTAL_STONE_BLOCK_ID = 4002;
	public static final String ELEMENTAL_STONE_NAME = "elementalStoneBlock";
	public static final String ELEMENTAL_STONE_UNLOCALIZED_NAME = Reference.MOD_ID + ":" + ELEMENTAL_STONE_NAME;

	public static BlockElementalOre elementalOreBlock1;
	public static int ELEMENTAL_ORE_BLOCK1_ID = 4003;
	public static BlockElementalOre elementalOreBlock2;
	public static int ELEMENTAL_ORE_BLOCK2_ID = 4004;
	public static final String ELEMENTAL_ORE_NAME = "oreBlockElemental";
	public static final String ELEMENTAL_ORE_UNLOCALIZED_NAME = Reference.MOD_ID + ":" + PORTAL_BLOCK_NAME;

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

		elementalStoneBlock = new BlockElementalStone(ELEMENTAL_STONE_BLOCK_ID)
		.setUnlocalizedName(ELEMENTAL_STONE_UNLOCALIZED_NAME)
		.func_111022_d(ELEMENTAL_STONE_UNLOCALIZED_NAME)
		.setHardness(1.5F)
		.setResistance(10.0F);
		GameRegistry.registerBlock(elementalStoneBlock, ItemBlockElementalStone.class, ELEMENTAL_STONE_NAME);
		for (int i = 0; i < 4; ++i)
			LanguageRegistry.addName(new ItemStack(elementalStoneBlock.blockID, 0, i),
					"Elemental Stone: " + GeneralHelper.ELEMENTS[i]);
		for (int i = 0; i < 4; ++i)
			LanguageRegistry.addName(new ItemStack(elementalStoneBlock.blockID, 0, i + 4),
					"Elemental Cobblestone: " + GeneralHelper.ELEMENTS[i]);
		for (int i = 0; i < 4; ++i)
			LanguageRegistry.addName(new ItemStack(elementalStoneBlock.blockID, 0, i + 8),
					"Elemental Stone Brick: " + GeneralHelper.ELEMENTS[i]);
		for (int i = 0; i < 4; ++i)
			LanguageRegistry.addName(new ItemStack(elementalStoneBlock.blockID, 0, i + 12),
					"Chiseled Elemental Stone Brick: " + GeneralHelper.ELEMENTS[i]);

		elementalOreBlock1 = (BlockElementalOre) new BlockElementalOre(ELEMENTAL_ORE_BLOCK1_ID)
		.setUnlocalizedName(ELEMENTAL_ORE_UNLOCALIZED_NAME)
		.func_111022_d(ELEMENTAL_ORE_UNLOCALIZED_NAME)
		.setHardness(1.5F)
		.setResistance(10.0F);
		GameRegistry.registerBlock(elementalOreBlock1, ELEMENTAL_ORE_NAME + 1);
		int i, j;
		for (i = 0; i < 4; ++i) for (j = 0; j < 4; ++j)
			LanguageRegistry.addName(new ItemStack(elementalOreBlock1.blockID, 0, i * 4 + j),
				"Elemental " + GeneralHelper.ORES[i] + " Ore: " + GeneralHelper.ELEMENTS[j]);
		
		elementalOreBlock2 = (BlockElementalOre) new BlockElementalOre(ELEMENTAL_ORE_BLOCK2_ID)
		.setUnlocalizedName(ELEMENTAL_ORE_UNLOCALIZED_NAME)
		.func_111022_d(ELEMENTAL_ORE_UNLOCALIZED_NAME)
		.setHardness(1.5F)
		.setResistance(10.0F);
		GameRegistry.registerBlock(elementalOreBlock2, ELEMENTAL_ORE_NAME + 2);
		for (i = 0; i < 4; ++i) for (j = 0; j < 4; ++j)
			LanguageRegistry.addName(new ItemStack(elementalOreBlock2.blockID, 0, i * 4 + j),
				"Elemental " + GeneralHelper.ORES[i + 4] + " Ore: " + GeneralHelper.ELEMENTS[j]);
	}
}
