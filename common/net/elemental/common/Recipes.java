package net.elemental.common;

import net.elemental.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes 
{
	public static void initRecipes()
	{
		initCraftingRecipes();
		initSmeltingRecipes();
	}

	private static void initCraftingRecipes()
	{
		//Earth
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.bowlBlock, 1, 0),
				" D ", "SBS", " D ",
				'B', Item.bowlEmpty,
				'D', Block.dirt,
				'S', Block.sand);
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.bowlBlock, 1, 0),
				" S ", "DBD", " S ",
				'B', Item.bowlEmpty,
				'D', Block.dirt,
				'S', Block.sand);
		//Air
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.bowlBlock, 1, 1),
				"   ", " B ", "   ",
				'B', Item.bowlEmpty);
		//Fire
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.bowlBlock, 1, 2),
				" S ", "CBC", " S ",
				'B', Item.bowlEmpty,
				'S', Item.flintAndSteel,
				'C', Item.fireballCharge);
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.bowlBlock, 1, 2),
				" C ", "SBS", " C ",
				'B', Item.bowlEmpty,
				'S', Item.flintAndSteel,
				'C', Item.fireballCharge);
		//Water
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.bowlBlock, 1, 3),
				" W ", "IBI", " W ",
				'B', Item.bowlEmpty,
				'W', Item.bucketWater,
				'I', Block.ice);
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.bowlBlock, 1, 3),
				" I ", "WBW", " I ",
				'B', Item.bowlEmpty,
				'W', Item.bucketWater,
				'I', Block.ice);
		int i;
		for (i = 0; i < 4; ++i)
			GameRegistry.addShapedRecipe(new ItemStack(Blocks.elementalStoneBlock, 4, 8 + i),
					"ss", "ss",
					's', new ItemStack(Blocks.elementalStoneBlock, 1, i));
		for (i = 0; i < 4; ++i)
		{
			GameRegistry.addShapedRecipe(new ItemStack(Blocks.elementalSlabBlock, 6, i),
					"sss",
					's', new ItemStack(Blocks.elementalStoneBlock, 1, 4 + i));
			GameRegistry.addShapedRecipe(new ItemStack(Blocks.elementalSlabBlock, 6, 4 + i),
					"sss",
					's', new ItemStack(Blocks.elementalStoneBlock, 1, 8 + i));
		}
		for (i = 0; i < 4; ++i)
			GameRegistry.addShapedRecipe(new ItemStack(Blocks.elementalWallBlock, 6, i),
					"sss", "sss",
					's', new ItemStack(Blocks.elementalStoneBlock, 1, 4 + i));
		
	}

	private static void initSmeltingRecipes()
	{
		int i;
		for (i = 0; i < 4; ++i)
			FurnaceRecipes.smelting().addSmelting(Blocks.elementalStoneBlock.blockID, i + 4,
					new ItemStack(Blocks.elementalStoneBlock, 1, i),
					0.1F);
		for (i = 0; i < 4; ++i)
			FurnaceRecipes.smelting().addSmelting(Blocks.elementalOreBlock1.blockID, i, new ItemStack(Block.oreCoal), .1F);
		for (i = 0; i < 4; ++i)
			FurnaceRecipes.smelting().addSmelting(Blocks.elementalOreBlock1.blockID, 4 + i, new ItemStack(Block.oreIron), .7F);
		for (i = 0; i < 4; ++i)
			FurnaceRecipes.smelting().addSmelting(Blocks.elementalOreBlock1.blockID, 8 + i, new ItemStack(Block.oreGold), 1F);
		for (i = 0; i < 4; ++i)
			FurnaceRecipes.smelting().addSmelting(Blocks.elementalOreBlock1.blockID, 12 + i, new ItemStack(Block.oreLapis), .2F);
		for (i = 0; i < 4; ++i)
			FurnaceRecipes.smelting().addSmelting(Blocks.elementalOreBlock2.blockID, i, new ItemStack(Block.oreRedstone), .7F);
		for (i = 0; i < 4; ++i)
			FurnaceRecipes.smelting().addSmelting(Blocks.elementalOreBlock2.blockID, 4 + i, new ItemStack(Block.oreEmerald), 1F);
		for (i = 0; i < 4; ++i)
			FurnaceRecipes.smelting().addSmelting(Blocks.elementalOreBlock2.blockID, 8 + i, new ItemStack(Block.oreDiamond), 1F);
	}
}
