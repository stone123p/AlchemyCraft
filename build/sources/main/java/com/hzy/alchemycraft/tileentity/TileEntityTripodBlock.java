package com.hzy.alchemycraft.tileentity;


import com.hzy.alchemycraft.recipes.LowerConvertRecipes;

import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class TileEntityTripodBlock extends TileEntity implements  ITickable{
	public int BurningTime=0;
	public int CookTime=200;
	public ItemStack ingot=null;
	public ItemStack food=null;
	public ItemStack CookItem;
	public ItemStack getCookFood(ItemStack food){
		if(food.getItem() instanceof ItemFood){
			return FurnaceRecipes.instance().getSmeltingResult(food);
		}
		return null;
	}
	
	@Override
	public void update() {
		if(CookItem!=null){
			CookItem.stackSize=1;
			if(new LowerConvertRecipes().getIngot(CookItem)!=null){	
				ingot=new LowerConvertRecipes().getIngot(CookItem);
			}
			if(getCookFood(CookItem)!=null){
			food=getCookFood(CookItem);
			}
		}else{
			CookTime=0;
		}
		
		if(BurningTime>0){
			BurningTime--;
			if(ingot!=null||food!=null){
				CookTime++;
			}
			if(CookTime>=200){
				if(ingot!=null)CookItem=ingot;
				if(food!=null)CookItem=food;
			}
		}
	}

	

}
