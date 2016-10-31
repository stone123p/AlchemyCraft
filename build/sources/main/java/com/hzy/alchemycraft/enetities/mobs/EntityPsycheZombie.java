package com.hzy.alchemycraft.enetities.mobs;

import java.util.Random;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;


public class EntityPsycheZombie extends EntityZombie {
	private Random random =new Random();
	public EntityPsycheZombie(World p_i1738_1_) {
		super(p_i1738_1_);
		 ((PathNavigateGround)this.getNavigator()).setBreakDoors(true);
	        this.tasks.addTask(0, new EntityAISwimming(this));
	        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityZombie.class, 1.0D, false));
	        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
	        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
	        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityZombie.class, 8.0F));
	        this.tasks.addTask(8, new EntityAILookIdle(this));
	        this.applyEntityAI();
	        this.setSize(0.6F, 1.95F);
	}
	@Override
	public void onLivingUpdate()
    {
		if(random.nextInt(3)==1){
    		this.worldObj.spawnParticle(EnumParticleTypes.SPELL_WITCH, this.posX, this.posY+1.5d, this.posZ, 0.0D, 0.0D, 0.0D);
    	
    	}
		
    	 if (this.worldObj.isDaytime() && !this.worldObj.isRemote && !this.isChild())
         {
             float f = this.getBrightness(1.0F);
             BlockPos blockpos = new BlockPos(this.posX, (double)Math.round(this.posY), this.posZ);

             if (f > 0.5F && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && this.worldObj.canSeeSky(blockpos))
             {
                 boolean flag = true;
                 ItemStack itemstack = this.getEquipmentInSlot(4);

                 if (itemstack != null)
                 {
                     if (itemstack.isItemStackDamageable())
                     {
                         itemstack.setItemDamage(itemstack.getItemDamage() + this.rand.nextInt(2));

                         if (itemstack.getItemDamage() >= itemstack.getMaxDamage())
                         {
                             this.renderBrokenItemStack(itemstack);
                             this.setCurrentItemOrArmor(4, (ItemStack)null);
                         }
                     }

                     flag = false;
                 }

                 if (flag)
                 {
                     this.setFire(8);
                 }
             }
         }

         if (this.isRiding() && this.getAttackTarget() != null && this.ridingEntity instanceof EntityChicken)
         {
             ((EntityLiving)this.ridingEntity).getNavigator().setPath(this.getNavigator().getPath(), 1.5D);
         }

         super.onLivingUpdate();
    }
	

}
