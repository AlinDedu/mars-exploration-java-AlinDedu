package com.codecool.marsexploration.helpers;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Symbol;

import java.util.ArrayList;
import java.util.List;

public class AreaScanner {
    public static List<Coordinate> scanAroundForMinerals(Symbol[][] map, Coordinate coordinate, int radius) {
        List<Coordinate> mineralsCoordinates = new ArrayList<>();
        for (int i = Math.max(0, coordinate.x() - radius); i < Math.min(map.length - 1, coordinate.x() + radius); i++) {
            for (int j = Math.max(0, coordinate.y() - radius); j <= Math.min(map[0].length - 1, coordinate.y() + radius); j++) {
                // Do something with the cell (i, j) on the map
                Symbol cellValue = map[i][j];
                if (cellValue.equals(Symbol.MINERAL)) {
                    mineralsCoordinates.add(new Coordinate(i, j));
                }
            }
        }
        return mineralsCoordinates;
    }
}
