package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Rover;
import com.codecool.marsexploration.helpers.Initializer;
import com.codecool.marsexploration.helpers.LogDialog;
import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.SimulationInput;
import com.codecool.marsexploration.logic.phase.*;
import com.codecool.marsexploration.logic.routine.GoToAlienRoutine;
import com.codecool.marsexploration.logic.routine.ReturningRoutine;

import java.util.Random;

public class ExplorationSimulator {

    public Context simulate() {
        SimulationInput input2 = Initializer.input();
        if (input2 != null) {
            Context context = Initializer.explorationInit(input2);
            Rover rover = context.getRovers().get(0);
            Random random = new Random();
            while(context.getOutcome() == null && context.getStepNumber() < random.nextInt(50)) {
                for (Phase phase : context.getRovers().get(0).getPhases()) {
                    phase.perform(context, context.getRovers().get(0));
                }
            }

            if (context.getRovers().get(0).getSpottedAliens().size() > 1) {
                context.getRovers().get(0).setRoutine(new GoToAlienRoutine());
            }

            if (context.getOutcome() != null) {
                context.getRovers().get(0).setRoutine(new ReturningRoutine());
                int steps = context.getStepNumber();
                context.setStepNumber(0);

                while(context.getStepNumber() < steps) {
                    context.getRovers().get(0).getRoutine().move(context, rover);
                    context.setStepNumber(context.getStepNumber() + 1);
                }
            }
            LogDialog.show(context.getLogFilePath());
            return context;
        } else {
            System.out.print("No simulation initiated.\nMake sure you selected a map, and provided all config data");
        }
        return null;
    }
}
