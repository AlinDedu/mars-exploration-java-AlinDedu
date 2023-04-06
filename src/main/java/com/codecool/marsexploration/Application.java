package com.codecool.marsexploration;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Outcome;
import com.codecool.marsexploration.logic.ColonizationSimulator;
import com.codecool.marsexploration.logic.ExplorationSimulator;

import java.util.Optional;


public class Application {
    public static void main(String[] args) {
        ExplorationSimulator explorationSimulator = new ExplorationSimulator();
        Context explorationContext = explorationSimulator.simulate();
        if (explorationContext != null && explorationContext.getOutcome() == null) {
            ColonizationSimulator colonizationSimulator = new ColonizationSimulator();
            colonizationSimulator.simulate(explorationContext);
        }
    }
}