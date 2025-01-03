package net.dr_complex.double_edged_enchantments.enchantments;

import net.dr_complex.double_edged_enchantments.DEE_Main;
import net.dr_complex.double_edged_enchantments.enchantments.custom.*;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.AttributeEnchantmentEffect;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.enchantment.effect.entity.ApplyMobEffectEnchantmentEffect;
import net.minecraft.enchantment.effect.entity.DamageEntityEnchantmentEffect;
import net.minecraft.enchantment.effect.value.AddEnchantmentEffect;
import net.minecraft.enchantment.effect.value.RemoveBinomialEnchantmentEffect;
import net.minecraft.enchantment.effect.value.SetEnchantmentEffect;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.loot.condition.*;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.provider.number.EnchantmentLevelLootNumberProvider;
import net.minecraft.predicate.TagPredicate;
import net.minecraft.predicate.entity.DamageSourcePredicate;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.entity.EntityTypePredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.registry.tag.EntityTypeTags;
import net.minecraft.registry.tag.ItemTags;
import org.jetbrains.annotations.NotNull;

public class DEE_Enchantments {

    public static final RegistryKey<Enchantment> ENCHANTMENT_LUCKY = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("enchantment_lucky"));
    public static final RegistryKey<Enchantment> ENCHANTMENT_CRITICALITY = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("enchantment_criticality"));
    public static final RegistryKey<Enchantment> ENCHANTMENT_MOON = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("enchantment_moon"));
    public static final RegistryKey<Enchantment> ENCHANTMENT_RETURN = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("enchantment_return"));
    public static final RegistryKey<Enchantment> ENCHANTMENT_REVEALING = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("enchantment_revealing"));

    public static final RegistryKey<Enchantment> CURSE_UNLUCKY = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("curse_unlucky"));
    public static final RegistryKey<Enchantment> CURSE_CRUELNESS = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("curse_cruelness"));
    public static final RegistryKey<Enchantment> CURSE_ENTOMOPHOBIA = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("curse_entomophobia"));
    public static final RegistryKey<Enchantment> CURSE_FUMBLING = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("curse_fumbling"));
    public static final RegistryKey<Enchantment> CURSE_RESONATING = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("curse_resonating"));
    public static final RegistryKey<Enchantment> CURSE_REBUILDING = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("curse_rebuilding"));
    public static final RegistryKey<Enchantment> CURSE_DULLNESS = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("curse_dullness"));
    public static final RegistryKey<Enchantment> CURSE_FRAGILE = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("curse_fragile"));
    public static final RegistryKey<Enchantment> CURSE_NARROW = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("curse_narrow"));
    public static final RegistryKey<Enchantment> CURSE_IRON_MAIDEN = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("curse_iron_maiden"));
    public static final RegistryKey<Enchantment> CURSE_LOSS = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("curse_loss"));
    public static final RegistryKey<Enchantment> CURSE_UNENDING = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("curse_unending"));
    public static final RegistryKey<Enchantment> CURSE_IMPALED = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("curse_impaled"));
    public static final RegistryKey<Enchantment> CURSE_THALASSOPHOBIA = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("curse_thalassophobia"));
    public static final RegistryKey<Enchantment> CURSE_JUPITER = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("curse_jupiter"));
    public static final RegistryKey<Enchantment> CURSE_SOULLESS = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("curse_soulless"));
    public static final RegistryKey<Enchantment> CURSE_STONES = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("curse_stones"));
    public static final RegistryKey<Enchantment> CURSE_DROWNING = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("curse_drowning"));
    public static final RegistryKey<Enchantment> CURSE_ASHES = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("curse_ashes"));
    public static final RegistryKey<Enchantment> CURSE_NECROPHOBIA = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("curse_necrophobia"));
    public static final RegistryKey<Enchantment> CURSE_HIDDEN = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("curse_hidden"));

    public static final RegistryKey<Enchantment> NM_GROWTH = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("neutral_magic_growth"));
    public static final RegistryKey<Enchantment> NM_SHRUNKEN = RegistryKey.of(RegistryKeys.ENCHANTMENT, DEE_Main.id("neutral_magic_shrunken"));

    public static void bootstrap(@NotNull Registerable<Enchantment> registerable){
        var enchantmentLookup = registerable.getRegistryLookup(RegistryKeys.ENCHANTMENT);
        var itemsLookup = registerable.getRegistryLookup(RegistryKeys.ITEM);
        var entryLookup = registerable.getRegistryLookup(RegistryKeys.ENTITY_TYPE);
        var damageTypeLookup = registerable.getRegistryLookup(RegistryKeys.DAMAGE_TYPE);

        register(registerable,ENCHANTMENT_LUCKY,Enchantment.builder(Enchantment.definition(
                itemsLookup.getOrThrow(ItemTags.EQUIPPABLE_ENCHANTABLE),
                1,3,
                Enchantment.leveledCost(2,4),
                Enchantment.leveledCost(2,5),2, AttributeModifierSlot.ARMOR
        )).addEffect(EnchantmentEffectComponentTypes.ATTRIBUTES,new AttributeEnchantmentEffect(
                DEE_Main.id("enchantment_lucky"),EntityAttributes.LUCK,
                EnchantmentLevelBasedValue.linear(1), EntityAttributeModifier.Operation.ADD_VALUE)));


        register(registerable, ENCHANTMENT_CRITICALITY,Enchantment.builder(Enchantment.definition(
                itemsLookup.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                1,5,
                Enchantment.leveledCost(2,2),
                Enchantment.leveledCost(3,3),2,AttributeModifierSlot.MAINHAND
        )).addEffect(EnchantmentEffectComponentTypes.DAMAGE,new AddEnchantmentEffect(EnchantmentLevelBasedValue.constant(8.5f)),
                RandomChanceLootCondition.builder(EnchantmentLevelLootNumberProvider.create(EnchantmentLevelBasedValue.linear(-0.2f,0.2f)))));

        register(registerable, CURSE_UNLUCKY,Enchantment.builder(Enchantment.definition(
                itemsLookup.getOrThrow(ItemTags.EQUIPPABLE_ENCHANTABLE),
                1,5,
                Enchantment.constantCost(25),
                Enchantment.constantCost(50),1, AttributeModifierSlot.ARMOR
        )).addEffect(EnchantmentEffectComponentTypes.ATTRIBUTES,new AttributeEnchantmentEffect(
                DEE_Main.id("curse_unlucky"),EntityAttributes.LUCK,
                EnchantmentLevelBasedValue.linear(-1,-1.25f), EntityAttributeModifier.Operation.ADD_VALUE)));

        register(registerable, CURSE_CRUELNESS,Enchantment.builder(Enchantment.definition(
                itemsLookup.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
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
                                EnchantmentLevelBasedValue.linear(30f,10f),
                                EnchantmentLevelBasedValue.linear(40f, 15f),
                                EnchantmentLevelBasedValue.linear(0f,1f),
                                EnchantmentLevelBasedValue.linear(1f,1f))));
        
        register(registerable, CURSE_FUMBLING,Enchantment.builder(Enchantment.definition(
                itemsLookup.getOrThrow(ItemTags.MINING_ENCHANTABLE),
                1,5,
                Enchantment.constantCost(25),
                Enchantment.constantCost(50),1,AttributeModifierSlot.ANY
        )).addEffect(EnchantmentEffectComponentTypes.TICK,new Curse_Fumbling()));

        register(registerable, CURSE_RESONATING,Enchantment.builder(Enchantment.definition(
                itemsLookup.getOrThrow(ItemTags.LEG_ARMOR_ENCHANTABLE),
                1,3,
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

        register(registerable, CURSE_NARROW, Enchantment.builder(Enchantment.definition(
                itemsLookup.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
                1,3,
                Enchantment.constantCost(25),
                Enchantment.constantCost(50),1,AttributeModifierSlot.MAINHAND
        )).addEffect(EnchantmentEffectComponentTypes.ATTRIBUTES,
                new AttributeEnchantmentEffect(DEE_Main.id("curse_narrow"),
                        EntityAttributes.SWEEPING_DAMAGE_RATIO,EnchantmentLevelBasedValue.linear(-0.25f,-0.325f),
                        EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)));

        register(registerable, CURSE_IRON_MAIDEN, Enchantment.builder(Enchantment.definition(
                itemsLookup.getOrThrow(ItemTags.ARMOR_ENCHANTABLE),
                1,3,
                Enchantment.constantCost(25),
                Enchantment.constantCost(50),1,AttributeModifierSlot.ARMOR
        )).addEffect(EnchantmentEffectComponentTypes.POST_ATTACK,
                EnchantmentEffectTarget.VICTIM,EnchantmentEffectTarget.VICTIM,
                new DamageEntityEnchantmentEffect(
                        EnchantmentLevelBasedValue.constant(5f), EnchantmentLevelBasedValue.constant(15f), damageTypeLookup.getOrThrow(DamageTypes.CACTUS)
                ),
                RandomChanceLootCondition.builder(EnchantmentLevelLootNumberProvider.create(EnchantmentLevelBasedValue.linear(0.25F)))
        ).addEffect(EnchantmentEffectComponentTypes.POST_ATTACK,
                EnchantmentEffectTarget.VICTIM,EnchantmentEffectTarget.VICTIM,
                new DamageEntityEnchantmentEffect(
                        EnchantmentLevelBasedValue.constant(100f),EnchantmentLevelBasedValue.constant(150f),damageTypeLookup.getOrThrow(DamageTypes.CACTUS)
                ),RandomChanceLootCondition.builder(0.001f)));

        register(registerable, CURSE_LOSS, Enchantment.builder(Enchantment.definition(
                itemsLookup.getOrThrow(ItemTags.MINING_ENCHANTABLE),
                1,1,
                Enchantment.constantCost(25),
                Enchantment.constantCost(50),1,AttributeModifierSlot.MAINHAND
        )).addEffect(EnchantmentEffectComponentTypes.BLOCK_EXPERIENCE,
                new SetEnchantmentEffect(EnchantmentLevelBasedValue.constant(0.0f))));

        register(registerable,CURSE_UNENDING,Enchantment.builder(Enchantment.definition(
                itemsLookup.getOrThrow(ItemTags.CROSSBOW_ENCHANTABLE),
                1,3,
                Enchantment.constantCost(25),
                Enchantment.constantCost(50),1,AttributeModifierSlot.MAINHAND
        )).addNonListEffect(EnchantmentEffectComponentTypes.CROSSBOW_CHARGE_TIME,
             new AddEnchantmentEffect(EnchantmentLevelBasedValue.linear(0.5f,0.25f))));

        register(registerable,CURSE_IMPALED,Enchantment.builder(Enchantment.definition(
                itemsLookup.getOrThrow(ItemTags.ARMOR_ENCHANTABLE),
                1,4,
                Enchantment.constantCost(25),
                Enchantment.constantCost(50),1,AttributeModifierSlot.ARMOR
        )).addEffect(EnchantmentEffectComponentTypes.POST_ATTACK,EnchantmentEffectTarget.VICTIM,EnchantmentEffectTarget.VICTIM,
                new DamageEntityEnchantmentEffect(
                        EnchantmentLevelBasedValue.linear(1,2f),
                        EnchantmentLevelBasedValue.linear(1,2.5f),
                        damageTypeLookup.getOrThrow(DamageTypes.MAGIC)),
                DamageSourcePropertiesLootCondition.builder(
                        DamageSourcePredicate.Builder.create()
                                .tag(TagPredicate.expected(DamageTypeTags.IS_PROJECTILE))
                                .tag(TagPredicate.unexpected(DamageTypeTags.BYPASSES_INVULNERABILITY)))));

        register(registerable, CURSE_THALASSOPHOBIA, Enchantment.builder(Enchantment.definition(
                itemsLookup.getOrThrow(ItemTags.HEAD_ARMOR_ENCHANTABLE),
                1,1,
                Enchantment.constantCost(25),
                Enchantment.constantCost(50),1, AttributeModifierSlot.ARMOR
        )).addEffect(EnchantmentEffectComponentTypes.ATTRIBUTES,new AttributeEnchantmentEffect(DEE_Main.id("curse_thalassophobia"),
                EntityAttributes.SUBMERGED_MINING_SPEED,
                EnchantmentLevelBasedValue.constant(-0.85f),
                EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)));

        register(registerable,ENCHANTMENT_MOON, Enchantment.builder(Enchantment.definition(
                itemsLookup.getOrThrow(ItemTags.FOOT_ARMOR_ENCHANTABLE),
                1,4,
                Enchantment.leveledCost(10,5),
                Enchantment.leveledCost(12,5),1,AttributeModifierSlot.FEET
        )).addEffect(EnchantmentEffectComponentTypes.ATTRIBUTES,new AttributeEnchantmentEffect(DEE_Main.id("enchantment_moon"),
                EntityAttributes.GRAVITY,EnchantmentLevelBasedValue.linear(-0.15f),
                EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)));

        register(registerable,CURSE_JUPITER, Enchantment.builder(Enchantment.definition(
                itemsLookup.getOrThrow(ItemTags.FOOT_ARMOR_ENCHANTABLE),
                1,4,
                Enchantment.constantCost(25),
                Enchantment.constantCost(50),1,AttributeModifierSlot.FEET
        )).addEffect(EnchantmentEffectComponentTypes.ATTRIBUTES,new AttributeEnchantmentEffect(DEE_Main.id("curse_jupiter"),
                EntityAttributes.GRAVITY,EnchantmentLevelBasedValue.linear(0.18f),
                EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)));

        register(registerable, ENCHANTMENT_RETURN,Enchantment.builder(Enchantment.definition(
                itemsLookup.getOrThrow(ItemTags.VANISHING_ENCHANTABLE),
                1,1,
                Enchantment.leveledCost(15,5),
                Enchantment.leveledCost(15,10),1,AttributeModifierSlot.ANY
        )).addEffect(EnchantmentEffectComponentTypes.TICK,
                new Enchantment_Return())
                .addEffect(EnchantmentEffectComponentTypes.PREVENT_EQUIPMENT_DROP));

        register(registerable, CURSE_SOULLESS, Enchantment.builder(Enchantment.definition(
                itemsLookup.getOrThrow(ItemTags.FOOT_ARMOR_ENCHANTABLE),
                1,3,
                Enchantment.constantCost(25),
                Enchantment.constantCost(50),1,AttributeModifierSlot.FEET
        )).addEffect(EnchantmentEffectComponentTypes.TICK,new ApplyMobEffectEnchantmentEffect(
                RegistryEntryList.of(StatusEffects.SLOWNESS),
                EnchantmentLevelBasedValue.linear(1,1),
                EnchantmentLevelBasedValue.linear(4,2),
                EnchantmentLevelBasedValue.constant(1),
                EnchantmentLevelBasedValue.constant(1)),
                RandomChanceLootCondition.builder(EnchantmentLevelLootNumberProvider.create(EnchantmentLevelBasedValue.linear(0.125f,0.175f)))));

        register(registerable, CURSE_STONES, Enchantment.builder(Enchantment.definition(
                itemsLookup.getOrThrow(ItemTags.FOOT_ARMOR_ENCHANTABLE),
                1,4,
                Enchantment.constantCost(25),
                Enchantment.constantCost(50),1,AttributeModifierSlot.FEET
        )).addEffect(EnchantmentEffectComponentTypes.TICK,new Curse_Stones()));

        register(registerable, CURSE_DROWNING, Enchantment.builder(Enchantment.definition(
                itemsLookup.getOrThrow(ItemTags.HEAD_ARMOR_ENCHANTABLE),
                1,3,
                Enchantment.constantCost(25),
                Enchantment.constantCost(50),1,AttributeModifierSlot.HEAD
        )).addEffect(EnchantmentEffectComponentTypes.ATTRIBUTES, new AttributeEnchantmentEffect(
                DEE_Main.id("curse_drowning"),
                EntityAttributes.OXYGEN_BONUS,
                EnchantmentLevelBasedValue.linear(-1),
                EntityAttributeModifier.Operation.ADD_VALUE)));

        register(registerable, CURSE_ASHES, Enchantment.builder(Enchantment.definition(
                itemsLookup.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
                1,2,
                Enchantment.constantCost(25),
                Enchantment.constantCost(50),1,AttributeModifierSlot.MAINHAND
        )).addEffect(EnchantmentEffectComponentTypes.POST_ATTACK,
                EnchantmentEffectTarget.ATTACKER,EnchantmentEffectTarget.ATTACKER,
                new ApplyMobEffectEnchantmentEffect(
                        RegistryEntryList.of(StatusEffects.BLINDNESS),
                        EnchantmentLevelBasedValue.linear(30,30),
                        EnchantmentLevelBasedValue.linear(50,50),
                        EnchantmentLevelBasedValue.constant(0),
                        EnchantmentLevelBasedValue.constant(0)
                )));

        register(registerable, CURSE_NECROPHOBIA, Enchantment.builder(Enchantment.definition(
                itemsLookup.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                1,5,
                Enchantment.constantCost(25),
                Enchantment.constantCost(50),1,AttributeModifierSlot.MAINHAND
        )).addEffect(EnchantmentEffectComponentTypes.DAMAGE,
                        new AddEnchantmentEffect(EnchantmentLevelBasedValue.linear(-1.1f)),
                        EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS,EntityPredicate.Builder.create().type(EntityTypePredicate.create(entryLookup, EntityTypeTags.UNDEAD))))
                .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK,EnchantmentEffectTarget.ATTACKER,EnchantmentEffectTarget.VICTIM,
                        new ApplyMobEffectEnchantmentEffect(
                                RegistryEntryList.of(StatusEffects.STRENGTH),
                                EnchantmentLevelBasedValue.linear(10f, 10f),
                                EnchantmentLevelBasedValue.linear(10f, 25f),
                                EnchantmentLevelBasedValue.constant(1.0F),
                                EnchantmentLevelBasedValue.constant(1.0F)),
                        EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS,EntityPredicate.Builder.create().type(EntityTypePredicate.create(entryLookup, EntityTypeTags.UNDEAD)))));

        register(registerable,NM_GROWTH,Enchantment.builder(Enchantment.definition(
                itemsLookup.getOrThrow(ItemTags.ARMOR_ENCHANTABLE),
                1,1,
                Enchantment.constantCost(10),
                Enchantment.constantCost(15),2,AttributeModifierSlot.ARMOR
        )).addEffect(EnchantmentEffectComponentTypes.ATTRIBUTES,new AttributeEnchantmentEffect(
                DEE_Main.id("neutral_magic_growth"),EntityAttributes.SCALE,
                EnchantmentLevelBasedValue.constant(0.15f), EntityAttributeModifier.Operation.ADD_VALUE)));

        register(registerable,NM_SHRUNKEN,Enchantment.builder(Enchantment.definition(
                itemsLookup.getOrThrow(ItemTags.ARMOR_ENCHANTABLE),
                1,1,
                Enchantment.constantCost(10),
                Enchantment.constantCost(15),2,AttributeModifierSlot.ARMOR
        )).addEffect(EnchantmentEffectComponentTypes.ATTRIBUTES,new AttributeEnchantmentEffect(
                DEE_Main.id("neutral_magic_shrunken"),EntityAttributes.SCALE,
                EnchantmentLevelBasedValue.constant(-0.15f), EntityAttributeModifier.Operation.ADD_VALUE)));

        register(registerable,ENCHANTMENT_REVEALING,Enchantment.builder(Enchantment.definition(
                itemsLookup.getOrThrow(ItemTags.VANISHING_ENCHANTABLE),
                1,1,
                Enchantment.constantCost(23),
                Enchantment.constantCost(30),3,AttributeModifierSlot.ANY
        )).addEffect(EnchantmentEffectComponentTypes.ATTRIBUTES,new AttributeEnchantmentEffect(
                DEE_Main.id("enchantment_revealing"),EntityAttributes.MAX_ABSORPTION,
                EnchantmentLevelBasedValue.constant(2.5f), EntityAttributeModifier.Operation.ADD_VALUE)));

        register(registerable,CURSE_HIDDEN,Enchantment.builder(Enchantment.definition(
                itemsLookup.getOrThrow(ItemTags.VANISHING_ENCHANTABLE),
                1,1,
                Enchantment.constantCost(23),
                Enchantment.constantCost(30),3,AttributeModifierSlot.ANY
        )).addEffect(EnchantmentEffectComponentTypes.ATTRIBUTES,new AttributeEnchantmentEffect(
                DEE_Main.id("curse_hidden"),EntityAttributes.MAX_ABSORPTION,
                EnchantmentLevelBasedValue.constant(-1.5f), EntityAttributeModifier.Operation.ADD_VALUE)));

    }

    private static void register(@NotNull Registerable<Enchantment> registerable, RegistryKey<Enchantment> key, Enchantment.@NotNull Builder builder){
        registerable.register(key,builder.build(key.getValue()));
    }
}
