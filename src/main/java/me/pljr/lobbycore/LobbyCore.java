package me.pljr.lobbycore;

import me.pljr.lobbycore.commands.HidePlayersCommand;
import me.pljr.lobbycore.config.*;
import me.pljr.lobbycore.listeners.DisabledListener;
import me.pljr.lobbycore.listeners.DoubleJumpListener;
import me.pljr.lobbycore.listeners.PlayerInteractEntityListener;
import me.pljr.lobbycore.listeners.PlayerJoinListener;
import me.pljr.pljrapi.managers.ConfigManager;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class LobbyCore extends JavaPlugin {

    private static LobbyCore instance;
    private ConfigManager configManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        setupConfig();
        setupListeners();
        setupCommands();
    }

    public void setupConfig(){
        saveDefaultConfig();
        reloadConfig();
        this.configManager = new ConfigManager(getConfig(), "§cLobbyCore:", "config.yml");
        CfgItems.load(configManager);
        CfgDisabledEvents.load(configManager);
        CfgLang.load(configManager);
        CfgLocations.load(configManager);
        CfgSounds.load(configManager);
        CfgNpcs.load(configManager);
    }

    public void setupListeners(){
        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new DisabledListener(), this);
        pluginManager.registerEvents(new DoubleJumpListener(), this);
        pluginManager.registerEvents(new PlayerJoinListener(), this);
        pluginManager.registerEvents(new PlayerInteractEntityListener(), this);
    }

    public void setupCommands(){
        getCommand("hideplayers").setExecutor(new HidePlayersCommand());
    }

    public static LobbyCore getInstance() {
        return instance;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
