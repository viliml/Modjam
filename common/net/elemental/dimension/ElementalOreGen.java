package net.elemental.dimension;

import java.util.Random;

import net.elemental.biome.AirBiomeGen;
import net.elemental.biome.FireBiomeGen;
import net.elemental.biome.WaterBiomeGen;
import net.elemental.block.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;


public class ElementalOreGen implements IWorldGenerator
{
	/** Methods For Ore Generation **/
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		/** switchs between dimension's**/
		// the case number must match the dimension id !!!!!!!!!!! i dont no y ? it just does lol
		switch(world.provider.dimensionId)
		{
		case 0 :
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
		case 1:
			generateNether(world, random, chunkX * 16, chunkZ * 16, chunkProvider, chunkX, chunkZ);
		case -1 :
			generateEnd(world, random, chunkX * 16, chunkZ * 16);
		case 5 :
			generateTutorial(world, random, chunkX * 16, chunkZ * 16);
		}
	}

	/** Generate's the Ore's In Surface World **/
	private void generateSurface(World world, Random random, int chunkX, int chunkZ)
	{
		// the 4 below is for how rare it will be
		
	}

	/** Generates Ore's In Nether **/
	private void generateNether(World world, Random random, int chunkX, int chunkZ, IChunkProvider par1IChunkProvider, int par2, int par3)
	{
		
	}

	/** Generates Ore's in TheEnd **/
	private void generateEnd(World world, Random random, int chunkX, int chunkZ)
	{
		
	}

	private void generateTutorial(World world, Random random, int chunkX, int chunkZ)
	{
		// the 4 below is for how rare it will be
		for(int i = 0; i < 10; i++)
		{
			//this below just tells me if its generating or not
			System.out.println("Generating Leaf in the dimension");

			int xCoord = chunkX + random.nextInt(16);
			int yCoord = random.nextInt(128);// the 128 is the max height the ore/block will generate
			int zCoord = chunkZ + random.nextInt(16);

			if (world.getBiomeGenForCoords(xCoord, zCoord) instanceof AirBiomeGen)
			(new WorldGenMinableElemental(
					Blocks.elementalStoneBlock.blockID,
					1, 16*16*128,
					Blocks.elementalStoneBlock.blockID))
					.generate(world, random, xCoord, yCoord, zCoord);
			if (world.getBiomeGenForCoords(xCoord, zCoord) instanceof FireBiomeGen)
			(new WorldGenMinableElemental(
					Blocks.elementalStoneBlock.blockID,
					2, 16*16*128,
					Blocks.elementalStoneBlock.blockID))
					.generate(world, random, xCoord, yCoord, zCoord);
			if (world.getBiomeGenForCoords(xCoord, zCoord) instanceof WaterBiomeGen)
			(new WorldGenMinableElemental(
					Blocks.elementalStoneBlock.blockID,
					3, 16*16*128,
					Blocks.elementalStoneBlock.blockID))
					.generate(world, random, xCoord, yCoord, zCoord);
		}
	}
}