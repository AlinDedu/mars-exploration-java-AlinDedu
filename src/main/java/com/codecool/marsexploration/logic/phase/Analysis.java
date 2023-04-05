package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Outcome;
import com.codecool.marsexploration.logic.analyzer.Analyzer;
import com.codecool.marsexploration.logic.analyzer.LandingAnalyzer;

import java.util.Optional;

public class Analysis implements Phase{
    @Override
    public void perform(Context context) {
        if (context.getStepNumber() == 0) {
            Analyzer landingAnalyzer = new LandingAnalyzer();
            Optional<Outcome> landingOutcome = landingAnalyzer.analyze(context);
            landingOutcome.ifPresent(context::setOutcome);
        } else {
            for (Analyzer analyzer : context.getRover().getAnalyzers()) {
                Optional<Outcome> analyzerOutcome = analyzer.analyze(context);
                analyzerOutcome.ifPresent(context::setOutcome);
            }
        }
    }
}
