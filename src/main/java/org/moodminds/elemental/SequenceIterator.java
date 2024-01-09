package org.moodminds.elemental;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A versatile iterator for {@link Sequence} that enables traversal of the sequence
 * in both forward and backward directions while providing information about the
 * current position within the sequence.
 *
 * @param <E> the type of elements
 */
public interface SequenceIterator<E> extends Iterator<E> {

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    boolean hasNext();

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @throws NoSuchElementException {@inheritDoc}
     */
    E next();

    /**
     * Determine whether this iterator has additional elements when moving
     * in the reverse direction, returning {@code true} if there are more
     * elements available for retrieval using {@link #previous} without
     * encountering an exception.
     *
     * @return {@code true} if there are more elements available for retrieval
     *         in the reverse direction, {@code false} otherwise
     */
    boolean hasPrevious();

    /**
     * Retrieve the element that precedes the current cursor position and
     * moves the cursor backward. This method can be used iteratively to
     * navigate backward through the sequence or can be mixed with calls
     * to {@link #next} to traverse back and forth. It's important to note
     * that alternating calls to {@code next} and {@code previous} will
     * yield the same element repeatedly.
     *
     * @return the element preceding the current cursor position
     * @throws NoSuchElementException if there are no previous elements
     *         in the iteration
     */
    E previous();

    /**
     * Retrieve the index of the element that will be returned by a
     * future invocation of {@link #next}. If the iterator has reached
     * the end of the sequence, it returns the size of the sequence.
     *
     * @return the index of the element that will be returned by a future
     *         call to {@code next}, or the size of the sequence if the
     *         iterator is at the end
     */
    int nextIndex();

    /**
     * Retrieve the index of the element that will be returned by a
     * future invocation of {@link #previous}. If the iterator is positioned
     * at the beginning of the sequence, it returns -1.
     *
     * @return the index of the element that will be returned by a future
     *         call to {@code previous}, or -1 if the iterator is at the
     *         beginning of the sequence
     */
    int previousIndex();
}
