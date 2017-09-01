package com.byteford.papercast.block;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface ILinkable {
	
	abstract boolean canlinkFrom();
	abstract boolean canlinkTo();
	abstract boolean linkBlock(World worldin, BlockPos Frompos, BlockPos topos);
}
