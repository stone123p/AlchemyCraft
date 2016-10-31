package com.hzy.alchemycraft.handler;

import com.hzy.alchemycraft.items.ACItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class PlantMutandisHandler {
	public PlantMutandisHandler(){
		
	}
	public ItemStack getMutandis(ItemStack bush){
		ItemStack pM=new ItemStack(ACItems.plantMutandis,8);
		if(isPlant(Block.func_149634_a(bush.func_77973_b())) && pM!=null){
			if(pM.func_77978_p()==null){
				pM.func_77982_d(new NBTTagCompound());
			}
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.func_74778_a("BushName","藥引："+ bush.func_82833_r());
			nbt.func_74768_a("BushId", Item.func_150891_b(bush.func_77973_b()));
			nbt.func_74768_a("BushMetadata", bush.func_77952_i());
			
			pM.func_77978_p().func_74782_a("mutandisBush", nbt);
			return  pM ;
		}
		return null;
	}
	public Block getBush(){
		return null;
		
	}
	public boolean isPlant(Block bush){
		int[] bushTypes=new int[]{1,3,13,20,23,40};
		if(bush !=null){
			if(bush !=Blocks.field_150321_G && bush instanceof BlockBush )
			for(int i=0;i<bushTypes.length;i++){
				if(bush.func_149645_b()==bushTypes[i])return true;
			}
		}
		return false;
	}

}
