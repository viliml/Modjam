package net.elemental.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntities
{
	public static final String TE_BOWL_KEY = "tileEntityBowl";

	public static void initTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityBowl.class, TE_BOWL_KEY);
	}
}