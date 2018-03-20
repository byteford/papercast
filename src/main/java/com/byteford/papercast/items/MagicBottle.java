package com.byteford.papercast.items;

import com.byteford.papercast.paperCast;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;

public class MagicBottle extends infuserItem {

    public  MagicBottle()
    {
        super();
        setRegistryName("magicbottle");
        setUnlocalizedName("magicbottle");
        setCreativeTab(paperCast.tabPapercast);
        infusesFrom = Item.getByNameOrId("minecraft:potion");


    }
}
