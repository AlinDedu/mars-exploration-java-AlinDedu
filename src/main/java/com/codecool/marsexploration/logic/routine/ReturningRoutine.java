package com.codecool.marsexploration.logic.routine;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Rover;

import java.util.List;

public class ReturningRoutine implements Routine{
    @Override
    public void move(Context context, Rover rover) {
        List<Coordinate> history = rover.getExploredCoordinates();
        rover.setPosition(history.get((history.size() - 1 - context.getStepNumber())));
    }
}
