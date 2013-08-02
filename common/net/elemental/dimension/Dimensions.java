package net.elemental.dimension;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.DimensionManager;

public class Dimensions
{
	public static final int ELEMENTAL_DIMENSION_ID = DimensionManager.getNextFreeDimId();
	
	public static void initDimensions()
	{
		DimensionManager.registerProviderType(ELEMENTAL_DIMENSION_ID, WorldProviderElemental.class, true);
		DimensionManager.registerDimension(ELEMENTAL_DIMENSION_ID, ELEMENTAL_DIMENSION_ID);
		GameRegistry.registerWorldGenerator(new ElementalOreGen());
	}
}
