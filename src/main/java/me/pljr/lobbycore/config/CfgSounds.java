package me.pljr.lobbycore.config;

import me.pljr.lobbycore.enums.Sounds;
import me.pljr.pljrapispigot.managers.ConfigManager;
import me.pljr.pljrapispigot.objects.PLJRSound;

import java.util.HashMap;

public class CfgSounds {
    public static HashMap<Sounds, PLJRSound> list;

    public static void load(ConfigManager config){
        list = new HashMap<>();
        for (Sounds event : Sounds.values()){
            list.put(event, config.getPLJRSound(event.getPath()));
        }
    }
}
