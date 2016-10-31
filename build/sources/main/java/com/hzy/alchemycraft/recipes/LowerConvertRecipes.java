package com.hzy.alchemycraft.recipes;

import java.util.ArrayList;
import java.util.List;

import com.hzy.alchemycraft.items.ACItems;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.OreDictionary;

public class LowerConvertRecipes {
public LowerConvertRecipes(){
		
	}
	public String getMetalName(ItemStack  NuggetStack){
		String NuggetOreName = OreDictionary.getOreName(OreDictionary.getOreIDs(NuggetStack)[0]);
		if(NuggetOreName.indexOf("nugget")!=-1){
			String MetalName=NuggetOreName.substring(NuggetOreName.indexOf("nugget")+6);
			return MetalName;
		}
		return "XXX";
	}
	public Item getIngot(String MetalName){
		if(MetalName !="XXX"){
			if(!OreDictionary.getOres("ingot"+MetalName).isEmpty())
			return OreDictionary.getOres("ingot"+MetalName).get(0).getItem();
		}
		return null;
	}
	public ItemStack getPreciousMetals(String MetalName){
		if(MetalName !="XXX"){
			ItemStack ingotStack =new ItemStack(ACItems.ingotPreciousMetal);
			if(ingotStack.getTagCompound()==null){
				ingotStack.setTagCompound(new NBTTagCompound());
			}
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setString("m","賦予靈氣：" + MetalName);
			ingotStack.getTagCompound().setTag("metal", nbt);
			return  ingotStack ;
		}
		return null;
	}
	public ItemStack getIngot(ItemStack PreciousMetals){
		String I="ingot";
		if(PreciousMetals.getTagCompound() !=null){
			if(PreciousMetals.getTagCompound().hasKey("metal")){
				NBTTagCompound nbt = (NBTTagCompound) PreciousMetals.getTagCompound().getTag("metal");
				List<ItemStack> FinElementList=OreDictionary.getOres(I.concat(nbt.getString("m").substring(5)));
				if(!FinElementList.isEmpty()){
					return FinElementList.get(0);
				}
			}
		}
		return null;
	}
}
