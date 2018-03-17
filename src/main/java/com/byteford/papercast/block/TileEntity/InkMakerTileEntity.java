package com.byteford.papercast.block.TileEntity;

import com.byteford.papercast.fluid.FluidManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidTankProperties;

import javax.annotation.Nullable;



public class InkMakerTileEntity extends TileEntity implements IFluidHandler {


    @Override
    public IFluidTankProperties[] getTankProperties() {
        IFluidTankProperties[] prop = new IFluidTankProperties[1];
        IFluidTankProperties Ink = new IFluidTankProperties(){
            @Nullable
            @Override
            public FluidStack getContents() {
                return new FluidStack(FluidManager.fluid_ink,0);
            }
            @Override
            public int getCapacity() {
                return 2000;
            }

            @Override
            public boolean canFill() {
                return true;
            }

            @Override
            public boolean canDrain() {
                return true;
            }
            @Override
            public boolean canFillFluidType(FluidStack fluidStack) {
                if(fluidStack.getFluid() == FluidManager.fluid_ink)
                    return true;
                return false;
            }

            @Override
            public boolean canDrainFluidType(FluidStack fluidStack) {
                return true;
            }
        };
        prop[1] = Ink;
        return prop;
    }

    @Override
    public int fill(FluidStack resource, boolean doFill) {

        if(getTankProperties()[1].canFill()){
           // return getTankProperties()[1].getCapacity() - getTankProperties()[1].ca
        }
        return 1000;
    }

    @Nullable
    @Override
    public FluidStack drain(FluidStack resource, boolean doDrain) {
        return new FluidStack(FluidManager.fluid_ink,1000);
    }

    @Nullable
    @Override
    public FluidStack drain(int maxDrain, boolean doDrain) {
        return new FluidStack(FluidManager.fluid_ink,maxDrain);
    }
    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY || super.hasCapability(capability, facing);
    }
    @SuppressWarnings("unchecked")
    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {

        return capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY ? (T)this: super.getCapability(capability, facing);
    }
}
