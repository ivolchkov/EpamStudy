package ua.epam.task5.text.domain;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sentence {
    private final List<SentenceUnit> words;

    public Sentence(List<SentenceUnit> words) {
        this.words = words;
    }

    public List<SentenceUnit> getWords() {
        return words;
    }

    public String getSentence() {
        if ( words.isEmpty() ) {
            return null;
        }

        StringBuilder builder = new StringBuilder();

        for ( SentenceUnit sentenceUnit: this.words ) {
            builder.append(sentenceUnit.toString());
        }

        return builder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Sentence other = (Sentence) obj;

        return (this.words == other.words) || (this.words != null && this.words.equals(other.words));
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;

        result = prime * result + (this.words == null ? 0 : this.words.hashCode());

        return result;
    }

    @Override
    public String toString() {
        return  this.getSentence();
    }

    public void addWords(Word... words) {
        if ( words == null ) {
            throw new IllegalArgumentException();
        }

        this.words.addAll(Arrays.asList(words));
    }

    public void addSign(PunctuationSymbol sign) {
        if ( sign == null ) {
            throw new IllegalArgumentException();
        }

        this.words.add(sign);
    }
}
