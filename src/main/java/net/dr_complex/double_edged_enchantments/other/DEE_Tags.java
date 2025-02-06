package net.dr_complex.double_edged_enchantments.other;

import net.dr_complex.double_edged_enchantments.DEE_Main;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class DEE_Tags {
    public static class Blocks{

        private static TagKey<Block> blockTagKey(String name){
            return TagKey.of(RegistryKeys.BLOCK, DEE_Main.id(name));
        }
    }

    public static class Items {

        public static final TagKey<Item> ARROW_SHOOT_ENCHANTABLE = itemTagKey("arrow_shoot_enchantable");
        public static final TagKey<Item> SHOOT_ENCHANTABLE = itemTagKey("shoot_enchantable");
        public static final TagKey<Item> SPEAR_WEAPONS = itemTagKey("spear_weapon");

        private static TagKey<Item> itemTagKey(String name){
            return TagKey.of(RegistryKeys.ITEM,DEE_Main.id(name));
        }
    }

    public static class Enchantments {

        public static final TagKey<Enchantment> ALL_GOOD = enchantmentTagKey("all_good");

        private static TagKey<Enchantment> enchantmentTagKey(String name){
            return TagKey.of(RegistryKeys.ENCHANTMENT,DEE_Main.id(name));
        }
    }
}
