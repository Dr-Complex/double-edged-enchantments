package net.dr_complex.double_edged_enchantments.mixin;

import net.minecraft.entity.Attackable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class DrowningReworkMixin extends Entity implements Attackable {
    @Shadow @Final private AttributeContainer attributes;

    public DrowningReworkMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Shadow
    public EntityAttributeInstance getAttributeInstance(RegistryEntry<EntityAttribute> attribute){
        return this.attributes.getCustomInstance(attribute);
    }

    @Shadow public abstract boolean isAlive();

    @Shadow @Final protected static TrackedData<Byte> LIVING_FLAGS;

    @Inject(method = "getNextAirUnderwater",at = @At("HEAD"), cancellable = true)
    private void ReworkedAir(int air, CallbackInfoReturnable<Integer> cir){
        EntityAttributeInstance entityAttributeInstance = this.getAttributeInstance(EntityAttributes.OXYGEN_BONUS);
        double d;
        if (entityAttributeInstance != null) {
            d = entityAttributeInstance.getValue();
        } else {
            d = 0.0;
        }

        if(d >= 0)cir.setReturnValue(d > 0.0 && this.random.nextDouble() >= 1.0 / (d + 1.0) ? MathHelper.clamp(air,-20,1024) : MathHelper.clamp(air-1,-20,1024));
        if(d < 0)cir.setReturnValue(MathHelper.clamp(air + (MathHelper.ceil(d) - 1),-20,1024));
    }

}
