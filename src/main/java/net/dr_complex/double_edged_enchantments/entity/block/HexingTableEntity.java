package net.dr_complex.double_edged_enchantments.entity.block;

import net.dr_complex.double_edged_enchantments.entity.DEE_Entities;
import net.dr_complex.double_edged_enchantments.screen.HexingTableScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.block.entity.ViewerCountManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.DoubleInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class HexingTableEntity extends LootableContainerBlockEntity implements ExtendedScreenHandlerFactory<BlockPos> {

    private DefaultedList<ItemStack> itemStacks = DefaultedList.ofSize(size(),ItemStack.EMPTY);
    private final ViewerCountManager stateManager = new ViewerCountManager() {
        @Override
        protected void onContainerOpen(World world, BlockPos pos, BlockState state) {
            HexingTableEntity.playSound(world, pos, SoundEvents.BLOCK_LAVA_POP);
        }

        @Override
        protected void onContainerClose(World world, BlockPos pos, BlockState state) {
            HexingTableEntity.playSound(world, pos, SoundEvents.BLOCK_LAVA_AMBIENT);
        }

        @Override
        protected void onViewerCountUpdate(World world, BlockPos pos, BlockState state, int oldViewerCount, int newViewerCount) {
            HexingTableEntity.this.onViewerCountUpdate(world, pos, state, newViewerCount);
        }

        @Override
        protected boolean isPlayerViewing(PlayerEntity player) {
            if (!(player.currentScreenHandler instanceof GenericContainerScreenHandler)) {
                return false;
            } else {
                Inventory inventory = ((GenericContainerScreenHandler)player.currentScreenHandler).getInventory();
                return inventory == HexingTableEntity.this || inventory instanceof DoubleInventory && ((DoubleInventory)inventory).isPart(HexingTableEntity.this);
            }
        }
    };

    public HexingTableEntity(BlockPos pos, BlockState state) {
        super(DEE_Entities.HEXING_TABLE_ENTITY_BLOCK_ENTITY_TYPE, pos, state);
    }

    @Override
    public BlockPos getScreenOpeningData(ServerPlayerEntity serverPlayerEntity) {
        return pos;
    }

    @Override
    protected Text getContainerName() {
        return Text.translatable("container.hexing_table");
    }

    @Override
    protected DefaultedList<ItemStack> getHeldStacks() {
        return itemStacks;
    }

    @Override
    protected void setHeldStacks(DefaultedList<ItemStack> inventory) {
        this.itemStacks = inventory;
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, @NotNull PlayerEntity player) {
        return new HexingTableScreenHandler(syncId,playerInventory, ScreenHandlerContext.create(world,pos));
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new HexingTableScreenHandler(syncId,playerInventory, ScreenHandlerContext.create(world,pos));
    }

    @Override
    public int size() {
        return 3;
    }

    public void onScheduledTick() {
        if (!this.removed) {
            this.stateManager.updateViewerCount(this.getWorld(), this.getPos(), this.getCachedState());
        }
    }


    static void playSound(@NotNull World world, @NotNull BlockPos pos, SoundEvent soundEvent) {
            double d = (double)pos.getX() + 0.5;
            double e = (double)pos.getY() + 0.5;
            double f = (double)pos.getZ() + 0.5;
            world.playSound(null, d, e, f, soundEvent, SoundCategory.BLOCKS, 1.05F, world.random.nextFloat() * 0.1F + 0.9F);
    }

    protected void onViewerCountUpdate(@NotNull World world, BlockPos pos, @NotNull BlockState state, int newViewerCount) {
        Block block = state.getBlock();
        world.addSyncedBlockEvent(pos, block, 1, newViewerCount);
    }
}
