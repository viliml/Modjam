package net.elemental.entity.passive;

import net.elemental.biome.EnumBiomes;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.world.World;

public class EntityElementalChicken extends EntityChicken implements IElementalEntity
{
	private EnumBiomes biome;
	
    public EntityElementalChicken(World par1World, EnumBiomes theBiome)
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
