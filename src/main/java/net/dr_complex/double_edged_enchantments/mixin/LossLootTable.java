package net.dr_complex.double_edged_enchantments.mixin;

import net.dr_complex.double_edged_enchantments.enchantments.DEE_Enchantments;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Objects;

import static net.minecraft.block.Block.dropStack;
import static net.minecraft.block.Block.getDroppedStacks;

@Mixin(Block.class)
public abstract class LossLootTable {

    @Inject(method = "dropStacks(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/entity/Entity;Lnet/minecraft/item/ItemStack;)V",at = @At("HEAD"), cancellable = true)
    private static void ModifyBlockLootTable(BlockState state, @NotNull World world, BlockPos pos, BlockEntity blockEntity, Entity entity, ItemStack tool, CallbackInfo ci) {
        if (!world.isClient) {
            if (!tool.getEnchantments().isEmpty()) {
                List<String> enchantments = tool.getEnchantments().getEnchantments().stream().map(RegistryEntry::getIdAsString).toList();
                for (String enchantment : enchantments) {
                    if (Objects.equals(enchantment, DEE_Enchantments.CURSE_LOSS.getValue().toString())) {
                        getDroppedStacks(state, (ServerWorld) world, pos, blockEntity, entity, tool).forEach(stack -> dropStack(world, pos, ItemStack.EMPTY));
                        state.onStacksDropped((ServerWorld) world, pos, tool, false);
                        ci.cancel();
                    }
                }
            }
        }
    }
}
