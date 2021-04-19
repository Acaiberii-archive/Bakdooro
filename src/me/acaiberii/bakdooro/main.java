package me.acaiberii.bakdooro;

import me.acaiberii.bakdooro.listeners.chat;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
    @Override
    public void onEnable() {
        try {
            new chat().wait();
        } catch (InterruptedException e) {

        }
    }
    @Override
    public void onDisable() {

    }
}
