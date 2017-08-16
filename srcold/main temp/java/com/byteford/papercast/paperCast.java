package main.java.com.byteford.papercast;


import org.apache.logging.log4j.Logger;

import main.java.com.byteford.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
	modid = paperCast.MODID,
	name = paperCast.MODNAME,
	version = paperCast.VERSION,
	useMetadata = true
	
)

public class paperCast {
	public static final String MODID = "papercast";
	public static final String MODNAME = "PaperCast";
	public static final String VERSION = "1.12-0.0.0.1";
	
	@Mod.Instance
	public static paperCast instance;
	
	
	@SidedProxy(clientSide = "main.java.com.byteford.proxy.ClientProxy", serverSide = "main.java.com.byteford.proxy.ServerProxy")
	public static CommonProxy proxy;
	
	public static Logger LOGGER;
	
	public paperCast() {
	}
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		LOGGER = event.getModLog();
		proxy.preInit(event);
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
}
