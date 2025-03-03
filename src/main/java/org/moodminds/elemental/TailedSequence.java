package org.moodminds.elemental;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * Represents a type of {@link Sequence} that is classified
 * as a {@link Tailed}, facilitating access to elements at both head and tail.
 *
 * @param <E> the element type
 */
public interface TailedSequence<E> extends Tailed<E>, Sequence<E> {

    /**
     * Return a {@link TailedSequenceIterator} that provides elements in reverse order, from the last (tail).
     *
     * @return a {@link TailedSequenceIterator} for the elements in reverse order (from the tail)
     */
    @Override
    default Iterator<E> descendingIterator() {
        return new Iterator<E>() {

            final TailedSequenceIterator<E> iterator = iterator(size());

            @Override public boolean hasNext() { return iterator.hasPrevious(); }
            @Override public E next() { return iterator.previous(); }
            @Override public void remove() { iterator.remove(); }
            @Override public void forEachRemaining(Consumer<? super E> action) {
                iterator.forEachPreceding(action); }
        };
    }

    /**
     * Retrieve a {@link TailedSequenceIterator} that iterates over the elements in this Sequence,
     * commencing at the specified position within the Sequence.
     * The provided index indicates the initial element to be returned by the
     * first invocation of {@link TailedSequenceIterator#next next}.
     *
     * @param index the index of the first element to be retrieved by the
     *              sequence iterator (via a call to {@link TailedSequenceIterator#next next})
     * @return a sequence iterator over the elements in this sequence, commencing
     * from the specified position within the sequence
     * @throws IndexOutOfBoundsException if the index is not within the valid range
     *                                   ({@code index < 0 || index > size()})
     */
    @Override
    TailedSequenceIterator<E> iterator(int index);

    /**
     * {@inheritDoc}
     *
     * @param fromIndex {@inheritDoc}
     * @param toIndex {@inheritDoc}
     * @return {@inheritDoc}
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    TailedSequence<E> sub(int fromIndex, int toIndex);

    /**
     * Return the last index position of occurrences of the specified object.
     *
     * @param o the specified object
     * @return the last index position of the specified object, or -1 if this Sequence does not contain the element
     * @throws ClassCastException   if the type of the specified element
     *                              is incompatible with this Sequence
     * @throws NullPointerException if the specified element is {@code null} and this
     *                              Sequence does not permit {@code null} elements
     */
    default int lastIndexOf(Object o) {
        TailedSequenceIterator<E> it = iterator(size());
        while (it.hasPrevious())
            if (Objects.equals(it.previous(), o))
                return it.nextIndex();
        return -1;
    }
}
