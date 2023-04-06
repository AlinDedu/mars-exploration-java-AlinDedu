package com.codecool.marsexploration.data;

import java.util.Map;

public class Construction {
    private final String id;
    private final int requiredResources;
    private CommandCenter commandCenter;
    private int step;
    private boolean isCompleted;

    public Construction(String id, int requiredResources) {
        this.id = id;
        this.requiredResources = requiredResources;
        this.commandCenter = null;
        this.step = 0;
        this.isCompleted = false;
    }

    public String getId() {
        return id;
    }

    public int getRequiredResources() {
        return requiredResources;
    }

    public void assignCommandCenter(CommandCenter commandCenter) {
        this.commandCenter = commandCenter;
    }

    public CommandCenter getCommandCenter() {
        return commandCenter;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getStep() {
        return step;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

//    public void removeResources(Map<ResourceType, Integer> resources) {
//        for (ResourceType resourceType : resources.keySet()) {
//            int requiredQuantity = requiredResources.get(resourceType);
//            int availableQuantity = resources.get(resourceType);
//
//            int remainingQuantity = requiredQuantity - availableQuantity;
//            if (remainingQuantity <= 0) {
//                requiredResources.remove(resourceType);
//            } else {
//                requiredResources.put(resourceType, remainingQuantity);
//            }
//        }
//    }
//
//    public void complete() {
//        isCompleted = true;
//        commandCenter.addCompletedConstruction(this);
//    }
}
