package de.roboticbrain.randommod.event;

import java.util.logging.Level;

import net.minecraft.entity.monster.EntityCreeper;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingSpawnEvent.CheckSpawn;
import de.roboticbrain.randommod.core.helper.LogHelper;

public class CreeperLivingSpawnEvent {
    @ForgeSubscribe
    public void onCreeperSpawn(CheckSpawn event) {
        if (event.entityLiving instanceof EntityCreeper) {
            event.setResult(Result.DENY);
        }
        //LogHelper.log(Level.INFO, "Someone spawned");
    }
}
