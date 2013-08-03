package net.elemental.entity;

import net.elemental.biome.EnumBiomes;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.world.World;

public class EntityElementalCow extends EntityCow
{
	private EnumBiomes biome;
	
    public EntityElementalCow(World par1World, EnumBiomes theBiome)
    {
        super(par1World);
        biome = theBiome;
    }
    
    public EnumBiomes getBiome()
    {
    	return biome;
    }
}
