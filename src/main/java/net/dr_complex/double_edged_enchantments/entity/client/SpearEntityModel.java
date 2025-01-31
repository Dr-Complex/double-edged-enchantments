package net.dr_complex.double_edged_enchantments.entity.client;

import net.dr_complex.double_edged_enchantments.DEE_Main;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.EntityModelLayer;

@Environment(EnvType.CLIENT)
public class SpearEntityModel extends AbstractSpearEntityModel<SpearEntityRenderState> {
    public static final EntityModelLayer Main = new EntityModelLayer(DEE_Main.id("spear_entity"),"main");

    public SpearEntityModel(ModelPart root) {
        super(root);
    }
}
