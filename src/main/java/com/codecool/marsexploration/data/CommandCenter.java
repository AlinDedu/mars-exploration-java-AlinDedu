package com.codecool.marsexploration.data;

import java.util.Map;

public class CommandCenter {
    private int id;
    private Location location;
    private Status status;
    private Map<Resource, Integer> resourcesOnStock;

    public CommandCenter(int id, Location location, Status status, Map<Resource, Integer> resourcesOnStock) {
        this.id = id;
        this.location = location;
        this.status = status;
        this.resourcesOnStock = resourcesOnStock;
    }

    public int getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Map<Resource, Integer> getResourcesOnStock() {
        return resourcesOnStock;
    }

    public void setResourcesOnStock(Map<Resource, Integer> resourcesOnStock) {
        this.resourcesOnStock = resourcesOnStock;
    }
    public void addResource(Resource resource, int amount) {
        if (resourcesOnStock.containsKey(resource)) {
            int currentAmount = resourcesOnStock.get(resource);
            resourcesOnStock.put(resource, currentAmount + amount);
        } else {
            resourcesOnStock.put(resource, amount);
        }
    }

    public void removeResource(Resource resource, int amount) {
        if (resourcesOnStock.containsKey(resource)) {
            int currentAmount = resourcesOnStock.get(resource);
            if (currentAmount >= amount) {
                resourcesOnStock.put(resource, currentAmount - amount);
            } else {
                throw new IllegalArgumentException("Not enough " + resource + " in stock!");
            }
        } else {
            throw new IllegalArgumentException("No " + resource + " in stock!");
        }
    }

    public boolean hasEnoughResources(Map<Resource, Integer> requiredResources) {
        for (Map.Entry<Resource, Integer> entry : requiredResources.entrySet()) {
            Resource resource = entry.getKey();
            int requiredAmount = entry.getValue();
            if (!resourcesOnStock.containsKey(resource) || resourcesOnStock.get(resource) < requiredAmount) {
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct(Construction construction) {
        return hasEnoughResources(construction.getRequiredResources());
    }

//    public void construct(Construction construction) {
//        if (canConstruct(construction)) {
//            construction.removeResources();
//            construction.complete();
//        } else {
//            throw new IllegalArgumentException("Not enough resources to construct " + construction);
//        }
//    }
//    public void addCompletedConstruction(Construction construction) {
//        int constructionCost = construction.getRequiredResources().getTotalResources();
//        stock.removeResources(construction.getRequiredResources());
//        completedConstructions.add(construction);
//        construction.setCompleted(true);
//        usedResources += constructionCost;
//    }

}
