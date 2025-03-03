package org.moodminds.elemental;

/**
 * A sorted extension of the {@link Collection} interface, which also extends
 * the {@link SortedContainer} interface.
 *
 * @param <E> the type of elements
 */
public interface SortedCollection<E> extends Collection<E>, SortedContainer<E> {

    /**
     * Return a view of the portion of this Collection that includes elements
     * from {@code fromElement}, inclusive, to {@code toElement}, exclusive. If
     * {@code fromElement} and {@code toElement} are equal, the returned
     * Collection is empty. The returned Collection is backed by this Collection,
     * meaning changes in the returned Collection are reflected in this Collection,
     * and vice versa. It supports all optional Collection operations available for
     * this Collection.
     *
     * <p>The returned Collection will raise an {@code IllegalArgumentException} if
     * an attempt is made to insert an element outside its specified range.
     *
     * @param fromElement the low endpoint (inclusive) of the returned Collection
     * @param toElement the high endpoint (exclusive) of the returned Collection
     * @return a view of the portion of this Collection that includes elements from
     *         {@code fromElement}, inclusive, to {@code toElement}, exclusive
     * @throws ClassCastException if {@code fromElement} and {@code toElement} cannot
     *         be compared using this Collection's comparator (or natural ordering
     *         if no comparator is provided). Implementations may throw this exception
     *         if the elements cannot be compared to those currently in the Collection
     * @throws NullPointerException if {@code fromElement} or {@code toElement} is
     *         {@code null} and this Collection does not allow {@code null} elements
     * @throws IllegalArgumentException if {@code fromElement} is greater than
     *         {@code toElement} or if this Collection itself has a restricted range,
     *         and either {@code fromElement} or {@code toElement} falls outside
     *         of that range
     */
    @Override
    SortedCollection<E> sub(E fromElement, E toElement);

    /**
     * Return a view of the portion of this Collection containing elements that
     * are strictly less than {@code toElement}. The returned Collection is backed
     * by this Collection, so changes in the returned Collection are reflected in
     * this Collection, and vice versa. It supports all optional Collection
     * operations available for this Collection.
     *
     * <p>The returned Collection will raise an {@code IllegalArgumentException} if
     * an attempt is made to insert an element outside its specified range.
     *
     * @param toElement the high endpoint (exclusive) of the returned Collection
     * @return a view of the portion of this Collection containing elements strictly
     *         less than {@code toElement}
     * @throws ClassCastException if {@code toElement} cannot be compared with
     *         this Collection's comparator (or using natural ordering if no
     *         comparator is provided). Implementations may throw this exception if
     *         {@code toElement} cannot be compared to elements currently in the
     *         Collection
     * @throws NullPointerException if {@code toElement} is {@code null} and this Collection
     *         does not allow {@code null} elements
     * @throws IllegalArgumentException if this Collection itself has a restricted
     *         range, and {@code toElement} falls outside the bounds of that range
     */
    @Override
    SortedCollection<E> head(E toElement);

    /**
     * Return a view of the portion of this Collection containing elements that
     * are greater than or equal to {@code fromElement}. The returned Collection is
     * backed by this Collection, so changes in the returned Collection are reflected
     * in this Collection, and vice-versa. It supports all optional Collection
     * operations available for this Collection.
     *
     * <p>The returned Collection will raise an {@code IllegalArgumentException} if
     * an attempt is made to insert an element outside its specified range.
     *
     * @param fromElement the low endpoint (inclusive) of the returned Collection
     * @return a view of the portion of this Collection containing elements greater
     *         than or equal to {@code fromElement}
     * @throws ClassCastException if {@code fromElement} cannot be compared with
     *         this Collection's comparator (or using natural ordering if no
     *         comparator is provided). Implementations may throw this exception if
     *         {@code fromElement} cannot be compared to elements currently in the
     *         Collection
     * @throws NullPointerException if {@code fromElement} is {@code null} and this
     *         Collection does not allow {@code null} elements
     * @throws IllegalArgumentException if this Collection itself has a restricted
     *         range, and {@code fromElement} falls outside the bounds of that range
     */
    @Override
    SortedCollection<E> tail(E fromElement);
}
