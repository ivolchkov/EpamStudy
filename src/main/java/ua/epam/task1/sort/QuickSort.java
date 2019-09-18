package ua.epam.task1.sort;

import org.jetbrains.annotations.NotNull;

public class QuickSort implements Sort {
    private int partition(int start, int end, int[] arr) {
        int size = end + start;
        int mid = size / 2;
        int tail = start;
        int buffer = arr[mid];

        arr[mid] = arr[end];
        arr[end] = buffer;

        for( ; tail < end && buffer > arr[tail]; tail++ );

        for ( int j = tail + 1; j < end; j++ ) {
            if ( arr[j] < buffer ) {
                int temp = arr[tail];

                arr[tail] = arr[j];
                arr[j] = temp;
                tail += 1;
            }
        }

        arr[end] = arr[tail];
        arr[tail] = buffer;

        return tail;
    }

    private void quickSort(int start, int end, @NotNull int[] arr) {
        if ( end > start ) {
            int pivot = partition(start, end, arr);

            quickSort(start, pivot - 1, arr) ;
            quickSort(pivot + 1, end, arr);
        }
    }

    @Override
    public void sort( @NotNull int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        quickSort(start, end, arr);
    }
}
