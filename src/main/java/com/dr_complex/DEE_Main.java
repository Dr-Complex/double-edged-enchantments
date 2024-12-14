package com.dr_complex;

import com.dr_complex.block.DEE_Blocks;
import com.dr_complex.components.DEE_DataComponentTypes;
import com.dr_complex.item.DEE_ItemGroup;
import com.dr_complex.item.DEE_Items;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DEE_Main implements ModInitializer {
	public static final String MOD_ID = "double-edged-enchantments";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static Identifier id(String path){
		return Identifier.of(MOD_ID,path);
	}

	@Override
	public void onInitialize() {
		DEE_ItemGroup.LoadItemGroups();
		DEE_Items.LoadItems();
		DEE_Blocks.LoadBlocks();
		DEE_DataComponentTypes.LoadDataComponents();
		LOGGER.info(MOD_ID + " is done");
	}
}