package com.byteford.papercast.block;

import java.util.Random;

import org.apache.logging.log4j.Level;

import com.byteford.papercast.paperCast;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockDispenser;
import net.minecraft.block.BlockHopper;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.BlockRedstoneRepeater;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.items.IItemHandler;

public class MagicInfuser extends Block implements IItemHandler{
	boolean powered = false;
	public MagicInfuser() {
		super(Material.ROCK);
		setRegistryName(paperCast.MODID,"magicinfuser");
		setUnlocalizedName("magicinfuser");
		setCreativeTab(paperCast.tabPapercast);
		
	}
	@Override
	public boolean canConnectRedstone(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side) {
		// TODO Auto-generated method stub
		return true;
		//return super.canConnectRedstone(state, world, pos, side);
	}
	@Override
	public void observedNeighborChange(IBlockState observerState, World world, BlockPos observerPos, Block changedBlock,
			BlockPos changedBlockPos) {
		// TODO Auto-generated method stub
		if(world.isBlockIndirectlyGettingPowered(observerPos)>0){
			if(!powered) {
				powered = true;
			}
		}else {
			powered = false;			
		}
		
		if(powered) {
			
			
		}
		
		super.observedNeighborChange(observerState, world, observerPos, changedBlock, changedBlockPos);
	}
	@Override
	public int getSlots() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public ItemStack getStackInSlot(int slot) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ItemStack extractItem(int slot, int amount, boolean simulate) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getSlotLimit(int slot) {
		// TODO Auto-generated method stub
		return 0;
	}
}
