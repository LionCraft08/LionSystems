package me.yourname.lionsystems.events;

import me.yourname.lionsystems.utilities.timer;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class timerFinishEvent extends Event{
    timer timer;
    private static final HandlerList handlers = new HandlerList();
    public long getTimerAtStart(){
        return timer.getSecondsAtStart();
    }
    public List<Player> getViewers(){return timer.getViewer();}
    public timer getTimer(){return timer;}

    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
    public timerFinishEvent(timer timer){
        this.timer = timer;
    }
}
