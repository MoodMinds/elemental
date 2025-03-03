package org.moodminds.elemental;

/**
 * A navigable extension of the {@link ConcurrentMap} interface, which also extends
 * the {@link NavigableMap} and {@link java.util.concurrent.ConcurrentNavigableMap} interfaces.
 *
 * @param <K> the type of keys
 * @param <V> the type of values
 */
public interface ConcurrentNavigableMap<K, V> extends ConcurrentMap<K, V>, NavigableMap<K, V>,
        java.util.concurrent.ConcurrentNavigableMap<K, V> {

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
    default ConcurrentNavigableMap<K, V> sub(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {
        return (ConcurrentNavigableMap<K, V>) NavigableMap.super.sub(fromKey, fromInclusive, toKey, toInclusive);
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
    ConcurrentNavigableMap<K,V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive);

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
    default ConcurrentNavigableMap<K, V> head(K toKey, boolean inclusive) {
        return (ConcurrentNavigableMap<K, V>) NavigableMap.super.head(toKey, inclusive);
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
    ConcurrentNavigableMap<K,V> headMap(K toKey, boolean inclusive);

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
    default ConcurrentNavigableMap<K, V> tail(K fromKey, boolean inclusive) {
        return (ConcurrentNavigableMap<K, V>) NavigableMap.super.tail(fromKey, inclusive);
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
    ConcurrentNavigableMap<K,V> tailMap(K fromKey, boolean inclusive);

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
    default ConcurrentNavigableMap<K, V> sub(K fromKey, K toKey) {
        return (ConcurrentNavigableMap<K, V>) NavigableMap.super.sub(fromKey, toKey);
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
    ConcurrentNavigableMap<K,V> subMap(K fromKey, K toKey);

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
    default ConcurrentNavigableMap<K, V> head(K toKey) {
        return (ConcurrentNavigableMap<K, V>) NavigableMap.super.head(toKey);
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
    ConcurrentNavigableMap<K,V> headMap(K toKey);

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
    default ConcurrentNavigableMap<K, V> tail(K fromKey) {
        return (ConcurrentNavigableMap<K, V>) NavigableMap.super.tail(fromKey);
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
    ConcurrentNavigableMap<K,V> tailMap(K fromKey);

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default ConcurrentNavigableMap<K, V> descending() {
        return (ConcurrentNavigableMap<K, V>) NavigableMap.super.descending();
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    ConcurrentNavigableMap<K,V> descendingMap();

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
    NavigableSet<K> keySet();

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    NavigableSet<K> descendingKeySet();
}
