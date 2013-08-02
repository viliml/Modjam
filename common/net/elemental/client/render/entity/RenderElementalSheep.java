package net.elemental.client.render.entity;

import net.elemental.entity.EntityElementalSheep;
import net.elemental.lib.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderSheep;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderElementalSheep extends RenderSheep
{
	private static final ResourceLocation earth =
			new ResourceLocation(Reference.MOD_ID, "textures/entity/sheepEarth.png");
	private static final ResourceLocation air =
			new ResourceLocation(Reference.MOD_ID, "textures/entity/sheepAir.png");
	private static final ResourceLocation fire =
			new ResourceLocation(Reference.MOD_ID, "textures/entity/sheepFire.png");
	private static final ResourceLocation water =
			new ResourceLocation(Reference.MOD_ID, "textures/entity/sheepWater.png");
	
    public RenderElementalSheep(ModelBase par1ModelBase, ModelBase par2ModelBase, float par3)
    {
        super(par1ModelBase, par2ModelBase, par3);
    }

    protected ResourceLocation getTexture(EntityElementalSheep entity)
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
        return this.getTexture((EntityElementalSheep)par1Entity);
    }
}
