package net.elemental.entity.passive;

import net.elemental.biome.EnumBiomes;
import net.elemental.entity.IElementalEntity;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.world.World;

public class EntityElementalBat extends EntityBat implements IElementalEntity
{
	private EnumBiomes biome;
	
    public EntityElementalBat(World par1World)
    {
        super(par1World);
    }
    
    @Override
    public EnumBiomes getBiome()
    {
    	return biome;
    }

	@Override
	public void setBiome(EnumBiomes theBiome) {
		biome = theBiome;
	}
}
