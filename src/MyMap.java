
public interface MyMap<K extends Comparable<K>, V> {
    void add(K key, V value);
    V get(K key);
}
