package com.byteford.papercast.block;

import com.byteford.papercast.block.TileEntity.InkMakerTileEntity;
import com.byteford.papercast.paperCast;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class InkMaker extends BlockContainer {
    public InkMaker() {
        super(Material.ROCK);
        setRegistryName("inkmaker");
        setUnlocalizedName("inkmaker");
        setCreativeTab(paperCast.tabPapercast);


    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new InkMakerTileEntity();
    }
}
