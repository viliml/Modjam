package net.elemental.common;

import java.io.File;

import net.elemental.biome.Biomes;
import net.elemental.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.Configuration;

public class ElementalConfig 
{
	private static final File CONFIG_FILE =
			new File(Minecraft.getMinecraft().mcDataDir + "/config/WisdomOfTheElements.cfg");
	private static final Configuration CONFIG = new Configuration(CONFIG_FILE);

	public static void initConfigs()
	{
		CONFIG.load();

		Blocks.ELEMENTAL_STONE_BLOCK_ID =
				CONFIG.getBlock(Blocks.ELEMENTAL_STONE_NAME,
						Blocks.ELEMENTAL_STONE_BLOCK_ID)
				.getInt(Blocks.ELEMENTAL_STONE_BLOCK_ID);
		Blocks.BOWL_BLOCK_ID =
				CONFIG.getBlock(Blocks.BOWL_BLOCK_NAME,
						Blocks.BOWL_BLOCK_ID)
				.getInt(Blocks.BOWL_BLOCK_ID);
		Blocks.PORTAL_BLOCK_ID =
				CONFIG.getBlock(Blocks.PORTAL_BLOCK_NAME,
						Blocks.PORTAL_BLOCK_ID)
				.getInt(Blocks.PORTAL_BLOCK_ID);
		Blocks.ELEMENTAL_ORE_BLOCK1_ID =
				CONFIG.getBlock(Blocks.ELEMENTAL_ORE_NAME + "1",
						Blocks.ELEMENTAL_ORE_BLOCK1_ID)
				.getInt(Blocks.ELEMENTAL_ORE_BLOCK1_ID);
		Blocks.ELEMENTAL_ORE_BLOCK2_ID =
				CONFIG.getBlock(Blocks.ELEMENTAL_ORE_NAME + "2",
						Blocks.ELEMENTAL_ORE_BLOCK2_ID)
				.getInt(Blocks.ELEMENTAL_ORE_BLOCK2_ID);
		Blocks.ELEMENTAL_SLAB_BLOCK_ID =
				CONFIG.getBlock(Blocks.ELEMENTAL_SLAB_NAME,
						Blocks.ELEMENTAL_SLAB_BLOCK_ID)
				.getInt(Blocks.ELEMENTAL_SLAB_BLOCK_ID);
		Blocks.ELEMENTAL_WALL_BLOCK_ID =
				CONFIG.getBlock(Blocks.ELEMENTAL_WALL_NAME,
						Blocks.ELEMENTAL_WALL_BLOCK_ID)
				.getInt(Blocks.ELEMENTAL_WALL_BLOCK_ID);
		for (int i = 0; i < 4; ++i)
			Blocks.ELEMENTAL_STAIRS_BLOCK_IDS[0][i] =
			CONFIG.getBlock(Blocks.ELEMENTAL_STAIRS_NAME + i,
					Blocks.ELEMENTAL_STAIRS_BLOCK_IDS[0][i])
			.getInt(Blocks.ELEMENTAL_STAIRS_BLOCK_IDS[0][i]);
		for (int i = 0; i < 4; ++i)
			Blocks.ELEMENTAL_STAIRS_BLOCK_IDS[1][i] =
			CONFIG.getBlock(Blocks.ELEMENTAL_STAIRS_NAME + (4 + i),
					Blocks.ELEMENTAL_STAIRS_BLOCK_IDS[1][i])
			.getInt(Blocks.ELEMENTAL_STAIRS_BLOCK_IDS[1][i]);
		Blocks.ELEMENTAL_PRESSURE_PLATE_BLOCK_ID =
				CONFIG.getBlock(Blocks.ELEMENTAL_PRESSURE_PLATE_NAME,
						Blocks.ELEMENTAL_PRESSURE_PLATE_BLOCK_ID)
				.getInt(Blocks.ELEMENTAL_PRESSURE_PLATE_BLOCK_ID);

		Biomes.EARTH_BIOME_ID = CONFIG.get("Biomes", "Earth Biome",Biomes.EARTH_BIOME_ID)
				.getInt(Biomes.EARTH_BIOME_ID);
		Biomes.AIR_BIOME_ID = CONFIG.get("Biomes", "Air Biome", Biomes.AIR_BIOME_ID)
				.getInt(Biomes.AIR_BIOME_ID);
		Biomes.FIRE_BIOME_ID = CONFIG.get("Biomes", "Fire Biome", Biomes.FIRE_BIOME_ID)
				.getInt(Biomes.FIRE_BIOME_ID);
		Biomes.WATER_BIOME_ID = CONFIG.get("Biomes", "Water Biome", Biomes.WATER_BIOME_ID)
				.getInt(Biomes.WATER_BIOME_ID);

		if (CONFIG.hasChanged())
			CONFIG.save();
	}
}
