package me.MiniDigger.RideThaMob.api;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;

public interface NMSHandler {

    boolean spawn( EntityType type, Location location );

    void registerEntites();

    EntityType[] getRegisteredEntityTypes();

    RideThaMob getPlugin();
}
