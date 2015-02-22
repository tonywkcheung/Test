package htable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HashTable<K, V> {

    private static int ARRAY_SIZE = 10;
    private int size = 0;

    @SuppressWarnings("unchecked")
    Entry<K, V>[] table = new Entry[ARRAY_SIZE];

    public void put(K key, V value) {
        if (key == null) {
            return;
        }

        int hashIndex = key.hashCode() % ARRAY_SIZE;

        Entry<K, V> hashEntry = table[hashIndex];

        if (hashEntry == null) {
            table[hashIndex] = new Entry<K, V>(key, value, null);
        } else {
            while (hashEntry != null) {
                if (hashEntry.getKey().equals(key)) {
                    hashEntry.value = value;
                    return;
                }

                hashEntry = hashEntry.next();
            }

            table[hashIndex] = new Entry<>(key, value, table[hashIndex]);
        }
        size++;
    }

    public void remove(K key) {
        if (key == null) {
            return;
        }

        int hashIndex = key.hashCode() % ARRAY_SIZE;

        Entry<K, V> hashEntry = table[hashIndex];

        if (hashEntry == null) {
            return;
        } else {
            Entry<K, V> previousEntry = null;

            while (hashEntry != null) {
                if (hashEntry.getKey().equals(key)) {
                    if (previousEntry == null) {
                        table[hashIndex] = hashEntry.next;
                    } else {
                        previousEntry.next = hashEntry.next();
                    }
                    size--;
                    return;
                }
                previousEntry = hashEntry;
                hashEntry = hashEntry.next();
            }
        }
    }

    public V get(K key) {

        if (key == null) {
            return null;
        }

        int hashIndex = key.hashCode() % ARRAY_SIZE;

        for (Entry<K, V> hashEntry = table[hashIndex]; hashEntry != null; hashEntry = hashEntry.next()) {
            if (hashEntry.getKey().equals(key)) {
                return hashEntry.getValue();
            }
        }

        return null;
    }

    public Collection<V> valueSet() {
        List<V> valueList = new ArrayList<V>();
        for (int i = 0; i < ARRAY_SIZE; i++) {
            if (table[i] != null) {
                for (Entry<K, V> hashEntry = table[i]; hashEntry != null; hashEntry = hashEntry.next()) {
                    valueList.add(hashEntry.getValue());
                }
            }
        }

        return valueList;
    }

    public Collection<K> keySet() {
        List<K> keyList = new ArrayList<K>();
        for (int i = 0; i < ARRAY_SIZE; i++) {
            if (table[i] != null) {
                for (Entry<K, V> hashEntry = table[i]; hashEntry != null; hashEntry = hashEntry.next()) {
                    keyList.add(hashEntry.getKey());
                }
            }
        }

        return keyList;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < ARRAY_SIZE; i++) {
            Entry<K, V> hashEntry = table[i];
            while (hashEntry != null) {
                sb.append(hashEntry.toString());
                sb.append(",");
                hashEntry = hashEntry.next();
            }
        }

        return sb.toString();
    }

    public int size() {
        return size;
    }

}
