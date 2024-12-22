package net.dr_complex.double_edged_enchantments.datagen;

import net.dr_complex.double_edged_enchantments.block.DEE_Blocks;
import net.dr_complex.double_edged_enchantments.other.DEE_Tags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class DEE_BlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public DEE_BlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(DEE_Blocks.VOID_FANG_BLOCK)
                .add(DEE_Blocks.END_VOID_FANG_ORE);

        getOrCreateTagBuilder(DEE_Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(DEE_Blocks.END_VOID_FANG_ORE)
                .add(DEE_Blocks.VOID_FANG_BLOCK);
    }
}
