package com.hzy.alchemycraft.tileentity;

import java.util.Random;

import com.hzy.alchemycraft.handler.SwordEnchHandler;
import com.hzy.alchemycraft.items.ACItems;
import com.hzy.alchemycraft.items.ItemPotion;
import com.hzy.alchemycraft.recipes.AlchemyRecipes;
import com.hzy.alchemycraft.recipes.ConvertRecipes;
import com.hzy.alchemycraft.recipes.LowerConvertRecipes;
import com.hzy.alchemycraft.recipes.PlantMutandisRecipes;
import com.hzy.alchemycraft.recipes.Resurrection;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ITickable;

public class TileEntityAlchemyTable  extends TileEntity implements IInventory, ITickable{
	public ItemStack[] AlchemyTableItemStack =new ItemStack[5];
	private ItemStack[][] recipes=AlchemyRecipes.AlchemyTableRecipes;
	private boolean flag =false;
	public int ProgressScaled=0;
	private int deff=0;
	private Random random;
	
	public String sss="";
	public int[] AccessibleSlotsId=new int[]{4,4,1,0,3,2};
	
	public ItemStack findMatchingRecipe(){
		if(AlchemyTableItemStack[0] != null){
			if(AlchemyTableItemStack[0].getItem() instanceof ItemSword){
				return new SwordEnchHandler().getSword(AlchemyTableItemStack);
			}
			if(AlchemyTableItemStack[0].getItem()==ACItems.ingotPreciousMetal){
				return LowerAlchemy(AlchemyTableItemStack);
			}
			if(AlchemyTableItemStack[0].getItem()==ACItems.HigherPhilosopherStone && AlchemyTableItemStack[0].getItemDamage()<AlchemyTableItemStack[0].getMaxDamage()){
				return HigherAlchemy(AlchemyTableItemStack);	
			}
			if(AlchemyTableItemStack[0].getItem()==new ItemStack(Items.dye,1,15).getItem() &&AlchemyTableItemStack[0].stackSize==8){
				return PlantMutandis(AlchemyTableItemStack);
			}
			if(AlchemyTableItemStack[0].getItem()==Items.egg){
				return new Resurrection().getEgg(AlchemyTableItemStack);
			}
		}
		for(int i=0;i<this.recipes.length;i++){
			ItemStack[] itemstack = this.recipes[i];
	    	if (isMatchesA(itemstack)){
	    		return itemstack[0];
	    	}
		}
		return null;
	 }
	private ItemStack PlantMutandis(ItemStack[] itemStacks){
		if(itemStacks[1] != null && itemStacks[2] != null&& itemStacks[3] != null){
			if(Block.getBlockFromItem(itemStacks[1].getItem()) instanceof BlockBush && itemStacks[2].getItem()==ACItems.ConversionOilBottle
																					&& itemStacks[3].getItem()==ACItems.ConversionOilBottle){
				return new PlantMutandisRecipes().getMutandis(itemStacks[1]);
			}
		}
		return null;
	}
	private ItemStack LowerAlchemy(ItemStack[] itemStacks) {
		if(itemStacks[1] != null && itemStacks[2] != null&&itemStacks[3] != null){
			if(itemStacks[2].getItem().equals(ACItems.GrowthOilBottle)&&itemStacks[3].getItem().equals(ACItems.GrowthOilBottle)){
				String name=new LowerConvertRecipes().getMetalName(itemStacks[1]);
				return new LowerConvertRecipes().getPreciousMetals(name);	
			}
		}
		return null;
	 }
	public ItemStack HigherAlchemy(ItemStack[] itemStacks){	
		 int up=0;
		 int down=0;
		 int c=-1;
		if(itemStacks[1] != null){ 
			c=new ConvertRecipes().getElementIndex(itemStacks[1]);
		}else{
			c=-1;
		}
		if(itemStacks[2] != null){ 
			if(itemStacks[2].getItem()==new ItemStack(Items.dye,1,0).getItem()){//left
				down=itemStacks[2].stackSize;	
			}	
		}else{
			down=0;
		}
		if(itemStacks[3] != null){
			if(itemStacks[3].getItem()==new ItemStack(Items.dye,1,15).getItem()){//right
				up=itemStacks[3].stackSize;
			}
		}else{
			up=0;
		}			
		if(c >= 0 && (c+up-down>=0)){
			deff=up-down;
			return new ConvertRecipes().getFinElement(c+up-down,"");
		}else{
			return null;
		}
	 }
	@Override
	public String getName() {
		return "";
	}

