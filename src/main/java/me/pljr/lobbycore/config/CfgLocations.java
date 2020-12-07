package me.pljr.lobbycore.config;

import me.pljr.lobbycore.enums.Locations;
import me.pljr.pljrapi.managers.ConfigManager;
import org.bukkit.Location;

import java.util.HashMap;

public class CfgLocations {
    public static HashMap<Locations, Location> list;

    public static void load(ConfigManager config){
        list = new HashMap<>();
        for (Locations event : Locations.values()){
            list.put(event, config.getLocation(event.getPath()));
        }
    }
}
