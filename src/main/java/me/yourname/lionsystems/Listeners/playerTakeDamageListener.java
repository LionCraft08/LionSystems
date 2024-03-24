package me.yourname.lionsystems.Listeners;

import me.yourname.lionsystems.LionSystems;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class playerTakeDamageListener implements Listener {
    @EventHandler
    public void onDamage(EntityDamageEvent e){
        if(e.getEntityType().equals(EntityType.PLAYER)) {
            if(LionSystems.getPlugin().getConfig().getBoolean("settings.show-damage-in-chat")) {
                Player p = (Player) e.getEntity();
                Bukkit.broadcast(Component.text(LionSystems.ls()).append(p.displayName()).append(Component.text(" hat "))
                        .append(Component.text(e.getFinalDamage() / 2)).append(Component.text(" Herzen Schaden bekommen ("
                                + e.getCause() + ")")), "see-broadcasts");
            }
        }
    }
}
