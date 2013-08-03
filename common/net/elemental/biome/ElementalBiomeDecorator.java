package net.elemental.biome;

import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.*;
import net.elemental.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

public class ElementalBiomeDecorator extends BiomeDecorator {

	EnumBiomes enumBiome;

	public ElementalBiomeDecorator(BiomeGenBase theBiome) {
		super(theBiome);
		enumBiome = ((BasicElementalBiomeGen) theBiome).getBiome();
		//TODO make 'em elemental
		sandGen = new WorldGenSand(7, Block.sand.blockID);
		gravelAsSandGen = new WorldGenSand(6, Block.gravel.blockID);
		dirtGen = new WorldGenMinable(Block.dirt.blockID, 32);
		gravelGen = new WorldGenMinable(Block.gravel.blockID, 32);
		coalGen = new WorldGenMinable(Block.oreCoal.blockID, 16);
		ironGen = new WorldGenMinable(Block.oreIron.blockID, 8);
		goldGen = new WorldGenMinable(Block.oreGold.blockID, 8);
		redstoneGen = new WorldGenMinable(Block.oreRedstone.blockID, 7);
		diamondGen = new WorldGenMinable(Block.oreDiamond.blockID, 7);
		lapisGen = new WorldGenMinable(Block.oreLapis.blockID, 6);
		plantYellowGen = new WorldGenFlowers(Block.plantYellow.blockID);
		plantRedGen = new WorldGenFlowers(Block.plantRed.blockID);
		mushroomBrownGen = new WorldGenFlowers(Block.mushroomBrown.blockID);
		mushroomRedGen = new WorldGenFlowers(Block.mushroomRed.blockID);
		bigMushroomGen = new WorldGenBigMushroom();
		reedGen = new WorldGenReed();
		cactusGen = new WorldGenCactus();
		waterlilyGen = new WorldGenWaterlily();
	}

	@Override
	protected void decorate()
	{
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(currentWorld, randomGenerator, chunk_X, chunk_Z));

		generateOres();
		changeStone();
		int i;
		int j;
		int k;

		boolean doGen = TerrainGen.decorate(currentWorld, randomGenerator, chunk_X, chunk_Z, SAND);
		for (i = 0; doGen && i < sandPerChunk2; ++i)
		{
			j = chunk_X + randomGenerator.nextInt(16) + 8;
			k = chunk_Z + randomGenerator.nextInt(16) + 8;
			sandGen.generate(currentWorld, randomGenerator, j, currentWorld.getTopSolidOrLiquidBlock(j, k), k);
		}

		doGen = TerrainGen.decorate(currentWorld, randomGenerator, chunk_X, chunk_Z, CLAY);
		for (i = 0; doGen && i < clayPerChunk; ++i)
		{
			j = chunk_X + randomGenerator.nextInt(16) + 8;
			k = chunk_Z + randomGenerator.nextInt(16) + 8;
			clayGen.generate(currentWorld, randomGenerator, j, currentWorld.getTopSolidOrLiquidBlock(j, k), k);
		}

		doGen = TerrainGen.decorate(currentWorld, randomGenerator, chunk_X, chunk_Z, SAND_PASS2);
		for (i = 0; doGen && i < sandPerChunk; ++i)
		{
			j = chunk_X + randomGenerator.nextInt(16) + 8;
			k = chunk_Z + randomGenerator.nextInt(16) + 8;
			sandGen.generate(currentWorld, randomGenerator, j, currentWorld.getTopSolidOrLiquidBlock(j, k), k);
		}

		i = treesPerChunk;

		if (randomGenerator.nextInt(10) == 0)
		{
			++i;
		}

		int l;

		doGen = TerrainGen.decorate(currentWorld, randomGenerator, chunk_X, chunk_Z, TREE);
		for (j = 0; doGen && j < i; ++j)
		{
			k = chunk_X + randomGenerator.nextInt(16) + 8;
			l = chunk_Z + randomGenerator.nextInt(16) + 8;
			WorldGenerator worldgenerator = biome.getRandomWorldGenForTrees(randomGenerator);
			worldgenerator.setScale(1.0D, 1.0D, 1.0D);
			worldgenerator.generate(currentWorld, randomGenerator, k, currentWorld.getHeightValue(k, l), l);
		}

		int i1;

