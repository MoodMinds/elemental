package org.moodminds.elemental;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Spliterator;

import static java.util.Spliterator.DISTINCT;
import static java.util.Spliterator.IMMUTABLE;

/**
 * An associative {@link Container} of values accessible by their keys. Association
 * cannot contain duplicate keys, each key can be associated with at most one value.
 *
 * @param <K> the type of keys
 * @param <V> the type of values
 * @param <KV> the type of {@link KeyValue} entries
 */
public interface Association<K, V, KV extends KeyValue<K, V>> extends Container<KV> {

    /**
     * Return the value to which the specified key is associated. If the specified key
     * is not associated with any value in this Association - {@code null} can be returned
     * or {@link NoSuchElementException} may be thrown.
     *
     * @param key the specified key
     * @return the value to which the specified key is associated, or {@code null}
     * if the specified key is not associated with any value
     * @throws ClassCastException     if the key is of an inappropriate type for this Association
     * @throws NullPointerException   if the specified key is {@code null} and this Association does not permit {@code null} keys
     * @throws NoSuchElementException if the specified key is not associated with any value
     * @param <R> the type of return value
     */
    <R extends V> R get(Object key);

    /**
     * Retrieve an {@link Iterator} of a single key-value pair that matches the given example.
     *
     * @param o the example key-value pair to compare
     * @return an {@link Iterator} of a single key-value pair that matches the specified example
     * @throws NullPointerException if the provided key-value example is {@code null} or has {@code null} key (optional)
     */
    @Override
    Iterator<KV> getAll(Object o);

    /**
     * {@inheritDoc}
     *
     * @param o {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    default int getCount(Object o) {
        return contains(o) ? 1 : 0;
    }

    /**
     * Retrieve the value associated with the specified key, or returns the default value if none is found.
     *
     * @param key          the key whose associated value is to be retrieved
     * @param defaultValue the default value to return if the key is not found
     * @return the value associated with the specified key, or the default value if not found
     * @throws ClassCastException   if the key's type is incompatible with this association
     * @throws NullPointerException if the key is {@code null} and {@code null} keys are not allowed in this association
     */
    default V getOrDefault(Object key, V defaultValue) {
        V v = get(key); return v != null || containsKey(key) ? v : defaultValue;
    }

    /**
     * Determine whether this Association includes a key-value pair that matches the provided example.
     *
     * @param o the example key-value pair to compare
     * @return {@code true} if this Association contains the examined element
     * @throws NullPointerException if the provided key-value example is {@code null} or has {@code null} key (optional)
     */
    @Override
    default boolean contains(Object o) {
        return Container.super.contains(o);
    }

    /**
     * Return a {@link Spliterator} over the key-value pairs described by this Association.
     *
     * @return a {@code Spliterator} over the key-value pairs described by this Association
     */
    default Spliterator<KV> spliterator() {
        return java.util.Spliterators.spliterator(iterator(), size(), IMMUTABLE | DISTINCT);
    }

    /**
     * Return {@code true} if the specified key is associated with a value in this Association.
     *
     * @param key key whose presence in this Association is to be tested
     * @return {@code true} if the specified key is associated with a value in this Association
     * @throws ClassCastException   if the key is of an inappropriate type for this Association
     * @throws NullPointerException if the specified key is {@code null} and this Association does not permit {@code null} keys
     */
    boolean containsKey(Object key);

    /**
     * Return {@code true} if the specified value is associated with one or more keys in this Association.
     *
     * @param value value whose presence in this Association is to be tested
     * @return {@code true} if the specified value is associated with one or more keys in this Association
     * @throws ClassCastException   if the value is of an inappropriate type for this map
     * @throws NullPointerException if the specified value is {@code null} and this map does not permit {@code null} values
     */
    default boolean containsValue(Object value) {
        for (KV kv : this)
            if (Objects.equals(kv.getValue(), value))
                return true;
        return false;
    }
}
