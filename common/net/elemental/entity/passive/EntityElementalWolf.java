package net.elemental.entity.passive;

import net.elemental.biome.EnumBiomes;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.World;

public class EntityElementalWolf extends EntityWolf implements IElementalEntity
{
	private EnumBiomes biome;

	public EntityElementalWolf(World par1World, EnumBiomes theBiome)
	{
		super(par1World);
		biome = theBiome;
	}
		
	@Override
	public EnumBiomes getBiome()
	{
		return biome;
	}
}