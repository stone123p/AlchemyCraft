package com.hzy.alchemycraft.renderer;

import java.util.Map;

import org.lwjgl.opengl.GL11;

import com.google.common.collect.Maps;
import com.hzy.alchemycraft.blocks.ACBlocks;
import com.hzy.alchemycraft.tileentity.TileEntityDistillerBlock;


import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class ItemRenderBlock extends TileEntityItemStackRenderer{
	private Map<Integer, TileEntityDistillerBlock> itemRenders = Maps.newHashMap();
	public ItemRenderBlock(){
		
	}
	@Override public void renderByItem(ItemStack itemStack) {
		Block block = Block.getBlockFromItem(itemStack.getItem());
		
		if (block == ACBlocks.Distiller) {
			
			TileEntityRendererDispatcher.instance.renderTileEntityAt(itemRenders.get(0), 0.0D, 0.0D, 0.0D, 0.0F);
		} else {
			super.renderByItem(itemStack);
		}
	}

}
