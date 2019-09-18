package ua.epam.task1.sort;

import org.jetbrains.annotations.NotNull;

public class MergeSort implements Sort {
    private void merge(int start, int mid, int end, int[] arr) {
        int size = end - start;
        int[] buffer = new int[size];
        int i, j, k;

        for ( i = start, j = mid, k = 0; i < mid && j < end; k++ ) {
            if ( arr[i] <= arr[j] ) {
                buffer[k] = arr[i];
                i += 1;
            } else {
                buffer[k] = arr[j];
                j += 1;
            }
        }

        for ( ; i < mid; i++, k++ ) {
            buffer[k] = arr[i];
        }

        for ( ; j < end; j++, k++ ) {
            buffer[k] = arr[j];
        }

        for (k = 0, i = start; i < end; k++, i++ ) {
            arr[i] = buffer[k];
        }
    }

    private void mergeSort(int start, int end, @NotNull int[] arr ) {
        int mid = (start + end) / 2;

        if ( mid == start ) {
            return;
        }

        mergeSort(start, mid, arr);
        mergeSort(mid, end, arr);
        merge(start, mid, end, arr);
    }

    @Override
    public void sort( @NotNull int[] arr) {
        int start = 0;
        int end = arr.length;

        mergeSort(start, end, arr);
    }
}
