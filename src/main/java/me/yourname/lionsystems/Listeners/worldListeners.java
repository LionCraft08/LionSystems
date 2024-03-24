package me.yourname.lionsystems.Listeners;

import me.yourname.lionsystems.LionSystems;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class worldListeners implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){
        if(!LionSystems.getPlugin().getConfig().getBoolean("settings.players-can-move")){
            if(e.hasChangedPosition()){
                e.setCancelled(true);
            }
        }
    }
}
