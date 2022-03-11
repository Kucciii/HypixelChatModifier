package me.kucciii.hypixelchatmodifier;

import me.kucciii.hypixelchatmodifier.commands.HCMCmd;
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
        Bukkit.getLogger().info(consolePrefix + "Registering Listeners...");
        registerListeners();
        Bukkit.getLogger().info(consolePrefix + "Registered listeners!");
        Bukkit.getLogger().info(consolePrefix + "Registering commands...");
        registerCommands();
        Bukkit.getLogger().info(consolePrefix + "Registered Commands!");
        Bukkit.getLogger().info(consolePrefix + "Loading configuration...");
        loadDefaultConfig();
        Bukkit.getLogger().info(consolePrefix + "Loaded configuration.");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info(consolePrefix  + "Saving configuration.");
    }

    public void loadDefaultConfig() {
        if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
        }
        config.options().copyDefaults();
        saveDefaultConfig();
    }

    public void registerListeners() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new ChatListener(this), this);
    }

    public void registerCommands() {
        getCommand("hcm").setExecutor(new HCMCmd(this));
    }

}