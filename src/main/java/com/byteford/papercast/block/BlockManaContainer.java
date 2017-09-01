package com.byteford.papercast.block;

import com.byteford.papercast.paperCast;
import com.byteford.papercast.block.TileEntity.ManaContainerTileEntity;

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

public class BlockManaContainer extends BlockContainer implements ILinkable {

	public BlockManaContainer() {
		super(Material.GLASS);
		setRegistryName("manacontainer");
		setUnlocalizedName("manacontainer");
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
		
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
	}
	@Override
	public boolean linkBlock(World worldin, BlockPos Frompos, BlockPos topos) {
		return false;
		
	}
	@Override
	public boolean canlinkFrom() {
		return true;
	}
	@Override
	public boolean canlinkTo() {
		return false;
	}
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new ManaContainerTileEntity();
	}
}
