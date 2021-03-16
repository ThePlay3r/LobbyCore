package me.pljr.lobbycore.config;

import me.pljr.pljrapispigot.managers.ConfigManager;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;

public enum Lang {
    BOSS_BAR("&a&lOBCHOD &6&lSTORE.DIAMONDCREW.CZ");

    private static HashMap<Lang, String> lang;
    private final String defaultValue;

    Lang(String defaultValue){
        this.defaultValue = defaultValue;
    }

    public static void load(ConfigManager config){
        FileConfiguration fileConfig = config.getConfig();
        lang = new HashMap<>();
        for (Lang lang : values()){
            if (!fileConfig.isSet(lang.toString())){
                fileConfig.set(lang.toString(), lang.defaultValue);
            }else{
                Lang.lang.put(lang, config.getString(lang.toString()));
            }
        }
        config.save();
    }

    public String get(){
        return lang.getOrDefault(this, defaultValue);
    }
}
