package com.github.games647.scoreboardstats.listener;

public final class EntityListener implements org.bukkit.event.Listener {

    @org.bukkit.event.EventHandler
    public void onMobDeath(final org.bukkit.event.entity.EntityDeathEvent event) {
        final org.bukkit.entity.LivingEntity entity = event.getEntity();
        final org.bukkit.entity.Player killer = entity.getKiller();

        if (com.github.games647.scoreboardstats.ScoreboardStats.getSettings().checkWorld(entity.getWorld().getName())
                || entity.getType().equals(org.bukkit.entity.EntityType.PLAYER)
                || killer == null
                || !killer.isOnline()) {
            return;
        }

        final com.github.games647.scoreboardstats.pvpstats.PlayerCache killercache = com.github.games647.scoreboardstats.pvpstats.Database.getCache(killer.getName());
        
        if (killercache != null) {
            killercache.increaseMob();
        }
    }
}