package net.dr_complex.double_edged_enchantments.item.custom;

import net.dr_complex.double_edged_enchantments.other.DEE_DataComponentTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.List;

public class XP_Needle extends Item {
    int increased = 0;

    public XP_Needle(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getMainHandStack();

        if(!world.isClient()){
            if (!user.isSneaking()){
                if(itemStack.get(DEE_DataComponentTypes.XP_CONTAINER) != null ){
                    if(user.experienceLevel >= 1){
                        this.increased = -1;
                        itemStack.set(DEE_DataComponentTypes.XP_CONTAINER,itemStack.get(DEE_DataComponentTypes.XP_CONTAINER)+1.0f);
                    }else {
                        this.increased = 0;
                        user.sendMessage(Text.literal("not enough xp"),true);
                    }
                } else {
                    itemStack.set(DEE_DataComponentTypes.XP_CONTAINER,0f);

                }
            } else {
                if(itemStack.get(DEE_DataComponentTypes.XP_CONTAINER) != null){
                    if(itemStack.get(DEE_DataComponentTypes.XP_CONTAINER) > 0){
                        this.increased = 1;
                        itemStack.set(DEE_DataComponentTypes.XP_CONTAINER,itemStack.get(DEE_DataComponentTypes.XP_CONTAINER)-1.0f);
                    } else {
                        this.increased = 0;
                        user.sendMessage(Text.literal("no xp contained"),true);
                    }
                } else {
                    this.increased = 0;
                    itemStack.set(DEE_DataComponentTypes.XP_CONTAINER,0f);
                }
            }
        }
        user.experienceLevel += increased;
        world.playSound(user,user.getX(),user.getY(),user.getZ(), SoundEvents.ENTITY_ITEM_FRAME_ROTATE_ITEM, SoundCategory.PLAYERS,0.5f,0.25f);
        return increased != 0 ? ActionResult.SUCCESS : ActionResult.FAIL;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(stack.get(DEE_DataComponentTypes.XP_CONTAINER) != null){
            tooltip.add(Text.of(stack.get(DEE_DataComponentTypes.XP_CONTAINER) + " xp contained"));
        }
        super.appendTooltip(stack, context, tooltip, type);
    }
}
