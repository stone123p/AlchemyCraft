package com.hzy.alchemycraft.gui;

import org.lwjgl.opengl.GL11;

import com.hzy.alchemycraft.AlchemyCraft;
import com.hzy.alchemycraft.container.ContainerDistiller;
import com.hzy.alchemycraft.tileentity.TileEntityDistillerBlock;
import com.sun.imageio.plugins.common.I18N;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiDistiller extends GuiContainer{

	private final ResourceLocation res = new ResourceLocation(AlchemyCraft.MODID+":textures/guis/distiller.png");
	private TileEntityDistillerBlock entity;
	
	public GuiDistiller(InventoryPlayer inv,TileEntityDistillerBlock entity){
		super(new ContainerDistiller(inv,entity));
		this.entity=entity;
		this.field_146999_f = 176; 
		this.field_147000_g = 166;
	}

	@Override
	protected void func_146979_b(int part1,int part2){
		String name = this.entity.func_145818_k_()? this.entity.func_70005_c_()  : I18n.func_135052_a(this.entity.func_70005_c_(), new Object[0]);
		this.field_146289_q.func_78276_b(name, this.field_146999_f/2-this.field_146289_q.func_78256_a(name)/2,6 , 4210752);
		this.field_146289_q.func_78276_b(I18N.getString("container.inventor"), 8,this.field_147000_g-96+2, 4210752);
		
	
	}
 	
	@Override
	protected void func_146976_a(float part1, int part2, int part3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		this.field_146297_k.func_110434_K().func_110577_a(res);
        int k = (this.field_146294_l - this.field_146999_f) / 2;
        int l = (this.field_146295_m - this.field_147000_g) / 2;
        this.func_73729_b(k, l, 0, 0, this.field_146999_f, this.field_147000_g);
        int i1;

        if (this.entity.isBurning())
        {
            i1 = this.entity.getBurnTimeRemainingScaled(24);
            this.func_73729_b(k + 44,l + 41+14-i1, 178, 68-i1, 14, i1+2 );
        }

        i1 = this.entity.getCookProgressScaled(24);
        this.func_73729_b(k + 51, l + 5, 178, 5, i1*4,35);//圖要放的位置,原圖位置,大小
		

	}
}
