package net.dr_complex.double_edged_enchantments.item;

import net.dr_complex.double_edged_enchantments.DEE_Main;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.EnchantmentTags;
import net.minecraft.text.Text;


public class DEE_ItemGroup {

    public static final ItemGroup DEE_GROUP = Registry.register(Registries.ITEM_GROUP,DEE_Main.id("dee_group"),
            FabricItemGroup.builder()
                    .icon(()->new ItemStack(Items.ENCHANTED_BOOK))
                    .displayName(Text.translatable("item_group.double_edged_enchantments.dee_group"))
                    .entries((displayContext, entries) ->{

                        entries.add(DEE_Items.REVERED_ENDER_PEARL);
                        entries.add(DEE_Items.EXP_NEEDLE);
                        entries.add(DEE_Items.COPPER_NUGGET);
                        entries.add(DEE_Items.WOODEN_SPEAR);
                        entries.add(DEE_Items.STONE_SPEAR);
                        entries.add(DEE_Items.GOLDEN_SPEAR);
                        entries.add(DEE_Items.COPPER_SPEAR);
                        entries.add(DEE_Items.IRON_SPEAR);
                        entries.add(DEE_Items.DIAMOND_SPEAR);
                        entries.add(DEE_Items.NETHERITE_SPEAR);
                        entries.add(DEE_Items.HEXING_TABLE);

                        displayContext.lookup().getOptional(RegistryKeys.ENCHANTMENT).ifPresent(enchantmentImpl -> enchantmentImpl.streamEntries()
                                .filter(tag -> !tag.isIn(EnchantmentTags.CURSE))
                                .map(reference -> EnchantmentHelper.getEnchantedBookWith(new EnchantmentLevelEntry(reference,reference.value().getMaxLevel())))
                                .forEach(itemStack -> entries.add(itemStack, ItemGroup.StackVisibility.PARENT_TAB_ONLY)));

                        displayContext.lookup().getOptional(RegistryKeys.ENCHANTMENT).ifPresent(enchantmentImpl -> enchantmentImpl.streamEntries()
                                .filter(tag -> tag.isIn(EnchantmentTags.CURSE))
                                .map(reference -> EnchantmentHelper.getEnchantedBookWith(new EnchantmentLevelEntry(reference,reference.value().getMaxLevel())))
                                .forEach(itemStack -> entries.add(itemStack, ItemGroup.StackVisibility.PARENT_TAB_ONLY)));

                    }).build());

    public static void LoadItemGroups(){
        DEE_Main.LOGGER.info("ItemGroups are now known");
    }
}
