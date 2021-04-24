package dev.is_a.acaiberii.bakdooro.listeners;

import dev.is_a.acaiberii.bakdooro.util.handler.chathandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.UUID;

public class chat implements Listener {
    @EventHandler
    public static void asyncChatEvent(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        UUID u = p.getUniqueId();
        String message = e.getMessage();
        chathandler.handler(p, message, e);
    }
}
