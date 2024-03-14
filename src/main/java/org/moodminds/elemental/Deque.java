package org.moodminds.elemental;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A {@link Ended double-ended} {@link Queue}, which also extends the {@link java.util.Deque} interface.
 *
 * @param <V> the type of elements
 */
public interface Deque<V> extends Queue<V>, Ended<V>, java.util.Deque<V> {

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default V peek() {
        return peekFirst();
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @throws NoSuchElementException {@inheritDoc}
     */
    @Override
    default V element() {
        return getFirst();
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @throws NoSuchElementException {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    default V getFirst() {
        return Ended.super.getFirst();
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default V peekFirst() {
        Iterator<V> it = iterator(); return it.hasNext() ? it.next() : null;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @throws NoSuchElementException {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    default V getLast() {
        return Ended.super.getLast();
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default V peekLast() {
        Iterator<V> it = descendingIterator(); return it.hasNext() ? it.next() : null;
    }

    /**
     * {@inheritDoc}
     *
     * @param c {@inheritDoc}
     * @return {@inheritDoc}
     * @throws IllegalStateException {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    default boolean addAll(java.util.Collection<? extends V> c) {
        return Queue.super.addAll(c);
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
    default boolean remove(Object o) {
        return Queue.super.remove(o);
    }

    /**
     * {@inheritDoc}
     *
     * @param o {@inheritDoc}
     * @return {@code true} {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    default boolean contains(Object o) {
        return Queue.super.contains(o);
    }
}
