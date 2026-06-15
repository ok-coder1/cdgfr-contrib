package com.jesz.createdieselgenerators.ponder;

import com.jesz.createdieselgenerators.CDGBlocks;
import com.jesz.createdieselgenerators.CDGItems;
import com.simibubi.create.infrastructure.ponder.AllCreatePonderTags;
import com.tterrag.registrate.util.entry.ItemProviderEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.createmod.ponder.api.registration.PonderPlugin;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.createmod.ponder.api.registration.PonderTagRegistrationHelper;
import net.minecraft.resources.ResourceLocation;

public class CDGPonderPlugin implements PonderPlugin {
    @Override
    public String getModId() {
        return "createdieselgenerators";
    }

    @Override
    public void registerScenes(PonderSceneRegistrationHelper<ResourceLocation> helper) {
        PonderPlugin.super.registerScenes(helper);
        PonderSceneRegistrationHelper<ItemProviderEntry<?>> HELPER = helper.withKeyFunction(RegistryEntry::getId);
        HELPER.forComponents(CDGItems.DISTILLATION_CONTROLLER)
                .addStoryBoard("distillation_tower", DistillationScenes::distillation);
        HELPER.forComponents(CDGBlocks.DIESEL_ENGINE)
                .addStoryBoard("diesel_engine", DieselEngineScenes::small);
        HELPER.forComponents(CDGBlocks.DIESEL_ENGINE)
                .addStoryBoard("engine_silencer", DieselEngineScenes::silencer);
        HELPER.forComponents(CDGBlocks.MODULAR_DIESEL_ENGINE)
                .addStoryBoard("large_diesel_engine", DieselEngineScenes::modular);
        HELPER.forComponents(CDGBlocks.MODULAR_DIESEL_ENGINE)
                .addStoryBoard("engine_silencer", DieselEngineScenes::silencer);
        HELPER.forComponents(CDGItems.ENGINE_SILENCER)
                .addStoryBoard("engine_silencer", DieselEngineScenes::silencer);
        HELPER.forComponents(CDGBlocks.BASIN_LID)
                .addStoryBoard("basin_fermenting_station", BasinScenes::basin_lid);
        HELPER.forComponents(CDGBlocks.HUGE_DIESEL_ENGINE)
                .addStoryBoard("huge_diesel_engine", DieselEngineScenes::huge);
        HELPER.forComponents(CDGBlocks.PUMPJACK_BEARING, CDGBlocks.PUMPJACK_CRANK, CDGBlocks.PUMPJACK_HEAD)
                .addStoryBoard("pumpjack", OilScenes::pumpjack);
    }
        @Override
        public void registerTags (PonderTagRegistrationHelper < ResourceLocation > helper) {
            PonderPlugin.super.registerTags(helper);

            PonderTagRegistrationHelper<RegistryEntry<?>> HELPER = helper.withKeyFunction(RegistryEntry::getId);
            HELPER.addToTag(AllCreatePonderTags.KINETIC_SOURCES)
                    .add(CDGBlocks.DIESEL_ENGINE)
                    .add(CDGBlocks.MODULAR_DIESEL_ENGINE)
                    .add(CDGBlocks.HUGE_DIESEL_ENGINE);
            HELPER.addToTag(AllCreatePonderTags.KINETIC_APPLIANCES)
                    .add(CDGBlocks.BASIN_LID)
                    .add(CDGBlocks.PUMPJACK_BEARING);
            HELPER.addToTag(AllCreatePonderTags.DISPLAY_SOURCES)
                    .add(CDGBlocks.DIESEL_ENGINE)
                    .add(CDGBlocks.MODULAR_DIESEL_ENGINE);
        }
    }