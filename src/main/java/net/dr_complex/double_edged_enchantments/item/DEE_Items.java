package net.dr_complex.double_edged_enchantments.item;

import net.dr_complex.double_edged_enchantments.DEE_Main;
import net.dr_complex.double_edged_enchantments.item.custom.DEE_ArmorMaterials;
import net.dr_complex.double_edged_enchantments.item.custom.Reverted_Ender_Pearl;
import net.dr_complex.double_edged_enchantments.item.custom.XP_Needle;
import net.dr_complex.double_edged_enchantments.item.custom.DEE_ToolMaterials;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Rarity;

public class DEE_Items {

    public static final Item VOID_FANG = registerItem("void_fang",new Item(new Item.Settings().rarity(Rarity.COMMON).registryKey(RegistryKey.of(RegistryKeys.ITEM,DEE_Main.id("void_fang")))));
    public static final Item MOLTEN_ENDER_PEARL = registerItem("molten_ender_pearl",new Item(new Item.Settings().rarity(Rarity.COMMON).registryKey(RegistryKey.of(RegistryKeys.ITEM,DEE_Main.id("molten_ender_pearl")))));

    public static final Item REVERED_ENDER_PEARL = registerItem("reverted_ender_pearl", new Reverted_Ender_Pearl(new Item.Settings().rarity(Rarity.COMMON).maxCount(16).useCooldown(1.5f).registryKey(RegistryKey.of(RegistryKeys.ITEM,DEE_Main.id("reverted_ender_pearl")))));
    public static final Item XP_NEEDLE = registerItem("xp_needle",new XP_Needle(new Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1).registryKey(RegistryKey.of(RegistryKeys.ITEM,DEE_Main.id("xp_needle")))));

    public static final Item VOID_FANG_SWORD = registerItem("void_fang_sword",new SwordItem(DEE_ToolMaterials.VOID_FANG,2.5f,-2.4f,new Item.Settings().rarity(Rarity.COMMON).registryKey(RegistryKey.of(RegistryKeys.ITEM,DEE_Main.id("void_fang_sword")))));
    public static final Item VOID_FANG_AXE = registerItem("void_fang_axe",new AxeItem(DEE_ToolMaterials.VOID_FANG,8f,-3,new Item.Settings().rarity(Rarity.COMMON).registryKey(RegistryKey.of(RegistryKeys.ITEM,DEE_Main.id("void_fang_axe")))));
    public static final Item VOID_FANG_PICKAXE = registerItem("void_fang_pickaxe",new PickaxeItem(DEE_ToolMaterials.VOID_FANG,2.5f,-2.8f,new Item.Settings().rarity(Rarity.COMMON).registryKey(RegistryKey.of(RegistryKeys.ITEM,DEE_Main.id("void_fang_pickaxe")))));
    public static final Item VOID_FANG_SHOVEL = registerItem("void_fang_shovel",new ShovelItem(DEE_ToolMaterials.VOID_FANG,1.5f,-3f,new Item.Settings().rarity(Rarity.COMMON).registryKey(RegistryKey.of(RegistryKeys.ITEM,DEE_Main.id("void_fang_shovel")))));
    public static final Item VOID_FANG_HOE = registerItem("void_fang_hoe",new HoeItem(DEE_ToolMaterials.VOID_FANG,-5.5f,2,new Item.Settings().rarity(Rarity.COMMON).registryKey(RegistryKey.of(RegistryKeys.ITEM,DEE_Main.id("void_fang_hoe")))));

    public static final Item VOID_FANG_HELMET = registerItem("void_fang_helmet",new ArmorItem(DEE_ArmorMaterials.VOID_FANG_ARMOR, EquipmentType.HELMET,new Item.Settings().rarity(Rarity.COMMON).registryKey(RegistryKey.of(RegistryKeys.ITEM,DEE_Main.id("void_fang_helmet")))));
    public static final Item VOID_FANG_CHESTPLATE = registerItem("void_fang_chestplate",new ArmorItem(DEE_ArmorMaterials.VOID_FANG_ARMOR, EquipmentType.CHESTPLATE,new Item.Settings().rarity(Rarity.COMMON).registryKey(RegistryKey.of(RegistryKeys.ITEM,DEE_Main.id("void_fang_chestplate")))));
    public static final Item VOID_FANG_LEGGINGS = registerItem("void_fang_leggings",new ArmorItem(DEE_ArmorMaterials.VOID_FANG_ARMOR, EquipmentType.LEGGINGS,new Item.Settings().rarity(Rarity.COMMON).registryKey(RegistryKey.of(RegistryKeys.ITEM,DEE_Main.id("void_fang_leggings")))));
    public static final Item VOID_FANG_BOOTS = registerItem("void_fang_boots",new ArmorItem(DEE_ArmorMaterials.VOID_FANG_ARMOR, EquipmentType.BOOTS,new Item.Settings().rarity(Rarity.COMMON).registryKey(RegistryKey.of(RegistryKeys.ITEM,DEE_Main.id("void_fang_boots")))));
    public static final Item VOID_FANG_HORSE_ARMOR = registerItem("void_fang_horse_armor",new AnimalArmorItem(DEE_ArmorMaterials.VOID_FANG_ARMOR, AnimalArmorItem.Type.EQUESTRIAN,new Item.Settings().rarity(Rarity.COMMON).registryKey(RegistryKey.of(RegistryKeys.ITEM,DEE_Main.id("void_fang_horse_armor")))));
    public static final Item BODY_SMITHING_TEMPLATE = registerItem("body_armor_trim_smithing_template", SmithingTemplateItem.of(new Item.Settings().rarity(Rarity.UNCOMMON).registryKey(RegistryKey.of(RegistryKeys.ITEM,DEE_Main.id("body_trim_smithing_template")))));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM,DEE_Main.id(name),item);
    }

    public static void LoadItems(){
        DEE_Main.LOGGER.info("Items are now cursed");
    }
}
