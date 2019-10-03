package ua.epam.task8.collection;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


import static org.junit.Assert.*;

public class ArrayListTest {
    private static ArrayList<Integer> arr;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @BeforeClass
    public static void initArrayList() {
        Integer[] array = {1, 2, 3, 4, 5};
        arr = new ArrayList<>(array);
    }

    @Test
    public void shouldReturnRightSize() {
        int expected = 5;
        int actual = arr.size();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnIsEmpty() {
        boolean actual = arr.isEmpty();

        assertFalse(actual);
    }

    @Test
    public void shouldReturnRightElemByIndex() {
        int expected = 1;
        int actual = arr.getByIndex(0);

        assertEquals(expected, actual);
    }


    @Test
    public void shouldRightRemove() {
        assertTrue(arr.remove(5));
    }

    @Test
    public void shouldNotRemove() {
        assertFalse(arr.remove(10));
    }

    @Test
    public void clean() {
        arr.clean();

        assertEquals(0, arr.size());
    }

    @Test
    public void shouldThrowIndexOutOfBoundsExceptionWithNegative() {
        exception.expect(IndexOutOfBoundsException.class);
        arr.getByIndex(-1);
    }

    @Test
    public void shouldThrowIndexOutOfBoundsExceptionWithBiggerThanSize() {
        exception.expect(IndexOutOfBoundsException.class);
        arr.getByIndex(100);
    }

}