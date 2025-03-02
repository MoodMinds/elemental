package org.moodminds.elemental;

import java.util.Collections;
import java.util.Comparator;

/**
 * A navigable extension of the {@link SortedCollection} interface, which also extends
 * the {@link NavigableContainer} interface.
 *
 * @param <E> the type of elements
 */
public interface NavigableCollection<E> extends SortedCollection<E>, NavigableContainer<E> {

    /**
     * Retrieve and remove the first (lowest) element from this Collection.
     *
     * @return the first element, or {@code null} if this Collection is empty
     */
    E pollFirst();

    /**
     * Retrieve and remove the last (highest) element from this Collection.
     *
     * @return the last element, or {@code null} if this Collection is empty
     */
    E pollLast();

    /**
     * Return a reverse order view of the elements in this Collection.
     * The descending Collection is backed by this Collection, so changes made to the original Collection
     * will be reflected in the descending Collection, and vice versa. However, modifying either Collection
     * while iterating over it (except through the iterator's own {@code remove} operation) can lead to undefined behavior.
     *
     * <p>The ordering of the returned Collection is equivalent to
     * {@link Collections#reverseOrder(Comparator) Collections.reverseOrder}{@code (comparator())}.
     * The expression {@code c.descending().descending()} returns a view of {@code c} that is essentially equivalent to {@code c}.
     *
     * @return a reverse order view of this Collection
     */
    @Override
    NavigableCollection<E> descending();

    /**
     * Return a view of the portion of this Collection whose elements range from
     * {@code fromElement} to {@code toElement}. If {@code fromElement} and
     * {@code toElement} are equal, the returned Collection is empty unless both
     * {@code fromInclusive} and {@code toInclusive} are set to {@code true}. The returned Collection
     * is backed by this Collection, so changes in the returned Collection are reflected in
     * this Collection, and vice versa. The returned Collection supports all optional Collection
     * operations that this Collection supports.
     *
     * <p>An attempt to insert an element outside the specified range will result in an
     * {@code IllegalArgumentException} being thrown by the returned Collection.
     *
     * @param fromElement the low endpoint of the returned Collection
     * @param fromInclusive {@code true} if the low endpoint
     *        is to be included in the returned view
     * @param toElement the high endpoint of the returned Collection
     * @param toInclusive {@code true} if the high endpoint
     *        is to be included in the returned view
     * @return a view of the portion of this Collection whose elements range from
     *         {@code fromElement}, inclusive, to {@code toElement}, exclusive
     * @throws ClassCastException if {@code fromElement} and
     *         {@code toElement} cannot be compared to each other using this
     *         Collection's comparator (or, if the Collection has no comparator, using
     *         natural ordering). Implementations may, but are not required
     *         to, throw this exception if {@code fromElement} or
     *         {@code toElement} cannot be compared to elements currently in
     *         the Collection
     * @throws NullPointerException if {@code fromElement} or
     *         {@code toElement} is {@code null} and this Collection does
     *         not permit {@code null} elements
     * @throws IllegalArgumentException if {@code fromElement} is
     *         greater than {@code toElement}; or if this Collection itself
     *         has a restricted range, and {@code fromElement} or
     *         {@code toElement} lies outside the bounds of the range
     */
    @Override
    NavigableCollection<E> sub(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive);

    /**
     * Return a view of the portion of this Collection whose elements are less than
     * (or equal to, if {@code inclusive} is set to {@code true}) {@code toElement}. The
     * returned Collection is backed by this Collection, so changes in the returned Collection are
     * reflected in this Collection, and vice versa. The returned Collection supports all
     * optional Collection operations that this Collection supports.
     *
     * <p>An attempt to insert an element outside the specified range will result in an
     * {@code IllegalArgumentException} being thrown by the returned Collection.
     *
     * @param toElement the high endpoint of the returned Collection
     * @param inclusive {@code true} if the high endpoint
     *        is to be included in the returned view
     * @return a view of the portion of this Collection whose elements are less than
     *         (or equal to, if {@code inclusive} is true) {@code toElement}
     * @throws ClassCastException if {@code toElement} is not compatible
     *         with this Collection's comparator (or, if the Collection has no comparator,
     *         if {@code toElement} does not implement {@link Comparable}).
     *         Implementations may, but are not required to, throw this
     *         exception if {@code toElement} cannot be compared to elements
     *         currently in the Collection
     * @throws NullPointerException if {@code toElement} is {@code null} and
     *         this Collection does not permit {@code null} elements
     * @throws IllegalArgumentException if this Collection itself has a
     *         restricted range, and {@code toElement} lies outside the
     *         bounds of the range
     */
    @Override
    NavigableCollection<E> head(E toElement, boolean inclusive);

    /**
     * Return a view of the portion of this Collection whose elements are greater
     * than (or equal to, if {@code inclusive} is set to {@code true}) {@code fromElement}.
     * The returned Collection is backed by this Collection, so changes in the returned Collection
     * are reflected in this Collection, and vice versa. The returned Collection supports
     * all optional Collection operations that this Collection supports.
     *
     * <p>An attempt to insert an element outside the specified range will result in an
     * {@code IllegalArgumentException} being thrown by the returned Collection.
     *
     * @param fromElement the low endpoint of the returned Collection
     * @param inclusive {@code true} if the low endpoint
     *        is to be included in the returned view
     * @return a view of the portion of this Collection whose elements are greater
     *         than or equal to {@code fromElement}
     * @throws ClassCastException if {@code fromElement} is not compatible
     *         with this Collection's comparator (or, if the Collection has no comparator,
     *         if {@code fromElement} does not implement {@link Comparable}).
     *         Implementations may, but are not required to, throw this
     *         exception if {@code fromElement} cannot be compared to elements
     *         currently in the Collection
     * @throws NullPointerException if {@code fromElement} is {@code null}
     *         and this Collection does not permit {@code null} elements
     * @throws IllegalArgumentException if this Collection itself has a
     *         restricted range, and {@code fromElement} lies outside the
     *         bounds of the range
     */
    @Override
    NavigableCollection<E> tail(E fromElement, boolean inclusive);
}
