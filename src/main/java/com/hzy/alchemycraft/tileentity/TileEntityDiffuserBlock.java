package com.hzy.alchemycraft.tileentity;

import java.util.List;
import java.util.Random;

import com.hzy.alchemycraft.enetities.mobs.PsycheMob;
import com.hzy.alchemycraft.items.ACItems;
import com.hzy.alchemycraft.items.ItemPotion;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ITickable;

public class TileEntityDiffuserBlock extends TileEntity implements ITickable{
	
	private static final String EntityPlayer = null;
	public  ItemStack HeldItem;
	public 	int s1,s2;
	public  PotionEffect Effect;
	public  Random random =new Random();
	public int burningTime;
	
	public EntityPlayer getNearPlayer(){
		return this.worldObj.getClosestPlayer(this.pos.getX(),this.pos.getY(), this.pos.getZ(), 3);
	}
	public EntityLiving getNearLiving(){
		int i=0;
		AxisAlignedBB emptyBounds = AxisAlignedBB.fromBounds(this.pos.getX()-3,this.pos.getY()-3, this.pos.getZ()-3, this.pos.getX()+3,this.pos.getY()+3, this.pos.getZ() + 3);
		List<EntityLiving> warningList1 = this.worldObj.getEntitiesWithinAABB(EntityLiving.class, emptyBounds.expand(7, 7, 7));	
		if(warningList1.size()!=0){
			i = random.nextInt(warningList1.size());
			return warningList1.get(i);
		}
		return null;
	}
	public void GropingCrop(){
		if(!this.worldObj.isRemote){
			int gropLevel=0;
			int xPos = this.pos.getX()+random.nextInt(7)-random.nextInt(7);
			int yPos = this.pos.getY()+random.nextInt(2)-random.nextInt(2);
			int zPos = this.pos.getZ()+random.nextInt(7)-random.nextInt(7);
		
			BlockPos CropPos = new BlockPos(xPos,yPos,zPos);
			BlockPos TopPos =new BlockPos(xPos,yPos+1,zPos);
			Block CropBlock =this.worldObj.getBlockState(CropPos).getBlock();
			Block TopBlock = this.worldObj.getBlockState(TopPos).getBlock();
			
			
			if(CropBlock instanceof BlockCrops){
				gropLevel=CropBlock.getMetaFromState(this.worldObj.getBlockState(CropPos));
				if(gropLevel<7){
					gropLevel++;
					this.worldObj.addBlockEvent(this.pos, this.getBlockType(), 1, 0);
					this.worldObj.setBlockState(CropPos,CropBlock.getStateFromMeta(gropLevel));
					this.worldObj.spawnParticle(EnumParticleTypes.SPELL_WITCH, this.pos.getX(), this.pos.getY()+1.5d, this.pos.getZ(), 0.0D, 0.0D, 0.0D);
				}
			}
			if(CropBlock == Blocks.reeds && TopBlock != Blocks.reeds){
				this.worldObj.addBlockEvent(this.pos, this.getBlockType(), 1, 0);
				this.worldObj.setBlockState(TopPos, this.worldObj.getBlockState(CropPos));
				this.worldObj.spawnParticle(EnumParticleTypes.SPELL_WITCH, this.pos.getX(), this.pos.getY()+1.5d, this.pos.getZ(), 0.0D, 0.0D, 0.0D);
			}
			if(CropBlock == Blocks.cactus && TopBlock != Blocks.cactus){
				this.worldObj.addBlockEvent(this.pos, this.getBlockType(), 1, 0);
				this.worldObj.setBlockState(TopPos, this.worldObj.getBlockState(CropPos));
				this.worldObj.spawnParticle(EnumParticleTypes.SPELL_WITCH, this.pos.getX(), this.pos.getY()+1.5d, this.pos.getZ(), 0.0D, 0.0D, 0.0D);
			}
			
		}
	}
	public void setHeldItem(Item HeldItem){	
		this.HeldItem = new ItemStack(HeldItem,1);
	}

	public boolean isBurning(){
		return burningTime>0;
	}
	@Override
	public void update() {
		if(Effect!=null){
			if(burningTime>0){
				--burningTime;
			}
			if(random.nextInt(2)==1 && s1!=3 && getNearLiving()!=null&& s2!=1){
				if(random.nextInt(25)==1){
					
					if(this.worldObj.isRemote){
						this.worldObj.addBlockEvent(this.pos, this.getBlockType(), 1, 0);
					}else{
						getNearLiving().addPotionEffect(new PotionEffect(Effect.getPotionID(),100,Effect.getAmplifier()));
						if(s1==1)getNearLiving().setFire(7);
						if(s1==2)for(int i = 0; i <24; i++)getNearLiving().removePotionEffect(i);
						if(s1==4)new PsycheMob(getNearLiving());
					}
				}
			}else if(getNearPlayer() !=null && s1!=3 && s2!=2){
				if(random.nextInt(25)==1 ){
					if(this.worldObj.isRemote){
						this.worldObj.addBlockEvent(this.pos, this.getBlockType(), 1, 0);
					}else{
						getNearPlayer().addPotionEffect(new PotionEffect(Effect.getPotionID(),100,0));
						if(s1==1)getNearPlayer().setFire(7);
						if(s1==2)for(int i = 0; i <30; i++)getNearPlayer().removePotionEffect(i);
					}
				}
			}
			if(s1==3 && random.nextInt(5)==1){
				GropingCrop();
			}
		}
		if (HeldItem != null){
			s1=0;
			s2=0;
			if(HeldItem.getItem() instanceof ItemPotion){
				burningTime=20000;
				new ItemPotion();
				Effect=ItemPotion.getEffects(HeldItem);
			}
			if(HeldItem.getItem()==ACItems.FireOilBottle)s1=1;
			if(HeldItem.getItem()==ACItems.PurifyPotion)s1=2;
			if(HeldItem.getItem()==ACItems.GrowthOilBottle)s1=3;
			if(HeldItem.getItem()==ACItems.PsychePotion)s1=4;
			HeldItem=null;	
		}	
		if(burningTime==0){
			Effect=null;
			
		}	
	}
	
}