package me.yourname.lionsystems.utilities;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionType;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.profile.PlayerTextures;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class ButtonCreators {
    public ItemStack WayPoints(){
        ItemStack wp = new ItemStack(Material.RECOVERY_COMPASS);
        ItemMeta wpmeta = wp.getItemMeta();
        wpmeta.setDisplayName(ChatColor.GOLD +"Server Waypoints");
        List<String> wplore = new ArrayList<>();
        wplore.add("Opens a Gui to");
        wplore.add("manage Serverwaypoints. ");
        wplore.add("Requires the plugin LionWaypoints");
        wpmeta.setLore(wplore);
        wp.setItemMeta(wpmeta);

        return wp;
    }
    public ItemStack RecipeGenerator(){
        ItemStack ct = new ItemStack(Material.CRAFTING_TABLE);
        ItemMeta ctmeta = ct.getItemMeta();
        ctmeta.setDisplayName(ChatColor.DARK_PURPLE + "Recipe generator");
        List<String> ctlore = new ArrayList<>();
        ctlore.add("Generate recipes ingame!");
        ctmeta.setLore(ctlore);
        ctmeta.setUnbreakable(true);
        ct.setItemMeta(ctmeta);
        return ct;
    }
    public ItemStack[] block(int size){
        ItemStack[] blocked = new ItemStack[size];
        ItemStack placeholder = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta plmeta = placeholder.getItemMeta();
        plmeta.setDisplayName(" ");
        plmeta.setUnbreakable(true);
        placeholder.setItemMeta(plmeta);
        for (int i = 0; i < size; i++){
            blocked[i] = placeholder;

        }
        return blocked;
    }
    public ItemStack Confirm(){
        ItemStack gw = new ItemStack(Material.GREEN_WOOL);
        ItemMeta gwmeta = gw.getItemMeta();
        gwmeta.setDisplayName(ChatColor.GREEN + "Click to confirm");
        gwmeta.setUnbreakable(true);
        gw.setItemMeta(gwmeta);
        return gw;
    }
    public ItemStack ButtonON(String name){
        ItemStack button = new ItemStack(Material.LIME_DYE);
        ItemMeta bmeta = button.getItemMeta();
        bmeta.setDisplayName(name);
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GREEN+"Currently enabled!");
        lore.add(ChatColor.GREEN+"Click here to disable.");
        bmeta.setLore(lore);
        button.setItemMeta(bmeta);
        return button;
    }
    public ItemStack ButtonOFF(String name){
        ItemStack button = new ItemStack(Material.GRAY_DYE);
        ItemMeta bmeta = button.getItemMeta();
        bmeta.setDisplayName(name);
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY+"Currently disabled!");
        lore.add(ChatColor.GRAY+"Click here to enable.");
        bmeta.setLore(lore);
        button.setItemMeta(bmeta);
        return button;
    }
    public ItemStack Timer(){
        ItemStack clock = new ItemStack(Material.CLOCK);
        ItemMeta clockmeta = clock.getItemMeta();
        clockmeta.setDisplayName(ChatColor.GOLD + "Timer");
        List<String> clocklore = new ArrayList<>();
        clocklore.add(ChatColor.AQUA + "Click to open the ");
        clocklore.add(ChatColor.AQUA + "Timer-Settings");
        clockmeta.setLore(clocklore);
        clock.setItemMeta(clockmeta);
        return clock;
    }
    public ItemStack Timerlive(){
        ItemStack timer = new ItemStack(Material.CLOCK);

        return timer;
    }


    public ItemStack counter(String displayname){
        ItemStack clock = new ItemStack(Material.CLOCK);
        ItemMeta clockmeta = clock.getItemMeta();
        clockmeta.setDisplayName(displayname);
        clock.setItemMeta(clockmeta);
        return clock;
    }
    public ItemStack Warp(){
        ItemStack button = new ItemStack(Material.ENDER_PEARL);
        ItemMeta bmeta = button.getItemMeta();
        bmeta.setDisplayName(org.bukkit.ChatColor.AQUA + "Warp all players to you!");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY+"Click to teleport");
        lore.add(ChatColor.GRAY+"Everyone to your current");
        lore.add(ChatColor.GRAY+"location!");
        bmeta.setLore(lore);
        button.setItemMeta(bmeta);
        return button;
    }
    public ItemStack prestart(){
        ItemStack button = new ItemStack(Material.LINGERING_POTION);
        PotionMeta bmeta = (PotionMeta) button.getItemMeta();
        bmeta.setDisplayName(org.bukkit.ChatColor.AQUA + "Set player-attributes");
        bmeta.setBasePotionType(PotionType.UNCRAFTABLE);
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY+"Click to make");
        lore.add(ChatColor.GRAY+"everyone invulnerable");
        lore.add(ChatColor.GRAY+"etc!");
        bmeta.setLore(lore);
        button.setItemMeta(bmeta);
        return button;
    }
    public ItemStack start(){
        ItemStack button = new ItemStack(Material.POTION);
        PotionMeta bmeta = (PotionMeta) button.getItemMeta();
        bmeta.setDisplayName(org.bukkit.ChatColor.AQUA + "unset player-attributes");
        bmeta.setBasePotionType(PotionType.INSTANT_HEAL);
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY+"Click to undo");
        lore.add(ChatColor.GRAY+"changes from ");
        lore.add(ChatColor.GRAY+"<--");
        bmeta.setLore(lore);
        button.setItemMeta(bmeta);
        return button;
    }

}
