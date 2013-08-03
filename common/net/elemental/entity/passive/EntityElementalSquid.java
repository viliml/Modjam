package net.elemental.entity.passive;

import net.elemental.biome.EnumBiomes;
import net.elemental.entity.IElementalEntity;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.world.World;

public class EntityElementalSquid extends EntitySquid implements IElementalEntity
{
private EnumBiomes biome;
	
    public EntityElementalSquid(World par1World)
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
