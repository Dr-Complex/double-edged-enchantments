package net.dr_complex.double_edged_enchantments.datagen;

import net.dr_complex.double_edged_enchantments.item.DEE_Items;
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

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(DEE_Items.XP_NEEDLE, Models.HANDHELD_ROD);
        itemModelGenerator.register(DEE_Items.REVERED_ENDER_PEARL, Models.GENERATED);
        itemModelGenerator.register(DEE_Items.DEBUGGING_TOOL,Models.HANDHELD);
    }
}
