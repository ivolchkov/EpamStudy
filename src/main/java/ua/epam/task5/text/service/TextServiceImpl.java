package ua.epam.task5.text.service;

import ua.epam.task5.text.domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Objects.isNull;

public class TextServiceImpl implements TextService {
    @Override
    public Text convertStringToText(String header, String text) {
        validate(header);
        validate(text);
        Sentence resultHead = convertCharToSentence(header);
        List<Sentence> sentences = convertCharToSentences(text);

        return new Text(resultHead, sentences);
    }

    @Override
    public void addSentenceToText(Text target, String sentence) {
        validate(target);
        validate(sentence);
        Sentence newSentence = convertCharToSentence(sentence);
        List<Sentence> newSentences = target.getSentences();
        newSentences.add(newSentence);
        target.addSentences(newSentences);
    }

    @Override
    public void setTextHead(Text target, String header) {
        validate(target);
        validate(header);
        Sentence head = convertCharToSentence(header);

        target.setHeader(head);
    }

    private <T> void validate(T target) {
        if ( target == null ) {
            throw new IllegalArgumentException();
        }
    }

    private Sentence convertCharToSentence(String str) {
        char[] symbols = str.toCharArray();
        List<Symbol> letters = new ArrayList<>();
        List<SentenceUnit> words = new ArrayList<>();

        for (char c : symbols) {
            if (PunctuationSymbol.validate(c)) {
                Word word = new Word(letters);
                words.add(word);
                words.add(new PunctuationSymbol(c));
                letters = new ArrayList<>();
            } else {
                letters.add(new Letter(c));
            }
        }

        if ( !letters.isEmpty() ) {
            Word word = new Word(letters);
            words.add(word);
        }
        return new Sentence(words);
    }

    private List<Sentence> convertCharToSentences(String str) {
        char[] symbols = str.toCharArray();
        List<Symbol> letters = new ArrayList<>();
        List<SentenceUnit> words = new ArrayList<>();
        List<Sentence> sentences = new ArrayList<>();

        for (char c : symbols) {
            if (PunctuationSymbol.validate(c)) {
                Word word = new Word(letters);
                words.add(word);
                words.add(new PunctuationSymbol(c));
                letters = new ArrayList<>();
            } else {
                letters.add(new Letter(c));
            }

            if (c == '.') {
                Sentence sentence = new Sentence(words);
                sentences.add(sentence);
                words = new ArrayList<>();
            }

        }
        return sentences;
    }

    @Override
    public String convertTextToString(Text text) {
        return isNull(text) ? null : text.toString();
    }
}
