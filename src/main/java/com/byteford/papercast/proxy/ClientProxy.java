package com.byteford.papercast.proxy;

import com.byteford.papercast.block.BlockManager;
import com.byteford.papercast.items.ItemManager;


import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy{

	@Override
	public void preInit(FMLPreInitializationEvent event)
	{
		super.preInit(event);
		
		
	}
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		ItemManager.initModels();
		BlockManager.initModels();
	}
	
}
