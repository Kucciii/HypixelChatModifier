package me.kucciii.hypixelchatmodifier;

import me.kucciii.hypixelchatmodifier.listeners.ChatListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class HypixelChatModifier extends JavaPlugin {

    private final FileConfiguration config = getConfig();
    private final String consolePrefix = "[HypixelChatModifier] ";

    @Override
    public void onEnable() {
        getLogger().info(consolePrefix + "Registering Listeners...");
        registerListeners();
        getLogger().info(consolePrefix + "Registered listeners!");
        getLogger().info(consolePrefix + "Loading configuration...");
        loadDefaultConfig();
        getLogger().info(consolePrefix + "Loaded configuration.");
    }

    @Override
    public void onDisable() {
        getLogger().info(consolePrefix  + "Saving configuration.");
    }

    public void loadDefaultConfig() {
        saveDefaultConfig();
    }

    public void registerListeners() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new ChatListener(this), this);
    }
}
