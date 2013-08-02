package net.elemental.entity.passive;

import net.elemental.biome.EnumBiomes;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.world.World;

public class EntityElementalPig extends EntityPig implements IElementalEntity
{
private EnumBiomes biome;
	
    public EntityElementalPig(World par1World)
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
