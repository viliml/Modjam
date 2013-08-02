package net.elemental.client.render;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class RenderHandlers 
{
	public static int RENDER_BOWL_RENDER_ID;
	
	public static void initRenderers()
	{
		RENDER_BOWL_RENDER_ID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new RenderBowl());
	}
}
