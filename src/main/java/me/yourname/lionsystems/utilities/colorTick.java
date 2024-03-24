package me.yourname.lionsystems.utilities;

import org.bukkit.scheduler.BukkitRunnable;

public class colorTick extends BukkitRunnable {
    @Override
    public void run() {
        if(timer!=null){
            timer.colorTick();
        } else if (stopwatch!=null) {
            stopwatch.colorTick();
        }
    }
    timer timer;
    stopwatch stopwatch;

    public colorTick(me.yourname.lionsystems.utilities.timer timer) {
        this.timer = timer;
    }

    public colorTick(me.yourname.lionsystems.utilities.stopwatch stopwatch) {
        this.stopwatch = stopwatch;
    }
}
