package ua.epam.task1.sort;

import org.jetbrains.annotations.NotNull;

public class BubbleSort implements Sort {
    @Override
    public void sort(@NotNull int[] arr) {
        int size = arr.length;

        for ( int i = 0, last = size - 1; i < last; i++ ) {
            for (int j = 0; j < last - i; j++ ) {
                if ( arr[j] > arr[j+1] ) {
                    int buffer = arr[j];

                    arr[j] = arr[j+1];
                    arr[j+1] = buffer;
                }
            }
        }

    }

}
