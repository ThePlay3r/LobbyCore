package me.pljr.lobbycore.listeners;

import lombok.AllArgsConstructor;
import me.pljr.lobbycore.config.NpcSettings;
import me.pljr.pljrapispigot.utils.BungeeUtil;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

@AllArgsConstructor
public class PlayerInteractEntityListener implements Listener {

    private final NpcSettings npcSettings;

    @EventHandler
    public void onInteract(PlayerInteractEntityEvent event){
        Entity entity = event.getRightClicked();
        String customName = entity.getCustomName();
        if (customName == null) return;
        if (npcSettings.getNpcs().containsKey(customName)){
            BungeeUtil.send(event.getPlayer(), npcSettings.getNpcs().get(customName));
        }
    }
}
