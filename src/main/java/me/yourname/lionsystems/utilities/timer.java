package me.yourname.lionsystems.utilities;

import me.yourname.lionsystems.LionSystems;
import me.yourname.lionsystems.data.def;
import me.yourname.lionsystems.events.TimerTickEvent;
import me.yourname.lionsystems.events.timerFinishEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class timer {
    int days, hours, minutes, seconds, secondsAtStart, currentSeconds;
    boolean isActive;
    BukkitTask task, colorTask;
    List<Player> viewer;
    Component message;
    TimerPhase timerPhase;
    int red, green, blue;

    public timer(int days, int hours, int minutes, int seconds) {
        viewer = new ArrayList<>();
        isActive = false;
        this.days = days;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        secondsAtStart = seconds + (minutes * 60) + (hours * 3600) + (days * 3600 * 24);
        currentSeconds = secondsAtStart;
        def.activeTimers.add(this);
    }
    public timer(int days, int hours, int minutes, int seconds, int secondsAtStart) {
        viewer = new ArrayList<>();
        isActive = false;
        this.days = days;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.secondsAtStart = secondsAtStart;
        def.activeTimers.add(this);
    }
    public void start(){
        if(secondsAtStart == 0){
            updateFirstSeconds();
        }
        if(currentSeconds == 0){
            updateCurrentSeconds();
        }
        task = new timerTick(this).runTaskTimer(LionSystems.getPlugin(), 1, 20);
        colorTask = new colorTick(this).runTaskTimer(LionSystems.getPlugin(), 1, 1);
        isActive = true;
        timerPhase = TimerPhase.RedToGreen;
    }
    public void addPlayer(Player... players){
        viewer.addAll(Arrays.asList(players));
    }
    public void pause(){
        task.cancel();
        for(Player p : viewer){
            p.sendActionBar(Component.text("Timer paused", TextColor.color(255, 0, 255)));
        }
        isActive = false;
    }
    public void tick(){
        currentSeconds--;
        seconds--;
        if(seconds < 0){
            seconds = 59;
            minutes--;
            if(minutes < 0){
                minutes = 59;
                hours--;
                if(hours < 0){
                    hours = 23;
                    days--;
                    if(days < 0){
                        finish();
                        return;
                    }
                }
            }
        }
        message = Component.text(" ");
        if(days > 0){
            message = message.append(Component.text(days)).append(Component.text("d "));
        }
        if(hours > 0){
            message = message.append(Component.text(hours)).append(Component.text("h "));
        }
        if(minutes > 0){
            message = message.append(Component.text(minutes)).append(Component.text("m "));
        }
        if(seconds > 0){
            message = message.append(Component.text(seconds)).append(Component.text("s"));
        }
        message = message.color(TextColor.color(255, 0, 255));
        message = message.decorate(TextDecoration.BOLD);
        Bukkit.getPluginManager().callEvent(new TimerTickEvent(this));
    }
    public void colorTick(){
        if(timerPhase.equals(TimerPhase.RedToGreen)){
            if(red != 0){
                red--;
            }else{
                green++;
                if(green == 255){
                    timerPhase = TimerPhase.GreenToBlue;
                }
            }
        } else if (timerPhase.equals(TimerPhase.GreenToBlue)) {
            if(green != 0){
                green--;
            }else{
                blue++;
                if(blue == 255){
                    timerPhase = TimerPhase.BlueToRed;
                }
            }
        }else{
            if(blue != 0){
                blue--;
            }else{
                red++;
                if(red == 255){
                    timerPhase = TimerPhase.RedToGreen;
                }
            }
        }
        for(Player p : viewer){
            p.sendActionBar(message.color(TextColor.color(red, green, blue)));
        }
    }
    public void finish(){
        currentSeconds = 0;
        seconds = 0;
        minutes = 0;
        hours = 0;
        days = 0;
        task.cancel();
        for(Player p : viewer){
            p.sendMessage(Component.text(LionSystems.ls() + " The Timer has expired!"));
            p.playSound(p, Sound.BLOCK_BEACON_DEACTIVATE, 1.0F, 1.0F);
            p.sendActionBar(Component.text("Timer expired"));
        }
        isActive = false;
        Bukkit.getPluginManager().callEvent(new timerFinishEvent(this));
    }

    public int getDays() {
        return days;
    }
    public void updateCurrentSeconds(){
        currentSeconds = seconds + (minutes * 60) + (hours * 3600) + (days * 3600 * 24);
    }
    public void updateFirstSeconds(){
        secondsAtStart = seconds + (minutes * 60) + (hours * 3600) + (days * 3600 * 24);
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public int getSecondsAtStart() {
        return secondsAtStart;
    }

    public int getCurrentSeconds() {
        return currentSeconds;
    }

    public boolean isActive() {
        return isActive;
    }

    public List<Player> getViewer() {
        return viewer;
    }

    public Component getMessage() {
        return message;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
}
