package me.MiniDigger.RideThaMob.v1_8_R3.fancyful;

import me.MiniDigger.RideThaMob.api.FancyMessageSender;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class FancyMessageSender_v1_8_R3 implements FancyMessageSender {

    @Override
    public void send( final Player sender, final String jsonString ) {
        ( (CraftPlayer) sender ).getHandle().playerConnection.sendPacket( new PacketPlayOutChat( IChatBaseComponent.ChatSerializer.a( jsonString ) ) );
    }
}
