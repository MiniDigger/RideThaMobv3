package me.MiniDigger.RideThaMob.api;

import org.bukkit.entity.EntityType;

public interface NMSHandler {

    boolean spawn( EntityType type );

    void registerEntites();

    EntityType[] getRegisteredEntityTypes();

    RideThaMob getPlugin();
}
