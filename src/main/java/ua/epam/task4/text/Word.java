package ua.epam.task4.text;


public class Word {
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Word other = (Word) obj;

        return (this.word == other.word) || (this.word != null && this.word.equals(other.word));
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;

        result = prime * result + (this.word == null ? 0 : this.word.hashCode());

        return result;
    }

    @Override
    public String toString() {
        return word;
    }
}
