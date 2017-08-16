package com.byteford.papercast.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class MagicPaper extends Item {
	public MagicPaper() {
		super();
		setRegistryName("magicpaper");
		setUnlocalizedName("magicpaper");
		setCreativeTab(CreativeTabs.MISC);
	}
	public int getMaxItemUseDuration(ItemStack stack) {
		// TODO Auto-generated method stub
		return 200;
	}
	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		// TODO Auto-generated method stub
		return EnumAction.BOW;
	}
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		 ItemStack itemstack = playerIn.getHeldItem(handIn);
	        boolean flag = true;

	        if (!playerIn.capabilities.isCreativeMode && !flag)
	        {
	            return  new ActionResult(EnumActionResult.PASS, itemstack);
	        }
	        else
	        {
	            playerIn.setActiveHand(handIn);
	            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
	        }
	}
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {
		if(stack.hasTagCompound()) {
			int effect = stack.getTagCompound().getInteger("effect");
			int duration = stack.getTagCompound().getInteger("duration");
			int amplifier = stack.getTagCompound().getInteger("amplifier");
			stack.shrink(1);
			entityLiving.addPotionEffect(new PotionEffect(Potion.getPotionById(effect),duration,amplifier));
		}
		
		super.onPlayerStoppedUsing(stack, worldIn, entityLiving, timeLeft);
	}

	
	
 
}
