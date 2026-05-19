package com.justagut.MinigameMod.entity.client;

import com.justagut.MinigameMod.entity.custom.TennisBall;
import com.justagut.MinigameMod.minigamemod;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TennisBallRenderer extends MobRenderer<TennisBall, TennisBallModel<TennisBall>> {
    public TennisBallRenderer(EntityRendererProvider.Context context) {
        super(context, new TennisBallModel<>(context.bakeLayer(TennisBallModel.LAYER_LOCATION)), 0.15f);
    }

    @Override
    public ResourceLocation getTextureLocation(TennisBall tennisBall) {
        return ResourceLocation.fromNamespaceAndPath(minigamemod.MODID,"textures/entity/tennisbal_texture.png");
    }

    @Override
    public void render(TennisBall entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
