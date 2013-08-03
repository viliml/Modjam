package net.elemental.entity;

import net.elemental.biome.EnumBiomes;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.world.World;

public class EntityElementalSquid extends EntitySquid
{
private EnumBiomes biome;
	
    public EntityElementalSquid(World par1World, EnumBiomes theBiome)
    {
        super(par1World);
        biome = theBiome;
    }
    
    public EnumBiomes getBiome()
    {
    	return biome;
    }
}
