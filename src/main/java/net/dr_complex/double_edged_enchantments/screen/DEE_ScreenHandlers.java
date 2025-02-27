package net.dr_complex.double_edged_enchantments.screen;

import net.dr_complex.double_edged_enchantments.DEE_Main;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;

public class DEE_ScreenHandlers{

    public static final ScreenHandlerType<HexingTableScreenHandler> HEXING_TABLE_SCREEN_HANDLER= register("hexing_table",HexingTableScreenHandler::new);

    private static <T extends ScreenHandler> ScreenHandlerType<T> register(String id, ScreenHandlerType.Factory<T> factory) {
        return Registry.register(Registries.SCREEN_HANDLER, id, new ScreenHandlerType<>(factory, FeatureFlags.VANILLA_FEATURES));
    }

    public static void LoadScreens(){
        DEE_Main.LOGGER.info("Screens are now smashed");
    }
}
