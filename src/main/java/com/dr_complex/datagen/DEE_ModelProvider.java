package com.dr_complex.datagen;

import com.dr_complex.block.DEE_Blocks;
import com.dr_complex.item.DEE_Items;
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
        blockStateModelGenerator.registerSimpleCubeAll(DEE_Blocks.END_VOIDFANG_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(DEE_Blocks.VOIDFANG_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(DEE_Items.VOIDFANG, Models.GENERATED);
        itemModelGenerator.register(DEE_Items.XP_NEEDLE, Models.GENERATED);
        itemModelGenerator.register(DEE_Items.REVERED_ENDERPEARL, Models.GENERATED);
    }
}
