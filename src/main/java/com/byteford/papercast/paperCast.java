package com.byteford.papercast;


import com.byteford.papercast.Util.managers.InfuserManager;
import com.byteford.papercast.fluid.FluidManager;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import com.byteford.papercast.GUI.ModGUIHandler;
import com.byteford.papercast.GUI.writingDeskGUI;
import com.byteford.papercast.items.ItemManager;
import com.byteford.papercast.network.writingPacket;
import com.byteford.papercast.network.writtingPacketHandler;
import com.byteford.papercast.proxy.CommonProxy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.handshake.NetworkDispatcher;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

@Mod(
	modid = paperCast.MODID,
	name = paperCast.MODNAME,
	version = paperCast.VERSION,
	useMetadata = true
	
)

public class paperCast {
	public static final String MODID = "papercast";
	public static final String MODNAME = "papercast";
	public static final String VERSION = "1.12-0.0.0.1";
	
	public static SimpleNetworkWrapper netWrapper;
	
	@Mod.Instance
	public static paperCast instance;
	
	
	@SidedProxy(clientSide = "com.byteford.papercast.proxy.ClientProxy", serverSide = "com.byteford.papercast.proxy.ServerProxy")
	public static CommonProxy proxy;
	
	public static Logger LOGGER;
	
	public paperCast() {
	}
	
	public static final CreativeTabs tabPapercast = new CreativeTabs("papercast") {
		
		@Override
		public ItemStack getTabIconItem() {
			// TODO Auto-generated method stub
			return new ItemStack(ItemManager.magicpaper);
		}
	};
	static{
		FluidRegistry.enableUniversalBucket();
	}
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		LOGGER = event.getModLog();
		proxy.preInit(event);

		NetworkRegistry.INSTANCE.registerGuiHandler(this, new ModGUIHandler());
		netWrapper = NetworkRegistry.INSTANCE.newSimpleChannel(MODNAME);
		netWrapper.registerMessage(writtingPacketHandler.class, writingPacket.class, 0, Side.SERVER);
	}
	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.init(event);
	}
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		proxy.postInit(event);
	}
	@Mod.EventHandler
	public void handleIMC(FMLInterModComms.IMCEvent event){
		MangaerInitialize();
	}
	private void MangaerInitialize(){
		InfuserManager.initialize();
		LOGGER.log(Level.INFO,"Man done");
	}
}
