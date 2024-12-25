package net.dr_complex.double_edged_enchantments.other;

import net.dr_complex.double_edged_enchantments.DEE_Main;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class DEE_Tags {
    public static class Blocks{
        public static final TagKey<Block> NEEDS_VOID_FANG_TOOL = blockTagKey("needs_void_fang_tool");
        public static final TagKey<Block> INCORRECT_VOID_FANG_TOOL = blockTagKey("incorrect_void_fang_tool");
        public static final TagKey<Block> NEEDS_NETHERITE_TOOL = blockTagKey("needs_netherite_tool");


        private static TagKey<Block> blockTagKey(String name){
            return TagKey.of(RegistryKeys.BLOCK, DEE_Main.id(name));
        }
    }

    public static class Items {
        public static final TagKey<Item> VOID_FANG_REPAIR = itemTagKey("void_fang_repair");

        private static TagKey<Item> itemTagKey(String name){
            return TagKey.of(RegistryKeys.ITEM,DEE_Main.id(name));
        }
    }

    public static class Enchantments{



        private static TagKey<Enchantment> EnchantmentTagKey(String name){
            return TagKey.of(RegistryKeys.ENCHANTMENT,DEE_Main.id(name));
        }
    }
}
