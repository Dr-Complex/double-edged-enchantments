package com.dr_complex.block;

import com.dr_complex.DEE_Main;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Rarity;

public class DEE_Blocks {

    public static final Block END_VOIDFANG_ORE = registerBlock("voidfang_ore_end",new Block(AbstractBlock.Settings.create().strength(6f).dropsNothing().hardness(10f).requiresTool().sounds(BlockSoundGroup.ANCIENT_DEBRIS).registryKey(RegistryKey.of(RegistryKeys.BLOCK,DEE_Main.id("voidfang_ore_end")))));
    public static final Block VOIDFANG_BLOCK = registerBlock("voidfang_block",new Block(AbstractBlock.Settings.create().strength(6f).dropsNothing().hardness(10f).requiresTool().sounds(BlockSoundGroup.ANCIENT_DEBRIS).registryKey(RegistryKey.of(RegistryKeys.BLOCK,DEE_Main.id("voidfang_block")))));

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
