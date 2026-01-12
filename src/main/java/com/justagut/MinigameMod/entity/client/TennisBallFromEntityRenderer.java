package com.justagut.MinigameMod.entity.client;

import com.justagut.MinigameMod.entity.custom.TennisBallFromEntity;
import com.justagut.MinigameMod.minigamemod;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.joml.Matrix4f;

public class TennisBallFromEntityRenderer extends EntityRenderer<TennisBallFromEntity> {

    private static final ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(minigamemod.MODID, "textures/entity/simple_entity.png");

    public TennisBallFromEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(
            TennisBallFromEntity entity,
            float entityYaw,
            float partialTicks,
            PoseStack poseStack,
            MultiBufferSource buffer,
            int packedLight
    ) {
        poseStack.pushPose();

        poseStack.translate(0.0D, 0.25D, 0.0D);
        poseStack.mulPose(this.entityRenderDispatcher.cameraOrientation());
        poseStack.scale(0.5F, 0.5F, 0.5F);

        VertexConsumer vertexConsumer =
                buffer.getBuffer(RenderType.entityCutoutNoCull(TEXTURE));

        PoseStack.Pose pose = poseStack.last();

        int blockLight = packedLight & 0xFFFF;
        int skyLight   = (packedLight >> 16) & 0xFFFF;

        vertexConsumer.addVertex(pose, -0.5F, -0.5F, 0.0F)
                .setColor(255, 255, 255, 255)
                .setUv(0.0F, 1.0F)
                .setUv2(blockLight, skyLight);

        vertexConsumer.addVertex(pose, 0.5F, -0.5F, 0.0F)
                .setColor(255, 255, 255, 255)
                .setUv(1.0F, 1.0F)
                .setUv2(blockLight, skyLight);

        vertexConsumer.addVertex(pose, 0.5F, 0.5F, 0.0F)
                .setColor(255, 255, 255, 255)
                .setUv(1.0F, 0.0F)
                .setUv2(blockLight, skyLight);

        vertexConsumer.addVertex(pose, -0.5F, 0.5F, 0.0F)
                .setColor(255, 255, 255, 255)
                .setUv(0.0F, 0.0F)
                .setUv2(blockLight, skyLight);

        poseStack.popPose();

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(TennisBallFromEntity entity) {
        return TEXTURE;
    }
}
