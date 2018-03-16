package com.byteford.papercast.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class InkMaker extends BlockContainer {
    protected InkMaker(Material materialIn) {
        super(materialIn);
    }

    protected InkMaker(Material materialIn, MapColor color) {
        super(materialIn, color);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return null;
    }
}
