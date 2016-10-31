package com.hzy.alchemycraft.renderer;

import java.util.Map;

import org.lwjgl.opengl.GL11;

import com.google.common.collect.Maps;
import com.hzy.alchemycraft.blocks.ACBlocks;
import com.hzy.alchemycraft.tileentity.TileEntityDistillerBlock;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;

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
	@Override public void func_179022_a(ItemStack itemStack) {
		Block block = Block.func_149634_a(itemStack.func_77973_b());
		
		if (block == ACBlocks.Distiller) {
			
			TileEntityRendererDispatcher.field_147556_a.func_147549_a(itemRenders.get(0), 0.0D, 0.0D, 0.0D, 0.0F);
		} else {
			super.func_179022_a(itemStack);
		}
	}

}
