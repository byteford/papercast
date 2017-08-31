package com.byteford.papercast.block;

import net.minecraft.util.math.BlockPos;

public interface ILinkable {
	abstract BlockPos getBlockPos();
	abstract void linkBlock(BlockPos pos);
}
