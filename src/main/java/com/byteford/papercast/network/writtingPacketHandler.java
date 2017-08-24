package com.byteford.papercast.network;

import com.byteford.papercast.block.TileEntity.WritingDeskTileEntity;

import net.minecraft.util.IThreadListener;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class writtingPacketHandler implements IMessageHandler<writingPacket,IMessage> {

	@Override
	public IMessage onMessage(writingPacket message, MessageContext ctx) {
		IThreadListener mainThread = (WorldServer)ctx.getServerHandler().player.getServerWorld();
		mainThread.addScheduledTask(new Runnable() {
			
			@Override
			public void run() {
				((WritingDeskTileEntity)ctx.getServerHandler().player.getServerWorld().getTileEntity(new BlockPos(message.posx,message.posy,message.posz))).MakePaperServer(message.tag);
				
			}
		});
		return null;
	}



}
