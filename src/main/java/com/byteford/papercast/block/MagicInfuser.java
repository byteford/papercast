package com.byteford.papercast.block;

import com.byteford.papercast.paperCast;
import com.byteford.papercast.block.TileEntity.InfuserTileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class MagicInfuser extends BlockContainer{
	boolean powered = false;
	public static final IProperty<Boolean> VARIANT = PropertyBool.create("powered");
	public MagicInfuser() {
		super(Material.ROCK);
		setRegistryName("magicinfuser");
		setUnlocalizedName("magicinfuser");
		setCreativeTab(paperCast.tabPapercast);
		//this.blockState.getProperties().add(VARIANT);
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, Boolean.valueOf(powered)));
		//BlockFence
	}
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        return state.withProperty(VARIANT, powered);
    }
	protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, VARIANT);
    }
	@Override
	public int getMetaFromState(IBlockState state) {
		return 0;
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
		if(!world.isRemote)
		if(world.isBlockIndirectlyGettingPowered(observerPos)>0){
			if((InfuserTileEntity)world.getTileEntity(observerPos) != null) {
				((InfuserTileEntity)world.getTileEntity(observerPos)).isPowered = true;
			}
			if(!powered) {
				powered = true;
				world.setBlockState(observerPos, observerState.withProperty(VARIANT,  Boolean.valueOf(powered)), 2);
			}
		}else {
			if((InfuserTileEntity)world.getTileEntity(observerPos) != null) {
				((InfuserTileEntity)world.getTileEntity(observerPos)).isPowered = false;
			}
			powered = false;
			world.setBlockState(observerPos, observerState.withProperty(VARIANT, Boolean.valueOf(powered)), 2);
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
//		if(!worldIn.isRemote) {
//			playerIn.openGui(paperCast.instance, ModGUIHandler.INFUSER, worldIn, pos.getX(), pos.getY(), pos.getZ());
//		}
		
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
