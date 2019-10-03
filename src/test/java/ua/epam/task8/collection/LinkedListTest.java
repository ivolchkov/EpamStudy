package ua.epam.task8.collection;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class LinkedListTest {
    private static  LinkedList<Integer> linkedList;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @BeforeClass
    public static void initLinkedList() {
        Integer[] arr = {1, 2, 3, 4, 5};
        linkedList = new LinkedList<>();

        for (Integer element: arr) {
            linkedList.add(element);
        }
    }

    @Test
    public void shouldReturnRightSize() {
        int expected = 5;
        int actual = linkedList.size();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnIsEmpty() {
        boolean actual = linkedList.isEmpty();

        assertFalse(actual);
    }

    @Test
    public void shouldReturnRightElemByIndex() {
        int expected = 1;
        int actual = linkedList.getByIndex(0);

        assertEquals(expected, actual);
    }


    @Test
    public void shouldRightRemove() {
        assertTrue(linkedList.remove(5));
    }

    @Test
    public void shouldNotRemove() {
        assertFalse(linkedList.remove(10));
    }

    @Test
    public void clean() {
        linkedList.clean();

        assertEquals(0, linkedList.size());
    }

    @Test
    public void shouldThrowIndexOutOfBoundsExceptionWithNegative() {
        exception.expect(IndexOutOfBoundsException.class);
        linkedList.getByIndex(-1);
    }

    @Test
    public void shouldThrowIndexOutOfBoundsExceptionWithBiggerThanSize() {
        exception.expect(IndexOutOfBoundsException.class);
        linkedList.getByIndex(100);
    }

}