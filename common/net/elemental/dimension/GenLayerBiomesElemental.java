package net.elemental.dimension;

import net.elemental.biome.Biomes;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerBiomesElemental extends GenLayer {

	protected BiomeGenBase[] allowedBiomes =
		{
			Biomes.earth_biome,
			Biomes.air_biome,
			Biomes.fire_biome,
			Biomes.water_biome,
			};

	public GenLayerBiomesElemental(long seed, GenLayer genlayer) {
		super(seed);
		parent = genlayer;
	}

	public GenLayerBiomesElemental(long seed) {
		super(seed);
	}

	@Override
	public int[] getInts(int x, int z, int width, int depth)
	{
		int[] dest = IntCache.getIntCache(width*depth);

		for (int dz=0; dz<depth; dz++)
		{
			for (int dx=0; dx<width; dx++)
			{
				initChunkSeed(dx+x, dz+z);
				dest[(dx+dz*width)] = allowedBiomes[nextInt(allowedBiomes.length)].biomeID;
			}
		}
		return dest;
	}
}