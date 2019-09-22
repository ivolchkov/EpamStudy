package ua.epam.task4.text;

public class Sentence {
    private String sentence;

    public Sentence() {
        this.sentence = "";
    }

    public Sentence(Word word) {
        this();
        if ( word == null ) {
            throw new IllegalArgumentException();
        }
        this.sentence = word.toString();
    }

    public Sentence(Word... words) {
        this();
        this.addWords(words);
    }

    public String getSentence() {
        return sentence;
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

        return (this.sentence == other.sentence) || (this.sentence != null && this.sentence.equals(other.sentence));
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;

        result = prime * result + (this.sentence == null ? 0 : this.sentence.hashCode());

        return result;
    }

    @Override
    public String toString() {
        return sentence;
    }

    public void addWords(Word... words) {
        if ( words == null ) {
            throw new IllegalArgumentException();
        }

        StringBuilder result = new StringBuilder(this.sentence);

        for(Word word : words) {
            result.append(word.toString()).append(' ');
        }

        result.deleteCharAt(result.length()-1);

        this.sentence = result.toString();
    }

    public void addSign(Sign sign) {
        if ( sign == null ) {
            throw new IllegalArgumentException();
        }

        this.sentence += sign.toString();
    }
}
