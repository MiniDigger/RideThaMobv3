package me.MiniDigger.RideThaMob;

import me.MiniDigger.RideThaMob.api.ConfigHandler;
import me.MiniDigger.RideThaMob.api.RideThaMob;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ConfigHandlerImpl implements ConfigHandler {

    private File file;
    private YamlConfiguration config;

    private final Map<EntityType, Double> rideSpeeds = new HashMap<>();
    private final Map<EntityType, Double> jumpHeights = new HashMap<>();
    private final Map<EntityType, Double> sideMods = new HashMap<>();
    private final Map<EntityType, Double> backMods = new HashMap<>();
    private final Map<EntityType, Double> stepHeights = new HashMap<>();

    //TODO save rtmRange to config
    private final int rtmRange = 10;

    private RideThaMob plugin;

    public ConfigHandlerImpl( File file, RideThaMob plugin ) {
        this.file = file;
        config = YamlConfiguration.loadConfiguration( file );
        this.plugin = plugin;
    }

    @Override
    public void loadStuff() {
        double defaultRideSpeed = 0.2;
        double defaultJumpHeight = 0.6;
        double defaultSideMod = 0.5;
        double defaultBackMod = 0.25;
        double defaultStepHeight = 1.0;

        final EntityType t = EntityType.UNKNOWN;
        rideSpeeds.put( t, defaultRideSpeed );
        jumpHeights.put( t, defaultJumpHeight );
        sideMods.put( t, defaultSideMod );
        backMods.put( t, defaultBackMod );
        stepHeights.put( t, defaultStepHeight );

        for ( final EntityType type : plugin.getNMSHanlder().getRegisteredEntityTypes() ) {
            rideSpeeds.put( type, config.getDouble( "entities." + type.name().toLowerCase() + ".rideSpeed", defaultRideSpeed ) );
            jumpHeights.put( type, config.getDouble( "entities." + type.name().toLowerCase() + ".jumpHeight", defaultJumpHeight ) );
            sideMods.put( type, config.getDouble( "entities." + type.name().toLowerCase() + ".sideMod", defaultSideMod ) );
            backMods.put( type, config.getDouble( "entities." + type.name().toLowerCase() + ".backMod", defaultBackMod ) );
            stepHeights.put( type, config.getDouble( "entities." + type.name().toLowerCase() + ".stepHeight", defaultStepHeight ) );
        }
    }

    @Override
    public void defaultValues() {
        final EntityType t = EntityType.UNKNOWN;
        rideSpeeds.put( t, 0.2 );
        jumpHeights.put( t, 0.6 );
        sideMods.put( t, 0.5 );
        backMods.put( t, 0.25 );
        stepHeights.put( t, 1.0 );

        for ( final EntityType type : plugin.getNMSHanlder().getRegisteredEntityTypes() ) {
            rideSpeeds.put( type, 0.2 );
            jumpHeights.put( type, 0.6 );
            sideMods.put( type, 0.5 );
            backMods.put( type, 0.25 );
            stepHeights.put( type, 1.0 );
        }
    }

    @Override
    public void save() {
        for ( final EntityType type : rideSpeeds.keySet() ) {
            config.set( "entities." + type.name().toLowerCase() + ".rideSpeed", rideSpeeds.get( type ) );
            config.set( "entities." + type.name().toLowerCase() + ".jumpHeight", jumpHeights.get( type ) );
            config.set( "entities." + type.name().toLowerCase() + ".sideMod", sideMods.get( type ) );
            config.set( "entities." + type.name().toLowerCase() + ".backMod", backMods.get( type ) );
            config.set( "entities." + type.name().toLowerCase() + ".stepHeight", stepHeights.get( type ) );
        }

        try {
            config.save( file );
        } catch ( IOException e ) {
            plugin.getLogger().severe( "Could not save config to " + file.getAbsolutePath() + ": " + e.getClass().getSimpleName() + ": " + e.getMessage() );
        }
    }

    @Override
    public YamlConfiguration getConfig() {
        return config;
    }

    /*
     * Getters
     */

    @Override
    public double getRideSpeed( final EntityType e ) {
        if ( rideSpeeds.containsKey( e ) ) {
            return rideSpeeds.get( e );
        } else {
            return rideSpeeds.get( EntityType.UNKNOWN );
        }
    }

    @Override
    public double getJumpHeight( final EntityType e ) {
        if ( jumpHeights.containsKey( e ) ) {
            return jumpHeights.get( e );
        } else {
            return jumpHeights.get( EntityType.UNKNOWN );
        }
    }

    //TODO implement flying
    @Override
    public boolean getFly( final EntityType e ) {
        return false;
    }

    @Override
    public double getSidewaysMod( final EntityType e ) {
        if ( sideMods.containsKey( e ) ) {
            return sideMods.get( e );
        } else {
            return sideMods.get( EntityType.UNKNOWN );
        }
    }

    @Override
    public double getBackwardsMod( final EntityType e ) {
        if ( backMods.containsKey( e ) ) {
            return backMods.get( e );
        } else {
            return backMods.get( EntityType.UNKNOWN );
        }
    }

    @Override
    public double getStepHeight( final EntityType e ) {
        if ( stepHeights.containsKey( e ) ) {
            return stepHeights.get( e );
        } else {
            return stepHeights.get( EntityType.UNKNOWN );
        }
    }

    @Override
    public int getRtmRange() {
        return rtmRange;
    }

    @Override
    public boolean isRideAble( final EntityType e ) {
        return rideSpeeds.containsKey( e );
    }
}
