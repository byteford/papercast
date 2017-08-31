package com.byteford.papercast.block;

import java.awt.print.Paper;

import org.apache.logging.log4j.Level;

import com.byteford.papercast.paperCast;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockManaContainer extends Block implements ILinkable {

	public BlockManaContainer() {
		super(Material.GLASS);
		setRegistryName("manacontainer");
		setUnlocalizedName("manacontainer");
		setCreativeTab(paperCast.tabPapercast);
	}
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
	}
	@Override
	public BlockPos getBlockPos() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void linkBlock(BlockPos pos) {
		paperCast.LOGGER.log(Level.INFO,"Link: " + pos);
		
	}
}
