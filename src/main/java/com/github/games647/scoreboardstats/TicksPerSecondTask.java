package com.github.games647.scoreboardstats;

/**
 * Tracks how many ticks are passed per second.
 */
public class TicksPerSecondTask implements Runnable {

    private static float lastTicks = 20.0F;

    /**
     * Get the ticks count of the last check. 20 Ticks should pass per second
     *
     * @return the ticks count of the last check
     */
    public static float getLastTicks() {
        return lastTicks;
    }

    //the last time we updated the ticks
    private long lastCheck;

    @Override
    public void run() {
        //nanoTime is more accurate
        long currentTime = System.nanoTime() ;
        long timeSpent = currentTime - lastCheck;
        //update the last check
        lastCheck = currentTime;

        //how many ticks passed since the last check * 1000 to convert to seconds
        float tps = 3 * 20 * 1000.0F / (timeSpent / (1_000 * 1_000));
        if (tps >= 0.0F && tps < 20.0F) {
            //Prevent all invalid values
            lastTicks = tps;
        }
    }
}
