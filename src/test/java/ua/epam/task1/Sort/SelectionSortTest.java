package ua.epam.task1.Sort;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class SelectionSortTest {
    private static SelectionSort selectionSort;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @BeforeClass
    public static void initSelectionSort() {
        selectionSort = new SelectionSort();
    }

    @Test
    public void shouldReturnSortedArr() {
        int[] actual = {5, 2, 3, 4, 1};
        int[] expected = {1, 2, 3, 4, 5};

        selectionSort.sort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnSortedArrWithNegativeNumbers() {
        int[] actual = {-5, -2, 3, 4, 1};
        int[] expected = {-5, -2, 1, 3, 4};

        selectionSort.sort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnTheSameArr() {
        int[] actual = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};

        selectionSort.sort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowIllegalArgumentException() {
        exception.expect(IllegalArgumentException.class);

        selectionSort.sort(null);
    }

}