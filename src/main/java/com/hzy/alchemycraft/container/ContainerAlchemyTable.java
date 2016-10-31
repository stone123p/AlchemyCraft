package com.hzy.alchemycraft.container;

import com.hzy.alchemycraft.tileentity.TileEntityAlchemyTable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceOutput;
import net.minecraft.item.ItemStack;

public class ContainerAlchemyTable extends Container {

	TileEntityAlchemyTable entity;
	//HigherPhilosopherStone
	public ContainerAlchemyTable(InventoryPlayer player,TileEntityAlchemyTable entity) {
		this.entity=entity;
		
		this.addSlotToContainer(new Slot(entity, 0, 83, 24));
		this.addSlotToContainer(new Slot(entity, 1, 83, 85));
		this.addSlotToContainer(new Slot(entity, 2,61,46));
		this.addSlotToContainer(new Slot(entity, 3,105,46));
		//output
		this.addSlotToContainer(new SlotFurnaceOutput(player.player,entity, 4, 83,60));
		
		
		for (int i = 0; i < 3; i++) {
			for(int k = 0; k < 9; k++) {
				this.addSlotToContainer(new Slot(player, k + i * 9 + 9, 8 + k * 18, 139 + i * 18));
			}
		}
		
		for (int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(player, i, 8 + i * 18, 197));
		}
		
		onCraftMatrixChanged(entity);
	}
	




	@Override
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
		return null;

    }


	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return this.entity.isUseableByPlayer(playerIn);
	}


}
