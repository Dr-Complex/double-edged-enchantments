package net.dr_complex.double_edged_enchantments.block;

import net.dr_complex.double_edged_enchantments.DEE_Main;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Rarity;

public class DEE_Blocks {

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK,DEE_Main.id(name),block);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM,DEE_Main.id(name),new BlockItem(block, new Item.Settings().rarity(Rarity.COMMON).registryKey(RegistryKey.of(RegistryKeys.ITEM,DEE_Main.id(name)))));
    }

    public static void LoadBlocks(){
        DEE_Main.LOGGER.info("Blocks are enchanted");
    }
}
