package com.hzy.alchemycraft.enetities.mobs;

import java.util.Random;

import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAICreeperSwell;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class EntityPsycheCreeper extends EntityCreeper{
	private int lastActiveTime;
	    /** The amount of time since the creeper was close enough to the player to ignite */
	private int timeSinceIgnited;
	private int fuseTime = 30;
	    /** Explosion radius for this creeper. */
	private int explosionRadius = 3;
	private Random random =new Random();
	private static final String __OBFID = "CL_00001684";
	public EntityPsycheCreeper(World p_i1733_1_) {
		super(p_i1733_1_);
		this.tasks.taskEntries.clear();
	    this.targetTasks.taskEntries.clear();
		this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAICreeperSwell(this));
        this.tasks.addTask(3, new EntityAIAvoidEntity(this, EntityOcelot.class, 6.0F, 1.0D, 1.2D));
        this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 1.0D, false));
        this.tasks.addTask(5, new EntityAIWander(this, 0.8D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityCreeper.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityCreeper.class, true));
        
	}
	@Override
	public void onUpdate() {
		
    	if(random.nextInt(3)==1){
    		this.worldObj.spawnParticle(EnumParticleTypes.SPELL_WITCH, this.posX, this.posY+1.5d, this.posZ, 0.0D, 0.0D, 0.0D);
    	
    	}
		if(this.isEntityAlive()){
			
		}
		super.onUpdate();
	}


	

}
