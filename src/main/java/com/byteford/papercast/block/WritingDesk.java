package com.byteford.papercast.block;

import com.byteford.papercast.paperCast;
import com.byteford.papercast.GUI.ModGUIHandler;
import com.byteford.papercast.block.TileEntity.WritingDeskTileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WritingDesk extends BlockContainer {

	public WritingDesk() {
		super(Material.WOOD);
		setRegistryName("writingdesk");
		setUnlocalizedName("writingdesk");
		setCreativeTab(paperCast.tabPapercast);
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
			playerIn.openGui(paperCast.instance, ModGUIHandler.WRITINGDESK, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		
		return true;
	}
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return new WritingDeskTileEntity();
	}
	
}
