package me.pljr.lobbycore.listeners;

import me.pljr.lobbycore.LobbyCore;
import me.pljr.lobbycore.config.CfgSounds;
import me.pljr.lobbycore.enums.Sounds;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class DoubleJumpListener implements Listener {

    @EventHandler
    public void onDoubleJump(PlayerToggleFlightEvent event){
        Player player = event.getPlayer();
        GameMode playerGM = player.getGameMode();
        if (playerGM == GameMode.CREATIVE || playerGM == GameMode.SPECTATOR) return;

        event.setCancelled(true);
        player.setAllowFlight(false);
        player.setVelocity(player.getLocation().getDirection().multiply(1.5).setY(1));
        CfgSounds.list.get(Sounds.DOUBLE_JUMP).play(player);
        Bukkit.getScheduler().runTaskLaterAsynchronously(LobbyCore.getInstance(), ()->{
            Bukkit.getScheduler().runTask(LobbyCore.getInstance(), () -> player.setAllowFlight(true));
        }, 20*2);
    }
}
