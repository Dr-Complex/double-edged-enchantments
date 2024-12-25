package net.dr_complex.double_edged_enchantments.enchantments.bad_stuff;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;


public record Curse_Entomophobia() implements EnchantmentEntityEffect {

    private static final TargetPredicate targetPredicate = TargetPredicate.createNonAttackable().setBaseMaxDistance(60.0d);
    public static final MapCodec<Curse_Entomophobia> CODEC = MapCodec.unit(Curse_Entomophobia::new);


    @Override
    public void apply(ServerWorld world, int level, @NotNull EnchantmentEffectContext context, Entity user, Vec3d pos) {
        if(context.owner() != null){
            LivingEntity scared = context.owner();
            var bug = world.getClosestEntity(SpiderEntity.class, targetPredicate, scared, scared.getX(), scared.getY(), scared.getZ(), scared.getBoundingBox().expand(10d));
            if(bug != null){
                if(scared.distanceTo(bug) <= 9) {
                    scared.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,40,0));
                    scared.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS,40,0));
                    scared.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE,40,0));
                }
            }
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
