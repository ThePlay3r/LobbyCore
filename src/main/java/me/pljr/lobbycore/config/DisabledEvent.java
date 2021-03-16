package me.pljr.lobbycore.config;

import me.pljr.pljrapispigot.managers.ConfigManager;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;

public enum DisabledEvent {
    DROP(true),
    INV_CLICK(true),
    BREAK(true),
    PLACE(true),
    HUNGER(true),
    DAMAGE(true),
    WEATHER(true);

    private static HashMap<DisabledEvent, Boolean> events;
    private final boolean defaultValue;

    DisabledEvent(boolean defaultValue){
        this.defaultValue = defaultValue;
    }

    public static void load(ConfigManager config){
        FileConfiguration fileConfig = config.getConfig();
        events = new HashMap<>();
        for (DisabledEvent event : values()){
            if (!fileConfig.isSet(event.toString())){
                fileConfig.set(event.toString(), event.defaultValue);
            }else{
                events.put(event, config.getBoolean(event.toString()));
            }
        }
        config.save();
    }

    public boolean get(){
        return events.getOrDefault(this, defaultValue);
    }
}
