package me.yourname.lionsystems;
import static me.yourname.lionsystems.LionSystems.getPlugin;

import de.lioncraft.lionapi.mainClass;
import me.yourname.lionsystems.Listeners.Listeners;
import me.yourname.lionsystems.Listeners.playerTakeDamageListener;
import me.yourname.lionsystems.Listeners.timerListeners;
import me.yourname.lionsystems.Listeners.worldListeners;
import me.yourname.lionsystems.commands.timerCommand;
import me.yourname.lionsystems.commands.lionsystems;
import me.yourname.lionsystems.commands.pingCommand;
import me.yourname.lionsystems.data.GUITitles;
import me.yourname.lionsystems.utilities.timer;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class enableMethod extends BukkitRunnable {
    @Override
    public void run() {
        if(Bukkit.getPluginManager().isPluginEnabled(mainClass.getPlugin())){
            Bukkit.getLogger().info(LionSystems.ls() + " Successfully linked with LionAPI!");
        }else{
            Bukkit.getLogger().warning(LionSystems.ls() + " Please make sure you have LionAPI installed!");
            Bukkit.getPluginManager().disablePlugin(getPlugin());
            return;
        }
        GUITitles.setTitles();
        getPlugin().getLogger().info("LionSystems is booting");
        getPlugin().getServer().getPluginManager().registerEvents(new Listeners(),getPlugin());
        getPlugin().getCommand("lionsystems").setExecutor(new lionsystems());
        getPlugin().getCommand("timer").setExecutor(new timerCommand());
        getPlugin().getServer().getPluginManager().registerEvents(new playerTakeDamageListener(), getPlugin());
        getPlugin().getServer().getPluginManager().registerEvents(new timerListeners(), getPlugin());
        getPlugin().getServer().getPluginManager().registerEvents(new worldListeners(), getPlugin());
        getPlugin().getCommand("ping").setExecutor(new pingCommand());
        getPlugin().saveDefaultConfig();
        LionSystems.timer = new timer(0, 0, 0, 0, getPlugin().getConfig().getInt("timer.public.timeratstart"));
        LionSystems.timer.setDays(getPlugin().getConfig().getInt("timer.public.days"));
        LionSystems.timer.setHours(getPlugin().getConfig().getInt("timer.public.hours"));
        LionSystems.timer.setMinutes(getPlugin().getConfig().getInt("timer.public.minutes"));
        LionSystems.timer.setSeconds(getPlugin().getConfig().getInt("timer.public.seconds"));
        if (LionSystems.timer.getSeconds() > 0 || LionSystems.timer.getMinutes() > 0 || LionSystems.timer.getHours() > 0 || LionSystems.timer.getDays() > 0){
            LionSystems.timer.start();
        }
        Bukkit.getConsoleSender().addAttachment(getPlugin(), "see-broadcasts", getPlugin().getConfig().getBoolean("settings.console-sees-broadcasts"));

    }
}
