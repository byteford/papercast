package com.byteford.papercast.block;

import java.util.Random;

import javax.swing.plaf.basic.BasicComboBoxUI.ItemHandler;

import org.apache.logging.log4j.Level;

import com.byteford.papercast.paperCast;
import com.byteford.papercast.GUI.ModGUIHandler;
import com.byteford.papercast.block.TileEntity.InfuserTileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockDispenser;
import net.minecraft.block.BlockHopper;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.BlockRedstoneRepeater;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class MagicInfuser extends BlockContainer{
	boolean powered = false;
	public MagicInfuser() {
		super(Material.ROCK);
		setRegistryName("magicinfuser");
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
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return new InfuserTileEntity();
	}
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		// TODO Auto-generated method stub
		return EnumBlockRenderType.MODEL;
	}
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(!worldIn.isRemote) {
			playerIn.openGui(paperCast.instance, ModGUIHandler.INFUSER, worldIn, pos.getX(), pos.getY(), pos.getZ());

			}
		
		return true;
	}
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		InfuserTileEntity tile = (InfuserTileEntity) worldIn.getTileEntity(pos);
		IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
		ItemStack stack = itemHandler.getStackInSlot(0);
		if(!stack.isEmpty()) {
			EntityItem item = new EntityItem(worldIn,pos.getX(),pos.getY(),pos.getZ(), stack);
			worldIn.spawnEntity(item);
		}
		super.breakBlock(worldIn, pos, state);
	}

}
