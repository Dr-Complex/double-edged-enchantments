package com.dr_complex.components;

import com.dr_complex.DEE_Main;
import com.mojang.serialization.Codec;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.math.BlockPos;

import java.util.function.UnaryOperator;

public class DEE_DataComponentTypes {

    public static final ComponentType<BlockPos> POS_CONTAINER = register("pos_container",blockPosBuilder -> blockPosBuilder.codec(BlockPos.CODEC));
    public static final ComponentType<Float> EXP_CONTAINER = register("container",floatBuilder -> floatBuilder.codec(Codec.FLOAT));

    private static <T>ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderUnaryOperator){
        return Registry.register(Registries.DATA_COMPONENT_TYPE,DEE_Main.id(name), builderUnaryOperator.apply(ComponentType.builder()).build());
    }

    public static void LoadDataComponents(){
        DEE_Main.LOGGER.info("Damaging the data (not really)");
    }
}
