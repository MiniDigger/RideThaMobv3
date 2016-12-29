package me.MiniDigger.RideThaMob;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

/**
 * Created by Martin on 19.06.2016.
 */
public class Lang {

    public void load() {
        FileConfiguration config = RideThaMobPlugin.getInstance().getConfigHandler().getConfig();
        for (LangKey key : LangKey.values()) {
            key.setValue(config.getString("lang." + key.getName(), key.getDefaultValue()));
        }
    }

    public static void msg(CommandSender sender, LangKey key, String... params) {
        String message = key.getValue();
        if (message == null) {
            message = key.getDefaultValue();
        }

        for (int i = 0; i < params.length; i++) {
            message = message.replace("%" + i + "%", params[i]);
        }

        message = ChatColor.translateAlternateColorCodes('&', message);
        sender.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "RTM" + ChatColor.RED + "] " + ChatColor.RESET + message);
    }

    enum LangKey {

        RIDE("ride", ChatColor.GREEN + "You are now riding %0%"),
        NO_NEAR("no_near", ChatColor.RED + "There is no entity that you are allowed to ride in the range of %0% blocks.");

        private String name;
        private String defaultValue;
        private String value;

        LangKey(String name, String defaultValue) {
            this.name = name;
            this.defaultValue = defaultValue;
        }

        public String getName() {
            return name;
        }

        public String getDefaultValue() {
            return defaultValue;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
