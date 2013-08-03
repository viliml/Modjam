package net.elemental.entity;

import net.elemental.biome.EnumBiomes;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.world.World;

public class EntityElementalHorse extends EntityHorse
{
	private EnumBiomes biome;
	
    public EntityElementalHorse(World par1World, EnumBiomes theBiome)
    {
        super(par1World);
        biome = theBiome;
    }
    
    public EnumBiomes getBiome()
    {
    	return biome;
    }
}
