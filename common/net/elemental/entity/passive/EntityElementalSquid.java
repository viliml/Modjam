package net.elemental.entity.passive;

import net.elemental.biome.EnumBiomes;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.world.World;

public class EntityElementalSquid extends EntitySquid implements IElementalEntity
{
private EnumBiomes biome;
	
    public EntityElementalSquid(World par1World, EnumBiomes theBiome)
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
