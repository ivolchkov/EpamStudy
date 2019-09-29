package ua.epam.task5.text.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Text {
    private Sentence header;
    private List<Sentence> sentences;

    public Text(Sentence header, List<Sentence> sentences) {
        this.header = header;
        this.sentences = sentences;
    }


    public void setHeader(Sentence header) {
        this.header = header;
    }

    public void addSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public Sentence getHeader() {
        return header;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Text text = (Text) o;
        return Objects.equals(header, text.header) &&
                Objects.equals(sentences, text.sentences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(header, sentences);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append(header).append("\n");
        for ( Sentence s : sentences ) {
            result.append(s);
        }

        return  result.toString();
    }
}
