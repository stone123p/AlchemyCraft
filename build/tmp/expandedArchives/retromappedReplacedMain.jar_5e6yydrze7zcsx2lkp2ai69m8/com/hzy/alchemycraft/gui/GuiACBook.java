 package com.hzy.alchemycraft.gui;

import org.lwjgl.opengl.GL11;
import com.hzy.alchemycraft.AlchemyCraft;
import com.hzy.alchemycraft.blocks.ACBlocks;

import com.hzy.alchemycraft.handler.LibHandler;
import com.hzy.alchemycraft.items.ACItems;
import com.hzy.alchemycraft.items.ItemPotion;
import com.hzy.alchemycraft.recipes.AlchemyRecipes;
import com.hzy.alchemycraft.recipes.DistillerRecipes;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiACBook extends GuiScreen{

	private ItemStack[] st1 = {
			new ItemStack(Items.field_151042_j),new ItemStack(Items.field_151042_j),new ItemStack(Items.field_151042_j),
			new ItemStack(Items.field_151067_bt),null,new ItemStack(Items.field_151042_j),
			new ItemStack(Item.func_150898_a(ACBlocks.Tripod)),null,null,
			new ItemStack(Item.func_150898_a(ACBlocks.Distiller))};
	
	private ItemStack[] st2 = {
			null,new ItemStack(Blocks.field_150373_bw),null,
			new ItemStack(Blocks.field_150359_w),null,new ItemStack(Blocks.field_150359_w),
			new ItemStack(Blocks.field_150359_w),new ItemStack(Blocks.field_150359_w),new ItemStack(Blocks.field_150359_w),
			new ItemStack(ACItems.DistilledBottle)};
	
	private ItemStack[] st3 = {
			new ItemStack(Blocks.field_150371_ca),new ItemStack(Items.field_151100_aR,1,5),new ItemStack(Blocks.field_150371_ca),
			new ItemStack(Blocks.field_150343_Z),new ItemStack(Blocks.field_150343_Z),new ItemStack(Blocks.field_150343_Z),
			new ItemStack(Blocks.field_150343_Z),new ItemStack(Blocks.field_150343_Z),new ItemStack(Blocks.field_150343_Z),
			new ItemStack(Item.func_150898_a(ACBlocks.AlchemyTable))};
	
	private ItemStack[] st4 = {
			new ItemStack(Items.field_151118_aC),null,new ItemStack(Items.field_151118_aC),
			new ItemStack(Items.field_151118_aC),new ItemStack(Items.field_151118_aC),new ItemStack(Items.field_151118_aC),
			new ItemStack(Items.field_151118_aC),new ItemStack(Items.field_151065_br),new ItemStack(Items.field_151118_aC),
			new ItemStack(Item.func_150898_a(ACBlocks.Diffuser))};
	
	private ItemStack[] st5 = {
			null,null,null,
			new ItemStack(Items.field_151042_j),new ItemStack(Items.field_151119_aD),new ItemStack(Items.field_151042_j),
			new ItemStack(Items.field_151042_j),new ItemStack(Items.field_151054_z),new ItemStack(Items.field_151042_j),
			new ItemStack(Item.func_150898_a(ACBlocks.Tripod))};
	
	Minecraft mc=Minecraft.func_71410_x();
	private String[] RomanNumerals={"I","II","III","IV","V","VI","VII","VIII","IX","X"};
	private NBTTagCompound nbt = new NBTTagCompound();
	private int guiWidth = 148;
	private int guiHeight =182;
	private int tabWidth = 27;
	private int tabHeight =23;
	
	
	private int Mainpage=0;
	private int pageNumber=0;
	private int MaxPageNumber=2;
	
	@Override
	public void func_73863_a(int x, int y, float ticks){
		super.func_73863_a(x, y, ticks);
		
		int guiX = (field_146294_l-guiWidth)/2;
		int guiY = (field_146295_m-guiHeight)/2;
		GL11.glColor4f(1, 1, 1, 1);
		func_146276_q_();
		mc.field_71446_o.func_110577_a(new ResourceLocation(AlchemyCraft.MODID+":textures/guis/AlchemyBook.png"));
		func_73729_b(guiX, guiY, 0, 0 , guiWidth, guiHeight);
		
		func_73729_b(guiX+135, guiY+20, 58, 188+(Mainpage==0?32:0) ,27, 23);
		func_73729_b(guiX+135, guiY+50, 58, 188+(Mainpage==1?32:0) ,27, 23);
		func_73729_b(guiX+135, guiY+80, 58, 188+(Mainpage==2?32:0) ,27, 23);
		func_73729_b(guiX+135, guiY+110, 58, 188+(Mainpage==3?32:0) ,27, 23);
		
		func_73729_b(guiX+140, guiY+23, 96, 191 ,16, 16);
		func_73729_b(guiX+140, guiY+53, 119, 191 ,16, 16);	
		func_73729_b(guiX+140, guiY+83, 145, 191 ,16, 16);
		func_73729_b(guiX+140, guiY+113,172, 191 ,16, 16);
		
		func_73729_b(guiX+120, guiY+155, 3+(pageNumber==MaxPageNumber?23:0), 194 ,18, 11);
		func_73729_b(guiX+15, guiY+155, 3+(pageNumber==0?23:0), 207 ,18, 11);
		
		if(Mainpage==0)SelectHerbs(guiX,guiY);
		if(Mainpage==1)SelectDistill(guiX,guiY);
		if(Mainpage==2)SelectAlchemy(guiX,guiY);
		if(Mainpage==3)SelectDiffuser(guiX,guiY);
		
		RenderHelper.func_74519_b();
	}
	
	

	@Override
	protected void func_73864_a(int x, int y, int button) {
	//	super.mouseClicked(x, y, button);
		int guiX = (field_146294_l-guiWidth)/2;
		int guiY = (field_146295_m-guiHeight)/2;
		if(guiX+135<=x&&x<=guiX+163&&guiY+23<=y&&y<=guiY+45){
			MaxPageNumber=2;
			pageNumber=0;
			Mainpage=0;
		}
		if(guiX+135<=x&&x<=guiX+163&&guiY+50<=y&&y<=guiY+72){
			MaxPageNumber=DistillerRecipes.RecipesList.length/4+3;
			pageNumber=0;
			Mainpage=1;
		}
		if(guiX+135<=x&&x<=guiX+163&&guiY+77<=y&&y<=guiY+99){
			MaxPageNumber=AlchemyRecipes.Recipes.length;
			pageNumber=0;
			Mainpage=2;
		}
		if(guiX+135<=x&&x<=guiX+163&&guiY+113<=y&&y<=guiY+113+22){
			MaxPageNumber=1;
			pageNumber=0;
			Mainpage=3;
		}
		if(guiX+120<=x&&x<=guiX+138 && guiY+155<=y&&y<=guiY+166){
			if(pageNumber<MaxPageNumber)pageNumber++;
		}
		
		if(guiX+15<=x&&x<=guiX+33 &&guiY+155<=y&&y<=guiY+166){
			if(pageNumber>0)pageNumber--;
		}
	}
	

	public void SelectHerbs(int x,int y){
		field_146289_q.func_78279_b("藥草學",x+60, y+15,116, 0);
		for(int i=0;i<5;i++){
			if(i+pageNumber*5<14){
				field_146289_q.func_78279_b(StatCollector.func_74838_a("GuiBook.Name.con")+StatCollector.func_74838_a(LibHandler.HerbsName[i+pageNumber*5]),x+40, y+30+25*i,116, 0);
				field_146289_q.func_78279_b(StatCollector.func_74838_a("GuiBook.Environment.con")+LibHandler.HerbsData[i+pageNumber*5],x+40, y+40+25*i,116, 3);
				GL11.glColor4f(1, 1, 1, 1);
				mc.field_71446_o.func_110577_a(new ResourceLocation(AlchemyCraft.MODID,"textures/guis/guiLib.png"));
				func_73729_b(x+20, y+30+25*i, 18*(i+pageNumber*5), 0 , 16, 16);
				
			}
		}
	}
	public void SelectDistill(int x,int y){
		String[] s={"所需設備：\n1.蒸餾器\n2.蒸餾瓶\n3.玻璃瓶\n\n蒸餾步驟：\n1.持蒸餾瓶對水源點擊右鍵以取的裝水的蒸餾瓶。\n2.將裝水的蒸餾瓶和配方材料用合成台合成出相對映的材料瓶\n3.將燃料、材料瓶、玻璃瓶放置於蒸餾器相對映的位置",
					"蒸餾器之合成表：\n\n\n\n\n\n\n蒸餾瓶之合成表：","本生燈之合成表："};
		field_146289_q.func_78276_b("蒸餾學",x+60, y+15,0x40404040);
		field_146289_q.func_78279_b(pageNumber>2?"蒸餾配方：":s[pageNumber], x+20, y+25, 116, 0);
		
		if(pageNumber==1){
			DrawCraftingRecipes(st1, x+30, y+35);
			DrawCraftingRecipes(st2, x+30, y+100);
		}

		if(pageNumber==2){
			DrawCraftingRecipes(st5, x+30, y+35);
		}
		if(pageNumber>=3){
			int i=(pageNumber-3)*2;
			DrawPotionInformation(DistillerRecipes.RecipesList[i*2+1].func_77973_b(),i,x+20,y+40);
			if(pageNumber<MaxPageNumber)DrawPotionInformation(DistillerRecipes.RecipesList[i*2+3].func_77973_b(),i+1,x+20,y+95);
		}

	}
	public void SelectAlchemy(int x,int y){
					   
		field_146289_q.func_78276_b("煉金術",x+60, y+15,0x40404040);
		
		if(pageNumber==0){
			field_146289_q.func_78279_b("設備:\n煉金桌\n煉金桌之合成表：", x+20, y+25, 116, 0);
			DrawCraftingRecipes(st3, x+30, y+65);
		}
		if(pageNumber>0){
			
			int i=(pageNumber-1);

			field_146289_q.func_78279_b(AlchemyRecipes.Recipes[i], x+20, y+15, 116, 0);
			DrawAlchemyRecipes(AlchemyRecipes.AlchemyTableRecipes[i],x+30,y+80 );
		}
	}
	private void SelectDiffuser(int x, int y) {
		field_146289_q.func_78276_b("精油燈",x+60, y+15,0x40404040);
		if(pageNumber==0){
			field_146289_q.func_78279_b("功能：將藥水揮發在空氣中，使周圍生物包括玩家獲得短暫的藥水效果。", x+20, y+25, 116, 0);
			field_146289_q.func_78279_b("使用方法：手持藥水對精油燈點右鍵。", x+20, y+65, 116, 0);
			field_146289_q.func_78279_b("精油燈之合成表：", x+20, y+95, 116, 0);
			DrawCraftingRecipes(st4, x+30, y+105);
		}
		if(pageNumber==1){
			field_146289_q.func_78279_b("對象綁定：可指定精油燈能夠影響的族群。\n綁定方法：\n\n1.只對玩家有作用：持紅石對精油燈點右鍵\n 2.只對非玩家生物有作用：持螢光粉對精油燈點右鍵\n 3.清除綁定：持糖對精油燈點右鍵", x+20, y+25, 116, 0);
		}
		
	}
	public void DrawCraftingRecipes(ItemStack[] itemstack,int x,int y){
	    net.minecraft.client.renderer.RenderHelper.func_74520_c();
		GL11.glEnable(32826 /* GL_RESCALE_NORMAL_EXT */);
		
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        GL11.glEnable(GL11.GL_LIGHTING);
        
		for(int i =0;i<3;i++){
			for(int j=0;j<3;j++){ 
				if(itemstack[i+3*j] != null){
					mc.func_175599_af().func_180450_b(itemstack[i+3*j], x+i*18, y+j*18);
					
					 
				}
			}
		}
		mc.func_175599_af().func_180450_b(itemstack[9], x+70, y+18);
	
		GL11.glDisable(32826);
        GL11.glDisable(GL11.GL_COLOR_MATERIAL);
	}
	
	public void DrawAlchemyRecipes(ItemStack[] itemstack,int x,int y){
        mc.field_71446_o.func_110577_a(new ResourceLocation(AlchemyCraft.MODID,"textures/guis/guiLib.png"));
        func_73729_b(x, y, 0, 20 , 80, 80);
        mc.func_175599_af().func_180450_b(itemstack[0], x+30, y+26);
        mc.func_175599_af().func_180450_b(itemstack[1], x+30, y+2);
        mc.func_175599_af().func_180450_b(itemstack[2], x+30, y+53);
        if(itemstack[3] !=null)mc.func_175599_af().func_180450_b( itemstack[3], x+9	, y+16);
        if(itemstack[4] !=null)mc.func_175599_af().func_180450_b( itemstack[4], x+51, y+16);
	}
	
	public void DrawPotionInformation(Item potion,int potionIndex,int x,int y){
		String Materials = "";
		for(String e : LibHandler.getMaterials(potionIndex)){Materials+="\n  "+StatCollector.func_74838_a(e);}
		
		String data=
				"藥水"+StatCollector.func_74838_a(potion.func_77658_a()+".name")+
				"\n配方："+Materials+
				"\n效果："+StatCollector.func_74838_a(ItemPotion.getEffects(potion).func_76453_d())+"Level:"+RomanNumerals[ItemPotion.getEffects(potion).func_76458_c()];
		
		GL11.glColor4f(1, 1, 1, 1);
		mc.func_175599_af().func_180450_b(new ItemStack(potion),x,y);
		field_146289_q.func_78279_b(data, x+20, y, 116, 0);

	}

}
