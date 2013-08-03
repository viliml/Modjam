package net.elemental.client.render.entity;

import net.elemental.entity.passive.EntityElementalPig;
import net.elemental.lib.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderPig;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderElementalPig extends RenderPig
{
	private static final ResourceLocation earth =
			new ResourceLocation(Reference.MOD_ID, "textures/entity/pigEarth.png");
	private static final ResourceLocation air =
			new ResourceLocation(Reference.MOD_ID, "textures/entity/pigAir.png");
	private static final ResourceLocation fire =
			new ResourceLocation(Reference.MOD_ID, "textures/entity/pigFire.png");
	private static final ResourceLocation water =
			new ResourceLocation(Reference.MOD_ID, "textures/entity/pigWater.png");

    public RenderElementalPig(ModelBase par1ModelBase, ModelBase par2ModelBase, float par2)
    {
        super(par1ModelBase, par2ModelBase, par2);
    }
    
    protected ResourceLocation getTexture(EntityElementalPig entity)
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
        return getTexture((EntityElementalPig)par1Entity);
    }
}
