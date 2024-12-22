package net.dr_complex.double_edged_enchantments.item.custom;

import net.dr_complex.double_edged_enchantments.other.DEE_EquipmentAssetKeys;
import net.dr_complex.double_edged_enchantments.other.DEE_Tags;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Util;
import java.util.EnumMap;

public interface DEE_ArmorMaterials {
    ArmorMaterial VOID_FANG_ARMOR = new ArmorMaterial(300,
            Util.make(new EnumMap<>(EquipmentType.class),map ->{
                map.put(EquipmentType.HELMET,5);
                map.put(EquipmentType.CHESTPLATE,10);
                map.put(EquipmentType.LEGGINGS,8);
                map.put(EquipmentType.BOOTS,4);
                map.put(EquipmentType.BODY,15);
            }),10,SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,0,0,DEE_Tags.Items.VOID_FANG_REPAIR,DEE_EquipmentAssetKeys.VOID_FANG);
}