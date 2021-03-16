package me.pljr.lobbycore.listeners;

import lombok.AllArgsConstructor;
import me.pljr.lobbycore.LobbyCore;
import me.pljr.lobbycore.config.CfgSound;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.plugin.java.JavaPlugin;

@AllArgsConstructor
public class DoubleJumpListener implements Listener {

    private final JavaPlugin plugin;

    @EventHandler
    public void onDoubleJump(PlayerToggleFlightEvent event){
        Player player = event.getPlayer();
        GameMode playerGM = player.getGameMode();
        if (playerGM == GameMode.CREATIVE || playerGM == GameMode.SPECTATOR) return;

        event.setCancelled(true);
        player.setAllowFlight(false);
        player.setVelocity(player.getLocation().getDirection().multiply(1.5).setY(1));
        CfgSound.DOUBLE_JUMP.get().play(player);
        Bukkit.getScheduler().runTaskLater(plugin, ()-> player.setAllowFlight(true), 20*2);
    }
}
