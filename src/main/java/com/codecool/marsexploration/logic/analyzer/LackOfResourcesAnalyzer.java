package com.codecool.marsexploration.logic.analyzer;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Outcome;

import java.util.Optional;

public class LackOfResourcesAnalyzer implements Analyzer{
    @Override
    public Optional<Outcome> analyze(Context context) {
        int resourcesCount = context.getRovers().get(0).getInterestingCoordinates().size();
        int stepNumber = context.getStepNumber();
        float remainingSteps = (context.getTimeout() - stepNumber);
        int resourcesLeftToFind = context.getResourcesRequired() - resourcesCount;
        double rate  = 0.25;
        if ((remainingSteps > (context.getTimeout()*0.1)) && (remainingSteps < (context.getTimeout()*0.7)) && resourcesLeftToFind > (rate * remainingSteps)) {
            return Optional.of(Outcome.NOT_COLONIZABLE_RESOURCES);
        }

        return Optional.empty();
    }
}
