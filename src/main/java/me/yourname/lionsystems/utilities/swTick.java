package me.yourname.lionsystems.utilities;

import org.bukkit.scheduler.BukkitRunnable;

public class swTick extends BukkitRunnable {
    @Override
    public void run() {
        sw.tick();
    }

    public swTick(stopwatch sw) {
        this.sw = sw;
    }

    stopwatch sw;
}
