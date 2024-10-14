package org.moodminds.elemental;

/**
 * A navigable extension of the {@link SortedMap} interface, which also extends
 * the {@link NavigableAssociation} and {@link java.util.NavigableMap} interfaces.
 *
 * @param <K> the type of keys
 * @param <V> the type of values
 */
public interface NavigableMap<K, V> extends SortedMap<K, V>, NavigableAssociation<K, V, Map.Entry<K, V>>,
        java.util.NavigableMap<K, V> {

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
     * @param key {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    Map.Entry<K, V> lowerEntry(K key);

    /**
     * {@inheritDoc}
     *
     * @param key {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    Map.Entry<K, V> floorEntry(K key);

    /**
     * {@inheritDoc}
     *
     * @param key {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    Map.Entry<K, V> ceilingEntry(K key);

    /**
     * {@inheritDoc}
     *
     * @param key {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    Map.Entry<K, V> higherEntry(K key);

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    Map.Entry<K, V> firstEntry();

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    Map.Entry<K, V> lastEntry();

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    Map.Entry<K, V> pollFirstEntry();

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    Map.Entry<K, V> pollLastEntry();

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default NavigableMap<K, V> descending() {
        return descendingMap();
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    NavigableMap<K, V> descendingMap();

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    NavigableSet<K> navigableKeySet();

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    NavigableSet<K> descendingKeySet();

    /**
     * {@inheritDoc}
     *
     * @param fromKey {@inheritDoc}
     * @param fromInclusive {@inheritDoc}
     * @param toKey {@inheritDoc}
     * @param toInclusive {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    default NavigableMap<K, V> sub(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {
        return subMap(fromKey, fromInclusive, toKey, toInclusive);
    }

    /**
     * {@inheritDoc}
     *
     * @param fromKey {@inheritDoc}
     * @param fromInclusive {@inheritDoc}
     * @param toKey {@inheritDoc}
     * @param toInclusive {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive);

    /**
     * {@inheritDoc}
     *
     * @param toKey {@inheritDoc}
     * @param inclusive {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    default NavigableMap<K, V> head(K toKey, boolean inclusive) {
        return headMap(toKey, inclusive);
    }

    /**
     * {@inheritDoc}
     *
     * @param toKey {@inheritDoc}
     * @param inclusive {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    NavigableMap<K, V> headMap(K toKey, boolean inclusive);

    /**
     * {@inheritDoc}
     *
     * @param fromKey {@inheritDoc}
     * @param inclusive {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    default NavigableMap<K, V> tail(K fromKey, boolean inclusive) {
        return tailMap(fromKey, inclusive);
    }

    /**
     * {@inheritDoc}
     *
     * @param fromKey {@inheritDoc}
     * @param inclusive {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    NavigableMap<K, V> tailMap(K fromKey, boolean inclusive);

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
        return SortedMap.super.sub(fromKey, toKey);
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
        return SortedMap.super.head(toKey);
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
        return SortedMap.super.tail(fromKey);
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
