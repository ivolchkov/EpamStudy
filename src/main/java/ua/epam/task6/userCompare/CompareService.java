package ua.epam.task6.userCompare;

import java.util.Comparator;

public final class CompareService  {
    private CompareService() {
        throw new RuntimeException();
    }

    public static void bubbleSort(User[] users) {
        int size = users.length;

        for ( int i = 0, last = size - 1; i < last; i++ ) {
            for (int j = 0; j < last - i; j++ ) {
                swap(users, j, j+1);
            }
        }

    }

    private static void swap(User[] users, int i, int j) {
        if ( users[i].compareTo(users[j] ) > 0 ) {
            User buffer = users[i];

            users[i] = users[j];
            users[j] = buffer;
        }
    }

    public static void selectSort(User[] users) {
        int size = users.length;

        for ( int i = 0; i < size; i++ ) {
            for ( int j = i + 1; j < size; j++ ) {
                swap(users, i, j);
            }
        }
    }
}
