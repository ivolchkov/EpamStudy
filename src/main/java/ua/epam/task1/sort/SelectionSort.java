package ua.epam.task1.sort;

import org.jetbrains.annotations.NotNull;

public class SelectionSort implements Sort {
    @Override
    public void sort(@NotNull int[] arr) {
        int size = arr.length;

        for (int i = 0; i < size; i++ ) {
            int min = i;

            for ( int j = i + 1; j < size; j++ ) {
                if ( arr[j] < arr[min] ) min = j;
            }

            if ( min != i ) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

}
