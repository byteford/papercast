package com.byteford.papercast.block.TileEntity;

import javax.annotation.Nullable;

import com.byteford.papercast.paperCast;
import com.byteford.papercast.items.ItemManager;
import com.byteford.papercast.items.MagicPaper;
import com.byteford.papercast.network.writingPacket;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;

public class WritingDeskTileEntity extends TileEntity implements IItemHandlerModifiable {

	private ItemStackHandler inventory = new ItemStackHandler(3);
	
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
	public void makePaper(String papervalue) {
		paperCast.netWrapper.sendToServer(new writingPacket(papervalue,pos.getX() , pos.getY(), pos.getZ()));
		//MakePaperServer();
		
	}
	public void MakePaperServer(String papervalue) {
		inventory.extractItem(1, 1, false);
		NBTTagCompound temp = new NBTTagCompound();
		temp.setString("effect", papervalue);
		ItemStack item = new ItemStack(ItemManager.magicpaper);
		item.setTagCompound(temp);
		inventory.insertItem(2,item, false);
	}
	@Override
	public int getSlots() {
		return inventory.getSlots();
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return inventory.getStackInSlot(slot);
	}

	@Override
	public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
		return inventory.insertItem(slot, stack, simulate);
	}

	@Override
	public ItemStack extractItem(int slot, int amount, boolean simulate) {
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

}
