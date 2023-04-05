package com.codecool.marsexploration.logic.analyzer;

import com.codecool.marsexploration.helpers.SymbolFinder;
import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Outcome;
import com.codecool.marsexploration.data.Symbol;

import java.util.Optional;

public class LandingAnalyzer implements Analyzer{
    @Override
    public Optional<Outcome> analyze(Context context) {
            Coordinate landingPoint = context.getLandingCoordinate();
            int mapWidth = context.getMap().length;
            int mapHeight = context.getMap()[0].length;
            if (landingPoint.x() < 0 || landingPoint.y() < 0 || landingPoint.x() >= mapWidth || landingPoint.y() >= mapHeight) {
                // Landing coordinate is outside the map boundaries
                return Optional.of(Outcome.WRONG_LANDING_COORDINATES);
            }
            Symbol landingSymbol = SymbolFinder.findSymbol(context.getMap()[landingPoint.x()][landingPoint.y()].getSymbol());
            if (landingSymbol != Symbol.EMPTY) {
                // Landing coordinate is not empty
                return Optional.of(Outcome.WRONG_LANDING_COORDINATES);
            }
        // Landing coordinate is valid
        return Optional.empty();
    }
}
