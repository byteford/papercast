package main.java.com.byteford.items;

import main.java.com.byteford.papercast.paperCast;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MagicPaper extends Item{
	public MagicPaper() {
		super();
		setRegistryName("magicpaper");
		setUnlocalizedName("magicpaper");
		setCreativeTab(CreativeTabs.MISC);
	}
	@SideOnly(Side.CLIENT)
	public void initModel() {
		System.out.println(getRegistryName());
		paperCast.LOGGER.info((new ModelResourceLocation(getRegistryName(),"inventory").getVariant()));
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(),"inventory"));
		
	}
}
