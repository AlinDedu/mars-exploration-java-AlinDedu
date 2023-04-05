package com.codecool.marsexploration.data;

import java.sql.Connection;

public class Context {
    private int stepNumber;
    private final long timeout;
    private final Symbol[][] map;
    private final Coordinate landingCoordinate;
    private final Rover rover;
    private Outcome outcome;
    private final String logFilePath;
    private final int resourcesRequired;
    private final Connection connection;
    private final String mapNameWithoutExtension;

    public Context(Connection connection, int stepNumber, long timeout, Symbol[][] map, Coordinate landingCoordinate, Rover rover, String logFilePath, int resourcesRequired, String mapNameWithoutExtension) {
        this.connection = connection;
        this.stepNumber = stepNumber;
        this.timeout = timeout;
        this.map = map;
        this.landingCoordinate = landingCoordinate;
        this.rover = rover;
        this.logFilePath = logFilePath;
        this.outcome = null;
        this.resourcesRequired = resourcesRequired;
        this.mapNameWithoutExtension = mapNameWithoutExtension;
    }

    public int getStepNumber() {
        return stepNumber;
    }
    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }
    public long getTimeout() {
        return timeout;
    }
    public Symbol[][] getMap() {
        return map;
    }
    public Coordinate getLandingCoordinate() {
        return landingCoordinate;
    }
    public Rover getRover() {
        return rover;
    }
    public Outcome getOutcome() {
        return outcome;
    }
    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }
    public String getLogFilePath() {
        return logFilePath;
    }
    public int getResourcesRequired() {
        return resourcesRequired;
    }
    public Connection getConnection() {
        return connection;
    }
    public String getMapNameWithoutExtension() {
        return mapNameWithoutExtension;
    }
}
