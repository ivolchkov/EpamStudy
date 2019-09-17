package ua.epam.task1.Sort;

import org.jetbrains.annotations.NotNull;

public class InsertionSort implements Sort {
    @Override
    public void sort(@NotNull int[] arr) {
        int size = arr.length;

        for ( int i = 1; i < size; i++ ) {
            int j = i;
            int temp = arr[i];

            for (int prev = j - 1; (j > 0) && (temp < arr[prev]); j--, prev-- ) {
                arr[j] = arr[prev];
            }

            arr[j] = temp;
        }
    }

}
