package me.pljr.lobbycore.config;

import me.pljr.pljrapi.managers.ConfigManager;
import org.bukkit.configuration.ConfigurationSection;

import java.util.HashMap;

public class CfgNpcs {
    public static HashMap<String, String> npcs;

    public static void load(ConfigManager config){
        npcs = new HashMap<>();
        ConfigurationSection csNpcs = config.getConfigurationSection("npcs");
        if (csNpcs != null){
            for (String npc : csNpcs.getKeys(false)){
                npcs.put(npc, config.getString("npcs."+npc));
            }
        }
    }
}
