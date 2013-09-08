package htable;

public class Entry<K,V> {

	Entry<K,V> next;

	public K key;
	public V value;
	
	public Entry(K key, V value, Entry<K, V> next) {
		this.key = key;
		this.value = value;
		this.next = next;
	}

	public Entry<K, V> next() {
		return this.next;
	}

	public K getKey() {
		return this.key;
	}

	public V getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return String.format("(%s, %s)", key, value );
	}
}
