package com.byteford.papercast.block.container;

import com.byteford.papercast.block.TileEntity.InfuserTileEntity;
import com.byteford.papercast.block.TileEntity.WritingDeskTileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class WritingDeskContainer extends Container {

	public WritingDeskContainer(InventoryPlayer playerInv, final WritingDeskTileEntity infuser) {
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		return true;
	}

}
