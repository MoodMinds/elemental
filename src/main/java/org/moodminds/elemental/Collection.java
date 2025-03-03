package org.moodminds.elemental;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;

/**
 * A mutative extension of the {@link Container} interface,
 * which also extends the {@link java.util.Collection} interface.
 *
 * @param <E> the type of elements
 */
public interface Collection<E> extends Container<E>, java.util.Collection<E> {

    /**
     * Incorporate all elements from the specified {@link Iterable} into this collection
     * (optional operation). The behavior of this operation is undefined if
     * the specified {@link Iterable} is modified while the operation is in progress.
     * (This implies that the behavior of this call is undefined if the
     * specified {@link Iterable} is the same as this collection, and this collection is
     * not empty.)
     *
     * @param elements the specified {@link Iterable} containing elements to be included in this collection
     * @return {@code true} if this collection underwent changes due to the operation
     * @throws UnsupportedOperationException if the {@code addAll} operation
     *         is not supported by this collection
     * @throws ClassCastException if an element within the specified {@link Iterable}
     *         cannot be added to this collection due to its class
     * @throws NullPointerException if the specified {@link Iterable} contains a
     *         {@code null} element, and this collection disallows {@code null} elements,
     *         or if the specified {@link Iterable} is {@code null}
     * @throws IllegalArgumentException if an element within the specified {@link Iterable}
     *         cannot be added to this collection due to some property
     * @throws IllegalStateException if not all elements can be added at
     *         the present moment due to insertion constraints
     * @see #add(Object)
     */
    default boolean addAll(Iterable<? extends E> elements) {
        boolean modified = false;
        for (E o : elements)
            if (add(o)) modified = true;
        return modified;
    }

    /**
     * Incorporate all elements from the specified {@link Container} into this collection
     * (optional operation). The behavior of this operation is undefined if
     * the specified {@link Container} is modified while the operation is in progress.
     * (This implies that the behavior of this call is undefined if the
     * specified {@link Container} is the same as this collection, and this collection is
     * not empty.)
     *
     * @param c the specified {@link Container} containing elements to be included in this collection
     * @return {@code true} if this collection underwent changes due to the operation
     * @throws UnsupportedOperationException if the {@code addAll} operation
     *         is not supported by this collection
     * @throws ClassCastException if an element within the specified {@link Container}
     *         cannot be added to this collection due to its class
     * @throws NullPointerException if the specified {@link Container} contains a
     *         {@code null} element, and this collection disallows {@code null} elements,
     *         or if the specified {@link Container} is {@code null}
     * @throws IllegalArgumentException if an element within the specified {@link Container}
     *         cannot be added to this collection due to some property
     * @throws IllegalStateException if not all elements can be added at
     *         the present moment due to insertion constraints
     * @see #add(Object)
     */
    default boolean addAll(Container<? extends E> c) {
        return addAll((Iterable<? extends E>) c);
    }

    /**
     * Incorporate all elements from the specified {@link java.util.Collection} into this collection
     * (optional operation). The behavior of this operation is undefined if
     * the specified {@link java.util.Collection} is modified while the operation is in progress.
     * (This implies that the behavior of this call is undefined if the specified {@link java.util.Collection}
     * is the same as this collection, and this collection is not empty.)
     *
     * @param c the specified {@link java.util.Collection} containing elements to be included in this collection
     * @return {@code true} if this collection underwent changes due to the operation
     * @throws UnsupportedOperationException if the {@code addAll} operation
     *         is not supported by this collection
     * @throws ClassCastException if an element within the specified {@link java.util.Collection}
     *         cannot be added to this collection due to its class
     * @throws NullPointerException if the specified {@link java.util.Collection} contains a
     *         {@code null} element, and this collection disallows {@code null} elements,
     *         or if the specified {@link java.util.Collection} is {@code null}
     * @throws IllegalArgumentException if an element within the specified {@link java.util.Collection}
     *         cannot be added to this collection due to some property
     * @throws IllegalStateException if not all elements can be added at
     *         the present moment due to insertion constraints
     * @see #add(Object)
     */
    @Override
    default boolean addAll(java.util.Collection<? extends E> c) {
        return addAll((Iterable<? extends E>) c);
    }

