package com.byteford.papercast.Util.managers;

import com.byteford.papercast.items.ItemManager;
import com.byteford.papercast.items.MagicPaper;
import gnu.trove.map.hash.THashMap;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

import java.util.Map;
public class InfuserManager {

    private static Map<Item, InfuserRecipe> _recipeMap = new THashMap<>();

    public static InfuserRecipe getRecipe(ItemStack input){
        if(input.isEmpty())
            return null;
        InfuserRecipe recipe = _recipeMap.get(input.getItem());
        return recipe;
    }
    public static  boolean recipeExixts(ItemStack input){
        return getRecipe(input) != null;
    }
    public static  InfuserRecipe[] getTecipeList(){
        return _recipeMap.values().toArray(new InfuserRecipe[_recipeMap.size()]);
    }
    public static  void initialize(){
        /* Paper */
        addRecipe(new ItemStack(Items.PAPER), new ItemStack(ItemManager.magicpaper));
        /*components*/

        /*Quills*/
    }
    /* ADD RECIPES*/
    public static InfuserRecipe addRecipe(ItemStack input, ItemStack output){
        if(input.isEmpty() || output.isEmpty() || recipeExixts(input))
            return null;
        InfuserRecipe recipe = new InfuserRecipe(input,output);
        _recipeMap.put(input.getItem(),recipe);
        return recipe;
    }
    /*REMOVE RECIPES*/
    public static InfuserRecipe removeRecipe(ItemStack input){
        return _recipeMap.remove(input.getItem());
    }
    /* RECIPE CLASS */
    public static class InfuserRecipe{
        final ItemStack _input;
        final ItemStack _output;
        InfuserRecipe(ItemStack input, ItemStack output){
            this._input = input;
            this._output = output;
        }

        public ItemStack getInput() {
            return _input;
        }

        public ItemStack get_output() {
            return _output;
        }

    }
}
