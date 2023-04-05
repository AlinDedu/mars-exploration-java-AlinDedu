package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.helpers.Initializer;
import com.codecool.marsexploration.helpers.LogDialog;
import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.SimulationInput;
import com.codecool.marsexploration.logic.phase.*;
import com.codecool.marsexploration.logic.routine.GoToAlienRoutine;
import com.codecool.marsexploration.logic.routine.ReturningRoutine;

public class ExplorationSimulator {

    public void simulate() {
        SimulationInput input2 = Initializer.input();
        if (input2 != null) {
            Context context = Initializer.explorationInit(input2);
            while(context.getOutcome() == null) {
                for (Phase phase : context.getRover().getPhases()) {
                    phase.perform(context);
                }
            }

            if (context.getRover().getSpottedAliens().size() > 1) {
                context.getRover().setRoutine(new GoToAlienRoutine());
            }

            if (context.getOutcome() != null) {
                context.getRover().setRoutine(new ReturningRoutine());
                int steps = context.getStepNumber();
                context.setStepNumber(0);

                while(context.getStepNumber() < steps) {
                    context.getRover().getRoutine().move(context);
                    context.setStepNumber(context.getStepNumber() + 1);
                }
            }
            LogDialog.show(context.getLogFilePath());
        } else {
            System.out.print("No simulation initiated.\nMake sure you selected a map, and provided all config data");
        }
    }
}
