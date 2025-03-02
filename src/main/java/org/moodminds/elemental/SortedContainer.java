package org.moodminds.elemental;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A specialized {@link Container} that maintains an <i>ordered</i> arrangement of its elements.
 * Elements within this Container are organized according to their inherent {@linkplain Comparable natural
 * ordering}, or a custom {@link Comparator} can be specified during the creation of a sorted Container.
 *
 * @param <E> the type of elements contained
 */
public interface SortedContainer<E> extends Container<E> {

    /**
     * Return the first (lowest) element of this Container.
     *
     * @return the first (lowest) element of this Container
     * @throws NoSuchElementException if this Container is empty
     */
    default E first() {
        return firstAll().next();
    }

    /**
     * Return the first (lowest) elements currently in this Container.
     *
     * @return the first (lowest) elements currently in this Container
     */
    Iterator<E> firstAll();

    /**
     * Return the last (highest) element of this Container.
     *
     * @return the last (highest) element of this Container
     * @throws NoSuchElementException if this Container is empty
     */
    default E last() {
        return lastAll().next();
    }

    /**
     * Return the last (highest) elements currently in this Container.
     *
     * @return the last (highest) elements currently in this Container
     * @throws NoSuchElementException if this Container is empty
     */
    Iterator<E> lastAll();

    /**
     * Retrieve the {@link Comparator} responsible for arranging the elements within this Container.
     * Return {@code null} if this Container relies on the {@linkplain Comparable natural ordering} of its elements.
     *
     * @return the comparator responsible for ordering elements in this Container, or {@code null}
     * if the natural ordering of elements is used
     */
    Comparator<? super E> comparator();

    /**
     * Retrieve a view of the portion of this Container containing elements that fall within the
     * range from {@code fromElement} (inclusive) to {@code toElement} (exclusive).
     * If {@code fromElement} and {@code toElement} are equal, the resulting Container is empty.
     *
     * @param fromElement the inclusive lower endpoint of the desired subset
     * @param toElement the exclusive upper endpoint of the desired subset
     * @return a view of the portion of this Container containing elements within
     *         the range from {@code fromElement} (inclusive) to {@code toElement} (exclusive)
     * @throws ClassCastException if {@code fromElement} and {@code toElement} cannot be compared
     *         using this Container's comparator (or natural ordering if none is specified).
     *         Implementations may, at their discretion, throw this exception if
     *         {@code fromElement} or {@code toElement} cannot be compared to elements
     *         currently in the Container.
     * @throws NullPointerException if {@code fromElement} or {@code toElement} is {@code null},
     *         and this Container does not accept {@code null} elements
     * @throws IllegalArgumentException if {@code fromElement} is greater than {@code toElement},
     *         or if this Container itself has a restricted range, and either
     *         {@code fromElement} or {@code toElement} lies outside of that range
     */
    SortedContainer<E> sub(E fromElement, E toElement);

    /**
     * Retrieve a view of the portion of this Container consisting of elements
     * that are strictly less than {@code toElement}.
     *
     * @param toElement the exclusive upper endpoint of the desired subset
     * @return a view of the portion of this Container containing elements that are
     *         strictly less than {@code toElement}
     * @throws ClassCastException if {@code toElement} is not compatible
     *         with this Container's comparator (or, if the Container has no comparator,
     *         if {@code toElement} does not implement {@link Comparable}).
     *         Implementations may, at their discretion, throw this
     *         exception if {@code toElement} cannot be compared to elements
     *         currently in the Container
     * @throws NullPointerException if {@code toElement} is {@code null} and
     *         this Container does not accept {@code null} elements
     * @throws IllegalArgumentException if this Container itself has a
     *         restricted range, and {@code toElement} is outside the
     *         bounds of that range
     */
    SortedContainer<E> head(E toElement);

    /**
     * Retrieve a view of the portion of this Container containing elements
     * that are greater than or equal to {@code fromElement}.
     *
     * @param fromElement the inclusive lower endpoint of the desired subset
     * @return a view of the portion of this Container containing elements that are
     *         greater than or equal to {@code fromElement}
     * @throws ClassCastException if {@code fromElement} is not compatible
     *         with this Container's comparator (or, if the Container has no comparator,
     *         if {@code fromElement} does not implement {@link Comparable}).
     *         Implementations may, at their discretion, throw this
     *         exception if {@code fromElement} cannot be compared to elements
     *         currently in the Container
     * @throws NullPointerException if {@code fromElement} is {@code null}
     *         and this Container does not accept {@code null} elements
     * @throws IllegalArgumentException if this Container itself has a
     *         restricted range, and {@code fromElement} is outside the
     *         bounds of that range
     */
    SortedContainer<E> tail(E fromElement);
}
