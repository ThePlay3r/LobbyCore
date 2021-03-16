package me.pljr.lobbycore;

import me.pljr.lobbycore.commands.HidePlayersCommand;
import me.pljr.lobbycore.config.*;
import me.pljr.lobbycore.listeners.DisabledListener;
import me.pljr.lobbycore.listeners.DoubleJumpListener;
import me.pljr.lobbycore.listeners.PlayerInteractEntityListener;
import me.pljr.lobbycore.listeners.PlayerJoinListener;
import me.pljr.pljrapispigot.PLJRApiSpigot;
import me.pljr.pljrapispigot.managers.ConfigManager;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class LobbyCore extends JavaPlugin {

    private static LobbyCore instance;

    private NpcSettings npcSettings;
    private Items items;

    public static LobbyCore get(){
        return instance;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        if (!setupPLJRApi()) return;
        setupConfig();
        setupListeners();
        setupCommands();
    }

    public boolean setupPLJRApi(){
        if (PLJRApiSpigot.get() == null){
            getLogger().warning("PLJRApi-Spigot is not enabled!");
            return false;
        }
        //pljrApiSpigot = PLJRApiSpigot.get();
        return true;
    }

    public void setupConfig(){
        saveDefaultConfig();
        reloadConfig();
        ConfigManager config = new ConfigManager(this, "config.yml");
        npcSettings = new NpcSettings(config);
        items = new Items(config);
        CfgLocation.load(new ConfigManager(this, "locations.yml"));
        CfgSound.load(new ConfigManager(this, "sounds.yml"));
        DisabledEvent.load(new ConfigManager(this, "disabled-events.yml"));
        Lang.load(new ConfigManager(this, "lang.yml"));
    }

    public void setupListeners(){
        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new DisabledListener(), this);
        pluginManager.registerEvents(new DoubleJumpListener(this), this);
        pluginManager.registerEvents(new PlayerJoinListener(items), this);
        pluginManager.registerEvents(new PlayerInteractEntityListener(npcSettings), this);
    }

    public void setupCommands(){
        new HidePlayersCommand(this).registerCommand(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
