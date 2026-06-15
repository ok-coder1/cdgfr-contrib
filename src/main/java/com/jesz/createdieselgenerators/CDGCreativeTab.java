package com.jesz.createdieselgenerators;

import com.jesz.createdieselgenerators.content.molds.MoldType;
import com.jesz.createdieselgenerators.content.track_layers_bag.TrackLayersBagItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

/**
 * rewritten using <a href="https://github.com/davioliva16/create-aquatic-ambitions/pull/10/files#diff-676ca02226dc30d2db262abc5c5a66d457c8c45a0080268f5a6cd7532485bd17">this snippet</a> by <a href="https://github.com/ninjaguardian">ninjaguardian</a> as a template.
 * thank you ninjaguardian!
 */
public class CDGCreativeTab {

    public static final CreativeModeTab CDG_CREATIVE_TAB = Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            new ResourceLocation(CreateDieselGenerators.ID, "s"), /*i dont have a clue what this s does here, but it works*/
            FabricItemGroup.builder()
                    .title(Component.translatable("itemGroup.cdg_creative_tab"))
                    .icon(() -> new ItemStack(CDGBlocks.DIESEL_ENGINE))
                    .displayItems(((itemDisplayParameters, output) -> {
                        output.accept(CDGItems.ENGINE_PISTON);
                        output.accept(CDGItems.WIRE_CUTTERS);
                        output.accept(CDGItems.HAMMER);
                        output.accept(CDGItems.ENGINE_SILENCER);
                        output.accept(CDGItems.ENGINE_TURBO);
                        output.accept(CDGBlocks.DIESEL_ENGINE);
                        output.accept(CDGBlocks.MODULAR_DIESEL_ENGINE);
                        output.accept(CDGBlocks.HUGE_DIESEL_ENGINE);
                        output.accept(CDGItems.DISTILLATION_CONTROLLER);
                        output.accept(CDGItems.OIL_SCANNER);
                        output.accept(CDGBlocks.PUMPJACK_BEARING);
                        output.accept(CDGBlocks.PUMPJACK_CRANK);
                        output.accept(CDGBlocks.PUMPJACK_HEAD);
                        output.accept(CDGBlocks.PUMPJACK_HOLE);
                        output.accept(CDGItems.WOOD_CHIPS);
                        output.accept(CDGBlocks.CHIP_WOOD_BEAM);
                        output.accept(CDGBlocks.CHIP_WOOD_BLOCK);
                        output.accept(CDGBlocks.CHIP_WOOD_STAIRS);
                        output.accept(CDGBlocks.CHIP_WOOD_SLAB);
                        output.accept(CDGBlocks.CANISTER);
                        output.accept(CDGBlocks.OIL_BARREL);
                        output.accept(CDGBlocks.BASIN_LID);
                        output.accept(CDGBlocks.ASPHALT_BLOCK);
                        output.accept(CDGBlocks.ASPHALT_STAIRS);
                        output.accept(CDGBlocks.ASPHALT_SLAB);
                        output.accept(CDGBlocks.BULK_FERMENTER);
                        output.accept(CDGBlocks.ANDESITE_GIRDER);
                        output.accept(CDGBlocks.BURNER);
                        output.accept(CDGBlocks.CHEMICAL_TURRET);
                        output.accept(CDGBlocks.SHEET_METAL_PANEL);
                        output.accept(CDGFluids.CRUDE_OIL.get().getBucket());
                        output.accept(CDGFluids.BIODIESEL.get().getBucket());
                        output.accept(CDGFluids.DIESEL.get().getBucket());
                        output.accept(CDGFluids.GASOLINE.get().getBucket());
                        output.accept(CDGFluids.PLANT_OIL.get().getBucket());
                        output.accept(CDGFluids.ETHANOL.get().getBucket());
                        output.accept(CDGItems.KELP_HANDLE);
                        output.accept(CDGItems.LIGHTER);
                        output.accept(CDGItems.CHEMICAL_SPRAYER);
                        output.accept(CDGItems.CHEMICAL_SPRAYER_LIGHTER);
                        output.accept(CDGItems.TRACK_LAYERS_BAG);
                        output.accept(CDGItems.ENTITY_FILTER);
                        output.accept(TrackLayersBagItem.full());
                        MoldType.types.forEach(mt -> {
                            ItemStack moldStack = CDGItems.MOLD.asStack();
                            moldStack.getOrCreateTag().putString("Mold", mt.getId().toString());
                            output.accept(moldStack);
                        });
                        CDGFluids.CEMENT.forEach((d, f) -> output.accept(f.getBucket().get()));
                    }))
                    .build()
    );

    public static void registerItemGroups() {
        CreateDieselGenerators.LOGGER.info("Registering Item Groups for " + CreateDieselGenerators.ID);
    }
}
