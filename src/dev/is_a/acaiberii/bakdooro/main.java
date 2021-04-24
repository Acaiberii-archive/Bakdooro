package dev.is_a.acaiberii.bakdooro;

import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(dev.is_a.acaiberii.bakdooro.game.server.lst, this);
    }
    @Override
    public void onDisable() {

    }
}
