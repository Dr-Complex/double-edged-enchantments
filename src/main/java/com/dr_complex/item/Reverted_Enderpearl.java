package com.dr_complex.item;

import com.dr_complex.components.DEE_DataComponentTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.HashSet;
import java.util.List;

public class Reverted_Enderpearl extends Item {
    public Reverted_Enderpearl(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(!context.getWorld().isClient && !context.shouldCancelInteraction()) {
            context.getStack().set(DEE_DataComponentTypes.POS_CONTAINER,context.getBlockPos());
            return ActionResult.SUCCESS;
        }else return ActionResult.PASS;
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getMainHandStack();
        if(itemStack.get(DEE_DataComponentTypes.POS_CONTAINER) != null && !world.isClient && user.isSneaking()){
            user.teleport((ServerWorld) world,itemStack.get(DEE_DataComponentTypes.POS_CONTAINER).getX() + 0.5d,itemStack.get(DEE_DataComponentTypes.POS_CONTAINER).getY() + 1.2d,itemStack.get(DEE_DataComponentTypes.POS_CONTAINER).getZ() + 0.5d, HashSet.newHashSet(1) ,user.headYaw,user.prevPitch,false);
            user.setIgnoreFallDamageFromCurrentExplosion(true);
            itemStack.decrementUnlessCreative(1,user);
            return ActionResult.CONSUME;
        }else return ActionResult.PASS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(stack.get(DEE_DataComponentTypes.POS_CONTAINER) != null){
            tooltip.add(Text.of(stack.get(DEE_DataComponentTypes.POS_CONTAINER).toString()));
        }
        super.appendTooltip(stack, context, tooltip, type);
    }
}
