package ua.epam.task5.text.domain;

import java.util.List;
import java.util.Objects;

public class Word implements SentenceUnit {
    private final List<Symbol> symbols;

    public Word(List<Symbol> symbols) {
        this.symbols = symbols;
    }

    public List<Symbol> getSymbols() {
        return symbols;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equals(symbols, word.symbols);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbols);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for ( Symbol s: symbols ) {
            result.append(s);
        }

        return result.toString();
    }
}
