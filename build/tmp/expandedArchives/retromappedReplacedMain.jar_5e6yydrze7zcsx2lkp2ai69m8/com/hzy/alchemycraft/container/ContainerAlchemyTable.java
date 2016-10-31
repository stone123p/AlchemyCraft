package com.hzy.alchemycraft.container;

import com.hzy.alchemycraft.tileentity.TileEntityAlchemyTable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerAlchemyTable extends Container {

	TileEntityAlchemyTable entity;
	//HigherPhilosopherStone
	public ContainerAlchemyTable(InventoryPlayer player,TileEntityAlchemyTable entity) {
		this.entity=entity;
		
		this.func_75146_a(new Slot(entity, 0, 83, 24));
		this.func_75146_a(new Slot(entity, 1, 83, 85));
		this.func_75146_a(new Slot(entity, 2,61,46));
		this.func_75146_a(new Slot(entity, 3,105,46));
		//output
		this.func_75146_a(new  Slot(entity, 4, 83,60));
		
		
		for (int i = 0; i < 3; i++) {
			for(int k = 0; k < 9; k++) {
				this.func_75146_a(new Slot(player, k + i * 9 + 9, 8 + k * 18, 139 + i * 18));
			}
		}
		
		for (int i = 0; i < 9; i++) {
			this.func_75146_a(new Slot(player, i, 8 + i * 18, 197));
		}
		
		func_75130_a(entity);
	}
	




	@Override
	public ItemStack func_82846_b(EntityPlayer par1EntityPlayer, int par2) {
		return null;

    }


	@Override
	public boolean func_75145_c(EntityPlayer playerIn) {
		return this.entity.func_70300_a(playerIn);
	}


}
