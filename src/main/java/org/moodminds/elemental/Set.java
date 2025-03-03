package org.moodminds.elemental;

import java.util.Spliterator;

/**
 * A unique-values {@link Collection}, which also extends the {@link java.util.Set} interface.
 *
 * @param <E> the type of elements
 */
public interface Set<E> extends Collection<E>, java.util.Set<E> {

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
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default boolean isEmpty() {
        return Collection.super.isEmpty();
    }

    /**
     * {@inheritDoc}
     *
     * @param c {@inheritDoc}
     * @return {@inheritDoc}
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     * @throws IllegalStateException {@inheritDoc}
     */
    @Override
    default boolean addAll(java.util.Collection<? extends E> c) {
        return Collection.super.addAll(c);
    }

    /**
     * {@inheritDoc}
     *
     * @param o {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws UnsupportedOperationException {@inheritDoc}
     */
    @Override
    default boolean remove(Object o) {
        return Collection.super.remove(o);
    }

    /**
     * {@inheritDoc}
     *
     * @param c {@inheritDoc}
     * @return {@inheritDoc}
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    default boolean removeAll(java.util.Collection<?> c) {
        return Collection.super.removeAll(c);
    }

    /**
     * {@inheritDoc}
     *
     * @param  c {@inheritDoc}
     * @return {@inheritDoc}
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    default boolean retainAll(java.util.Collection<?> c) {
        return Collection.super.retainAll(c);
    }

    /**
     * {@inheritDoc}
     *
     * @param o {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    default boolean contains(Object o) {
        return Collection.super.contains(o);
    }

    /**
     * {@inheritDoc}
     *
     * @param c {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    default boolean containsAll(java.util.Collection<?> c) {
        return Collection.super.containsAll(c);
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default Object[] toArray() {
        return Collection.super.toArray();
    }

    /**
     * {@inheritDoc}
     *
     * @param a {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ArrayStoreException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    default <T> T[] toArray(T[] a) {
        return Collection.super.toArray(a);
    }

    /**
     * Create a {@code Spliterator} to iterate over the elements in this set.
     *
     * <p>The {@code Spliterator} is marked with the characteristic {@link Spliterator#DISTINCT}.
     * Implementations may document additional characteristics they report.
     *
     * @implSpec
     * The default implementation generates a
     * <em><a href="Spliterator.html#binding">late-binding</a></em> spliterator
     * from the set's {@code Iterator}. The spliterator inherits the
     * <em>fail-fast</em> behavior of the set's iterator.
     * <p>
     * The resulting {@code Spliterator} also has the {@link Spliterator#SIZED} characteristic.
     *
     * @implNote
     * The resulting {@code Spliterator} additionally has the {@link Spliterator#SUBSIZED} characteristic.
     *
     * @return a {@code Spliterator} to iterate over the elements in this set
     */
    @Override
    default Spliterator<E> spliterator() {
        return java.util.Set.super.spliterator();
    }
}
