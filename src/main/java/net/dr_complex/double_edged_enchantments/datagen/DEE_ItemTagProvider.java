package net.dr_complex.double_edged_enchantments.datagen;

import net.dr_complex.double_edged_enchantments.item.DEE_Items;
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
        getOrCreateTagBuilder(DEE_Tags.Items.VOID_FANG_REPAIR)
                .add(DEE_Items.VOID_FANG);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(DEE_Items.VOID_FANG_SWORD);

        getOrCreateTagBuilder(ItemTags.AXES)
                .add(DEE_Items.VOID_FANG_AXE);

        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(DEE_Items.VOID_FANG_PICKAXE);

        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(DEE_Items.VOID_FANG_SHOVEL);

        getOrCreateTagBuilder(ItemTags.HOES)
                .add(DEE_Items.VOID_FANG_HOE);

        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR)
                .add(DEE_Items.VOID_FANG_HELMET);

        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR)
                .add(DEE_Items.VOID_FANG_CHESTPLATE);

        getOrCreateTagBuilder(ItemTags.LEG_ARMOR)
                .add(DEE_Items.VOID_FANG_LEGGINGS);

        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR)
                .add(DEE_Items.VOID_FANG_BOOTS);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(DEE_Items.VOID_FANG_HELMET)
                .add(DEE_Items.VOID_FANG_BOOTS)
                .add(DEE_Items.VOID_FANG_CHESTPLATE)
                .add(DEE_Items.VOID_FANG_LEGGINGS);

        getOrCreateTagBuilder(ItemTags.TRIM_MATERIALS)
                .add(DEE_Items.VOID_FANG);
    }
}
