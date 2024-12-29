package net.dr_complex.double_edged_enchantments.other;

import net.dr_complex.double_edged_enchantments.DEE_Main;
import net.minecraft.block.Block;
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

        public static final TagKey<Item> TOOLS = itemTagKey("tools");

        private static TagKey<Item> itemTagKey(String name){
            return TagKey.of(RegistryKeys.ITEM,DEE_Main.id(name));
        }
    }
}
