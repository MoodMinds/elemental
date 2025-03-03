package org.moodminds.elemental;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An {@link Iterator} for {@link Sequence} that provides
 * information about the current position within the sequence.
 *
 * @param <E> the type of elements
 */
public interface SequenceIterator<E> extends Iterator<E> {

    /**
     * Check if there are more elements available when traversing the sequence in the forward direction.
     *
     * @return {@code true} if additional elements remain in the forward traversal
     */
    @Override
    boolean hasNext();

    /**
     * Retrieve the next element in the sequence and advance the iterator’s position.
     * This method can be called repeatedly to iterate over the sequence.
     *
     * @return the next element in the sequence
     * @throws NoSuchElementException if there are no further elements in the sequence
     */
    @Override
    E next();

    /**
     * Retrieve the index of the element that will be returned by a
     * future invocation of {@link #next}. If the iterator has reached
     * the end of the sequence, Return the size of the sequence.
     *
     * @return the index of the element that will be returned by a future
     *         call to {@code next}, or the size of the sequence if the
     *         iterator is at the end
     */
    int nextIndex();

    /**
     * Remove the last element returned by {@link #next} from the sequence (optional operation).
     * This method may be invoked only once per call to {@link #next}.
     *
     * @throws UnsupportedOperationException if the {@code remove} operation is not supported by this iterator
     * @throws IllegalStateException if {@link #next} has not yet been called,
     * or if {@code remove} was already called after the last {@code next} call
     */
    @Override
    default void remove() {
        Iterator.super.remove();
    }
}
