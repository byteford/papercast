package com.byteford.papercast.items;


import com.byteford.papercast.paperCast;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.brewing.BrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

public class InkBottle extends net.minecraft.item.Item{
    public InkBottle(){
        setRegistryName("inkbottle");
        setUnlocalizedName("inkbottle");
        setCreativeTab(paperCast.tabPapercast);

    }
}
