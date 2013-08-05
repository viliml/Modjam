package net.elemental.block;

import net.elemental.itemblock.ItemBlockElementalOre1;
import net.elemental.itemblock.ItemBlockElementalOre2;
import net.elemental.itemblock.ItemBlockElementalPressurePlate;
import net.elemental.itemblock.ItemBlockElementalSlab;
import net.elemental.itemblock.ItemBlockElementalStone;
import net.elemental.itemblock.ItemBlockElementalWall;
import net.elemental.lib.GeneralHelper;
import net.elemental.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Blocks 
{
	public static Block/*Bowl*/ bowlBlock;
	public static int BOWL_BLOCK_ID = 4000;
	public static final String BOWL_BLOCK_NAME = "bowlBlock";
	public static final String BOWL_BLOCK_UNLOCALIZED_NAME = Reference.MOD_ID + ":" + BOWL_BLOCK_NAME;
	public static final String BOWL_BLOCK_ACTUAL_NAME = "Elemental Bowl Block";

	public static BlockElementalPortal portalBlock;
	public static int PORTAL_BLOCK_ID = 4001;
	public static final String PORTAL_BLOCK_NAME = "portalBlockElemental";
	public static final String PORTAL_BLOCK_UNLOCALIZED_NAME = Reference.MOD_ID + ":" + PORTAL_BLOCK_NAME;
	public static final String PORTAL_BLOCK_ACTUAL_NAME = "Elemental Portal Block";

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

	public static BlockElementalSlab elementalSlabBlock;
	public static int ELEMENTAL_SLAB_BLOCK_ID = 4005;
	public static final String ELEMENTAL_SLAB_NAME = "elementalSlabBlock";
	public static final String ELEMENTAL_SLAB_UNLOCALIZED_NAME = Reference.MOD_ID + ":" + ELEMENTAL_SLAB_NAME;

	public static BlockElementalWall elementalWallBlock;
	public static int ELEMENTAL_WALL_BLOCK_ID = 4006;
	public static final String ELEMENTAL_WALL_NAME = "elementalWallBlock";
	public static final String ELEMENTAL_WALL_UNLOCALIZED_NAME = Reference.MOD_ID + ":" + ELEMENTAL_WALL_NAME;

	public static BlockElementalStairs[][] elementalStairsBlocks;
	public static int[][] ELEMENTAL_STAIRS_BLOCK_IDS =
		{
		{
			4007, 4008, 4009, 4010
		},
		{
			4011, 4012, 4013, 4014
		}
		};
	public static final String ELEMENTAL_STAIRS_NAME = "elementalStairsBlock";
	public static final String ELEMENTAL_STAIRS_UNLOCALIZED_NAME = Reference.MOD_ID + ":" + ELEMENTAL_STAIRS_NAME;

	public static BlockElementalPressurePlate elementalPressurePlateBlock;
	public static int ELEMENTAL_PRESSURE_PLATE_BLOCK_ID = 4015;
	public static final String ELEMENTAL_PRESSURE_PLATE_NAME = "elementalPressurePlateBlock";
	public static final String ELEMENTAL_PRESSURE_PLATE_UNLOCALIZED_NAME = Reference.MOD_ID + ":" + ELEMENTAL_PRESSURE_PLATE_NAME;

	public static void initBlocks()
	{
		int i, j;

		/*bowlBlock = (BlockBowl) new BlockBowl(BOWL_BLOCK_ID)
		.setUnlocalizedName(BOWL_BLOCK_UNLOCALIZED_NAME)
		.func_111022_d(BOWL_BLOCK_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(bowlBlock, ItemBlockBowl.class, BOWL_BLOCK_NAME);
		for (int i = 0; i < GeneralHelper.ELEMENTS.length; ++i)
		LanguageRegistry.addName(new ItemStack(bowlBlock.blockID, 0, i), BOWL_BLOCK_ACTUAL_NAME + ": " + GeneralHelper.ELEMENTS[i]);*/

		bowlBlock = new BlockBowlNew(BOWL_BLOCK_ID)
		.setUnlocalizedName(BOWL_BLOCK_UNLOCALIZED_NAME)
		.func_111022_d(BOWL_BLOCK_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(bowlBlock, BOWL_BLOCK_NAME);
		LanguageRegistry.addName(bowlBlock, BOWL_BLOCK_ACTUAL_NAME);


		portalBlock = (BlockElementalPortal) new BlockElementalPortal(PORTAL_BLOCK_ID)
		.setUnlocalizedName(PORTAL_BLOCK_UNLOCALIZED_NAME)
		.func_111022_d(PORTAL_BLOCK_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(portalBlock, PORTAL_BLOCK_NAME);
		LanguageRegistry.addName(portalBlock, PORTAL_BLOCK_ACTUAL_NAME);

		elementalStoneBlock = new BlockElementalStone(ELEMENTAL_STONE_BLOCK_ID)
		.setUnlocalizedName(ELEMENTAL_STONE_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(elementalStoneBlock, ItemBlockElementalStone.class, ELEMENTAL_STONE_NAME);
		for (i = 0; i < 4; ++i)
			LanguageRegistry.addName(new ItemStack(elementalStoneBlock.blockID, 1, i),
					"Elemental Stone: " + GeneralHelper.ELEMENTS[i]);
		for (i = 0; i < 4; ++i)
			LanguageRegistry.addName(new ItemStack(elementalStoneBlock.blockID, 1, i + 4),
					"Elemental Cobblestone: " + GeneralHelper.ELEMENTS[i]);
		for (i = 0; i < 4; ++i)
			LanguageRegistry.addName(new ItemStack(elementalStoneBlock.blockID, 1, i + 8),
					"Elemental Stone Bricks: " + GeneralHelper.ELEMENTS[i]);
		for (i = 0; i < 4; ++i)
			LanguageRegistry.addName(new ItemStack(elementalStoneBlock.blockID, 1, i + 12),
					"Chiseled Elemental Stone Bricks: " + GeneralHelper.ELEMENTS[i]);

		elementalOreBlock1 = (BlockElementalOre) new BlockElementalOre(ELEMENTAL_ORE_BLOCK1_ID, false)
		.setUnlocalizedName(ELEMENTAL_ORE_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(elementalOreBlock1, ItemBlockElementalOre1.class, ELEMENTAL_ORE_NAME + 1);
		for (i = 0; i < 4; ++i) for (j = 0; j < 4; ++j)
			LanguageRegistry.addName(new ItemStack(elementalOreBlock1.blockID, 1, i * 4 + j),
					"Elemental " + GeneralHelper.ORES[i] + " Ore: " + GeneralHelper.ELEMENTS[j]);

		elementalOreBlock2 = (BlockElementalOre) new BlockElementalOre(ELEMENTAL_ORE_BLOCK2_ID, true)
		.setUnlocalizedName(ELEMENTAL_ORE_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(elementalOreBlock2, ItemBlockElementalOre2.class, ELEMENTAL_ORE_NAME + 2);
		for (i = 0; i < 4; ++i) for (j = 0; j < 4; ++j)
			LanguageRegistry.addName(new ItemStack(elementalOreBlock2.blockID, 1, i * 4 + j),
					"Elemental " + GeneralHelper.ORES[i + 4] + " Ore: " + GeneralHelper.ELEMENTS[j]);

		elementalSlabBlock = (BlockElementalSlab) new BlockElementalSlab(ELEMENTAL_SLAB_BLOCK_ID)
		.setUnlocalizedName(ELEMENTAL_SLAB_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(elementalSlabBlock, ItemBlockElementalSlab.class, ELEMENTAL_SLAB_NAME);
		for (i = 0; i < 4; ++i)
			LanguageRegistry.addName(new ItemStack(elementalSlabBlock.blockID, 1, i),
					"Elemental Cobblestone Slab: " + GeneralHelper.ELEMENTS[i]);
		for (i = 0; i < 4; ++i)
			LanguageRegistry.addName(new ItemStack(elementalSlabBlock.blockID, 1, i + 4),
					"Elemental Stone Bricks Slab: " + GeneralHelper.ELEMENTS[i]);

		elementalWallBlock = (BlockElementalWall) new BlockElementalWall(ELEMENTAL_WALL_BLOCK_ID)
		.setUnlocalizedName(ELEMENTAL_WALL_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(elementalWallBlock, ItemBlockElementalWall.class, ELEMENTAL_WALL_NAME);
		for (i = 0; i < 4; ++i)
			LanguageRegistry.addName(new ItemStack(elementalWallBlock.blockID, 1, i),
					"Elemental Cobblestone Wall: " + GeneralHelper.ELEMENTS[i]);

		elementalStairsBlocks = new BlockElementalStairs[2][4];
		for (i = 0; i < 4; i++)
		{
			elementalStairsBlocks[0][i] = (BlockElementalStairs)
					new BlockElementalStairs(ELEMENTAL_STAIRS_BLOCK_IDS[0][i], 4 + i)
			.setUnlocalizedName(ELEMENTAL_STAIRS_UNLOCALIZED_NAME + i);
			GameRegistry.registerBlock(elementalStairsBlocks[0][i], ELEMENTAL_STAIRS_NAME + i);
			LanguageRegistry.addName(elementalStairsBlocks[0][i],
					"Elemental Cobblestone Stairs: " + GeneralHelper.ELEMENTS[i]);
		}
		for (i = 0; i < 4; i++)
		{
			elementalStairsBlocks[1][i] = (BlockElementalStairs)
					new BlockElementalStairs(ELEMENTAL_STAIRS_BLOCK_IDS[1][i], 8 + i)
			.setUnlocalizedName(ELEMENTAL_STAIRS_UNLOCALIZED_NAME + (4 + i));
			GameRegistry.registerBlock(elementalStairsBlocks[1][i], ELEMENTAL_STAIRS_NAME + (4 + i));
			LanguageRegistry.addName(elementalStairsBlocks[1][i],
					"Elemental Stone Bricks Stairs: " + GeneralHelper.ELEMENTS[i]);
		}

		elementalPressurePlateBlock = (BlockElementalPressurePlate)
				new BlockElementalPressurePlate(ELEMENTAL_PRESSURE_PLATE_BLOCK_ID)
		.setUnlocalizedName(ELEMENTAL_PRESSURE_PLATE_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(elementalPressurePlateBlock, ItemBlockElementalPressurePlate.class, ELEMENTAL_PRESSURE_PLATE_NAME);
		for (i = 0; i < 4; ++i)
			LanguageRegistry.addName(new ItemStack(elementalPressurePlateBlock.blockID, 1, i),
					"Elemental Stone Pressure Plate: " + GeneralHelper.ELEMENTS[i]);

		registerBlockProperties();
	}

	private static void registerBlockProperties()
	{
		MinecraftForge.setBlockHarvestLevel(elementalStoneBlock, "pickaxe", 0);
		int i;
		for (i = 0; i < 4; ++i)
			MinecraftForge.setBlockHarvestLevel(elementalOreBlock1, i, "pickaxe", 1);
		for (i = 0; i < 4; ++i)
			MinecraftForge.setBlockHarvestLevel(elementalOreBlock1, 4 + i, "pickaxe", 1);
		for (i = 0; i < 4; ++i)
			MinecraftForge.setBlockHarvestLevel(elementalOreBlock1, 8 + i, "pickaxe", 2);
		for (i = 0; i < 4; ++i)
			MinecraftForge.setBlockHarvestLevel(elementalOreBlock1, 12 + i, "pickaxe", 1);
		for (i = 0; i < 4; ++i)
			MinecraftForge.setBlockHarvestLevel(elementalOreBlock2, i, "pickaxe", 2);
		for (i = 0; i < 4; ++i)
			MinecraftForge.setBlockHarvestLevel(elementalOreBlock2, 4 + i, "pickaxe", 2);
		for (i = 0; i < 4; ++i)
			MinecraftForge.setBlockHarvestLevel(elementalOreBlock2, 8 + i, "pickaxe", 2);
		for (i = 0; i < 4; ++i)
			MinecraftForge.setBlockHarvestLevel(elementalOreBlock2, 12 + i, "pickaxe", 2);
		for (i = 0; i < 4; ++i)
			OreDictionary.registerOre("oreCoal", new ItemStack(elementalOreBlock1, 1, i));
		for (i = 0; i < 4; ++i)
			OreDictionary.registerOre("oreIron", new ItemStack(elementalOreBlock1, 1, 4 + i));
		for (i = 0; i < 4; ++i)
			OreDictionary.registerOre("oreGold", new ItemStack(elementalOreBlock1, 1, 8 + i));
		for (i = 0; i < 4; ++i)
			OreDictionary.registerOre("oreLapis", new ItemStack(elementalOreBlock1, 1, 12 + i));
		for (i = 0; i < 4; ++i)
			OreDictionary.registerOre("oreRedstone", new ItemStack(elementalOreBlock2, 1, i));
		for (i = 0; i < 4; ++i)
			OreDictionary.registerOre("oreEmerald", new ItemStack(elementalOreBlock2, 1, 4 + i));
		for (i = 0; i < 4; ++i)
			OreDictionary.registerOre("oreDiamond", new ItemStack(elementalOreBlock2, 1, 8 + i));
	}
}
