package me.kucciii.hypixelchatmodifier;

import me.kucciii.hypixelchatmodifier.listeners.ChatListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class HypixelChatModifier extends JavaPlugin {
    
    @Override
    public void onEnable() {
        getLogger().info("Registering Listeners...");
        registerListeners();
        getLogger().info("Registered listeners!");
        getLogger().info("Loading configuration...");
        loadDefaultConfig();
        getLogger().info("Loaded configuration.");
    }

    @Override
    public void onDisable() {
        getLogger().info("Saving configuration.");
    }

    public void loadDefaultConfig() {
        saveDefaultConfig();
    }

    public void registerListeners() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new ChatListener(this), this);
    }
}
