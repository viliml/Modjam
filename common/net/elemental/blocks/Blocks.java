package net.elemental.blocks;

import net.elemental.lib.Reference;
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
	
	public static void initBlocks()
	{
		bowlBlock = (BlockBowl) new BlockBowl(4000).func_111022_d(BOWL_BLOCK_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(bowlBlock, BOWL_BLOCK_NAME);
		LanguageRegistry.addName(bowlBlock, BOWL_BLOCK_ACTUAL_NAME);
	}
}
