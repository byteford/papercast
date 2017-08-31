package com.byteford.papercast.block;

import com.byteford.papercast.paperCast;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockManaContainer extends Block {

	public BlockManaContainer() {
		super(Material.GLASS);
		setRegistryName("manacontainer");
		setUnlocalizedName("manacontainer");
		setCreativeTab(paperCast.tabPapercast);
	}

}
