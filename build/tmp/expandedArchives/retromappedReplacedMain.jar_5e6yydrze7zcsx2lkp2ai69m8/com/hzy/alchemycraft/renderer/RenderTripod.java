package com.hzy.alchemycraft.renderer;

import org.lwjgl.opengl.GL11;

import com.hzy.alchemycraft.AlchemyCraft;
import com.hzy.alchemycraft.model.ModelDistiller;
import com.hzy.alchemycraft.tileentity.TileEntityTripodBlock;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderTripod extends TileEntitySpecialRenderer {

	 private static final ResourceLocation texture = new ResourceLocation(AlchemyCraft.MODID+":"+"textures/models/Distiller.png");
		private EntityItem entItem = null;
		private RenderManager renderManager;
	    private ModelDistiller model;
		
	    public RenderTripod(){
	    	this.model = new ModelDistiller();
	    }
	    

		@Override
		public void func_180535_a(TileEntity tileentity, double x, double y, double z, float partialTicks,
				int destroyStage) {
			GL11.glPushMatrix();
				GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
				GL11.glRotatef(180, 0F, 0F, 1F);
				this.func_147499_a(texture);
				GL11.glPushMatrix();
					this.model.renderModel2(0.0625F);
				GL11.glPopMatrix();
				GL11.glPopMatrix();
				if(((TileEntityTripodBlock)tileentity).CookItem!=null){
			((TileEntityTripodBlock)tileentity).CookItem.field_77994_a=1;
			
			
			entItem = new EntityItem(tileentity.func_145831_w(), x, y, z,((TileEntityTripodBlock)tileentity).CookItem);
			TileEntityTripodBlock es = (TileEntityTripodBlock)tileentity;

			if(es.CookItem != null) {
				GL11.glPushMatrix();
					this.entItem.field_70290_d = 0.0F;
					RenderManager var11 = Minecraft.func_71410_x().func_175598_ae();
					GL11.glTranslatef((float) x + 0.5F, (float) y + 1F, (float) z + 0.28F);
					GL11.glRotatef(180, 0, 1, 1);
					var11.func_147940_a(entItem,  0.13f,  0, -0.8,0, 0);
				GL11.glPopMatrix();
			}

		}
			
		}


}
