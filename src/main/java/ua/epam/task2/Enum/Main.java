package ua.epam.task2.Enum;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Color color = Color.BLUE;
        Color[] colors = { Color.RED, Color.BLUE, Color.GREEN};

        System.out.println(color);
        System.out.println(Arrays.toString(colors));
        System.out.println(Arrays.toString(Color.values()));
    }
}
