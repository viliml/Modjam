package net.elemental.client.render;

import net.elemental.client.render.block.RenderBowlNew;
import net.elemental.client.render.block.TileEntityBowlRenderer;
import net.elemental.tileentity.TileEntityBowl;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class RenderHandlers 
{
	public static int RENDER_BOWL_RENDER_ID;
	
	public static void initRenderers()
	{
		RENDER_BOWL_RENDER_ID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new RenderBowlNew());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBowl.class, new TileEntityBowlRenderer());
	}
}
