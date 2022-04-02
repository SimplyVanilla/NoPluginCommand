package net.simplyvanilla.nopluginscommand;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;

public final class NoPluginsCommand extends JavaPlugin implements Listener {

    private static final List<String> COMMANDS = Arrays.asList("?", "pl", "about", "version", "ver", "plugins", "bukkit:?", "bukkit:pl", "bukkit:about", "bukkit:version", "bukkit:ver", "bukkit:plugins", "minecraft:pl", "minecraft:plugins", "minecraft:about", "minecraft:version", "minecraft:ver");

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onCommandUse(PlayerCommandPreprocessEvent event) {
        String[] arrCommand = event.getMessage().toLowerCase().split(" ", 2);

        for (String command : COMMANDS) {
            if (arrCommand[0].equalsIgnoreCase("/" + command)) {
                event.setCancelled(true);
                return;
            }
        }
    }

}
