package com.dr_complex.item;

import com.dr_complex.DEE_Main;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Rarity;

public class DEE_Items {

    public static final Item VOIDFANG = registerItem("voidfang",new Item(new Item.Settings().rarity(Rarity.COMMON).registryKey(RegistryKey.of(RegistryKeys.ITEM,DEE_Main.id("voidfang")))));
    public static final Item REVERED_ENDERPEARL = registerItem("revered_enderpearl", new Reverted_Enderpearl(new Item.Settings().rarity(Rarity.COMMON).registryKey(RegistryKey.of(RegistryKeys.ITEM,DEE_Main.id("revered_enderpearl")))));
    public static final Item XP_NEEDLE = registerItem("xp_needle",new XP_Needle(new Item.Settings().rarity(Rarity.UNCOMMON).maxDamage(64).registryKey(RegistryKey.of(RegistryKeys.ITEM,DEE_Main.id("xp_needle")))));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM,DEE_Main.id(name),item);
    }

    public static void LoadItems(){
        DEE_Main.LOGGER.info("Items are now cursed");
    }
}
