package com.codecool.marsexploration.logic.routine;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Rover;

public class ExtractionRoutine implements Routine{
    @Override
    public void move(Context context, Rover rover) {
        Coordinate roverPosition = rover.getPosition();
        Coordinate roverTarget = rover.getTarget();
        int xDiff = roverTarget.x() - roverPosition.x();
        int yDiff = roverTarget.y() - roverPosition.y();

        int newX = roverPosition.x() + Integer.signum(xDiff);
        int newY = roverPosition.y() + Integer.signum(yDiff);

        rover.setPosition(new Coordinate(newX, newY));
    }
}
