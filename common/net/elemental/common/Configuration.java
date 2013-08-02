package net.elemental.common;

import net.minecraft.client.Minecraft;

public class Configuration 
{
	private static final File CONFIG_FILE = new File(Minecraft.getMinecraft().mcDataDir + "/config/WisdomOfTheElements.cfg");
	private static final Configuration CONFIG = new Configuration(CONFIG_FILE);
	
	public static void initConfigs()
	{
		
	}
}
