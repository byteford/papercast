package com.byteford.papercast.items;

import com.byteford.papercast.block.BlockManager;
import com.byteford.papercast.block.TileEntity.InfuserTileEntity;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


@GameRegistry.ObjectHolder("papercast")
public class ItemManager {
	public static final MagicPaper magicpaper = null;
	public static final MagicQuill magicquill = null;
	public static final MagicCrystal magiccrystal = null;
	public static final ItemBinder itembinder = null;
	public ItemManager() {
		
	}
	public static void initialize(FMLInitializationEvent event) {
		InfuserTileEntity.addItem(magicpaper);
		InfuserTileEntity.addItem(magicquill);
		InfuserTileEntity.addItem(magiccrystal);
		
	}
	@SideOnly(Side.CLIENT)
	public static void initModels() {
		//_magicpaper.initModel();
		ModelLoader.setCustomModelResourceLocation(magicpaper, 0, new ModelResourceLocation(magicpaper.getRegistryName(),"inventory"));
		ModelLoader.setCustomModelResourceLocation(magicquill, 0, new ModelResourceLocation(magicquill.getRegistryName(),"inventory"));
		ModelLoader.setCustomModelResourceLocation(magiccrystal, 0, new ModelResourceLocation(magiccrystal.getRegistryName(),"inventory"));
		ModelLoader.setCustomModelResourceLocation(itembinder, 0, new ModelResourceLocation(itembinder.getRegistryName(),"inventory"));
	}
	public static void registerItems(Register<Item> event) {
		event.getRegistry().register(new MagicPaper());
		event.getRegistry().register(new MagicQuill());
		event.getRegistry().register(new MagicCrystal());
		event.getRegistry().register(new ItemBinder());	
	}

}