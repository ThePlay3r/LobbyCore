package me.pljr.lobbycore.listeners;

import me.pljr.lobbycore.config.CfgNpcs;
import me.pljr.pljrapi.utils.BungeeUtil;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class PlayerInteractEntityListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEntityEvent event){
        Entity entity = event.getRightClicked();
        String customName = entity.getCustomName();
        if (customName == null) return;
        if (CfgNpcs.npcs.containsKey(customName)){
            BungeeUtil.send(event.getPlayer(), CfgNpcs.npcs.get(customName));
        }
    }
}
