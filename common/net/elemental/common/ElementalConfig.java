package net.elemental.common;

import java.io.File;

import net.elemental.blocks.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.Configuration;

public class ElementalConfig 
{
	private static final File CONFIG_FILE = new File(Minecraft.getMinecraft().mcDataDir + "/config/WisdomOfTheElements.cfg");
	private static final Configuration CONFIG = new Configuration(CONFIG_FILE);
	
	public static void initConfigs()
	{
		CONFIG.load();
		
		Blocks.BOWL_BLOCK_ID = CONFIG.getBlock(Blocks.BOWL_BLOCK_NAME, Blocks.BOWL_BLOCK_DEFAULT_ID).getInt(Blocks.BOWL_BLOCK_DEFAULT_ID);
		
		if (CONFIG.hasChanged())
			CONFIG.save();
	}
}
