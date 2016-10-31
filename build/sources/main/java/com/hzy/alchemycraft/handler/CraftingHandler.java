package com.hzy.alchemycraft.handler;

import com.hzy.alchemycraft.blocks.ACBlocks;
import com.hzy.alchemycraft.items.ACItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class CraftingHandler {
	@EventHandler
	public static void register(){
		for(int i=0;i<6;i++)
			GameRegistry.addRecipe(new ItemStack(ACItems.DistilledBottle,1), new Object[] {" w ","G G","GGG",'G',Item.getItemFromBlock(Blocks.glass),'w',new ItemStack(Blocks.planks,1,i)});
  
		for(int i=0;i<ACItems.DistilledMaterialBottle.length;i++) 
    		GameRegistry.addShapelessRecipe(new ItemStack(ACItems.DistilledMaterialBottle[i]),new LibHandler().getRecipes(i));
    	
		GameRegistry.addRecipe(new ItemStack(ACBlocks.Tripod), new Object[] {"isi","ibi",'i',Items.iron_ingot,'b',Items.bowl,'s',Items.clay_ball});
    	GameRegistry.addRecipe(new ItemStack(ACBlocks.Diffuser), new Object[] {"b b","bbb","bcb",'b',Items.brick,'c',Items.blaze_powder});
    	GameRegistry.addRecipe(new ItemStack(ACBlocks.Distiller), new Object[] {"iii","m i","f  ",'i',Items.iron_ingot,'m',Items.brewing_stand,'f',ACBlocks.Tripod});
    	GameRegistry.addRecipe(new ItemStack(ACBlocks.AlchemyTable), new Object[] {"aba","ccc","ccc",'a',Blocks.quartz_block,'b',new ItemStack(Items.dye,1,5),'c',Blocks.obsidian});
    	GameRegistry.addShapelessRecipe(new ItemStack(ACItems.AlchemyBook),new Object[]{Items.book,ACBlocks.Peacebloom,ACBlocks.Silverleaf,ACBlocks.Earthroot});
    	GameRegistry.addSmelting(ACBlocks.oreStannite, new ItemStack(ACItems.ingotTin), 3f);
    	GameRegistry.addSmelting(ACBlocks.oreCuprite, new ItemStack(ACItems.ingotCopper), 3f);
    	GameRegistry.addSmelting(ACBlocks.oreGalena, new ItemStack(ACItems.ingotLead), 3f);
    	GameRegistry.addSmelting(new ItemStack(ACItems.baseMetalMixture), new ItemStack(ACItems.ingotBaseMetal,4), 3f);
    	GameRegistry.addShapelessRecipe(new ItemStack(ACItems.baseMetalMixture),  new Object[] {ACItems.ingotTin,ACItems.ingotCopper,ACItems.ingotLead,Items.iron_ingot});
    	
    	OreDictionary.registerOre("ingotTin",ACItems.ingotTin);
    	OreDictionary.registerOre("ingotCopper",ACItems.ingotCopper);
    	OreDictionary.registerOre("ingotLead",ACItems.ingotLead);
    	OreDictionary.registerOre("oreTin",ACBlocks.oreStannite);
    	OreDictionary.registerOre("oreCopper",ACBlocks.oreCuprite);
    	OreDictionary.registerOre("oreLead",ACBlocks.oreGalena);

	}
}
