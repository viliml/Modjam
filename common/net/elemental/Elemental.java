package net.elemental;

import net.elemental.biome.Biomes;
import net.elemental.block.Blocks;
import net.elemental.common.CommonProxyElemental;
import net.elemental.common.CreativeTabElemental;
import net.elemental.common.ElementalConfig;
import net.elemental.common.ElementalEventListener;
import net.elemental.common.Recipes;
import net.elemental.dimension.Dimensions;
import net.elemental.item.Items;
import net.elemental.lib.Reference;
import net.elemental.lib.ShrineHelper;
import net.elemental.tileentity.TileEntities;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
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

	@SidedProxy
	(
			clientSide = Reference.CLIENT_PROXY_LOCATION,
			serverSide = Reference.SERVER_PROXY_LOCATION
			)
	public static CommonProxyElemental proxy;

	public static CreativeTabs creativeTabElemental;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		proxy.registerRenderers();
		ElementalConfig.initConfigs();
		creativeTabElemental = new CreativeTabElemental(Reference.MOD_NAME);
		Blocks.initBlocks();
		Items.initItems();
		Biomes.init();
		Dimensions.initDimensions();
		//Entities.init();
		if (ShrineHelper.CENTER_BLOCK_ID == 1) System.out.println(">.>");
		MinecraftForge.EVENT_BUS.register(new ElementalEventListener());
		MinecraftForge.TERRAIN_GEN_BUS.register(new ElementalEventListener());
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		TileEntities.initTileEntities();
		Recipes.initRecipes();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
	}
}
