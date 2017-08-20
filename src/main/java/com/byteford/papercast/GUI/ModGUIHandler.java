package com.byteford.papercast.GUI;

import com.byteford.papercast.block.TileEntity.InfuserTileEntity;
import com.byteford.papercast.block.TileEntity.WritingDeskTileEntity;
import com.byteford.papercast.block.container.InfuserContainer;
import com.byteford.papercast.block.container.WritingDeskContainer;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ModGUIHandler implements IGuiHandler {
	public static final int INFUSER = 0;
	public static final int WRITINGDESK = 1;
	@Override
	public Container getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID) {
		case INFUSER:
			return new InfuserContainer(player.inventory, (InfuserTileEntity)world.getTileEntity(new BlockPos(x,y,z)));
		case WRITINGDESK:
			return new WritingDeskContainer(player.inventory, (WritingDeskTileEntity)world.getTileEntity(new BlockPos(x,y,z)));
			default:
				return null;
		}
		
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID) {
		case INFUSER:
			return new infuserGUI(getServerGuiElement(ID, player, world, x, y, z),player.inventory);
		case WRITINGDESK:
			return new writingDeskGUI(getServerGuiElement(ID, player, world, x, y, z),player.inventory);
		default:
			return null;
		}
		
	}

}
