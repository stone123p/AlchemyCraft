package com.hzy.alchemycraft;

import com.hzy.alchemycraft.blocks.ACBlocks;
import com.hzy.alchemycraft.enetities.ACEntity;
import com.hzy.alchemycraft.event.EnchEvent;
import com.hzy.alchemycraft.event.PotionEvent;
import com.hzy.alchemycraft.handler.CraftingHandler;
import com.hzy.alchemycraft.handler.GenerateHandler;
import com.hzy.alchemycraft.handler.GuiHandler;
import com.hzy.alchemycraft.items.ACItems;
import com.hzy.alchemycraft.potions.FlyingEffect;
import com.hzy.alchemycraft.proxy.CommonProxy;
import com.hzy.alchemycraft.tileentity.TileEntityDistillerBlock;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = AlchemyCraft.MODID,name = AlchemyCraft.NAME,version = AlchemyCraft.VERSION)
public class AlchemyCraft {
	public static final String MODID = "alchemycraft";
	public static final String NAME = "AlchemyCraft";
	public static final String VERSION = "1.3.2";
	
    public static final int  Distiller_GUIID = 0;
    public static final int  AlchemyTable_GUIID = 1;
    public static final int  ACBook_GUIID = 2;
	
	@Instance
    public static AlchemyCraft instance;
	
	@SidedProxy(clientSide="com.hzy.alchemycraft.proxy.ClientProxy",serverSide="com.hzy.alchemycraft.proxy.CommonProxy")
    public static CommonProxy nealeProxy;
    
    //seting Tab
	public static CreativeTabs alchemycraftTab = new CreativeTabs("alchemycraftTab"){
		@Override
		public Item func_78016_d() {
			return Item.func_150898_a(ACBlocks.Peacebloom); 
		}
	};
	public static Potion Flying=new FlyingEffect(25,new ResourceLocation("flying"),false,0).func_76399_b(0, 0)
    		.func_76390_b(StatCollector.func_74838_a("effect.flying.name"));
	
	@EventHandler
    public void init(FMLInitializationEvent event){
		ACBlocks.registerBlocks();
		ACItems.registerItems();
		ACEntity.mainRegistry();
		GenerateHandler.register();
		CraftingHandler.register();
		new GuiHandler();
		MinecraftForge.EVENT_BUS.register(new PotionEvent());
		MinecraftForge.EVENT_BUS.register(new EnchEvent());
		nealeProxy.registerRenders();
		nealeProxy.registerTileEntitys();
		
    }

}
