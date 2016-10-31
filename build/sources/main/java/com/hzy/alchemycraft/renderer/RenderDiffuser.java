package com.hzy.alchemycraft.renderer;

import org.lwjgl.opengl.GL11;

import com.hzy.alchemycraft.AlchemyCraft;
import com.hzy.alchemycraft.items.ACItems;
import com.hzy.alchemycraft.model.ModelDiffuser;
import com.hzy.alchemycraft.tileentity.TileEntityDiffuserBlock;

import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderDiffuser extends TileEntitySpecialRenderer{
	private static final ResourceLocation texture = new ResourceLocation(AlchemyCraft.MODID+":"+"textures/models/Distiller.png");
	private EntityItem entItem = null;
	private ModelDiffuser model;
	public RenderDiffuser(){
		this.model = new ModelDiffuser();
	}
	


	@Override
	public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float partialTicks, int destroyStage) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);
		this.bindTexture(texture);
		GL11.glPushMatrix();
			this.model.renderModel(0.0625F,(TileEntityDiffuserBlock) entity);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		
	}
	
}
