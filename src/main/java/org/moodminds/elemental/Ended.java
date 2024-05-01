package org.moodminds.elemental;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A double-ended linear {@link Container} that facilitates access
 * to elements at both head and tail via the {@link #iterator()}
 * and {@link #descendingIterator()} methods, respectively.
 *
 * @param <E> the type of elements
 */
public interface Ended<E> extends Container<E> {

    /**
     * Retrieve the first element (head) of this Container.
     *
     * @return the first element (head) of this Container
     * @throws NoSuchElementException if this Container is empty
     * @param <R> the type of return value
     */
    @SuppressWarnings("unchecked")
    default <R extends E> R getFirst() {
        return (R) iterator().next();
    }

    /**
     * Retrieve the last element (tail) of this Container.
     *
     * @return the last element (tail) of this Container
     * @throws NoSuchElementException if this Container is empty
     * @param <R> the type of return value
     */
    @SuppressWarnings("unchecked")
    default <R extends E> R getLast() {
        return (R) descendingIterator().next();
    }

    /**
     * Returns an iterator that provides elements in proper order, from the first (head).
     *
     * @return an iterator for the elements in proper order (from the head)
     */
    @Override
    Iterator<E> iterator();

    /**
     * Returns an iterator that provides elements in reverse order, from the last (tail).
     *
     * @return an iterator for the elements in reverse order (from the tail)
     */
    Iterator<E> descendingIterator();
}
