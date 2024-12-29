package net.dr_complex.double_edged_enchantments.enchantments;

import com.mojang.serialization.MapCodec;
import net.dr_complex.double_edged_enchantments.DEE_Main;
import net.dr_complex.double_edged_enchantments.enchantments.custom.Curse_Fumbling;
import net.dr_complex.double_edged_enchantments.enchantments.custom.Curse_Resonating;
import net.dr_complex.double_edged_enchantments.enchantments.custom.Curse_Unlucky;
import net.dr_complex.double_edged_enchantments.enchantments.custom.Enchantment_Lucky;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class DEE_Enchantment_Effects {

    public static final MapCodec<? extends EnchantmentEntityEffect> ENCHANTMENT_LUCKY = registerEntityEffect("enchantment_lucky",Enchantment_Lucky.CODEC);

    public static final MapCodec<? extends EnchantmentEntityEffect> CURSE_FUMBLING = registerEntityEffect("enchantment_fumbling", Curse_Fumbling.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> CURSE_RESONATING = registerEntityEffect("enchantment_resonating", Curse_Resonating.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> CURSE_UNLUCKY = registerEntityEffect("enchantment_unlucky", Curse_Unlucky.CODEC);

    public static void LoadEnchantmentEffects(){
        DEE_Main.LOGGER.info("Main reason for this mod is made");
    }

    private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffect(String name, MapCodec<? extends EnchantmentEntityEffect> codec){
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE,DEE_Main.id(name),codec);
    }
}
