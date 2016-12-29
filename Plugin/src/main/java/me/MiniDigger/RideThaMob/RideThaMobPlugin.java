package me.MiniDigger.RideThaMob;

import me.MiniDigger.RideThaMob.api.FancyMessageSender;
import me.MiniDigger.RideThaMob.api.NMSHandler;
import me.MiniDigger.RideThaMob.api.RideThaMob;
import me.MiniDigger.RideThaMob.fanciful.FancyMessage;
import me.MiniDigger.RideThaMob.v1_10_R1.fancyful.FancyMessageSender_v1_10_R1;
import me.MiniDigger.RideThaMob.v1_10_R1.util.NMSHandler_1_10_R1;
import me.MiniDigger.RideThaMob.v1_8_R3.fancyful.FancyMessageSender_v1_8_R3;
import me.MiniDigger.RideThaMob.v1_8_R3.util.NMSHandler_1_8_R3;
import me.MiniDigger.RideThaMob.v1_9_R1.fancyful.FancyMessageSender_v1_9_R1;
import me.MiniDigger.RideThaMob.v1_9_R1.util.NMSHandler_1_9_R1;
import me.MiniDigger.RideThaMob.v1_9_R2.fancyful.FancyMessageSender_v1_9_R2;
import me.MiniDigger.RideThaMob.v1_9_R2.util.NMSHandler_1_9_R2;
import org.apache.commons.lang.ArrayUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.util.regex.Pattern;

public class RideThaMobPlugin extends JavaPlugin implements Listener, RideThaMob {

    public static final String[] supportedVersions = { "v1_8_R3", "v1_9_R1", "v1_9_R2", "v1_10_R1" };

    private static RideThaMobPlugin INSTANCE;

    private String nmsVersion;
    private NMSHandler nmsHandler;
    private FancyMessageSender fancyMessageSender;
    private ConfigHandlerImpl config;
    private int updateVal = 1;

    @Override
    public void onLoad() {
        INSTANCE = this;
        nmsVersion = getNMSVersion();
    }

    @Override
    public void onEnable() {
        if ( !enableNMSHandler() ) {
            getLogger().severe( "Disabling Plugin!" );
            getPluginLoader().disablePlugin( this );
            return;
        }

        nmsHandler.registerEntites();

        reloadConfig();

        fixEntities();

        RideThaMobCommands cmd = new RideThaMobCommands();
        getCommand( "rtm" ).setExecutor( cmd );

        new FancyMessage( "Test" ).color( ChatColor.RED ).then( "This is a test" ).color( ChatColor.GREEN ).send( Bukkit.getConsoleSender() );
    }

    @Override
    public void onDisable() {
        INSTANCE = null;
    }

    @Override
    public void fixEntities() {
        // TODO replace ALL entities in the world with rideable ones, only if the user enables it
    }

    @Override
    public void reloadConfig() {
        config = new ConfigHandlerImpl( new File( getDataFolder(), "config.yml" ), this );
        config.defaultValues();
        config.loadStuff();
        config.save();
    }

    @Override
    public ConfigHandlerImpl getConfigHandler() {
        return config;
    }

    @Override
    public void setShouldUpdate() {
        updateVal++;
    }

    @Override
    public int getUpdateVal() {
        return updateVal;
    }

    @Override
    public boolean enableNMSHandler() {
        getLogger().info( "Found server version " + nmsVersion );

        if ( ArrayUtils.contains( supportedVersions, nmsVersion ) ) {
            switch ( nmsVersion ) {
                case "v1_8_R3":
                    fancyMessageSender = new FancyMessageSender_v1_8_R3();
                    nmsHandler = new NMSHandler_1_8_R3( this );
                    break;
                case "v1_9_R1":
                    fancyMessageSender = new FancyMessageSender_v1_9_R1();
                    nmsHandler = new NMSHandler_1_9_R1( this );
                    break;
                case "v1_9_R2":
                    fancyMessageSender = new FancyMessageSender_v1_9_R2();
                    nmsHandler = new NMSHandler_1_9_R2( this );
                    break;
                case "v1_10_R1":
                    fancyMessageSender = new FancyMessageSender_v1_10_R1();
                    nmsHandler = new NMSHandler_1_10_R1( this );
                    break;
                default:
                    getLogger().severe( "Your server version (" + nmsVersion + ") is not supported!" );
                    return false;
            }
        } else {
            getLogger().severe( "Your server version (" + nmsVersion + ") is not supported!" );
            return false;
        }

        getLogger().info( "Enabled nms handler!" );

        return true;
    }

    @Override
    public String getNMSVersion() {
        String version;
        try {
            version = Bukkit.getServer().getClass().getPackage().getName().split( Pattern.quote( "." ) )[3];
        } catch ( Exception ex ) {
            return "UNKNOWN";
        }
        return version;
    }

    @Override
    public NMSHandler getNMSHanlder() {
        return nmsHandler;
    }

    @Override
    public FancyMessageSender getFancyMessageSender() {
        return fancyMessageSender;
    }

    public static RideThaMobPlugin getInstance() {
        return INSTANCE;
    }
}
