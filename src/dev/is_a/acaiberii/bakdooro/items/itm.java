package dev.is_a.acaiberii.bakdooro.items;

import dev.is_a.acaiberii.bakdooro.game.server;
import dev.is_a.acaiberii.bakdooro.main;
import org.bukkit.plugin.Plugin;

public class itm {
    public static String[] hacks = {"Fly", "KillAura", "Speed", "FastInteract", "BadPacket", "Backdoor", "DDoS", "SlowPacket", "Anticheat Bypass", "Unknown"};
    public static Object[] players = server.srv.getOnlinePlayers().toArray();
    public static Plugin thispl = new main();
}
