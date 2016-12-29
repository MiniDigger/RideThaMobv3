package me.MiniDigger.RideThaMob.api;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;

public interface ConfigHandler {
    void loadStuff();

    void defaultValues();

    void save();

    double getRideSpeed( EntityType e );

    double getJumpHeight( EntityType e );

    //TODO implement flying
    boolean getFly( EntityType e );

    double getSidewaysMod( EntityType e );

    double getBackwardsMod( EntityType e );

    double getStepHeight( EntityType e );

    int getRtmRange();

    boolean isRideAble( EntityType e );

    FileConfiguration getConfig();
}
