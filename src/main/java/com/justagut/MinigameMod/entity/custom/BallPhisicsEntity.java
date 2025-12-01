package com.justagut.MinigameMod.entity.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.ServerChatEvent;

public class BallPhisicsEntity extends Entity {
    public BallPhisicsEntity(EntityType<?> entityType, Level level) {super(entityType, level);}
    public float airdrag = 0.98f;
    public float weight = -0.04f;
    public float bouncyness = 0.7f;
    public float grounddrag = 0.9f;

    @Override
    public void tick() {
        if (!this.onGround()) {
            setDeltaMovement(getDeltaMovement().add(0, weight, 0));
        }

        Vec3 old_vel = getDeltaMovement();

        move(MoverType.SELF, getDeltaMovement());

        if (old_vel.x != getDeltaMovement().x && Math.abs(getDeltaMovement().x) > 0.001) {
            setDeltaMovement(-getDeltaMovement().x * bouncyness, getDeltaMovement().y, getDeltaMovement().z);
        }

        if (old_vel.z != getDeltaMovement().z && Math.abs(getDeltaMovement().z) > 0.001) {
            setDeltaMovement(getDeltaMovement().x * bouncyness, getDeltaMovement().y, -getDeltaMovement().z);
        }


        if (this.onGround()) {
            setDeltaMovement(getDeltaMovement().x * grounddrag, -getDeltaMovement().y * bouncyness, getDeltaMovement().z * grounddrag);
        }

        setDeltaMovement(getDeltaMovement().scale(airdrag));

    }

    @EventBusSubscriber(modid = "minigames")
    public class ChatListener {

        @SubscribeEvent
        public void onChat(ServerChatEvent event) {
            String message = event.getRawText();

            if (message.startsWith("!ballvel")) {
                String[] parts = message.split(" ");

                switch (parts[1]) {
                    case "x":
                        BallPhisicsEntity.this.setDeltaMovement(Double.parseDouble(parts[2]), BallPhisicsEntity.this.getDeltaMovement().y, BallPhisicsEntity.this.getDeltaMovement().z);
                    case "y":
                        BallPhisicsEntity.this.setDeltaMovement(BallPhisicsEntity.this.getDeltaMovement().x, Double.parseDouble(parts[2]), BallPhisicsEntity.this.getDeltaMovement().z);
                    case "z":
                        BallPhisicsEntity.this.setDeltaMovement(BallPhisicsEntity.this.getDeltaMovement().x, BallPhisicsEntity.this.getDeltaMovement().y, Double.parseDouble(parts[2]));
                }
            }
        }
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {}

    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {}

    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {}
}
