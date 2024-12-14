package com.dr_complex.item;


import com.dr_complex.DEE_Main;
import com.dr_complex.components.DEE_DataComponentTypes;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class XP_Needle extends Item {


    public XP_Needle(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getMainHandStack();
        if(!world.isClient()){
            if (user.isSneaking()){
                if(itemStack.get(DEE_DataComponentTypes.EXP_CONTAINER) != null){
                    itemStack.set(DEE_DataComponentTypes.EXP_CONTAINER,itemStack.get(DEE_DataComponentTypes.EXP_CONTAINER)+1.0f);
                }else {
                    itemStack.set(DEE_DataComponentTypes.EXP_CONTAINER,0f);
                }
            } else {
                if(itemStack.get(DEE_DataComponentTypes.EXP_CONTAINER) != null){
                    itemStack.set(DEE_DataComponentTypes.EXP_CONTAINER,itemStack.get(DEE_DataComponentTypes.EXP_CONTAINER)-1.0f);
                }else {
                    itemStack.set(DEE_DataComponentTypes.EXP_CONTAINER,0f);
                }
            }
            
        }
        return ActionResult.SUCCESS;
    }
}
