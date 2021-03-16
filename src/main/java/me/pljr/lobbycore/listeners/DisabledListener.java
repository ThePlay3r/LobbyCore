package me.pljr.lobbycore.listeners;

import me.pljr.lobbycore.config.DisabledEvent;
import me.pljr.lobbycore.config.CfgLocation;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class DisabledListener implements Listener {

    @EventHandler
    public void onDrop(PlayerDropItemEvent event){
        if (event.getPlayer().getGameMode() == GameMode.CREATIVE) return;
        event.setCancelled(DisabledEvent.DROP.get());
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent event){
        if (event.getWhoClicked().getGameMode() == GameMode.CREATIVE) return;
        event.setCancelled(DisabledEvent.INV_CLICK.get());
        /*if (event.getWhoClicked() instanceof Player){
            int slot = event.getRawSlot();
            if (CfgItems.itemSlots.contains(slot)){
                event.setCancelled(CfgDisabledEvents.list.get(DisabledEvents.INV_CLICK));
            }
        }*/
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event){
        if (event.getPlayer().getGameMode() == GameMode.CREATIVE) return;
        event.setCancelled(DisabledEvent.BREAK.get());
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event){
        if (event.getPlayer().getGameMode() == GameMode.CREATIVE) return;
        event.setCancelled(DisabledEvent.PLACE.get());
    }

    @EventHandler
    public void onHunger(FoodLevelChangeEvent event){
        event.setCancelled(DisabledEvent.HUNGER.get());
    }

    @EventHandler
    public void onWeather(WeatherChangeEvent event){
        if (DisabledEvent.WEATHER.get() && event.toWeatherState()) event.setCancelled(true);
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event){
        event.setCancelled(DisabledEvent.DAMAGE.get());
        if (event.getCause() == EntityDamageEvent.DamageCause.VOID){
            event.getEntity().teleport(CfgLocation.SPAWN.get());
        }
    }
}
