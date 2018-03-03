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

	
	private static final int numberOfContainers = 9;
	
	private ItemStackHandler inventory = new ItemStackHandler(3);

	private BlockPos[] linkedContainers = new BlockPos[numberOfContainers];
	
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setTag("inventory", inventory.serializeNBT());
		compound.setTag("linked", getintArray());
		return super.writeToNBT(compound);
	}
	private NBTTagIntArray getintArray() {
		int[] pos = new int[numberOfContainers *3];
		for(int i = 0; i< numberOfContainers ; i++) {
			if(linkedContainers[i] != null) {
				int[] temp = getIntsFromBlockPos(linkedContainers[i]);
				pos[i*3] = temp[0];
				pos[i*3 + 1] = temp[1];
				pos[i*3 + 2] = temp[2];
			}
		}
		NBTTagIntArray list = new NBTTagIntArray(pos);
		return list;
	}
	private int[] getIntsFromBlockPos(BlockPos pos) {
		return new int[] {pos.getX(),pos.getY(),pos.getZ()};
	}
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		inventory.deserializeNBT(compound.getCompoundTag("inventory"));
		//deserializeNBT(compound);
		linkedContainers = getBlockPosFromIntary(compound.getIntArray("linked"));
		//containers = getContainersFromPoss(linkedContainers);
		super.readFromNBT(compound);
		
	}
	private BlockPos[] getBlockPosFromIntary(int[] intary) {
		BlockPos[] temp = new BlockPos[numberOfContainers];
		for(int i = 0; i< intary.length; i+= 3) {
			temp[i/3] = new BlockPos(intary[i], intary[i+1], intary[i+2]);
		}
		return temp;
	}
	public boolean hasContainerAtId(int id) {
		if(linkedContainers[id] == null) {
			paperCast.LOGGER.info(Integer.toString(id) + " is null");
			return false;
		}
		return world.getTileEntity(linkedContainers[id]) != null;
	}
	public ManaContainerTileEntity getContFromID(int id) {
		//if(containers[id] != null)
		return (ManaContainerTileEntity) world.getTileEntity(linkedContainers[id]);
		//return null;
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
	
	public boolean linkBlock(World worldIn,BlockPos Frompos, BlockPos topos) {
		if(linkedContainers[0]!= null) {
			paperCast.LOGGER.log(Level.INFO,"alreadyLinked to: " + linkedContainers[0]);
			linkedContainers[0]= Frompos;
			this.markDirty();
			paperCast.LOGGER.log(Level.INFO,"rebound to: " + Frompos);
			return false;
		}else {
			linkedContainers[0]= Frompos;
			this.markDirty();
			paperCast.LOGGER.log(Level.INFO,"Linked");
			return true;
		}
	}

}
