package com.byteford.papercast.items;

import com.byteford.papercast.paperCast;

import net.minecraft.item.Item;


public class MagicCrystal extends infuserItem{
	public MagicCrystal() {
		super();
		setRegistryName("magiccrystal");
		setUnlocalizedName("magiccrystal");
		setCreativeTab(paperCast.tabPapercast);
		infusesFrom = Item.getByNameOrId("minecraft:diamond");
	}
	
}
