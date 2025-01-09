package net.dr_complex.double_edged_enchantments.mixin;

import net.dr_complex.double_edged_enchantments.enchantments.DEE_Enchantments;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ArrowEntity.class)
public abstract class ArrowTrailMixin extends PersistentProjectileEntity {
    @Unique
    private static final TrackedData<Boolean> IsSmoke = DataTracker.registerData(ArrowTrailMixin.class, TrackedDataHandlerRegistry.BOOLEAN);

    @Unique
    private int turn = 0;

    protected ArrowTrailMixin(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "initDataTracker", at =@At("TAIL"))
    protected void initDataTracker(DataTracker.Builder builder, CallbackInfo ci) {
        builder.add(IsSmoke,false);
    }

    @Inject(method = "<init>(Lnet/minecraft/world/World;Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ItemStack;)V",at = @At("TAIL"))
    private void Reworked(World world, LivingEntity owner, ItemStack stack, @NotNull ItemStack shotFrom, CallbackInfo ci){
        if(shotFrom.hasEnchantments()){
            var test1 = shotFrom.getEnchantments().getEnchantments().stream().map(RegistryEntry::getIdAsString).toList();
            var test2 = DEE_Enchantments.CURSE_SMOKE.getValue().toString();
            for (int i = 0; i < shotFrom.getEnchantments().getEnchantments().size(); i++) {
                if(test1.get(i).matches(test2)){
                    this.dataTracker.set(IsSmoke,true);
                }
            }
        }
    }

    @Inject(method = "<init>(Lnet/minecraft/world/World;DDDLnet/minecraft/item/ItemStack;Lnet/minecraft/item/ItemStack;)V",at = @At("TAIL"))
    private void Reworked(World world, double x, double y, double z, ItemStack stack, @NotNull ItemStack shotFrom, CallbackInfo ci){
        if(shotFrom.hasEnchantments()){
            var test3 = shotFrom.getEnchantments().getEnchantments().stream().map(RegistryEntry::getIdAsString).toList();
            var test4 = DEE_Enchantments.CURSE_SMOKE.getValue().toString();
            for (int i = 0; i < shotFrom.getEnchantments().getEnchantments().size(); i++) {
                if(test3.get(i).matches(test4)){
                    this.dataTracker.set(IsSmoke,true);
                }
            }
        }
    }

    @Inject(method = "tick", at = @At("TAIL"), cancellable = true)
    private void spawnParticles(CallbackInfo ci) {
        if(!this.getWorld().isClient){
            ci.cancel();
        }else if(this.dataTracker.get(IsSmoke)){
            if(!this.isInGround()){
                this.getWorld().addParticle(
                        ParticleTypes.CAMPFIRE_SIGNAL_SMOKE,
                        this.getParticleX(0.25),
                        this.getRandomBodyY(),
                        this.getParticleZ(0.25),
                        0, 0.01f, 0
                );
            }else {
                this.turn += 15;
                this.getWorld().addParticle(
                        ParticleTypes.CAMPFIRE_SIGNAL_SMOKE,
                        this.getParticleX(0.25),
                        this.getRandomBodyY(),
                        this.getParticleZ(0.25),
                        -MathHelper.sin((this.turn * MathHelper.TAU) / 360.0f)/50f, 0.375f, MathHelper.cos((this.turn * MathHelper.TAU) / 360.0f)/50f
                );
                if(turn > 360){
                    this.turn = 0;
                }
            }
        }
    }
}
