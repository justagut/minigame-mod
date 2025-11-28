package com.justagut.MinigameMod.event;


import com.justagut.MinigameMod.block.ModBlocks;
import com.justagut.MinigameMod.entity.ModEntities;
import com.justagut.MinigameMod.entity.client.TennisBallModel;
import com.justagut.MinigameMod.entity.custom.TennisBall;
import com.justagut.MinigameMod.item.ModItems;
import com.justagut.MinigameMod.minigamemod;
import net.minecraft.network.chat.Component;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;

@EventBusSubscriber(modid = minigamemod.MODID)
public class TennisEvents {
    @SubscribeEvent
    public static void onAttackEntity(AttackEntityEvent event){
        if (event.getTarget() instanceof TennisBall tennisBall &&
                event.getEntity().getMainHandItem().getItem() == ModItems.TENNIS_RACKET.get()){
            tennisBall.gettinghit = 2;
            tennisBall.oldpos = tennisBall.position();
            tennisBall.player = event.getEntity();
            TennisBall.tickcount = 0;
            event.setCanceled(true);
        }
    }
}