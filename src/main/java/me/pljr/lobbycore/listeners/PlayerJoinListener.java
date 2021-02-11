package me.pljr.lobbycore.listeners;

import me.pljr.lobbycore.config.CfgItems;
import me.pljr.lobbycore.config.CfgLang;
import me.pljr.lobbycore.config.CfgLocations;
import me.pljr.lobbycore.enums.Lang;
import me.pljr.lobbycore.enums.Locations;
import me.pljr.pljrapispigot.kyori.adventure.bossbar.BossBar;
import me.pljr.pljrapispigot.utils.BossBarUtil;
import me.pljr.pljrapispigot.utils.MiniMessageUtil;
import me.pljr.pljrapispigot.utils.PlayerUtil;
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
        player.teleport(CfgLocations.list.get(Locations.SPAWN));
        player.setAllowFlight(true);
        BossBarUtil.show(player, BossBar.bossBar(MiniMessageUtil.parse(CfgLang.list.get(Lang.BOSS_BAR)), 1f, BossBar.Color.RED, BossBar.Overlay.PROGRESS));
    }
}
