package net.elemental.entity;

import net.elemental.biome.EnumBiomes;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.world.World;

public class EntityElementalOcelot extends EntityOcelot
{
	private EnumBiomes biome;

	public EntityElementalOcelot(World par1World, EnumBiomes theBiome)
	{
		super(par1World);
		biome = theBiome;
	}

	public EnumBiomes getBiome()
	{
		return biome;
	}
}