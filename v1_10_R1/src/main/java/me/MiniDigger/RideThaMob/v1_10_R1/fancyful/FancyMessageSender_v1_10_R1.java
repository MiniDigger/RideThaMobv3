package me.MiniDigger.RideThaMob.v1_10_R1.fancyful;

import net.minecraft.server.v1_10_R1.IChatBaseComponent;
import net.minecraft.server.v1_10_R1.PacketPlayOutChat;

import org.bukkit.craftbukkit.v1_10_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import me.MiniDigger.RideThaMob.api.FancyMessageSender;

public class FancyMessageSender_v1_10_R1 implements FancyMessageSender {

    @Override
    public void send(final Player sender, final String jsonString) {
        ((CraftPlayer) sender).getHandle().playerConnection.sendPacket(new PacketPlayOutChat(IChatBaseComponent.ChatSerializer.a(jsonString)));
    }
}
