package org.moodminds.elemental;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.Spliterator.IMMUTABLE;

/**
 * A Container represents a holder of objects referred to as its values.
 * <p>
 * A Container serves as a holder for zero, one, or more value. Whether it is
 * modifiable or not depends on the specific implementation. This interface does not
 * impose any constraints on the order or appearance of elements within the Container.
 * <p>
 * Provides elements read methods {@link #getAll(Object)} and {@link #getCount(Object)}
 * matching the specified example object.
 *
 * @param <V> the type of elements
 *
 * @see RandomMatch
 */
public interface Container<V> extends Iterable<V> {

    /**
     * Retrieve objects' count that match the provided example.
     *
     * @param o the reference object for comparison
     * @return objects' count that match the provided example
     * @throws ClassCastException if the type of the example is not compatible
     *         with this Container (optional)
     * @throws NullPointerException if the example is {@code null} or contains internal {@code null} values,
     *         and this Container does not allow that (optional)
     *
     * @see RandomMatch
     */
    int getCount(Object o);

    /**
     * Retrieve objects that match the provided example.
     *
     * @param o the reference object for comparison
     * @return an {@link Iterator} of objects that match the provided example
     * @throws ClassCastException if the type of the example is not compatible
     *         with this Container (optional)
     * @throws NullPointerException if the example is {@code null} or contains internal {@code null} values,
     *         and this Container does not allow that (optional)
     */
    Iterator<V> getAll(Object o);

    /**
     * Return the number of elements in this Container. If this Container contains
     * more than {@link Integer#MAX_VALUE} elements, return {@link Integer#MAX_VALUE}.
     *
     * @return the number of elements in this Container
     */
    int size();

    /**
     * Return a hash code value for this Container. While this interface does not impose any specific
     * {@code Object.hashCode} contract for Container objects, implementations may choose to implement
     * "value hash" - basing on the elements within the Container, ensuring that containers with the same
     * elements and with the same number of duplicated elements produce the same hash code. The calculation
     * may or may not consider the order of elements.
     *
     * @return the hash code value for this Container
     */
    @Override
    int hashCode();

    /**
     * Compare this container with the specified object for equality. While this interface does not
     * impose any specific equality contract for Container objects, implementations may choose to implement
     * a "value comparison" - returning {@code true} if and only if this Container is considered equivalent
     * to another in terms of symmetry, both containers have the same size and elements. The comparison may
     * or may not take element order into account and may consider duplicates.
     *
     * @param obj the object to be compared for equality
     * @return {@code true} if the given object is this Container or (optionally) if both objects contain the same
     * elements, with or without considering order, and possibly allowing duplicates; otherwise, {@code false}
     */
    @Override
    boolean equals(Object obj);

    /**
     * Return an independent array containing all the elements in this Container.
     * If this Container preserves elements' order, this method must return the array in
     * the same order.
     *
     * @return an independent array containing all the elements in this Container
     */
    default Object[] toArray() {
        return stream().toArray();
    }

    /**
     * Return an independent array containing all the elements in this Container. The runtime
     * type of the returned array is that of the specified array. If this Container preserves
     * elements' order, this method must return the array in the same order.
     * <p>
     * If the Container can be accommodated within the provided array, it will be placed there.
     * If not, a new array will be created with the same runtime type as the specified array,
     * and it will have a size equal to that of this Container.
     *
     * @param a   the given array
     * @param <T> the given array component type
     * @return an array containing all the elements in this Container
     * @throws ArrayStoreException  if any element's runtime type within this Container cannot be assigned
     *                              to the {@linkplain Class#getComponentType runtime component type} of the specified array.
     * @throws NullPointerException if the specified array is {@code null}
     */
    @SuppressWarnings("unchecked")
    default <T> T[] toArray(T[] a) {
        return stream().toArray(size -> a.length >= size ? a
                : (T[]) Array.newInstance(a.getClass().getComponentType(), size));
    }

    /**
     * Check if this Container contains elements. The default implementation
     * uses the {@link #size()} method to check if the size greater than 0.
     *
     * @return {@code true} if this Container contains elements
     */
    default boolean contains() {
        return size() > 0;
    }

