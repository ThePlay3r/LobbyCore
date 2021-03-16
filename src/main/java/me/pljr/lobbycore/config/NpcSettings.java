package me.pljr.lobbycore.config;

import lombok.Getter;
import me.pljr.pljrapispigot.managers.ConfigManager;
import org.bukkit.configuration.ConfigurationSection;

import java.util.HashMap;

@Getter
public class NpcSettings {
    private final HashMap<String, String> npcs;

    public NpcSettings(ConfigManager config){
        npcs = new HashMap<>();
        ConfigurationSection csNpcs = config.getConfigurationSection("npcs");
        if (csNpcs != null){
            for (String npc : csNpcs.getKeys(false)){
                npcs.put(npc, config.getString("npcs."+npc));
            }
        }
    }
}
