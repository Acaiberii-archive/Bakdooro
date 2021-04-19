package me.acaiberii.bakdooro.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.io.IOException;
import java.util.HashSet;
import java.util.UUID;

public class chat implements Listener {
    @EventHandler
    public static void asyncChatEvent(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        UUID u = p.getUniqueId();
        String message = e.getMessage();
        e.setCancelled(true);
        me.acaiberii.bakdooro.util.handler.chathandler.handler(p, message);
    }
}
