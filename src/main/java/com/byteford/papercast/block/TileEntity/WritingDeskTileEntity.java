package com.byteford.papercast.block.TileEntity;

import javax.annotation.Nullable;

import org.apache.logging.log4j.Level;

import com.byteford.papercast.paperCast;
import com.byteford.papercast.items.ItemManager;
import com.byteford.papercast.network.writingPacket;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagIntArray;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;

public class WritingDeskTileEntity extends TileEntity implements IItemHandlerModifiable {

	
	private ItemStackHandler inventory = new ItemStackHandler(8);

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setTag("inventory", inventory.serializeNBT());
		return super.writeToNBT(compound);
	}

	private int[] getIntsFromBlockPos(BlockPos pos) {
		return new int[] {pos.getX(),pos.getY(),pos.getZ()};
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
	    if(isItemValidForSlot(slot,stack))
		    return inventory.insertItem(slot, stack, simulate);
	    return stack;
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
	public boolean isItemValidForSlot(int slot, ItemStack stack){

		switch (slot){
            //quill
			case 0:
			    if(stack.getItem() == ItemManager.magicquill)
			        return true;
				break;
				//magicpaper
			case 1:
			    if(stack.getItem() == ItemManager.magicpaper)
			        return true;
				break;
				//ink
			case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                if(stack.getItem() == ItemManager.inkbottle)
                    return true;
                break;
			default:
				return true;
		}
		return false;
	}
}
