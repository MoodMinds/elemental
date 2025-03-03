package org.moodminds.elemental;

/**
 * A blocking extension of the {@link Queue} interface, which also extends
 * the {@link java.util.concurrent.BlockingQueue} interface.
 *
 * @param <V> the type of elements
 */
public interface BlockingQueue<E> extends Queue<E>, java.util.concurrent.BlockingQueue<E> {

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
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    default boolean contains(Object o) {
        return Queue.super.contains(o);
    }
}
