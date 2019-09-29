package ua.epam.task6.userCompare;

import java.util.ArrayList;
import java.util.Comparator;

public class User implements Comparable<User> {
    private static final Comparator<User> COMPARE_BY_AGE = ((first, second) -> first.age - second.age);
    private static final Comparator<User> COMPARE_BY_NAME = ((first, second) -> first.name.compareTo(second.name));
    private static final Comparator<User> COMPARE_BY_SURNAME = ((first, second) -> first.surname.compareTo(second.surname));
    public static ArrayList<User> users = new ArrayList<>();

    private String name;
    private String surname;
    private int age;

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;

        users.add(this);
    }

    public static User[] getUsers() {
        Object[] objects = users.toArray();
        int size = objects.length;
        User[] users = new User[size];

        for ( int i = 0; i < size; i++ ) {
            if (objects[i] instanceof User) {
                users[i] = (User) objects[i];
            }
        }
        return users;
    }

    @Override
    public String toString() {
        return "User:" + '\n' +
                "surname = " + surname +
                ", name = " + name + ' ' +
                ", age = " + age;
    }

    @Override
    public int compareTo(User other) {
        return COMPARE_BY_SURNAME.thenComparing(COMPARE_BY_NAME).thenComparing(COMPARE_BY_AGE).compare(this, other);
    }
}
