package ua.epam.task4.text;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class TextTest {
    private static Text text;

    @BeforeClass
    public static void textInit() {
        text = new Text();
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldThrowIllegalArgumentException() {
        exception.expect(IllegalArgumentException.class);

        text.addSentence(null);
    }

    @Test
    public void shouldSetNewTextHead() {
        text.setTextHead("Text head");
        String expected = "Text head";
        String actual = text.getTextHead();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnRightSentence() {
        Word[] words = {new Word("I"), new Word("am"), new Word("student"), new Word("of"), new Word("EPAM"), new Word("courses")};
        Sentence sentence = new Sentence();
        sentence.addWords(words);
        text.addSentence(sentence);
        String expected = "[I am student of EPAM courses]";
        String actual = text.getSentences().toString();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldRightAddWord() {
        Word[] words = {new Word("I"), new Word("am"), new Word("student"), new Word("of"), new Word("EPAM"), new Word("courses")};
        Sentence sentence = new Sentence();
        sentence.addWords(words);
        text.addSentence(sentence);
        Word word = new Word("now");
        text.addWord(word);
        String expected = "[I am student of EPAM courses now]";
        String actual = text.getSentences().toString();

        assertEquals(expected, actual);
    }

}