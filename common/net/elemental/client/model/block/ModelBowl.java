package net.elemental.client.model.block;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBowl extends ModelBase
{
  //fields
    ModelRenderer BottomLayer;
    ModelRenderer Layer1;
    ModelRenderer Layer2;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
  
  public ModelBowl()
  {
    textureWidth = 184;
    textureHeight = 32;
    
      BottomLayer = new ModelRenderer(this, 0, 0);
      BottomLayer.addBox(0F, 0F, 0F, 10, 1, 10);
      BottomLayer.setRotationPoint(-5F, 22F, -5F);
      BottomLayer.setTextureSize(textureWidth, textureHeight);
      BottomLayer.mirror = true;
      setRotation(BottomLayer, 0F, 0F, 0F);
      Layer1 = new ModelRenderer(this, 0, 12);
      Layer1.addBox(0F, 0F, 0F, 12, 1, 12);
      Layer1.setRotationPoint(-6F, 21F, -6F);
      Layer1.setTextureSize(textureWidth, textureHeight);
      Layer1.mirror = true;
      setRotation(Layer1, 0F, 0F, 0F);
      Layer2 = new ModelRenderer(this, 49, 0);
      Layer2.addBox(0F, 0F, 0F, 14, 1, 14);
      Layer2.setRotationPoint(-7F, 20F, -7F);
      Layer2.setTextureSize(textureWidth, textureHeight);
      Layer2.mirror = true;
      setRotation(Layer2, 0F, 0F, 0F);
      Shape1 = new ModelRenderer(this, 137, 0);
      Shape1.addBox(0F, 0F, 0F, 1, 1, 14);
      Shape1.setRotationPoint(-7F, 19F, -7F);
      Shape1.setTextureSize(textureWidth, textureHeight);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 66, 16);
      Shape2.addBox(0F, 0F, 0F, 14, 1, 1);
      Shape2.setRotationPoint(-7F, 19F, -7F);
      Shape2.setTextureSize(textureWidth, textureHeight);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 66, 19);
      Shape3.addBox(0F, 0F, 0F, 14, 1, 1);
      Shape3.setRotationPoint(-7F, 19F, 6F);
      Shape3.setTextureSize(textureWidth, textureHeight);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 106, 0);
      Shape4.addBox(0F, 0F, 0F, 1, 1, 14);
      Shape4.setRotationPoint(6F, 19F, -7F);
      Shape4.setTextureSize(textureWidth, textureHeight);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 106, 18);
      Shape5.addBox(0F, 0F, 0F, 8, 1, 8);
      Shape5.setRotationPoint(-4F, 23F, -4F);
      Shape5.setTextureSize(textureWidth, textureHeight);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    BottomLayer.render(f5);
    Layer1.render(f5);
    Layer2.render(f5);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
