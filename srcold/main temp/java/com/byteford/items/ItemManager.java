package main.java.com.byteford.items;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


@GameRegistry.ObjectHolder("paperCraft")
public class ItemManager {
	public static final MagicPaper _magicpaper = new MagicPaper();
	public ItemManager() {
		
	}
	@SideOnly(Side.CLIENT)
	public static void initModels() {
		_magicpaper.initModel();
		
	}


}