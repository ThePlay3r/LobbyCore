package me.pljr.lobbycore.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class HidePlayersCommand implements CommandExecutor {
    private final List<Player> hidden;

    public HidePlayersCommand(){
        this.hidden = new ArrayList<>();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (hidden.contains(player)){
                for (Player onlinePlayer : Bukkit.getOnlinePlayers()){
                    if (player == onlinePlayer) continue;
                    player.showPlayer(onlinePlayer);
                }
                hidden.remove(player);
            }else{
                for (Player onlinePlayer : Bukkit.getOnlinePlayers()){
                    if (player == onlinePlayer) continue;
                    player.hidePlayer(onlinePlayer);
                }
                hidden.add(player);
            }
            player.playSound(player.getLocation(), Sound.NOTE_PLING, 1, 1);
        }
        return false;
    }
}
