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
    E peek();

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @throws NoSuchElementException {@inheritDoc}
     */
    @Override
    E element();

    /**
     * {@inheritDoc}
     *
     * @param o {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    boolean remove(Object o);

    /**
     * {@inheritDoc}
     *
     * @param o {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    boolean contains(Object o);
}
