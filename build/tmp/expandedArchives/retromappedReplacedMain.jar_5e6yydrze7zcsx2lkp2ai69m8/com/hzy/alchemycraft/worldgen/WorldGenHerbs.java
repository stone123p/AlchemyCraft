package com.hzy.alchemycraft.worldgen;

import java.util.Random;

import com.hzy.alchemycraft.blocks.ACBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockFlowerPot.EnumFlowerType;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.common.IWorldGenerator;


public class WorldGenHerbs implements IWorldGenerator
{

	@Override
	public void generate(Random random, int x, int z, World world, IChunkProvider chunkGenerator,
			IChunkProvider chunkProvider) {
		switch(world.field_73011_w.func_177502_q()){
		case 1:
			break;
		case 0:
			generateSuface(random,x*16,z*16,world);
			break;
		case -1:
			break;
		}
		
	}

	private void generateSuface(Random random, int x, int z, World world) {
		BiomeGenBase biome = world.func_180494_b(new BlockPos(x,1,z));
		addHerbsSpawn(world,random,x,z,60,150,ACBlocks.Swiftthistle,BiomeDictionary.isBiomeOfType(biome,Type.JUNGLE));
		addHerbsSpawn(world,random,x,z,60,200,ACBlocks.Briarthorn,BiomeDictionary.isBiomeOfType(biome,Type.SAVANNA));
		addHerbsSpawn(world,random,x,z,60,200,ACBlocks.Bruiseweed,BiomeDictionary.isBiomeOfType(biome,Type.PLAINS));
		addHerbsSpawn(world,random,x,z,60,200,ACBlocks.Fadeleaf,BiomeDictionary.isBiomeOfType(biome,Type.SAVANNA));
		addHerbsSpawn(world,random,x,z,60,150,ACBlocks.Goldthorn,BiomeDictionary.isBiomeOfType(biome,Type.SAVANNA));
		addHerbsSpawn(world,random,x,z,60,150,ACBlocks.Stranglekelp,BiomeDictionary.isBiomeOfType(biome,Type.SWAMP));
		addHerbsSpawn(world,random,x,z,60,150,ACBlocks.Kingsblood,BiomeDictionary.isBiomeOfType(biome,Type.FOREST));
		addHerbsSpawn(world,random,x,z,60,150,ACBlocks.Cinderpearl,BiomeDictionary.isBiomeOfType(biome,Type.DRY));
		addHerbsSpawn(world,random,x,z,80,200,ACBlocks.WildSteelbloom,true);	
		addHerbsSpawn(world,random,x,z,80,200,ACBlocks.Mageroyal,true);
		addHerbsSpawn(world,random,x,z,60,200,ACBlocks.Peacebloom,true);
		addHerbsSpawn(world,random,x,z,60,200,ACBlocks.Silverleaf,true);
		addHerbsSpawn(world,random,x,z,60,200,ACBlocks.Earthroot,true);
		
	}

	private void addHerbsSpawn(World world, Random random, int blockXPos, int blockZPos, int minY,int maxY,BlockBush herb,boolean isBiome) {
		int maxX=16;
		int maxZ=16;
		
	    int diffBtwMinMaxY=maxY-minY;
	    if(isBiome){
	    	int XPos = blockXPos + random.nextInt(maxX);
	    	int YPos = minY + random.nextInt(diffBtwMinMaxY);
	    	int ZPos = blockZPos + random.nextInt(maxZ);

	    	BlockPos FPos=new BlockPos( XPos, YPos, ZPos);

	    	new WorldGenBushs(herb).func_180709_b(world, random, FPos);
	    }
	}



    
    
}
