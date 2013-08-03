package net.elemental.common;

import cpw.mods.fml.common.registry.GameRegistry;
import net.elemental.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;

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
		for (int i = 0; i < 4; ++i)
			GameRegistry.addShapedRecipe(new ItemStack(Blocks.elementalStoneBlock, 4, i + 8),
					"ss", "ss",
					's', new ItemStack(Blocks.elementalStoneBlock, 1, i));
	}

	private void initSmeltingRecipes()
	{
		int i;
		for (i = 0; i < 4; ++i)
			FurnaceRecipes.smelting().addSmelting(Blocks.elementalStoneBlock.blockID, i + 4,
					new ItemStack(Blocks.elementalStoneBlock, 1, i),
					0.1F);
		for (i = 0; i < 4; ++i)//
			GameRegistry.addSmelting(Block.oreCoal.blockID, new ItemStack(Blocks.elementalOreBlock1, 1, i), .1F);
		for (i = 0; i < 4; ++i)
			GameRegistry.addSmelting(Block.oreIron.blockID, new ItemStack(Blocks.elementalOreBlock1, 1, 4 + i));
		for (i = 0; i < 4; ++i)
			GameRegistry.addSmelting(Block.oreGold.blockID, new ItemStack(Blocks.elementalOreBlock1, 1, 8 + i));
		for (i = 0; i < 4; ++i)
			GameRegistry.addSmelting(Block.oreLapis.blockID, new ItemStack(Blocks.elementalOreBlock1, 1, 12 + i));
		for (i = 0; i < 4; ++i)
			GameRegistry.addSmelting(Block.oreRedstone.blockID, new ItemStack(Blocks.elementalOreBlock2, 1, i));
		for (i = 0; i < 4; ++i)
			GameRegistry.addSmelting(Block.oreEmerald.blockID, new ItemStack(Blocks.elementalOreBlock2, 1, 4 + i));
		for (i = 0; i < 4; ++i)
			GameRegistry.addSmelting(Block.oreDiamond.blockID, new ItemStack(Blocks.elementalOreBlock2, 1, 8 + i));
	}
}
