package me.pljr.lobbycore.config;

import lombok.Getter;
import me.pljr.itemcommands.ItemCommands;
import me.pljr.itemcommands.objects.CommandItem;
import me.pljr.pljrapispigot.managers.ConfigManager;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
public class Items {
    private final HashMap<Integer, ItemStack> items;
    private final List<Integer> itemSlots;

    public Items(ConfigManager config){
        items = new HashMap<>();
        itemSlots = new ArrayList<>();
        ItemCommands itemCommands = ItemCommands.getPlugin(ItemCommands.class);
        HashMap<String, CommandItem> setItems = itemCommands.getItems().getItems();
        ConfigurationSection csItems = config.getConfigurationSection("items");
        if (csItems == null) return;
        for (String item : csItems.getKeys(false)){
            if (setItems.containsKey(item)){
                items.put(config.getInt("items."+item), setItems.get(item).getItem());
                itemSlots.add(config.getInt("items."+item));
            }
        }
    }
}