		doGen = TerrainGen.decorate(currentWorld, randomGenerator, chunk_X, chunk_Z, FLOWERS);
		for (j = 0; doGen && j < flowersPerChunk; ++j)
		{
			k = chunk_X + randomGenerator.nextInt(16) + 8;
			l = randomGenerator.nextInt(128);
			i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
			plantYellowGen.generate(currentWorld, randomGenerator, k, l, i1);

			if (randomGenerator.nextInt(4) == 0)
			{
				k = chunk_X + randomGenerator.nextInt(16) + 8;
				l = randomGenerator.nextInt(128);
				i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
				plantRedGen.generate(currentWorld, randomGenerator, k, l, i1);
			}
		}

		doGen = TerrainGen.decorate(currentWorld, randomGenerator, chunk_X, chunk_Z, GRASS);
		for (j = 0; doGen && j < grassPerChunk; ++j)
		{
			k = chunk_X + randomGenerator.nextInt(16) + 8;
			l = randomGenerator.nextInt(128);
			i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
			WorldGenerator worldgenerator1 = biome.getRandomWorldGenForGrass(randomGenerator);
			worldgenerator1.generate(currentWorld, randomGenerator, k, l, i1);
		}

		doGen = TerrainGen.decorate(currentWorld, randomGenerator, chunk_X, chunk_Z, LILYPAD);
		for (j = 0; doGen && j < waterlilyPerChunk; ++j)
		{
			k = chunk_X + randomGenerator.nextInt(16) + 8;
			l = chunk_Z + randomGenerator.nextInt(16) + 8;

			for (i1 = randomGenerator.nextInt(128); i1 > 0 && currentWorld.getBlockId(k, i1 - 1, l) == 0; --i1)
			{
				;
			}

			waterlilyGen.generate(currentWorld, randomGenerator, k, i1, l);
		}

		doGen = TerrainGen.decorate(currentWorld, randomGenerator, chunk_X, chunk_Z, REED);
		for (j = 0; doGen && j < reedsPerChunk; ++j)
		{
			k = chunk_X + randomGenerator.nextInt(16) + 8;
			l = chunk_Z + randomGenerator.nextInt(16) + 8;
			i1 = randomGenerator.nextInt(128);
			reedGen.generate(currentWorld, randomGenerator, k, i1, l);
		}

		for (j = 0; doGen && j < 10; ++j)
		{
			k = chunk_X + randomGenerator.nextInt(16) + 8;
			l = randomGenerator.nextInt(128);
			i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
			reedGen.generate(currentWorld, randomGenerator, k, l, i1);
		}

		doGen = TerrainGen.decorate(currentWorld, randomGenerator, chunk_X, chunk_Z, PUMPKIN);
		if (doGen && randomGenerator.nextInt(32) == 0)
		{
			j = chunk_X + randomGenerator.nextInt(16) + 8;
			k = randomGenerator.nextInt(128);
			l = chunk_Z + randomGenerator.nextInt(16) + 8;
			(new WorldGenPumpkin()).generate(currentWorld, randomGenerator, j, k, l);
		}

		doGen = TerrainGen.decorate(currentWorld, randomGenerator, chunk_X, chunk_Z, LAKE);
		if (doGen && generateLakes)
		{
			for (j = 0; j < 70; ++j)
			{
				k = chunk_X + randomGenerator.nextInt(16) + 8;
				l = randomGenerator.nextInt(randomGenerator.nextInt(120) + 8);
				i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
				(new WorldGenLiquids(enumBiome.LIQUID_BLOCK)).generate(currentWorld, randomGenerator, k, l, i1);
			}
		}

		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(currentWorld, randomGenerator, chunk_X, chunk_Z));
	}

	protected void changeStone()
	{
		int i, j, k;
		for (i = chunk_X; i < chunk_X + 16; ++i)
			for (k = chunk_Z; k < chunk_Z + 16; ++k)
			{
				if (currentWorld.getBiomeGenForCoords(i, k).biomeID != biome.biomeID)
					continue;
				for (j = 0; j < 256; ++j)
					if (currentWorld.getBlockId(i, j, k) == Block.stone.blockID)
					{
						currentWorld.setBlock(i, j, k,
								Blocks.elementalStoneBlock.blockID, enumBiome.ordinal(), 2);
					}
			}
	}
}
