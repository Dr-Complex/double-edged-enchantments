package net.dr_complex.double_edged_enchantments.datagen;

import net.dr_complex.double_edged_enchantments.enchantments.DEE_Enchantments;
import net.dr_complex.double_edged_enchantments.other.DEE_Tags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.loot.LootTable;
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
               .add(DEE_Enchantments.CURSE_FRAGILE)
               .add(DEE_Enchantments.CURSE_NARROW)
               .add(DEE_Enchantments.CURSE_IRON_MAIDEN)
               .add(DEE_Enchantments.CURSE_LOSS)
               .add(DEE_Enchantments.CURSE_UNENDING)
               .add(DEE_Enchantments.CURSE_IMPALED)
               .add(DEE_Enchantments.CURSE_THALASSOPHOBIA)
               .add(DEE_Enchantments.CURSE_JUPITER)
               .add(DEE_Enchantments.CURSE_STONES)
               .add(DEE_Enchantments.CURSE_SOULLESS)
               .add(DEE_Enchantments.CURSE_NECROPHOBIA)
               .add(DEE_Enchantments.CURSE_DROWNING)
               .add(DEE_Enchantments.CURSE_ASHES)
               .add(DEE_Enchantments.CURSE_HIDDEN);

        getOrCreateTagBuilder(EnchantmentTags.IN_ENCHANTING_TABLE)
                .add(DEE_Enchantments.ENCHANTMENT_LUCKY)
                .add(DEE_Enchantments.ENCHANTMENT_CRITICALITY);

        getOrCreateTagBuilder(EnchantmentTags.ON_RANDOM_LOOT).addOptionalTag(EnchantmentTags.CURSE);

        getOrCreateTagBuilder(EnchantmentTags.TREASURE)
                .add(DEE_Enchantments.ENCHANTMENT_MOON)
                .add(DEE_Enchantments.ENCHANTMENT_RETURN);

        getOrCreateTagBuilder(DEE_Tags.Enchantments.NEUTRAL_MAGIC)
                .add(DEE_Enchantments.NM_GROWTH)
                .add(DEE_Enchantments.NM_SHRUNKEN);
    }
}
