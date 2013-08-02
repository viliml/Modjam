package net.elemental.dimension;

import java.util.Random;

import net.elemental.biome.AirBiomeGen;
import net.elemental.biome.BasicElementalBiomeGen;
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
		if (world.getBiomeGenForCoords(chunkX * 16, chunkZ * 16) instanceof BasicElementalBiomeGen)
			generateTutorial(world, random, chunkX * 16, chunkZ * 16);
	}

	private void generateTutorial(World world, Random random, int chunkX, int chunkZ)
	{
		// the 4 below is for how rare it will be
		for(int i = 0; i < 1; i++)
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