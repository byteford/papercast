package com.byteford.papercast.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class linkedContainersPacket implements IMessage {

	NBTTagCompound tag;
	
	public linkedContainersPacket() {
		
	}
	public linkedContainersPacket(NBTTagCompound tag){
		this.tag = tag;
	}
	@Override
	public void fromBytes(ByteBuf buf) {
		tag = ByteBufUtils.readTag(buf);
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeTag(buf, tag);
		
	}

}
