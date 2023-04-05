package com.codecool.marsexploration.helpers;

import com.codecool.marsexploration.data.Symbol;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MapReader {
    private Symbol[][] array;
    private int numRows;
    private int numCols;

    public MapReader(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null) {
                if (numCols == 0) {
                    numCols = line.length();
                }
                numRows++;
            }
            reader.close();

            array = new Symbol[numRows][numCols];
            reader = new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null) {
                for (int col = 0; col < numCols; col++) {
                    String c = String.valueOf(line.charAt(col));
                    array[row][col] = SymbolFinder.findSymbol(c);
                    System.out.print(c);
                }
                System.out.println();
                row++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Symbol[][] getArray() {
        return array;
    }
}
