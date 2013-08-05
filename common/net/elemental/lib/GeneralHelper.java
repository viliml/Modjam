package net.elemental.lib;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
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
	
	public static final String[] PARTICLES = 
	{
		"dirt",
		"smoke",
		"flame",
		"dripWater"
	};
	
	public static void spawnParticles(String particleName, World world, int x, int y, int z)
	{
		if (!particleName.equals("dirt"))
		{
			Random rand = new Random();
			
			for(int i = 0; i < (rand.nextInt(20) + 6); ++i)
			{System.out.println(particleName + i);
				world.spawnParticle(particleName, x + rand.nextDouble(), y + rand.nextDouble(), z + rand.nextDouble(), 0F, 0F, 0F);
			}
		}
		else
			Minecraft.getMinecraft().effectRenderer.addBlockDestroyEffects(x, y, z, Block.dirt.blockID, 0);
	}
}
