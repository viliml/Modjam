package net.elemental.client.render.entity;

import net.elemental.entity.EntityElementalChicken;
import net.elemental.lib.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderChicken;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderElementalChicken extends RenderChicken
{
	private static final ResourceLocation earth =
			new ResourceLocation(Reference.MOD_ID, "textures/entity/chickenEarth.png");
	private static final ResourceLocation air =
			new ResourceLocation(Reference.MOD_ID, "textures/entity/chickenAir.png");
	private static final ResourceLocation fire =
			new ResourceLocation(Reference.MOD_ID, "textures/entity/chickenFire.png");
	private static final ResourceLocation water =
			new ResourceLocation(Reference.MOD_ID, "textures/entity/chickenWater.png");

    public RenderElementalChicken(ModelBase par1ModelBase, float par2)
    {
        super(par1ModelBase, par2);
    }
    
    protected ResourceLocation getTexture(EntityElementalChicken entity)
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
    
    protected ResourceLocation func_110775_a(Entity par1Entity)
    {
        return this.getTexture((EntityElementalChicken)par1Entity);
    }
}
