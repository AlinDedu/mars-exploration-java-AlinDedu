package com.codecool.marsexploration.data;

public class Configuration {
    private int landingX;
    private int landingY;
    private int timeout;
    private int roverSight;
    private int resourcesRequired;

    public Configuration(int landingX, int landingY, int timeout, int roverSight, int resourcesRequired) {
        this.landingX = landingX;
        this.landingY = landingY;
        this.timeout = timeout;
        this.roverSight = roverSight;
        this.resourcesRequired = resourcesRequired;
    }

    public int getLandingX() {
        return landingX;
    }

    public int getLandingY() {
        return landingY;
    }

    public int getTimeout() {
        return timeout;
    }

    public int getRoverSight() {
        return roverSight;
    }

    public int getResourcesRequired() {
        return resourcesRequired;
    }
}
