package me.MiniDigger.RideThaMob;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class RideThaMobCommands implements CommandExecutor {
    @Override
    public boolean onCommand( CommandSender sender, Command command, String label, String[] args ) {
        switch ( command.getName() ) {
            case "rtm":
                if ( args.length == 0 ) {
                    if ( !( sender instanceof Player ) ) {
                        //TODO msg
                        return true;
                    }
                    rtm( (Player) sender );
                    return true;
                }
                switch ( args[0] ) {
                    case "reload":
                        reload( sender );
                        return true;
                }

        }

        return false;
    }

    public void rtm( final Player sender ) {
        for ( int i = 0; i < RideThaMobPlugin.getInstance().getConfigHandler().getRtmRange(); i++ ) {
            for ( final Entity e : sender.getWorld().getNearbyEntities( sender.getLocation(), i, i, i ) ) {
                if ( e.equals( sender ) ) {
                    continue;
                }

                if ( e.getType() == EntityType.PLAYER ) {
                    // TODO skip for now till a proper permission system is added
                    continue;
                }

                if ( RideThaMobPlugin.getInstance().getConfigHandler().isRideAble( e.getType() ) ) {
                    e.setPassenger( sender );
                    //Lang.msg(sender, RTMLangKey.RIDE, e.getType().name());
                    return;
                }
            }
        }
        // Lang.msg(sender, RTMLangKey.NO_NEAR);
    }

    public void reload( final CommandSender sender ) {
        RideThaMobPlugin.getInstance().reloadConfig();
        RideThaMobPlugin.getInstance().setShouldUpdate();
        //   Lang.msg(sender, RTMLangKey.CONFIG_RELOADED);
    }
}
