package M_hash_tables.B_map;

public interface Map264<K, V> {
    // Entry interface?

    int size();
    V put(K key, V value);
    boolean containsKey(Object o);
    V get(Object key);
    V remove(Object key);
}
