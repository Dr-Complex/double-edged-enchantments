package com.dr_complex;

import com.dr_complex.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class DEE_DataGen implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(DEE_BlockTagProvider::new);
		pack.addProvider(DEE_ItemTagProvider::new);
		//pack.addProvider(DEE_RecipeProvider::new);
		pack.addProvider(DEE_ModelProvider::new);
		pack.addProvider(DEE_LootProvider::new);
	}
}
