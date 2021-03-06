package com.hzy.alchemycraft.recipes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ConvertRecipes {
	public static String[] element=new String[93];	
	public static void ConvertRecipe(){
		
		
	}
	public static void SetElements(){
		element[3]="Lithium,ingot,dust,nugget,ore";
		element[6]="Coal,item,dust,XXX,ore";
		element[13]="Aluminum,ingot,dust,nugget,ore";
		element[15]="Glowstone,dust,dust,XXX,XXX";
		element[16]="Sulfur,dust,dust,XXX,ore";
		element[22]="Titanium,ingot,dust,nugget,ore";
		element[23]="Vanadium,ingot,dust,nugget,ore";
		element[24]="Chromium,ingot,dust,nugget,ore";
		element[25]="Manganese,ingot,dust,nugget,ore";
		element[26]="Iron,ingot,dust,nugget,ore";
		element[27]="Cobalt,ingot,dust,nugget,ore";
		element[28]="Nickel,ingot,dust,nugget,ore";
		element[29]="Copper,ingot,dust,nugget,ore";
		element[30]="Zinc,ingot,dust,nugget,ore";
		element[39]="Yttrium,ingot,dust,nugget,ore";
		element[42]="Molybdenum,ingot,dust,nugget,ore";
		element[50]="Tin,ingot,dust,nugget,ore";
		element[46]="Palladium,ingot,dust,nugget,ore";
		element[47]="Silver,ingot,dust,nugget,ore";
		element[74]="Tungsten,ingot,dust,nugget,ore";
		element[76]="Osmium,ingot,dust,nugget,ore";
		element[77]="Iridium,ingot,dust,nugget,oreItem";
		element[78]="Platinum,ingot,dust,nugget,ore";
		element[79]="Gold,ingot,dust,nugget,ore";
		element[82]="Lead,ingot,dust,nugget,ore";
		element[83]="Bismuth,ingot,dust,nugget,ore";
		element[92]="Uranium,ingot,dust,nugget,ore";
	}
	public static int getElementIndex(ItemStack itemStack){
		SetElements();

		if(OreDictionary.getOreIDs(itemStack).length==0)return -1;
		String ElementName=OreDictionary.getOreName(OreDictionary.getOreIDs(itemStack)[0]);
		String M="";
		int j=-1;
		for(int i=0;i<element.length;i++){
			if(element[i] ==null)element[i]="XXX,XXX";
			M=element[i].split(",")[0].toLowerCase();
			if(ElementName.toLowerCase().indexOf(M)!=-1){
				j=i;
				break;
			}
		}
		if(itemStack.getItem()==Items.glowstone_dust)j=15;
		if(itemStack.getItem()==Items.coal)j=6;
		return j;
	}
	public static ItemStack getFinElement(int i, String type){
		SetElements();
		String M="";
			
		if(element[i] ==null)return null;
			M=element[i].split(",")[0];
			if(i<element.length){
				List<ItemStack> FinElementList = OreDictionary.getOres(type.concat(M));
			
				if(!FinElementList.isEmpty()){
					return FinElementList.get(0).copy();
				}
				if(type.concat(M).equals("itemCoal"))return new ItemStack(Items.coal);
			}
		
		return null;
	}
	public String getElementType(ItemStack itemStack,int index) {
		String ElementName=new String(itemStack.getUnlocalizedName());
		String type="XXX";
		if(index>=0)
		for(int i=1;i<element[index].split(",").length;i++){
			if(ElementName.toLowerCase().indexOf(element[index].split(",")[i])!=-1){
				type=element[index].split(",")[i];
				break;
			}
		}
		;
		return type;
	}
}
