package com.justagut.MinigameMod.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;

public class lasergun extends Item {

    public lasergun(Properties properties) {
        super(properties);
    }

    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        //shoot laserthingy, we have not yet made this

        player.sendSystemMessage(Component.literal("Pieuw Pieuw!"));

        return InteractionResult.SUCCESS;
    }
}
