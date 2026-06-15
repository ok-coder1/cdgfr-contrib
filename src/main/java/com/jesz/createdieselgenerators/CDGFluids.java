package com.jesz.createdieselgenerators;

import com.jesz.createdieselgenerators.content.cement.CementFluid;
import com.simibubi.create.AllTags;
import com.tterrag.registrate.util.entry.FluidEntry;
import com.tterrag.registrate.fabric.SimpleFlowableFluid;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.transfer.v1.fluid.*;
import net.fabricmc.fabric.api.transfer.v1.fluid.base.EmptyItemFluidStorage;
import net.fabricmc.fabric.api.transfer.v1.fluid.base.FullItemFluidStorage;
import net.fabricmc.fabric.api.transfer.v1.item.ItemVariant;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

import static com.jesz.createdieselgenerators.CreateDieselGenerators.REGISTRATE;
import static net.minecraft.world.item.Items.BUCKET;

public class CDGFluids {

    public static final FluidEntry<SimpleFlowableFluid.Flowing> PLANT_OIL =
            REGISTRATE.fluid("plant_oil", CreateDieselGenerators.asResource("block/plant_oil_still"), CreateDieselGenerators.asResource("block/plant_oil_flow"))
                    .fluidAttributes(() -> new CreateAttributeHandler("block.createdieselgenerators.plant_oil", 1500, 500))
                    .fluidProperties(p -> p.levelDecreasePerBlock(2)
                            .tickRate(25)
                            .flowSpeed(3)
                            .blastResistance(100f))
                    .source(SimpleFlowableFluid.Source::new)
                    .tag(AllTags.forgeFluidTag("plant_oil"))
                    .onRegisterAfter(Registries.ITEM, plant -> {
                        Fluid source = plant.getSource();

                        FluidStorage.combinedItemApiProvider(source.getBucket()).register(context ->
                                new FullItemFluidStorage(context, bucket -> ItemVariant.of(BUCKET), FluidVariant.of(source), FluidConstants.BUCKET));
                        FluidStorage.combinedItemApiProvider(BUCKET).register(context ->
                                new EmptyItemFluidStorage(context, bucket -> ItemVariant.of(source.getBucket()), source, FluidConstants.BUCKET));

                        FuelRegistry.INSTANCE.add(source.getBucket(), 5000);
                    })
                    .register();
    public static final FluidEntry<SimpleFlowableFluid.Flowing> CRUDE_OIL =
            REGISTRATE.fluid("crude_oil", CreateDieselGenerators.asResource("block/crude_oil_still"), CreateDieselGenerators.asResource("block/crude_oil_flow"))
                    .fluidAttributes(() -> new CreateAttributeHandler("block.createdieselgenerators.crude_oil", 1500, 100))
                    .fluidProperties(p -> p.levelDecreasePerBlock(3)
                            .tickRate(25)
                            .flowSpeed(2)
                            .blastResistance(100f))
                    .source(SimpleFlowableFluid.Source::new)
                    .tag(AllTags.forgeFluidTag("crude_oil"))
                    .tag(TagRegistry.FluidTags.PUMPJACK_OUTPUT.tag)
                    .onRegisterAfter(Registries.ITEM, plant -> {
                        Fluid source = plant.getSource();

                        FluidStorage.combinedItemApiProvider(source.getBucket()).register(context ->
                                new FullItemFluidStorage(context, bucket -> ItemVariant.of(BUCKET), FluidVariant.of(source), FluidConstants.BUCKET));
                        FluidStorage.combinedItemApiProvider(BUCKET).register(context ->
                                new EmptyItemFluidStorage(context, bucket -> ItemVariant.of(source.getBucket()), source, FluidConstants.BUCKET));

                    })
                    .register();

