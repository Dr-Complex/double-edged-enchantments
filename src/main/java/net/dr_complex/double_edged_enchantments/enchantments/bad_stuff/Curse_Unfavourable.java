package net.dr_complex.double_edged_enchantments.enchantments.bad_stuff;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public record Curse_Unfavourable() implements EnchantmentEntityEffect {

    public static final MapCodec<Curse_Unfavourable> CODEC = MapCodec.unit(Curse_Unfavourable::new);

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos) {
        if(context.owner() != null){
            context.owner().addStatusEffect(new StatusEffectInstance(StatusEffects.UNLUCK, 30, level - 1));
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
