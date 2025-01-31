package net.dr_complex.double_edged_enchantments;

import net.dr_complex.double_edged_enchantments.datagen.*;
import net.dr_complex.double_edged_enchantments.enchantments.DEE_Enchantments;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class DEE_DataGen implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(DEE_BlockTagProvider::new);
		pack.addProvider(DEE_ItemTagProvider::new);
		pack.addProvider(DEE_ModelProvider::new);
		pack.addProvider(DEE_LootProvider::new);
		pack.addProvider(DEE_RegistryDataGen::new);
		pack.addProvider(DEE_EnchantmentTagProvider::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.ENCHANTMENT, DEE_Enchantments::bootstrap);
	}
}
