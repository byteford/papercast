package com.byteford.papercast.block;

import com.byteford.papercast.paperCast;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class MagicInfuser extends Block {

	public MagicInfuser() {
		super(Material.ROCK);
		setRegistryName(paperCast.MODID,"magicinfuser");
		setUnlocalizedName("magicinfuser");
		setCreativeTab(paperCast.tabPapercast);
	}

}
