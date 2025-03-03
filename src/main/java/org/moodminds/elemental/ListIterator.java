package org.moodminds.elemental;

/**
 * A mutative extension of the {@link TailedSequenceIterator} interface,
 * which also extends the {@link java.util.ListIterator} interface.
 *
 * @param <E> the type of elements
 */
public interface ListIterator<E> extends TailedSequenceIterator<E>, java.util.ListIterator<E> {

    /**
     * {@inheritDoc}
     *
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws IllegalStateException {@inheritDoc}
     */
    @Override
    void remove();
}
