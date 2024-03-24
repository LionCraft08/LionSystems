package me.yourname.lionsystems.events;

import me.yourname.lionsystems.LionSystems;
import me.yourname.lionsystems.utilities.timer;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class TimerTickEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    public Long getTimerAtStart() {
        return timerAtStart;
    }

    public Long getTimerCurrent() {
        return timerCurrent;
    }

    public int getTimerHours() {
        return timerHours;
    }

    public int getTimerDays() {
        return timerDays;
    }

    public int getTimerMinutes() {
        return timerMinutes;
    }

    public int getTimerSeconds() {
        return timerSeconds;
    }

    private final Long timerAtStart;
    private final Long timerCurrent;
    private final int timerHours;
    private final int timerDays;
    private final int timerMinutes;
    private final int timerSeconds;
    private final timer timer;
    public TimerTickEvent(timer timer){
        this.timer = timer;
        timerAtStart = (long) timer.getSecondsAtStart();
        timerCurrent = (long) timer.getCurrentSeconds();
        timerHours = timer.getHours();
        timerDays = timer.getDays();
        timerMinutes = timer.getMinutes();
        timerSeconds = timer.getSeconds();
    }

    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
    public timer getTimer(){return timer;}
}
