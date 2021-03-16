package me.pljr.lobbycore.config;

import me.pljr.pljrapispigot.managers.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;

public enum CfgLocation {
    SPAWN(new Location(Bukkit.getWorld("lobbyworld"), 0, 0, 0, 0, 0));

    private static HashMap<CfgLocation, Location> locations;
    private final Location defaultValue;

    CfgLocation(Location defaultValue){
        this.defaultValue = defaultValue;
    }

    public static void load(ConfigManager config){
        FileConfiguration fileConfig = config.getConfig();
        locations = new HashMap<>();
        for (CfgLocation cfgLocation : values()){
            if (!fileConfig.isSet(cfgLocation.toString())){
                String path = cfgLocation.toString();
                fileConfig.set(path+".world", cfgLocation.defaultValue.getWorld().getName());
                fileConfig.set(path+".x", cfgLocation.defaultValue.getX());
                fileConfig.set(path+".y", cfgLocation.defaultValue.getY());
                fileConfig.set(path+".z", cfgLocation.defaultValue.getZ());
                fileConfig.set(path+".yaw", cfgLocation.defaultValue.getYaw());
                fileConfig.set(path+".pitch", cfgLocation.defaultValue.getPitch());
            }else{
                CfgLocation.locations.put(cfgLocation, config.getLocation(cfgLocation.toString()));
            }
        }
        config.save();
    }

    public Location get(){
        return locations.getOrDefault(this, defaultValue);
    }
}
