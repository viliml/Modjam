package net.elemental.biome;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;

public class Biomes 
{
	public static byte MAIN_FILLER_ID;
	
	public static int EARTH_BIOME_ID = 128;
	public static int AIR_BIOME_ID = 129;
	public static int FIRE_BIOME_ID = 130;
	public static int WATER_BIOME_ID = 131;
	
	public static BiomeGenBase earth_biome;
	public static BiomeGenBase air_biome;
	public static BiomeGenBase fire_biome;
	public static BiomeGenBase water_biome;
	
	public static void init()
	{
		MAIN_FILLER_ID =  (byte) Block.stone.blockID;
		
		// Initialize biomes
		initBiomes();
		
		//Biome Dictionary
		addToBiomeDictionary();

		//Village spawning
		addVillageBiomes();

		//Stronghold spawning
		addStrongholdBiomes();
	}

	private static void addStrongholdBiomes()
	{
		BiomeManager.addStrongholdBiome(earth_biome);
		BiomeManager.addStrongholdBiome(air_biome);
		BiomeManager.addStrongholdBiome(fire_biome);
		BiomeManager.addStrongholdBiome(water_biome);
	}

	private static void addVillageBiomes() 
	{
		BiomeManager.addVillageBiome(earth_biome, true);
		BiomeManager.addVillageBiome(air_biome, true);
		BiomeManager.addVillageBiome(fire_biome, true);
		BiomeManager.addVillageBiome(water_biome, true);
	}

	private static void addToBiomeDictionary()
	{
		BiomeDictionary.registerBiomeType(earth_biome, Type.MAGICAL);
		BiomeDictionary.registerBiomeType(air_biome, Type.MAGICAL);
		BiomeDictionary.registerBiomeType(fire_biome, Type.MAGICAL);
		BiomeDictionary.registerBiomeType(water_biome, Type.MAGICAL);
	}

	private static void initBiomes()
	{
		earth_biome = new EarthBiomeGen(EARTH_BIOME_ID);
		air_biome = new AirBiomeGen(AIR_BIOME_ID);
		fire_biome = new FireBiomeGen(FIRE_BIOME_ID);
		water_biome = new WaterBiomeGen(WATER_BIOME_ID);
	}
}
