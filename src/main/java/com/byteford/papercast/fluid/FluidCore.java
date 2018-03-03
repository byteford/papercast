package com.byteford.papercast.fluid;

import com.byteford.papercast.paperCast;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class FluidCore extends Fluid {

    public FluidCore(String fluidName, String modName) {
        super(fluidName, new ResourceLocation(modName,"blocks/fluid/" + fluidName + "_still"), new ResourceLocation("blocks/fluid/" + fluidName + "_flowing"));
    }
}
