package com.byteford.papercast.block.container;

import javax.swing.plaf.basic.BasicComboBoxUI.ItemHandler;

import com.byteford.papercast.block.TileEntity.InfuserTileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class InfuserContainer extends Container {

	public InfuserContainer(InventoryPlayer playerInv, final InfuserTileEntity infuser) {
		IItemHandler inventory = infuser.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
		addSlotToContainer(new SlotItemHandler(inventory, 0, 80, 35){
			public void onSlotChanged() {
				infuser.markDirty();
			};
		});
		addSlotToContainer(new SlotItemHandler(inventory, 1,100,35){
			public void onSlotChanged() {
				infuser.markDirty();
			};
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
		return true;
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = inventorySlots.get(index);
	
		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
	
			int containerSlots = inventorySlots.size() - playerIn.inventory.mainInventory.size();
	
			if (index < containerSlots) {
				if (!this.mergeItemStack(itemstack1, containerSlots, inventorySlots.size(), true)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.mergeItemStack(itemstack1, 0, containerSlots, false)) {
				return ItemStack.EMPTY;
			}
	
			if (itemstack1.getCount() == 0) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}
	
			if (itemstack1.getCount() == itemstack.getCount()) {
				return ItemStack.EMPTY;
			}
	
			slot.onTake(playerIn, itemstack1);
		}
	
		return itemstack;
	}
}
