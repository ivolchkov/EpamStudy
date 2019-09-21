package ua.epam.task1.sort;


public class InsertionSort implements Sort {
    @Override
    public void sort(int[] arr) {
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
