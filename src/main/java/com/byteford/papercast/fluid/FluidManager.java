package com.byteford.papercast.fluid;


import com.byteford.papercast.paperCast;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


@GameRegistry.ObjectHolder("papercast")
public class FluidManager {
    public  static  void preInit(){
        registerAllFluids();
        createBuckets();
    }
    public  static  void registerAllFluids(){
        //fluidInk = new FluidCore("ink","papercast").setDensity(1000).setViscosity(2000);
        //fluidInk = new Fluid("ink",new ResourceLocation("papercast:ink"), new ResourceLocation("papercase:ink"));

    }
    public  static  void createBuckets(){
        FluidRegistry.addBucketForFluid(fluid_ink);
    }
    public  static  void registerFuildBlocks(RegistryEvent.Register<Block> event){
        blockFluidInk = new BlockFluidClassic(fluid_ink, Material.WATER);
        blockFluidInk.setRegistryName("fluid_ink").setUnlocalizedName("fluid_ink").setCreativeTab(paperCast.tabPapercast);
        event.getRegistry().register(blockFluidInk);
    }
    public  static  Fluid createFluid(String fluidName, ResourceLocation stilTexture, ResourceLocation flowTexture){
        Fluid fluid = new Fluid(fluidName,stilTexture,flowTexture);
        FluidRegistry.registerFluid(fluid);
        return fluid;
    }
    @SideOnly(Side.CLIENT)
    public static void initModels(){
        Item item = Item.getItemFromBlock(blockFluidInk);

        ModelBakery.registerItemVariants(item);
        ModelResourceLocation location = new ModelResourceLocation("papercast:fluid","fluid_ink");
        ModelLoader.setCustomMeshDefinition(item, stack -> location);
        ModelLoader.setCustomStateMapper(blockFluidInk,new StateMapperBase(){
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState state){
                return location;
            }
        });
    }
    public  static  Fluid fluid_ink = createFluid(
            "fluid_ink",
            new ResourceLocation("papercast", "blocks/fluid_ink_still"),
            new ResourceLocation("papercast","blocks/fluid_ink_flow"));
    public static  BlockFluidClassic blockFluidInk;
}
