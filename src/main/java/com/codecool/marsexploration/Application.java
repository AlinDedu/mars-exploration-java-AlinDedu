package com.codecool.marsexploration;

import com.codecool.marsexploration.logic.ExplorationSimulator;

public class Application {
    public static void main(String[] args) {
        ExplorationSimulator simulator = new ExplorationSimulator();
        simulator.simulate();
    }
}
