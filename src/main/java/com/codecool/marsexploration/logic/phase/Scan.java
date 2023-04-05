package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Symbol;
import com.codecool.marsexploration.logic.Finder;

import java.util.List;

public class Scan implements Phase{
    @Override
    public void perform(Context context) {
        Coordinate roverPosition = context.getRover().getPosition();
        List<Coordinate> neighbors = Finder.find(roverPosition, context.getRover().getInterestingCoordinates(), context.getMap().length, context.getRover().getSight());
        for (Coordinate coordinate : neighbors) {
            Symbol symbol = context.getMap()[coordinate.x()][coordinate.y()];
            if (symbol == Symbol.MINERAL || symbol == Symbol.WATER) {
                if (!context.getRover().getInterestingCoordinates().contains(coordinate))
                    context.getRover().addInterestingCoordinates(coordinate);
            } else if (symbol == Symbol.ALIEN) {
                if (!context.getRover().getSpottedAliens().contains(coordinate))
                    context.getRover().addSpottedAliens(coordinate);
            }
        }
    }
}
