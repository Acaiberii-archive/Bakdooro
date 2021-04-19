package me.acaiberii.bakdooro.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.HashSet;
import java.util.UUID;

public class chat {
    @EventHandler
    public void asyncChatEvent(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        UUID u = p.getUniqueId();
        String message = e.getMessage();
        e.setCancelled(true);
    }
}
