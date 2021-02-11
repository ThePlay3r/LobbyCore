package me.pljr.lobbycore.config;

import me.pljr.lobbycore.enums.DisabledEvents;
import me.pljr.pljrapispigot.managers.ConfigManager;

import java.util.HashMap;

public class CfgDisabledEvents {
    public static HashMap<DisabledEvents, Boolean> list;

    public static void load(ConfigManager config){
        list = new HashMap<>();
        for (DisabledEvents event : DisabledEvents.values()){
            list.put(event, config.getBoolean(event.getPath()));
        }
    }
}
