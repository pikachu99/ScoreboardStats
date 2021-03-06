package com.github.games647.scoreboardstats.commands;

import com.github.games647.scoreboardstats.ScoreboardStats;
import com.github.games647.scoreboardstats.config.Lang;

import org.bukkit.command.CommandSender;

/**
 * Reload the plugin and the components
 */
public class ReloadCommand extends CommandHandler {

    public ReloadCommand(ScoreboardStats plugin) {
        super("reload", "&aReloads the config", plugin);
    }

    @Override
    public void onCommand(CommandSender sender, String subCommand, String... args) {
        plugin.onReload();
        sender.sendMessage(Lang.get("onReload"));
    }
}
