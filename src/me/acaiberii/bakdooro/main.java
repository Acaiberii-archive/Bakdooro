package me.acaiberii.bakdooro;

import me.acaiberii.bakdooro.game.server;
import me.acaiberii.bakdooro.listeners.chat;
import me.acaiberii.bakdooro.util.util;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(me.acaiberii.bakdooro.game.server.lst, this);
    }
    @Override
    public void onDisable() {

    }
}
