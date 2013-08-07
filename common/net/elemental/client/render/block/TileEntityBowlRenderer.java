package net.elemental.client.render.block;

import net.elemental.client.model.block.ModelBowl;
import net.elemental.lib.Reference;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class TileEntityBowlRenderer extends TileEntitySpecialRenderer
{
	private final ModelBowl model;

	public TileEntityBowlRenderer()
	{
		this.model = new ModelBowl();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y,
			double z, float scale)
	{
		GL11.glPushMatrix();

		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);

		func_110628_a(new ResourceLocation(Reference.MOD_ID, "textures/blocks/bowl.png"));

		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);

		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);

		GL11.glPopMatrix();
		
		GL11.glPopMatrix();
	}
}