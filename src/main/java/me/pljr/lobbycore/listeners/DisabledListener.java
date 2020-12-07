package me.pljr.lobbycore.listeners;

import me.pljr.lobbycore.config.CfgDisabledEvents;
import me.pljr.lobbycore.config.CfgLocations;
import me.pljr.lobbycore.enums.DisabledEvents;
import me.pljr.lobbycore.enums.Locations;
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
        event.setCancelled(CfgDisabledEvents.list.get(DisabledEvents.DROP));
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent event){
        if (event.getWhoClicked().getGameMode() == GameMode.CREATIVE) return;
        event.setCancelled(CfgDisabledEvents.list.get(DisabledEvents.INV_CLICK));
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
        event.setCancelled(CfgDisabledEvents.list.get(DisabledEvents.BREAK));
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event){
        if (event.getPlayer().getGameMode() == GameMode.CREATIVE) return;
        event.setCancelled(CfgDisabledEvents.list.get(DisabledEvents.PLACE));
    }

    @EventHandler
    public void onHunger(FoodLevelChangeEvent event){
        event.setCancelled(CfgDisabledEvents.list.get(DisabledEvents.HUNGER));
    }

    @EventHandler
    public void onWeather(WeatherChangeEvent event){
        if (CfgDisabledEvents.list.get(DisabledEvents.WEATHER) && event.toWeatherState()) event.setCancelled(true);
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event){
        event.setCancelled(CfgDisabledEvents.list.get(DisabledEvents.DAMAGE));
        if (event.getCause() == EntityDamageEvent.DamageCause.VOID){
            event.getEntity().teleport(CfgLocations.list.get(Locations.SPAWN));
        }
    }
}
