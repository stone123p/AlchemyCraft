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
		this.setCreativeTab(AlchemyCraft.alchemycraftTab);
		this.setUnlocalizedName("ingotPreciousMetal");
	}
		
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack ingotStack) {
		return  new LowerConvertRecipes().getIngot(ingotStack) !=null;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, java.util.List<String> tooltip,
			boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		if(stack.getTagCompound() !=null){
			if(stack.getTagCompound().hasKey("metal")){
				NBTTagCompound nbt = (NBTTagCompound) stack.getTagCompound().getTag("metal");
				tooltip.add(nbt.getString("m"));
			}
		}
	}



}
