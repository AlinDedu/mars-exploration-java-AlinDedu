package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class Finder {

    private static List<Coordinate> findNeighbors(Coordinate coordinate, int area, int sight){
            List<Coordinate> neighbors = new ArrayList<>();
            if (coordinate != null) {
                int x = coordinate.x(); int y = coordinate.y();

                // Add all neighbors to the list
                for (int i = -sight; i <= sight; i++){
                    for (int j = -sight; j <= sight; j++){
                        int newX = x+i;
                        int newY = y+j;
                        if(newX >= 0 && newY >= 0 && newX < area && newY < area)
                            neighbors.add(new Coordinate(x+i, y+j));
                    }
                }
            }
            return neighbors;
    }

    public static List<Coordinate> find(Coordinate coordinate, List<Coordinate> explored, int area, int sight) {
        return findNeighbors(coordinate, area, sight).stream()
                .filter(neighbor -> !explored.contains(neighbor))
                .toList();
    }

    public static List<Coordinate> findSpot(Coordinate coordinate, int area, int sight) {
        return findNeighbors(coordinate, area, sight).stream()
                .filter(spot -> !spot.equals(coordinate))
                .toList();
    }
}
