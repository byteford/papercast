package com.byteford.papercast.proxy;

import com.byteford.papercast.block.BlockManager;
import com.byteford.papercast.fluid.FluidManager;
import com.byteford.papercast.items.ItemManager;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;

@Mod.EventBusSubscriber
public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		FluidManager.preInit();
	}
	public void init(FMLInitializationEvent event) {
		ItemManager.initialize(event);
		BlockManager.initialize(event);

	}
	public void postInit(FMLPostInitializationEvent event) {
		
		
	}
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		ItemManager.registerItems(event);
		BlockManager.registerItems(event);
	}
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		BlockManager.regiserBlocks(event);
	}

}
