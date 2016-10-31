package com.hzy.alchemycraft.container;


import com.hzy.alchemycraft.recipes.DistillerRecipes;
import com.hzy.alchemycraft.tileentity.TileEntityDistillerBlock;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerDistiller extends Container{


	private TileEntityDistillerBlock entity;
	private int lastCookTime;
	private int lastBurnTime;
	private int lastItemBurnTime;
	
	
	public ContainerDistiller(InventoryPlayer inv,TileEntityDistillerBlock entity){
		this.entity=entity;
		//input
		this.func_75146_a(new Slot(entity, 0, 43, 22));
		this.func_75146_a(new Slot(entity, 3, 100, 40));
		//output
		this.func_75146_a(new Slot(entity, 2, 129, 40));
		
		//燃料
		this.func_75146_a(new Slot(entity, 1, 43, 57));
		for(int i=0;i<3;i++){
			for(int j=0;j<9;j++){
				this.func_75146_a(new Slot(inv, j+i*9+9,8+(18*j),84+(18*i)));
			}
		}
		for(int i=0;i<9;i++){
			this.func_75146_a(new Slot(inv, i,8+(18*i), 142));
		}

	}
	

	@Override
	public void func_75142_b() {
		super.func_75142_b();
		for(int i = 0; i < this.field_75149_d.size(); ++i){
			ICrafting craft = (ICrafting) this.field_75149_d.get(i);
			
			if(this.lastCookTime != this.entity.furnaceCookTime){
				craft.func_71112_a(this, 0, this.entity.furnaceCookTime);
			}
			
			if(this.lastBurnTime != this.entity.furnaceBurnTime){
				craft.func_71112_a(this, 1, this.entity.furnaceBurnTime);
			}
			
			if(this.lastItemBurnTime != this.entity.currentBurnTime){
				craft.func_71112_a(this, 2, this.entity.currentBurnTime);
			}
		}
		
		this.lastBurnTime = this.entity.furnaceBurnTime;
		this.lastCookTime = this.entity.furnaceCookTime;
		this.lastItemBurnTime = this.entity.currentBurnTime;
	}
	
	@Override
	public void func_75137_b(int par1, int par2){
		if(par1 == 0){
			this.entity.furnaceCookTime = par2;
		}
		
		if(par1 == 1){
			this.entity.furnaceBurnTime = par2;
		}
		
		if(par1 == 2){
			this.entity.currentBurnTime = par2;
		}
	}
	
	@Override
	public boolean func_75145_c(EntityPlayer entity) {
		return this.entity.func_70300_a(entity);
	}
	
	@Override
	public ItemStack func_82846_b(EntityPlayer player, int par2){
		ItemStack itemstack = null;
		Slot slot = (Slot) this.field_75151_b.get(par2);
		
		if(slot != null && slot.func_75216_d()){
			ItemStack itemstack1 = slot.func_75211_c();
			itemstack = itemstack1.func_77946_l();
			
			if(par2 == 2){
				if(!this.func_75135_a(itemstack1, 3, 39, true)){
					return null;
				}
				slot.func_75220_a(itemstack1, itemstack);
			}else if(par2 != 1 && par2 != 0){
				if(DistillerRecipes.smelting().getSmeltingResult(itemstack1,0) != null){
					if(!this.func_75135_a(itemstack1, 0, 1, false)){
						return null;
					}
				}else if(TileEntityDistillerBlock.isItemFuel(itemstack1)){
					if(!this.func_75135_a(itemstack1, 1, 2, false)){
						return null;
					}
				}else if(par2 >=3 && par2 < 30){
					if(!this.func_75135_a(itemstack1, 30, 39, false)){
						return null;
					}
				}else if(par2 >= 30 && par2 < 39 && !this.func_75135_a(itemstack1, 3, 30, false)){
					return null;
				}
			}else if(!this.func_75135_a(itemstack1, 3, 39, false)){
				return null;
			}
			if(itemstack1.field_77994_a == 0){
				slot.func_75215_d((ItemStack)null);
			}else{
				slot.func_75218_e();
			}
			if(itemstack1.field_77994_a == itemstack.field_77994_a){
				return null;
			}
			slot.func_82870_a(player, itemstack1);
		}
		return itemstack;
	}
}