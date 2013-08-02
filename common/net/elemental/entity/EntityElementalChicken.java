package net.elemental.entity;

import net.elemental.biome.EnumBiomes;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.world.World;

public class EntityElementalChicken extends EntityChicken
{
	private EnumBiomes biome;
	
    public EntityElementalChicken(World par1World, EnumBiomes theBiome)
    {
        super(par1World);
        biome = theBiome;
    }
    
    public EnumBiomes getBiome()
    {
    	return biome;
    }
}
