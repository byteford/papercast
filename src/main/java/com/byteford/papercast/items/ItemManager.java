package com.byteford.papercast.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


@GameRegistry.ObjectHolder("papercast")
public class ItemManager {
	public static final MagicPaper magicpaper = null;
	public ItemManager() {
		
	}
	@SideOnly(Side.CLIENT)
	public static void initModels() {
		//_magicpaper.initModel();
		ModelLoader.setCustomModelResourceLocation(magicpaper, 0, new ModelResourceLocation(magicpaper.getRegistryName(),"inventory"));
		
	}


}