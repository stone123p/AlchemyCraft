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
			GameRegistry.addRecipe(new ItemStack(ACItems.DistilledBottle,1), new Object[] {" w ","G G","GGG",'G',Item.func_150898_a(Blocks.field_150359_w),'w',new ItemStack(Blocks.field_150344_f,1,i)});
  
		for(int i=0;i<ACItems.DistilledMaterialBottle.length;i++) 
    		GameRegistry.addShapelessRecipe(new ItemStack(ACItems.DistilledMaterialBottle[i]),new LibHandler().getRecipes(i));
    	
		GameRegistry.addRecipe(new ItemStack(ACBlocks.Tripod), new Object[] {"isi","ibi",'i',Items.field_151042_j,'b',Items.field_151054_z,'s',Items.field_151119_aD});
    	GameRegistry.addRecipe(new ItemStack(ACBlocks.Diffuser), new Object[] {"b b","bbb","bcb",'b',Items.field_151118_aC,'c',Items.field_151065_br});
    	GameRegistry.addRecipe(new ItemStack(ACBlocks.Distiller), new Object[] {"iii","m i","f  ",'i',Items.field_151042_j,'m',Items.field_151067_bt,'f',ACBlocks.Tripod});
    	GameRegistry.addRecipe(new ItemStack(ACBlocks.AlchemyTable), new Object[] {"aba","ccc","ccc",'a',Blocks.field_150371_ca,'b',new ItemStack(Items.field_151100_aR,1,5),'c',Blocks.field_150343_Z});
    	GameRegistry.addShapelessRecipe(new ItemStack(ACItems.AlchemyBook),new Object[]{Items.field_151122_aG,ACBlocks.Peacebloom,ACBlocks.Silverleaf,ACBlocks.Earthroot});
    	GameRegistry.addSmelting(ACBlocks.oreStannite, new ItemStack(ACItems.ingotTin), 3f);
    	GameRegistry.addSmelting(ACBlocks.oreCuprite, new ItemStack(ACItems.ingotCopper), 3f);
    	GameRegistry.addSmelting(ACBlocks.oreGalena, new ItemStack(ACItems.ingotLead), 3f);
    	GameRegistry.addSmelting(new ItemStack(ACItems.baseMetalMixture), new ItemStack(ACItems.ingotBaseMetal,4), 3f);
    	GameRegistry.addShapelessRecipe(new ItemStack(ACItems.baseMetalMixture),  new Object[] {ACItems.ingotTin,ACItems.ingotCopper,ACItems.ingotLead,Items.field_151042_j});
    	
    	OreDictionary.registerOre("ingotTin",ACItems.ingotTin);
    	OreDictionary.registerOre("ingotCopper",ACItems.ingotCopper);
    	OreDictionary.registerOre("ingotLead",ACItems.ingotLead);
    	OreDictionary.registerOre("oreTin",ACBlocks.oreStannite);
    	OreDictionary.registerOre("oreCopper",ACBlocks.oreCuprite);
    	OreDictionary.registerOre("oreLead",ACBlocks.oreGalena);

	}
}