    public static final FluidEntry<SimpleFlowableFluid.Flowing> BIODIESEL =
            REGISTRATE.fluid("biodiesel", CreateDieselGenerators.asResource("block/biodiesel_still"), CreateDieselGenerators.asResource("block/biodiesel_flow"))
                    .fluidAttributes(() -> new CreateAttributeHandler("block.createdieselgenerators.biodiesel", 1500, 500))
                    .fluidProperties(p -> p.levelDecreasePerBlock(2)
                            .tickRate(25)
                            .flowSpeed(3)
                            .blastResistance(100f))
                    .source(SimpleFlowableFluid.Source::new)
                    .tag(AllTags.forgeFluidTag("biodiesel"))
                    .onRegisterAfter(Registries.ITEM, plant -> {
                        Fluid source = plant.getSource();

                        FluidStorage.combinedItemApiProvider(source.getBucket()).register(context ->
                                new FullItemFluidStorage(context, bucket -> ItemVariant.of(BUCKET), FluidVariant.of(source), FluidConstants.BUCKET));
                        FluidStorage.combinedItemApiProvider(BUCKET).register(context ->
                                new EmptyItemFluidStorage(context, bucket -> ItemVariant.of(source.getBucket()), source, FluidConstants.BUCKET));

                        FuelRegistry.INSTANCE.add(source.getBucket(), 25000);
                    })
                    .register();
    public static final FluidEntry<SimpleFlowableFluid.Flowing> DIESEL =
            REGISTRATE.fluid("diesel", CreateDieselGenerators.asResource("block/diesel_still"), CreateDieselGenerators.asResource("block/diesel_flow"))
                    .fluidAttributes(() -> new CreateAttributeHandler("block.createdieselgenerators.diesel", 1500, 500))
                    .fluidProperties(p -> p.levelDecreasePerBlock(2)
                            .tickRate(25)
                            .flowSpeed(3)
                            .blastResistance(100f))
                    .source(SimpleFlowableFluid.Source::new)
                    .tag(AllTags.forgeFluidTag("diesel"))
                    .onRegisterAfter(Registries.ITEM, plant -> {
                        Fluid source = plant.getSource();

                        FluidStorage.combinedItemApiProvider(source.getBucket()).register(context ->
                                new FullItemFluidStorage(context, bucket -> ItemVariant.of(BUCKET), FluidVariant.of(source), FluidConstants.BUCKET));
                        FluidStorage.combinedItemApiProvider(BUCKET).register(context ->
                                new EmptyItemFluidStorage(context, bucket -> ItemVariant.of(source.getBucket()), source, FluidConstants.BUCKET));

                        FuelRegistry.INSTANCE.add(source.getBucket(), 32767);
                    })
                    .register();
    public static final FluidEntry<SimpleFlowableFluid.Flowing> GASOLINE =
            REGISTRATE.fluid("gasoline", CreateDieselGenerators.asResource("block/gasoline_still"), CreateDieselGenerators.asResource("block/gasoline_flow"))
                    .fluidAttributes(() -> new CreateAttributeHandler("block.createdieselgenerators.gasoline", 1500, 500))
                    .fluidProperties(p -> p.levelDecreasePerBlock(2)
                            .tickRate(25)
                            .flowSpeed(3)
                            .blastResistance(100f))
                    .source(SimpleFlowableFluid.Source::new)
                    .tag(AllTags.forgeFluidTag("gasoline"))
                    .onRegisterAfter(Registries.ITEM, plant -> {
                        Fluid source = plant.getSource();

                        FluidStorage.combinedItemApiProvider(source.getBucket()).register(context ->
                                new FullItemFluidStorage(context, bucket -> ItemVariant.of(BUCKET), FluidVariant.of(source), FluidConstants.BUCKET));
                        FluidStorage.combinedItemApiProvider(BUCKET).register(context ->
                                new EmptyItemFluidStorage(context, bucket -> ItemVariant.of(source.getBucket()), source, FluidConstants.BUCKET));

                        FuelRegistry.INSTANCE.add(source.getBucket(), 32767);
                    })
                    .register();
    public static final FluidEntry<SimpleFlowableFluid.Flowing> ETHANOL =
            REGISTRATE.fluid("ethanol", CreateDieselGenerators.asResource("block/ethanol_still"), CreateDieselGenerators.asResource("block/ethanol_flow"))
                    .fluidAttributes(() -> new CreateAttributeHandler("block.createdieselgenerators.ethanol", 1500, 500))
                    .fluidProperties(p -> p.levelDecreasePerBlock(2)
                            .tickRate(25)
                            .flowSpeed(5)
                            .blastResistance(100f))
                    .source(SimpleFlowableFluid.Source::new)
                    .tag(AllTags.forgeFluidTag("ethanol"))
                    .onRegisterAfter(Registries.ITEM, plant -> {
                        Fluid source = plant.getSource();

                        FluidStorage.combinedItemApiProvider(source.getBucket()).register(context ->
                                new FullItemFluidStorage(context, bucket -> ItemVariant.of(BUCKET), FluidVariant.of(source), FluidConstants.BUCKET));
                        FluidStorage.combinedItemApiProvider(BUCKET).register(context ->
                                new EmptyItemFluidStorage(context, bucket -> ItemVariant.of(source.getBucket()), source, FluidConstants.BUCKET));

                        FuelRegistry.INSTANCE.add(source.getBucket(), 6250);
                    })
                    .register();

    public static final Map<DyeColor, FluidEntry<SimpleFlowableFluid.Flowing>> CEMENT = new HashMap<>();
    static {
        for (DyeColor color : DyeColor.values()) {
            CEMENT.put(color,
                    REGISTRATE.fluid(color.getName() + "_cement", CreateDieselGenerators.asResource("block/cement/" + color.getName() + "_still"), CreateDieselGenerators.asResource("block/cement/" + color.getName() + "_flow"))
                    .fluidAttributes(() -> new CreateAttributeHandler("block.createdieselgenerators.cement", 1500, 500))
                    .fluidProperties(p -> p.levelDecreasePerBlock(3)
                            .tickRate(12)
                            .flowSpeed(2)
                            .blastResistance(100f))
                    .source(p -> new CementFluid(p, color))
                    .tag(AllTags.forgeFluidTag("cement"))
                    .onRegisterAfter(Registries.ITEM, plant -> {
                        Fluid source = plant.getSource();

                        FluidStorage.combinedItemApiProvider(source.getBucket()).register(context ->
                                new FullItemFluidStorage(context, bucket -> ItemVariant.of(BUCKET), FluidVariant.of(source), FluidConstants.BUCKET));
                        FluidStorage.combinedItemApiProvider(BUCKET).register(context ->
                                new EmptyItemFluidStorage(context, bucket -> ItemVariant.of(source.getBucket()), source, FluidConstants.BUCKET));
                    })
                    .register()
            );
        }
    }

    public static void register() {}

    private record CreateAttributeHandler(Component name, int viscosity, boolean lighterThanAir) implements FluidVariantAttributeHandler {
        private CreateAttributeHandler(String key, int viscosity, int density) {
            this(Component.translatable(key), viscosity, density <= 0);
        }

        @SuppressWarnings("unused")
        public CreateAttributeHandler(String key) {
            this(key, FluidConstants.WATER_VISCOSITY, 1000);
        }

        @Override
        public Component getName(FluidVariant fluidVariant) {
            return name.copy();
        }

        @Override
        public int getViscosity(FluidVariant variant, @Nullable Level world) {
            return viscosity;
        }

        @Override
        public boolean isLighterThanAir(FluidVariant variant) {
            return lighterThanAir;
        }
    }
}
