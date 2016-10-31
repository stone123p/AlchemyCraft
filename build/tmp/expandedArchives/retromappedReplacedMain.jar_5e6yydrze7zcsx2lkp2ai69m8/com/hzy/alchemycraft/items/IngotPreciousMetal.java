package com.hzy.alchemycraft.items;

import java.awt.List;

import com.hzy.alchemycraft.AlchemyCraft;
import com.hzy.alchemycraft.recipes.LowerConvertRecipes;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class IngotPreciousMetal extends Item {

	public ItemStack ingot = null;
	public int i=0; 

	public String data ="";
	public IngotPreciousMetal() {
		this.func_77637_a(AlchemyCraft.alchemycraftTab);
		this.func_77655_b("ingotPreciousMetal");
	}
		
	@Override
	@SideOnly(Side.CLIENT)
	public boolean func_77636_d(ItemStack ingotStack) {
		return  new LowerConvertRecipes().getIngot(ingotStack) !=null;
	}
	
	@Override
	public void func_77624_a(ItemStack stack, EntityPlayer playerIn, java.util.List<String> tooltip,
			boolean advanced) {
		super.func_77624_a(stack, playerIn, tooltip, advanced);
		if(stack.func_77978_p() !=null){
			if(stack.func_77978_p().func_74764_b("metal")){
				NBTTagCompound nbt = (NBTTagCompound) stack.func_77978_p().func_74781_a("metal");
				tooltip.add(nbt.func_74779_i("m"));
			}
		}
	}



}
