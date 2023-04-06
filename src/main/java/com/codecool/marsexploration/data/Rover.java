package com.codecool.marsexploration.data;

import com.codecool.marsexploration.logic.analyzer.Analyzer;
import com.codecool.marsexploration.logic.phase.Phase;
import com.codecool.marsexploration.logic.routine.Routine;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Rover {
    private final String id;
    private Coordinate position;
    private final int sight;
    private Routine routine;
    private List<Phase> phases;
    private List<Analyzer> analyzers;
    private final List<Coordinate> exploredCoordinates;
    private final List<Coordinate> interestingCoordinates;
    private final List<Coordinate> spottedAliens;
    private Coordinate target;
    private Coordinate resCoordinate;
    private Coordinate commandCenterCoordinate;
    private String event;

    public Rover(String id, Coordinate position, int sight) {
        this.id = id;
        this.position = position;
        this.sight = sight;
        this.phases = new ArrayList<>();
        this.analyzers = new ArrayList<>();
        this.exploredCoordinates = new ArrayList<>();
        this.interestingCoordinates = new ArrayList<>();
        this.spottedAliens = new ArrayList<>();
        this.routine = null;
        this.target = null;
        this.resCoordinate = null;
        this.commandCenterCoordinate = null;
        this.event = "Position";
    }
    public String getId() {
        return id;
    }
    public Coordinate getPosition() {
        return position;
    }
    public void setPosition(Coordinate position) {
        this.position = position;
    }
    public int getSight() {
        return sight;
    }
    public Routine getRoutine() {
        return routine;
    }
    public void setRoutine(Routine routine) {
        this.routine = routine;
    }
    public List<Coordinate> getExploredCoordinates() {
        return exploredCoordinates;
    }
    public void addExploredCoordinates(Coordinate coordinate) {
        this.exploredCoordinates.add(coordinate);
    }
    public List<Coordinate> getInterestingCoordinates() {
        return interestingCoordinates;
    }
    public void addInterestingCoordinates(Coordinate coordinate) {
        this.interestingCoordinates.add(coordinate);
    }
    public List<Phase> getPhases() {
        return phases;
    }
    public void resetPhase() {
        this.phases = new ArrayList<>();
    }
    public void addPhase(Phase phase) {
        this.phases.add(phase);
    }
    public List<Analyzer> getAnalyzers() {
        return analyzers;
    }
    public void resetAnalyzers() {
        this.analyzers = new ArrayList<>();
    }
    public void addAnalyzer(Analyzer analyzers) {
        this.analyzers.add(analyzers);
    }
    public List<Coordinate> getSpottedAliens() {
        return spottedAliens;
    }
    public void addSpottedAliens(Coordinate spottedAliens) {
        this.spottedAliens.add(spottedAliens);
    }
    public Coordinate getTarget() {
        return target;
    }
    public void setTarget(Coordinate target) {
        this.target = target;
    }

    public Coordinate getResCoordinate() {
        return resCoordinate;
    }

    public void setResCoordinate(Coordinate resCoordinate) {
        this.resCoordinate = resCoordinate;
    }

    public Coordinate getCommandCenterCoordinate() {
        return commandCenterCoordinate;
    }

    public void setCommandCenterCoordinate(Coordinate commandCenterCoordinate) {
        this.commandCenterCoordinate = commandCenterCoordinate;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
