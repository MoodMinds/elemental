package org.moodminds.elemental;

import java.util.NoSuchElementException;
import java.util.Spliterator;

/**
 * A sorted extension of the {@link Set} interface, which also
 * extends the {@link SortedCollection} and {@link java.util.SortedSet} interfaces.
 *
 * @param <E> the type of elements
 */
public interface SortedSet<E> extends Set<E>, SortedCollection<E>, java.util.SortedSet<E> {

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @throws NoSuchElementException {@inheritDoc}
     */
    @Override
    default E first() {
        return SortedCollection.super.first();
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @throws NoSuchElementException {@inheritDoc}
     */
    @Override
    default E last() {
        return SortedCollection.super.last();
    }

    /**
     * {@inheritDoc}
     *
     * @param fromElement {@inheritDoc}
     * @param toElement {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    default SortedSet<E> sub(E fromElement, E toElement) {
        return subSet(fromElement, toElement);
    }

    /**
     * {@inheritDoc}
     *
     * @param fromElement {@inheritDoc}
     * @param toElement {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    SortedSet<E> subSet(E fromElement, E toElement);

    /**
     * {@inheritDoc}
     *
     * @param toElement {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    default SortedSet<E> head(E toElement) {
        return headSet(toElement);
    }

    /**
     * {@inheritDoc}
     *
     * @param toElement {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    SortedSet<E> headSet(E toElement);

    /**
     * {@inheritDoc}
     *
     * @param fromElement {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    default SortedSet<E> tail(E fromElement) {
        return tailSet(fromElement);
    }

    /**
     * {@inheritDoc}
     *
     * @param fromElement {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    SortedSet<E> tailSet(E fromElement);

    /**
     * Create a {@code Spliterator} to traverse the elements in this sorted set.
     *
     * <p>The {@code Spliterator} is marked with the characteristics {@link Spliterator#DISTINCT},
     * {@link Spliterator#SORTED}, and {@link Spliterator#ORDERED}.
     * Implementations may document additional characteristics they report.
     *
     * <p>The spliterator's comparator (see {@link java.util.Spliterator#getComparator()}) must be {@code null}
     * if the sorted set's comparator (see {@link #comparator()}) is {@code null}.
     * Otherwise, the spliterator's comparator must be the same as or impose the
     * same total ordering as the sorted set's comparator.
     *
     * @implSpec
     * The default implementation creates a <em><a href="Spliterator.html#binding">late-binding</a></em>
     * spliterator from the sorted set's {@code Iterator}. The spliterator inherits the <em>fail-fast</em>
     * behavior of the set's iterator. The spliterator's comparator is the same as the sorted set's comparator.
     * <p>
     * The resulting {@code Spliterator} also has the {@link Spliterator#SIZED} characteristic.
     *
     * @implNote
     * The resulting {@code Spliterator} additionally has the {@link Spliterator#SUBSIZED} characteristic.
     *
     * @return a {@code Spliterator} to traverse the elements in this sorted set
     */
    @Override
    default Spliterator<E> spliterator() {
        return java.util.SortedSet.super.spliterator();
    }
}
