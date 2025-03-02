package org.moodminds.elemental;

import java.util.Iterator;

/**
 * An extension of a {@link SortedContainer} that offers additional navigation methods
 * to identify and provide information about the nearest matches for specified search targets.
 *
 * @param <E> the type of elements
 */
public interface NavigableContainer<E> extends SortedContainer<E> {

    /**
     * Retrieve the greatest element in this Container that is strictly less than the
     * given element, or {@code null} if no such element exists.
     *
     * @param e the value to compare against
     * @return the greatest element less than {@code e},
     *         or {@code null} if no such element exists
     * @throws ClassCastException if the specified element cannot be
     *         compared with the elements currently in the Container
     * @throws NullPointerException if the specified element is {@code null}
     *         and this Container does not accept {@code null} elements
     */
    default E lower(E e) {
        Iterator<E> iterator = lowerAll(e); return iterator.hasNext() ? iterator.next() : null;
    }

    /**
     * Retrieve the greatest elements in this Container that
     * are strictly less than the given element.
     *
     * @param e the value to compare against
     * @return the greatest elements less than {@code e}
     * @throws ClassCastException if the specified element cannot be
     *         compared with the elements currently in the Container
     * @throws NullPointerException if the specified element is {@code null}
     *         and this Container does not accept {@code null} elements
     */
    Iterator<E> lowerAll(E e);

    /**
     * Retrieve the greatest element in this Container that is less than or equal to
     * the given element, or {@code null} if no such element exists.
     *
     * @param e the value to compare against
     * @return the greatest element less than or equal to {@code e},
     *         or {@code null} if no such element exists
     * @throws ClassCastException if the specified element cannot be
     *         compared with the elements currently in the Container
     * @throws NullPointerException if the specified element is {@code null}
     *         and this Container does not accept {@code null} elements
     */
    default E floor(E e) {
        Iterator<E> iterator = floorAll(e); return iterator.hasNext() ? iterator.next() : null;
    }

    /**
     * Retrieve the greatest elements in this Container that
     * are less than or equal to the given element.
     *
     * @param e the value to compare against
     * @return the greatest elements less than or equal to {@code e}
     * @throws ClassCastException if the specified element cannot be
     *         compared with the elements currently in the Container
     * @throws NullPointerException if the specified element is {@code null}
     *         and this Container does not accept {@code null} elements
     */
    Iterator<E> floorAll(E e);

    /**
     * Retrieve the least element in this Container that is greater than or equal to
     * the given element, or {@code null} if no such element exists.
     *
     * @param e the value to compare against
     * @return the least element greater than or equal to {@code e},
     *         or {@code null} if no such element exists
     * @throws ClassCastException if the specified element cannot be
     *         compared with the elements currently in the Container
     * @throws NullPointerException if the specified element is {@code null}
     *         and this Container does not accept {@code null} elements
     */
    default E ceiling(E e) {
        Iterator<E> iterator = ceilingAll(e); return iterator.hasNext() ? iterator.next() : null;
    }

    /**
     * Retrieve the least elements in this Container that
     * are greater than or equal to the given element.
     *
     * @param e the value to compare against
     * @return the least elements greater than or equal to {@code e}
     * @throws ClassCastException if the specified element cannot be
     *         compared with the elements currently in the Container
     * @throws NullPointerException if the specified element is {@code null}
     *         and this Container does not accept {@code null} elements
     */
    Iterator<E> ceilingAll(E e);

    /**
     * Retrieve the least element in this Container that is strictly greater than the
     * given element, or {@code null} if no such element exists.
     *
     * @param e the value to compare against
     * @return the least element greater than {@code e},
     *         or {@code null} if no such element exists
     * @throws ClassCastException if the specified element cannot be
     *         compared with the elements currently in the Container
     * @throws NullPointerException if the specified element is {@code null}
     *         and this Container does not accept {@code null} elements
     */
    default E higher(E e) {
        Iterator<E> iterator = higherAll(e); return iterator.hasNext() ? iterator.next() : null;
    }

    /**
     * Retrieve the least elements in this Container that
     * are strictly greater than the given element.
     *
     * @param e the value to compare against
     * @return the least elements greater than {@code e}
     * @throws ClassCastException if the specified element cannot be
     *         compared with the elements currently in the Container
     * @throws NullPointerException if the specified element is {@code null}
     *         and this Container does not accept {@code null} elements
     */
    Iterator<E> higherAll(E e);

    /**
     * Provide an iterator over the elements in this Container, arranged in ascending order.
     *
     * @return an iterator over the elements in this Container, in ascending order
     */
    @Override
    Iterator<E> iterator();

    /**
     * Provide a view of the elements in this Container in reverse order.
     *
     * @return a reverse order view of this Container
     */
    NavigableContainer<E> descending();

    /**
     * Retrieve a view of the portion of this Container containing elements that fall within the range
     * from {@code fromElement} (inclusive) to {@code toElement} (exclusive).
     * If {@code fromElement} and {@code toElement} are equal and both {@code fromInclusive} and
     * {@code toInclusive} are true, the resulting Container contains a single element; otherwise, it's empty.
     *
     * @param fromElement the inclusive lower endpoint of the desired subset
     * @param fromInclusive {@code true} if the lower endpoint
     *        should be included in the returned view
     * @param toElement the exclusive upper endpoint of the desired subset
     * @param toInclusive {@code true} if the upper endpoint
     *        should be included in the returned view
     * @return a view of the portion of this Container containing elements within
     *         the range from {@code fromElement} (inclusive) to {@code toElement} (exclusive)
     * @throws ClassCastException if {@code fromElement} and
     *         {@code toElement} cannot be compared using this
     *         Container's comparator (or, if the Container has no comparator, using
     *         natural ordering). Implementations may, but are not required
     *         to, throw this exception if {@code fromElement} or
     *         {@code toElement} cannot be compared to elements currently in
     *         the Container
     * @throws NullPointerException if {@code fromElement} or
     *         {@code toElement} is {@code null} and this Container does
     *         not permit {@code null} elements
     * @throws IllegalArgumentException if {@code fromElement} is
     *         greater than {@code toElement}; or if this Container itself
     *         has a restricted range, and {@code fromElement} or
     *         {@code toElement} lies outside the bounds of the range
     */
    NavigableContainer<E> sub(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive);

    /**
     * Retrieve a view of the portion of this Container containing elements that are
     * less than or equal to {@code toElement}.
     *
     * @param toElement the upper endpoint of the desired subset
     * @param inclusive {@code true} if the upper endpoint
     *        should be included in the returned view
     * @return a view of the portion of this Container containing elements that are
     *         less than or equal to {@code toElement}
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
    NavigableContainer<E> head(E toElement, boolean inclusive);

    /**
     * Retrieve a view of the portion of this Container containing elements that are
     * greater than or equal to {@code fromElement}.
     *
     * @param fromElement the lower endpoint of the desired subset
     * @param inclusive {@code true} if the lower endpoint
     *        should be included in the returned view
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
    NavigableContainer<E> tail(E fromElement, boolean inclusive);
}
