package net.elemental.lib;

import java.util.Random;

public class GeneralHelper 
{
	public static final String[] ELEMENTS = 
	{
		"Earth",
		"Air",
		"Fire",
		"Water"
	};
	
	public static final String[] ORES =
	{
		"Coal",
		"Iron",
		"Gold",
		"Lapis",
		"Redstone",
		"Emerald",
		"Diamond",
		"Active Redstone"
	};
	
	public static double nextDouble(Random rand, double min, double max)
	{
		return min + rand.nextDouble() * (max - min);
	}
}
