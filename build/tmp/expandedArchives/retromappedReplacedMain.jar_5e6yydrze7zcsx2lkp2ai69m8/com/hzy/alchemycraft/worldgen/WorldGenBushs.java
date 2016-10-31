package com.hzy.alchemycraft.worldgen;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenBushs extends WorldGenerator
{
    private BlockBush flower;
    private IBlockState field_175915_b;

    public WorldGenBushs(BlockBush p_i45632_1)
    {
        this.setGeneratedBlock(p_i45632_1);
    }

    public void setGeneratedBlock(BlockBush p_175914_1_)
    {
        this.flower = p_175914_1_;
        this.field_175915_b = p_175914_1_.func_176223_P();
    }

    public boolean func_180709_b(World worldIn, Random rand, BlockPos position)
    {
        for (int i = 0; i < 16; ++i)
        {
            BlockPos blockpos = position.func_177982_a(rand.nextInt(8) , rand.nextInt(4) , rand.nextInt(8));

            if (worldIn.func_175623_d(blockpos) && (!worldIn.field_73011_w.func_177495_o() || blockpos.func_177956_o() < 255) && this.flower.func_180671_f(worldIn, blockpos, this.field_175915_b))
            {
                worldIn.func_180501_a(blockpos,this.field_175915_b, 2);
            }
        }

        return true;
    }

	
}
