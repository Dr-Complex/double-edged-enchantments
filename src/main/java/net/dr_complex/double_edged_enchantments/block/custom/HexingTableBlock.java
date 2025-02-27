package net.dr_complex.double_edged_enchantments.block.custom;

import com.mojang.serialization.MapCodec;
import net.dr_complex.double_edged_enchantments.entity.block.HexingTableEntity;
import net.dr_complex.double_edged_enchantments.screen.HexingTableScreenHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class HexingTableBlock extends BlockWithEntity {

    public static final EnumProperty<Direction> FACING = Properties.HORIZONTAL_FACING;
    public static final MapCodec<HexingTableBlock> CODEC = createCodec(HexingTableBlock::new);

    public HexingTableBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new HexingTableEntity(pos,state);
    }

    @Override
    protected ActionResult onUse(BlockState state, @NotNull World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if(!world.isClient){
            NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);
            if(screenHandlerFactory != null) {
                player.openHandledScreen(screenHandlerFactory);
            }
        }
        return ActionResult.SUCCESS;
    }

    @Override
    protected void onStateReplaced(@NotNull BlockState state, World world, BlockPos pos, @NotNull BlockState newState, boolean moved) {
        if(state.getBlock() != newState.getBlock()){
            BlockEntity blockEntity = world.getBlockEntity(pos);

            if(blockEntity instanceof Inventory){
                ItemScatterer.spawn(world,pos,(Inventory) blockEntity);
                world.updateComparators(pos,this);
            }

            super.onStateReplaced(state,world,pos,newState,moved);
        }
    }

    @Override
    protected int getComparatorOutput(BlockState state, @NotNull World world, BlockPos pos) {
        return ScreenHandler.calculateComparatorOutput(world.getBlockEntity(pos));
    }

    @Override
    public @Nullable BlockState getPlacementState(@NotNull ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING,ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.@NotNull Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    protected BlockState rotate(@NotNull BlockState state, @NotNull BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    protected BlockState mirror(@NotNull BlockState state, @NotNull BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }


    @Override
    protected void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof HexingTableEntity) {
            ((HexingTableEntity)blockEntity).onScheduledTick();
        }
    }

    @Override
    protected @Nullable NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, @NotNull World world, BlockPos pos) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof HexingTableEntity) {
            Text text = ((Nameable)blockEntity).getDisplayName();
            return new SimpleNamedScreenHandlerFactory(
                    (syncId, inventory, player) -> new HexingTableScreenHandler(syncId, inventory, ScreenHandlerContext.create(world, pos)), text
            );
        } else {
            return null;
        }
    }
}
