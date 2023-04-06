package com.codecool.marsexploration.logic.routine;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Outcome;
import com.codecool.marsexploration.data.Rover;
import com.codecool.marsexploration.logic.Finder;

import java.util.List;
import java.util.Random;

public class RandomExplorationRoutine implements Routine {
    @Override
    public void move(Context context, Rover rover) {
        Coordinate roverPosition = rover.getPosition();
        List<Coordinate> neighbors = Finder.findSpot(roverPosition, context.getMap().length, 1);
        Coordinate newRoverPosition  = neighbors.get(new Random().nextInt(neighbors.size()));
        if (context.getStepNumber() == 0) {
            rover.addExploredCoordinates(context.getLandingCoordinate());
            rover.setPosition(context.getLandingCoordinate());
        } else {
            rover.addExploredCoordinates(newRoverPosition);
            rover.setPosition(newRoverPosition);
        }
    }
}

