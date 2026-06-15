package com.jesz.createdieselgenerators.blocks;

import com.jesz.createdieselgenerators.CDGBlocks;
import com.simibubi.create.content.contraptions.bearing.BearingBlock;
import com.simibubi.create.content.equipment.wrench.IWrenchable;
import net.fabricmc.fabric.api.block.BlockPickInteractionAware;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.HitResult;

import javax.annotation.Nullable;

public class PumpjackBearingBBlock extends Block implements IWrenchable, BlockPickInteractionAware {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public PumpjackBearingBBlock(Properties properties) {
        super(properties);
    }
    @Override
    public InteractionResult onWrenched(BlockState state, UseOnContext context) {
        context.getLevel().setBlock(context.getClickedPos(), CDGBlocks.PUMPJACK_BEARING.getDefaultState().setValue(BearingBlock.FACING, state.getValue(FACING)), 2);
        return InteractionResult.SUCCESS;
    }



    @Override
    public ItemStack getPickedStack(BlockState state, BlockGetter view, BlockPos pos, @Nullable Player player, @Nullable HitResult result) {
        return CDGBlocks.PUMPJACK_BEARING.asStack();
    }

    @Override
    public Item asItem() {
        return CDGBlocks.PUMPJACK_BEARING.asStack().getItem();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
