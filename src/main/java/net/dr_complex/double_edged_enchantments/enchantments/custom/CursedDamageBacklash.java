package net.dr_complex.double_edged_enchantments.enchantments.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.dr_complex.double_edged_enchantments.DEE_Main;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;

public record CursedDamageBacklash(EnchantmentLevelBasedValue min, EnchantmentLevelBasedValue max,float chance) implements EnchantmentEntityEffect {

    public static final MapCodec<CursedDamageBacklash> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            EnchantmentLevelBasedValue.CODEC.fieldOf("min").forGetter(CursedDamageBacklash::min),
            EnchantmentLevelBasedValue.CODEC.fieldOf("max").forGetter(CursedDamageBacklash::max),
            Codec.FLOAT.fieldOf("chance").forGetter(CursedDamageBacklash::chance)
    ).apply(instance, CursedDamageBacklash::new));

    public static final RegistryKey<DamageType> CURSE_BACKLASH = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, DEE_Main.id("curse_backlash"));

    @Override
    public void apply(ServerWorld world, int level, @NotNull EnchantmentEffectContext context, Entity user, Vec3d pos) {
        if(context.owner() != null && world.random.nextFloat() <= chance){
            var damage = new DamageSource(world.getRegistryManager().getOrThrow(RegistryKeys.DAMAGE_TYPE).getOrThrow(CURSE_BACKLASH));
            context.owner().damage(world,damage,level);
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
