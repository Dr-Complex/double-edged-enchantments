package net.dr_complex.double_edged_enchantments.entity.client;

import net.dr_complex.double_edged_enchantments.other.SpearType;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.state.EntityRenderState;

@Environment(EnvType.CLIENT)
public class SpearEntityRenderState extends EntityRenderState {
    public float yaw;
    public float pitch;
    public boolean Enchanted;
    public SpearType Type = SpearType.Wooden;
}
