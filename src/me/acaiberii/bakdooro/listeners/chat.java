package me.acaiberii.bakdooro.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.HashSet;
import java.util.UUID;

public class chat {
    private HashSet<UUID> players = new HashSet<UUID>();
    @EventHandler
    public void asyncChatEvent(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        UUID u = p.getUniqueId();
        if(players.contains(u)) {
            String message = e.getMessage();
            players.remove(u);
            e.setCancelled(true);
        }
    }
}
