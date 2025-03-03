package org.moodminds.elemental;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

import static java.util.Objects.requireNonNull;

/**
 * A {@link SequenceIterator} for {@link TailedSequence} that supports traversal
 * in both forward and backward directions, allowing navigation from the both ends of a sequence.
 * Adds additional methods {@link #hasPrevious()}, {@link #previous()} and {@link #previousIndex()
 * for reverse traversal. There is no current element in such an iterator; its <I>cursor position</I> always
 * lies between the element that would be returned by a call to {@link #previous()}
 * and the element that would be returned by a call to {@link #next()}.
 *
 * @param <V> the type of elements
 */
public interface TailedSequenceIterator<E> extends SequenceIterator<E> {

    /**
     * Return {@code true} if there are more elements in the sequence when traversing
     * in the reverse direction. In other words, return {@code true} if a call to {@link #previous}
     * would successfully return an element rather than throwing an exception.
     *
     * @return {@code true} if there are additional elements when traversing in reverse order
     */
    boolean hasPrevious();

    /**
     * Return the previous element in the sequence and moves the cursor position backward.
     * This method can be called repeatedly to iterate through the sequence in reverse order,
     * or alternated with calls to {@link #next} to move both forwards and backwards.
     * <p>Note: Consecutive calls to {@code next} followed by {@code previous} will repeatedly
     * return the same element.
     *
     * @return the previous element in the sequence
     * @throws NoSuchElementException if there are no previous elements in the sequence
     */
    E previous();

    /**
     * Return the index of the element that would be returned by the next call to {@link #previous}.
     * If the iterator is positioned at the start of the sequence, return {@code -1}.
     *
     * @return the index of the element to be returned by {@code previous},
     *         or {@code -1} if the iterator is at the beginning of the sequence
     */
    int previousIndex();

    /**
     * Execute the given action for each preceding element in reverse order,
     * processing all elements unless an exception is thrown by the action.
     * <p>
     * If the iteration order is defined, actions are applied in reverse.
     * Any exceptions thrown by the action are propagated to the caller.
     * <p>
     * Modifying the source during iteration (e.g., using {@link #remove remove}
     * or other mutator methods) results in undefined behavior, unless a subclass
     * explicitly allows concurrent modifications.
     * <p>
     * If the action throws an exception, the subsequent behavior of the iterator
     * is unspecified.
     *
     * @implSpec
     * The default implementation operates as follows:
     * <pre>{@code
     *     while (hasPrevious())
     *         action.accept(previous());
     * }</pre>
     *
     * @param action The action to perform on each element
     * @throws NullPointerException if the action is {@code null}
     */
    default void forEachPreceding(Consumer<? super E> action) {
        requireNonNull(action);
        while (hasPrevious())
            action.accept(previous());
    }
}
