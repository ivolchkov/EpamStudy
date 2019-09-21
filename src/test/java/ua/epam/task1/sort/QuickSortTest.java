package ua.epam.task1.sort;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class QuickSortTest {
    private static QuickSort quickSort;

    @Rule
    public final  ExpectedException exception = ExpectedException.none();

    @BeforeClass
    public static void initQuickSort() {
        quickSort = new QuickSort();
    }

    @Test
    public void shouldReturnSortedArr() {
        int[] actual = {5, 2, 3, 4, 1};
        int[] expected = {1, 2, 3, 4, 5};

        quickSort.sort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnSortedArrWithNegativeNumbers() {
        int[] actual = {-5, -2, 3, 4, 1};
        int[] expected = {-5, -2, 1, 3, 4};

        quickSort.sort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnTheSameArr() {
        int[] actual = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};

        quickSort.sort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowNullPointerException() {
        exception.expect(NullPointerException.class);

        quickSort.sort(null);
    }

}