package me.acaiberii.bakdooro.commands.blatant;

import javax.swing.*;

public class blnt {
    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}