	@Override
	public boolean hasCustomName() {
		return false;
	}
	public Boolean isMatchesA(ItemStack[] R){
    	int haveResult=0;
    	ItemStack[] itemstack=new ItemStack[4];
    	for(int i=0;i<4;i++){
    		itemstack[i]=AlchemyTableItemStack[i];
    		if(itemstack[i] != null && R[i+1] != null){
    			if(itemstack[i].getItem()==R[i+1].getItem() && itemstack[i].stackSize==R[i+1].stackSize)
    				haveResult++;
    		}
    		if(itemstack[i] == null && R[i+1] == null){
    			haveResult++;
    		}
    	}
    	if(haveResult==4){
    		return true;		
    	}
		return false;
 }

	

	@Override
	public void update() {
		if(AlchemyTableItemStack[4]==null  && findMatchingRecipe() != null){
			ProgressScaled++;
			if(ProgressScaled==200){
				ItemStack itemstack =findMatchingRecipe();
				AlchemyTableItemStack[4] = itemstack.copy();
				AlchemyDone();
			}
		 }else{
			 ProgressScaled=0;
		 }
		
	}
	
	public void AlchemyDone(){
		 for(int i=0;i<4;i++){
			 if(AlchemyTableItemStack[i] != null){
				 if((AlchemyTableItemStack[i].getItem()==ACItems.HigherPhilosopherStone) && i==0){
					 ItemStack j=AlchemyTableItemStack[0];
					 AlchemyTableItemStack[0] =new ItemStack(j.getItem(),1,j.getItemDamage()+deff);
					 AlchemyTableItemStack[1]=null; 
					 return;
				 }else if((AlchemyTableItemStack[i].getItem()==ACItems.PhilosopherStone) && i==0){
					 ItemStack j=AlchemyTableItemStack[0];
					 AlchemyTableItemStack[0] =new ItemStack(j.getItem(),1,j.getItemDamage()+53);
					 if(j.getItemDamage()+deff>=j.getMaxDamage())AlchemyTableItemStack[0] =null;
					 if(AlchemyTableItemStack[4] !=null)if(AlchemyTableItemStack[4].getItem() ==ACItems.HigherPhilosopherStone)AlchemyTableItemStack[0] =null;
					 AlchemyTableItemStack[1]=null;
					 AlchemyTableItemStack[2]=null;
					 AlchemyTableItemStack[3]=null;
					 return;
				 }else if(AlchemyTableItemStack[i].getItem() instanceof ItemPotion|| AlchemyTableItemStack[i].getItem()==Items.potionitem){
					 AlchemyTableItemStack[i]=new ItemStack(Items.glass_bottle);
				 }else if(AlchemyTableItemStack[i].getItem() ==Items.water_bucket){
					 AlchemyTableItemStack[i]=new ItemStack(Items.bucket);
				 }else{
					 AlchemyTableItemStack[i]=null;
				 }	
			 }
		 }
		 ProgressScaled=0;
		 return;
	}
	
	@Override
	public IChatComponent getDisplayName() {
		return null;
	}

	@Override
	public int getSizeInventory() {
		return AlchemyTableItemStack.length;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		return AlchemyTableItemStack[index];
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		if (this.AlchemyTableItemStack[index] != null) {
			ItemStack itemstack;
			if (this.AlchemyTableItemStack[index].stackSize <= count) {
				itemstack = this.AlchemyTableItemStack[index];
				this.AlchemyTableItemStack[index] = null;
				return itemstack;
			} else {
				itemstack = this.AlchemyTableItemStack[index].splitStack(count);

				if (this.AlchemyTableItemStack[index].stackSize == 0) {
					this.AlchemyTableItemStack[index] = null;
				}
				return itemstack;
			}
		} else {
			return null;
		}
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		this.AlchemyTableItemStack[index] = stack;

		if (stack != null && stack.stackSize > this.getInventoryStackLimit()) {
			stack.stackSize = this.getInventoryStackLimit();
		}
	}

	@Override
	public int getInventoryStackLimit() {
		return 100;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return worldObj.getTileEntity(this.pos) != this ? false : player.getDistanceSq(this.pos.getX()+0.5f, this.pos.getY()+0.5f, this.pos.getZ()+0.5f) <= 64.0D;
	}

	@Override
	public void openInventory(EntityPlayer player) {
		
	}

	@Override
	public void closeInventory(EntityPlayer player) {
		
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		return true;
	}

	@Override
	public int getField(int id) {
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		
	}

	@Override
	public int getFieldCount() {
		return 0;
	}

	@Override
	public void clear() {
		
	}
	public int getProgressScaled(int i) {
		return this.ProgressScaled * i / 200;
	}
}
