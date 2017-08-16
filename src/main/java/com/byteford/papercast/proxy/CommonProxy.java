package com.byteford.papercast.proxy;

import com.byteford.papercast.items.MagicPaper;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		
	}
	public void init(FMLInitializationEvent event) {
		
	}
	public void postInit(FMLPostInitializationEvent event) {
		
		
	}
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		System.out.println("register");
		event.getRegistry().registerAll(new MagicPaper());
	}

}
