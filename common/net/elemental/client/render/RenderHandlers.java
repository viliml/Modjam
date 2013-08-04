package net.elemental.client.render;

import net.elemental.client.render.block.RenderBowl;
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
		//RenderingRegistry.registerBlockHandler(new RenderBowl());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBowl.class, new TileEntityBowlRenderer());
		//initEntityRenderers();
	}
	
	/*private static void initEntityRenderers()
	{
		//RenderingRegistry.registerEntityRenderingHandler(EntityElementalCaveSpider.class, new RenderElementalCaveSpider());
        //RenderingRegistry.registerEntityRenderingHandler(EntityElementalSpider.class, new RenderElementalSpider());
        RenderingRegistry.registerEntityRenderingHandler(EntityElementalPig.class, new RenderElementalPig(new ModelPig(), new ModelPig(0.5F), 0.7F));
        RenderingRegistry.registerEntityRenderingHandler(EntityElementalSheep.class, new RenderElementalSheep(new ModelSheep2(), new ModelSheep1(), 0.7F));
        RenderingRegistry.registerEntityRenderingHandler(EntityElementalCow.class, new RenderElementalCow(new ModelCow(), 0.7F));
        //RenderingRegistry.registerEntityRenderingHandler(EntityElementalMooshroom.class, new RenderElementalMooshroom(new ModelCow(), 0.7F));
        RenderingRegistry.registerEntityRenderingHandler(EntityElementalWolf.class, new RenderElementalWolf(new ModelWolf(), new ModelWolf(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityElementalChicken.class, new RenderElementalChicken(new ModelChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityElementalOcelot.class, new RenderElementalOcelot(new ModelOcelot(), 0.4F));
        //RenderingRegistry.registerEntityRenderingHandler(EntityElementalSilverfish.class, new RenderElementalSilverfish());
        //RenderingRegistry.registerEntityRenderingHandler(EntityElementalCreeper.class, new RenderElementalCreeper());
        //RenderingRegistry.registerEntityRenderingHandler(EntityElementalEnderman.class, new RenderElementalEnderman());
        //RenderingRegistry.registerEntityRenderingHandler(EntityElementalSnowman.class, new RenderElementalSnowMan());
        //RenderingRegistry.registerEntityRenderingHandler(EntityElementalSkeleton.class, new RenderElementalSkeleton());
        //RenderingRegistry.registerEntityRenderingHandler(EntityElementalWitch.class, new RenderElementalWitch());
        //RenderingRegistry.registerEntityRenderingHandler(EntityElementalBlaze.class, new RenderElementalBlaze());
        //RenderingRegistry.registerEntityRenderingHandler(EntityElementalZombie.class, new RenderElementalZombie());
        //RenderingRegistry.registerEntityRenderingHandler(EntityElementalSlime.class, new RenderElementalSlime(new ModelSlime(16), new ModelSlime(0), 0.25F));
        //RenderingRegistry.registerEntityRenderingHandler(EntityElementalMagmaCube.class, new RenderElementalMagmaCube());
        //RenderingRegistry.registerEntityRenderingHandler(EntityElementalGhast.class, new RenderElementalGhast());
        RenderingRegistry.registerEntityRenderingHandler(EntityElementalSquid.class, new RenderElementalSquid(new ModelSquid(), 0.7F));
        //RenderingRegistry.registerEntityRenderingHandler(EntityElementalVillager.class, new RenderElementalVillager());
        //RenderingRegistry.registerEntityRenderingHandler(EntityElementalIronGolem.class, new RenderElementalIronGolem());
        //RenderingRegistry.registerEntityRenderingHandler(EntityElementalBat.class, new RenderElementalBat());
        //RenderingRegistry.registerEntityRenderingHandler(EntityElementalDragon.class, new RenderElementalDragon());
        //RenderingRegistry.registerEntityRenderingHandler(EntityElementalEnderCrystal.class, new RenderElementalEnderCrystal());
        //RenderingRegistry.registerEntityRenderingHandler(EntityElementalWither.class, new RenderElementalWither());
        RenderingRegistry.registerEntityRenderingHandler(EntityElementalHorse.class, new RenderElementalHorse(new ModelHorse(), 0.75F));
	}*/
}
