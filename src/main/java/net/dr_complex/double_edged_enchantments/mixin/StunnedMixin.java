package net.dr_complex.double_edged_enchantments.mixin;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.dr_complex.double_edged_enchantments.enchantments.DEE_Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class StunnedMixin extends LivingEntity{

    protected StunnedMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Shadow public abstract PlayerInventory getInventory();


    @Unique
    private static final TrackedData<Integer> StunTime = DataTracker.registerData(
            StunnedMixin.class,TrackedDataHandlerRegistry.INTEGER);

    @Inject(method = "initDataTracker",at = @At("TAIL"))
    private void init(DataTracker.@NotNull Builder builder, CallbackInfo ci){
        builder.add(StunTime,0);

    }

    @Inject(method = "tick",at = @At("HEAD"))
    private void Disable(CallbackInfo ci){
        if(this.dataTracker.get(StunTime) > 0) {
            this.dataTracker.set(StunTime,this.dataTracker.get(StunTime) - 1);
            this.movementMultiplier = new Vec3d(0,-2 * this.getVelocity().y,0);
        }else this.movementMultiplier = new Vec3d(0,0,0);
    }

    @Inject(method = "attack", at = @At("HEAD"))
    private void setStunTime(Entity target, CallbackInfo ci){
        if(this.getInventory().getMainHandStack().hasEnchantments() && this.dataTracker.get(StunTime) <= 0){
            var test1 = this.getInventory().getMainHandStack().getEnchantments().getEnchantments().stream().map(RegistryEntry::getIdAsString).toList();
            var test2 = DEE_Enchantments.CURSE_STUNNED.getValue().toString();
            var level = this.getInventory().getMainHandStack().getEnchantments().getEnchantmentEntries().stream().map(Object2IntMap.Entry::getIntValue).toList();
            for (int i = 0; i < test1.size(); i++) {
                if(test1.get(i).matches(test2)){
                    this.dataTracker.set(StunTime,
                            level.get(i) * 25
                    );
                }
            }
        }
    }
}