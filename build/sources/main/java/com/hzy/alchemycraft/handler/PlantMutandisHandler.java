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
		if(isPlant(Block.getBlockFromItem(bush.getItem())) && pM!=null){
			if(pM.getTagCompound()==null){
				pM.setTagCompound(new NBTTagCompound());
			}
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setString("BushName","藥引："+ bush.getDisplayName());
			nbt.setInteger("BushId", Item.getIdFromItem(bush.getItem()));
			nbt.setInteger("BushMetadata", bush.getItemDamage());
			
			pM.getTagCompound().setTag("mutandisBush", nbt);
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
			if(bush !=Blocks.web && bush instanceof BlockBush )
			for(int i=0;i<bushTypes.length;i++){
				if(bush.getRenderType()==bushTypes[i])return true;
			}
		}
		return false;
	}

}
