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
	    field_78090_t = 128;
	    field_78089_u = 32;
	    
	    this.potion = new ModelRenderer(this, 58, 0);
	    this.potion.func_78787_b(field_78090_t, field_78089_u);
	    this.potion.func_78793_a(0F, 15F, 0F);
	    this.potion.func_78789_a(-2.0f, 0.0f, -2.0f, 4, 1, 4);
	    
	    this.boiler = new ModelRenderer(this, 0, 0);
	    this.boiler.func_78787_b(field_78090_t, field_78089_u);
	    this.boiler.func_78793_a(0F, 14F, 0F);
	    this.boiler.func_78789_a(2.0f, 0.0f, -3.0f, 1, 2, 6);
	    this.boiler.func_78789_a(-3.0f, 0.0f, -3.0f, 1, 2, 6);
	    this.boiler.func_78789_a(-2.0f, 0.0f, 2.0f, 4, 2, 1);
	    this.boiler.func_78789_a(-2.0f, 0.0f, -3.0f, 4, 2, 1);
	    this.boiler.func_78789_a(-3.0f, 2.0f, -3.0f, 6, 1, 6);
	   
	    this.stand = new ModelRenderer(this, 0, 0);
	    this.stand.func_78787_b(this.field_78090_t, this.field_78089_u);
	    this.stand.func_78793_a(0F,24F, 0F);
	    this.setRotation(this.stand, 3.14f, 0.0f, 0.0f);
	    this.stand.func_78789_a(-3.0f, 2.0f,-3.0f, 1, 5, 6);
	    this.stand.func_78789_a(2.0f, 2.0f,-3.0f, 1, 5, 6);
	    this.stand.func_78789_a(-2.0f, 2.0f,2.0f, 4, 1, 1);
	    this.stand.func_78789_a(-2.0f, 2.0f,-3.0f, 4, 1, 1);
	    this.stand.func_78789_a(-3.0f, 1.0f,-3.0f, 6, 1, 6);
	  }
	 
	 @Override
	public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
	    func_78087_a(f, f1, f2, f3, f4, f5,entity);
	    potion.func_78785_a(f5);
	    boiler.func_78785_a(f5);
	    stand.func_78785_a(f5);
	  }
	 
	  public void renderModel(float f,TileEntityDiffuserBlock tile){
		  boiler.func_78785_a(f);
		  stand.func_78785_a(f); 
		  if(tile !=null && tile.isBurning())
		  potion.func_78785_a(f);
		 
	  }
	  
	 
	  private void setRotation(ModelRenderer model, float x, float y, float z)
	  {
	    model.field_78795_f = x;
	    model.field_78796_g = y;
	    model.field_78808_h = z;
	  }
	  
	  @Override
	public void func_78087_a(float f, float f1, float f2, float f3, float f4, float f5,Entity entity)
	  {
	    super.func_78087_a(f, f1, f2, f3, f4, f5,entity);
	  }
}
