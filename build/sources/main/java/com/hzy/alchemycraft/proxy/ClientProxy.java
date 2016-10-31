package com.hzy.alchemycraft.proxy;

import com.hzy.alchemycraft.AlchemyCraft;
import com.hzy.alchemycraft.blocks.ACBlocks;
import com.hzy.alchemycraft.items.ACItems;
import com.hzy.alchemycraft.model.ModelDistiller;
import com.hzy.alchemycraft.renderer.ItemRenderBlock;
import com.hzy.alchemycraft.renderer.RenderDiffuser;
import com.hzy.alchemycraft.renderer.RenderDistiller;
import com.hzy.alchemycraft.renderer.RenderTripod;
import com.hzy.alchemycraft.tileentity.TileEntityDiffuserBlock;
import com.hzy.alchemycraft.tileentity.TileEntityDistillerBlock;
import com.hzy.alchemycraft.tileentity.TileEntityTripodBlock;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ClientProxy  extends CommonProxy{

	@Override
	public void registerRenders() {
		super.registerRenders();

		ACBlocks.registerRenders();
		ACItems.registerRenders();
		
		TileEntitySpecialRenderer render1 = new RenderDistiller();
		TileEntitySpecialRenderer render2 = new RenderTripod();
		TileEntitySpecialRenderer render3 = new RenderDiffuser();
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDistillerBlock.class,render1); 	
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTripodBlock.class,render2); 
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDiffuserBlock.class,render3);
		
		
		
	}
	
	public void registerTileEntitys() {
		GameRegistry.registerTileEntity(TileEntityDistillerBlock.class, "TileEntityDistillerBlock");
		GameRegistry.registerTileEntity(TileEntityTripodBlock.class,"TileEntityTripodBlock");
		GameRegistry.registerTileEntity(TileEntityDiffuserBlock.class,"TileEntityDiffuserBlock");
	}

}
