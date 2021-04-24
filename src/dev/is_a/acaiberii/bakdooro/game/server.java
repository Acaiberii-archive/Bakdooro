package dev.is_a.acaiberii.bakdooro.game;

import dev.is_a.acaiberii.bakdooro.listeners.chat;
import org.bukkit.Server;
import org.bukkit.event.Listener;

import static org.bukkit.Bukkit.*;

public class server {
    public static Server srv = getServer();
    public static Listener lst = new chat();
}
