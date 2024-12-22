package net.dr_complex.double_edged_enchantments.datagen;

import net.dr_complex.double_edged_enchantments.item.DEE_Items;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.predicate.NumberRange;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class DEE_RecipeProvider extends FabricRecipeProvider {
    public DEE_RecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup,recipeExporter) {
            @Override
            public void generate() {
                offerSmithingTrimRecipe(DEE_Items.BODY_SMITHING_TEMPLATE, RegistryKey.of(RegistryKeys.RECIPE, Identifier.ofVanilla(getItemPath(DEE_Items.BODY_SMITHING_TEMPLATE) + "_smithing_trim")));

                createShaped(RecipeCategory.COMBAT,DEE_Items.REVERED_ENDER_PEARL,3)
                        .input('#',DEE_Items.MOLTEN_ENDER_PEARL)
                        .input('A', Items.AMETHYST_SHARD)
                        .pattern(" A ")
                        .pattern("#A#")
                        .pattern(" A ")
                        .criterion(hasItem(DEE_Items.MOLTEN_ENDER_PEARL),conditionsFromItem(NumberRange.IntRange.exactly(2),DEE_Items.MOLTEN_ENDER_PEARL))
                        .criterion(hasItem(Items.AMETHYST_SHARD),conditionsFromItem(NumberRange.IntRange.exactly(3),Items.AMETHYST_SHARD))
                        .offerTo(exporter);

                offerSmelting(List.of(Items.ENDER_PEARL),RecipeCategory.MISC,DEE_Items.MOLTEN_ENDER_PEARL,0.45f,200,"molten_ender_pearl");
            }
        };
    }

    @Override
    public String getName() {
        return "Double Edged Enchantments : Recipes";
    }
}
