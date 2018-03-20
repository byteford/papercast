package com.byteford.papercast.items;

import com.byteford.papercast.block.BlockManager;
import com.byteford.papercast.block.TileEntity.InfuserTileEntity;

import com.byteford.papercast.paperCast;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagString;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.brewing.BrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


@GameRegistry.ObjectHolder("papercast")
public class ItemManager {
	public static final MagicPaper magicpaper = null;
	public static final Item magicquill = null;
	public static final Item magiccrystal = null;
	public static  final Item inkbottle = null;
	public static  final Item magicbottle = null;
	public ItemManager() {
		
	}
	public static void initialize(FMLInitializationEvent event) {
		BrewingRecipeRegistry.addRecipe(new ItemStack(magicbottle,1),new ItemStack(Items.DYE,1),new ItemStack(inkbottle,1));
	}
	@SideOnly(Side.CLIENT)
	public static void initModels() {
		//_magicpaper.initModel();
		ModelLoader.setCustomModelResourceLocation(magicpaper, 0, new ModelResourceLocation(magicpaper.getRegistryName(),"inventory"));
		ModelLoader.setCustomModelResourceLocation(magicquill, 0, new ModelResourceLocation(magicquill.getRegistryName(),"inventory"));
		ModelLoader.setCustomModelResourceLocation(magiccrystal, 0, new ModelResourceLocation(magiccrystal.getRegistryName(),"inventory"));
		ModelLoader.setCustomModelResourceLocation(inkbottle,0,new ModelResourceLocation(Items.POTIONITEM.getRegistryName(),"water"));
		ModelLoader.setCustomModelResourceLocation(magicbottle,0,new ModelResourceLocation(magicbottle.getRegistryName(),"inventory"));
	}
	public static void registerItems(Register<Item> event) {
		event.getRegistry().register(new MagicPaper());
        event.getRegistry().register(new Item().setUnlocalizedName("magicquill").setRegistryName("magicquill").setCreativeTab(paperCast.tabPapercast));
		event.getRegistry().register(new Item().setUnlocalizedName("magiccrystal").setRegistryName("magiccrystal").setCreativeTab(paperCast.tabPapercast));
        event.getRegistry().register(new Item().setUnlocalizedName("inkbottle").setRegistryName("inkbottle").setCreativeTab(paperCast.tabPapercast));
        event.getRegistry().register(new Item().setUnlocalizedName("magicbottle").setRegistryName("magicbottle").setCreativeTab(paperCast.tabPapercast));
	}

}