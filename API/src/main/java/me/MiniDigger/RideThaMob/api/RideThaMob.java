package me.MiniDigger.RideThaMob.api;

import org.bukkit.plugin.Plugin;

public interface RideThaMob extends Plugin {

    void fixEntities();

    void reloadConfig();

    ConfigHandler getConfigHandler();

    void setShouldUpdate();

    int getUpdateVal();

    boolean enableNMSHandler();

    String getNMSVersion();

    NMSHandler getNMSHanlder();

    FancyMessageSender getFancyMessageSender();
}
