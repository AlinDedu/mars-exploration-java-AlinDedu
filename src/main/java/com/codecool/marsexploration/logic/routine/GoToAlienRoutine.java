package com.codecool.marsexploration.logic.routine;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;

import java.util.List;
import java.util.Random;

public class GoToAlienRoutine implements Routine{
    @Override
    public void move(Context context) {
        List<Coordinate> spottedAliens = context.getRover().getSpottedAliens();
        Random random = new Random();
        Coordinate alienPosition = spottedAliens.get(random.nextInt(spottedAliens.size()));
        context.getRover().setPosition(alienPosition);
    }
}
