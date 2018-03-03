package com.byteford.papercast.network;

import net.minecraft.client.Minecraft;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class linkedContainersPacketHandler implements IMessageHandler<linkedContainersPacket,IMessage> {

	@Override
	public IMessage onMessage(linkedContainersPacket message, MessageContext ctx) {
		//IThreadListener mainThread = (WorldServer)ctx.getClientHandler().;
		//ctx.getClientHandler().
//		mainThread.addScheduledTask(new Runnable() {
//			
//			@Override
//			public void run() {
//				
//			}
//		});
		return null;
	}

}
