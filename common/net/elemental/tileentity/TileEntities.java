package net.elemental.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntities
{
	public static final String TE_BOWL_KEY = "tileEntityBowl";
	public static final String TE_PORTAL_KEY = "tileEntityPortalElemental";

	public static void initTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityBowl.class, TE_BOWL_KEY);
		GameRegistry.registerTileEntity(TileEntityElementalPortal.class, TE_PORTAL_KEY);
	}
}