package me.kucciii.hypixelchatmodifier.utilities;

import lombok.experimental.UtilityClass;
import org.bukkit.ChatColor;

@UtilityClass
public class ChatUtility {

    public String format(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

}
