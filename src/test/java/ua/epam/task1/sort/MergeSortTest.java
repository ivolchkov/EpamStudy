package ua.epam.task1.sort;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class MergeSortTest {
    private static MergeSort mergeSort;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @BeforeClass
    public static void initMergeSort() {
        mergeSort = new MergeSort();
    }

    @Test
    public void shouldReturnSortedArr() {
        int[] actual = {5, 2, 3, 4, 1};
        int[] expected = {1, 2, 3, 4, 5};

        mergeSort.sort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnSortedArrWithNegativeNumbers() {
        int[] actual = {-5, -2, 3, 4, 1};
        int[] expected = {-5, -2, 1, 3, 4};

        mergeSort.sort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnTheSameArr() {
        int[] actual = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};

        mergeSort.sort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowNullPointerException() {
        exception.expect(NullPointerException.class);

        mergeSort.sort(null);
    }

}