package net.dr_complex.double_edged_enchantments.enchantments;

import net.dr_complex.double_edged_enchantments.DEE_Main;
import net.dr_complex.double_edged_enchantments.enchantments.bad_stuff.Curse_Critical_Miss;
import net.dr_complex.double_edged_enchantments.enchantments.bad_stuff.Curse_Entomophobia;
import net.dr_complex.double_edged_enchantments.enchantments.bad_stuff.Curse_Unfavourable;
import net.dr_complex.double_edged_enchantments.enchantments.good_stuff.Enchantment_Lucky;
import net.dr_complex.double_edged_enchantments.enchantments.good_stuff.Enchantment_Pivotal;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.predicate.entity.EntityTypePredicate;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.EntityTypeTags;
import net.minecraft.registry.tag.ItemTags;
import org.jetbrains.annotations.NotNull;

public class DEE_Enchantments {

    public static final RegistryKey<Enchantment> ENCHANTMENT_LUCKY = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("enchantment_lucky"));
    public static final RegistryKey<Enchantment> CURSE_UNFAVOURABLE = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("curse_unfavourable"));
    public static final RegistryKey<Enchantment> ENCHANTMENT_PIVOTAL = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("enchantment_pivotal"));
    public static final RegistryKey<Enchantment> CURSE_CRITICAL_MISS = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("curse_critical_miss"));
    public static final RegistryKey<Enchantment> CURSE_ENTOMOPHOBIA = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("curse_entomophobia"));

    public static void bootstrap(@NotNull Registerable<Enchantment> registerable){
        var enchantment = registerable.getRegistryLookup(RegistryKeys.ENCHANTMENT);
        var items = registerable.getRegistryLookup(RegistryKeys.ITEM);
        RegistryEntryLookup<EntityType<?>> entryLookup = registerable.getRegistryLookup(RegistryKeys.ENTITY_TYPE);

        register(registerable,ENCHANTMENT_LUCKY,Enchantment.builder(Enchantment.definition(
                items.getOrThrow(ItemTags.EQUIPPABLE_ENCHANTABLE),
                items.getOrThrow(ItemTags.LEG_ARMOR),
                6,3,
                Enchantment.leveledCost(2,4),
                Enchantment.leveledCost(2,5),2, AttributeModifierSlot.ARMOR
        )).addEffect(EnchantmentEffectComponentTypes.TICK,new Enchantment_Lucky()));

        register(registerable,CURSE_UNFAVOURABLE,Enchantment.builder(Enchantment.definition(
                items.getOrThrow(ItemTags.EQUIPPABLE_ENCHANTABLE),
                items.getOrThrow(ItemTags.LEG_ARMOR),
                1,3,
                Enchantment.constantCost(25),
                Enchantment.constantCost(50),1, AttributeModifierSlot.ARMOR
        )).addEffect(EnchantmentEffectComponentTypes.TICK,new Curse_Unfavourable()));

        register(registerable,ENCHANTMENT_PIVOTAL,Enchantment.builder(Enchantment.definition(
                items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                items.getOrThrow(ItemTags.SWORDS),
                3,10,
                Enchantment.leveledCost(2,2),
                Enchantment.leveledCost(3,3),2,AttributeModifierSlot.MAINHAND
        )).addEffect(EnchantmentEffectComponentTypes.POST_ATTACK, EnchantmentEffectTarget.ATTACKER ,EnchantmentEffectTarget.VICTIM,new Enchantment_Pivotal()));

        register(registerable,CURSE_CRITICAL_MISS,Enchantment.builder(Enchantment.definition(
                items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                items.getOrThrow(ItemTags.SWORDS),
                1,10,
                Enchantment.constantCost(25),
                Enchantment.constantCost(50),1,AttributeModifierSlot.MAINHAND
        )).addEffect(EnchantmentEffectComponentTypes.POST_ATTACK, EnchantmentEffectTarget.ATTACKER ,EnchantmentEffectTarget.VICTIM,new Curse_Critical_Miss()));

        register(registerable,CURSE_ENTOMOPHOBIA,Enchantment.builder(Enchantment.definition(
                items.getOrThrow(ItemTags.ARMOR_ENCHANTABLE),
                items.getOrThrow(ItemTags.FOOT_ARMOR),
                1,1,
                Enchantment.constantCost(25),
                Enchantment.constantCost(50),1,AttributeModifierSlot.ARMOR
        )).addEffect(EnchantmentEffectComponentTypes.TICK,new Curse_Entomophobia()));
    }

    private static void register(Registerable<Enchantment> registerable, RegistryKey<Enchantment> key, Enchantment.Builder builder){
        registerable.register(key,builder.build(key.getValue()));
    }
}
