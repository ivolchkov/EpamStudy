package ua.epam.task3.builder;

public class Main {
    public static void main(String[] args) {
        User user = User.build().
                withName("Igor").
                withSurname("Volchkov").
                withEmail("igor@gmail.com").
                withCode(3056).
                    build();
    }
}
