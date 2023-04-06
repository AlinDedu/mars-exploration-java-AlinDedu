package com.codecool.marsexploration.logic.routine;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Rover;

import java.util.List;
import java.util.Random;

public class GoToAlienRoutine implements Routine{
    @Override
    public void move(Context context, Rover rover) {
        List<Coordinate> spottedAliens = rover.getSpottedAliens();
        Random random = new Random();
        Coordinate alienPosition = spottedAliens.get(random.nextInt(spottedAliens.size()));
        rover.setPosition(alienPosition);
    }
}
