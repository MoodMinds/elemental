package org.moodminds.elemental;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A double-ended linear {@link Container} that facilitates access
 * to elements at both head and tail via the {@link #iterator()}
 * and {@link #descendingIterator()} methods, respectively.
 *
 * @param <V> the type of elements
 */
public interface Ended<V> extends Container<V> {

    /**
     * Retrieve objects that match the provided example in reverse order (from the last).
     *
     * @param o the reference object for comparison
     * @return an {@link Iterator} of objects that match the provided example in reverse order (from the last)
     * @throws ClassCastException if the type of the example is not compatible
     *         with this Container (optional)
     * @throws NullPointerException if the example is {@code null} or contains internal {@code null} values,
     *         and this Container does not allow that (optional)
     */
    Iterator<V> getAllDescending(Object o);

    /**
     * Returns an iterator that provides elements in proper order, from the first (head).
     *
     * @return an iterator for the elements in proper order (from the head)
     */
    @Override
    Iterator<V> iterator();

    /**
     * Returns an iterator that provides elements in reverse order, from the last (tail).
     *
     * @return an iterator for the elements in reverse order (from the tail)
     */
    Iterator<V> descendingIterator();

    /**
     * Retrieve the first element (head) of this Container.
     *
     * @return the first element (head) of this Container
     * @throws NoSuchElementException if this Container is empty
     * @param <R> the type of return value
     */
    @SuppressWarnings("unchecked")
    default <R extends V> R getFirst() {
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
    default <R extends V> R getLast() {
        return (R) descendingIterator().next();
    }
}
