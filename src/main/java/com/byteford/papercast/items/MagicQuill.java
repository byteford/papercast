package com.byteford.papercast.items;

import com.byteford.papercast.paperCast;

import net.minecraft.item.Item;

public class MagicQuill extends Item {
	public MagicQuill() {
		super();
		setRegistryName("magicquill");
		setUnlocalizedName("magicquill");
		setCreativeTab(paperCast.tabPapercast);
	}
}
