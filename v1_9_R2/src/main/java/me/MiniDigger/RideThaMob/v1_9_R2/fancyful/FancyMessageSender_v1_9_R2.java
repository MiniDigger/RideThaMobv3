package me.MiniDigger.RideThaMob.v1_9_R2.fancyful;

import me.MiniDigger.RideThaMob.api.FancyMessageSender;
import net.minecraft.server.v1_9_R2.IChatBaseComponent;
import net.minecraft.server.v1_9_R2.PacketPlayOutChat;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class FancyMessageSender_v1_9_R2 implements FancyMessageSender {

    @Override
    public void send( final Player sender, final String jsonString ) {
        ( (CraftPlayer) sender ).getHandle().playerConnection.sendPacket( new PacketPlayOutChat( IChatBaseComponent.ChatSerializer.a( jsonString ) ) );
    }
}
