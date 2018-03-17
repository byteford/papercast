package com.byteford.papercast.block.container;

import com.byteford.papercast.block.TileEntity.InfuserTileEntity;
import com.byteford.papercast.block.TileEntity.WritingDeskTileEntity;

import com.byteford.papercast.items.InkBottle;
import com.byteford.papercast.items.ItemManager;
import com.byteford.papercast.items.MagicPaper;
import com.byteford.papercast.items.MagicQuill;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nonnull;

public class WritingDeskContainer extends Container {

	public WritingDeskTileEntity writingDesk;
	
	
	public WritingDeskContainer(InventoryPlayer playerInv, final WritingDeskTileEntity WritingDesk) {
		writingDesk = WritingDesk;
		IItemHandler inventory = WritingDesk.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
		//container from quill
		addSlotToContainer(new SlotItemHandler(inventory, 0, 20, 20){
			@Override
			public void onSlotChanged() {
				WritingDesk.markDirty();
			}

			@Override
			public boolean isItemValid(@Nonnull ItemStack stack) {

				if( stack.getItem() instanceof MagicQuill)
					return true;
				return false;
			}
		});
		//magic paper input
		addSlotToContainer(new SlotItemHandler(inventory, 1, 80, 35){
			@Override
			public void onSlotChanged() {
				WritingDesk.markDirty();
			}
			@Override
			public boolean isItemValid(@Nonnull ItemStack stack) {

				if( stack.getItem() instanceof MagicPaper)
					return true;
				return false;
			}
		});
		//out put
		addSlotToContainer(new SlotItemHandler(inventory, 2, 152, 61){
			@Override
			public void onSlotChanged() {
				WritingDesk.markDirty();
			}

		});
		// ink slot 1
        addSlotToContainer(new SlotItemHandler(inventory, 3, 80, 11){
            @Override
            public void onSlotChanged() {
                WritingDesk.markDirty();
            }
            @Override
            public boolean isItemValid(@Nonnull ItemStack stack) {

                if( stack.getItem() instanceof InkBottle)
                    return true;
                return false;
            }
        });
        // ink slot 2
        addSlotToContainer(new SlotItemHandler(inventory, 4, 108, 35){
            @Override
            public void onSlotChanged() {
                WritingDesk.markDirty();
            }
            @Override
            public boolean isItemValid(@Nonnull ItemStack stack) {

                if( stack.getItem() instanceof InkBottle)
                    return true;
                return false;
            }
        });
        // ink slot 3
        addSlotToContainer(new SlotItemHandler(inventory, 5, 96, 57){
            @Override
            public void onSlotChanged() {
                WritingDesk.markDirty();
            }
            @Override
            public boolean isItemValid(@Nonnull ItemStack stack) {

                if( stack.getItem() instanceof InkBottle)
                    return true;
                return false;
            }
        });
        //ink slot 4
        addSlotToContainer(new SlotItemHandler(inventory, 6, 67, 58){
            @Override
            public void onSlotChanged() {
                WritingDesk.markDirty();
            }
            @Override
            public boolean isItemValid(@Nonnull ItemStack stack) {

                if( stack.getItem() instanceof InkBottle)
                    return true;
                return false;
            }
        });
        //ink slot 5
        addSlotToContainer(new SlotItemHandler(inventory, 7, 52, 35){
            @Override
            public void onSlotChanged() {
                WritingDesk.markDirty();
            }
            @Override
            public boolean isItemValid(@Nonnull ItemStack stack) {

                if( stack.getItem() instanceof InkBottle)
                    return true;
                return false;
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
