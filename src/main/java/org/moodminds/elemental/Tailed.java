package org.moodminds.elemental;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A double-ended linear {@link Container} that allows access to elements
 * from the tail end through the {@link #descendingIterator()} method.
 *
 * @param <E> the type of elements in this container
 */
public interface Tailed<E> extends Container<E> {

    /**
     * Retrieve objects that match the provided example in regular order (from the head).
     *
     * @param o the reference object for comparison
     * @return an {@link Iterator} of objects that match the provided example in regular order (from the head)
     * @throws ClassCastException if the type of the example is not compatible
     *         with this Container (optional)
     * @throws NullPointerException if the example is {@code null} or contains internal {@code null} values,
     *         and this Container does not allow that (optional)
     */
    @Override
    Iterator<E> getAll(Object o);

    /**
     * Retrieve objects that match the provided example in reverse order (from the tail).
     *
     * @param o the reference object for comparison
     * @return an {@link Iterator} of objects that match the provided example in reverse order (from the tail)
     * @throws ClassCastException if the type of the example is not compatible
     *         with this Container (optional)
     * @throws NullPointerException if the example is {@code null} or contains internal {@code null} values,
     *         and this Container does not allow that (optional)
     */
    Iterator<E> getAllDescending(Object o);

    /**
     * Return an {@link Iterator} that provides elements in proper order, from the first (head).
     *
     * @return an {@link Iterator} for the elements in proper order (from the head)
     */
    @Override
    Iterator<E> iterator();

    /**
     * Return an {@link Iterator} that provides elements in reverse order, from the last (tail).
     *
     * @return an {@link Iterator} for the elements in reverse order (from the tail)
     */
    Iterator<E> descendingIterator();

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
}
