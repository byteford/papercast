package com.byteford.papercast.block.TileEntity;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.byteford.papercast.Util.managers.InfuserManager;
import com.byteford.papercast.items.ItemManager;
import com.byteford.papercast.items.infuserItem;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;

public class InfuserTileEntity extends TileEntity implements IItemHandlerModifiable, ITickable {
	
	
	private ItemStackHandler inventory = new ItemStackHandler(2);
	public boolean isPowered = false;
	private boolean hasBeenPowered = false;
	
	private static List<Item> accepts = new ArrayList<Item>();
	private static List<infuserItem> makesList = new ArrayList<infuserItem>();
	public ItemStack makeing;
	public InfuserTileEntity() {
		//accepts.add(Item.getByNameOrId("minecraft:paper"));
		
	}
	public static void addItem(infuserItem makes) {
		accepts.add(makes.infusesFrom);
		makesList.add(makes);
	}
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setTag("inventory", inventory.serializeNBT());
		return super.writeToNBT(compound);
	}
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		inventory.deserializeNBT(compound.getCompoundTag("inventory"));
		super.readFromNBT(compound);
	}

	@Override
	public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
		return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY || super.hasCapability(capability, facing);
	}
	@SuppressWarnings("unchecked")
	@Nullable
	@Override
	public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
		
		return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? (T)this: super.getCapability(capability, facing);
	}
	@Override
	public int getSlots() {
		// TODO Auto-generated method stub
		return inventory.getSlots();
	}
	@Override
	public ItemStack getStackInSlot(int slot) {
		// TODO Auto-generated method stub
		return inventory.getStackInSlot(slot);
	}
	public boolean isItemValidForSlot(int slot, ItemStack stack){
	    return slot != 0 || InfuserManager.recipeExixts(stack);
    }
	@Override
	public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
		// TODO Auto-generated method stub
		if(isItemValidForSlot(slot,stack))
			return inventory.insertItem(slot, stack, simulate);
		
		return stack;
	}
	@Override
	public ItemStack extractItem(int slot, int amount, boolean simulate) {
		/*if(slot==0) {
			return ItemStack.EMPTY;
		}*/
		return inventory.extractItem(slot, amount, simulate);
	}
	@Override
	public int getSlotLimit(int slot) {
		return inventory.getSlotLimit(slot);
	}
	@Override
	public void setStackInSlot(int slot, ItemStack stack) {
		inventory.setStackInSlot(slot, stack);
	}
	@Override
	public void update() {
		if(!this.world.isRemote) {
			if(isPowered) {
				if(!hasBeenPowered) {
					ItemStack stack = getStackInSlot(0);
					//if(stack.getItem() == accepts.get(0)) {
					if(isItemValidForSlot(0,stack)) {
						makeing = InfuserManager.getRecipe(stack).get_output();
						hasBeenPowered = true;
						inventory.extractItem(0, 1, false);	
					}else {
						
					}
				}
			}else if (hasBeenPowered) {
				hasBeenPowered = false;
				inventory.insertItem(1, makeing, false);
			}
			
			
		}
	}
}

