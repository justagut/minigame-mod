package com.justagut.MinigameMod.entity.client;

import com.justagut.MinigameMod.entity.custom.BallBasics;
import com.justagut.MinigameMod.minigamemod;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MagmaBossRenderer extends MobRenderer<BallBasics,MagmaBossModel<BallBasics>> {
    public MagmaBossRenderer(EntityRendererProvider.Context context) {
        super(context, new MagmaBossModel<>(context.bakeLayer(MagmaBossModel.LAYER_LOCATION)),1f);
    }

    @Override
    public ResourceLocation getTextureLocation(BallBasics ballBasics) {
        return ResourceLocation.fromNamespaceAndPath(minigamemod.MODID,"textures/entity/magma_boss_texture.png");
    }

    @Override
    public void render(BallBasics entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
