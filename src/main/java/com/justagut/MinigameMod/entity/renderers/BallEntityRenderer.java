package com.justagut.MinigameMod.entity.renderers;

import com.justagut.MinigameMod.entity.custom.BallPhisicsEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class BallEntityRenderer extends EntityRenderer<BallPhisicsEntity> {

    protected BallEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(BallPhisicsEntity entity) {
        return null;
    }
}