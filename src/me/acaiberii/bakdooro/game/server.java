package me.acaiberii.bakdooro.game;

import org.bukkit.Server;
import org.bukkit.event.Listener;

import static org.bukkit.Bukkit.*;

public class server {
    public static Server srv = getServer();
    public static Listener lst = new me.acaiberii.bakdooro.listeners.chat();
}
