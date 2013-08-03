package net.elemental.entity;

import net.elemental.biome.EnumBiomes;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.world.World;

public class EntityElementalBat extends EntityBat
{
	private EnumBiomes biome;
	
    public EntityElementalBat(World par1World, EnumBiomes theBiome)
    {
        super(par1World);
        biome = theBiome;
    }
    
    public EnumBiomes getBiome()
    {
    	return biome;
    }
}
