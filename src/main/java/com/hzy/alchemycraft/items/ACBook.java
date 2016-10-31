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
		this.setUnlocalizedName("AlchemyBook");
		this.setCreativeTab(AlchemyCraft.alchemycraftTab);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		if(world.isRemote){
			FMLNetworkHandler.openGui(player, AlchemyCraft.instance, AlchemyCraft.ACBook_GUIID, world,(int)player.posX, (int)player.posY, (int)player.posZ);
		}
		return itemstack;
	}

}
