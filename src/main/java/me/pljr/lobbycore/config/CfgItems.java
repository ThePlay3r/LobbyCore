package me.pljr.lobbycore.config;

import me.pljr.itemcommands.objects.CommandItem;
import me.pljr.pljrapi.managers.ConfigManager;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CfgItems {
    public static HashMap<Integer, ItemStack> items;
    public static List<Integer> itemSlots;

    public static void load(ConfigManager config){
        items = new HashMap<>();
        itemSlots = new ArrayList<>();
        HashMap<String, CommandItem> setItems = me.pljr.itemcommands.config.CfgItems.items;
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
