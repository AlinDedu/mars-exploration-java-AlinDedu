package com.codecool.marsexploration.helpers;

import com.codecool.marsexploration.data.*;
import com.codecool.marsexploration.logic.analyzer.*;
import com.codecool.marsexploration.logic.phase.*;
import com.codecool.marsexploration.logic.routine.RandomExplorationRoutine;

import java.sql.Connection;
import java.util.List;

public class Initializer {
    public static Context explorationInit(SimulationInput input) {
        String[] mapName = input.mapPath().split("/");
        String nameWithoutExtension = mapName[mapName.length -1].split("\\.")[0];
        Connection connection = Database.init(nameWithoutExtension);
        Rover rover = new Rover("Rover-1", input.landing(), input.roverSight());
        rover.setRoutine(new RandomExplorationRoutine());
        rover.addPhase(new Movement());
        rover.addPhase(new Scan());
        rover.addPhase(new Analysis());
        rover.addPhase(new Log());
        rover.addPhase(new StepIncrement());

        rover.addAnalyzer(new LackOfResourcesAnalyzer());
        rover.addAnalyzer(new TimeoutAnalyzer());

        Symbol[][] map = new MapReader(input.mapPath()).getArray();
        Context context = new Context(connection, 0, input.timeout(), map, input.landing(), input.logPath(), input.resourcesRequired(), nameWithoutExtension);
        context.addRover(rover);
        return context;
    }
    public static SimulationInput input() {
        String fileName = MapFileSelector.select();
        Configuration config = ConfigurationDialog.getConfig();

        if (fileName != null && config != null) {
            String nameWithoutExtension = fileName.substring(0, fileName.lastIndexOf((".")));
            return new SimulationInput(
                    "src/main/resources/" + fileName,
                    new Coordinate(config.getLandingX(), config.getLandingY()),
                    config.getTimeout(),
                    "src/main/resources/" + nameWithoutExtension + ".log",
                    config.getRoverSight(),
                    config.getResourcesRequired());
        }
        return null;
    }
}
