package me.pljr.lobbycore.listeners;

import lombok.AllArgsConstructor;
import me.pljr.lobbycore.config.Items;
import me.pljr.lobbycore.config.Lang;
import me.pljr.lobbycore.config.CfgLocation;
import me.pljr.pljrapispigot.utils.BossBarUtil;
import me.pljr.pljrapispigot.utils.MiniMessageUtil;
import net.kyori.adventure.bossbar.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.Map;

@AllArgsConstructor
public class PlayerJoinListener implements Listener {

    private final Items items;

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        PlayerInventory playerInventory = player.getInventory();
        playerInventory.clear();
        for (Map.Entry<Integer, ItemStack> entry : items.getItems().entrySet()){
            playerInventory.setItem(entry.getKey(), entry.getValue());
        }
        player.updateInventory();
        player.teleport(CfgLocation.SPAWN.get());
        player.setAllowFlight(true);
        BossBarUtil.show(player, BossBar.bossBar(MiniMessageUtil.parse(Lang.BOSS_BAR.get()), 1f, BossBar.Color.RED, BossBar.Overlay.PROGRESS));
    }
}
