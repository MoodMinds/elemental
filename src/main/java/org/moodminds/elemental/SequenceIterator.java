package org.moodminds.elemental;

/**
 * A {@link PreviousIterator} for {@link Sequence} that provides
 * information about the current position within the sequence.
 *
 * @param <V> the type of elements
 */
public interface SequenceIterator<V> extends PreviousIterator<V> {

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
