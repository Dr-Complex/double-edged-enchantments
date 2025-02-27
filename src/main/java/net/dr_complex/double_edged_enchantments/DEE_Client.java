package net.dr_complex.double_edged_enchantments;

import net.dr_complex.double_edged_enchantments.entity.DEE_Entities;
import net.dr_complex.double_edged_enchantments.entity.client.AbstractSpearEntityRenderer;
import net.dr_complex.double_edged_enchantments.entity.client.SpearEntityModel;
import net.dr_complex.double_edged_enchantments.screen.DEE_ScreenHandlers;
import net.dr_complex.double_edged_enchantments.screen.HexingTableScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class DEE_Client implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(SpearEntityModel.Main,SpearEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(DEE_Entities.WOODEN_SPEAR_ENTITY_TYPE, AbstractSpearEntityRenderer::new);
        EntityRendererRegistry.register(DEE_Entities.STONE_SPEAR_ENTITY_TYPE, AbstractSpearEntityRenderer::new);
        EntityRendererRegistry.register(DEE_Entities.GOLDEN_SPEAR_ENTITY_TYPE, AbstractSpearEntityRenderer::new);
        EntityRendererRegistry.register(DEE_Entities.COPPER_SPEAR_ENTITY_TYPE, AbstractSpearEntityRenderer::new);
        EntityRendererRegistry.register(DEE_Entities.IRON_SPEAR_ENTITY_TYPE, AbstractSpearEntityRenderer::new);
        EntityRendererRegistry.register(DEE_Entities.DIAMOND_SPEAR_ENTITY_TYPE, AbstractSpearEntityRenderer::new);
        EntityRendererRegistry.register(DEE_Entities.NETHERITE_SPEAR_ENTITY_TYPE, AbstractSpearEntityRenderer::new);
        HandledScreens.register(DEE_ScreenHandlers.HEXING_TABLE_SCREEN_HANDLER, HexingTableScreen::new);
    }
}
