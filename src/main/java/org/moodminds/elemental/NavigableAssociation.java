package org.moodminds.elemental;

/**
 * A {@link SortedAssociation} extended with navigation methods designed
 * to provide the nearest matches for specified search targets.
 *
 * @param <K> the type of keys
 * @param <V> the type of values
 */
public interface NavigableAssociation<K, V, KV extends KeyValue<? extends K, ? extends V>> extends SortedAssociation<K, V, KV> {

    /**
     * Retrieve the largest key that is strictly smaller than the given key,
     * or {@code null} if such a key does not exist.
     *
     * @param key the key
     * @return the largest key that is less than {@code key},
     *         or {@code null} if no such key exists
     * @throws ClassCastException if the specified key cannot be compared
     *         with the keys currently in the Association
     * @throws NullPointerException if the specified key is {@code null}
     *         and this Association does not allow {@code null} keys
     */
    K lowerKey(K key);

    /**
     * Retrieve the key-value pair associated with the largest key that is
     * strictly smaller than the given key, or {@code null} if no such key exists.
     *
     * @param key the key
     * @return a key-value pair with the largest key less than {@code key},
     *         or {@code null} if there is no such key
     * @throws ClassCastException if the specified key cannot be compared
     *         with the keys currently in the Association
     * @throws NullPointerException if the specified key is {@code null}
     *         and this Association does not allow {@code null} keys
     */
    KV lowerEntry(K key);

    /**
     * Retrieve the largest key that is less than or equal to the given key,
     * or {@code null} if no such key exists.
     *
     * @param key the key
     * @return the largest key less than or equal to {@code key},
     *         or {@code null} if there is no such key
     * @throws ClassCastException if the specified key cannot be compared
     *         with the keys currently in the Association
     * @throws NullPointerException if the specified key is {@code null}
     *         and this Association does not allow {@code null} keys
     */
    K floorKey(K key);

    /**
     * Retrieve the key-value pair associated with the largest key that is
     * less than or equal to the given key, or {@code null} if no such key exists.
     *
     * @param key the key
     * @return a key-value pair with the largest key less than or equal to
     *         {@code key}, or {@code null} if there is no such key
     * @throws ClassCastException if the specified key cannot be compared
     *         with the keys currently in the Association
     * @throws NullPointerException if the specified key is {@code null}
     *         and this Association does not allow {@code null} keys
     */
    KV floorEntry(K key);

    /**
     * Retrieve the smallest key that is greater than or equal to the given key,
     * or {@code null} if no such key exists.
     *
     * @param key the key
     * @return the smallest key greater than or equal to {@code key},
     *         or {@code null} if there is no such key
     * @throws ClassCastException if the specified key cannot be compared
     *         with the keys currently in the Association
     * @throws NullPointerException if the specified key is {@code null}
     *         and this Association does not allow {@code null} keys
     */
    K ceilingKey(K key);

    /**
     * Retrieve the key-value pair associated with the smallest key that is
     * greater than or equal to the given key, or {@code null} if no such key exists.
     *
     * @param key the key
     * @return a key-value pair with the smallest key greater than or equal to
     *         {@code key}, or {@code null} if there is no such key
     * @throws ClassCastException if the specified key cannot be compared
     *         with the keys currently in the Association
     * @throws NullPointerException if the specified key is {@code null}
     *         and this Association does not allow {@code null} keys
     */
    KV ceilingEntry(K key);

    /**
     * Retrieve the smallest key that is strictly greater than the given key,
     * or {@code null} if no such key exists.
     *
     * @param key the key
     * @return the smallest key greater than {@code key},
     *         or {@code null} if there is no such key
     * @throws ClassCastException if the specified key cannot be compared
     *         with the keys currently in the Association
     * @throws NullPointerException if the specified key is {@code null}
     *         and this Association does not allow {@code null} keys
     */
    K higherKey(K key);

    /**
     * Retrieve the key-value pair associated with the smallest key that is
     * strictly greater than the given key, or {@code null} if no such key exists.
     *
     * @param key the key
     * @return a key-value pair with the smallest key greater than {@code key},
     *         or {@code null} if there is no such key
     * @throws ClassCastException if the specified key cannot be compared
     *         with the keys currently in the Association
     * @throws NullPointerException if the specified key is {@code null}
     *         and this Association does not allow {@code null} keys
     */
    KV higherEntry(K key);

