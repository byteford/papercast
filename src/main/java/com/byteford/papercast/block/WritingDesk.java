package com.byteford.papercast.block;

import com.byteford.papercast.paperCast;
import com.byteford.papercast.block.TileEntity.WritingDeskTileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;

public class WritingDesk extends Block {

	public WritingDesk() {
		super(Material.WOOD);
		setRegistryName("writingdesk");
		setUnlocalizedName("writingdesk");
		setCreativeTab(paperCast.tabPapercast);
	}
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		// TODO Auto-generated method stub
		return new WritingDeskTileEntity();
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		// TODO Auto-generated method stub
		return EnumBlockRenderType.MODEL;
	}
}
