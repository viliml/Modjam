package net.elemental.entity.passive;

import net.elemental.biome.EnumBiomes;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.world.World;

public class EntityElementalCow extends EntityCow implements IElementalEntity
{
	private EnumBiomes biome;
	
    public EntityElementalCow(World par1World, EnumBiomes theBiome)
    {
        super(par1World);
        biome = theBiome;
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