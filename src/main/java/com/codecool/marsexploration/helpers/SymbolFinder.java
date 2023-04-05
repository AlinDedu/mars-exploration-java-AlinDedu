package com.codecool.marsexploration.helpers;

import com.codecool.marsexploration.data.Symbol;

public class SymbolFinder {
    public static Symbol findSymbol(String input) {
        for (Symbol symbol : Symbol.values()) {
            if (symbol.getSymbol().equals(input))
                return symbol;
        }
        return Symbol.EMPTY;
    }
}
