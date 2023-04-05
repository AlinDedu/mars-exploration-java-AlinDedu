package com.codecool.marsexploration.data;

public record SimulationInput(String mapPath, Coordinate landing, long timeout, String logPath, String roverName, int roverSight, int resourcesRequired) {
}
