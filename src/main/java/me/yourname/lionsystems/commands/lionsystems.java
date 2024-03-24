package me.yourname.lionsystems.commands;

import de.lioncraft.lionapi.guimanagement.buttons;
import de.lioncraft.lionapi.guimanagement.createItem;
import de.lioncraft.lionapi.messageHandling.defaultMessages;
import me.yourname.lionsystems.data.GUITitles;
import me.yourname.lionsystems.utilities.ButtonCreators;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class lionsystems implements TabExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player p){
            if (p.isOp()){
            p.openInventory(opinv(p));
            }else{
                p.openInventory(maingui(p));
            }
        }else{
            commandSender.sendMessage(defaultMessages.notAPlayer);
        }
        return true;
    }

    public Inventory opinv(Player p){
        Inventory inv = Bukkit.createInventory(p,54, GUITitles.OperatorMenuGUI);
        inv.setContents(buttons.blockButtons);
        inv.setItem(13, new ButtonCreators().RecipeGenerator());
        inv.setItem(15, new ButtonCreators().WayPoints());
        inv.setItem(49, buttons.closeButton);
        inv.setItem(11, new ButtonCreators().Timer());
        inv.setItem(21, new ButtonCreators().Warp());
        inv.setItem(23, new ButtonCreators().prestart());
        inv.setItem(25, new ButtonCreators().start());
        inv.setItem(53, createItem.get(Component.text("Settings"), Material.COMMAND_BLOCK, "Open default settings."));
        return inv;
    }
    public Inventory maingui(Player p){
        Inventory inv = Bukkit.createInventory(p, 54, GUITitles.defaultMenuGUI);
        inv.setContents(buttons.blockButtons);
        inv.setItem(11, new ButtonCreators().WayPoints());
        inv.setItem(49, buttons.closeButton);
        return inv;
    }
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        return null;
    }
}
