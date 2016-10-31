package com.hzy.alchemycraft.enetities.mobs;

import java.util.Random;

import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityWitch ;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
public class EntityPsycheWitch extends EntityWitch{
	private Random random =new Random();
	 public EntityPsycheWitch(World p_i1744_1_)
	    {
	        super(p_i1744_1_);
	        this.tasks.taskEntries.clear();
		    this.targetTasks.taskEntries.clear();
	        this.tasks.addTask(1, new EntityAISwimming(this));
	        this.tasks.addTask(2, new EntityAIArrowAttack(this, 1.0D, 60, 10.0F));
	        this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
	        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityWitch.class, 8.0F));
	        this.tasks.addTask(3, new EntityAILookIdle(this));
	        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
	        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityWitch.class, true));
	    }

	@Override
	public void onUpdate() {
		super.onUpdate();
		if(random.nextInt(3)==1){
    		this.worldObj.spawnParticle(EnumParticleTypes.SPELL_WITCH, this.posX, this.posY+1.5d, this.posZ, 0.0D, 0.0D, 0.0D);
    	
    	}
		
	}
	 
	 
}
