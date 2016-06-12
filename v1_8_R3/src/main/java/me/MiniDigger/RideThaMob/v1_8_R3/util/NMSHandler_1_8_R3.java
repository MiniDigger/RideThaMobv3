package me.MiniDigger.RideThaMob.v1_8_R3.util;

import me.MiniDigger.RideThaMob.api.NMSHandler;
import me.MiniDigger.RideThaMob.v1_8_R3.RideAbleEntityType;
import me.MiniDigger.RideThaMob.api.RideThaMob;
import org.bukkit.entity.EntityType;

public class NMSHandler_1_8_R3 implements NMSHandler {

    private static NMSHandler_1_8_R3 INSTANCE;

    private RideThaMob plugin;

    public NMSHandler_1_8_R3( RideThaMob plugin ) {
        this.plugin = plugin;
        INSTANCE = this;
    }

    @Override
    public boolean spawn( EntityType type ) {
        return false;
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

    public static NMSHandler_1_8_R3 getInstance() {
        return INSTANCE;
    }
}
