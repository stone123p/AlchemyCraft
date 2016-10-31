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
		func_77655_b("DistilledMaterialBottle");
		func_77637_a(AlchemyCraft.alchemycraftTab);
		func_77625_d(1);
		func_77656_e(3);
	}

	@Override
	public void func_77624_a(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.func_77624_a(stack, playerIn, tooltip, advanced);
		
		String name="";
		for(int i=0;i<this.materials.length;i++){
			tooltip.add(StatCollector.func_74838_a(this.materials[i]));
		}
	}

}
