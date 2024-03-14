package org.moodminds.elemental;

import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;

import static java.util.Spliterator.ORDERED;

/**
 * Represents a type of {@link Ended linear Container} that is classified
 * as an {@link Ordered}, signifying its capability to maintain the order
 * of its elements and access by their positional indices.
 * <p>
 * Provides elements read {@link #get(int)} method by the specified position index.
 *
 * @param <E> the element type
 *
 * @see RandomGet
 */
public interface Sequence<E> extends Ended<E>, Ordered<E> {

    /**
     * Return the element at the specified position in this sequence.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this sequence
     * @throws IndexOutOfBoundsException if the index is out of range
     *
     * @see RandomGet
     */
    @Override
    <R extends E> R get(int index);

    /**
     * Compute and return the hash code value for this Sequence. The hash code of a Sequence
     * is determined using the following formula:
     *
     * <pre>{@code
     *     int hashCode = 1;
     *     for (E element : sequence)
     *         hashCode = 31 * hashCode + (element == null ? 0 : element.hashCode());
     * }</pre>
     *
     * This calculation ensures that if two sequences, 'seq1' and 'seq2', are equal
     * according to the {@link Object#equals(Object) equals} method, then their hash
     * codes, as obtained by 'seq1.hashCode()' and 'seq2.hashCode()', will also be equal.
     * This is a requirement of the general contract of {@link Object#hashCode}.
     *
     * @return the computed hash code value for this Sequence
     */
    @Override
    int hashCode();

    /**
     * Compare this Sequence with the provided object for equality. Return
     * {@code true} if and only if the object is also a Sequence, if this Sequence
     * is equatable to it, both Sequences have the same size, and all corresponding
     * pairs of elements in the two Sequences are <i>equal</i>. Two elements {@code e1}
     * and {@code e2} are considered <i>equal</i> if {@code Objects.equals(e1, e2)}.
     * <p>
     * In simpler terms, two Sequences are considered equal if they are equatable to each other
     * and if they contain the same elements in the same order.
     * This definition ensures that the equals method works consistently across different
     * implementations of the {@code Sequence} interface.
     *
     * @param o the object to be compared with this Sequence for equality
     * @return {@code true} if the provided object is equal to this Sequence
     */
    @Override
    boolean equals(Object o);

    /**
     * Return a view of the portion of this Sequence between the specified
     * {@code fromIndex}, inclusive, and {@code toIndex}, exclusive.
     *
     * @param fromIndex low endpoint (inclusive) of the sub
     * @param toIndex   high endpoint (exclusive) of the sub
     * @return a view of the specified range within this Sequence
     * @throws IndexOutOfBoundsException for an illegal endpoint index value
     *                                   ({@code fromIndex < 0 || toIndex > size || fromIndex > toIndex})
     */
    Sequence<E> sub(int fromIndex, int toIndex);

    /**
     * Retrieves a {@link SequenceIterator} that iterates over the elements in this Sequence,
     * commencing at the specified position within the Sequence.
     * The provided index indicates the initial element to be returned by the
     * first invocation of {@link SequenceIterator#next next}. Subsequently,
     * calling {@link SequenceIterator#previous previous} would yield the element
     * preceding the specified index.
     *
     * @param index the index of the first element to be retrieved by the
     *              sequence iterator (via a call to {@link SequenceIterator#next next})
     * @return a sequence iterator over the elements in this sequence, commencing
     * from the specified position within the sequence
     * @throws IndexOutOfBoundsException if the index is not within the valid range
     *                                   ({@code index < 0 || index > size()})
     */
    SequenceIterator<E> sequenceIterator(int index);

    /**
     * Return a {@link SequenceIterator} for this sequence, enabling traversal over the elements
     * in their proper sequence.
     *
     * @return an iterator for this sequence, preserving the proper sequence of elements
     */
    default SequenceIterator<E> sequenceIterator() {
        return sequenceIterator(0);
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default Iterator<E> descendingIterator() {
        return new Iterator<E>() {

            final SequenceIterator<E> iterator = sequenceIterator(size());

            @Override public boolean hasNext() {
                return iterator.hasPrevious(); }
            @Override public E next() {
                return iterator.previous(); }
            @Override public void remove() {
                iterator.remove(); }
        };
    }

    /**
     * Return a {@link Spliterator} over the elements described by this Sequence.
     *
     * @implNote This Spliterator has {@link Spliterator#ORDERED} characteristic.
     *
     * @return a {@code Spliterator} over the elements described by this Sequence
     */
    @Override
    default Spliterator<E> spliterator() {
        return java.util.Spliterators.spliterator(iterator(), size(), ORDERED);
    }

    /**
     * Return the first occurrence index position of the specified object.
     *
     * @param o the specified object
     * @return the index position of the specified object, or -1 if this sequence does not contain the element
     * @throws ClassCastException   if the type of the specified element
     *                              is incompatible with this Sequence
     * @throws NullPointerException if the specified element is {@code null} and this
     *                              Sequence does not permit {@code null} elements
     */
    default int indexOf(Object o) {
        int index = -1;
        Iterator<E> iterator = iterator();
        while (iterator.hasNext() && Objects.equals(iterator.next(), o))
            index++;
        return index;
    }

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
        int index = -1, i = 0;
        for (E e : this) {
            if (Objects.equals(e, o))
                index = i;
            i++;
        } return index;
    }
}
