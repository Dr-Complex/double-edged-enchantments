package net.dr_complex.double_edged_enchantments.entity;

import net.dr_complex.double_edged_enchantments.DEE_Main;
import net.dr_complex.double_edged_enchantments.block.DEE_Blocks;
import net.dr_complex.double_edged_enchantments.entity.block.HexingTableEntity;
import net.dr_complex.double_edged_enchantments.entity.projectiles.*;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityType;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class DEE_Entities {

    public static <T extends BlockEntityType<?>> T registerBlockEntity(String path,T blockEntityType){
        return Registry.register(Registries.BLOCK_ENTITY_TYPE,DEE_Main.id(path),blockEntityType);
    }

    public static final EntityType<WoodenSpearEntity> WOODEN_SPEAR_ENTITY_TYPE = Registry.register(
            Registries.ENTITY_TYPE,DEE_Main.id("wooden_spear_entity"),
            EntityType.Builder.<WoodenSpearEntity>create(WoodenSpearEntity::new, SpawnGroup.MISC).dimensions(0.25f,0.25f)
                    .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE,DEE_Main.id("wooden_spear_entity"))));

    public static final EntityType<StoneSpearEntity> STONE_SPEAR_ENTITY_TYPE = Registry.register(
            Registries.ENTITY_TYPE,DEE_Main.id("stone_spear_entity"),
            EntityType.Builder.<StoneSpearEntity>create(StoneSpearEntity::new, SpawnGroup.MISC).dimensions(0.25f,0.25f)
                    .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE,DEE_Main.id("stone_spear_entity"))));

    public static final EntityType<GoldenSpearEntity> GOLDEN_SPEAR_ENTITY_TYPE = Registry.register(
            Registries.ENTITY_TYPE,DEE_Main.id("golden_spear_entity"),
            EntityType.Builder.<GoldenSpearEntity>create(GoldenSpearEntity::new, SpawnGroup.MISC).dimensions(0.25f,0.25f)
                    .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE,DEE_Main.id("golden_spear_entity"))));

    public static final EntityType<IronSpearEntity> IRON_SPEAR_ENTITY_TYPE = Registry.register(
            Registries.ENTITY_TYPE,DEE_Main.id("iron_spear_entity"),
            EntityType.Builder.<IronSpearEntity>create(IronSpearEntity::new, SpawnGroup.MISC).dimensions(0.25f,0.25f)
                    .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE,DEE_Main.id("iron_spear_entity"))));

    public static final EntityType<DiamondSpearEntity> DIAMOND_SPEAR_ENTITY_TYPE = Registry.register(
            Registries.ENTITY_TYPE,DEE_Main.id("diamond_spear_entity"),
            EntityType.Builder.<DiamondSpearEntity>create(DiamondSpearEntity::new, SpawnGroup.MISC).dimensions(0.25f,0.25f)
                    .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE,DEE_Main.id("diamond_spear_entity"))));

    public static final EntityType<NetheriteSpearEntity> NETHERITE_SPEAR_ENTITY_TYPE = Registry.register(
            Registries.ENTITY_TYPE,DEE_Main.id("netherite_spear_entity"),
            EntityType.Builder.<NetheriteSpearEntity>create(NetheriteSpearEntity::new, SpawnGroup.MISC).dimensions(0.25f,0.25f)
                    .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE,DEE_Main.id("netherite_spear_entity"))));

    public static final EntityType<CopperSpearEntity> COPPER_SPEAR_ENTITY_TYPE = Registry.register(
            Registries.ENTITY_TYPE,DEE_Main.id("copper_spear_entity"),
            EntityType.Builder.<CopperSpearEntity>create(CopperSpearEntity::new, SpawnGroup.MISC).dimensions(0.25f,0.25f)
                    .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE,DEE_Main.id("copper_spear_entity"))));

    public static final BlockEntityType<HexingTableEntity> HEXING_TABLE_ENTITY_BLOCK_ENTITY_TYPE = registerBlockEntity(
            "hexing_table",
            FabricBlockEntityTypeBuilder.create(HexingTableEntity::new,DEE_Blocks.HEXING_TABLE).build()
    );

    public static void LoadEntities(){
        DEE_Main.LOGGER.info("Entities are now shipped by shipping ships");
    }
}
