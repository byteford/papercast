package com.byteford.papercast.block.container;

import com.byteford.papercast.block.TileEntity.InfuserTileEntity;
import com.byteford.papercast.block.TileEntity.WritingDeskTileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class WritingDeskContainer extends Container {

	public WritingDeskTileEntity writingDesk;
	
	
	public WritingDeskContainer(InventoryPlayer playerInv, final WritingDeskTileEntity WritingDesk) {
		writingDesk = WritingDesk;
		IItemHandler inventory = WritingDesk.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
		addSlotToContainer(new SlotItemHandler(inventory, 0, 20, 20){
			@Override
			public void onSlotChanged() {
				WritingDesk.markDirty();
			}
		});
		addSlotToContainer(new SlotItemHandler(inventory, 1, 150, 40){
			@Override
			public void onSlotChanged() {
				WritingDesk.markDirty();
			}
		});
		addSlotToContainer(new SlotItemHandler(inventory, 2, 150, 60){
			@Override
			public void onSlotChanged() {
				WritingDesk.markDirty();
			}
		});
		
		for(int i =0; i< 3; i++) {
			for(int j = 0; j < 9; j++) {
				addSlotToContainer(new Slot(playerInv, j+i * 9 + 9,8 +j * 18, 84 + i*18 ));
			}
		}
		for(int k=0; k < 9; k++) {
			addSlotToContainer(new Slot(playerInv,k,8+k*18, 142));
		}
		
		
		
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		return true;
	}
	

}
