package net.dr_complex.double_edged_enchantments.enchantments.bad_stuff;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;

public record Curse_Critical_Miss() implements EnchantmentEntityEffect {

    public static final MapCodec<Curse_Critical_Miss> CODEC = MapCodec.unit(Curse_Critical_Miss::new);

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos) {
        if(world.random.nextBetween(0,100)>=(80-level*6) && context.owner() != null){
            float attackDamage = context.owner().getActiveItem().getItem().getBonusAttackDamage(user, 10, world.getDamageSources().generic());
            if(user instanceof LivingEntity livingEntity){
                livingEntity.setHealth(livingEntity.getHealth() + attackDamage/2.0f);
            } else if (user instanceof PlayerEntity player) {
                player.setHealth(player.getHealth() + attackDamage/1.5f);
            }
            world.spawnParticles(ParticleTypes.CHERRY_LEAVES, user.getX(), user.getY() + user.getHeight()/2f, user.getZ(),25,0.25f,0.25f,0.25f,0.15d);
            user.playSound(SoundEvents.ENCHANT_THORNS_HIT,1f,-1f);
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
