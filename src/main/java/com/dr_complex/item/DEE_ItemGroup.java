package com.dr_complex.item;

import com.dr_complex.DEE_Main;
import com.dr_complex.block.DEE_Blocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;


public class DEE_ItemGroup {
    public static final ItemGroup DEE_GROUP = Registry.register(Registries.ITEM_GROUP,DEE_Main.id("dee_group"),
            FabricItemGroup.builder()
                    .icon(()->new ItemStack(DEE_Items.VOIDFANG))
                    .displayName(Text.translatable("item_group.double-edged-enchantments.dee_group"))
                    .entries((displayContext, entries) ->{
                        entries.add(DEE_Items.VOIDFANG);
                        entries.add(DEE_Items.REVERED_ENDERPEARL);
                        entries.add(DEE_Items.XP_NEEDLE);
                        entries.add(DEE_Blocks.VOIDFANG_BLOCK);
                        entries.add(DEE_Blocks.END_VOIDFANG_ORE);
                    }).build()
    );

    public static void LoadItemGroups(){
        DEE_Main.LOGGER.info("ItemGroups are now known");
    }
}
