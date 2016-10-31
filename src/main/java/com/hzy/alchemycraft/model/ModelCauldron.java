package com.hzy.alchemycraft.model;

import com.hzy.alchemycraft.tileentity.TileEntityDiffuserBlock;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCauldron extends ModelBase{
	ModelRenderer side;
	ModelRenderer bottom;
	ModelRenderer water;
	 public ModelCauldron(){
	    textureWidth = 128;
	    textureHeight = 32;
	    
	    this.side = new ModelRenderer(this, 0, 0);
	    this.side.setTextureSize(textureWidth, textureHeight);
	    this.side.setRotationPoint(-8F, 24F, -8F);
	    this.side.addBox(0.0f, -8.0f, 0.0f, 16, 8, 1);
	    this.side.addBox(0.0f,-8.0f, 15.0f, 16, 8, 1);
	    this.side.addBox(0.0f, -8.0f, 1.0f, 1, 8, 14);
	    this.side.addBox(15.0f, -8.0f,1.0f, 1, 8, 14);
	    
	    this.bottom = new ModelRenderer(this, 64, 0);
	    this.bottom.setTextureSize(textureWidth, textureHeight);
	    this.bottom.setRotationPoint(-7F, 23F, -7F);
	    this.bottom.addBox(0.0f, 0.0f, 0.0f, 14, 1, 14);
	   
	  }
	 
	 @Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5,entity);
	    side.render(f5);
	    bottom.render(f5);
	  }
	 
	  public void renderModel(float f){
		  side.render(f);
		  bottom.render(f); 
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
