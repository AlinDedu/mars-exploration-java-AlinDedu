package com.codecool.marsexploration.helpers;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LogDialog {
    public static void show(String logPath) {
        String[] logString = readLogFile(logPath).split("\n");
        JOptionPane.showInternalMessageDialog(null, logString[logString.length-1]);

    }

    public static String readLogFile(String filename) {
        StringBuilder logStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                logStringBuilder.append(line);
                logStringBuilder.append("\n");
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        return logStringBuilder.toString();
    }
}
