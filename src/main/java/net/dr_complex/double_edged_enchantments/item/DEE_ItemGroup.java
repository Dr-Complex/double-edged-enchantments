package net.dr_complex.double_edged_enchantments.item;

import net.dr_complex.double_edged_enchantments.DEE_Main;
import net.dr_complex.double_edged_enchantments.block.DEE_Blocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.EnchantmentTags;
import net.minecraft.text.Text;


public class DEE_ItemGroup {

    private static boolean Run = true;

    public static final ItemGroup DEE_GROUP = Registry.register(Registries.ITEM_GROUP,DEE_Main.id("dee_group"),
            FabricItemGroup.builder()
                    .icon(()->new ItemStack(DEE_Items.VOID_FANG))
                    .displayName(Text.translatable("item_group.double_edged_enchantments.dee_group"))
                    .entries((displayContext, entries) ->{
                        entries.add(DEE_Items.VOID_FANG);
                        entries.add(DEE_Items.MOLTEN_ENDER_PEARL);

                        entries.add(DEE_Items.REVERED_ENDER_PEARL);
                        entries.add(DEE_Items.XP_NEEDLE);

                        entries.add(DEE_Items.VOID_FANG_SWORD);
                        entries.add(DEE_Items.VOID_FANG_AXE);
                        entries.add(DEE_Items.VOID_FANG_PICKAXE);
                        entries.add(DEE_Items.VOID_FANG_SHOVEL);
                        entries.add(DEE_Items.VOID_FANG_HOE);

                        entries.add(DEE_Items.VOID_FANG_HELMET);
                        entries.add(DEE_Items.VOID_FANG_CHESTPLATE);
                        entries.add(DEE_Items.VOID_FANG_LEGGINGS);
                        entries.add(DEE_Items.VOID_FANG_BOOTS);
                        entries.add(DEE_Items.VOID_FANG_HORSE_ARMOR);

                        entries.add(DEE_Items.BODY_SMITHING_TEMPLATE);

                        entries.add(DEE_Blocks.VOID_FANG_BLOCK);
                        entries.add(DEE_Blocks.END_VOID_FANG_ORE);

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
