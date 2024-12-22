package net.dr_complex.double_edged_enchantments.other;

import net.dr_complex.double_edged_enchantments.DEE_Main;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.registry.RegistryKey;

public interface DEE_EquipmentAssetKeys {
    RegistryKey<EquipmentAsset> VOID_FANG = register("void_fang");

    static RegistryKey<EquipmentAsset> register(String name){
        return RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY,DEE_Main.id(name));
    }
}
