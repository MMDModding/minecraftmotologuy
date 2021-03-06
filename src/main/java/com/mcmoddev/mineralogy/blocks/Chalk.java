package com.mcmoddev.mineralogy.blocks;

import com.mcmoddev.mineralogy.Mineralogy;
import com.mcmoddev.mineralogy.ioc.MinIoC;

import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Chalk extends Rock {
	public Chalk() {
		super(false,(float)0.75, (float)1, 0, SoundType.STONE);
		this.setTranslationKey(Mineralogy.MODID + "_chalk");
	}

	@Override
	public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
		return true;
	}
	
	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state,
			int fortune) {
		Item dustChalk = MinIoC.getInstance().resolve(Item.class, "dustChalk", Mineralogy.MODID);
	
		drops.clear();
		drops.add(new ItemStack(dustChalk, 4));
	}
}
