package com.hzy.alchemycraft.handler;

import com.hzy.alchemycraft.AlchemyCraft;
import com.hzy.alchemycraft.container.ContainerAlchemyTable;
import com.hzy.alchemycraft.container.ContainerDistiller;
import com.hzy.alchemycraft.gui.GuiACBook;
import com.hzy.alchemycraft.gui.GuiAlchemyTable;
import com.hzy.alchemycraft.gui.GuiDistiller;
import com.hzy.alchemycraft.tileentity.TileEntityAlchemyTable;
import com.hzy.alchemycraft.tileentity.TileEntityDistillerBlock;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler{
	public GuiHandler(){
		NetworkRegistry.INSTANCE.registerGuiHandler(AlchemyCraft.instance, this);
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity=world.func_175625_s(new BlockPos(x, y, z));
		
		if(entity != null){
			switch(ID){
				case AlchemyCraft.Distiller_GUIID:{
					if(entity instanceof TileEntityDistillerBlock ){
						return new ContainerDistiller(player.field_71071_by,(TileEntityDistillerBlock ) entity);
					}
					break;
				}	
				case AlchemyCraft.AlchemyTable_GUIID:{
					if(entity instanceof TileEntityAlchemyTable ){
						return new ContainerAlchemyTable(player.field_71071_by,(TileEntityAlchemyTable) entity);
					}
					break;
				}	
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity=world.func_175625_s(new BlockPos(x, y, z));
		
		if(entity != null){
			switch(ID){
			case AlchemyCraft.Distiller_GUIID:{
				if(entity instanceof TileEntityDistillerBlock ){
					return new GuiDistiller(player.field_71071_by,(TileEntityDistillerBlock ) entity);
				}
				break;
			 }
			case AlchemyCraft.AlchemyTable_GUIID:{
				if(entity instanceof TileEntityAlchemyTable ){
					return new GuiAlchemyTable(player.field_71071_by,(TileEntityAlchemyTable ) entity);
				}
				break;
			}	
			}
			
		}
		if(ID==AlchemyCraft.ACBook_GUIID)return new GuiACBook();
		return null;
	}

}
