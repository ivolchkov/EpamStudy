package ua.epam.task4.text;

import java.util.Objects;

public class Sign {
    private static char[] signs = {' ', '?', '!', ',', '.', ':', ';', '[', ']', '{' , '}' };

    private char sign;

    public Sign(char sign) {
        Sign.validate(sign);
        this.sign = sign;
    }

    public static void validate(char sign) {
        boolean isSign = false;

        for (char c : signs ) {
            if ( c == sign ) {
                isSign = true;
            }
        }

        if ( !isSign ) {
            throw new IllegalArgumentException();
        }
    }

    public char getSign() {
        return sign;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Sign other = (Sign) obj;

        return sign == other.sign;
    }

    @Override
    public int hashCode() {
        return Character.hashCode(sign);
    }

    @Override
    public String toString() {
        return "" + sign;
    }
}
