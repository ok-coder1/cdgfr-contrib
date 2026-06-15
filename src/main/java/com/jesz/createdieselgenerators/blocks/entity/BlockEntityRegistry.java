package com.jesz.createdieselgenerators.blocks.entity;

import com.jesz.createdieselgenerators.blocks.renderer.*;
import com.simibubi.create.content.kinetics.base.KineticBlockEntityRenderer;
import com.simibubi.create.content.kinetics.base.ShaftVisual;
import com.simibubi.create.content.kinetics.base.SingleAxisRotatingVisual;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import com.simibubi.create.AllPartialModels;

import static com.jesz.createdieselgenerators.CreateDieselGenerators.REGISTRATE;

import com.jesz.createdieselgenerators.CDGBlocks;

public class BlockEntityRegistry {

    public static final BlockEntityEntry<DieselGeneratorBlockEntity> DIESEL_ENGINE = REGISTRATE.blockEntity("diesel_engine_tile_entity", DieselGeneratorBlockEntity::new)
            .visual(() -> ShaftVisual::new )
            .validBlocks(CDGBlocks.DIESEL_ENGINE)
            .renderer(() -> DieselGeneratorRenderer::new)
            .register();
    public static final BlockEntityEntry<LargeDieselGeneratorBlockEntity> LARGE_DIESEL_ENGINE = REGISTRATE.blockEntity("large_diesel_engine_tile_entity", LargeDieselGeneratorBlockEntity::new)
            .visual(() -> ShaftVisual::new )
            .validBlocks(CDGBlocks.MODULAR_DIESEL_ENGINE)
            .renderer(() -> LargeDieselGeneratorRenderer::new)
            .register();
    public static final BlockEntityEntry<HugeDieselEngineBlockEntity> HUGE_DIESEL_ENGINE = REGISTRATE.blockEntity("huge_diesel_engine_block_entity", HugeDieselEngineBlockEntity::new)
            .visual(() -> HugeDieselEngineInstance::new)
            .validBlocks(CDGBlocks.HUGE_DIESEL_ENGINE)
            .renderer(() -> HugeDieselEngineRenderer::new)
            .register();
    public static final BlockEntityEntry<PoweredEngineShaftBlockEntity> POWERED_ENGINE_SHAFT = REGISTRATE.blockEntity("powered_engine_shaft_block_entity", PoweredEngineShaftBlockEntity::new)
            .visual(() -> SingleAxisRotatingVisual.of(AllPartialModels.POWERED_SHAFT), false)
            .validBlocks(CDGBlocks.POWERED_ENGINE_SHAFT)
            .renderer(() -> KineticBlockEntityRenderer::new)
            .register();
    public static final BlockEntityEntry<BasinLidBlockEntity> BASIN_LID = REGISTRATE.blockEntity("basin_lid_tile_entity", BasinLidBlockEntity::new)
            .validBlocks(CDGBlocks.BASIN_LID)
            .renderer(() -> BasinLidRenderer::new)
            .register();
    public static final BlockEntityEntry<PumpjackBearingBlockEntity> PUMPJACK_BEARING = REGISTRATE.blockEntity("pumpjack_bearing_block_entity", PumpjackBearingBlockEntity::new)
            .visual(() -> NoShaftBearingInstance::new)
            .validBlocks(CDGBlocks.PUMPJACK_BEARING)
            .renderer(() -> NoShaftBearingRenderer::new)
            .register();
    public static final BlockEntityEntry<CanisterBlockEntity> CANISTER = REGISTRATE.blockEntity("canister_block_entity", CanisterBlockEntity::new)
            .validBlocks(CDGBlocks.CANISTER)
            .register();
    public static final BlockEntityEntry<DistillationTankBlockEntity> DISTILLATION_TANK = REGISTRATE.blockEntity("distillation_tank_block_entity", DistillationTankBlockEntity::new)
            .validBlocks(CDGBlocks.DISTILLATION_TANK)
            .renderer(() -> DistillationTankRenderer::new)
            .register();
    public static final BlockEntityEntry<OilBarrelBlockEntity> OIL_BARREL = REGISTRATE.blockEntity("oil_barrel_block_entity", OilBarrelBlockEntity::new)
            .validBlocks(CDGBlocks.OIL_BARREL)
            .register();
    public static final BlockEntityEntry<PumpjackHoleBlockEntity> PUMPJACK_HOLE = REGISTRATE.blockEntity("pumpjack_hole_block_entity", PumpjackHoleBlockEntity::new)
            .validBlocks(CDGBlocks.PUMPJACK_HOLE)
            .renderer(() -> PumpjackHoleRenderer::new)
            .register();
    public static final BlockEntityEntry<PumpjackCrankBlockEntity> PUMPJACK_CRANK = REGISTRATE.blockEntity("pumpjack_crank_block_entity", PumpjackCrankBlockEntity::new)
            .visual(() -> PumpjackCrankInstance::new)
            .validBlocks(CDGBlocks.PUMPJACK_CRANK)
            .renderer(() -> PumpjackCrankRenderer::new)
            .register();

    public static void register() {
    }
}
