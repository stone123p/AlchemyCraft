package com.hzy.alchemycraft.tileentity;

import java.util.List;
import java.util.Random;

import com.hzy.alchemycraft.enetities.mobs.PsycheMob;
import com.hzy.alchemycraft.items.ACItems;
import com.hzy.alchemycraft.items.ItemPotion;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
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
		return this.field_145850_b.func_72977_a(this.field_174879_c.func_177958_n(),this.field_174879_c.func_177956_o(), this.field_174879_c.func_177952_p(), 3);
	}
	public EntityLiving getNearLiving(){
		int i=0;
		AxisAlignedBB emptyBounds = AxisAlignedBB.func_178781_a(this.field_174879_c.func_177958_n()-3,this.field_174879_c.func_177956_o()-3, this.field_174879_c.func_177952_p()-3, this.field_174879_c.func_177958_n()+3,this.field_174879_c.func_177956_o()+3, this.field_174879_c.func_177952_p() + 3);
		List<EntityLiving> warningList1 = this.field_145850_b.func_72872_a(EntityLiving.class, emptyBounds.func_72314_b(7, 7, 7));	
		if(warningList1.size()!=0){
			i = random.nextInt(warningList1.size());
			return warningList1.get(i);
		}
		return null;
	}
	public void GropingCrop(){
		if(!this.field_145850_b.field_72995_K){
			int gropLevel=0;
			int xPos = this.field_174879_c.func_177958_n()+random.nextInt(7)-random.nextInt(7);
			int yPos = this.field_174879_c.func_177956_o()+random.nextInt(2)-random.nextInt(2);
			int zPos = this.field_174879_c.func_177952_p()+random.nextInt(7)-random.nextInt(7);
		
			BlockPos CropPos = new BlockPos(xPos,yPos,zPos);
			BlockPos TopPos =new BlockPos(xPos,yPos+1,zPos);
			Block CropBlock =this.field_145850_b.func_180495_p(CropPos).func_177230_c();
			Block TopBlock = this.field_145850_b.func_180495_p(TopPos).func_177230_c();
			
			
			if(CropBlock instanceof BlockCrops){
				gropLevel=CropBlock.func_176201_c(this.field_145850_b.func_180495_p(CropPos));
				if(gropLevel<7){
					gropLevel++;
					this.field_145850_b.func_175641_c(this.field_174879_c, this.func_145838_q(), 1, 0);
					this.field_145850_b.func_175656_a(CropPos,CropBlock.func_176203_a(gropLevel));
					this.field_145850_b.func_175688_a(EnumParticleTypes.SPELL_WITCH, this.field_174879_c.func_177958_n(), this.field_174879_c.func_177956_o()+1.5d, this.field_174879_c.func_177952_p(), 0.0D, 0.0D, 0.0D);
				}
			}
			if(CropBlock == Blocks.field_150436_aH && TopBlock != Blocks.field_150436_aH){
				this.field_145850_b.func_175641_c(this.field_174879_c, this.func_145838_q(), 1, 0);
				this.field_145850_b.func_175656_a(TopPos, this.field_145850_b.func_180495_p(CropPos));
				this.field_145850_b.func_175688_a(EnumParticleTypes.SPELL_WITCH, this.field_174879_c.func_177958_n(), this.field_174879_c.func_177956_o()+1.5d, this.field_174879_c.func_177952_p(), 0.0D, 0.0D, 0.0D);
			}
			if(CropBlock == Blocks.field_150434_aF && TopBlock != Blocks.field_150434_aF){
				this.field_145850_b.func_175641_c(this.field_174879_c, this.func_145838_q(), 1, 0);
				this.field_145850_b.func_175656_a(TopPos, this.field_145850_b.func_180495_p(CropPos));
				this.field_145850_b.func_175688_a(EnumParticleTypes.SPELL_WITCH, this.field_174879_c.func_177958_n(), this.field_174879_c.func_177956_o()+1.5d, this.field_174879_c.func_177952_p(), 0.0D, 0.0D, 0.0D);
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
	public void func_73660_a() {
		if(Effect!=null){
			if(burningTime>0){
				--burningTime;
			}
			if(random.nextInt(2)==1 && s1!=3 && getNearLiving()!=null&& s2!=1){
				if(random.nextInt(25)==1){
					
					if(this.field_145850_b.field_72995_K){
						this.field_145850_b.func_175641_c(this.field_174879_c, this.func_145838_q(), 1, 0);
					}else{
						getNearLiving().func_70690_d(new PotionEffect(Effect.func_76456_a(),100,Effect.func_76458_c()));
						if(s1==1)getNearLiving().func_70015_d(7);
						if(s1==2)for(int i = 0; i <24; i++)getNearLiving().func_82170_o(i);
						if(s1==4)new PsycheMob(getNearLiving());
					}
				}
			}else if(getNearPlayer() !=null && s1!=3 && s2!=2){
				if(random.nextInt(25)==1 ){
					if(this.field_145850_b.field_72995_K){
						this.field_145850_b.func_175641_c(this.field_174879_c, this.func_145838_q(), 1, 0);
					}else{
						getNearPlayer().func_70690_d(new PotionEffect(Effect.func_76456_a(),100,0));
						if(s1==1)getNearPlayer().func_70015_d(7);
						if(s1==2)for(int i = 0; i <30; i++)getNearPlayer().func_82170_o(i);
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
			if(HeldItem.func_77973_b() instanceof ItemPotion){
				burningTime=10000;
				new ItemPotion();
				Effect=ItemPotion.getEffects(HeldItem.func_77973_b());
			}
			if(HeldItem.func_77973_b()==ACItems.FireOilBottle)s1=1;
			if(HeldItem.func_77973_b()==ACItems.PurifyPotion)s1=2;
			if(HeldItem.func_77973_b()==ACItems.GrowthOilBottle)s1=3;
			if(HeldItem.func_77973_b()==ACItems.PsychePotion)s1=4;
			HeldItem=null;	
		}	
		if(burningTime==0){
			Effect=null;
			
		}	
	}
	
}
