package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Rover;
import com.codecool.marsexploration.data.Symbol;
import com.codecool.marsexploration.logic.Finder;

import java.util.List;

public class Scan implements Phase{
    @Override
    public void perform(Context context, Rover rover) {
        Coordinate roverPosition = rover.getPosition();
        List<Coordinate> neighbors = Finder.find(roverPosition, rover.getInterestingCoordinates(), context.getMap().length, rover.getSight());
        for (Coordinate coordinate : neighbors) {
            Symbol symbol = context.getMap()[coordinate.x()][coordinate.y()];
            if (symbol == Symbol.MINERAL || symbol == Symbol.WATER) {
                if (!rover.getInterestingCoordinates().contains(coordinate))
                    rover.addInterestingCoordinates(coordinate);
            } else if (symbol == Symbol.ALIEN) {
                if (!rover.getSpottedAliens().contains(coordinate))
                    rover.addSpottedAliens(coordinate);
            }
        }
    }
}
