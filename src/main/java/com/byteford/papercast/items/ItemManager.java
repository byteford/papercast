package com.byteford.papercast.items;

import com.byteford.papercast.block.BlockManager;
import com.byteford.papercast.block.TileEntity.InfuserTileEntity;

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
	public static final MagicQuill magicquill = null;
	public static final MagicCrystal magiccrystal = null;
	public static  final InkBottle inkbottle = null;
	public ItemManager() {
		
	}
	public static void initialize(FMLInitializationEvent event) {
		InfuserTileEntity.addItem(magicpaper);
		InfuserTileEntity.addItem(magicquill);
		InfuserTileEntity.addItem(magiccrystal);
        NBTTagCompound tempNbt = new NBTTagCompound();
        tempNbt.setTag("Potion",new NBTTagString("minecraft:water"));
		BrewingRecipeRegistry.addRecipe(new ItemStack(Items.POTIONITEM,1, 0,tempNbt),new ItemStack(Items.DYE,1),new ItemStack(inkbottle,1));
	}
	@SideOnly(Side.CLIENT)
	public static void initModels() {
		//_magicpaper.initModel();
		ModelLoader.setCustomModelResourceLocation(magicpaper, 0, new ModelResourceLocation(magicpaper.getRegistryName(),"inventory"));
		ModelLoader.setCustomModelResourceLocation(magicquill, 0, new ModelResourceLocation(magicquill.getRegistryName(),"inventory"));
		ModelLoader.setCustomModelResourceLocation(magiccrystal, 0, new ModelResourceLocation(magiccrystal.getRegistryName(),"inventory"));
		ModelLoader.setCustomModelResourceLocation(inkbottle,0,new ModelResourceLocation(Items.POTIONITEM.getRegistryName(),"water"));
	}
	public static void registerItems(Register<Item> event) {
		event.getRegistry().register(new MagicPaper());
		event.getRegistry().register(new MagicQuill());
		event.getRegistry().register(new MagicCrystal());
		event.getRegistry().register(new InkBottle());
	}

}