    /**
     * Incorporate all elements from the specified {@link Collection} into this collection
     * (optional operation). The behavior of this operation is undefined if
     * the specified {@link Collection} is modified while the operation is in progress.
     * (This implies that the behavior of this call is undefined if the
     * specified {@link Collection} is the same as this collection, and this collection is
     * not empty.)
     *
     * @param c the specified {@link Collection} containing elements to be included in this collection
     * @return {@code true} if this collection underwent changes due to the operation
     * @throws UnsupportedOperationException if the {@code addAll} operation
     *         is not supported by this collection
     * @throws ClassCastException if an element within the specified {@link Collection}
     *         cannot be added to this collection due to its class
     * @throws NullPointerException if the specified {@link Collection} contains a
     *         {@code null} element, and this collection disallows {@code null} elements,
     *         or if the specified {@link Collection} is {@code null}
     * @throws IllegalArgumentException if an element within the specified {@link Collection}
     *         cannot be added to this collection due to some property
     * @throws IllegalStateException if not all elements can be added at
     *         the present moment due to insertion constraints
     * @see #add(Object)
     */
    default boolean addAll(Collection<? extends E> c) {
        return addAll((java.util.Collection<? extends E>) c);
    }

    /**
     * {@inheritDoc}
     *
     * @param o {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws UnsupportedOperationException {@inheritDoc}
     */
    @Override
    default boolean remove(Object o) {
        Iterator<E> it = getAll(o);
        if (!it.hasNext())
            return false;
        it.next(); it.remove(); return true;
    }

    /**
     * Eliminates all elements from this collection that are also present in the
     * provided {@link Iterable} (optional operation). Following this operation,
     * this collection will have no elements in common with the specified elements.
     *
     * @param elements the {@link Iterable} of elements to be deleted from this collection
     * @return {@code true} if this collection had changes as a result of the call
     * @throws UnsupportedOperationException if this collection does not support
     *         the {@code removeAll} operation
     * @throws ClassCastException if the types of one or more elements
     *         within this collection are incompatible with the specified
     *         {@link Iterable}
     * @throws NullPointerException if this collection contains one or more
     *         {@code null} elements and the specified {@link Iterable} does not permit
     *         {@code null} elements, or if the specified elements {@link Iterable} is {@code null}
     */
    default boolean removeAll(Iterable<?> elements) {
        boolean modified = false;
        for (Object element : elements)
            for (Iterator<E> it = getAll(element); it.hasNext(); ) {
                it.next(); it.remove(); modified = true;
            }
        return modified;
    }

    /**
     * Eliminate all elements from this collection that are also present in the
     * provided {@link Container} (optional operation). Following this operation,
     * this collection will have no elements in common with the specified elements.
     *
     * @param c the {@link Container} containing elements to be deleted from this collection
     * @return {@code true} if this collection had changes as a result of the call
     * @throws UnsupportedOperationException if this collection does not support
     *         the {@code removeAll} operation
     * @throws ClassCastException if the types of one or more elements
     *         within this collection are incompatible with the specified
     *         {@link Container}
     * @throws NullPointerException if this collection contains one or more
     *         {@code null} elements and the specified {@link Container} does not permit
     *         {@code null} elements, or if the specified container is {@code null}
     */
    default boolean removeAll(Container<?> c) {
        return size() > c.size() ? removeAll((Iterable<?>) c) : removeIf(c::contains);
    }

    /**
     * Eliminate all elements from this collection that are also present in the
     * provided {@link java.util.Collection} (optional operation). Following this operation,
     * this collection will have no elements in common with the specified collection.
     *
     * @param c the {@link java.util.Collection} containing elements to be deleted from this collection
     * @return {@code true} if this collection had changes as a result of the call
     * @throws UnsupportedOperationException if this collection does not support
     *         the {@code removeAll} operation
     * @throws ClassCastException if the types of one or more elements
     *         within this collection are incompatible with the specified
     *         {@link java.util.Collection}
     * @throws NullPointerException if this collection contains one or more
     *         {@code null} elements and the specified {@link java.util.Collection} does not permit
     *         {@code null} elements, or if the specified collection is {@code null}
     */
    @Override
    default boolean removeAll(java.util.Collection<?> c) {
        return size() > c.size() ? removeAll((Iterable<?>) c) : removeIf(c::contains);
    }

