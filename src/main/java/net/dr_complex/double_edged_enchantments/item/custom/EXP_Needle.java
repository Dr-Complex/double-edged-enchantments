package net.dr_complex.double_edged_enchantments.item.custom;

import net.dr_complex.double_edged_enchantments.other.DEE_DataComponentTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.List;

public class EXP_Needle extends Item {
    int increased = 0;

    public EXP_Needle(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getMainHandStack();

        if(!world.isClient()){
            if (!user.isSneaking()){
                if(itemStack.get(DEE_DataComponentTypes.XP_CONTAINER) != null ){
                    if(user.experienceLevel >= 1){
                        if(itemStack.get(DEE_DataComponentTypes.XP_CONTAINER) < 256){
                            this.increased = 1;
                            itemStack.set(DEE_DataComponentTypes.XP_CONTAINER,itemStack.get(DEE_DataComponentTypes.XP_CONTAINER)+1);
                        }else {
                            this.increased = 0;
                            user.sendMessage(Text.literal("needle is full"),true);
                        }
                    }else {
                        this.increased = 0;
                    }
                } else {
                    this.increased = 1;
                    itemStack.set(DEE_DataComponentTypes.XP_CONTAINER,1);
                }
            } else {
                if(itemStack.get(DEE_DataComponentTypes.XP_CONTAINER) != null){
                    if(itemStack.get(DEE_DataComponentTypes.XP_CONTAINER) > 0){
                        this.increased = -1;
                        itemStack.set(DEE_DataComponentTypes.XP_CONTAINER,itemStack.get(DEE_DataComponentTypes.XP_CONTAINER)-1);
                    } else {
                        this.increased = 0;
                    }
                }
            }
        }

        if(itemStack.get(DEE_DataComponentTypes.XP_CONTAINER) != null){
            itemStack.setDamage(256 - (itemStack.get(DEE_DataComponentTypes.XP_CONTAINER)));
        }

        user.experienceLevel -= increased;
        return increased != 0 ? ActionResult.SUCCESS : ActionResult.FAIL;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(stack.get(DEE_DataComponentTypes.XP_CONTAINER) != null){
            tooltip.add(Text.of(stack.get(DEE_DataComponentTypes.XP_CONTAINER) + " / 256 "));
        }
        super.appendTooltip(stack, context, tooltip, type);
    }
}
