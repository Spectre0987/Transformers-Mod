package com.marctron.transformersmod.blocks;

import java.util.Random;

import com.marctron.transformersmod.init.ModItems;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RedEnergonoreBlock extends BlockBase
{

	public RedEnergonoreBlock(String name, Material material) {
		super(name, material);
		setSoundType(SoundType.METAL);
		setHardness(5.0F);
		setHarvestLevel("pickaxe", 2);
		setLightLevel(0.4F);
	}

	@Override
    public Item getItemDropped(IBlockState state, Random par2Random, int par3) {
        return new ItemStack(ModItems.RED_ENERGON_SHARD).getItem();
        
    }
	
	public int quantityDroppedWithBonus(int fortune, Random random)
    {
        return 2 + random.nextInt(6);
    }
	
}
