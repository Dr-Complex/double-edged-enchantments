package net.dr_complex.double_edged_enchantments.item.custom;

import net.dr_complex.double_edged_enchantments.other.DEE_DataComponentTypes;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ClickType;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Debugging_Tool extends Item{
    public Debugging_Tool(Settings settings) {
        super(settings);
    }
    private static float frames = 0;
    private static String mode_type = "null";
    private static double result = -1;

    @Override
    public ActionResult use(@NotNull World world, @NotNull PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getMainHandStack();
        if(!world.isClient){
            if(user.isSneaking()) {
                if(itemStack.get(DEE_DataComponentTypes.MODE_CONTAINER) != null){
                    GetMode(itemStack.get(DEE_DataComponentTypes.MODE_CONTAINER),user);
                    user.sendMessage(Text.of(String.valueOf(result).formatted(Formatting.UNDERLINE, Formatting.WHITE)), true);
                    return ActionResult.SUCCESS;
                }
            }
        }
        return ActionResult.FAIL;
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, @NotNull PlayerEntity user, LivingEntity entity, Hand hand) {
        if(!user.isSneaking()){
            if(stack.get(DEE_DataComponentTypes.MODE_CONTAINER) != null){
                GetMode(stack.get(DEE_DataComponentTypes.MODE_CONTAINER),entity);
                user.sendMessage(Text.of(String.valueOf(result).formatted(Formatting.UNDERLINE, Formatting.DARK_GRAY)), true);
                return ActionResult.SUCCESS;
            } else {
                user.sendMessage(Text.of("Mode not set!"),true);
            }
        }
        return ActionResult.FAIL;
    }

    @Override
    public void appendTooltip(@NotNull ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        stack.set(DEE_DataComponentTypes.RARITY_CONTAINER,1);
        if(stack.get(DEE_DataComponentTypes.MODE_CONTAINER) != null){
            GetMode(stack.get(DEE_DataComponentTypes.MODE_CONTAINER),null);
            if(frames > 0.5){
                tooltip.add(Text.literal("Mode").formatted(Formatting.GREEN).append(Text.literal(" : ").formatted(Formatting.DARK_GREEN).append(Text.literal(mode_type).formatted(Formatting.GREEN))));
                if(frames > 1)frames = 0;
            }else {
                tooltip.add(Text.literal("Mode").formatted(Formatting.DARK_GREEN).append(Text.literal(" : ").formatted(Formatting.GREEN).append(Text.literal(mode_type).formatted(Formatting.DARK_GREEN))));
            }
        } else {
            if(frames > 0.5f){
                tooltip.add(Text.literal("error").formatted(Formatting.RED,Formatting.OBFUSCATED));
                if(frames > 1.0f){
                    frames = 0;
                }
            } else {
                tooltip.add(Text.literal("error").formatted(Formatting.RED));
            }
        }
        frames += 0.015f;
    }

    @Override
    public boolean onClicked(ItemStack stack, ItemStack otherStack, Slot slot, ClickType clickType, PlayerEntity player, StackReference cursorStackReference) {
        if(clickType == ClickType.RIGHT){
            if(stack.get(DEE_DataComponentTypes.MODE_CONTAINER) != null){
                if(!Screen.hasAltDown()){
                    stack.set(DEE_DataComponentTypes.MODE_CONTAINER, stack.get(DEE_DataComponentTypes.MODE_CONTAINER) + 1);
                    if(stack.get(DEE_DataComponentTypes.MODE_CONTAINER) > 36){
                        stack.set(DEE_DataComponentTypes.MODE_CONTAINER,1);
                    }
                }else {
                    stack.set(DEE_DataComponentTypes.MODE_CONTAINER,stack.get(DEE_DataComponentTypes.MODE_CONTAINER) - 1);
                    if(stack.get(DEE_DataComponentTypes.MODE_CONTAINER) < 1){
                        stack.set(DEE_DataComponentTypes.MODE_CONTAINER,36);
                    }
                }
            } else {
                stack.set(DEE_DataComponentTypes.MODE_CONTAINER, 1);
            }
            return true;
        }else return false;
    }

    private void GetMode(int mode, @Nullable LivingEntity entity){
        if(entity != null) {
            if (mode == 1) {
                mode_type = "Armor";
                if(entity.getAttributes().hasAttribute(EntityAttributes.ARMOR)) result = entity.getAttributes().getValue(EntityAttributes.ARMOR);
                else result = -1;
            }
            if (mode == 2) {
                mode_type = "Armor Toughness";
                if(entity.getAttributes().hasAttribute(EntityAttributes.ARMOR_TOUGHNESS)) result = entity.getAttributes().getValue(EntityAttributes.ARMOR_TOUGHNESS);
                else result = -1;
            }
            if (mode == 3) {
                mode_type = "Attack Damage";
                if(entity.getAttributes().hasAttribute(EntityAttributes.ATTACK_DAMAGE)) result = entity.getAttributes().getValue(EntityAttributes.ATTACK_DAMAGE);
                else result = -1;
            }
            if (mode == 4) {
                mode_type = "Attack Knock-back";
                if(entity.getAttributes().hasAttribute(EntityAttributes.ATTACK_KNOCKBACK)) result = entity.getAttributes().getValue(EntityAttributes.ATTACK_KNOCKBACK);
                else result = -1;
            }
            if (mode == 5) {
                mode_type = "Attack Speed";
                if(entity.getAttributes().hasAttribute(EntityAttributes.ATTACK_SPEED)) result = entity.getAttributes().getValue(EntityAttributes.ATTACK_SPEED);
                else result = -1;
            }
            if (mode == 6) {
                mode_type = "Flying Speed";
                if(entity.getAttributes().hasAttribute(EntityAttributes.FLYING_SPEED)) result = entity.getAttributes().getValue(EntityAttributes.FLYING_SPEED);
                else result = -1;
            }
            if (mode == 7) {
                mode_type = "Follow Range";
                if(entity.getAttributes().hasAttribute(EntityAttributes.FOLLOW_RANGE)) result = entity.getAttributes().getValue(EntityAttributes.FOLLOW_RANGE);
                else result = -1;
            }
            if (mode == 8) {
                mode_type = "Knock-back Resistance";
                if(entity.getAttributes().hasAttribute(EntityAttributes.KNOCKBACK_RESISTANCE)) result = entity.getAttributes().getValue(EntityAttributes.KNOCKBACK_RESISTANCE);
                else result = -1;
            }
            if (mode == 9) {
                mode_type = "Luck";
                if(entity.getAttributes().hasAttribute(EntityAttributes.LUCK)) result = entity.getAttributes().getValue(EntityAttributes.LUCK);
                else result = -1;
            }
            if (mode == 10) {
                mode_type = "Max Absorption";
                if(entity.getAttributes().hasAttribute(EntityAttributes.MAX_ABSORPTION)) result = entity.getAttributes().getValue(EntityAttributes.MAX_ABSORPTION);
                else result = -1;
            }
            if (mode == 11) {
                mode_type = "Max Health";
                if(entity.getAttributes().hasAttribute(EntityAttributes.MAX_HEALTH)) result = entity.getAttributes().getValue(EntityAttributes.MAX_HEALTH);
                else result = -1;
            }
            if (mode == 12) {
                mode_type = "Movement Speed";
                if(entity.getAttributes().hasAttribute(EntityAttributes.MOVEMENT_SPEED)) result = entity.getAttributes().getValue(EntityAttributes.MOVEMENT_SPEED);
                else result = -1;
            }
            if (mode == 13) {
                mode_type = "Scale";
                if(entity.getAttributes().hasAttribute(EntityAttributes.SCALE)) result = entity.getAttributes().getValue(EntityAttributes.SCALE);
                else result = -1;
            }
            if (mode == 14) {
                mode_type = "Step Height";
                if(entity.getAttributes().hasAttribute(EntityAttributes.STEP_HEIGHT)) result = entity.getAttributes().getValue(EntityAttributes.STEP_HEIGHT);
                else result = -1;
            }
            if (mode == 15) {
                mode_type = "Jump Strength";
                if(entity.getAttributes().hasAttribute(EntityAttributes.JUMP_STRENGTH)) result = entity.getAttributes().getValue(EntityAttributes.JUMP_STRENGTH);
                else result = -1;
            }
            if (mode == 16) {
                mode_type = "Block Interaction Range";
                if(entity.getAttributes().hasAttribute(EntityAttributes.BLOCK_INTERACTION_RANGE)) result = entity.getAttributes().getValue(EntityAttributes.BLOCK_INTERACTION_RANGE);
                else result = -1;
            }
            if (mode == 17) {
                mode_type = "Entity Interaction Range";
                if(entity.getAttributes().hasAttribute(EntityAttributes.ENTITY_INTERACTION_RANGE)) result = entity.getAttributes().getValue(EntityAttributes.ENTITY_INTERACTION_RANGE);
                else result = -1;
            }
            if (mode == 18) {
                mode_type = "Spawn Reinforcements";
                if(entity.getAttributes().hasAttribute(EntityAttributes.SPAWN_REINFORCEMENTS)) result = entity.getAttributes().getValue(EntityAttributes.SPAWN_REINFORCEMENTS);
                else result = -1;
            }
            if (mode == 19) {
                mode_type = "Block Breaking Speed";
                if(entity.getAttributes().hasAttribute(EntityAttributes.BLOCK_BREAK_SPEED)) result = entity.getAttributes().getValue(EntityAttributes.BLOCK_BREAK_SPEED);
                else result = -1;
            }
            if (mode == 20) {
                mode_type = "Gravity";
                if(entity.getAttributes().hasAttribute(EntityAttributes.GRAVITY)) result = entity.getAttributes().getValue(EntityAttributes.GRAVITY);
                else result = -1;
            }
            if (mode == 21) {
                mode_type = "Safe Fall Distance";
                if(entity.getAttributes().hasAttribute(EntityAttributes.SAFE_FALL_DISTANCE)) result = entity.getAttributes().getValue(EntityAttributes.SAFE_FALL_DISTANCE);
                else result = -1;
            }
            if (mode == 22) {
                mode_type = "Fall Damage Multiplier";
                if(entity.getAttributes().hasAttribute(EntityAttributes.FALL_DAMAGE_MULTIPLIER)) result = entity.getAttributes().getValue(EntityAttributes.FALL_DAMAGE_MULTIPLIER);
                else result = -1;
            }
            if (mode == 23) {
                mode_type = "Burning Time";
                if(entity.getAttributes().hasAttribute(EntityAttributes.BURNING_TIME)) result = entity.getAttributes().getValue(EntityAttributes.BURNING_TIME);
                else result = -1;
            }
            if (mode == 24) {
                mode_type = "Explosion Knock-back Resistance";
                if(entity.getAttributes().hasAttribute(EntityAttributes.EXPLOSION_KNOCKBACK_RESISTANCE)) result = entity.getAttributes().getValue(EntityAttributes.EXPLOSION_KNOCKBACK_RESISTANCE);
                else result = -1;
            }
            if (mode == 25) {
                mode_type = "Mining Efficiency";
                if(entity.getAttributes().hasAttribute(EntityAttributes.MINING_EFFICIENCY)) result = entity.getAttributes().getValue(EntityAttributes.MINING_EFFICIENCY);
                else result = -1;
            }
            if (mode == 26) {
                mode_type = "Movement Efficiency";
                if(entity.getAttributes().hasAttribute(EntityAttributes.MOVEMENT_EFFICIENCY)) result = entity.getAttributes().getValue(EntityAttributes.MOVEMENT_EFFICIENCY);
                else result = -1;
            }
            if (mode == 27) {
                mode_type = "Oxygen Bonus";
                if(entity.getAttributes().hasAttribute(EntityAttributes.OXYGEN_BONUS)) result = entity.getAttributes().getValue(EntityAttributes.OXYGEN_BONUS);
                else result = -1;
            }
            if (mode == 28) {
                mode_type = "Sneaking Speed";
                if(entity.getAttributes().hasAttribute(EntityAttributes.SNEAKING_SPEED)) result = entity.getAttributes().getValue(EntityAttributes.SNEAKING_SPEED);
                else result = -1;
            }
            if (mode == 29) {
                mode_type = "Submerged Mining Speed";
                if(entity.getAttributes().hasAttribute(EntityAttributes.SUBMERGED_MINING_SPEED)) result = entity.getAttributes().getValue(EntityAttributes.SUBMERGED_MINING_SPEED);
                else result = -1;
            }
            if (mode == 30) {
                mode_type = "Sweeping Damage Ratio";
                if(entity.getAttributes().hasAttribute(EntityAttributes.SWEEPING_DAMAGE_RATIO)) result = entity.getAttributes().getValue(EntityAttributes.SWEEPING_DAMAGE_RATIO);
                else result = -1;
            }
            if (mode == 31) {
                mode_type = "Temp Range";
                if(entity.getAttributes().hasAttribute(EntityAttributes.TEMPT_RANGE)) result = entity.getAttributes().getValue(EntityAttributes.TEMPT_RANGE);
                else result = -1;
            }
            if (mode == 32) {
                mode_type = "Water Movement Efficiency";
                if(entity.getAttributes().hasAttribute(EntityAttributes.WATER_MOVEMENT_EFFICIENCY)) result = entity.getAttributes().getValue(EntityAttributes.WATER_MOVEMENT_EFFICIENCY);
                else result = -1;
            }
            if (mode == 33) {
                mode_type = "Health";
                result = entity.getHealth();
            }
            if (mode == 34) {
                mode_type = "Armor Visibility";
                result = entity.getArmorVisibility();
            }
            if (mode == 35) {
                mode_type = "Absorption Amount";
                result = entity.getAbsorptionAmount();
            }
            if (mode == 36) {
                mode_type = "Age";
                result = entity.age;
            }
        }else {
            if (mode == 1) {
                mode_type = "Armor";
            }
            if (mode == 2) {
                mode_type = "Armor Toughness";
            }
            if (mode == 3) {
                mode_type = "Attack Damage";
            }
            if (mode == 4) {
                mode_type = "Attack Knock-back";
            }
            if (mode == 5) {
                mode_type = "Attack Speed";
            }
            if (mode == 6) {
                mode_type = "Flying Speed";
            }
            if (mode == 7) {
                mode_type = "Follow Range";
            }
            if (mode == 8) {
                mode_type = "Knock-back Resistance";
            }
            if (mode == 9) {
                mode_type = "Luck";
            }
            if (mode == 10) {
                mode_type = "Max Absorption";
            }
            if (mode == 11) {
                mode_type = "Max Health";
            }
            if (mode == 12) {
                mode_type = "Movement Speed";
            }
            if (mode == 13) {
                mode_type = "Scale";
            }
            if (mode == 14) {
                mode_type = "Step Height";
            }
            if (mode == 15) {
                mode_type = "Jump Strength";
            }
            if (mode == 16) {
                mode_type = "Block Interaction Range";
            }
            if (mode == 17) {
                mode_type = "Entity Interaction Range";
            }
            if (mode == 18) {
                mode_type = "Spawn Reinforcements";
            }
            if (mode == 19) {
                mode_type = "Block Breaking Speed";
            }
            if (mode == 20) {
                mode_type = "Gravity";
            }
            if (mode == 21) {
                mode_type = "Safe Fall Distance";
            }
            if (mode == 22) {
                mode_type = "Fall Damage Multiplier";
            }
            if (mode == 23) {
                mode_type = "Burning Time";
            }
            if (mode == 24) {
                mode_type = "Explosion Knock-back Resistance";
            }
            if (mode == 25) {
                mode_type = "Mining Efficiency";
            }
            if (mode == 26) {
                mode_type = "Movement Efficiency";
            }
            if (mode == 27) {
                mode_type = "Oxygen Bonus";
            }
            if (mode == 28) {
                mode_type = "Sneaking Speed";
            }
            if (mode == 29) {
                mode_type = "Submerged Mining Speed";
            }
            if (mode == 30) {
                mode_type = "Sweeping Damage Ratio";
            }
            if (mode == 31) {
                mode_type = "Temp Range";
            }
            if (mode == 32) {
                mode_type = "Water Movement Efficiency";
            }
            if (mode == 33) {
                mode_type = "Health";
            }
            if (mode == 34) {
                mode_type = "Armor Visibility";
            }
            if (mode == 35) {
                mode_type = "Absorption Amount";
            }
            if (mode == 36) {
                mode_type = "Age";
            }
        }
    }
}
