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
		this.setCreativeTab(AlchemyCraft.alchemycraftTab);
		this.setUnlocalizedName("AlchemyTable");
		this.setHardness(3.0F);

	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		super.breakBlock(worldIn, pos, state);
		worldIn.removeTileEntity(pos);
		TileEntityAlchemyTable tileEntity= (TileEntityAlchemyTable)worldIn.getTileEntity(pos);
		if(!worldIn.isRemote){
			for(int i=0; i<tileEntity.AlchemyTableItemStack.length;i++){
				if(tileEntity.AlchemyTableItemStack[i]!=null)worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), tileEntity.AlchemyTableItemStack[i]));
			}
		}
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumFacing side, float hitX, float hitY, float hitZ) {
		TileEntity entity=worldIn.getTileEntity(pos);
		TileEntityAlchemyTable TileEntity=(TileEntityAlchemyTable)worldIn.getTileEntity(pos);
		if(worldIn.isRemote){
			return true;
		}else if(entity !=null){
			FMLNetworkHandler.openGui(playerIn, AlchemyCraft.instance, AlchemyCraft.AlchemyTable_GUIID, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack) {
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
		
		TileEntityAlchemyTable tileEntity =(TileEntityAlchemyTable)worldIn.getTileEntity(pos);
		if(!worldIn.isRemote){
			int l = MathHelper.floor_double((double)((placer.rotationYaw * 4F) / 360F) + 0.5D) & 3;
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
	public int getRenderType() {
		return 3;
	}

	@Override
    public boolean isBlockNormalCube() {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityAlchemyTable();
	}

}
