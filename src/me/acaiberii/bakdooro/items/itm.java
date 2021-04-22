package me.acaiberii.bakdooro.items;

import me.acaiberii.bakdooro.main;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import static me.acaiberii.bakdooro.game.server.srv;

public class itm {
    public static String[] hacks = {"Fly", "KillAura", "Speed", "FastInteract", "BadPacket", "Backdoor", "DDoS", "SlowPacket", "Anticheat Bypass", "Unknown"};
    public static Object[] players = srv.getOnlinePlayers().toArray();
    public static Plugin thispl = new main();
}
