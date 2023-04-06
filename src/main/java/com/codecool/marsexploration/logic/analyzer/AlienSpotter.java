package com.codecool.marsexploration.logic.analyzer;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Outcome;

import java.util.Optional;
import java.util.Random;

public class AlienSpotter implements Analyzer{
    @Override
    public Optional<Outcome> analyze(Context context) {
        int aliens = context.getRovers().get(0).getSpottedAliens().size();
        if (aliens >= 1) {
            Random random = new Random();
            if (random.nextDouble() >= 0.5) {
                return Optional.of(Outcome.FRIENDLY_ALIENS);
            }
            return Optional.of(Outcome.NOT_COLONIZABLE_ALIENS);
        }
        return Optional.empty();
    }
}
