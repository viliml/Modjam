package net.elemental.lib;

import net.minecraftforge.common.DimensionManager;

public class Reference 
{
	public static final String MOD_ID = "elemental";
	public static final String MOD_NAME = "The Wisdom of the Elements";
	public static final String VERSION_NUMBER = "0.0.1";
	
	public static final String CLIENT_PROXY_LOCATION = "net.elemental.client.ClientProxyElemental";
	public static final String SERVER_PROXY_LOCATION = "net.elemental.common.CommonProxyElemental";

	public static final int dimensionID = DimensionManager.getNextFreeDimId();
}
