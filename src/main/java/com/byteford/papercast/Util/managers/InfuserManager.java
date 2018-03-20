package com.byteford.papercast.Util.managers;

import com.byteford.papercast.items.ItemManager;
import gnu.trove.map.hash.THashMap;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Map;
public class InfuserManager {

    private static Map<Item, InfuserRecipe> _recipeMap = new THashMap<>();

    public static InfuserRecipe getRecipe(ItemStack input){
        if(input.isEmpty())
            return null;
        InfuserRecipe recipe = _recipeMap.get(input.getItem());
        return recipe;
    }
    public static  boolean recipeExists(ItemStack input){
        return getRecipe(input) != null;
    }
    public static  InfuserRecipe[] getRecipeList(){
        return _recipeMap.values().toArray(new InfuserRecipe[_recipeMap.size()]);
    }
    public static  void initialize(){
        /* Paper */
        addRecipe(new ItemStack(Items.PAPER), new ItemStack(ItemManager.magicpaper));

        /*components*/

        addRecipe(new ItemStack(Items.DIAMOND),new ItemStack(ItemManager.magiccrystal));
        addRecipe(new ItemStack(Items.POTIONITEM),new ItemStack(ItemManager.magicbottle));
        /*Quills*/
        addRecipe(new ItemStack(Items.FEATHER),new ItemStack(ItemManager.magicquill));
    }
    /* ADD RECIPES*/
    public static InfuserRecipe addRecipe(ItemStack input, ItemStack output){
        if(input.isEmpty() || output.isEmpty() || recipeExists(input))
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
    public static final class InfuserRecipe{
        final ItemStack _input;
        final ItemStack _output;
        InfuserRecipe(ItemStack input, ItemStack output){
            this._input = input;
            this._output = output;
            this._input.setCount(1);
            this._input.setCount(1);
        }

        public final ItemStack getInput() {
            return _input.copy();
        }

        public final ItemStack get_output() {
            return _output.copy();
        }

        @Override
        public String toString() {
            return "input: " + _input.toString() + ", output: " + _output.toString();
        }
    }
}
