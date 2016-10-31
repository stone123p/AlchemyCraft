package com.hzy.alchemycraft.items;

import java.util.List;

import com.hzy.alchemycraft.AlchemyCraft;
import com.hzy.alchemycraft.handler.LibHandler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;

public class PotionDistilledBottle extends Item {
	public PotionDistilledBottle(){

		setUnlocalizedName("PotionDistilledBottle");
		setCreativeTab(AlchemyCraft.alchemycraftTab);
		setMaxStackSize(1);
		
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		
		if(stack.getTagCompound() !=null){
			if(stack.getTagCompound().hasKey("potion")){
				
				NBTTagCompound nbt = (NBTTagCompound) stack.getTagCompound().getTag("potion");
				int totalDamage=0;
				
				for(int i=0;i<nbt.getInteger("size");i++){
					tooltip.add(nbt.getString("name_"+i)+" : "+nbt.getInteger("n_"+i)+" mol");
				}
			}
		}
	}

}
