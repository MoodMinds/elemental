package org.moodminds.elemental;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * A concurrent extension of the {@link Map} interface, which also extends
 * the {@link java.util.concurrent.ConcurrentMap} interface.
 *
 * @param <K> the type of keys
 * @param <V> the type of values
 */
public interface ConcurrentMap<K, V> extends Map<K, V>, java.util.concurrent.ConcurrentMap<K, V> {

    /**
     * {@inheritDoc}
     *
     * @param key {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
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
        return Map.super.getOrDefault(key, defaultValue);
    }

    /**
     * {@inheritDoc}
     *
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    default void forEach(BiConsumer<? super K, ? super V> action) {
        java.util.concurrent.ConcurrentMap.super.forEach(action);
    }

    /**
     * {@inheritDoc}
     *
     * @param key {@inheritDoc}
     * @param value {@inheritDoc}
     * @return {@inheritDoc}
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    boolean remove(Object key, Object value);

    /**
     * {@inheritDoc}
     *
     * @param key {@inheritDoc}
     * @param value {@inheritDoc}
     * @return {@inheritDoc}
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    V replace(K key, V value);

    /**
     * {@inheritDoc}
     *
     * @param key {@inheritDoc}
     * @param oldValue {@inheritDoc}
     * @param newValue {@inheritDoc}
     * @return {@inheritDoc}
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    boolean replace(K key, V oldValue, V newValue);

    /**
     * {@inheritDoc}
     *
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    default void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
        java.util.concurrent.ConcurrentMap.super.replaceAll(function);
    }

    /**
     * {@inheritDoc}
     *
     * @param key {@inheritDoc}
     * @param value {@inheritDoc}
     * @return {@inheritDoc}
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    V putIfAbsent(K key, V value);

    /**
     * {@inheritDoc}
     *
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    default V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        return java.util.concurrent.ConcurrentMap.super.computeIfAbsent(key, mappingFunction);
    }

    /**
     * {@inheritDoc}
     *
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    default V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return java.util.concurrent.ConcurrentMap.super.computeIfPresent(key, remappingFunction);
    }

    /**
     * {@inheritDoc}
     *
     * @param key {@inheritDoc}
     * @param remappingFunction {@inheritDoc}
     * @return {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    default V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return java.util.concurrent.ConcurrentMap.super.compute(key, remappingFunction);
    }

    /**
     * {@inheritDoc}
     *
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    default V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        return java.util.concurrent.ConcurrentMap.super.merge(key, value, remappingFunction);
    }
}
