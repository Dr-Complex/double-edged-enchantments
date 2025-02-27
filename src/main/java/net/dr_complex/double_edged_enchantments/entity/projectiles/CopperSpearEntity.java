package net.dr_complex.double_edged_enchantments.entity.projectiles;

import net.dr_complex.double_edged_enchantments.entity.DEE_Entities;
import net.dr_complex.double_edged_enchantments.item.DEE_Items;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class CopperSpearEntity extends AbstractSpearEntity{

    public CopperSpearEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world, 6.125f, 6);
    }

    public CopperSpearEntity(double x, double y, double z, World world, ItemStack stack, @Nullable ItemStack weapon) {
        super(DEE_Entities.COPPER_SPEAR_ENTITY_TYPE, x, y, z, world, stack, weapon,6.125f, 6);
    }

    public CopperSpearEntity(World world, LivingEntity player, ItemStack itemStack) {
        super(DEE_Entities.COPPER_SPEAR_ENTITY_TYPE, world, player, itemStack,6.125f, 6);
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return new ItemStack(DEE_Items.COPPER_SPEAR);
    }

}
