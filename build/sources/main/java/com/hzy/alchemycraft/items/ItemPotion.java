package com.hzy.alchemycraft.items;

import java.util.*;
import com.hzy.alchemycraft.AlchemyCraft;
import com.hzy.alchemycraft.items.ACItems;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemPotion extends Item
{
	/**
     * Contains a map from integers to the list of potion effects that potions with that damage value confer (to prevent
     * recalculating it).
     */
    private HashMap effectCache = new HashMap();

    public ItemPotion()
    {
        this.setMaxStackSize(20);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setCreativeTab(AlchemyCraft.alchemycraftTab);
        
    }

    

    public static PotionEffect getEffects(Item item)
    {
    	PotionEffect potiones = null;

    	
    	if(item==  ACItems.MinorHealingPotion)potiones=new PotionEffect(Potion.heal.getId(),1,0);
    	if(item==  ACItems.ElixirofMinorFortitude)potiones=new PotionEffect(Potion.absorption.getId(),5000,0);
    	if(item==  ACItems.ElixirofMinorAgility)potiones=new PotionEffect(Potion.moveSpeed.getId(),5000,0);  
    	if(item==  ACItems.ElixirofMinorDefense)potiones=new PotionEffect(Potion.resistance.getId(),5000,0);
    	if(item==  ACItems.ElixirofMinorStrength)potiones=new PotionEffect(Potion.damageBoost.getId(),5000,0);
    	if(item==  ACItems.ElixirofMinorInvisibility)potiones=new PotionEffect(Potion.invisibility.getId(),5000,0);
    	if(item==  ACItems.ElixirofMinorWaterBreathing)potiones=new PotionEffect(Potion.waterBreathing.getId(),5000,0);
    	if(item==  ACItems.ElixirofMinorNightVision)potiones=new PotionEffect(Potion.nightVision.getId(),5000,0);
    	
    	if(item==  ACItems.HealingPotion)potiones=new PotionEffect(Potion.heal.getId(),1,2);
    	if(item==  ACItems.FortitudePotion)potiones=new PotionEffect(Potion.absorption.getId(),10000,2);
    	if(item==  ACItems.AgilityPotion)potiones=new PotionEffect(Potion.moveSpeed.getId(),10000,2);
    	if(item==  ACItems.DefensePotion)potiones=new PotionEffect(Potion.resistance.getId(),10000,2);
    	if(item==  ACItems.StrengthPotion)potiones=new PotionEffect(Potion.damageBoost.getId(),10000,2);
    	if(item==  ACItems.InvisibilityPotion)potiones=new PotionEffect(Potion.invisibility.getId(),10000,2);
    	if(item==  ACItems.WaterBreathingPotion)potiones=new PotionEffect(Potion.waterBreathing.getId(),10000,2);
    	if(item==  ACItems.NightVisionPotion)potiones=new PotionEffect(Potion.nightVision.getId(),10000,2);
    	if(item==  ACItems.FireResistancePotion)potiones=new PotionEffect(Potion.fireResistance.getId(),10000,2);
    	if(item==  ACItems.PurifyPotion)potiones=new PotionEffect(Potion.heal.getId(),1,0);
    	if(item==  ACItems.PsychePotion)potiones=new PotionEffect(Potion.confusion .getId(),10000,2);
    	if(item==  ACItems.RegenerationPotion)potiones=new PotionEffect(Potion.regeneration.getId(),10000,2);
    	if(item==  ACItems.FlyingPotion)potiones=new PotionEffect(AlchemyCraft.Flying.id,10000,0);
    	
    	if(item==  ACItems.FishOilBottle)potiones=new PotionEffect(Potion.nightVision.getId(),200,0);
    	if(item==  ACItems.CorpseOilBottle)potiones=new PotionEffect(Potion.blindness.getId(),0,0);
    	if(item==  ACItems.WitherOilBottle)potiones=new PotionEffect(Potion.wither.getId(),160,7);
    	if(item==  ACItems.YinYangOilBottle)potiones=new PotionEffect(Potion.confusion .getId(),200,0);
    	if(item==  ACItems.FireOilBottle)potiones=new PotionEffect(Potion.blindness.getId(),0,0);
    	if(item==  ACItems.GrowthOilBottle)potiones=new PotionEffect(Potion.blindness.getId(),0,0);
    	if(item==  ACItems.ConversionOilBottle)potiones=new PotionEffect(Potion.blindness.getId(),0,0);
    	if(item==  ACItems.FrostOilBottle)potiones=new PotionEffect(Potion.moveSlowdown.getId(),160,7);
    	if(item==  ACItems.PoisonOilBottle)potiones=new PotionEffect(Potion.poison.getId(),160,7);
    	if(item==  ACItems.ProdigyOilBottle)potiones=new PotionEffect(Potion.poison.getId(),0,0);
    	
    	return potiones;
        
    }

    @Override
	public ItemStack onItemUseFinish(ItemStack itemstack, World world, EntityPlayer player)
    {
    	// player.addPotionEffect(new PotionEffect(Main.Flying.id,200,0));
        if (!player.capabilities.isCreativeMode)
        {
            --itemstack.stackSize;
        }

        if (!world.isRemote)
        {
        	 PotionEffect potioneffect = ItemPotion.getEffects(itemstack.getItem());

            if (potioneffect != null)
            {
              if(itemstack.getItem()==ACItems.FireOilBottle){
            	  player.setFire(7);
              }else if(itemstack.getItem()==ACItems.PurifyPotion){
            	  for(int i = 0; i <30; i++)player.removePotionEffect(i);
              }else if(itemstack.getItem()==ACItems.ProdigyOilBottle){
            	  player.setDead();
              }else{
            	  player.addPotionEffect(new PotionEffect(potioneffect));
               }
            }
        }

        if (!player.capabilities.isCreativeMode)
        {
            if (itemstack.stackSize <= 0)
            {
                return new ItemStack(Items.glass_bottle);
            }

            player.inventory.addItemStackToInventory(new ItemStack(Items.glass_bottle));
        }

        return itemstack;
    }

    private void removePotionEffect(EntityPlayer player) {
    	
    
	}



	/**
     * How long it takes to use or consume an item
     */
    @Override
	public int getMaxItemUseDuration(ItemStack p_77626_1_)
    {
        return 32;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    @Override
	public EnumAction getItemUseAction(ItemStack p_77661_1_)
    {
        return EnumAction.DRINK;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    @Override
	public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
    	
        if (isSplash(p_77659_1_.getItemDamage()))
        {
            if (!p_77659_3_.capabilities.isCreativeMode)
            {
                --p_77659_1_.stackSize;
            }

            
            p_77659_2_.playSoundAtEntity(p_77659_3_, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

            if (!p_77659_2_.isRemote)
            {
                p_77659_2_.spawnEntityInWorld(new EntityPotion(p_77659_2_, p_77659_3_, p_77659_1_));
            }

            return p_77659_1_;
        }
        else
        {
            p_77659_3_.setItemInUse(p_77659_1_, this.getMaxItemUseDuration(p_77659_1_));
            return p_77659_1_;
        }
    }


    /**
     * returns wether or not a potion is a throwable splash potion based on damage value
     */
    public static boolean isSplash(int p_77831_0_)
    {
        return (p_77831_0_ & 16384) != 0;
    }


    
 

    @Override
	@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack p_77636_1_)
    {
        return false;
    }

    



   
  
}