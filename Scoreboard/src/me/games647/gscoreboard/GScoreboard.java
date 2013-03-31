package me.games647.gscoreboard;

import java.util.List;
import me.games647.gscoreboard.api.PlayerStats;

public final class GScoreboard extends org.bukkit.plugin.java.JavaPlugin {

    @Override
    public void onEnable() {
        setupDatabase();
        this.getServer().getPluginManager().registerEvents(new me.games647.gscoreboard.listener.DeathListener(), this);
    }

    private void setupDatabase() {
        try {
            getDatabase().find(PlayerStats.class).findRowCount();
        } catch (javax.persistence.PersistenceException ex) {
            getLogger().info("Can't find a existing Database, so creating a new one");
            installDDL();
        }
        me.games647.gscoreboard.api.Database.setDatabase(getDatabase());
    }

    @Override
    public List<Class<?>> getDatabaseClasses() {

        final List<Class<?>> list = new java.util.ArrayList<Class<?>>(1);
        list.add(PlayerStats.class);

        return list;
    }

}
