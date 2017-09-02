package com.byteford.papercast.items;

import org.apache.logging.log4j.Level;

import com.byteford.papercast.paperCast;
import com.byteford.papercast.block.ILinkable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemBinder extends Item {
	public boolean bound = false; 
	 public ItemBinder() {
		 super();
			setRegistryName("itembinder");
			setUnlocalizedName("itembinder");
			setCreativeTab(paperCast.tabPapercast);
			
	}
	 @Override
	public boolean canItemEditBlocks() {
		// TODO Auto-generated method stub
		return true ;
	}
	 
	 @Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		 //if(!worldIn.isRemote) {
		ILinkable block = (ILinkable) worldIn.getBlockState(pos).getBlock();
		if(block != null) {
			if(player.getHeldItem(hand).getTagCompound() == null) {
				player.getHeldItem(hand).setTagCompound(new NBTTagCompound());
				bound = false;
			}
				if(block.canlinkFrom()) {
					paperCast.LOGGER.log(Level.INFO,"store: " +  pos);
					
					player.getHeldItem(hand).getTagCompound().setFloat("x", pos.getX());
					player.getHeldItem(hand).getTagCompound().setFloat("y", pos.getY());
					player.getHeldItem(hand).getTagCompound().setFloat("z", pos.getZ());
					bound = true;
					return EnumActionResult.SUCCESS;
				}
			if(bound) {
				if(block.canlinkTo()) {
					paperCast.LOGGER.log(Level.INFO,"link: " +  pos);
					block.linkBlock(worldIn,new BlockPos(player.getHeldItem(hand).getTagCompound().getFloat("x"),
							player.getHeldItem(hand).getTagCompound().getFloat("y"),
							player.getHeldItem(hand).getTagCompound().getFloat("z")), pos);
					bound = false;
				}
			}
		}
		return EnumActionResult.FAIL;
	 
		// return EnumActionResult.SUCCESS;
		
	}
}
