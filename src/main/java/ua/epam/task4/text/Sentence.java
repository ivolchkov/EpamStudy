package ua.epam.task4.text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Sentence {
    private ArrayList<SentenceUnit> words;

    public Sentence() {
        this.words = new ArrayList<>();
    }

    public Sentence(Word word) {
        this();
        if ( word == null ) {
            throw new IllegalArgumentException();
        }
        this.words.add(word);
    }

    public Sentence(Word... words) {
        this();
        this.addWords(words);
    }

    public String getSentence() {
        StringBuilder builder = new StringBuilder();

        for ( SentenceUnit word: this.words ) {
            builder.append(word.toString()).append(' ');
        }

        builder.deleteCharAt(builder.length()-1);

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

        if ( this.words.isEmpty() ) {
            StringBuilder result = new StringBuilder();
        } else {
            StringBuilder result = new StringBuilder(this.getSentence());
        }

        this.words.addAll(Arrays.asList(words));
    }

    public void addSign(Sign sign) {
        if ( sign == null ) {
            throw new IllegalArgumentException();
        }

        this.words.add(sign);
    }
}
