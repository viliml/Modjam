package net.elemental.entity.passive;

import net.elemental.biome.EnumBiomes;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.world.World;

public class EntityElementalSheep extends EntitySheep implements IElementalEntity
{
	private EnumBiomes biome;
	
    public EntityElementalSheep(World par1World, EnumBiomes theBiome)
    {
        super(par1World);
        biome = theBiome;
    }
    
    public EnumBiomes getBiome()
    {
    	return biome;
    }
}