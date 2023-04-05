package com.codecool.marsexploration.logic.routine;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;

import java.util.List;

public class ReturningRoutine implements Routine{
    @Override
    public void move(Context context) {
        List<Coordinate> history = context.getRover().getExploredCoordinates();
        context.getRover().setPosition(history.get((history.size() - 1 - context.getStepNumber())));
    }
}
