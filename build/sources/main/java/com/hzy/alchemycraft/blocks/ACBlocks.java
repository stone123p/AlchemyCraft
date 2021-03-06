package com.hzy.alchemycraft.blocks;

import com.hzy.alchemycraft.AlchemyCraft;
import com.hzy.alchemycraft.model.ModelDistiller;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ACBlocks {
	public ACBlocks(){
		
	}
	
	//setting Herbs 
	public static  BlockBush Peacebloom =  new Herbs("Peacebloom");
	public static  BlockBush Silverleaf=  new Herbs("Silverleaf"); 	
    public static  BlockBush Earthroot=  new Herbs("Earthroot"); 		
    public static  BlockBush Swiftthistle= new Herbs("Swiftthistle");	    
    public static  BlockBush Cinderpearl= new CHerbs("Cinderpearl"); 	
    public static  BlockBush Mageroyal= new Herbs("Mageroyal");       
    public static  BlockBush Briarthorn = new Herbs("Briarthorn");      
    public static  BlockBush Bruiseweed= new Herbs("Bruiseweed");     
    public static  BlockBush Fadeleaf= new Herbs("Fadeleaf");			   
    public static  BlockBush Goldthorn= new Herbs("Goldthorn");		    
    public static  BlockBush Kingsblood= new Herbs("Kingsblood");		
    public static  BlockBush Stranglekelp= new Herbs("Stranglekelp");	
    public static  BlockBush WildSteelbloom= new Herbs("WildSteelbloom");
	
    //setting Others
    public static  Block Tripod =new Tripod(Material.rock);
    public static  Block Distiller = new Distiller(Material.rock);
    public static  Block Diffuser = new Diffuser(Material.rock);
    public static  Block AlchemyTable= new AlchemyTable(Material.rock);
  
    //setting Ore
    public static  Block oreStannite=new OreSetting("oreStannite") ;
    public static  Block oreCuprite =new OreSetting("oreCuprite") ;
    public static  Block oreGalena= new OreSetting("oreGalena") ;
    
    @EventHandler
	public static void registerBlocks(){	
    	//register Herbs
    	registerBlock(Peacebloom);
    	registerBlock(Silverleaf); 	
    	registerBlock(Earthroot); 		
    	registerBlock(Swiftthistle);	    
    	registerBlock(Cinderpearl); 	
    	registerBlock(Mageroyal);       
    	registerBlock(Briarthorn);      
    	registerBlock(Bruiseweed);     
    	registerBlock(Fadeleaf);			   
    	registerBlock(Goldthorn);		    
    	registerBlock(Kingsblood);		
    	registerBlock(Stranglekelp);	
    	registerBlock(WildSteelbloom);
    	
    	registerBlock(Distiller);
    	registerBlock(Diffuser);
    	registerBlock(Tripod);
    	registerBlock(AlchemyTable);
    	
    	registerBlock(oreStannite);
    	registerBlock(oreCuprite);
    	registerBlock(oreGalena);
	}
    public static void registerRenders(){
    	//register Herbs
    	registerRender(Peacebloom);
    	registerRender(Silverleaf); 	
    	registerRender(Earthroot); 		
    	registerRender(Swiftthistle);	    
    	registerRender(Cinderpearl); 	
    	registerRender(Mageroyal);       
    	registerRender(Briarthorn);      
    	registerRender(Bruiseweed);     
    	registerRender(Fadeleaf);			   
    	registerRender(Goldthorn);		    
    	registerRender(Kingsblood);		
    	registerRender(Stranglekelp);	
    	registerRender(WildSteelbloom);

    	
    	registerRender(oreStannite);
    	registerRender(oreCuprite);
    	registerRender(oreGalena);
    	
    	registerRender(Distiller);
    	registerRender(Diffuser);
    	registerRender(Tripod);
    	registerRender(AlchemyTable);
    }
    
    public static void registerBlock(Block block){
    	GameRegistry.registerBlock(block,block.getUnlocalizedName().substring(5));
    }
    
	public static void registerRender(Block block){	
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
	    .register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(AlchemyCraft.MODID+":"+block.getUnlocalizedName().substring(5), "inventory"));	
	}
}
