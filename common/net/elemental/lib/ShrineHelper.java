package net.elemental.lib;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class ShrineHelper 
{
	// Activator
	public static final int ACTIVATOR_ITEM_ID = Item.stick.itemID;
	public static final int ACTIVATOR_ITEM_META = 0;
	
	// Center block on which you use the activator to activate
	public static final int CENTER_BLOCK_ID = Block.blockDiamond.blockID;
	public static final int CENTER_BLOCK_META = 0;
	
	// Offset from the edge of the shrine
	public static final int CENTER_BLOCK_X_OFFSET = 1;
	public static final int CENTER_BLOCK_Y_OFFSET = 0;
	public static final int CENTER_BLOCK_Z_OFFSET = 1;
	
	// Blueprint of the shrine
	public static final int[][][] SHRINE_BLUEPRINT =
	{ // 0 = must be air, -1 = doesn't matter, -2 = center block
		{
			{
				2, 1, 2
			},
			{
				1, -2, 1
			},
			{
				2, 1, 2
			}
		}
	};
	
	// Shrine building blocks with meta
	public static final int[][] SHRINE_BUILDING_BLOCKS = 
	{
		{
			Block.blockClay.blockID, 0
		},
		{
			Block.blockGold.blockID, 0
		}
	};
	
	public static void buildShrine(World world, int x, int y, int z)
	{
		// Cause it will get called with the coords of the center block and we want the edge
		x -= CENTER_BLOCK_X_OFFSET;
		y -= CENTER_BLOCK_Y_OFFSET;
		z -= CENTER_BLOCK_Z_OFFSET;
		
		int i, j, k, tempX, tempY, tempZ, current;
		
		for (i = 0; i < SHRINE_BLUEPRINT.length; ++i)
		{
			for (j = 0; j < SHRINE_BLUEPRINT[i].length; ++j)
			{
                for (k = 0; k < SHRINE_BLUEPRINT[i][j].length; ++k)
                {
                	tempX = x + i;
                	tempY = y + j;
                	tempZ = z + k;
                	
                	current = SHRINE_BLUEPRINT[i][j][k];
                	
                	if (current == 0)
                		world.setBlockToAir(tempX, tempY, tempZ);
                	if (current == -1)
                		continue;
                	if (current == -2)
                		world.setBlock(tempX, tempY, tempZ, CENTER_BLOCK_ID, CENTER_BLOCK_META, 3);
                	else
                		world.setBlock(tempX, tempY, tempZ, SHRINE_BUILDING_BLOCKS[current - 1][0], SHRINE_BUILDING_BLOCKS[current - 1][1], 3);
                }
			}
		}
	}
	
	public static boolean checkShrineDone(World world, int x, int y, int z)
	{// Basicly same code but this one checks if the blocks are right
		// Cause it will get called with the coords of the center block and we want the edge
		x -= CENTER_BLOCK_X_OFFSET;
		y -= CENTER_BLOCK_Y_OFFSET;
		z -= CENTER_BLOCK_Z_OFFSET;
		
		int i, j, k, tempX, tempY, tempZ, current;
		
		for (i = 0; i < SHRINE_BLUEPRINT.length; ++i)
		{
			for (j = 0; j < SHRINE_BLUEPRINT[i].length; ++j)
			{
                for (k = 0; k < SHRINE_BLUEPRINT[i][j].length; ++k)
                {
                	tempX = x + i;
                	tempY = y + j;
                	tempZ = z + k;
                	
                	current = SHRINE_BLUEPRINT[i][j][k];
                	
                	if (current == 0 &&
                	   !world.isAirBlock(tempX, tempY, tempZ))
                		return false;
                	if (current == -1)
                		continue;
                	if (current == -2 &&
                	   (world.getBlockId(tempX, tempY, tempZ) != CENTER_BLOCK_ID ||
                	    world.getBlockMetadata(tempX, tempY, tempZ) != CENTER_BLOCK_META))
                		return false;
                	else if(world.getBlockId(tempX, tempY, tempZ) != SHRINE_BUILDING_BLOCKS[current - 1][0] ||
                			world.getBlockMetadata(tempX, tempY, tempZ) != SHRINE_BUILDING_BLOCKS[current - 1][1])
                		return false;
                }
			}
		}
		
		return true;
	}
	
	public static boolean checkBowls(World world, int x, int y, int z)
	{//TODO add this
		return true;
	}
	
	public static boolean canMakePortal(World world, int x, int y, int z)
	{//more checks planned
		return checkShrineDone(world, x, y, z) && checkBowls(world, x, y, z);
	}
}