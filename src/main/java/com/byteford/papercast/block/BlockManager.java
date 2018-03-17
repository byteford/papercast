package com.byteford.papercast.block;

import com.byteford.papercast.block.TileEntity.InfuserTileEntity;
import com.byteford.papercast.block.TileEntity.InkMakerTileEntity;
import com.byteford.papercast.block.TileEntity.WritingDeskTileEntity;

import com.byteford.papercast.fluid.FluidManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHopper;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


@GameRegistry.ObjectHolder("papercast")
public class BlockManager {
	public static final MagicInfuser magicinfuser = null;
	public static final WritingDesk writingdesk = null;
	public  static final InkMaker inkmaker = null;
	@SideOnly(Side.CLIENT)
	public static void initModels() {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(magicinfuser), 0, new ModelResourceLocation(magicinfuser.getRegistryName(), "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(writingdesk), 0, new ModelResourceLocation(writingdesk.getRegistryName(), "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(inkmaker),0,new ModelResourceLocation(inkmaker.getRegistryName(),"inventory"));
		FluidManager.initModels();
	}
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().register(new ItemBlock(magicinfuser).setRegistryName(magicinfuser.getRegistryName()));
		event.getRegistry().register(new ItemBlock(writingdesk).setRegistryName(writingdesk.getRegistryName()));
		event.getRegistry().register(new ItemBlock(inkmaker).setRegistryName(inkmaker.getRegistryName()));
		
	}
	public static void regiserBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().register(new MagicInfuser());
		event.getRegistry().register(new WritingDesk());
		event.getRegistry().register(new InkMaker());
		FluidManager.registerFuildBlocks(event);
		
	}
	public static void initialize(FMLInitializationEvent event) {
		GameRegistry.registerTileEntity(InfuserTileEntity.class, "papercast:magicinfuser");
		GameRegistry.registerTileEntity(WritingDeskTileEntity.class, "papercast:writingdesk");
		GameRegistry.registerTileEntity(InkMakerTileEntity.class,"papercast:inkmaker");
	}
}
