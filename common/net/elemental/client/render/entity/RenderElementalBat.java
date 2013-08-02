package net.elemental.client.render.entity;

import net.minecraft.client.model.ModelBat;
import net.minecraft.client.renderer.entity.RenderBat;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderElementalBat extends RenderBat
{
    private static final ResourceLocation field_110835_a = new ResourceLocation("textures/entity/bat.png");

    /**
     * not actually sure this is size, is not used as of now, but the model would be recreated if the value changed and
     * it seems a good match for a bats size
     */
    private int renderedBatSize;

    public RenderElementalBat()
    {
        super();
    }

    protected ResourceLocation func_110834_a(EntityBat par1EntityBat)
    {
        return field_110835_a;
    }

    protected ResourceLocation func_110775_a(Entity par1Entity)
    {
        return this.func_110834_a((EntityBat)par1Entity);
    }
}
