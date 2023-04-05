package com.codecool.marsexploration.helpers;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class MapFileSelector {
    public static String select() {
        JFileChooser fileChooser = new JFileChooser("C:\\Projects\\Learning\\mars-exploration-2-java-pilatdenis99\\src\\main\\resources");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Map Files", "map"));
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getName());
            return selectedFile.getName();
        }
        return null;
    }
}
