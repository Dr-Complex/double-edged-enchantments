package net.dr_complex.double_edged_enchantments.mixin;

import net.minecraft.entity.*;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;

@Mixin(LivingEntity.class)
public abstract class LivingMixin extends Entity implements Attackable {

    @Shadow public abstract AttributeContainer getAttributes();

    @Shadow @Final private AttributeContainer attributes;

    @Shadow protected abstract double getEffectiveGravity();

    @Shadow protected abstract float getBaseWaterMovementSpeedMultiplier();

    @Shadow public abstract boolean hasStatusEffect(RegistryEntry<StatusEffect> effect);

    @Shadow public abstract boolean isClimbing();

    @Shadow public abstract Vec3d applyFluidMovingSpeed(double gravity, boolean falling, Vec3d motion);

    @Shadow public abstract float getMovementSpeed();

    public LivingMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "getNextAirUnderwater",at = @At("HEAD"), cancellable = true)
    private void ReworkedAir(int air, CallbackInfoReturnable<Integer> cir){
        EntityAttributeInstance entityAttributeInstance = this.attributes.getCustomInstance(EntityAttributes.OXYGEN_BONUS);
        double d;
        if (entityAttributeInstance != null) {
            d = entityAttributeInstance.getValue();
        } else {
            d = 0.0;
        }

        if(d >= 0)cir.setReturnValue(d > 0.0 && this.random.nextDouble() >= 1.0 / (d + 1.0) ? MathHelper.clamp(air,-20,1024) : MathHelper.clamp(air-1,-20,1024));
        if(d < 0)cir.setReturnValue(MathHelper.clamp(air + (MathHelper.ceil(d) - 1),-20,1024));
    }

    @Inject(method = "travelInFluid" ,at = @At("HEAD"), cancellable = true)
    private void ReworkedFluidSpeed(Vec3d movementInput, CallbackInfo ci){
        double Speed;
        if(this.attributes.getCustomInstance(EntityAttributes.WATER_MOVEMENT_EFFICIENCY) != null){
             Speed = Objects.requireNonNull(this.attributes.getCustomInstance(EntityAttributes.WATER_MOVEMENT_EFFICIENCY)).getValue();
        }else Speed = 0;

        int Length = 5;
        boolean aBool = this.getVelocity().y <= 0.0;
        double Gravity = this.getEffectiveGravity();

        if (this.isTouchingWater() && this.getWorld().isClient) {
            float SprintingSpeed = this.isSprinting() ? 0.9F : this.getBaseWaterMovementSpeedMultiplier();
            float ScaleSpeed = 0.02F;

            if (!this.isOnGround()) {
                Speed *= 0.5F;
            }

            SprintingSpeed = (float) (1 - (0.5-(Speed/Length))*(SprintingSpeed-0.5));

            if(Speed > 0) {
                ScaleSpeed += (float) ((this.getMovementSpeed() - ScaleSpeed) * (Speed/Length));
            }

            if (this.hasStatusEffect(StatusEffects.DOLPHINS_GRACE)) {
                SprintingSpeed *= 1.15F;
            }

            this.updateVelocity(ScaleSpeed, movementInput);
            this.move(MovementType.SELF, this.getVelocity());
            Vec3d vec3d = this.getVelocity();

            if (this.horizontalCollision && this.isClimbing()) {
                vec3d = new Vec3d(vec3d.x, 0.2f, vec3d.z);
            }

            vec3d = vec3d.multiply(SprintingSpeed, 0.8f, SprintingSpeed);
            this.setVelocity(this.applyFluidMovingSpeed(Gravity, aBool, vec3d));

        } else if(this.getWorld().isClient){
            this.updateVelocity(0.02F, movementInput);
            this.move(MovementType.SELF, this.getVelocity());
            if (this.getFluidHeight(FluidTags.LAVA) <= this.getSwimHeight()) {
                this.setVelocity(this.getVelocity().multiply(0.5, 0.8F, 0.5));
                Vec3d vec3d2 = this.applyFluidMovingSpeed(Gravity, aBool, this.getVelocity());
                this.setVelocity(vec3d2);
            } else {
                this.setVelocity(this.getVelocity().multiply(0.5));
            }

            if (Gravity != 0.0) {
                this.setVelocity(this.getVelocity().add(0.0, -Gravity / 4.0, 0.0));
            }
        }

        Vec3d vec3d2 = this.getVelocity();
        if (this.horizontalCollision && this.doesNotCollide(vec3d2.x, vec3d2.y + 0.6F - this.getY() + this.getY(), vec3d2.z)) {
            this.setVelocity(vec3d2.x, 0.3F, vec3d2.z);
        }
        ci.cancel();
    }
}
