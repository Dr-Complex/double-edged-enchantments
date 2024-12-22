package net.dr_complex.double_edged_enchantments.datagen;

import net.dr_complex.double_edged_enchantments.block.DEE_Blocks;
import net.dr_complex.double_edged_enchantments.item.DEE_Items;
import net.dr_complex.double_edged_enchantments.other.DEE_EquipmentAssetKeys;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class DEE_ModelProvider extends FabricModelProvider {
    public DEE_ModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(DEE_Blocks.END_VOID_FANG_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(DEE_Blocks.VOID_FANG_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(DEE_Items.VOID_FANG, Models.GENERATED);
        itemModelGenerator.register(DEE_Items.XP_NEEDLE, Models.HANDHELD_ROD);
        itemModelGenerator.register(DEE_Items.REVERED_ENDER_PEARL, Models.GENERATED);
        itemModelGenerator.register(DEE_Items.MOLTEN_ENDER_PEARL, Models.GENERATED);
        itemModelGenerator.register(DEE_Items.VOID_FANG_SWORD, Models.HANDHELD);
        itemModelGenerator.register(DEE_Items.VOID_FANG_AXE, Models.HANDHELD);
        itemModelGenerator.register(DEE_Items.VOID_FANG_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(DEE_Items.VOID_FANG_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(DEE_Items.VOID_FANG_HOE, Models.HANDHELD);
        itemModelGenerator.registerArmor(DEE_Items.VOID_FANG_HELMET, DEE_EquipmentAssetKeys.VOID_FANG,"helmet",false);
        itemModelGenerator.registerArmor(DEE_Items.VOID_FANG_CHESTPLATE, DEE_EquipmentAssetKeys.VOID_FANG,"chestplate",false);
        itemModelGenerator.registerArmor(DEE_Items.VOID_FANG_LEGGINGS, DEE_EquipmentAssetKeys.VOID_FANG,"leggings",false);
        itemModelGenerator.registerArmor(DEE_Items.VOID_FANG_BOOTS, DEE_EquipmentAssetKeys.VOID_FANG,"boots",false);
        itemModelGenerator.register(DEE_Items.VOID_FANG_HORSE_ARMOR,Models.GENERATED);
        itemModelGenerator.register(DEE_Items.BODY_SMITHING_TEMPLATE,Models.GENERATED);
    }
}
