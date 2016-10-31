package com.hzy.alchemycraft.recipes;

import java.util.List;

import com.hzy.alchemycraft.items.ACItems;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.OreDictionary;

public class DistillerRecipes {
	private static final DistillerRecipes SMELTING_BASE = new DistillerRecipes();
	public static ItemStack[] RecipesList = {
			 new ItemStack(ACItems.DistilledMaterialBottle[0]) , new ItemStack(ACItems.MinorHealingPotion),
			 new ItemStack(ACItems.DistilledMaterialBottle[1]) , new ItemStack(ACItems.ElixirofMinorFortitude),
			 new ItemStack(ACItems.DistilledMaterialBottle[2]) , new ItemStack(ACItems.ElixirofMinorAgility),
			 new ItemStack(ACItems.DistilledMaterialBottle[3]) , new ItemStack(ACItems.ElixirofMinorDefense),
			 new ItemStack(ACItems.DistilledMaterialBottle[4]) , new ItemStack(ACItems.ElixirofMinorStrength),
			 new ItemStack(ACItems.DistilledMaterialBottle[5]) , new ItemStack(ACItems.ElixirofMinorInvisibility),
			 new ItemStack(ACItems.DistilledMaterialBottle[6]) , new ItemStack(ACItems.ElixirofMinorWaterBreathing),
			 new ItemStack(ACItems.DistilledMaterialBottle[7]) , new ItemStack(ACItems.ElixirofMinorNightVision),
			 new ItemStack(ACItems.DistilledMaterialBottle[8]) , new ItemStack(ACItems.HealingPotion),
			 new ItemStack(ACItems.DistilledMaterialBottle[9]) , new ItemStack(ACItems.FortitudePotion),
			 new ItemStack(ACItems.DistilledMaterialBottle[10]) , new ItemStack(ACItems.AgilityPotion),
			 new ItemStack(ACItems.DistilledMaterialBottle[11]) , new ItemStack(ACItems.DefensePotion),
			 new ItemStack(ACItems.DistilledMaterialBottle[12]) , new ItemStack(ACItems.StrengthPotion),
			 new ItemStack(ACItems.DistilledMaterialBottle[13]) , new ItemStack(ACItems.InvisibilityPotion),
			 new ItemStack(ACItems.DistilledMaterialBottle[14]) , new ItemStack(ACItems.WaterBreathingPotion),
			 new ItemStack(ACItems.DistilledMaterialBottle[15]) , new ItemStack(ACItems.NightVisionPotion),
			 new ItemStack(ACItems.DistilledMaterialBottle[16]) , new ItemStack(ACItems.FireResistancePotion),
			 new ItemStack(ACItems.DistilledMaterialBottle[17]) , new ItemStack(ACItems.PurifyPotion),
			 new ItemStack(ACItems.DistilledMaterialBottle[18]) , new ItemStack(ACItems.RegenerationPotion),
			 new ItemStack(ACItems.DistilledMaterialBottle[19]) , new ItemStack(ACItems.FlyingPotion),
			 new ItemStack(ACItems.DistilledMaterialBottle[20]) , new ItemStack(ACItems.LovePotion),
			 
			 new ItemStack(ACItems.DistilledMaterialBottle[21]) , new ItemStack(ACItems.PsychePotion), 
			 new ItemStack(ACItems.DistilledMaterialBottle[22]) , new ItemStack(ACItems.FishOilBottle),
			 new ItemStack(ACItems.DistilledMaterialBottle[23]) , new ItemStack(ACItems.CorpseOilBottle),
			 new ItemStack(ACItems.DistilledMaterialBottle[24]) , new ItemStack(ACItems.WitherOilBottle),
			 new ItemStack(ACItems.DistilledMaterialBottle[25]) , new ItemStack(ACItems.WitherOilBottle),
			 new ItemStack(ACItems.DistilledMaterialBottle[26]) , new ItemStack(ACItems.YinYangOilBottle),
			 new ItemStack(ACItems.DistilledMaterialBottle[27]) , new ItemStack(ACItems.FireOilBottle),
			 new ItemStack(ACItems.DistilledMaterialBottle[28]) , new ItemStack(ACItems.FireOilBottle),
			 new ItemStack(ACItems.DistilledMaterialBottle[29]) , new ItemStack(ACItems.GrowthOilBottle),
			 new ItemStack(ACItems.DistilledMaterialBottle[30]) , new ItemStack(ACItems.ConversionOilBottle),
			 new ItemStack(ACItems.DistilledMaterialBottle[31]) , new ItemStack(ACItems.FrostOilBottle),
			 new ItemStack(ACItems.DistilledMaterialBottle[32]) , new ItemStack(ACItems.PoisonOilBottle),
			 new ItemStack(ACItems.DistilledMaterialBottle[33]) , new ItemStack(ACItems.ProdigyOilBottle),
			 
	};


	public static DistillerRecipes smelting() {
		return SMELTING_BASE;
	}
	
	public DistillerRecipes(){
	}

	public ItemStack getSmeltingResult(ItemStack furnaceItemStacks,int index) {
		ItemStack[] Recipes=new ItemStack[6];
		for(int i=0;i<DistillerRecipes.RecipesList.length;i=i+2){
			if(furnaceItemStacks.getItem()==RecipesList[i].getItem()){
				Recipes[0]=RecipesList[i+1];
				
			}
		}
		if(furnaceItemStacks.getItem()==ACItems.PotionDistilledBottle){
			if(furnaceItemStacks.getTagCompound() !=null){
				if(furnaceItemStacks.getTagCompound().hasKey("potion")){
					NBTTagCompound nbt = (NBTTagCompound) furnaceItemStacks.getTagCompound().getTag("potion");
					int i=nbt.getInteger("size")-1;
					if(nbt.getInteger("n_"+i)>=StandardMole(Item.getItemById(nbt.getInteger("id_"+i)))){
						Recipes[0]=new ItemStack(Item.getItemById(nbt.getInteger("id_"+i)));
					}else{
						Recipes[0]=new ItemStack(Items.potionitem,1,0);
					}
				}
			}
		}
		return Recipes[index];
	}
	public int StandardMole(Item potion){
		if(potion==Items.potionitem)return 8;
		return (Item.getIdFromItem(potion)-Item.getIdFromItem(ACItems.MinorHealingPotion)>8)?8:4;
	}
}
