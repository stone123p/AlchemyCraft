package com.hzy.alchemycraft.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.hzy.alchemycraft.AlchemyCraft;
import com.hzy.alchemycraft.items.ACItems;
import com.hzy.alchemycraft.items.ItemPotion;
import com.hzy.alchemycraft.tileentity.TileEntityACCauldron;
import com.hzy.alchemycraft.tileentity.TileEntityAlchemyTable;

import net.minecraft.block.BlockCauldron;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import scala.actors.threadpool.Arrays;

public class ACCauldron extends BlockContainer{

	public Random random =new Random();
	protected ACCauldron(Material materialIn) {
		super(materialIn);
		this.setUnlocalizedName("ACCauldron");
		this.setHardness(3);
		this.setCreativeTab(AlchemyCraft.alchemycraftTab);
	}
	
	public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean isFullCube()
    {
        return false;
    }
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityACCauldron();
	}
	public void addCollisionBoxesToList(World worldIn, BlockPos pos, IBlockState state, AxisAlignedBB mask, List<AxisAlignedBB> list, Entity collidingEntity)
    {
        float f = 1/16F;
        this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 0.6F, 1.0F);
        super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
        
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.6F, f);
        super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
        
        this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 0.6F, 1.0F);
        super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
        
        this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 0.6F, 1.0F);
        super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
        
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 2*f, 1.0F);
        super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
    }

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,EnumFacing side, float hitX, float hitY, float hitZ) {
		TileEntityACCauldron TileEntity = (TileEntityACCauldron)worldIn.getTileEntity(pos);
	        ItemStack HeldItem = playerIn.getHeldItem();
	        if (HeldItem != null) {
	        	boolean isWater=HeldItem.getItem()==Items.potionitem&&HeldItem.getMetadata()==0;
	            if ((HeldItem.getItem() instanceof ItemPotion||isWater) && TileEntity.WaterLevel+TileEntity.StandardMole(HeldItem.getItem())<=24){
	            	TileEntity.WaterLevel+=TileEntity.addPotionMole(HeldItem);
	                TileEntity.addPotion(HeldItem.copy());
	                --playerIn.getHeldItem().stackSize;
	                playerIn.inventory.addItemStackToInventory(new ItemStack(Items.glass_bottle, 1));
	            }
	            if(HeldItem.getItem() == ACItems.DistilledBottle){
	            	ItemStack PDB=new ItemStack(ACItems.PotionDistilledBottle);
	            	if(PDB.getTagCompound()==null){
	            		PDB.setTagCompound(new NBTTagCompound());
	    			}
	            	int j=0;
	    			NBTTagCompound nbt = new NBTTagCompound();
	    			for(int i=0;i<TileEntity.potions.size();i++){
	    				ItemStack P=TileEntity.potions.get(i);
	    				if(P.stackSize>0){
	    					nbt.setString("name_"+j,P.getDisplayName());
	    					nbt.setInteger("id_"+j,Item.getIdFromItem(P.getItem()));
	    					nbt.setInteger("n_"+j,P.stackSize);
	    					j++;
	    					P.stackSize=0;
	    				}
	    			}
	    			TileEntity.WaterLevel=0;
	    			nbt.setInteger("size", j);
	    			PDB.getTagCompound().setTag("potion", nbt);
	    			if(j>0){
	    				HeldItem.stackSize--;
		            	playerIn.inventory.addItemStackToInventory(PDB);
	    			}
	            }
	            if(HeldItem.getItem() == ACItems.PotionDistilledBottle){
	            	if(HeldItem.getTagCompound() !=null){
	        			if(HeldItem.getTagCompound().hasKey("potion")){
	        				NBTTagCompound nbt = (NBTTagCompound) HeldItem.getTagCompound().getTag("potion");	        				int L=0;
	        				for(int i=0;i<nbt.getInteger("size");i++){
	        					if(TileEntity.WaterLevel+nbt.getInteger("n_"+i)<=24){
	        						isWater=Item.getItemById(nbt.getInteger("id_"+i)).equals(Items.potionitem);
		        					TileEntity.WaterLevel+=nbt.getInteger("n_"+i);
		        	                TileEntity.addPotion(new ItemStack(Item.getItemById(nbt.getInteger("id_"+i)),1,nbt.getInteger("n_"+i) ));
		        	                L++;
	        					}
	        				}
	        				HeldItem.stackSize--;
	        				if( nbt.getInteger("size")>L){
	        					ItemStack PDB=new ItemStack(ACItems.PotionDistilledBottle);
	        					
	        					for(int i=0;i< nbt.getInteger("size")-L;i++){
	        						nbt.setString("name_"+i,nbt.getString("name_"+String.valueOf(i+L)));
	        						nbt.setInteger("id_"+i,nbt.getInteger("id_"+String.valueOf(i+L)));
	        						nbt.setInteger("n_"+i,nbt.getInteger("n_"+String.valueOf(i+L)));
	        					}
	        						

	        					nbt.setInteger("size", nbt.getInteger("size")-L);
	        					if(PDB.getTagCompound()==null){
	        						PDB.setTagCompound(new NBTTagCompound());
	        					}
	        					PDB.getTagCompound().setTag("potion", nbt);
	        					playerIn.inventory.addItemStackToInventory(PDB);
	        				}else{
	        					playerIn.inventory.addItemStackToInventory(new ItemStack(ACItems.DistilledBottle));
	        				}
	        			}
	        		}
	        		
	            }
	        }else{
	        	TileEntity.f=true;
	        	TileEntity.player=playerIn;
	        }
	    return true;
	}
	@Override
	public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		super.randomDisplayTick(worldIn, pos, state, rand);
		TileEntityACCauldron TileEntity = (TileEntityACCauldron)worldIn.getTileEntity(pos);

		if(TileEntity.canAlchemy){
			TileEntity.CanAlchemy(true);
			float f1 = pos.getX()+0.5f;
			float f2 = pos.getY()+0.15F/8*TileEntity.WaterLevel;
			float f3 = pos.getZ()+0.5f;
			worldIn.spawnParticle(EnumParticleTypes.SLIME, (f1), f2, (f3), 0, 0, 0);
		}
		

		
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		super.breakBlock(worldIn, pos, state);
		worldIn.removeTileEntity(pos);
	}

	@Override
	public boolean onBlockEventReceived(World worldIn, BlockPos pos, IBlockState state, int eventID, int eventParam) {
		TileEntityACCauldron TileEntity = (TileEntityACCauldron)worldIn.getTileEntity(pos);
		if (eventParam == 0) {
			worldIn.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, pos.getX()+0.5f, pos.getY()+1, pos.getZ()+0.5f, 0, 0, 0, 0);      
			}
		if(eventParam == 1){
			TileEntity.WaterLevel=TileEntity.WaterLevel-eventID;
		}
			
		return true;
	}

	@Override	
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		super.onEntityCollidedWithBlock(worldIn, pos, state, entityIn);
	}
}
