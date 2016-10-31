package com.hzy.alchemycraft.handler;

import com.hzy.alchemycraft.worldgen.WorldGenHerbs;
import com.hzy.alchemycraft.worldgen.WorldGenOres;

import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class GenerateHandler {

	@EventHandler
	public static void register(){
		GameRegistry.registerWorldGenerator(new WorldGenHerbs(), 1);
		GameRegistry.registerWorldGenerator(new WorldGenOres(),1);
	}

	
}
