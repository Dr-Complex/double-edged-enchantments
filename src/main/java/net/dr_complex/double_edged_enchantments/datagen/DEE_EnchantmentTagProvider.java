package net.dr_complex.double_edged_enchantments.datagen;

import net.dr_complex.double_edged_enchantments.enchantments.DEE_Enchantments;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.EnchantmentTags;

import java.util.concurrent.CompletableFuture;

public class DEE_EnchantmentTagProvider extends FabricTagProvider.EnchantmentTagProvider {
    public DEE_EnchantmentTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(EnchantmentTags.CURSE)
                .add(DEE_Enchantments.CURSE_UNFAVOURABLE)
                .add(DEE_Enchantments.CURSE_CRITICAL_MISS)
                .add(DEE_Enchantments.CURSE_ENTOMOPHOBIA);

        getOrCreateTagBuilder(EnchantmentTags.IN_ENCHANTING_TABLE)
                .add(DEE_Enchantments.ENCHANTMENT_LUCKY)
                .add(DEE_Enchantments.ENCHANTMENT_PIVOTAL);
    }
}
