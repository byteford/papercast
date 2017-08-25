package com.byteford.papercast.items;

import com.byteford.papercast.paperCast;

import net.minecraft.item.Item;

public class MagicQuill extends infuserItem {
	public MagicQuill() {
		super();
		setRegistryName("magicquill");
		setUnlocalizedName("magicquill");
		setCreativeTab(paperCast.tabPapercast);
		infusesFrom = Item.getByNameOrId("minecraft:feather");
	}
}