    /**
     * Retrieve the key-value pair associated with the smallest key in this Association,
     * or {@code null} if the Association is empty.
     *
     * @return a key-value pair with the smallest key, or {@code null} if this Association is empty
     */
    KV firstEntry();

    /**
     * Retrieve the key-value pair associated with the largest key in this Association,
     * or {@code null} if the Association is empty.
     *
     * @return a key-value pair with the largest key, or {@code null} if this Association is empty
     */
    KV lastEntry();

    /**
     * Retrieve a view of the mappings contained in this Association in reverse order.
     *
     * @return a view of this Association in reverse order
     */
    NavigableAssociation<K, V, ?> descending();

    /**
     * Retrieve a view of the section within this Association where keys range
     * from {@code fromKey} to {@code toKey}. If {@code fromKey} and
     * {@code toKey} are equal, the returned Association is empty unless
     * both {@code fromInclusive} and {@code toInclusive} are set to {@code true}.
     *
     * @param fromKey the lower endpoint of keys in the returned Association
     * @param fromInclusive {@code true} if the lower endpoint
     *        should be included in the returned view
     * @param toKey the upper endpoint of keys in the returned Association
     * @param toInclusive {@code true} if the upper endpoint
     *        should be included in the returned view
     * @return a view of the section of this Association where keys range from
     *         {@code fromKey} to {@code toKey}
     * @throws ClassCastException if {@code fromKey} and {@code toKey}
     *         cannot be compared to each other using this Association's comparator
     *         (or, if the Association has no comparator, using natural ordering).
     *         Implementations may, but are not required to, throw this
     *         exception if {@code fromKey} or {@code toKey}
     *         cannot be compared to keys currently in the Association
     * @throws NullPointerException if {@code fromKey} or {@code toKey}
     *         is {@code null} and this Association does not allow {@code null} keys
     * @throws IllegalArgumentException if {@code fromKey} is greater than
     *         {@code toKey}, or if this Association itself has a
     *         restricted range, and {@code fromKey} or {@code toKey}
     *         falls outside the bounds of the range
     */
    NavigableAssociation<K, V, ?> sub(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive);

    /**
     * Retrieve a view of the section within this Association where keys are less
     * than (or equal to, if {@code inclusive} is true) {@code toKey}.
     *
     * @param toKey the upper endpoint of keys in the returned Association
     * @param inclusive {@code true} if the upper endpoint
     *        should be included in the returned view
     * @return a view of the section of this Association where keys are less than
     *         (or equal to, if {@code inclusive} is true) {@code toKey}
     * @throws ClassCastException if {@code toKey} is incompatible with
     *         this Association's comparator (or, if the Association has no comparator,
     *         if {@code toKey} does not implement {@link Comparable}).
     *         Implementations may, but are not required to, throw this
     *         exception if {@code toKey} cannot be compared to keys
     *         currently in the Association
     * @throws NullPointerException if {@code toKey} is {@code null}
     *         and this Association does not allow {@code null} keys
     * @throws IllegalArgumentException if this Association itself has a
     *         restricted range, and {@code toKey} falls outside the
     *         bounds of the range
     */
    NavigableAssociation<K, V, ?> head(K toKey, boolean inclusive);

    /**
     * Retrieve a view of the section within this Association where keys are greater
     * than (or equal to, if {@code inclusive} is true) {@code fromKey}.
     *
     * @param fromKey the lower endpoint of keys in the returned Association
     * @param inclusive {@code true} if the lower endpoint
     *        should be included in the returned view
     * @return a view of the section of this Association where keys are greater than
     *         (or equal to, if {@code inclusive} is true) {@code fromKey}
     * @throws ClassCastException if {@code fromKey} is incompatible with
     *         this Association's comparator (or, if the Association has no comparator,
     *         if {@code fromKey} does not implement {@link Comparable}).
     *         Implementations may, but are not required to, throw this
     *         exception if {@code fromKey} cannot be compared to keys
     *         currently in the Association
     * @throws NullPointerException if {@code fromKey} is {@code null}
     *         and this Association does not allow {@code null} keys
     * @throws IllegalArgumentException if this Association itself has a
     *         restricted range, and {@code fromKey} falls outside the
     *         bounds of the range
     */
    NavigableAssociation<K, V, ?> tail(K fromKey, boolean inclusive);
}
