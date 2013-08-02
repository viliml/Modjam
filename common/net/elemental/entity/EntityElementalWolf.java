package net.elemental.entity;

import net.elemental.biome.EnumBiomes;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.World;

public class EntityElementalWolf extends EntityWolf
{
	private EnumBiomes biome;

	public EntityElementalWolf(World par1World, EnumBiomes theBiome)
	{
		super(par1World);
		biome = theBiome;
	}

	public EnumBiomes getBiome()
	{
		return biome;
	}
}