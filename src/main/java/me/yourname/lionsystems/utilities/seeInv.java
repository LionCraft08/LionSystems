package me.yourname.lionsystems.utilities;

import me.yourname.lionsystems.data.GUITitles;
import me.yourname.lionsystems.data.messages;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class seeInv {
    public static void viewInv(Player viewer, @NotNull Player player){
        Inventory inv = Bukkit.createInventory(viewer, 54, GUITitles.invWatchGUITitle);
        inv.setContents(player.getInventory().getContents());
        player.openInventory(inv);
    }
}
