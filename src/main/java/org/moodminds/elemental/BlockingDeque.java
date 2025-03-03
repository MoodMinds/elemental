package org.moodminds.elemental;

import java.util.NoSuchElementException;

/**
 * A blocking extension of the {@link Deque} interface, which also extends
 * the {@link BlockingQueue} and the {@link java.util.concurrent.BlockingDeque} interfaces.
 *
 * @param <E> the type of elements
 */
public interface BlockingDeque<E> extends BlockingQueue<E>, Deque<E>, java.util.concurrent.BlockingDeque<E> {

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default E poll() {
        return Deque.super.poll();
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @throws NoSuchElementException {@inheritDoc}
     */
    @Override
    default E element() {
        return Deque.super.element();
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default E peek() {
        return Deque.super.peek();
    }

    /**
     * {@inheritDoc}
     *
     * @param v {@inheritDoc}
     * @throws IllegalStateException {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    default void addLast(E v) {
        Deque.super.addLast(v);
    }

    /**
     * {@inheritDoc}
     *
     * @param v {@inheritDoc}
     * @throws IllegalStateException {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    default void push(E v) {
        Deque.super.push(v);
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
        return Deque.super.remove(o);
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
        return Deque.super.contains(o);
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @throws NoSuchElementException {@inheritDoc}
     */
    @Override
    default E remove() {
        return Deque.super.remove();
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
    default boolean removeFirstOccurrence(Object o) {
        return Deque.super.removeFirstOccurrence(o);
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
    default boolean removeLastOccurrence(Object o) {
        return Deque.super.removeLastOccurrence(o);
    }
}
