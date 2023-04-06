package com.codecool.marsexploration.helpers;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class MapFileSelector {
    public static String select() {
        JFileChooser fileChooser = new JFileChooser("C:\\Projects\\OOP\\Week 5\\mars-exploration-3-java-AlinDedu\\src\\main\\resources");
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
