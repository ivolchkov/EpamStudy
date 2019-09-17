package ua.epam.task1.Sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        InsertionSort insertionSort = new InsertionSort();
        SelectionSort selectionSort = new SelectionSort();
        MergeSort mergeSort = new MergeSort();
        QuickSort quickSort = new QuickSort();

        int[] test = {1, 5, 4, 3, 2, 9, 6, 8 , 12, 3, 1 , 4, 7};
//        int[] test = {5, 3, 2, 1 ,4};
        System.out.println("Before: " + Arrays.toString(test));

        quickSort.sort(test);

        System.out.println("After: " + Arrays.toString(test));
    }
}
