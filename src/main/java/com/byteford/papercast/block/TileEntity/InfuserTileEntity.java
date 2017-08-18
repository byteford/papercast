package com.byteford.papercast.block.TileEntity;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.byteford.papercast.items.ItemManager;
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

	private List<Item> assepts = new ArrayList<Item>();
	public InfuserTileEntity() {
		assepts.add(Item.getByNameOrId("minecraft:paper"));
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
	@Override
	public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
		if(slot==1)
			return stack;
		// TODO Auto-generated method stub
		if(stack.getItem() == assepts.get(0))
			return inventory.insertItem(slot, stack, simulate);
		
		return stack;
	}
	@Override
	public ItemStack extractItem(int slot, int amount, boolean simulate) {
		if(slot==0) {
			return ItemStack.EMPTY;
		}
		return inventory.extractItem(slot, amount, simulate);
	}
	@Override
	public int getSlotLimit(int slot) {
		// TODO Auto-generated method stub
		return inventory.getSlotLimit(slot);
	}
	@Override
	public void setStackInSlot(int slot, ItemStack stack) {
		inventory.setStackInSlot(slot, stack);
	}
	@Override
	public void update() {
		if(!this.world.isRemote) {
		ItemStack stack = getStackInSlot(0);
		if(stack.getItem() == assepts.get(0)) {
			inventory.extractItem(0, 1, false);
			inventory.insertItem(1, new ItemStack(ItemManager.magicpaper), false);
		}else {
		}
		}
	}
	
	

}
