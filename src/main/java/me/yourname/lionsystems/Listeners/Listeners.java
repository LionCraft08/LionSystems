package me.yourname.lionsystems.Listeners;

import de.lioncraft.lionapi.guimanagement.buttons;
import de.lioncraft.lionapi.messageHandling.defaultMessages;
import me.yourname.lionsystems.LionSystems;
import me.yourname.lionsystems.data.GUITitles;
import me.yourname.lionsystems.data.messages;
import me.yourname.lionsystems.utilities.ButtonCreators;
import me.yourname.lionsystems.utilities.Inventories;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextReplacementConfig;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.world.WorldSaveEvent;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapelessRecipe;

import java.util.Objects;
import java.util.UUID;

public class Listeners implements Listener {


    @EventHandler
    public void onClickEvent(InventoryClickEvent e){
        if(e.getCurrentItem() == null){
            return;
        }
        if(e.getClickedInventory() == null){
            return;
        }
            if (e.getView().title().equals(GUITitles.OperatorMenuGUI)) {
                // OP GUI
                Player p = (Player) e.getWhoClicked();
                if(e.getCurrentItem() == null){
                    return;
                }
                if (Objects.equals(e.getCurrentItem(), new ButtonCreators().RecipeGenerator())) {
                    e.setCancelled(true);
                    p.openInventory(new Inventories().RecipeGenerator(p));
                } else if (Objects.equals(e.getCurrentItem(), new ButtonCreators().WayPoints())) {
                    e.setCancelled(true);
                    p.performCommand("wp");
                } else if (Objects.equals(e.getCurrentItem(), new ButtonCreators().Timer())) {
                    e.setCancelled(true);
                    p.openInventory(new Inventories().TimerMain(p, true));
                } else if (Objects.equals(e.getCurrentItem(), new ButtonCreators().Warp())) {
                    e.setCancelled(true);
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.teleport(p.getLocation());
                        player.playSound(player, Sound.ENTITY_ILLUSIONER_MIRROR_MOVE, 1.0F, 1.0F);
                    }
                } else if (Objects.equals(e.getCurrentItem(), new ButtonCreators().prestart())) {
                    e.setCancelled(true);
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.setAllowFlight(true);
                        player.setInvulnerable(true);
                        player.setHealth(20);
                        player.setGameMode(GameMode.ADVENTURE);
                        player.setCanPickupItems(false);
                    }
                } else if (Objects.equals(e.getCurrentItem(), new ButtonCreators().start())) {
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.setAllowFlight(false);
                        player.setInvulnerable(false);
                        player.setHealth(20);
                        player.setGameMode(GameMode.SURVIVAL);
                        player.setCanPickupItems(true);
                    }
                    e.setCancelled(true);
                } else if(e.getCurrentItem().getType().equals(Material.COMMAND_BLOCK)){
                    p.openInventory(Inventories.defaultSettingsInv(p));
                }else{
                    e.setCancelled(true);
                }
            }else if (e.getView().title().equals(GUITitles.defaultMenuGUI)) {
                // Main user menu
                e.setCancelled(true);
                if (Objects.equals(e.getCurrentItem(), new ButtonCreators().WayPoints())) {
                    Player p = (Player) e.getWhoClicked();
                    e.setCancelled(true);
                    p.performCommand("wp");
                }
            } else if (e.getView().title().equals(GUITitles.RecipeGeneratorGUI)) {
                //Recipe menu
                if (Objects.equals(e.getCurrentItem(), new ButtonCreators().Confirm())){
                    e.setCancelled(true);
                    if(e.getClickedInventory().getItem(25)==null){
                        e.getWhoClicked().sendMessage(defaultMessages.messagePrefix.append(Component.text("Please set a result Item!")));
                        return;
                    }
                    if (Objects.equals(e.getClickedInventory().getItem(10), new ButtonCreators().ButtonON("Shapeless crafting"))) {
                        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(LionSystems.getPlugin(), UUID.randomUUID().toString()), Objects.requireNonNull(e.getClickedInventory().getItem(25)));
                        int temp = 0;
                        if(e.getClickedInventory().getItem(12)!=null){
                            temp++;
                            recipe.addIngredient(Objects.requireNonNull(e.getClickedInventory().getItem(12)));
                        }if(e.getClickedInventory().getItem(13)!=null){
                            temp++;
                        recipe.addIngredient(Objects.requireNonNull(e.getClickedInventory().getItem(13)));
                        }if(e.getClickedInventory().getItem(14)!=null){
                            temp++;
                        recipe.addIngredient(Objects.requireNonNull(e.getClickedInventory().getItem(14)));
                        }if(e.getClickedInventory().getItem(21)!=null){
                            temp++;
                        recipe.addIngredient(Objects.requireNonNull(e.getClickedInventory().getItem(21)));
                        }if(e.getClickedInventory().getItem(22)!=null){
                            temp++;
                        recipe.addIngredient(Objects.requireNonNull(e.getClickedInventory().getItem(22)));
                        }if(e.getClickedInventory().getItem(23)!=null){
                            temp++;
                        recipe.addIngredient(Objects.requireNonNull(e.getClickedInventory().getItem(23)));
                        }if(e.getClickedInventory().getItem(30)!=null){
                            temp++;
                        recipe.addIngredient(Objects.requireNonNull(e.getClickedInventory().getItem(30)));
                        }if(e.getClickedInventory().getItem(31)!=null){
                            temp++;
                        recipe.addIngredient(Objects.requireNonNull(e.getClickedInventory().getItem(31)));
                        }if(e.getClickedInventory().getItem(32)!=null) {
                            temp++;
                            recipe.addIngredient(Objects.requireNonNull(e.getClickedInventory().getItem(32)));
                        }
                        if(temp > 0){
                            Bukkit.addRecipe(recipe);
                            e.getWhoClicked().closeInventory();
                            e.getWhoClicked().sendMessage(Component.text(LionSystems.ls() + " Successfully created a new Recipe for " ).append(Component.translatable(recipe.getResult().translationKey())));
                        }else{
                            e.getWhoClicked().sendMessage(LionSystems.ls() + " Please provide required Items!");
                        }
                        
                    }

                } else if (e.getCurrentItem().equals(buttons.blockButton)){
                    e.setCancelled(true);
                } else if (e.getCurrentItem().equals(new ButtonCreators().ButtonOFF("Shapeless crafting"))) {
                    e.setCancelled(true);
                    e.getClickedInventory().setItem(10, new ButtonCreators().ButtonON("Shapeless crafting"));
                } else if (e.getCurrentItem().equals(new ButtonCreators().ButtonON("Shapeless crafting"))) {
                    e.setCancelled(true);
                    e.getClickedInventory().setItem(10, new ButtonCreators().ButtonOFF("Shapeless crafting"));
                }

            } else if (e.getView().title().equals(GUITitles.invWatchGUITitle)) {
                if(e.getCurrentItem() != null) {
                    e.setCancelled(true);
                }
            } else if (e.getView().title().equals(GUITitles.settingsMenuGUI)) {
                if(e.getCurrentItem() != null) {
                    e.setCancelled(true);
                }
            }

        if (e.getCurrentItem() != null) {
            if (e.getCurrentItem().equals(buttons.closeButton)) {
                Player p = (Player) e.getWhoClicked();
                e.setCancelled(true);
                p.closeInventory();
                p.playSound(p, Sound.ENTITY_ILLUSIONER_MIRROR_MOVE, 1.0f, 1.0f);
            }
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player p = event.getPlayer();
        Component joinmsg;
        if (p.hasPlayedBefore()){
            joinmsg = Component.text(Objects.requireNonNull(LionSystems.getPlugin().getConfig().getString("messages.joinmessage").replace("?playername?", event.getPlayer().getName())));
        }else{
            joinmsg = Component.text(Objects.requireNonNull(LionSystems.getPlugin().getConfig().getString("messages.firstjoinmessage").replace("?playername?", event.getPlayer().getName())));
        }
        event.joinMessage(joinmsg.color(TextColor.color(255, 0, 255)));
        if(!LionSystems.timer.getViewer().contains(event.getPlayer())){
            LionSystems.timer.getViewer().add(event.getPlayer());
        }
    }
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){
        String quitmsg = LionSystems.getPlugin().getConfig().getString("messages.quitmessage");
        quitmsg = quitmsg.replace("?playername?", e.getPlayer().getName());
        e.setQuitMessage(ChatColor.translateAlternateColorCodes('&', quitmsg));
    }
    @EventHandler
    public void onWorldSave(WorldSaveEvent e){
        LionSystems.getPlugin().getConfig().set("timer.public.hours", LionSystems.timer.getHours());
        LionSystems.getPlugin().getConfig().set("timer.public.minutes", LionSystems.timer.getMinutes());
        LionSystems.getPlugin().getConfig().set("timer.public.seconds", LionSystems.timer.getSeconds());
        LionSystems.getPlugin().getConfig().set("timer.public.days", LionSystems.timer.getDays());
        LionSystems.getPlugin().getConfig().set("timer.public.timeratstart", LionSystems.timer.getSecondsAtStart());
        LionSystems.getPlugin().getConfig().set("timer.public.timercurrent", LionSystems.timer.getCurrentSeconds());
        for(Player p : Bukkit.getOnlinePlayers()){
            if (p.isOp()) {
                p.sendMessage("Debug: World saved");
            }
        }
        LionSystems.getPlugin().saveConfig();
    }
}
