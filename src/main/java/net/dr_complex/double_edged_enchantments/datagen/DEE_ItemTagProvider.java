package net.dr_complex.double_edged_enchantments.datagen;

import net.dr_complex.double_edged_enchantments.other.DEE_Tags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class DEE_ItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public DEE_ItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(DEE_Tags.Items.SHOOT_ENCHANTABLE)
                .addOptionalTag(ItemTags.CROSSBOW_ENCHANTABLE)
                .addOptionalTag(ItemTags.BOW_ENCHANTABLE);
    }
}
