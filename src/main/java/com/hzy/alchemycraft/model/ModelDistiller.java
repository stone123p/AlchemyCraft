
package com.hzy.alchemycraft.model;

import com.hzy.alchemycraft.tileentity.TileEntityDistillerBlock;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

public class ModelDistiller extends ModelBase
{
  //fields
	ModelRenderer boiler;
	ModelRenderer stand;
	ModelRenderer tube;
  
  public ModelDistiller()
  {
    textureWidth = 128;
    textureHeight = 32;
    
    this.boiler = new ModelRenderer(this, 58, 0);
    this.boiler.setTextureSize(textureWidth, textureHeight);
    this.boiler.setRotationPoint(-1F, 7F, -1F);
    //this.boiler.addBox(1.5f, 6.0f, 1.5f, 3, 1, 3);
    this.boiler.addBox(2.0f, 6.0f, 2.0f, 2, 3, 2);
    this.boiler.addBox(1.0f, 9.0f, 1.0f, 4, 1, 4);
    this.boiler.addBox(0.0f, 10.0f, 0.0f, 6, 3, 6);
    this.boiler.addBox(1.0f, 13.0f, 1.0f, 4, 1, 4);
   
    this.stand = new ModelRenderer(this, 24, 1);
    this.stand.setTextureSize(this.textureWidth, this.textureHeight);
    this.stand.setRotationPoint(-2F,24F, 14F);
    this.setRotation(this.stand, 3.14f, 0.0f, 0.0f);
    this.stand.addBox(1.0f, 0.0f, 9.0f, 6, 3, 6);
    
    this.tube = new ModelRenderer(this, 0, 13);
    this.tube.setTextureSize(this.textureWidth, this.textureHeight);
    this.tube.setRotationPoint(-3.3f, 10.0f, -1.0f);
    this.setRotation(this.tube, 3.14f, 3.14f, 0.0f);
    this.tube.addBox(-5.9f, -1.0f, 2.6f, 10, 1, 1);
    this.tube.addBox(-5.9f, -10.0f, 2.6f, 1, 10, 1);
    this.tube.addBox(3.1f, -6.0f, 2.6f, 1, 5, 1);
    
  }
  
  @Override
public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5,entity);
      boiler.render(f5);
      stand.render(f5);
      tube.render(f5);
  }
  public void renderModel(TileEntityDistillerBlock entity, float f){
	  
	  
		boiler.render(f);
		stand.render(f);
		tube.render(f);
  }
  public void renderModel2(float f){
		stand.render(f);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  @Override
public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5,Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5,entity);
  }

}
