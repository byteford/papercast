package com.byteford.papercast.Util;

import com.byteford.papercast.items.ItemManager;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class InkUtil {

    public static String InkToString(InkTypes[] ink){
        return ink[0].name() + ":" + ink[1].name() + ":" + ink[2].name() + ":" + ink[3].name() + ":" + ink[4].name();
    }
    public static InkTypes[] StringToInk(String ink){
        InkTypes[] temp = new InkTypes[5];
        int loc = ink.indexOf(":",0);
        int loc2;
        temp[0] = InkTypes.valueOf(ink.substring(0,loc-1));
        loc2 = ink.indexOf(":",loc);
        temp[1] = InkTypes.valueOf(ink.substring(loc+1,loc2-1));
        loc = ink.indexOf(":",loc2);
        temp[2] = InkTypes.valueOf(ink.substring(loc2+1,loc-1));
        loc2 = ink.indexOf(":",loc);
        temp[3] = InkTypes.valueOf(ink.substring(loc+1,loc2-1));
        loc = ink.indexOf(":",loc2);
        temp[4]= InkTypes.valueOf(ink.substring(loc2+1,loc-1));
        return new InkTypes[0];
    }
    public static  InkTypes ItemToType(ItemStack stack){
        String typename = stack.getTagCompound().getString("type");
        return InkTypes.valueOf(typename);
    }
    public  static  ItemStack TypeToInk(InkTypes type){
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setString("type",type.name());
        return new ItemStack(ItemManager.inkbottle,1,0,nbt);
    }
}