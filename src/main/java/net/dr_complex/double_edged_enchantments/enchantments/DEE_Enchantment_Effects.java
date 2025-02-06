package net.dr_complex.double_edged_enchantments.enchantments;

import com.mojang.serialization.MapCodec;
import net.dr_complex.double_edged_enchantments.DEE_Main;
import net.dr_complex.double_edged_enchantments.enchantments.custom.*;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class DEE_Enchantment_Effects {

    public static final MapCodec<? extends EnchantmentEntityEffect> ENCHANTMENT_RETURN = registerEntityEffect("enchantment_return", Enchantment_Return.CODEC);

    public static final MapCodec<? extends EnchantmentEntityEffect> CURSE_FUMBLING = registerEntityEffect("curse_fumbling", Curse_Fumbling.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> CURSE_RESONATING = registerEntityEffect("curse_resonating", Curse_Resonating.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> CURSE_STONES = registerEntityEffect("curse_stones", Curse_Stones.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> CURSE_TIDES = registerEntityEffect("curse_tides", Curse_Tides.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> CURSE_WORSEN = registerEntityEffect("curse_worsen", Curse_Worsen.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> CURSE_EVAPORATION = registerEntityEffect("curse_evaporation", Curse_Evaporation.CODEC);

    public static final MapCodec<? extends EnchantmentEntityEffect> CURSE_DAMAGE_BACKLASH = registerEntityEffect("curse_damage_backlash", CursedDamageBacklash.CODEC);

    public static void LoadEnchantmentEffects(){
        DEE_Main.LOGGER.info("Main reason for this mod is made");
    }

    private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffect(String name, MapCodec<? extends EnchantmentEntityEffect> codec){
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE,DEE_Main.id(name),codec);
    }
}
