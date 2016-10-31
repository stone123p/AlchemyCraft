package com.hzy.alchemycraft.items;

import com.hzy.alchemycraft.AlchemyCraft;
import com.hzy.alchemycraft.recipes.LowerConvertRecipes;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Soul extends Item {
	public Soul(){
		this.setUnlocalizedName("Soul");
		this.setCreativeTab(AlchemyCraft.alchemycraftTab);  
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack Stack) {
		return  true;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, java.util.List<String> tooltip,
			boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		if(stack.getTagCompound() !=null){
			if(stack.getTagCompound().hasKey("soul")){
				NBTTagCompound nbt = (NBTTagCompound) stack.getTagCompound().getTag("soul");
				tooltip.add(nbt.getString("name"));
			}
		}
	}
}
