package org.moodminds.elemental;

import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * An {@link Association} that additionally organizes its keys in a specific sequence.
 * The ordering of keys in this Association is determined by either the natural order of keys,
 * as defined by their inherent properties, or by a user-supplied {@link Comparator},
 * typically specified when creating a sorted Association.
 *
 * @param <K> the type of keys
 * @param <V> the type of values
 */
public interface SortedAssociation<K, V, KV extends KeyValue<? extends K, ? extends V>> extends Association<K, V, KV> {

    /**
     * Return the first (lowest) key in this Association.
     *
     * @return the first (lowest) key in this Association
     * @throws NoSuchElementException if this Association is empty
     */
    K firstKey();

    /**
     * Return the last (highest) key in this Association.
     *
     * @return the last (highest) key in this Association
     * @throws NoSuchElementException if this Association is empty
     */
    K lastKey();

    /**
     * Retrieve the key comparator employed for sorting keys within this Association.
     * If this Association utilizes the natural ordering of its keys, return {@code null}.
     *
     * @return the key comparator used for sorting keys within this Association,
     *         or {@code null} if the natural ordering of its keys is employed
     */
    Comparator<? super K> comparator();

    /**
     * Retrieve a view of the section within this Association where keys fall within
     * the range from {@code fromKey}, inclusive, to {@code toKey}, exclusive. If
     * {@code fromKey} and {@code toKey} are equal, the resulting Association is empty.
     *
     * @param fromKey the lower bound (inclusive) of keys in the returned Association
     * @param toKey the upper bound (exclusive) of keys in the returned Association
     * @return a view of the section of this Association where keys range from
     *         {@code fromKey}, inclusive, to {@code toKey}, exclusive
     * @throws ClassCastException if {@code fromKey} and {@code toKey}
     *         cannot be compared using this Association's comparator
     *         (or, if the Association has no comparator, using natural ordering).
     *         Implementations may, but are not required to, throw this
     *         exception if {@code fromKey} or {@code toKey}
     *         cannot be compared to keys currently in the Association
     * @throws NullPointerException if {@code fromKey} or {@code toKey}
     *         is {@code null} and this Association doesn't allow {@code null} keys
     * @throws IllegalArgumentException if {@code fromKey} is greater than
     *         {@code toKey}, or if this Association itself has a restricted
     *         range, and {@code fromKey} or {@code toKey} falls
     *         outside of that range
     */
    SortedAssociation<K, V, ?> sub(K fromKey, K toKey);

    /**
     * Retrieve a view of the section within this Association where keys are
     * strictly less than {@code toKey}.
     *
     * @param toKey the upper bound (exclusive) of keys in the returned Association
     * @return a view of the section of this Association where keys are strictly
     *         less than {@code toKey}
     * @throws ClassCastException if {@code toKey} is incompatible with
     *         this Association's comparator (or, if the Association has no comparator,
     *         if {@code toKey} does not implement {@link Comparable}).
     *         Implementations may, but are not required to, throw this
     *         exception if {@code toKey} cannot be compared to keys
     *         currently in the Association
     * @throws NullPointerException if {@code toKey} is {@code null} and
     *         this Association does not permit {@code null} keys
     * @throws IllegalArgumentException if this Association itself has a
     *         restricted range, and {@code toKey} falls outside the
     *         bounds of the range
     */
    SortedAssociation<K, V, ?> head(K toKey);

    /**
     * Retrieve a view of the section within this Association where keys are
     * greater than or equal to {@code fromKey}.
     *
     * @param fromKey the lower bound (inclusive) of keys in the returned Association
     * @return a view of the section of this Association where keys are greater
     *         than or equal to {@code fromKey}
     * @throws ClassCastException if {@code fromKey} is incompatible with
     *         this Association's comparator (or, if the Association has no comparator,
     *         if {@code fromKey} does not implement {@link Comparable}).
     *         Implementations may, but are not required to, throw this
     *         exception if {@code fromKey} cannot be compared to keys
     *         currently in the Association
     * @throws NullPointerException if {@code fromKey} is {@code null} and
     *         this Association does not permit {@code null} keys
     * @throws IllegalArgumentException if this Association itself has a
     *         restricted range, and {@code fromKey} falls outside the
     *         bounds of the range
     */
    SortedAssociation<K, V, ?> tail(K fromKey);
}
