package lesson6.task5.service;

import org.junit.Ignore;
import org.junit.Test;
import ua.epam.task5.text.domain.*;
import ua.epam.task5.text.service.TextServiceImpl;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TextServiceImplTest {
    private final TextServiceImpl textService = new TextServiceImpl();

    @Test
    @Ignore
    public void shouldReturnNullStringForNullText() {
        String expectedResult = null;
        String actualResult = textService.convertTextToString(null);
//        assertEquals(expectedResult,actualResult);
        assertNull("", actualResult);
    }

    @Test
    @Ignore
    // testConvertTextToString_shouldReturnString_
    public void shouldReturnStringForTextWithOutBody() {
        String expectedResult = "Hello";
        List<Symbol> symbols = asList(new Letter('H'),new Letter('e'),new Letter('l'),
                new Letter('l'),new Letter('o'));
        Sentence header = new Sentence(asList(new Word(symbols)));
        Text text = new Text(header, null);
        String actualResult = textService.convertTextToString(text);
        assertEquals(expectedResult, actualResult);
    }
}
