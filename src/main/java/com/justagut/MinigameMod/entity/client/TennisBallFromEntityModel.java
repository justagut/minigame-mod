package com.justagut.MinigameMod.entity.client;

import com.justagut.MinigameMod.entity.custom.TennisBallFromEntity;
import com.justagut.MinigameMod.minigamemod;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class TennisBallFromEntityModel extends EntityModel<TennisBallFromEntity> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(minigamemod.MODID, "tennisbal"), "main");
    private final ModelPart bone;

    public TennisBallFromEntityModel(ModelPart root) {
        this.bone = root.getChild("bone");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -8.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 6).addBox(0.5F, -7.5F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(8, 6).addBox(-1.5F, -7.5F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 10).addBox(-0.5F, -7.5F, -0.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 14).addBox(-0.5F, -7.5F, -2.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(8, 10).addBox(-0.5F, -8.5F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(12, 0).addBox(-0.5F, -6.5F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 28.5F, 0.5F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        bone.render(poseStack, vertexConsumer, packedLight, packedOverlay,color);
    }


    @Override
    public void setupAnim(TennisBallFromEntity entity,
                          float limbSwing,
                          float limbSwingAmount,
                          float ageInTicks,
                          float netHeadYaw,
                          float headPitch) {

    }
}

