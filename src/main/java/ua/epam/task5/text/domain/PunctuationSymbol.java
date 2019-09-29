package ua.epam.task5.text.domain;


public class PunctuationSymbol  extends Symbol implements SentenceUnit {
    private static char[] signs = {' ', '?', '!', ',', '.', ':', ';', '[', ']', '{' , '}' };

    public PunctuationSymbol(char symbol) {
        super(symbol);
        if ( !PunctuationSymbol.validate(symbol) ) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean validate(char sign) {
        boolean isSign = false;

        for (char c : signs ) {
            if ( c == sign ) {
                isSign = true;
            }
        }

        return isSign;
    }

    public static char[] getSigns() {
        return signs;
    }


}
