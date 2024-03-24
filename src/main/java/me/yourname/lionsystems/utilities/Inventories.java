package me.yourname.lionsystems.utilities;

import de.lioncraft.lionapi.guimanagement.Function;
import de.lioncraft.lionapi.guimanagement.Setting;
import de.lioncraft.lionapi.guimanagement.buttons;
import de.lioncraft.lionapi.guimanagement.createItem;
import me.yourname.lionsystems.LionSystems;
import me.yourname.lionsystems.data.GUITitles;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Set;

public class Inventories {

    public Inventory RecipeGenerator(Player p){
        Inventory inv = Bukkit.createInventory(p, 54, GUITitles.RecipeGeneratorGUI);
        inv.setContents(buttons.blockButtons);
        inv.setItem(49, buttons.closeButton);
        ItemStack air = new ItemStack(Material.AIR);
        inv.setItem(10, new ButtonCreators().ButtonOFF("Shapeless crafting"));
        inv.setItem(12, air);
        inv.setItem(13, air);
        inv.setItem(14, air);
        inv.setItem(21, air);
        inv.setItem(22, air);
        inv.setItem(23, air);
        inv.setItem(30, air);
        inv.setItem(31, air);
        inv.setItem(32, air);
        inv.setItem(25, air);
        inv.setItem(53, new ButtonCreators().Confirm());
        return inv;
    }
    ItemStack plus = buttons.plusButton;
    ItemStack minus = buttons.MinusButton;
    public Inventory TimerMain(Player p, Boolean isop){
        Inventory inv = Bukkit.createInventory(p, 54, LionSystems.ls() + "TimerSettings");
        inv.setContents(buttons.blockButtons);
        inv.setItem(49, buttons.closeButton);
        inv.setItem(6, new ButtonCreators().Timerlive());
        inv.setItem(9, plus);
        inv.setItem(10, plus);
        inv.setItem(11, plus);
        inv.setItem(12, plus);
        inv.setItem(27, minus);
        inv.setItem(28, minus);
        inv.setItem(29, minus);
        inv.setItem(30, minus);
        inv.setMaxStackSize(256);
        inv.setItem(18, new ButtonCreators().counter("days"));
        inv.setItem(19, new ButtonCreators().counter("hours"));
        inv.setItem(20, new ButtonCreators().counter("minutes"));
        inv.setItem(21, new ButtonCreators().counter("seconds"));
        Setting timer = new Setting(LionSystems.isStopwatch, createItem.get(Component.text("Timer?"), Material.CLOCK, "Sets if the Timer should ", "count down (is enabled) or up (if disabled)"),
                b -> {
            if(b){
                if(LionSystems.stopwatch.isActive){
                    LionSystems.stopwatch.pause();
                }
                LionSystems.stopwatch = null;
                LionSystems.timer = new timer(0, 1, 0, 0);
            }else{
                if(LionSystems.timer.isActive){
                    LionSystems.timer.pause();
                }
                LionSystems.timer = null;
                LionSystems.stopwatch = new stopwatch();
            }
                }
        );
        inv.setItem(34, timer.getTopItem());
        inv.setItem(43, timer.getBottomItem());
        return inv;
    }
    public static Inventory defaultSettingsInv(Player owner){
        Inventory inv = Bukkit.createInventory(owner, 54, GUITitles.settingsMenuGUI);
        inv.setContents(buttons.blockButtons);
        inv.setItem(49, buttons.closeButton);
        Setting damageInChat = new Setting(LionSystems.getPlugin().getConfig().getBoolean("settings.show-damage-in-chat"),
                createItem.get("Show Damage in Chat", Material.TNT, "If damage should be displayed in Chat"), b -> {
                    LionSystems.getPlugin().getConfig().set("settings.show-damage-in-chat", b);
                    if(b){
                        owner.sendMessage(LionSystems.ls() + " Damage will be displayed in Chat");
                    }else{
                        owner.sendMessage(LionSystems.ls() + " Damage will no longer be displayed in Chat");
                    }
                });
        inv.setItem(10, damageInChat.getTopItem());
        inv.setItem(19, damageInChat.getBottomItem());
        Setting pvp = new Setting(owner.getWorld().getPVP(), createItem.get("PVP", Material.IRON_SWORD, "Toggles PVP"),
                b -> {
                    if(b){
                        owner.sendMessage(LionSystems.ls() + "PVP is now enabled.");
                    }else{
                        owner.sendMessage(LionSystems.ls() + "PVP is now disabled.");
                    }
                    owner.getWorld().setPVP(b);
                });
        inv.setItem(12, pvp.getTopItem());
        inv.setItem(21, pvp.getBottomItem());
        Setting move = new Setting(LionSystems.getPlugin().getConfig().getBoolean("settings.players-can-move"), createItem.get("Players can move", Material.LEATHER_BOOTS, "Sets weather players can move"),
                b -> {
                if(b){
                    owner.sendMessage(LionSystems.ls() + "Players can move");
                }else{
                    owner.sendMessage(LionSystems.ls() + "Players can't move");
                }
                    LionSystems.getPlugin().getConfig().set("settings.players-can-move", b);
                });
        inv.setItem(14, move.getTopItem());
        inv.setItem(23, move.getBottomItem());
        Setting fly = new Setting(LionSystems.getPlugin().getConfig().getBoolean("settings.players-can-fly"), createItem.get("Players can fly in Survival", Material.ELYTRA, "Sets if all Players can fly in Survival mode"),
                b -> {
            if(b){
                owner.sendMessage(LionSystems.ls() + "Players now can fly");
            }else{
                owner.sendMessage(LionSystems.ls() + "Players now  can't fly");
            }
                    LionSystems.getPlugin().getConfig().set("settings.players-can-fly", b);
            for(Player p : Bukkit.getOnlinePlayers()){
                p.setAllowFlight(b);
            }
                });
        inv.setItem(16, fly.getTopItem());
        inv.setItem(25, fly.getBottomItem());
        return inv;
    }
}
