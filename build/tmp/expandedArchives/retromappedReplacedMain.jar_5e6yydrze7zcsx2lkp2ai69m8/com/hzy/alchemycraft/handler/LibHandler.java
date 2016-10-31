package com.hzy.alchemycraft.handler;

import com.hzy.alchemycraft.blocks.ACBlocks;
import com.hzy.alchemycraft.items.ACItems;

import net.minecraft.block.BlockBush;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class LibHandler {

	public static Object[][] Recipes={
			/*0 初級治療藥水*/		{ACItems.FullDistilledBottle,Item.func_150898_a(ACBlocks.Peacebloom),Item.func_150898_a(ACBlocks.Silverleaf)},
			/*1 初級堅韌藥水*/		{ACItems.FullDistilledBottle,Item.func_150898_a(ACBlocks.Peacebloom),Item.func_150898_a(ACBlocks.Earthroot),Item.func_150898_a(ACBlocks.Earthroot)},
			/*2 初級敏捷藥水*/		{ACItems.FullDistilledBottle,Item.func_150898_a(ACBlocks.Swiftthistle),Item.func_150898_a(ACBlocks.Silverleaf)},
			/*3 初級防禦藥水*/		{ACItems.FullDistilledBottle,Item.func_150898_a(ACBlocks.Silverleaf),Item.func_150898_a(ACBlocks.Silverleaf)},
			/*4 初級力量藥劑*/		{ACItems.FullDistilledBottle,Item.func_150898_a(ACBlocks.Silverleaf),Item.func_150898_a(ACBlocks.Earthroot)},
			/*5 初級隱形藥劑*/		{ACItems.FullDistilledBottle,Item.func_150898_a(ACBlocks.Silverleaf),Item.func_150898_a(ACBlocks.Fadeleaf)},
			/*6 初級水肺藥水*/		{ACItems.FullDistilledBottle,Item.func_150898_a(ACBlocks.Silverleaf),new ItemStack(ACItems.FishOilBottle.func_77642_a(Items.field_151069_bo))},
			/*7 初級夜視藥水*/		{ACItems.FullDistilledBottle,new ItemStack(ACItems.FishOilBottle.func_77642_a(Items.field_151069_bo)),Item.func_150898_a(ACBlocks.Briarthorn)},
			
			/*8 治療藥水*/	 	{ACItems.FullDistilledBottle,Item.func_150898_a(ACBlocks.Bruiseweed),Item.func_150898_a(ACBlocks.Briarthorn)},
			/*9 堅韌藥水*/    	{ACItems.FullDistilledBottle,Item.func_150898_a(ACBlocks.Bruiseweed),Item.func_150898_a(ACBlocks.Stranglekelp)},
			/*10 敏捷藥水*/ 		{ACItems.FullDistilledBottle,Item.func_150898_a(ACBlocks.Goldthorn),Item.func_150898_a(ACBlocks.Stranglekelp)},
			/*11 防禦藥水*/		{ACItems.FullDistilledBottle,Item.func_150898_a(ACBlocks.WildSteelbloom),Item.func_150898_a(ACBlocks.Stranglekelp)},
			/*12 力量藥水*/		{ACItems.FullDistilledBottle,Item.func_150898_a(ACBlocks.Kingsblood),Item.func_150898_a(ACBlocks.Earthroot)},
			/*13 隱形藥水*/		{ACItems.FullDistilledBottle,Item.func_150898_a(Blocks.field_150338_P),Item.func_150898_a(ACBlocks.Silverleaf)},
			/*14 水肺藥水*/		{ACItems.FullDistilledBottle,new ItemStack(ACItems.FishOilBottle.func_77642_a(Items.field_151069_bo)),new ItemStack(ACItems.FishOilBottle.func_77642_a(Items.field_151069_bo)),Item.func_150898_a(ACBlocks.Stranglekelp)},
			/*15 夜視藥水*/		{ACItems.FullDistilledBottle,new ItemStack(ACItems.FishOilBottle.func_77642_a(Items.field_151069_bo)),Item.func_150898_a(ACBlocks.Goldthorn)},
			/*16 防火藥水*/     	{ACItems.FullDistilledBottle,new ItemStack(ACItems.FireOilBottle.func_77642_a(Items.field_151069_bo)),Item.func_150898_a(ACBlocks.WildSteelbloom)},
			/*17 淨化藥水*/		{ACItems.FullDistilledBottle,Items.field_151117_aB,Item.func_150898_a(ACBlocks.Kingsblood)},
			/*18 重生藥水*/		{ACItems.FullDistilledBottle,new ItemStack(ACItems.HealingPotion.func_77642_a(Items.field_151069_bo)),Item.func_150898_a(ACBlocks.Goldthorn)},	
			/*19 飛行藥水*/		{ACItems.FullDistilledBottle,Item.func_150898_a(ACBlocks.Stranglekelp),new ItemStack(Items.field_151008_G),Item.func_150898_a(ACBlocks.Goldthorn)},	
			
			/*20 迷幻之油*/		{ACItems.FullDistilledBottle,new ItemStack(ACItems.CorpseOilBottle.func_77642_a(Items.field_151069_bo)),new ItemStack(ACItems.PoisonOilBottle.func_77642_a(Items.field_151069_bo)),new ItemStack(ACItems.YinYangOilBottle)},
			/*21 魚   油*/		{ACItems.FullDistilledBottle,Items.field_151115_aP},	
			/*22 屍   油*/		{ACItems.FullDistilledBottle,Items.field_151103_aS,Items.field_151078_bh},
			/*23 凋零之油1*/		{ACItems.FullDistilledBottle,new ItemStack(ACItems.CorpseOilBottle.func_77642_a(Items.field_151069_bo)),Items.field_151075_bm,Item.func_150898_a(ACBlocks.Kingsblood)},
			/*24 凋零之油2*/		{ACItems.FullDistilledBottle,new ItemStack(Items.field_151144_bL, 1, 1)},
			/*25 陰陽之油*/		{ACItems.FullDistilledBottle,Item.func_150898_a(Blocks.field_150327_N),Item.func_150898_a(Blocks.field_150338_P)},
			/*26 火焰之油1*/		{ACItems.FullDistilledBottle,Items.field_151065_br},
			/*27 火焰之油2*/		{ACItems.FullDistilledBottle,Item.func_150898_a(ACBlocks.Cinderpearl)},
			/*28 生長之油*/		{ACItems.FullDistilledBottle,Item.func_150898_a(ACBlocks.Bruiseweed),new ItemStack(Items.field_151100_aR, 1, 15)},
			/*29 轉換之油*/		{ACItems.FullDistilledBottle,new ItemStack(ACItems.YinYangOilBottle.func_77642_a(Items.field_151069_bo)),Item.func_150898_a(ACBlocks.Mageroyal)},
			/*30 冰霜之油*/		{ACItems.FullDistilledBottle,Item.func_150898_a(Blocks.field_150432_aD),Item.func_150898_a(Blocks.field_150433_aE)},
			/*31 邪毒之油*/		{ACItems.FullDistilledBottle,Items.field_151070_bp,Items.field_151170_bI,new ItemStack(Items.field_151115_aP,1,3),Item.func_150898_a(ACBlocks.Briarthorn)},
			/*32 奪魂之油*/		{ACItems.FullDistilledBottle,Items.field_151016_H,Items.field_151016_H,Items.field_151016_H,Items.field_151016_H,Item.func_150898_a(ACBlocks.Peacebloom)}
		};


		
		public static String[][] Materials={
			/*初級治療藥水*/	{"gui.Peacebloom_1.action","gui.Silverleaf_1.action"},
			/*初級堅韌藥水*/ 	{"gui.Peacebloom_1.action","gui.Earthroot_2.action"},
			/*初級敏捷藥水*/	{"gui.Swiftthistle_1.action","gui.Silverleaf_1.action"},
			/*初級防禦藥水*/	{"gui.Silverleaf_2.action"},
			/*初級力量藥劑*/	{"gui.Earthroot_1.action","gui.Silverleaf_1.action"},
			/*初級隱形藥劑*/	{"gui.Silverleaf_1.action","gui.Fadeleaf_1.action"},
			/*初級水肺藥水*/	{"gui.Silverleaf_1.action","gui.FishOil_1.action"},
			/*初級夜視藥水*/	{"gui.FishOil_1.action","gui.Briarthorn_1.action"},
			
			/*治療藥水*/		{"gui.Bruiseweed_1.action","gui.Briarthorn_1.action"},
			/*堅韌藥水*/		{"gui.Bruiseweed_1.action","gui.Stranglekelp_1.action"},
			/*敏捷藥水*/  	{"gui.Goldthorn_1.action","gui.Stranglekelp_1.action"},
			/*防禦藥水*/  	{"gui.WildSteelbloom_1.action","gui.Stranglekelp_1.action"},
			/*力量藥水*/  	{"gui.Kingsblood_1.action","gui.Earthroot_1.action"},
			/*隱形藥水*/  	{"gui.brown_mushroom_1.action","gui.Silverleaf_1.action"},
			/*水肺藥水*/  	{"gui.FishOil_2.action","gui.Stranglekelp_1.action"},
			/*夜視藥水*/  	{"gui.Goldthorn_1.action","gui.FishOil_1.action"},
			/*防火藥水*/  	{"gui.FireOil_1.action","gui.WildSteelbloom_1.action"},
			/*淨化藥水*/  	{"gui.milk_1.action","gui.Kingsblood_1.action"},
			/*重生藥水*/  	{"gui.HealingPotion_1.action","gui.Goldthorn_1.action"},
			/*飛行藥水*/		{"gui.Stranglekelp_1.action","gui.feather_1.action","gui.Goldthorn_1.action"},
			
			/*迷幻之油*/		{"gui.CorpseOil_1.action","gui.PoisonOil_1.action","gui.YinYangOil_1.action"},
			/*魚   油*/  	{"gui.Fish_1.action"},
			/*屍   油*/  	{"gui.bone_1.action","gui.rotten_flesh_1.action"},
			/*凋零之油1*/		{"gui.CorpseOil_1.action","gui.nether_wart_1.action","gui.Kingsblood_1.action"},
			/*凋零之油2*/		{"gui.WitherSkeletonHead_1.action"},
			/*陰陽之油*/		{"gui.yellow_flower_1.action","gui.brown_mushroom_1.action"},
			/*火焰之油1*/		{"gui.blaze_powder_1.action"},
			/*火焰之油2*/		{"gui.Cinderpearl_1.action"},
			/*生長之油*/		{"gui.Bruiseweed_1.action","gui.bonemeal_1.action"},
			/*轉換之油*/		{"gui.YinYangOil_1.action","gui.Mageroyal_1.action"},
			/*冰霜之油*/		{"gui.IceBlock_1.action","gui.SnowBlock_1.action"},
			/*邪毒之油*/		{"gui.spider_eye_1.action","gui.poisonous_potato_1.action","gui.pufferfish_1.action","gui.Briarthorn_1.action"},
			/*奪魂之油*/   	{"gui.gunpowder_4.action","gui.Peacebloom_1.action"}
		};
		
		public static BlockBush [] Herbs={
				ACBlocks.Peacebloom,ACBlocks.Silverleaf,ACBlocks.Earthroot,ACBlocks.Mageroyal,
				ACBlocks.Fadeleaf,ACBlocks.Briarthorn,ACBlocks.Swiftthistle,ACBlocks.Bruiseweed,
				ACBlocks.WildSteelbloom,ACBlocks.Kingsblood,ACBlocks.Goldthorn,ACBlocks.Stranglekelp,
				ACBlocks.Cinderpearl
		};
		public static String[] HerbsName={
				"tile.Peacebloom.name","tile.Silverleaf.name","tile.Earthroot.name","tile.Mageroyal.name",
				"tile.Fadeleaf.name","tile.Briarthorn.name","tile.Swiftthistle.name","tile.Bruiseweed.name",
				"tile.WildSteelbloom.name","tile.Kingsblood.name","tile.Goldthorn.name","tile.Stranglekelp.name",
				"tile.Cinderpearl.anme","tile.Mushroom.name"};
		public static String[] HerbsData={
				"任何","任何","任何","高山(>80)",
				"熱帶草原","熱帶草原","叢林","平原",
				"高山(>80)","森林","熱帶草原","沼澤",
				"沙漠","沼澤"
		};
		public LibHandler(){

		}
		public static String[] getMaterials(int i){
			return Materials[i];
		}
		public Object[] getRecipes(int i){
			return Recipes[i];
		}

}
