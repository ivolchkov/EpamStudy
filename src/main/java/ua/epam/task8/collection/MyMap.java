package ua.epam.task8.collection;

import java.util.Collection;
import java.util.Set;

public interface MyMap<K,V> {
        // loading 80% -> 2*capacity
        // Node->Node->Node-> >8
        V put(K key, V value);

        V getByKey(K key);

        int size();

        boolean isEmpty();

        Collection<V> values();

        Set<K> keys();
}
