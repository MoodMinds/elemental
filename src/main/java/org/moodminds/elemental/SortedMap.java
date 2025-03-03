package org.moodminds.elemental;

import org.moodminds.elemental.Map.Entry;

/**
 * A sorted extension of the {@link Map} interface, which also extends
 * the {@link SortedAssociation} and {@link java.util.SortedMap} interfaces.
 *
 * @param <K> the type of keys
 * @param <V> the type of values
 */
public interface SortedMap<K, V> extends Map<K, V>, SortedAssociation<K, V, Entry<K, V>>,
        java.util.SortedMap<K, V> {

    /**
     * {@inheritDoc}
     *
     * @param key {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    V get(Object key);

    /**
     * {@inheritDoc}
     *
     * @param fromKey {@inheritDoc}
     * @param toKey {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    default SortedMap<K, V> sub(K fromKey, K toKey) {
        return subMap(fromKey, toKey);
    }

    /**
     * {@inheritDoc}
     *
     * @param fromKey {@inheritDoc}
     * @param toKey {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    SortedMap<K, V> subMap(K fromKey, K toKey);

    /**
     * {@inheritDoc}
     *
     * @param toKey {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    default SortedMap<K, V> head(K toKey) {
        return headMap(toKey);
    }

    /**
     * {@inheritDoc}
     *
     * @param toKey {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    SortedMap<K, V> headMap(K toKey);

    /**
     * {@inheritDoc}
     *
     * @param fromKey {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    default SortedMap<K, V> tail(K fromKey) {
        return tailMap(fromKey);
    }

    /**
     * {@inheritDoc}
     *
     * @param fromKey {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    SortedMap<K, V> tailMap(K fromKey);
}
