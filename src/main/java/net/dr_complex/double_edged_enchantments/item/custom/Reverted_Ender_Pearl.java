package net.dr_complex.double_edged_enchantments.item.custom;

import net.dr_complex.double_edged_enchantments.other.DEE_DataComponentTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.List;

public class Reverted_Ender_Pearl extends Item {
    public Reverted_Ender_Pearl(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, @NotNull PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getMainHandStack();
        if(itemStack.get(DEE_DataComponentTypes.POS_CONTAINER) != null){
            if(!world.isClient){
                if(!user.isSneaking()){
                    user.teleport((ServerWorld) world,itemStack.get(DEE_DataComponentTypes.POS_CONTAINER).getX() + 0.5d,itemStack.get(DEE_DataComponentTypes.POS_CONTAINER).getY() + 1.2d,itemStack.get(DEE_DataComponentTypes.POS_CONTAINER).getZ() + 0.5d, HashSet.newHashSet(1) ,user.headYaw,user.prevPitch,false);
                    itemStack.decrementUnlessCreative(1,user);
                    return ActionResult.CONSUME;
                }else {
                    itemStack.set(DEE_DataComponentTypes.POS_CONTAINER,user.getBlockPos());
                    return ActionResult.SUCCESS;
                }
            }else {
                if(!user.isSneaking()){
                    for (int i = 0; i < 25; i++) {
                        world.playSound(user,user.getX(),user.getY(),user.getZ(), SoundEvents.ENTITY_PLAYER_TELEPORT, SoundCategory.PLAYERS,0.75f,-1.5f);
                        world.addParticle(ParticleTypes.PORTAL,user.getParticleX(0.25),user.getRandomBodyY(),user.getParticleZ(0.25),(user.getRandom().nextDouble() - 0.5d)*2.0,0,(user.getRandom().nextDouble() - 0.5d)*2.0);
                    }
                }else {
                    world.playSound(user,user.getX(),user.getY(),user.getZ(), SoundEvents.UI_BUTTON_CLICK, SoundCategory.PLAYERS,0.75f,0f);
                }
                return ActionResult.PASS;
            }
        }else{
            itemStack.set(DEE_DataComponentTypes.POS_CONTAINER,user.getBlockPos());
            return ActionResult.SUCCESS;
        }
    }

    @Override
    public void appendTooltip(@NotNull ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(stack.get(DEE_DataComponentTypes.POS_CONTAINER) != null){
            tooltip.add(Text.of(stack.get(DEE_DataComponentTypes.POS_CONTAINER).getX() + " , " + stack.get(DEE_DataComponentTypes.POS_CONTAINER).getY() + " , " + stack.get(DEE_DataComponentTypes.POS_CONTAINER).getZ()));
        }
        super.appendTooltip(stack, context, tooltip, type);
    }
}
