package me.MiniDigger.RideThaMob.v1_10_R1.util;

import net.minecraft.server.v1_10_R1.Entity;
import net.minecraft.server.v1_10_R1.World;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_10_R1.CraftWorld;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.lang.reflect.InvocationTargetException;

import me.MiniDigger.RideThaMob.api.NMSHandler;
import me.MiniDigger.RideThaMob.api.RideThaMob;
import me.MiniDigger.RideThaMob.v1_10_R1.RideAbleEntityType;

public class NMSHandler_1_10_R1 implements NMSHandler {

    private static NMSHandler_1_10_R1 INSTANCE;

    private RideThaMob plugin;

    public NMSHandler_1_10_R1(RideThaMob plugin) {
        this.plugin = plugin;
        INSTANCE = this;
    }

    @Override
    public boolean spawn(EntityType type, Location location) {
        World nmsWorld = ((CraftWorld) location.getWorld()).getHandle();
        RideAbleEntityType rideAbleEntityType = RideAbleEntityType.valueOf(type);
        if (rideAbleEntityType == null) {
            return false;
        }
        Entity entity;
        try {
            entity = (Entity) rideAbleEntityType.getCustomClass().getConstructors()[0].newInstance(nmsWorld);
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            return false;
        }

        entity.setLocation(location.getX(), location.getY(), location.getZ(), location.getPitch(), location.getYaw());
        return nmsWorld.addEntity(entity, CreatureSpawnEvent.SpawnReason.CUSTOM);
    }

    @Override
    public void registerEntites() {
        RideAbleEntityType.registerEntities();
    }

    @Override
    public EntityType[] getRegisteredEntityTypes() {
        return RideAbleEntityType.getRegisteredEntityTypes();
    }

    @Override
    public RideThaMob getPlugin() {
        return plugin;
    }

    public static NMSHandler_1_10_R1 getInstance() {
        return INSTANCE;
    }
}
