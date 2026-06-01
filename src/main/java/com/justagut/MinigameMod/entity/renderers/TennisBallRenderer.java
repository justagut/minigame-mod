package com.justagut.MinigameMod.entity.renderers;

import com.justagut.MinigameMod.entity.client.TennisBallModel;
import com.justagut.MinigameMod.entity.custom.TennisBall;
import com.justagut.MinigameMod.minigamemod;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class TennisBallRenderer extends EntityRenderer<TennisBall> {
    private final TennisBallModel<TennisBall> model;

    public TennisBallRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new TennisBallModel<>(context.bakeLayer(TennisBallModel.LAYER_LOCATION));
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(TennisBall entity) {
        return ResourceLocation.fromNamespaceAndPath(minigamemod.MODID, "textures/entity/tennisball.png");
    }

    @Override
    public void render(TennisBall entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        poseStack.pushPose();

        VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(this.getTextureLocation(entity)));

        this.model.renderToBuffer(poseStack, vertexConsumer, packedLight,
                OverlayTexture.NO_OVERLAY, 0xFFFFFF);

        poseStack.popPose();
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
