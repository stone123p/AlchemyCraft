package com.hzy.alchemycraft.model;

import com.hzy.alchemycraft.tileentity.TileEntityDiffuserBlock;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDiffuser extends ModelBase{
	ModelRenderer boiler;
	ModelRenderer stand;
	ModelRenderer potion;
	 public ModelDiffuser(){
	    textureWidth = 128;
	    textureHeight = 32;
	    
	    this.potion = new ModelRenderer(this, 58, 0);
	    this.potion.setTextureSize(textureWidth, textureHeight);
	    this.potion.setRotationPoint(0F, 15F, 0F);
	    this.potion.addBox(-2.0f, 0.0f, -2.0f, 4, 1, 4);
	    
	    this.boiler = new ModelRenderer(this, 0, 0);
	    this.boiler.setTextureSize(textureWidth, textureHeight);
	    this.boiler.setRotationPoint(0F, 14F, 0F);
	    this.boiler.addBox(2.0f, 0.0f, -3.0f, 1, 2, 6);
	    this.boiler.addBox(-3.0f, 0.0f, -3.0f, 1, 2, 6);
	    this.boiler.addBox(-2.0f, 0.0f, 2.0f, 4, 2, 1);
	    this.boiler.addBox(-2.0f, 0.0f, -3.0f, 4, 2, 1);
	    this.boiler.addBox(-3.0f, 2.0f, -3.0f, 6, 1, 6);
	   
	    this.stand = new ModelRenderer(this, 0, 0);
	    this.stand.setTextureSize(this.textureWidth, this.textureHeight);
	    this.stand.setRotationPoint(0F,24F, 0F);
	    this.setRotation(this.stand, 3.14f, 0.0f, 0.0f);
	    this.stand.addBox(-3.0f, 2.0f,-3.0f, 1, 5, 6);
	    this.stand.addBox(2.0f, 2.0f,-3.0f, 1, 5, 6);
	    this.stand.addBox(-2.0f, 2.0f,2.0f, 4, 1, 1);
	    this.stand.addBox(-2.0f, 2.0f,-3.0f, 4, 1, 1);
	    this.stand.addBox(-3.0f, 1.0f,-3.0f, 6, 1, 6);
	  }
	 
	 @Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5,entity);
	    potion.render(f5);
	    boiler.render(f5);
	    stand.render(f5);
	  }
	 
	  public void renderModel(float f,TileEntityDiffuserBlock tile){
		  boiler.render(f);
		  stand.render(f); 
		  if(tile !=null && tile.isBurning())
		  potion.render(f);
		 
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
