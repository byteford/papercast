package com.byteford.papercast.block.TileEntity;

import javax.annotation.Nullable;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class InfuserTileEntity extends TileEntity implements IItemHandler {
	
	
	private ItemStackHandler inventory = new ItemStackHandler(1);

	

	
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
		
		return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? (T)inventory: super.getCapability(capability, facing);
	}
	
	//Inherited from IItemHandler
	@Override
	public int getSlots() {
		// TODO Auto-generated method stub
		return 1;
	}
	@Override
	public ItemStack getStackInSlot(int slot) {
			return null;
		
	}
	@Override
	public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ItemStack extractItem(int slot, int amount, boolean simulate) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getSlotLimit(int slot) {
		// TODO Auto-generated method stub
		return 64;
	}
}
