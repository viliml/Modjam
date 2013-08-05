package net.elemental.lib;

import net.elemental.block.Blocks;
import net.elemental.item.Items;
import net.minecraft.block.Block;
import net.minecraft.world.World;

public class ShrineHelper 
{
	// Activator
	public static final int ACTIVATOR_ITEM_ID = Items.itemStaff.itemID;
	public static final int ACTIVATOR_ITEM_META = 0;
	
	// Center block on which you use the activator to activate
	public static final int CENTER_BLOCK_ID = Block.blockDiamond.blockID;
	public static final int CENTER_BLOCK_META = 0;
	
	// Offset from the edge of the shrine
	public static final int CENTER_BLOCK_X_OFFSET = 18;
	public static final int CENTER_BLOCK_Y_OFFSET = 0;
	public static final int CENTER_BLOCK_Z_OFFSET = 18;
	
	// Blueprint of the shrine // 0 = must be air, -1 = doesn't matter, -2 = center block
	public static final int[][][] SHRINE_BLUEPRINT;
	
	public static final int[][][] SHRINE_BLUEPRINT_CORNER = 
	{
		{
			{
				1, 1
			},
			{
				2, 0
			}
		},
		{
			{
				1, 1
			},
			{
				0, 0
			}
		}
	};
	
	// Shrine building blocks with meta
	public static final int[][] SHRINE_BUILDING_BLOCKS = 
	{
		{//1
			Block.stoneBrick.blockID, 0
		},
		{//2
			Block.fence.blockID, 0
		},
		{//3
			Blocks.bowlBlock.blockID, 1
		},
		{//4
			Blocks.bowlBlock.blockID, 2
		},
		{//5
			Blocks.bowlBlock.blockID, 3
		},
		{//6
			Blocks.bowlBlock.blockID, 4
		},
		{//7
			Block.woodSingleSlab.blockID, 2
		},
		{//8
			Block.wood.blockID, 9
		},
		{//9
			//Cracked
			Block.stoneBrick.blockID, 2
		},
		{//10
			//Mossy
			Block.stoneBrick.blockID, 1
		},
		{//11
			//Smooth
			Block.sandStone.blockID, 2
		},
		{//12
			//Red
			Block.cloth.blockID, 1
		},
		{//13
			//White
			Block.cloth.blockID, 0
		},
		{//14
			Block.glowStone.blockID, 0
		},
		{//15
			Block.waterMoving.blockID, 15
		},
		{//16
			Block.torchRedstoneActive.blockID, 0
		},
		{//17
			//corner - top
			Block.stairsNetherBrick.blockID, 4
		},
		{//18
			//birch top
			Block.woodSingleSlab.blockID, 10
		},
		{//19
			//birch
			Block.woodDoubleSlab.blockID, 2
		},
		{
			//20
			//Spruce Facing -x
			Block.wood.blockID, 5
		},
		{
			//21
			//Spruce -y
			Block.wood.blockID, 1
		},
		{
			//22
			Block.stairsNetherBrick.blockID, 6
		},
		{
			//23
			//Spruce -z
			Block.wood.blockID, 9
		}
	};
	
