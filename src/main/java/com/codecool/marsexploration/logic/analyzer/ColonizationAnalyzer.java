package com.codecool.marsexploration.logic.analyzer;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Outcome;

import java.util.Optional;

public class ColonizationAnalyzer implements Analyzer{
    @Override
    public Optional<Outcome> analyze(Context context) {
        if (context.getCommandCenters().size() > 1) {
            return Optional.of(Outcome.COLONIZED);
        }
        return Optional.empty();
    }
}
