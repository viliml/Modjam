package net.elemental.client.render.entity;

import net.elemental.entity.passive.EntityElementalBat;
import net.elemental.lib.Reference;
import net.minecraft.client.renderer.entity.RenderBat;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderElementalBat extends RenderBat //<-- Bat
{
	private static final ResourceLocation earth =
			new ResourceLocation(Reference.MOD_ID, "textures/entity/batEarth.png");
	private static final ResourceLocation air =
			new ResourceLocation(Reference.MOD_ID, "textures/entity/batAir.png");
	private static final ResourceLocation fire =
			new ResourceLocation(Reference.MOD_ID, "textures/entity/batFire.png");
	private static final ResourceLocation water =
			new ResourceLocation(Reference.MOD_ID, "textures/entity/batWater.png");

    public RenderElementalBat()
    {
        super();
    }

    protected ResourceLocation getTexture(EntityElementalBat entity)
    {
        switch (entity.getBiome())
        {
        case Earth:
        	return earth;
		case Air:
        	return air;
		case Fire:
        	return fire;
		case Water:
        	return water;
		default:
			return null;
        }
    }

    protected ResourceLocation func_110775_a(Entity entity)
    {
        return getTexture((EntityElementalBat)entity);
    }
}
