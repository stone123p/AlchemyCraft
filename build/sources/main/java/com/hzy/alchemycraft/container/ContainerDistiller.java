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
		this.addSlotToContainer(new Slot(entity, 0, 43, 22));
		this.addSlotToContainer(new Slot(entity, 3, 100, 40));
		//output
		this.addSlotToContainer(new Slot(entity, 2, 129, 40));
		
		//燃料
		this.addSlotToContainer(new Slot(entity, 1, 43, 57));
		for(int i=0;i<3;i++){
			for(int j=0;j<9;j++){
				this.addSlotToContainer(new Slot(inv, j+i*9+9,8+(18*j),84+(18*i)));
			}
		}
		for(int i=0;i<9;i++){
			this.addSlotToContainer(new Slot(inv, i,8+(18*i), 142));
		}

	}
	

	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		for(int i = 0; i < this.crafters.size(); ++i){
			ICrafting craft = (ICrafting) this.crafters.get(i);
			
			if(this.lastCookTime != this.entity.furnaceCookTime){
				craft.sendProgressBarUpdate(this, 0, this.entity.furnaceCookTime);
			}
			
			if(this.lastBurnTime != this.entity.furnaceBurnTime){
				craft.sendProgressBarUpdate(this, 1, this.entity.furnaceBurnTime);
			}
			
			if(this.lastItemBurnTime != this.entity.currentBurnTime){
				craft.sendProgressBarUpdate(this, 2, this.entity.currentBurnTime);
			}
		}
		
		this.lastBurnTime = this.entity.furnaceBurnTime;
		this.lastCookTime = this.entity.furnaceCookTime;
		this.lastItemBurnTime = this.entity.currentBurnTime;
	}
	
	@Override
	public void updateProgressBar(int par1, int par2){
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
	public boolean canInteractWith(EntityPlayer entity) {
		return this.entity.isUseableByPlayer(entity);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int par2){
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(par2);
		
		if(slot != null && slot.getHasStack()){
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			
			if(par2 == 2){
				if(!this.mergeItemStack(itemstack1, 3, 39, true)){
					return null;
				}
				slot.onSlotChange(itemstack1, itemstack);
			}else if(par2 != 1 && par2 != 0){
				if(DistillerRecipes.smelting().getSmeltingResult(itemstack1,0) != null){
					if(!this.mergeItemStack(itemstack1, 0, 1, false)){
						return null;
					}
				}else if(TileEntityDistillerBlock.isItemFuel(itemstack1)){
					if(!this.mergeItemStack(itemstack1, 1, 2, false)){
						return null;
					}
				}else if(par2 >=3 && par2 < 30){
					if(!this.mergeItemStack(itemstack1, 30, 39, false)){
						return null;
					}
				}else if(par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false)){
					return null;
				}
			}else if(!this.mergeItemStack(itemstack1, 3, 39, false)){
				return null;
			}
			if(itemstack1.stackSize == 0){
				slot.putStack((ItemStack)null);
			}else{
				slot.onSlotChanged();
			}
			if(itemstack1.stackSize == itemstack.stackSize){
				return null;
			}
			slot.onPickupFromSlot(player, itemstack1);
		}
		return itemstack;
	}
}
