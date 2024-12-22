package net.dr_complex.double_edged_enchantments.other;

import net.dr_complex.double_edged_enchantments.DEE_Main;
import net.dr_complex.double_edged_enchantments.item.DEE_Items;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.trim.ArmorTrimMaterial;
import net.minecraft.item.equipment.trim.ArmorTrimPattern;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Util;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class DEE_Trims {

    public static final RegistryKey<ArmorTrimMaterial> VOID_FANG = RegistryKey.of(RegistryKeys.TRIM_MATERIAL, DEE_Main.id("void_fang"));

    public static void bootstrapM(Registerable<ArmorTrimMaterial> registerable){
        registerM(registerable,VOID_FANG, Registries.ITEM.getEntry(DEE_Items.VOID_FANG),Style.EMPTY.withColor(6422707).withShadowColor(13582297));
    }

    private static void registerM(@NotNull Registerable<ArmorTrimMaterial> registerable, @NotNull RegistryKey<ArmorTrimMaterial> armorTrimKey, RegistryEntry<Item> item, Style style){
        ArmorTrimMaterial trimMaterial = new ArmorTrimMaterial(armorTrimKey.getValue().getPath(),item, Map.of(), Text.translatable(Util.createTranslationKey("trim_material",armorTrimKey.getValue())).fillStyle(style));
        registerable.register(armorTrimKey,trimMaterial);
    }

    //↑--material : pattern--↓

    public static final RegistryKey<ArmorTrimPattern> BODY = RegistryKey.of(RegistryKeys.TRIM_PATTERN,DEE_Main.id("body"));

    public static void bootstrapP(Registerable<ArmorTrimPattern> context){
        registerP(context, DEE_Items.BODY_SMITHING_TEMPLATE,BODY);
    }

    private static void registerP(Registerable<ArmorTrimPattern> context, Item item, RegistryKey<ArmorTrimPattern> key){
        ArmorTrimPattern pattern = new ArmorTrimPattern(key.getValue(),Registries.ITEM.getEntry(item),Text.translatable(Util.createTranslationKey("trim_pattern", key.getValue())),false);
        context.register(key,pattern);
    }
}
