package com.codecool.marsexploration.logic.analyzer;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Outcome;

import java.util.Optional;

public class SuccessAnalyzer implements Analyzer{
    @Override
    public Optional<Outcome> analyze(Context context) {
        int resourcesCount = context.getRovers().get(0).getInterestingCoordinates().size();
        int stepNumber = context.getStepNumber();
        if (resourcesCount >= context.getResourcesRequired()
                || ((resourcesCount >= (context.getResourcesRequired()*0.5)) && (stepNumber <= context.getTimeout()*0.1))) {
            return Optional.of(Outcome.COLONIZABLE);
        }
        return Optional.empty();
    }
}
