package me.pljr.lobbycore.listeners;

import me.pljr.lobbycore.config.CfgItems;
import me.pljr.lobbycore.config.CfgLang;
import me.pljr.lobbycore.config.CfgLocations;
import me.pljr.lobbycore.enums.Lang;
import me.pljr.lobbycore.enums.Locations;
import me.pljr.pljrapi.adventure.bossbar.BossBar;
import me.pljr.pljrapi.utils.BossBarUtil;
import me.pljr.pljrapi.utils.MiniMessageUtil;
import me.pljr.pljrapi.utils.PlayerUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.Map;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        PlayerInventory playerInventory = player.getInventory();
        playerInventory.clear();
        for (Map.Entry<Integer, ItemStack> entry : CfgItems.items.entrySet()){
            playerInventory.setItem(entry.getKey(), entry.getValue());
        }
        player.updateInventory();
        PlayerUtil.teleport(player, CfgLocations.list.get(Locations.SPAWN), false);
        player.setAllowFlight(true);
        BossBarUtil.show(player, BossBar.bossBar(MiniMessageUtil.parse(CfgLang.list.get(Lang.BOSS_BAR)), 1f, BossBar.Color.RED, BossBar.Overlay.PROGRESS));
    }
}
