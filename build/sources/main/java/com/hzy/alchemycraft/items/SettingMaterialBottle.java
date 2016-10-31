package com.hzy.alchemycraft.items;

import java.util.List;

import com.hzy.alchemycraft.AlchemyCraft;
import com.hzy.alchemycraft.handler.LibHandler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class SettingMaterialBottle extends Item {

	private String[] materials;

	public SettingMaterialBottle(int i){

		materials = LibHandler.getMaterials(i);
		setUnlocalizedName("DistilledMaterialBottle");
		setCreativeTab(AlchemyCraft.alchemycraftTab);
		setMaxStackSize(1);
		setMaxDamage(3);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		
		String name="";
		for(int i=0;i<this.materials.length;i++){
			tooltip.add(StatCollector.translateToLocal(this.materials[i]));
		}
	}

}
