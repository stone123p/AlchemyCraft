
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
    field_78090_t = 128;
    field_78089_u = 32;
    
    this.boiler = new ModelRenderer(this, 58, 0);
    this.boiler.func_78787_b(field_78090_t, field_78089_u);
    this.boiler.func_78793_a(-1F, 7F, -1F);
    //this.boiler.addBox(1.5f, 6.0f, 1.5f, 3, 1, 3);
    this.boiler.func_78789_a(2.0f, 6.0f, 2.0f, 2, 3, 2);
    this.boiler.func_78789_a(1.0f, 9.0f, 1.0f, 4, 1, 4);
    this.boiler.func_78789_a(0.0f, 10.0f, 0.0f, 6, 3, 6);
    this.boiler.func_78789_a(1.0f, 13.0f, 1.0f, 4, 1, 4);
   
    this.stand = new ModelRenderer(this, 24, 1);
    this.stand.func_78787_b(this.field_78090_t, this.field_78089_u);
    this.stand.func_78793_a(-2F,24F, 14F);
    this.setRotation(this.stand, 3.14f, 0.0f, 0.0f);
    this.stand.func_78789_a(1.0f, 0.0f, 9.0f, 6, 3, 6);
    
    this.tube = new ModelRenderer(this, 0, 13);
    this.tube.func_78787_b(this.field_78090_t, this.field_78089_u);
    this.tube.func_78793_a(-3.3f, 10.0f, -1.0f);
    this.setRotation(this.tube, 3.14f, 3.14f, 0.0f);
    this.tube.func_78789_a(-5.9f, -1.0f, 2.6f, 10, 1, 1);
    this.tube.func_78789_a(-5.9f, -10.0f, 2.6f, 1, 10, 1);
    this.tube.func_78789_a(3.1f, -6.0f, 2.6f, 1, 5, 1);
    
  }
  
  @Override
public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
    func_78087_a(f, f1, f2, f3, f4, f5,entity);
      boiler.func_78785_a(f5);
      stand.func_78785_a(f5);
      tube.func_78785_a(f5);
  }
  public void renderModel(TileEntityDistillerBlock entity, float f){
	  
	  
		boiler.func_78785_a(f);
		stand.func_78785_a(f);
		tube.func_78785_a(f);
  }
  public void renderModel2(float f){
		stand.func_78785_a(f);
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
