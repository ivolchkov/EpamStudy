package ua.epam.task8.collection;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class MyHashMapTest {
    private static MyHashMap<Integer, Integer> map;

    @BeforeClass
    public static void init() {
        map = new MyHashMap<>();
    }

    @Before
    public void clean() {
        map = new MyHashMap<>();
    }

    @Test
    public void shouldPutElement() {
        map.put(1,1);
        int expected = 1;
        int actual = map.size();

        assertEquals(expected,actual);
    }

    @Test
    public void shouldPutElementWithNullKey() {
        map.put(null, 1);
        int expected = 1;
        int actual = map.size();

        assertEquals(expected,actual);
    }

    @Test
    public void shouldChangeValueElementWithNullKey() {
        map.put(null, 1);
        map.put(null, 2);
        int expected = 1;
        int actual = map.size();

        assertEquals(expected,actual);
    }

    @Test
    public void shouldChangeValueElement() {
        map.put(1, 1);
        map.put(1, 1);
        int expected = 1;
        int actual = map.size();

        assertEquals(expected,actual);
    }

    @Test
    public void shouldExtendMapCapacity() {
        for ( int i = 0; i < 17; i++ ) {
            map.put(i, i);
        }
        int expected = 17;
        int actual = map.size();

        assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnElementByKey() {
        map.put(1, 2);
        int expected = 2;
        int actual = map.getByKey(1);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnElementByNullKey() {
        map.put(null, 2);
        int expected = 2;
        int actual = map.getByKey(null);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNull() {
        Integer expected = null;
        Integer actual = map.getByKey(1);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNullWithNullKey() {
        Integer expected = null;
        Integer actual = map.getByKey(null);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnSize() {
        int expected = 0;
        int actual = map.size();

        assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnRightSizeWithTwoElem() {
        map.put(1,1);
        map.put(2,2);
        int expected = 2;
        int actual = map.size();

        assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnIsEmptyWithoutElem() {
        boolean actual = map.isEmpty();

        assertTrue(actual);
    }

    @Test
    public void shouldReturnIsEmptyWithElem() {
        map.put(1,1);
        boolean actual = map.isEmpty();

        assertFalse(actual);
    }

    @Test
    public void shouldReturnValues() {
        map.put(1,1);
        map.put(2,2);
        Collection<Integer> actual = map.values();
        Collection<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);

        assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnEmptyList() {
        Collection<Integer> expected = Collections.emptyList();
        Collection<Integer> actual = map.values();

        assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnRightKeys() {
        map.put(1,1);
        map.put(2,2);
        Set<Integer>  actual = map.keys();
        Set<Integer>  expected = new HashSet<>();
        expected.add(1);
        expected.add(2);

        assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnEmptySet() {
        int expected = 0;
        int actual = map.keys().size();

        assertEquals(expected,actual);
    }
}