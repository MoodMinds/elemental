package org.moodminds.elemental;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Objects.requireNonNull;
import static java.util.Spliterator.DISTINCT;

/**
 * A mutative extension of the {@link Association} interface,
 * which also extends the {@link java.util.Map} interface.
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
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    default V getOrDefault(Object key, V defaultValue) {
        return java.util.Map.super.getOrDefault(key, defaultValue);
    }

    /**
     * {@inheritDoc}
     * <p>
     * Optionally replaces the existing key instance with the given one. Implementations
     * decide whether to implement real key instance replacement or not, which may be
     * ignored for various reasons.
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
    V put(K key, V value);

    /**
     * Copy all mappings from the provided {@link Association} to this map
     * (optional operation). This operation is equivalent to invoking
     * {@link #put(Object, Object) put(k, v)} on this map once for each
     * mapping in the specified {@link Association}, where key {@code k} is
     * associated with value {@code v}. The behavior of this operation is
     * undefined if the specified {@link Association} is modified while the
     * operation is in progress.
     * <p>
     * Optionally replaces the existing keys instances with the given ones. Implementations
     * decide whether to implement real keys instances replacement or not, which may be
     * ignored for various reasons.
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
     * <p>
     * Optionally replaces the existing keys instances with the given ones. Implementations
     * decide whether to implement real keys instances replacement or not, which may be
     * ignored for various reasons.
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
     * <p>
     * Optionally replaces the existing keys instances with the given ones. Implementations
     * decide whether to implement real keys instances replacement or not, which may be
     * ignored for various reasons.
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
     * <p>
     * Optionally replaces the existing key instance with the given one. Implementations
     * decide whether to implement real key instance replacement or not, which may be
     * ignored for various reasons.
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
    default V putIfAbsent(K key, V value) {
        return java.util.Map.super.putIfAbsent(key, value);
    }

    /**
     * {@inheritDoc}
     * <p>
     * Optionally replaces the existing key instance with the given one. Implementations
     * decide whether to implement real key instance replacement or not, which may be
     * ignored for various reasons.
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
        return java.util.Map.super.compute(key, remappingFunction);
    }

    /**
     * {@inheritDoc}
     * <p>
     * Optionally replaces the existing key instance with the given one. Implementations
     * decide whether to implement real key instance replacement or not, which may be
     * ignored for various reasons.
     *
     * @param key {@inheritDoc}
     * @param mappingFunction {@inheritDoc}
     * @return {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    default V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        return java.util.Map.super.computeIfAbsent(key, mappingFunction);
    }

    /**
     * {@inheritDoc}
     * <p>
     * Optionally replaces the existing key instance with the given one. Implementations
     * decide whether to implement real key instance replacement or not, which may be
     * ignored for various reasons.
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
    default V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return java.util.Map.super.computeIfPresent(key, remappingFunction);
    }

    /**
     * {@inheritDoc}
     * <p>
     * Optionally replaces the existing key instance with the given one. Implementations
     * decide whether to implement real key instance replacement or not, which may be
     * ignored for various reasons.
     *
     * @param key {@inheritDoc}
     * @param value {@inheritDoc}
     * @param remappingFunction {@inheritDoc}
     * @return {@inheritDoc}
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    default V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        return java.util.Map.super.merge(key, value, remappingFunction);
    }

    /**
     * Replace the existing key instance with the given one. Implementations
     * decide whether to implement real key instance replacement or not, which may be
     * ignored for various reasons.
     *
     * @param key the equivalent key to replace the existing key
     * @return the value associated with the specified key, or {@code null}
     *         if there was no mapping for the key, or if map previously associated
     *         {@code null} with the key, if the implementation supports null values
     * @throws UnsupportedOperationException if the {@code put} operation is not supported by this map
     * @throws ClassCastException if the class of the specified key
     *         prevents it from being stored in this map
     * @throws NullPointerException if the specified key is null,
     *         and this map does not permit null keys
     * @throws IllegalArgumentException if some property of the specified key
     *         prevents it from being stored in this map
     */
    V replace(K key);

    /**
     * {@inheritDoc}
     * <p>
     * Optionally replaces the existing key instance with the given one. Implementations
     * decide whether to implement real key instance replacement or not, which may be
     * ignored for various reasons.
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
    default V replace(K key, V value) {
        return java.util.Map.super.replace(key, value);
    }

    /**
     * {@inheritDoc}
     * <p>
     * Optionally replaces the existing key instance with the given one. Implementations
     * decide whether to implement real key instance replacement or not, which may be
     * ignored for various reasons.
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
    default boolean replace(K key, V oldValue, V newValue) {
        return java.util.Map.super.replace(key, oldValue, newValue);
    }

    /**
     * Remove a single entry from this Map that satisfies
     * the specified {@link K key} and {@link V value} {@link BiPredicate}.
     *
     * @implSpec
     * The default implementation iterates over the entries of the Map using its {@link #iterator}.
     * When an entry satisfies the predicate, it is removed using {@link Iterator#remove()}.
     *
     * @param filter the predicate used to determine which entry to remove
     * @return {@code true} if any entry was removed
     * @throws NullPointerException if the specified {@link BiPredicate} is null
     * @throws UnsupportedOperationException if entries cannot be removed from this Map
     */
    default boolean removeIf(BiPredicate<? super K, ? super V> filter) {
        requireNonNull(filter);
        for (Iterator<Map.Entry<K, V>> it = iterator(); it.hasNext(); ) {
            Entry<K, V> entry = it.next();
            if (filter.test(entry.getKey(), entry.getValue())) {
                it.remove(); return true; }
        } return false;
    }

    /**
     * Remove a single entry from this Map that satisfies
     * the specified {@link V value} {@link Predicate}.
     *
     * @implSpec
     * The default implementation iterates over the entries of the Map using its {@link #iterator}.
     * When an entry's value satisfies the predicate, it is removed using {@link Iterator#remove()}.
     *
     * @param filter the predicate used to determine which entry to remove
     * @return {@code true} if any entry was removed
     * @throws NullPointerException if the specified {@link Predicate} is null
     * @throws UnsupportedOperationException if entries cannot be removed from this Map
     */
    default boolean removeIfValue(Predicate<? super V> filter) {
        requireNonNull(filter); return removeIf((k, v) -> filter.test(v));
    }

    /**
     * Retain only the entries in this Map that satisfy
     * the specified {@link K key} and {@link V value} {@link BiPredicate}.
     *
     * @implSpec
     * The default implementation iterates over all entries of the Map using its {@link #iterator}.
     * Each entry that does not satisfy the predicate is removed using {@link Iterator#remove()}.
     *
     * @param filter the predicate used to determine which entry to retain
     * @return {@code true} if any entries were removed
     * @throws NullPointerException if the specified {@link BiPredicate} is null
     * @throws UnsupportedOperationException if entries cannot be removed from this Map
     */
    default boolean retainIf(BiPredicate<? super K, ? super V> filter) {
        requireNonNull(filter); boolean modified = false;
        for (Iterator<Map.Entry<K, V>> it = iterator(); it.hasNext(); ) {
            Entry<K, V> entry = it.next();
            if (!filter.test(entry.getKey(), entry.getValue())) {
                it.remove(); modified = true; }
        } return modified;
    }

    /**
     * Retain only the entries in this Map that satisfy
     * the specified {@link V value} {@link Predicate}.
     *
     * @implSpec
     * The default implementation iterates over all entries of the Map using its {@link #iterator}.
     * Each entry, which value does not satisfy the predicate, is removed using {@link Iterator#remove()}.
     *
     * @param filter the predicate used to determine which entry to retain
     * @return {@code true} if any entries were removed
     * @throws NullPointerException if the specified {@link Predicate} is null
     * @throws UnsupportedOperationException if entries cannot be removed from this Map
     */
    default boolean retainIfValue(Predicate<? super V> filter) {
        requireNonNull(filter); return retainIf((k, v) -> filter.test(v));
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
    default Container<K> keys() {
        return keySet();
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    Set<K> keySet();

    /**
     * Return a {@link Collection} view of the values contained in this map.
     * <p>
     * Note: This method returns {@link Collection} solely due to the interface
     * extending {@link java.util.Map} itself. If you intend to perform such
     * a hacky O(n) complexity action as:
     * <pre>{@code
     *     map.values().remove(value);
     * }</pre>,
     * or, perish the thought,
     * <pre>{@code
     *     while (map.values().remove(value));
     * }</pre>
     * - consider using the {@link #removeIf(BiPredicate)}, {@link #removeIfValue(Predicate)}
     * or {@link #retainIf(BiPredicate)}, {@link #retainIfValue(Predicate)} methods instead.
     *
     * @return a {@link Collection} view of the values contained in this map
     */
    @Override
    Collection<V> values();

    /**
     * {@inheritDoc}
     * <p>
     * @deprecated This method is here solely due to the interface extending {@link java.util.Map} itself.
     * There is no scenario that cannot be accomplished using the {@link Map} interface as a
     * {@link Container} of {@link Entry entries} alongside direct mutation methods provided
     * by {@link Map}. Usage of this method is not recommended unless for legacy purposes
     * or for compatibility with code which safely utilizes a {@link java.util.Collection} result
     * from this method as an unmodifiable or partially operational {@link java.util.Collection}.
     *
     * @return {@inheritDoc}
     */
    @Override
    @Deprecated
    Set<java.util.Map.Entry<K, V>> entrySet();

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default Spliterator<Map.Entry<K, V>> spliterator() {
        return java.util.Spliterators.spliterator(iterator(), size(), DISTINCT);
    }

    /**
     * {@inheritDoc}
     *
     * @param action {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws ConcurrentModificationException {@inheritDoc}
     */
    @Override
    default void forEach(BiConsumer<? super K, ? super V> action) {
        java.util.Map.super.forEach(action);
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
         * Replace the key corresponding to this entry with the specified
         * equivalent key instance (optional operation). The behavior of
         * this call is undefined if the mapping has already been removed
         * from the map (by an iterator's {@code remove} operation).
         * <p>
         * Key replacement is only possible if the specified key is equal
         * to the existing key. Otherwise, an {@link IllegalArgumentException} is thrown.
         * <p>
         * Implementations decide whether to implement real key instance
         * replacement or not, which may be ignored for various reasons.
         *
         * @param key the new key to be associated with this entry
         * @return the old key instance corresponding to the entry
         * @throws ClassCastException if the class of the specified key
         *         prevents it from being stored in the backing map
         * @throws NullPointerException if the backing map does not permit
         *         null keys, and the specified key is null
         * @throws IllegalArgumentException if the given key is not equal to the existing key
         *         or if some property of this key prevents it from being stored in the backing map
         * @throws IllegalStateException implementations may, but are not required to,
         *         throw this exception if the entry has been removed from the backing map
         * @throws UnsupportedOperationException if the operation is not supported
         *         by the backing map
         */
        K setKey(K key);

        /**
         * {@inheritDoc}
         *
         * @param value {@inheritDoc}
         * @return {@inheritDoc}
         * @throws ClassCastException {@inheritDoc}
         * @throws NullPointerException {@inheritDoc}
         * @throws IllegalArgumentException {@inheritDoc}
         * @throws IllegalStateException {@inheritDoc}
         * @throws UnsupportedOperationException {@inheritDoc}
         */
        V setValue(V value);
    }
}
