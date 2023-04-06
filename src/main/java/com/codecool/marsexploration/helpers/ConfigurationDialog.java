package com.codecool.marsexploration.helpers;

import com.codecool.marsexploration.data.Configuration;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ConfigurationDialog {
    public static Configuration getConfig() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel landingLabel = new JLabel("Landing Coordinates:");
        landingLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(landingLabel);

        JPanel landingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField landingXField = new JTextField(5);
        landingPanel.add(new JLabel("X: "));
        landingPanel.add(landingXField);
        JTextField landingYField = new JTextField(5);
        landingPanel.add(new JLabel("Y: "));
        landingPanel.add(landingYField);
        landingPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(landingPanel);

        JLabel timeoutLabel = new JLabel("Timeout (maximum steps until rover stops):");
        timeoutLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(Box.createVerticalStrut(10));
        panel.add(timeoutLabel);
        JTextField timeoutField = new JTextField(10);
        timeoutField.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(timeoutField);

        JLabel roverSightLabel = new JLabel("Rover Sight:");
        roverSightLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(Box.createVerticalStrut(10));
        panel.add(roverSightLabel);
        JTextField roverSightField = new JTextField(10);
        roverSightField.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(roverSightField);

        JLabel resourcesRequiredLabel = new JLabel("Resources required for colonization:");
        resourcesRequiredLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(Box.createVerticalStrut(10));
        panel.add(resourcesRequiredLabel);
        JTextField resourcesRequiredField = new JTextField(10);
        resourcesRequiredField.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(resourcesRequiredField);

        UIManager.put("OptionPane.background", Color.lightGray);

        int result = JOptionPane.showConfirmDialog(null, panel, "Mars Exploration", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            int landingX = Integer.parseInt(landingXField.getText());
            int landingY = Integer.parseInt(landingYField.getText());
            int timeout = Integer.parseInt(timeoutField.getText());
            int roverSight = Integer.parseInt(roverSightField.getText());
            int resourcesRequired = Integer.parseInt(resourcesRequiredField.getText());

            return new Configuration(landingX, landingY, timeout, roverSight, resourcesRequired);
        }

        return null;
    }
}
