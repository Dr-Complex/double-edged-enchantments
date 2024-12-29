package net.dr_complex.double_edged_enchantments.mixin;

import net.dr_complex.double_edged_enchantments.DEE_Main;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class PlayerRangeMixin {

    @Inject(method = "getBlockInteractionRange", at = @At(value = "TAIL"), cancellable = true)
    public void modifyBlockReachForCustomItem(CallbackInfoReturnable<Double> cir){
        if(MinecraftClient.getInstance().player != null && MinecraftClient.getInstance().player instanceof ClientPlayerEntity player) {
            ItemStack mainHandItemStack = player.getMainHandStack();
            if (mainHandItemStack.getItem() == Items.NETHERITE_HOE) {
                cir.setReturnValue(player.getAttributeValue(EntityAttributes.BLOCK_INTERACTION_RANGE) + 50);
            }
        }else {
            DEE_Main.LOGGER.warn("Player is null!");
        }
    }

    @Inject(method = "getEntityInteractionRange", at = @At(value = "TAIL"), cancellable = true)
    public void modifyEntityReachForCustomItem(CallbackInfoReturnable<Double> cir){
        if(MinecraftClient.getInstance().player != null && MinecraftClient.getInstance().player instanceof ClientPlayerEntity player) {
            ItemStack mainHandItemStack = player.getMainHandStack();
            if (mainHandItemStack.getItem() == Items.NETHERITE_HOE) {
                cir.setReturnValue(player.getAttributeValue(EntityAttributes.ENTITY_INTERACTION_RANGE) + 50);
            }
        }else {
            DEE_Main.LOGGER.warn("Player is null!");
        }
    }
}
