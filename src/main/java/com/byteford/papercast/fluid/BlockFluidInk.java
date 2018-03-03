package com.byteford.papercast.fluid;

import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockFluidInk extends BlockFluidClassic{
    public BlockFluidInk(Fluid fluid) {
        super(fluid, Material.WATER);
        setRegistryName("ink");
        setUnlocalizedName("ink");
        setQuantaPerBlock(8);
        setTickRate(5);
        setHardness(100F);
        setLightOpacity(2);
    }
}
