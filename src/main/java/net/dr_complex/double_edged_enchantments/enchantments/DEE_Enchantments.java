package net.dr_complex.double_edged_enchantments.enchantments;

import net.dr_complex.double_edged_enchantments.DEE_Main;
import net.dr_complex.double_edged_enchantments.enchantments.custom.Curse_Fumbling;
import net.dr_complex.double_edged_enchantments.enchantments.custom.Curse_Resonating;
import net.dr_complex.double_edged_enchantments.enchantments.custom.Curse_Unlucky;
import net.dr_complex.double_edged_enchantments.enchantments.custom.Enchantment_Lucky;
import net.dr_complex.double_edged_enchantments.other.DEE_Tags;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.enchantment.effect.entity.ApplyMobEffectEnchantmentEffect;
import net.minecraft.enchantment.effect.value.AddEnchantmentEffect;
import net.minecraft.enchantment.effect.value.RemoveBinomialEnchantmentEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.condition.InvertedLootCondition;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.provider.number.EnchantmentLevelLootNumberProvider;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.entity.EntityTypePredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.EntityTypeTags;
import net.minecraft.registry.tag.ItemTags;
import org.jetbrains.annotations.NotNull;

public class DEE_Enchantments {

    public static final RegistryKey<Enchantment> ENCHANTMENT_LUCKY = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("enchantment_lucky"));
    public static final RegistryKey<Enchantment> ENCHANTMENT_CRITICALITY = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("enchantment_criticality"));

    public static final RegistryKey<Enchantment> CURSE_UNLUCKY = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("curse_unlucky"));
    public static final RegistryKey<Enchantment> CURSE_CRUELNESS = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("curse_cruelness"));
    public static final RegistryKey<Enchantment> CURSE_ENTOMOPHOBIA = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("curse_entomophobia"));
    public static final RegistryKey<Enchantment> CURSE_FUMBLING = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("curse_fumbling"));
    public static final RegistryKey<Enchantment> CURSE_RESONATING = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("curse_resonating"));
    public static final RegistryKey<Enchantment> CURSE_REBUILDING = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("curse_rebuilding"));
    public static final RegistryKey<Enchantment> CURSE_DULLNESS = RegistryKey.of(RegistryKeys.ENCHANTMENT,DEE_Main.id("curse_dullness"));
    public static final RegistryKey<Enchantment> CURSE_FRAGILE = RegistryKey.of(RegistryKeys.ENCHANTMENT,DEE_Main.id("curse_fragile"));

    public static void bootstrap(@NotNull Registerable<Enchantment> registerable){
        var enchantmentLookup = registerable.getRegistryLookup(RegistryKeys.ENCHANTMENT);
        var itemsLookup = registerable.getRegistryLookup(RegistryKeys.ITEM);
        var entryLookup = registerable.getRegistryLookup(RegistryKeys.ENTITY_TYPE);

        register(registerable,ENCHANTMENT_LUCKY,Enchantment.builder(Enchantment.definition(
                itemsLookup.getOrThrow(ItemTags.EQUIPPABLE_ENCHANTABLE),
                1,3,
                Enchantment.leveledCost(2,4),
                Enchantment.leveledCost(2,5),2, AttributeModifierSlot.ARMOR
        )).addEffect(EnchantmentEffectComponentTypes.TICK,new Enchantment_Lucky()));

        register(registerable, ENCHANTMENT_CRITICALITY,Enchantment.builder(Enchantment.definition(
                itemsLookup.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                itemsLookup.getOrThrow(ItemTags.SWORDS),
                1,5,
                Enchantment.leveledCost(2,2),
                Enchantment.leveledCost(3,3),2,AttributeModifierSlot.MAINHAND
        )).addEffect(EnchantmentEffectComponentTypes.DAMAGE,new AddEnchantmentEffect(EnchantmentLevelBasedValue.constant(8.5f)),
                RandomChanceLootCondition.builder(EnchantmentLevelLootNumberProvider.create(EnchantmentLevelBasedValue.linear(-0.2f,0.2f)))));

        register(registerable, CURSE_UNLUCKY,Enchantment.builder(Enchantment.definition(
                itemsLookup.getOrThrow(ItemTags.EQUIPPABLE_ENCHANTABLE),
                1,3,
                Enchantment.constantCost(25),
                Enchantment.constantCost(50),1, AttributeModifierSlot.ARMOR
        )).addEffect(EnchantmentEffectComponentTypes.TICK,new Curse_Unlucky()));

        register(registerable, CURSE_CRUELNESS,Enchantment.builder(Enchantment.definition(
                itemsLookup.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                itemsLookup.getOrThrow(ItemTags.SWORDS),
                1,5,
                Enchantment.constantCost(25),
                Enchantment.constantCost(50),1,AttributeModifierSlot.MAINHAND
        )).addEffect(EnchantmentEffectComponentTypes.DAMAGE,new AddEnchantmentEffect(EnchantmentLevelBasedValue.constant(-9.5f)),
                RandomChanceLootCondition.builder(EnchantmentLevelLootNumberProvider.create(EnchantmentLevelBasedValue.linear(-0.05f,0.15f)))));


        register(registerable,CURSE_ENTOMOPHOBIA,Enchantment.builder(Enchantment.definition(
                itemsLookup.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                1,5,
                Enchantment.constantCost(25),
                Enchantment.constantCost(50),1,AttributeModifierSlot.MAINHAND
        )).addEffect(EnchantmentEffectComponentTypes.DAMAGE,
                        new AddEnchantmentEffect(EnchantmentLevelBasedValue.linear(-1.05f)),
                        EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS,EntityPredicate.Builder.create().type(EntityTypePredicate.create(entryLookup, EntityTypeTags.ARTHROPOD))))
                .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK,EnchantmentEffectTarget.ATTACKER,EnchantmentEffectTarget.VICTIM,
                        new ApplyMobEffectEnchantmentEffect(
                                RegistryEntryList.of(StatusEffects.INFESTED),
                                EnchantmentLevelBasedValue.constant(1.5F),
                                EnchantmentLevelBasedValue.linear(1.5F, 0.5F),
                                EnchantmentLevelBasedValue.constant(3.0F),
                                EnchantmentLevelBasedValue.constant(3.0F)),
                        EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS,
                                EntityPredicate.Builder.create().type(EntityTypePredicate.create(entryLookup, EntityTypeTags.ARTHROPOD)))));

        register(registerable, CURSE_FUMBLING,Enchantment.builder(Enchantment.definition(
                itemsLookup.getOrThrow(DEE_Tags.Items.TOOLS),
                1,5,
                Enchantment.constantCost(25),
                Enchantment.constantCost(50),1,AttributeModifierSlot.ANY
        )).addEffect(EnchantmentEffectComponentTypes.TICK,new Curse_Fumbling()));

        register(registerable, CURSE_RESONATING,Enchantment.builder(Enchantment.definition(
                itemsLookup.getOrThrow(ItemTags.LEG_ARMOR_ENCHANTABLE),
                1,1,
                Enchantment.constantCost(25),
                Enchantment.constantCost(50),1,AttributeModifierSlot.ARMOR
        )).addEffect(EnchantmentEffectComponentTypes.TICK,new Curse_Resonating()));

        register(registerable, CURSE_REBUILDING, Enchantment.builder(Enchantment.definition(
                itemsLookup.getOrThrow(ItemTags.MACE_ENCHANTABLE),
                1,4,
                Enchantment.constantCost(25),
                Enchantment.constantCost(50),1,AttributeModifierSlot.MAINHAND
        )).addEffect(EnchantmentEffectComponentTypes.ARMOR_EFFECTIVENESS,
                new AddEnchantmentEffect(EnchantmentLevelBasedValue.linear(0.25f))));

        register(registerable, CURSE_DULLNESS, Enchantment.builder(Enchantment.definition(
                itemsLookup.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                1,5,
                Enchantment.constantCost(25),
                Enchantment.constantCost(50),1,AttributeModifierSlot.MAINHAND
        )).addEffect(EnchantmentEffectComponentTypes.DAMAGE,
                new AddEnchantmentEffect(EnchantmentLevelBasedValue.linear(-0.75f,-0.85f))));

        register(registerable, CURSE_FRAGILE, Enchantment.builder(Enchantment.definition(
                itemsLookup.getOrThrow(ItemTags.DURABILITY_ENCHANTABLE),
                1,3,
                Enchantment.constantCost(25),
                Enchantment.constantCost(50),1,AttributeModifierSlot.ANY
        )).addEffect(EnchantmentEffectComponentTypes.ITEM_DAMAGE,
                new RemoveBinomialEnchantmentEffect(new EnchantmentLevelBasedValue.Fraction(EnchantmentLevelBasedValue.linear(-4.0F),
                        EnchantmentLevelBasedValue.linear(10.0F, 5.0F))),
                MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(itemsLookup, ItemTags.ARMOR_ENCHANTABLE)))
                .addEffect(EnchantmentEffectComponentTypes.ITEM_DAMAGE,
                        new RemoveBinomialEnchantmentEffect(new EnchantmentLevelBasedValue.Fraction(EnchantmentLevelBasedValue.linear(-2.0F),
                                EnchantmentLevelBasedValue.linear(2.0F, 1.0F))),
                        InvertedLootCondition.builder(MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(itemsLookup, ItemTags.ARMOR_ENCHANTABLE)))));
    }

    private static void register(@NotNull Registerable<Enchantment> registerable, RegistryKey<Enchantment> key, Enchantment.@NotNull Builder builder){
        registerable.register(key,builder.build(key.getValue()));
    }
}
