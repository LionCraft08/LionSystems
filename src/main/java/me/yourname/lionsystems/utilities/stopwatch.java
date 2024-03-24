package me.yourname.lionsystems.utilities;

import me.yourname.lionsystems.LionSystems;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.List;

public class stopwatch {
    int days, hours, minutes, seconds;
    boolean isActive;
    BukkitTask task, colorTask;
    List<Player> viewer;
    Component message;
    TimerPhase timerPhase;
    int red, blue, green;

    public void start(){
        if(isActive){
            return;
        }
        isActive = true;
        task = new swTick(this).runTaskTimer(LionSystems.getPlugin(), 1, 20);
        colorTask = new colorTick(this).runTaskTimer(LionSystems.getPlugin(), 1, 1);
        timerPhase = TimerPhase.RedToGreen;
    }
    public void pause(){
        if(!isActive){
            return;
        }
        task.cancel();
        for(Player p : viewer){
            p.sendActionBar(Component.text("Timer paused", TextColor.color(255, 0, 255)));
        }
        isActive = false;
    }
    public void tick(){
        seconds++;
        if(seconds>=60){
            seconds = 0;
            minutes++;
            if(minutes>=60){
                minutes=0;
                hours++;
                if(hours>=24){
                    hours=0;
                    days++;
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
        for(Player p : viewer){
            p.sendActionBar(message);
        }
    }

    public stopwatch(int days, int hours, int minutes, int seconds) {
        isActive = false;
        this.days = days;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        viewer = new ArrayList<>();
    }
    public stopwatch() {
        isActive = false;
        this.days = 0;
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
        viewer = new ArrayList<>();
    }


    public void addViewer(Player p){
        if (p!=null) {
            viewer.add(p);
        }
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

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
}
