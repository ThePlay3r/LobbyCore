package me.pljr.lobbycore.config;

import me.pljr.lobbycore.enums.Lang;
import me.pljr.pljrapispigot.managers.ConfigManager;

import java.util.HashMap;

public class CfgLang {
    public static HashMap<Lang, String> list;

    public static void load(ConfigManager config){
        list = new HashMap<>();
        for (Lang event : Lang.values()){
            list.put(event, config.getString(event.getPath()));
        }
    }
}
