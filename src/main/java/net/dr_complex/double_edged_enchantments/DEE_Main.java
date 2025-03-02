package net.dr_complex.double_edged_enchantments;

import net.dr_complex.double_edged_enchantments.block.DEE_Blocks;
import net.dr_complex.double_edged_enchantments.enchantments.DEE_Enchantment_Effects;
import net.dr_complex.double_edged_enchantments.entity.DEE_Entities;
import net.dr_complex.double_edged_enchantments.item.DEE_ItemGroup;
import net.dr_complex.double_edged_enchantments.item.DEE_Items;
import net.dr_complex.double_edged_enchantments.other.DEE_DataComponentTypes;
import net.dr_complex.double_edged_enchantments.screen.DEE_ScreenHandlers;
import net.fabricmc.api.ModInitializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DEE_Main implements ModInitializer {
	public static final String MOD_ID = "double_edged_enchantments";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	@Contract("_ -> new")
	public static @NotNull Identifier id(String path){
		return Identifier.of(MOD_ID,path);
	}

	public static final Identifier CURSED_STAT = id("cursed_stat");

	@Override
	public void onInitialize() {

		Registry.register(Registries.CUSTOM_STAT,"cursed_stat",CURSED_STAT);

		DEE_ItemGroup.LoadItemGroups();
		DEE_Items.LoadItems();
		DEE_Blocks.LoadBlocks();
		DEE_DataComponentTypes.LoadDataComponents();
		DEE_Enchantment_Effects.LoadEnchantmentEffects();
		DEE_Entities.LoadEntities();
		DEE_ScreenHandlers.LoadScreens();
		LOGGER.info(MOD_ID + " is done");
	}
}