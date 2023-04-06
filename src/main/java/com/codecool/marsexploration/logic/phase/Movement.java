package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Rover;

public class Movement implements Phase{
    @Override
    public void perform(Context context, Rover rover) {
        rover.getRoutine().move(context, rover);
    }
}
