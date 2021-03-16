package me.pljr.lobbycore.commands;

import me.pljr.pljrapispigot.commands.BukkitCommand;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class HidePlayersCommand extends BukkitCommand {
    private final JavaPlugin plugin;
    private final List<Player> hidden;

    public HidePlayersCommand(JavaPlugin plugin){
        super("hideplayers");
        this.plugin = plugin;
        this.hidden = new ArrayList<>();
    }

    @Override
    public void onPlayerCommand(Player player, String[] args) {
        if (hidden.contains(player)){
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()){
                if (player == onlinePlayer) continue;
                player.showPlayer(plugin, onlinePlayer);
            }
            hidden.remove(player);
        }else{
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()){
                if (player == onlinePlayer) continue;
                player.hidePlayer(plugin, onlinePlayer);
            }
            hidden.add(player);
        }
        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
    }
}
