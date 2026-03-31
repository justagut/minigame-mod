package com.justagut.MinigameMod.entity.renderers;

import com.justagut.MinigameMod.minigamemod;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class PlaceholderEntityRenderer<T extends Entity> extends EntityRenderer<T> {
    public PlaceholderEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius = 0f;
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return ResourceLocation.fromNamespaceAndPath(minigamemod.MODID, "textures/entity/placeholder.png");
    }

    @Override
    public void render(T entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        // Intentionally no model rendering: this prevents missing renderer NPEs.
        // Keep a minimal call to super to preserve lighting/outline handling.
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
