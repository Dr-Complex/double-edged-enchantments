package net.dr_complex.double_edged_enchantments.enchantments;

import com.mojang.serialization.MapCodec;
import net.dr_complex.double_edged_enchantments.DEE_Main;
import net.dr_complex.double_edged_enchantments.enchantments.bad_stuff.Curse_Critical_Miss;
import net.dr_complex.double_edged_enchantments.enchantments.bad_stuff.Curse_Entomophobia;
import net.dr_complex.double_edged_enchantments.enchantments.bad_stuff.Curse_Unfavourable;
import net.dr_complex.double_edged_enchantments.enchantments.good_stuff.Enchantment_Lucky;
import net.dr_complex.double_edged_enchantments.enchantments.good_stuff.Enchantment_Pivotal;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class DEE_Enchantment_Effects {

    public static final MapCodec<? extends EnchantmentEntityEffect> ENCHANTMENT_LUCKY = registerEntityEffect("enchantment_lucky", Enchantment_Lucky.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> CURSE_UNFAVOURABLE = registerEntityEffect("curse_unfavourable", Curse_Unfavourable.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> ENCHANTMENT_PIVOTAL = registerEntityEffect("enchantment_pivotal", Enchantment_Pivotal.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> CURSE_CRITICAL_MISS = registerEntityEffect("curse_critical_miss", Curse_Critical_Miss.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> CURSE_ENTOMOPHOBIA = registerEntityEffect("curse_entomophobia", Curse_Entomophobia.CODEC);

    public static void LoadEnchantmentEffects(){
        DEE_Main.LOGGER.info("Main reason for this mod is made");
    }

    private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffect(String name, MapCodec<? extends EnchantmentEntityEffect> codec){
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE,DEE_Main.id(name),codec);
    }
}
