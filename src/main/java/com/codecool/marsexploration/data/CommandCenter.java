package com.codecool.marsexploration.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommandCenter {
    private final int id;
    private Coordinate location;
    private Status status;
    private int resourcesOnStock;
    private List<Coordinate> resourcesCoordinates;

    public CommandCenter(int id, Coordinate location, Status status, int resourcesOnStock) {
        this.id = id;
        this.location = location;
        this.status = status;
        this.resourcesOnStock = resourcesOnStock;
        this.resourcesCoordinates = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public Coordinate getLocation() {
        return location;
    }

    public void setLocation(Coordinate location) {
        this.location = location;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getResourcesOnStock() {
        return resourcesOnStock;
    }

    public void setResourcesOnStock(int resourcesOnStock) {
        this.resourcesOnStock = resourcesOnStock;
    }
    public void addResource(int amount) {
       resourcesOnStock += amount;
    }

    public void removeResource(int amount) {
        resourcesOnStock -= amount;
    }

    public boolean hasEnoughResources(int requiredResources) {
        return resourcesOnStock >= requiredResources;
    }

    public List<Coordinate> getResourcesCoordinates() {
        return resourcesCoordinates;
    }

    public Coordinate getResourceCoordinate(int index) {
        return resourcesCoordinates.get(index);
    }
    public void setResourcesCoordinates(List<Coordinate> resourcesCoordinates) {
        this.resourcesCoordinates = resourcesCoordinates;
    }

    public void removeResourceCoordinate(Coordinate coordinate) {
        resourcesCoordinates.remove(coordinate);
    }
}
