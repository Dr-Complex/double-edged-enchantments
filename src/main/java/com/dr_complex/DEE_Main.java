package com.dr_complex;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DEE_Main implements ModInitializer {
	public static final String MOD_ID = "double-edged-enchantments";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info(MOD_ID + "is done");
	}
}