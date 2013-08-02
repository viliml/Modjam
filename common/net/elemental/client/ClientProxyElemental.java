package net.elemental.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.elemental.client.render.RenderBowl;
import net.elemental.common.CommonProxyElemental;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.RenderBlockFluid;

public class ClientProxyElemental extends CommonProxyElemental
{
	public static int renderIdBowl;
	
	static {
        renderIdBowl = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(RenderBowl.instance);
    }
}
