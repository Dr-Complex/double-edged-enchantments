package net.dr_complex.double_edged_enchantments.enchantments.good_stuff;

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
import org.jetbrains.annotations.NotNull;

public record Enchantment_Pivotal() implements EnchantmentEntityEffect {

    public static final MapCodec<Enchantment_Pivotal> CODEC = MapCodec.unit(Enchantment_Pivotal::new);

    @Override
    public void apply(@NotNull ServerWorld world, int level, @NotNull EnchantmentEffectContext context, Entity user, Vec3d pos) {
        if( world.random.nextBetween(0,100) >= (90-level*6) && context.owner() != null){
            float attackDamage = context.owner().getActiveItem().getItem().getBonusAttackDamage(user, 10, world.getDamageSources().generic());
            if(user instanceof LivingEntity livingEntity){
                livingEntity.damage(world,livingEntity.getDamageSources().mobAttack(livingEntity),attackDamage/2.0f);
            } else if (user instanceof PlayerEntity player) {
                player.damage(world,player.getDamageSources().mobAttack(player),attackDamage/2.3f);
            }
            world.spawnParticles(ParticleTypes.END_ROD, user.getX(), user.getY() + user.getHeight()/2f, user.getZ(),25,0.25f,0.25f,0.25f,0.15d);
            user.playSound(SoundEvents.ENTITY_PLAYER_ATTACK_CRIT,1f,-1f);
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