    /**
     * Eliminate all elements from this collection that are also present in the
     * provided {@link Collection} (optional operation). Following this operation,
     * this collection will have no elements in common with the specified collection.
     *
     * @param c the {@link Collection} containing elements to be deleted from this collection
     * @return {@code true} if this collection had changes as a result of the call
     * @throws UnsupportedOperationException if this collection does not support
     *         the {@code removeAll} operation
     * @throws ClassCastException if the types of one or more elements
     *         within this collection are incompatible with the specified
     *         {@link Collection}
     * @throws NullPointerException if this collection contains one or more
     *         {@code null} elements and the specified {@link Collection} does not permit
     *         {@code null} elements, or if the specified collection is {@code null}
     */
    default boolean removeAll(Collection<?> c) {
        return removeAll((java.util.Collection<?>) c);
    }

    /**
     * Preserve only the elements in this collection that are found in the
     * provided {@link Container} (optional operation). In essence, it removes from
     * this collection all elements that are not present in the specified {@link Container}.
     *
     * @param c the {@link Container} containing elements to be kept in this collection
     * @return {@code true} if this collection had changes as a result of the call
     * @throws UnsupportedOperationException if this collection does not support
     *         the {@code retainAll} operation
     * @throws ClassCastException if the types of one or more elements
     *         within this collection are incompatible with the specified
     *         {@link Container}
     * @throws NullPointerException if this collection contains one or more
     *         {@code null} elements and the specified {@link Container} does not allow null
     *         elements, or if the specified container is {@code null}
     */
    default boolean retainAll(Container<?> c) {
        requireNonNull(c); return removeIf(e -> !c.contains(e));
    }

    /**
     * Preserve only the elements in this collection that are found in the
     * provided {@link java.util.Collection} (optional operation). In essence, it removes from
     * this collection all elements that are not present in the specified {@link java.util.Collection}.
     *
     * @param c the {@link java.util.Collection} containing elements to be kept in this collection
     * @return {@code true} if this collection had changes as a result of the call
     * @throws UnsupportedOperationException if this collection does not support
     *         the {@code retainAll} operation
     * @throws ClassCastException if the types of one or more elements
     *         within this collection are incompatible with the specified
     *         {@link java.util.Collection}
     * @throws NullPointerException if this collection contains one or more
     *         {@code null} elements and the specified {@link java.util.Collection} does not allow null
     *         elements, or if the specified collection is {@code null}
     */
    @Override
    default boolean retainAll(java.util.Collection<?> c) {
        requireNonNull(c); return removeIf(e -> !c.contains(e));
    }

    /**
     * Preserve only the elements in this collection that are found in the
     * provided {@link Collection} (optional operation). In essence, it removes from
     * this collection all elements that are not present in the specified {@link Collection}.
     *
     * @param c the {@link Collection} containing elements to be kept in this collection
     * @return {@code true} if this collection had changes as a result of the call
     * @throws UnsupportedOperationException if this collection does not support
     *         the {@code retainAll} operation
     * @throws ClassCastException if the types of one or more elements
     *         within this collection are incompatible with the specified
     *         {@link Collection}
     * @throws NullPointerException if this collection contains one or more
     *         {@code null} elements and the specified {@link Collection} does not allow null
     *         elements, or if the specified collection is {@code null}
     */
    default boolean retainAll(Collection<?> c) {
        return retainAll((java.util.Collection<?>) c);
    }

    /**
     * {@inheritDoc}
     *
     * @param o {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    default boolean contains(Object o) {
        return Container.super.contains(o);
    }

    /**
     * {@inheritDoc}
     *
     * @param c {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    default boolean containsAll(java.util.Collection<?> c) {
        return Container.super.containsAll(c);
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default boolean isEmpty() {
        return !contains();
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default Object[] toArray() {
        return Container.super.toArray();
    }

    /**
     * {@inheritDoc}
     *
     * @param a {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ArrayStoreException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    default <T> T[] toArray(T[] a) {
        return Container.super.toArray(a);
    }

    /**
     * {@inheritDoc}
     *
     * @return a {@inheritDoc}
     */
    @Override
    default Spliterator<E> spliterator() {
        return java.util.Collection.super.spliterator();
    }

    /**
     * {@inheritDoc}
     *
     * @return a {@inheritDoc}
     */
    @Override
    default Stream<E> stream() {
        return java.util.Collection.super.stream();
    }

    /**
     * {@inheritDoc}
     *
     * @return a {@inheritDoc}
     */
    @Override
    default Stream<E> parallelStream() {
        return java.util.Collection.super.parallelStream();
    }
}
