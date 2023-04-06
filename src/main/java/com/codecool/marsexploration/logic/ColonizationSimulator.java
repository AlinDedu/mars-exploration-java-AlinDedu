package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.*;
import com.codecool.marsexploration.helpers.AreaScanner;
import com.codecool.marsexploration.logic.analyzer.Analyzer;
import com.codecool.marsexploration.logic.analyzer.ColonizationAnalyzer;
import com.codecool.marsexploration.logic.analyzer.TimeoutAnalyzer;
import com.codecool.marsexploration.logic.phase.*;
import com.codecool.marsexploration.logic.routine.ExtractionRoutine;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class ColonizationSimulator {
    public void simulate(Context context) {
        System.out.println("\nStarting colonization!\n");
        Random random = new Random();
        context.setOutcome(null);
        List<Rover> roverList = context.getRovers();
        Rover rover1 = roverList.get(0);
        rover1.setRoutine(new ExtractionRoutine());

        CommandCenter commandCenter = new CommandCenter(1, rover1.getPosition(), Status.ACTIVE, 0);
        context.addCommandCenter(commandCenter);
        commandCenter.setResourcesCoordinates(AreaScanner.scanAroundForMinerals(context.getMap(), commandCenter.getLocation(), 10));
        Coordinate resCoordinate = commandCenter.getResourceCoordinate(random.nextInt(commandCenter.getResourcesCoordinates().size()));

        rover1.setResCoordinate(resCoordinate);
        commandCenter.removeResourceCoordinate(resCoordinate);
        rover1.setCommandCenterCoordinate(commandCenter.getLocation());

        rover1.resetAnalyzers();
        rover1.resetPhase();

        rover1.addAnalyzer(new TimeoutAnalyzer());

        rover1.addPhase(new Movement());
        rover1.addPhase(new Analysis());
        rover1.addPhase(new Log());

        rover1.setTarget(rover1.getResCoordinate());

        while(context.getOutcome() == null) {
            Analyzer colonizationAnalyzer = new ColonizationAnalyzer();
            Optional<Outcome> colonizationOutcome = colonizationAnalyzer.analyze(context);
            colonizationOutcome.ifPresent(context::setOutcome);
            if (context.getOutcome() != null) {
                for (Rover rover : context.getRovers()) {
                    rover.resetAnalyzers();
                    rover.resetPhase();
                }
                rover1.addPhase(new Log());
            }
            context.setStepNumber(context.getStepNumber()+1);
            if (commandCenter.hasEnoughResources(5) && commandCenter.getResourcesCoordinates().size() > 0) {
                int newRoverId = context.getRovers().size() + 1;
                Rover newRover = new Rover("Rover-" + newRoverId, commandCenter.getLocation(), 3);
                newRover.setCommandCenterCoordinate(commandCenter.getLocation());

                newRover.setRoutine(new ExtractionRoutine());

                newRover.addAnalyzer(new TimeoutAnalyzer());

                newRover.addPhase(new Movement());
                newRover.addPhase(new Analysis());
                newRover.addPhase(new Log());

                Coordinate newResCoordinate = commandCenter.getResourceCoordinate(new Random().nextInt(commandCenter.getResourcesCoordinates().size()));
                newRover.setResCoordinate(newResCoordinate);
                newRover.setTarget(newResCoordinate);
                commandCenter.removeResourceCoordinate(newResCoordinate);

                context.addRover(newRover);
                commandCenter.removeResource(5);
            }
            for (Rover rover : roverList) {
                for (Phase phase : rover.getPhases()) {
                    phase.perform(context, rover);
                }
                if (rover.getPosition().equals(rover.getTarget())) {
                    if (rover.getTarget().equals(rover.getCommandCenterCoordinate())) {
                        rover.setTarget(rover.getResCoordinate());
                        rover.setEvent("Position");
                        commandCenter.addResource(1);
                    }
                    else if (rover.getTarget().equals(rover.getResCoordinate())) {
                        rover.setTarget(rover.getCommandCenterCoordinate());
                        rover.setEvent("Delivery");
                    }
                }
                if (context.getOutcome() == null)
                    System.out.println("        Resources on stock: " + commandCenter.getResourcesOnStock());
            }
            if (commandCenter.getResourcesCoordinates().size() == 0 && commandCenter.getResourcesOnStock() >= 25) {
                CommandCenter newCommandCenter = new CommandCenter(2, new Coordinate(random.nextInt(context.getMap().length), random.nextInt(context.getMap()[0].length)), Status.ACTIVE, 0);
                context.addCommandCenter(newCommandCenter);
                commandCenter.removeResource(25);
            }
            System.out.println("----------------------------------------------------------");
        }
    }
}
