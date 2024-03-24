package me.yourname.lionsystems;

import me.yourname.lionsystems.data.def;
import me.yourname.lionsystems.utilities.stopwatch;
import me.yourname.lionsystems.utilities.timer;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;


public final class LionSystems extends JavaPlugin implements Listener {

    private static LionSystems plugin;
    @Override
    public void onEnable() {
        def.activeTimers = new ArrayList<>();
        // Plugin startup logic
        plugin = this;
        BukkitTask t = new enableMethod().runTaskLater(this, 1);
    }
    public static Component finaltimerMessage;
    public static timer timer;
    public static stopwatch stopwatch;
    public static boolean isStopwatch;

    @Override
    public void onDisable() {

    }

    public static String ls(){
        String s = plugin.getConfig().getString("default_prefix");
        s = ChatColor.translateAlternateColorCodes('&', s);
        return s + " ";
    }
    public static LionSystems getPlugin() {
        return plugin;
    }
}
