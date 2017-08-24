package com.byteford.papercast.network;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class writingPacket implements IMessage {

	public String tag;
	public int posx, posy, posz;
	public writingPacket() {
		
	}
	public writingPacket(String tag,int posx,int posy, int posz) {
		this.tag = tag;
		this.posx = posx;
		this.posy = posy;
		this.posz = posz;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		tag = ByteBufUtils.readUTF8String(buf);
		posx = ByteBufUtils.readVarInt(buf, 5);
		posy = ByteBufUtils.readVarInt(buf, 5);
		posz = ByteBufUtils.readVarInt(buf, 5);
		
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, tag);
		ByteBufUtils.writeVarInt(buf, posx, 5);
		ByteBufUtils.writeVarInt(buf, posy, 5);
		ByteBufUtils.writeVarInt(buf, posz, 5);
		
	}

}
