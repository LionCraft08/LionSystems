package me.yourname.lionsystems.utilities;

import org.bukkit.scheduler.BukkitRunnable;

public class timerTick extends BukkitRunnable {
    @Override
    public void run() {
        if(!timer.isActive()){
            this.cancel();
        }else {
            timer.tick();
        }
    }
    timer timer;

    public timerTick(me.yourname.lionsystems.utilities.timer timer) {
        this.timer = timer;
    }
}
