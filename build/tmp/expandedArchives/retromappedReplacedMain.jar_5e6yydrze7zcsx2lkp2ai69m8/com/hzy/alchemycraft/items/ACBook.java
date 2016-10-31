package com.hzy.alchemycraft.items;

import com.hzy.alchemycraft.AlchemyCraft;
import com.hzy.alchemycraft.gui.GuiACBook;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBook;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;

public class ACBook extends ItemBook{
	public ACBook(){
		this.func_77655_b("AlchemyBook");
		this.func_77637_a(AlchemyCraft.alchemycraftTab);
	}

	@Override
	public ItemStack func_77659_a(ItemStack itemstack, World world, EntityPlayer player) {
		if(world.field_72995_K){
			FMLNetworkHandler.openGui(player, AlchemyCraft.instance, AlchemyCraft.ACBook_GUIID, world,(int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
			
		}
		return itemstack;
	}

}
