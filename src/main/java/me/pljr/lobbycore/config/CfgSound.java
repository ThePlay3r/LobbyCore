package me.pljr.lobbycore.config;

import me.pljr.pljrapispigot.builders.SoundBuilder;
import me.pljr.pljrapispigot.managers.ConfigManager;
import me.pljr.pljrapispigot.objects.PLJRSound;
import me.pljr.pljrapispigot.xseries.XSound;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;

public enum CfgSound {
    DOUBLE_JUMP(new SoundBuilder(XSound.ENTITY_BAT_TAKEOFF, 1, -5).create());

    private static HashMap<CfgSound, PLJRSound> sounds;
    private final PLJRSound defaultValue;

    CfgSound(PLJRSound defaultValue){
        this.defaultValue = defaultValue;
    }

    public static void load(ConfigManager config){
        FileConfiguration fileConfig = config.getConfig();
        sounds = new HashMap<>();
        for (CfgSound cfgSound : values()){
            if (!fileConfig.isSet(cfgSound.toString())){
                config.setPLJRSound(cfgSound.toString(), cfgSound.defaultValue);
            }else{
                CfgSound.sounds.put(cfgSound, config.getPLJRSound(cfgSound.toString()));
            }
        }
        config.save();
    }

    public PLJRSound get(){
        return sounds.getOrDefault(this, defaultValue);
    }
}
