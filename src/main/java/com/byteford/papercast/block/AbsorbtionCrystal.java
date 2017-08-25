package com.byteford.papercast.block;

import com.byteford.papercast.paperCast;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class AbsorbtionCrystal extends Block {

	public AbsorbtionCrystal() {
		super(Material.GLASS, MapColor.BLUE);
		setRegistryName("absorbtioncrystal");
		setUnlocalizedName("absorbtioncrystal");
		setCreativeTab(paperCast.tabPapercast);
	}
	

}
