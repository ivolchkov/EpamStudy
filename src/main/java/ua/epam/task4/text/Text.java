package ua.epam.task4.text;

import java.util.ArrayList;
import java.util.Objects;

public class Text {
    private String textHead = "Default";
    private ArrayList<Sentence> sentences = new ArrayList<>();

    public Text() {}

    public Text(Sentence sentence) {
        validate(sentence);

        this.sentences.add(sentence);
    }

    public Text(String head, Sentence sentence) {
        this(sentence);
        this.textHead = head;
    }

    private void validate(Sentence sentence) {
        if ( sentence == null ) {
            throw new IllegalArgumentException();
        }
    }

    public String getTextHead() {
        return textHead;
    }

    public ArrayList<Sentence> getSentences() {
        return sentences;
    }

    public void setTextHead(String textHead) {
        this.textHead = textHead;
    }

    public void addSentence(Sentence sentence) {
        validate(sentence);
        this.sentences.add(sentence);
    }

    public void addWord(Word word) {
        if ( word == null ) {
            throw new IllegalArgumentException();
        }

        Sentence last = this.sentences.get(sentences.size()-1);

        if ( last.getSentence().endsWith(".") ) {
            this.sentences.add(new Sentence(word));
        } else {
            last.addSign(new Sign(' '));
            last.addWords(word);
        }

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Text other = (Text) obj;

        return Objects.equals(textHead, other.textHead) &&
                Objects.equals(sentences, other.sentences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(textHead, sentences);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append(this.textHead.toUpperCase()).append("\n");
        result.append('\t');

        for (Sentence sentence : this.sentences ) {
            result.append(sentence.toString());
        }

        return result.toString();
    }
}
