package net.elemental.entity;

import net.elemental.biome.EnumBiomes;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.world.World;

public class EntityElementalPig extends EntityPig
{
private EnumBiomes biome;
	
    public EntityElementalPig(World par1World, EnumBiomes theBiome)
    {
        super(par1World);
        biome = theBiome;
    }
    
    public EnumBiomes getBiome()
    {
    	return biome;
    }
}
