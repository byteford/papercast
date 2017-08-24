package com.byteford.papercast.items;

import com.byteford.papercast.paperCast;
import com.byteford.papercast.Util.paperType;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
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
		setCreativeTab(paperCast.tabPapercast);
	}
	public int getMaxItemUseDuration(ItemStack stack) {
		// TODO Auto-generated method stub
		return 200;
	}
	@Override
	public String getUnlocalizedName() {
		// TODO Auto-generated method stub
		return super.getUnlocalizedName();
	}
	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		if(stack.hasTagCompound())
			if(stack.getTagCompound().hasKey("effect")) {
				String  temp1 = paperType.values()[Character.getNumericValue(stack.getTagCompound().getString("effect").charAt(0))].toString();
				int temp2 = Character.getNumericValue(stack.getTagCompound().getString("effect").charAt(1));
					return temp1 + ": " + Potion.getPotionById(temp2).getName();
				}
			return super.getItemStackDisplayName(stack);
	}
	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		// TODO Auto-generated method stub
		return EnumAction.BOW;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		 ItemStack itemstack = playerIn.getHeldItem(handIn);
	        boolean flag = true;
	        ItemStack stack = playerIn.getHeldItem(handIn);
	        if(!stack.hasTagCompound())
	        	return new ActionResult(EnumActionResult.FAIL, itemstack);
	        if(!stack.getTagCompound().hasKey("effect"))
	        	return new ActionResult(EnumActionResult.FAIL, itemstack);

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
	public Boolean BuffPaper(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {
			int effect = Character.getNumericValue(stack.getTagCompound().getString("effect").charAt(1));
			int duration = Character.getNumericValue(stack.getTagCompound().getString("effect").charAt(2));
			int amplifier = Character.getNumericValue(stack.getTagCompound().getString("effect").charAt(3));			
			entityLiving.addPotionEffect(new PotionEffect(Potion.getPotionById(effect),duration,amplifier));
			return true;
	}
	
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {
		if(stack.hasTagCompound()) {
			paperType type = paperType.values()[stack.getTagCompound().getString("effect").charAt(0)];
			Boolean success = false;
			switch(type) {
			case buff:
				success = BuffPaper(stack,worldIn,entityLiving,timeLeft);
				break;
			case conjuration:
				break;
			case projectile:
				break;
			default:
				break; 
			}
			if(success)
			stack.shrink(1);
		}
		
		super.onPlayerStoppedUsing(stack, worldIn, entityLiving, timeLeft);
	}

	
	
 
}
