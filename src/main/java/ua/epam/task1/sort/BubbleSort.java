package ua.epam.task1.sort;


public class BubbleSort implements Sort {
    @Override
    public void sort(int[] arr) {
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