	static
	{
		SHRINE_BLUEPRINT = new int[SHRINE_BLUEPRINT_CORNER.length * 2][SHRINE_BLUEPRINT_CORNER[0].length * 2][SHRINE_BLUEPRINT_CORNER[0][0].length * 2];
		
		int i, j, k;
		
		for(i = 0; i < SHRINE_BLUEPRINT_CORNER.length; ++i)
		{
			for(j = 0; j < SHRINE_BLUEPRINT_CORNER[0].length; ++j)
			{
				for(k = 0; k < SHRINE_BLUEPRINT_CORNER[0][0].length; ++k)
				{
					SHRINE_BLUEPRINT[i][j][k] = SHRINE_BLUEPRINT_CORNER[i][j][k];
				}
			}
		}
		
		for(i = 0; i < SHRINE_BLUEPRINT_CORNER.length; ++i)
		{
			for(j = 0; j < SHRINE_BLUEPRINT_CORNER[0].length; ++j)
			{
				for(k = 0; k < SHRINE_BLUEPRINT_CORNER[0][0].length; ++k)
				{
					SHRINE_BLUEPRINT[SHRINE_BLUEPRINT_CORNER.length + i][j][k] =
							SHRINE_BLUEPRINT_CORNER[SHRINE_BLUEPRINT_CORNER.length - 1 - i][j][k];
				}
			}
		}
		
		for(i = 0; i < SHRINE_BLUEPRINT_CORNER.length; ++i)
		{
			for(j = 0; j < SHRINE_BLUEPRINT_CORNER[0].length; ++j)
			{
				for(k = 0; k < SHRINE_BLUEPRINT_CORNER[0][0].length; ++k)
				{
					SHRINE_BLUEPRINT[i][j][SHRINE_BLUEPRINT[0][0].length - 1 - k] = SHRINE_BLUEPRINT_CORNER[i][j][k];
				}
			}
		}
		
		for(i = 0; i < SHRINE_BLUEPRINT_CORNER.length; ++i)
		{
			for(j = 0; j < SHRINE_BLUEPRINT_CORNER[0].length; ++j)
			{
				for(k = 0; k < SHRINE_BLUEPRINT_CORNER[0][0].length; ++k)
				{
					SHRINE_BLUEPRINT[SHRINE_BLUEPRINT_CORNER.length + i][j][SHRINE_BLUEPRINT_CORNER[0][0].length + k] =
							SHRINE_BLUEPRINT_CORNER[SHRINE_BLUEPRINT_CORNER.length - 1 - i][j][SHRINE_BLUEPRINT_CORNER[0][0].length - 1 - k];
				}
			}
		}
	}
	
	public static boolean buildNextBlock(World world, int x, int y, int z, String particleName)
	{
		if (checkShrineDone(world, x, y, z))
			return false;
		
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
					{
						if (!world.isAirBlock(tempX, tempY, tempZ))
						{
							world.setBlockToAir(tempX, tempY, tempZ);
							GeneralHelper.spawnParticles(particleName, world, tempX, tempY, tempZ);
							return true;
						}
					}
					else if (current == -1)
						continue;
					else if (current == -2)
					{
						if (!(world.getBlockId(tempX, tempY, tempZ) == CENTER_BLOCK_ID &&
							 world.getBlockMetadata(tempX, tempY, tempZ) == CENTER_BLOCK_META))
						{
							world.setBlock(tempX, tempY, tempZ, CENTER_BLOCK_ID, CENTER_BLOCK_META, 3);
							GeneralHelper.spawnParticles(particleName, world, tempX, tempY, tempZ);
							return true;
						}
					}
					else
					{
						if (!(world.getBlockId(tempX, tempY, tempZ) == SHRINE_BUILDING_BLOCKS[current - 1][0] &&
							 world.getBlockMetadata(tempX, tempY, tempZ) == SHRINE_BUILDING_BLOCKS[current - 1][1]))
						{
							world.setBlock(tempX, tempY, tempZ, SHRINE_BUILDING_BLOCKS[current - 1][0], SHRINE_BUILDING_BLOCKS[current - 1][1], 3);
							GeneralHelper.spawnParticles(particleName, world, tempX, tempY, tempZ);
							return true;
						}
					}
				}
			}
		}
		
		return false;
	}
	
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
					{
						world.setBlockToAir(tempX, tempY, tempZ);
						continue;
					}
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
					else if (current == 0)
						continue;
					else if (current == -1)
						continue;
					else if (current == -2 &&
					   (world.getBlockId(tempX, tempY, tempZ) != CENTER_BLOCK_ID ||
					world.getBlockMetadata(tempX, tempY, tempZ) != CENTER_BLOCK_META))
						return false;
					else if (current == -2)
						continue;
					else if (world.getBlockId(tempX, tempY, tempZ) != SHRINE_BUILDING_BLOCKS[current - 1][0] ||
						world.getBlockMetadata(tempX, tempY, tempZ) != SHRINE_BUILDING_BLOCKS[current - 1][1])
						return false;
				}
			}
		}
		
		return true;
	}
	
	public static boolean canMakePortal(World world, int x, int y, int z)
	{//more checks planned
		return !world.isRemote && checkShrineDone(world, x, y, z);
	}
}
