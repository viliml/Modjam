package net.elemental;

import net.elemental.blocks.BlockBowl;
import net.elemental.common.CommonProxyElemental;
import net.elemental.lib.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod
(
	modid = Reference.MOD_ID,
	name = Reference.MOD_NAME,
	version = Reference.VERSION_NUMBER
)
@NetworkMod
(
	clientSideRequired = true,
	serverSideRequired = true
)

public class Elemental 
{
	@Instance
	public static Elemental instance;
	
	public static BlockBowl bowlBlock;
	
	@SidedProxy
	(
		clientSide = Reference.CLIENT_PROXY_LOCATION,
		serverSide = Reference.SERVER_PROXY_LOCATION
	)
	public static CommonProxyElemental proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		bowlBlock = new BlockBowl(4000).func_111022_d("elemental:bowlBlock");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
	}
}
