package com.hzy.alchemycraft.blocks;

import com.hzy.alchemycraft.AlchemyCraft;
import com.hzy.alchemycraft.tileentity.TileEntityAlchemyTable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class AlchemyTable  extends BlockContainer{


	public AlchemyTable(Material materialIn) {
		super(materialIn);
		this.func_149647_a(AlchemyCraft.alchemycraftTab);
		this.func_149663_c("AlchemyTable");
		this.func_149711_c(3.0F);

	}

	@Override
	public void func_180663_b(World worldIn, BlockPos pos, IBlockState state) {
		super.func_180663_b(worldIn, pos, state);
		worldIn.func_175713_t(pos);
		TileEntityAlchemyTable tileEntity= (TileEntityAlchemyTable)worldIn.func_175625_s(pos);
		if(!worldIn.field_72995_K){
			for(int i=0; i<tileEntity.AlchemyTableItemStack.length;i++){
				if(tileEntity.AlchemyTableItemStack[i]!=null)worldIn.func_72838_d(new EntityItem(worldIn, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p(), tileEntity.AlchemyTableItemStack[i]));
			}
		}
	}

	@Override
	public boolean func_180639_a(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumFacing side, float hitX, float hitY, float hitZ) {
		TileEntity entity=worldIn.func_175625_s(pos);
		TileEntityAlchemyTable TileEntity=(TileEntityAlchemyTable)worldIn.func_175625_s(pos);
		if(worldIn.field_72995_K){
			return true;
		}else if(entity !=null){
			FMLNetworkHandler.openGui(playerIn, AlchemyCraft.instance, AlchemyCraft.AlchemyTable_GUIID, worldIn, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p());
		}
		return true;
	}

	@Override
	public void func_180633_a(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack) {
		super.func_180633_a(worldIn, pos, state, placer, stack);
		
		TileEntityAlchemyTable tileEntity =(TileEntityAlchemyTable)worldIn.func_175625_s(pos);
		if(!worldIn.field_72995_K){
			int l = MathHelper.func_76128_c((double)((placer.field_70177_z * 4F) / 360F) + 0.5D) & 3;
			System.out.println(l);
			switch (l)
			{
			case 0:
				tileEntity.AccessibleSlotsId=new int[]{4,4,1,0,3,2};
			break;

			case 1:
				tileEntity.AccessibleSlotsId=new int[]{4,4,3,2,0,1};
			break;

			case 2:
				tileEntity.AccessibleSlotsId=new int[]{4,4,0,1,2,3};
			break;

			case 3:
				tileEntity.AccessibleSlotsId=new int[]{4,4,3,2,1,0};
			break;
			}
			   
		}
	}


    @Override
	public int func_149645_b() {
		return 3;
	}

	@Override
    public boolean func_149637_q() {
        return false;
    }

    @Override
    public boolean func_149662_c() {
        return false;
    }
	@Override
	public TileEntity func_149915_a(World worldIn, int meta) {
		return new TileEntityAlchemyTable();
	}

}
