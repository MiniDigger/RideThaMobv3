package me.MiniDigger.RideThaMob.api;

import org.bukkit.entity.Player;

/**
 * Created by Martin on 11.06.2016.
 */
public interface FancyMessageSender {
    void send( Player sender, String jsonString );
}
