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
                .add(DEE_Enchantments.CURSE_UNLUCKY)
                .add(DEE_Enchantments.CURSE_CRUELNESS)
                .add(DEE_Enchantments.CURSE_ENTOMOPHOBIA)
                .add(DEE_Enchantments.CURSE_FUMBLING)
                .add(DEE_Enchantments.CURSE_RESONATING)
                .add(DEE_Enchantments.CURSE_REBUILDING)
                .add(DEE_Enchantments.CURSE_DULLNESS)
                .add(DEE_Enchantments.CURSE_FRAGILE);

        getOrCreateTagBuilder(EnchantmentTags.IN_ENCHANTING_TABLE)
                .add(DEE_Enchantments.ENCHANTMENT_LUCKY)
                .add(DEE_Enchantments.ENCHANTMENT_CRITICALITY);
    }
}
