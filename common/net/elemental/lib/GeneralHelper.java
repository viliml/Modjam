package net.elemental.lib;

import java.util.Random;

import net.minecraft.world.World;

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
	
	public static void spawnParticles(String particleName, World world, int x, int y, int z)
	{
		Random rand = new Random();
		
		for(int i = 0; i < rand.nextInt(20); ++i)
		{
			world.spawnParticle(particleName, x + rand.nextDouble(), y + rand.nextDouble(), z + rand.nextDouble(), rand.nextDouble(), rand.nextDouble(), rand.nextDouble());
		}
	}
}