    /**
     * Determine whether this Container includes an element that matches the provided example.
     *
     * @param o the object to be examined
     * @return {@code true} if this Container contains the examined element
     * @throws ClassCastException if the type of the given element
     *         is not compatible with this Container
     * @throws NullPointerException if the given element is {@code null} or
     *         if it contains {@code null} values internally, and this Container does not allow it (optionally)
     */
    default boolean contains(Object o) {
        return getAll(o).hasNext();
    }

    /**
     * Determine whether this Container includes all the specified elements.
     *
     * @param elements the elements to be checked
     * @return {@code true} if this Container contains all the specified elements
     * @throws ClassCastException if one or more elements in the specified {@link Iterable}
     *         are of types incompatible with this Container
     * @throws NullPointerException if one or more of the specified elements are null
     *         or if their internals contain {@code null} values, and this Container does not
     *         allow this (optionally)
     */
    default boolean containsAll(java.lang.Iterable<?> elements) {
        for (Object e : elements)
            if (!contains(e))
                return false;
        return true;
    }

    /**
     * Determine whether this Container includes all the specified elements.
     *
     * @param c the elements to be checked
     * @return {@code true} if this Container contains all the specified elements
     * @throws ClassCastException if one or more elements in the specified Container
     *         are of types incompatible with this Container
     * @throws NullPointerException if one or more of the specified elements are null
     *         or if their internals contain {@code null} values, and this Container does not
     *         allow this (optionally)
     */
    default boolean containsAll(Container<?> c) {
        return containsAll((Iterable<?>) c);
    }

    /**
     * Determine whether this Container includes all the specified elements.
     *
     * @param c the elements to be checked
     * @return {@code true} if this Container contains all the specified elements
     * @throws ClassCastException if one or more elements in the specified collection
     *         are of types incompatible with this Container
     * @throws NullPointerException if one or more of the specified elements are null
     *         or if their internals contain {@code null} values, and this Container does not
     *         allow this (optionally)
     */
    default boolean containsAll(java.util.Collection<?> c) {
        return containsAll((java.lang.Iterable<?>) c);
    }

    /**
     * Determine whether this Container includes all the specified elements.
     *
     * @param c the elements to be checked
     * @return {@code true} if this Container contains all the specified elements
     * @throws ClassCastException if one or more elements in the specified collection
     *         are of types incompatible with this Container
     * @throws NullPointerException if one or more of the specified elements are null
     *         or if their internals contain {@code null} values, and this Container does not
     *         allow this (optionally)
     */
    default boolean containsAll(Collection<?> c) {
        return containsAll((java.util.Collection<?>) c);
    }

    /**
     * Return an {@link Iterator} over the elements in this Container. There are no
     * guarantees concerning the order in which the elements are returned.
     *
     * @return an {@link Iterator} over the elements in this Container
     */
    @Override
    Iterator<V> iterator();

    /**
     * Return a {@link Spliterator} over the elements described by this Container.
     *
     * @implSpec
     * The default implementation creates an
     * <em><a href="../util/Spliterator.html#binding">early-binding</a></em>
     * spliterator from the iterable's {@code Iterator}. The spliterator
     * inherits the <em>fail-fast</em> properties of the Container's iterator.
     *
     * @return a {@code Spliterator} over the elements described by this Container
     */
    @Override
    default Spliterator<V> spliterator() {
        return java.util.Spliterators.spliterator(iterator(), size(), IMMUTABLE);
    }

    /**
     * Return a sequential {@link Stream} with this Container as its source.
     *
     * @return a sequential {@link Stream} with this Container as its source
     */
    default Stream<V> stream() {
        return StreamSupport.stream(spliterator(), false);
    }

    /**
     * Return a possible parallel {@link Stream} with this Container as its source.
     *
     * @return a possible parallel {@link Stream} with this Container as its source
     */
    default Stream<V> parallelStream() {
        return StreamSupport.stream(spliterator(), true);
    }
}
