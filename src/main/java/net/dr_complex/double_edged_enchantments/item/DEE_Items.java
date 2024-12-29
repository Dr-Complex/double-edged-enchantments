package net.dr_complex.double_edged_enchantments.item;

import net.dr_complex.double_edged_enchantments.DEE_Main;
import net.dr_complex.double_edged_enchantments.item.custom.Debugging_Tool;
import net.dr_complex.double_edged_enchantments.item.custom.Reverted_Ender_Pearl;
import net.dr_complex.double_edged_enchantments.item.custom.XP_Needle;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Rarity;

public class DEE_Items {

    public static final Item REVERED_ENDER_PEARL = registerItem("reverted_ender_pearl", new Reverted_Ender_Pearl(new Item.Settings().rarity(Rarity.COMMON).maxCount(16).useCooldown(1.5f).registryKey(RegistryKey.of(RegistryKeys.ITEM,DEE_Main.id("reverted_ender_pearl")))));
    public static final Item DEBUGGING_TOOL = registerItem("debugging_tool",new Debugging_Tool(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM,DEE_Main.id("debugging_tool")))));
    public static final Item XP_NEEDLE = registerItem("xp_needle",new XP_Needle(new Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1).registryKey(RegistryKey.of(RegistryKeys.ITEM,DEE_Main.id("xp_needle")))));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM,DEE_Main.id(name),item);
    }

    public static void LoadItems(){
        DEE_Main.LOGGER.info("Items are now cursed");
    }
}
