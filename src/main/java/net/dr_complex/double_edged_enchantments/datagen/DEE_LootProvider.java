package net.dr_complex.double_edged_enchantments.datagen;

import net.dr_complex.double_edged_enchantments.block.DEE_Blocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class DEE_LootProvider extends FabricBlockLootTableProvider {
    public DEE_LootProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(DEE_Blocks.VOID_FANG_BLOCK);
    }
}
