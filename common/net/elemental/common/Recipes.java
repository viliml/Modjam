package net.elemental.common;

import cpw.mods.fml.common.registry.GameRegistry;
import net.elemental.blocks.Blocks;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Recipes 
{
	public static void initRecipes()
	{
		initCraftingRecipes();
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
	}
}
