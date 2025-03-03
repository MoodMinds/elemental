package org.moodminds.elemental;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.BiConsumer;

import static java.util.Objects.requireNonNull;
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
public interface Association<K, V, KV extends KeyValue<? extends K, ? extends V>> extends Container<KV> {

    /**
     * Return the value to which the specified key is associated. If the specified key
     * is not associated with any value in this Association - {@code null} can be returned
     * or {@link NoSuchElementException} may be thrown. A {@code null} return can also
     * indicate that the {@code null} is associated with {@code key}, if the implementation
     * supports {@code null} values.
     *
     * @param key the specified key
     * @return the value to which the specified key is associated, or {@code null}
     * if the specified key is not associated with any value
     * @throws ClassCastException if the key is of an inappropriate type for this Association
     * @throws NullPointerException if the specified key is {@code null} and this Association does not permit {@code null} keys
     * @throws NoSuchElementException if the specified key is not associated with any value
     * @param <R> the type of return value
     */
    <R extends V> R get(Object key);

    /**
     * Retrieve an {@link Iterator} of a single key-value pair that matches the given example.
     *
     * @param o the example key-value pair to compare
     * @return an {@link Iterator} of a single key-value pair that matches the specified example
     * @throws ClassCastException if the specified object is not a compatible {@link KV} type
     * for this Association, or if its key or value has an incompatible type
     * @throws NullPointerException if the provided key-value example is {@code null} or has {@code null} key (optional)
     */
    @Override
    Iterator<KV> getAll(Object o);

    /**
     * Retrieve single key-value pair number that matches the given example.
     *
     * @param o the example key-value pair to compare
     * @return single key-value pair number that matches the given example
     * @throws ClassCastException if the specified object is not a compatible {@link KV} type
     * for this Association, or if its key or value has an incompatible type
     * @throws NullPointerException if the provided key-value example is {@code null} or has {@code null} key (optional)
     */
    @Override
    int getCount(Object o);

    /**
     * Retrieve the value associated with the specified key, or return the default value if none is found.
     *
     * @param key          the key whose associated value is to be retrieved
     * @param defaultValue the default value to return if the key is not found
     * @return the value associated with the specified key, or the default value if not found
     * @throws ClassCastException if the key's type is incompatible with this association
     * @throws NullPointerException if the key is {@code null} and {@code null} keys are not allowed in this association
     */
    default V getOrDefault(Object key, V defaultValue) {
        V v = get(key); return v != null || containsKey(key) ? v : defaultValue;
    }

    /**
     * Return a {@link Container} view of the keys contained in this Association.
     *
     * @return a {@link Container} view of the keys contained in this Association
     */
    Container<K> keys();

    /**
     * Return a {@link Container} view of the values contained in this Association.
     *
     * @return a {@link Container} view of the values contained in this Association
     */
    Container<V> values();

    /**
     * Determine whether this Association includes an entry that matches the provided key-value pair example.
     *
     * @param o the example key-value pair to compare
     * @return {@code true} if this Association contains the examined element
     * @throws ClassCastException if the specified object is not a compatible {@link KV} type
     * for this Association, or if its key or value has an incompatible type
     * @throws NullPointerException if the provided key-value example is {@code null} or has {@code null} key (optional)
     */
    @Override
    default boolean contains(Object o) {
        return Container.super.contains(o);
    }

    /**
     * Determine whether this Association includes an entry of the provided key and value.
     *
     * @param key the specified key to check
     * @param value the specified value to check
     * @return {@code true} if this Association contains an entry of the provided key and value
     * @throws ClassCastException if the key or value is of an inappropriate type for this Association
     * @throws NullPointerException if the provided key or value is {@code null} (optional)
     */
    boolean contains(Object key, Object value);

    /**
     * Return {@code true} if the specified key is associated with a value in this Association.
     *
     * @param key key whose presence in this Association is to be tested
     * @return {@code true} if the specified key is associated with a value in this Association
     * @throws ClassCastException if the key is of an inappropriate type for this Association
     * @throws NullPointerException if the specified key is {@code null} and this Association does not permit {@code null} keys
     */
    boolean containsKey(Object key);

    /**
     * Return {@code true} if the specified value is associated with one or more keys in this Association.
     *
     * @param value value whose presence in this Association is to be tested
     * @return {@code true} if the specified value is associated with one or more keys in this Association
     * @throws ClassCastException if the value is of an inappropriate type for this Association
     * @throws NullPointerException if the specified value is {@code null} and this Association does not permit {@code null} values
     */
    default boolean containsValue(Object value) {
        for (KV kv : this)
            if (Objects.equals(kv.getValue(), value))
                return true;
        return false;
    }

    /**
     * Return a {@link Spliterator} over the key-value pairs described by this Association.
     *
     * @return a {@code Spliterator} over the key-value pairs described by this Association
     */
    @Override
    default Spliterator<KV> spliterator() {
        return java.util.Spliterators.spliterator(iterator(), size(), IMMUTABLE | DISTINCT);
    }

    /**
     * Perform the specified action for each {@link KV} entry in this Association until either
     * all entries have been processed or the action throws an exception. Unless otherwise
     * specified by the implementing class, the actions are performed in the order of
     * entries iteration (if an iteration order is specified). Any exceptions thrown by
     * the action are relayed to the caller.
     *
     * @implSpec
     * The default implementation is equivalent to the following for this {@code association}:
     * <pre>{@code
     *      association.forEach(kv -> action.accept(kv.getKey(), kv.getValue()));
     * }</pre>
     *
     * @param action the action to be performed for each {@link KV} entry
     * @throws NullPointerException if the specified action is null
     * @throws RuntimeException if an error occurred during iteration
     */
    default void forEach(BiConsumer<? super K, ? super V> action) {
        requireNonNull(action); forEach(kv -> action.accept(kv.getKey(), kv.getValue()));
    }
}
