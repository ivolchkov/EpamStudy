package ua.epam.task8.collection;

import java.util.*;

public class MyHashMap<K,V> implements MyMap<K,V> {
    private static final int DEFAULT_CAPACITY = 1 << 4;
    private static final int MAXIMUM_CAPACITY = 1 << 31;
    private static final int CHAIN_THRESHOLD = 1 << 3;

    private Entry<K,V>[] table;
    private final float loadFactor = 0.8f;
    private int threshold;
    private int size;
    private Set<K> keySet;
    private Collection<V> values;

    public MyHashMap() {
        this.table = (Entry<K, V>[]) new Entry[DEFAULT_CAPACITY];
        this.size = 0;
        this.threshold = (int) (DEFAULT_CAPACITY * loadFactor);
    }

    @Override
    public V put(K key, V value) {
        if ( key == null ) {
            return putForNullKey(value);
        }
        int hash = hash(key.hashCode());
        int index = indexFor(hash, table.length);
        int counter = 0;

        for (Entry<K,V> e = table[index]; e != null; e = e.next ) {
            if ( e.hash == hash && (e.value == value || e.value.equals(value))) {
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
            counter += 1;
        }

        validate(counter);

        addEntry(hash , key, value, index);
        return null;
    }

    private void validate(int counter) {
        if ( counter >= CHAIN_THRESHOLD || this.size > this.threshold) {
            int newCapacity;

            if ( table.length >= (1 << 30) ) {
                newCapacity = MAXIMUM_CAPACITY;
            } else {
                newCapacity = table.length * 2;
            }

            resize(newCapacity);
        }
    }

    private void resize(int newCapacity) {
        if ( table.length == MAXIMUM_CAPACITY ) {
            threshold = Integer.MAX_VALUE;
            return;
        }
        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable);
        this.table = (Entry<K, V>[]) newTable;
        this.threshold = (int) (this.loadFactor * this.table.length);
    }

    private void transfer(Entry[] newTable) {
        int length = newTable.length;

        for ( Entry<K,V> e : this.table ) {
            while ( e != null ) {
                Entry<K,V> next = e.next;
                int index = indexFor(e.hash, length);
                e.next = null;
                if ( table[index] == null ) {
                    newTable[index] = e;
                } else {
                    Entry<K,V> entry = table[index];
                    table[index] = new Entry<>(e.hash, e.key, e.value, entry);
                }
                e = next;
            }
        }
    }

    private void addEntry(int hash, K key, V value, int index) {
        Entry<K,V> e = table[index];
        table[index] = new Entry<>(hash, key, value, e);
        if ( keySet == null ) {
            keySet = new HashSet<>();
        }
        if ( values == null ) {
            values = new ArrayList<>();
        }
        keySet.add(key);
        values.add(value);
        size += 1;
    }

    private V putForNullKey(V value) {
        int counter = 0;

        for ( Entry<K,V> e = table[0]; e != null; e = e.next) {
            if ( e.key == null ) {
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
            counter += 1;
        }

        validate(counter);

        addEntry(0, null, value,0);
        return null;
    }

    private int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    private int indexFor(int h, int length) {
        return h & (length - 1);
    }

    @Override
    public V getByKey(K key) {
        if ( key == null ) {
            return getByNullKey();
        }

        Entry<K,V> entry = getByNonNullKey(key);

        return entry == null ? null : entry.getValue();
    }

    private V getByNullKey() {
        for (Entry<K,V> e = table[0]; e != null; e = e.next ) {
            if ( e.key == null ) {
                return e.getValue();
            }
        }
        return null;
    }

    private Entry<K,V> getByNonNullKey(K key) {
        int index = indexFor(key.hashCode(), table.length);

        for (Entry<K,V> e = table[index]; e != null; e = e.next ) {
            if (e.hash == key.hashCode() && (e.key == key || e.key.equals(key))) {
                return e;
            }
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Collection<V> values() {
        return this.values == null ? Collections.emptyList() : values;
    }

    @Override
    public Set<K> keys() {
        return this.keySet == null ? new HashSet<>(): keySet;
    }

    private static class Entry<K,V> {
        private int hash;
        private K key;
        private V value;
        private Entry<K,V> next;

        public Entry(int hash, K key, V value, Entry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public int getHash() {
            return hash;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Entry<K, V> getNext() {
            return next;
        }
    }
}
