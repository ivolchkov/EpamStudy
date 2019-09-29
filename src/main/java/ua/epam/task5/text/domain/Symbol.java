package ua.epam.task5.text.domain;

import java.util.Objects;

public abstract class Symbol {
    private final char symbol;

    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symbol symbol1 = (Symbol) o;
        return symbol == symbol1.symbol;
    }

    @Override
    public String toString() {
        return "" + symbol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol);
    }
}
