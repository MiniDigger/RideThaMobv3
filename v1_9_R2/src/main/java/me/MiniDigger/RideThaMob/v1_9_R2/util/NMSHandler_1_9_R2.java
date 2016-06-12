package me.MiniDigger.RideThaMob.v1_9_R2.util;

import me.MiniDigger.RideThaMob.api.NMSHandler;
import me.MiniDigger.RideThaMob.v1_9_R2.RideAbleEntityType;
import me.MiniDigger.RideThaMob.api.RideThaMob;
import org.bukkit.entity.EntityType;

public class NMSHandler_1_9_R2 implements NMSHandler {

    private static NMSHandler_1_9_R2 INSTANCE;

    private RideThaMob plugin;

    public NMSHandler_1_9_R2( RideThaMob plugin ) {
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

    public static NMSHandler_1_9_R2 getInstance() {
        return INSTANCE;
    }
}
