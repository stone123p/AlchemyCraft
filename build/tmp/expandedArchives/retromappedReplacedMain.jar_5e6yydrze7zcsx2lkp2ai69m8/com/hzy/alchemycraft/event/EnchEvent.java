package com.hzy.alchemycraft.event;

import java.util.ArrayList;
import java.util.Random;

import com.hzy.alchemycraft.enetities.mobs.PsycheMob;
import com.hzy.alchemycraft.handler.SwordEnchHandler;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;

public class EnchEvent {
	public int[] effectIds =new int[]{
			SwordEnchHandler.enchantmentWither.field_77352_x,
			SwordEnchHandler.enchantmentFrost.field_77352_x,
			SwordEnchHandler.enchantmentFire.field_77352_x,
			SwordEnchHandler.enchantmentZombieWrangle.field_77352_x,
			SwordEnchHandler.enchantmentPsyche.field_77352_x,
			SwordEnchHandler.enchantmentPoison.field_77352_x
			};

	
	@SubscribeEvent
	public void hitEndermanWithDagger(AttackEntityEvent event){
		
		int j;
		ItemStack playerHeldItem =event.entityPlayer.func_70694_bm();
		
		if(playerHeldItem!=null){
			for(int i=0;i<effectIds.length;i++){
				j=EnchantmentHelper.func_77506_a(effectIds[i], playerHeldItem);
				if(j>0)addEffectToLiving((EntityLiving)event.target,event.entityPlayer,i);
			}
			
		}
	}
	public void addEffectToLiving(EntityLiving target ,EntityPlayer player, int index){
		Random random = new Random();
		switch(index){
		case 0:
			target.func_70690_d(new PotionEffect(Potion.field_82731_v.field_76415_H, 600, 7));
		break;
		case 1:
			target.func_70690_d(new PotionEffect(Potion.field_76421_d.field_76415_H, 600, 7));
		break;
		case 2:
			target.func_70015_d(5);
		break;
		case 3:
			if(target instanceof EntityZombie && !player.field_70170_p.field_72995_K)hitZombie(target);
		break;
		case 4:
			if(random.nextInt(3)==1&&! player.field_70170_p.field_72995_K)new PsycheMob(target);
		break;
		case 5:
			target.func_70690_d(new PotionEffect(Potion.field_76436_u.field_76415_H, 600, 7));
		break;
		}
	}
	public void hitZombie(EntityLivingBase EntityLiving1){
		Random random = new Random();
		World world = EntityLiving1.field_70170_p;
		EntityVillager Villager = new EntityVillager(world);
		Villager.func_70012_b(EntityLiving1.field_70165_t, EntityLiving1.field_70163_u, EntityLiving1.field_70161_v, MathHelper.func_76142_g(world.field_73012_v.nextFloat() * 360.0F), 0.0F);
		if(random.nextInt(3)==1){
			EntityLiving1.func_70106_y();
			world.func_72838_d(Villager);
		}
	}
}
