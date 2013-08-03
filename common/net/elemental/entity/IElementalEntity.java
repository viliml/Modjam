package net.elemental.entity;

import net.elemental.biome.EnumBiomes;

public interface IElementalEntity {

	public EnumBiomes getBiome();
	
	public void setBiome(EnumBiomes theBiome);

}