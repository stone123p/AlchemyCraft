package com.hzy.alchemycraft.recipes;

import com.hzy.alchemycraft.items.ACItems;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class Resurrection{
	
	public  Resurrection(){
		
	}

	public ItemStack getEgg(ItemStack[] itemStacks) {
		if(itemStacks[1] != null && itemStacks[2] != null&&itemStacks[3] != null){
			if(itemStacks[1].getItem().equals(ACItems.Soul)&&itemStacks[2].getItem().equals(ACItems.CorpseOilBottle)&&itemStacks[3].getItem().equals( ACItems.RegenerationPotion)){
					ItemStack SoulStack = itemStacks[1];
					if(SoulStack.getTagCompound() !=null){
						if(SoulStack.getTagCompound().hasKey("soul")){
							NBTTagCompound nbt = (NBTTagCompound) SoulStack.getTagCompound().getTag("soul");
							return new ItemStack(Items.spawn_egg,1,nbt.getInteger("id"));
						}
					}
			}
		}
		return null;
	}
	public ItemStack getEgg(ItemStack SoulStack){
	
		if(SoulStack.getTagCompound() !=null){
			if(SoulStack.getTagCompound().hasKey("soul")){
				NBTTagCompound nbt = (NBTTagCompound) SoulStack.getTagCompound().getTag("soul");
				return new ItemStack(Items.spawn_egg,1,nbt.getInteger("id"));
			}
		}
		return null;
	}
}
