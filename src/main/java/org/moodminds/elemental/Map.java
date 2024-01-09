package org.moodminds.elemental;

import java.util.Spliterator;

import static java.util.Spliterator.DISTINCT;

/**
 * A mutative extension of the {@link Association} interface, which also extends
 * the {@link java.util.Map} interface.
 *
 * @param <K> the type of keys
 * @param <V> the type of values
 */
public interface Map<K, V> extends Association<K, V, Map.Entry<K, V>>, java.util.Map<K, V> {

    /**
     * Retrieve the value associated with the given key from this map.
     * Return {@code null} if no mapping for the key exists.
     *
     * <p>More precisely, if this map contains a mapping from a key
     * {@code k} to a value {@code v} such that
     * {@code Objects.equals(key, k)},
     * this method returns {@code v}; otherwise, it returns {@code null}.
     * (There can be, at most, one such mapping.)
     *
     * <p>If this map allows {@code null} values, a return value of
     * {@code null} doesn't necessarily mean the map lacks a mapping for the key;
     * it's also possible that the map explicitly maps the key to {@code null}.
     * You can use the {@link #containsKey containsKey} operation to distinguish
     * between these scenarios.
     *
     * @param key the key for which the associated value is requested
     * @return the value associated with the specified key, or
     *         {@code null} if no mapping exists for the key
     * @throws ClassCastException if the key has an incompatible type for this map
     * @throws NullPointerException if the specified key is {@code null} and this map
     *         doesn't allow {@code null} keys
     */
    @Override
    @SuppressWarnings("unchecked")
    V get(Object key);

    /**
     * {@inheritDoc}
     *
     * @param key {@inheritDoc}
     * @param defaultValue {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException  {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    default V getOrDefault(Object key, V defaultValue) {
        return java.util.Map.super.getOrDefault(key, defaultValue);
    }

    /**
     * Copy all mappings from the provided {@link Association} to this map
     * (optional operation). This operation is equivalent to invoking
     * {@link #put(Object, Object) put(k, v)} on this map once for each
     * mapping in the specified {@link Association}, where key {@code k} is
     * associated with value {@code v}. The behavior of this operation is
     * undefined if the specified {@link Association} is modified while the
     * operation is in progress.
     *
     * @param a the associations to be copied into this map
     * @throws UnsupportedOperationException if the {@code putAll} operation
     *         is not supported by this map
     * @throws ClassCastException if the class of a key or value in the
     *         specified {@link Association} prevents it from being stored in this map
     * @throws NullPointerException if the specified {@link Association} is {@code null},
     *         or if this map does not allow {@code null} keys or values, and the
     *         specified {@link Association} contains {@code null} keys or values
     * @throws IllegalArgumentException if a key or value in the specified
     *         {@link Association} has a property that prevents it from being
     *         stored in this map
     */
    default void putAll(Association<? extends K, ? extends V, ?> a) {
        for (KeyValue<? extends K, ? extends V> kv : a)
            put(kv.getKey(), kv.getValue());
    }

    /**
     * Copy all mappings from the provided {@link java.util.Map} to this map
     * (optional operation). This operation is equivalent to invoking
     * {@link #put(Object, Object) put(k, v)} on this map once for each
     * mapping in the specified {@link java.util.Map}, where key {@code k} is
     * associated with value {@code v}. The behavior of this operation is
     * undefined if the specified {@link java.util.Map} is modified while the
     * operation is in progress.
     *
     * @param m the associations to be copied into this map
     * @throws UnsupportedOperationException if the {@code putAll} operation
     *         is not supported by this map
     * @throws ClassCastException if the class of a key or value in the
     *         specified {@link java.util.Map} prevents it from being stored in this map
     * @throws NullPointerException if the specified {@link java.util.Map} is {@code null},
     *         or if this map does not allow {@code null} keys or values, and the
     *         specified {@link java.util.Map} contains {@code null} keys or values
     * @throws IllegalArgumentException if a key or value in the specified
     *         {@link java.util.Map} has a property that prevents it from being
     *         stored in this map
     */
    @Override
    void putAll(java.util.Map<? extends K, ? extends V> m);

    /**
     * Copy all mappings from the provided {@link Map} to this map
     * (optional operation). This operation is equivalent to invoking
     * {@link #put(Object, Object) put(k, v)} on this map once for each
     * mapping in the specified {@link Map}, where key {@code k} is
     * associated with value {@code v}. The behavior of this operation is
     * undefined if the specified {@link Map} is modified while the
     * operation is in progress.
     *
     * @param m the associations to be copied into this map
     * @throws UnsupportedOperationException if the {@code putAll} operation
     *         is not supported by this map
     * @throws ClassCastException if the class of a key or value in the
     *         specified {@link Map} prevents it from being stored in this map
     * @throws NullPointerException if the specified {@link Map} is {@code null},
     *         or if this map does not allow {@code null} keys or values, and the
     *         specified {@link Map} contains {@code null} keys or values
     * @throws IllegalArgumentException if a key or value in the specified
     *         {@link Map} has a property that prevents it from being
     *         stored in this map
     */
    default void putAll(Map<? extends K, ? extends V> m) {
        putAll((java.util.Map<? extends K, ? extends V>) m);
    }

    /**
     * {@inheritDoc}
     *
     * @param value {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    default boolean containsValue(Object value) {
        return Association.super.containsValue(value);
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    Set<java.util.Map.Entry<K, V>> entrySet();

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    Set<K> keySet();

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    Collection<V> values();

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    default Spliterator<Map.Entry<K, V>> spliterator() {
        return java.util.Spliterators.spliterator(iterator(), size(), DISTINCT);
    }

    /**
     * A map entry {@link KeyValue} pair. Also extends the {@link java.util.Map.Entry} interface.
     *
     * @param <K> the type of the key
     * @param <V> the type of the value
     */
    interface Entry<K, V> extends KeyValue<K, V>, java.util.Map.Entry<K, V> {

        /**
         * {@inheritDoc}
         *
         * @return {@inheritDoc}
         * @throws IllegalStateException {@inheritDoc}
         */
        @Override
        @SuppressWarnings("unchecked")
        K getKey();

        /**
         * {@inheritDoc}
         *
         * @return {@inheritDoc}
         * @throws IllegalStateException {@inheritDoc}
         */
        @Override
        @SuppressWarnings("unchecked")
        V getValue();

        /**
         * {@inheritDoc}
         *
         * @param value {@inheritDoc}
         * @return {@inheritDoc}
         * @throws UnsupportedOperationException {@inheritDoc}
         * @throws ClassCastException {@inheritDoc}
         * @throws NullPointerException {@inheritDoc}
         * @throws IllegalArgumentException {@inheritDoc}
         * @throws IllegalStateException {@inheritDoc}
         */
        V setValue(V value);
    }
}
