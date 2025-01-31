package net.dr_complex.double_edged_enchantments.datagen;

import net.dr_complex.double_edged_enchantments.item.DEE_Items;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.*;
import net.minecraft.client.render.item.model.ItemModel;
import net.minecraft.client.render.item.property.bool.BooleanProperty;
import net.minecraft.client.render.item.property.bool.DamagedProperty;
import org.jetbrains.annotations.NotNull;


public class DEE_ModelProvider extends FabricModelProvider {

    public DEE_ModelProvider(FabricDataOutput output) {
        super(output);
    }


    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(@NotNull ItemModelGenerator itemModelGenerator) {

        ItemModel.Unbaked unbakedFalse = ItemModels.basic(ModelIds.getItemModelId(DEE_Items.EXP_NEEDLE));
        ItemModel.Unbaked unbakedTrue = ItemModels.basic(ModelIds.getItemSubModelId(DEE_Items.EXP_NEEDLE,"_empty"));
        BooleanProperty Condition = new DamagedProperty();

        itemModelGenerator.registerCondition( DEE_Items.EXP_NEEDLE, Condition, unbakedTrue, unbakedFalse);
        itemModelGenerator.register(DEE_Items.REVERED_ENDER_PEARL, Models.GENERATED);
        itemModelGenerator.register(DEE_Items.COPPER_NUGGET,Models.GENERATED);
    }
}
