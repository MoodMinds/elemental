package org.moodminds.elemental;

import java.util.Spliterator;
import java.util.function.Consumer;

import static java.lang.String.format;

/**
 * A mutative extension of the {@link Sequence} interface, which also extends
 * the {@link Collection} and {@link java.util.List} interfaces.
 *
 * @param <V> the type of elements
 */
public interface List<V> extends Collection<V>, Sequence<V>, java.util.List<V> {

    /**
     * {@inheritDoc}
     *
     * @param index {@inheritDoc}
     * @return {@inheritDoc}
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    V get(int index);

    /**
     * Extend this list by appending all elements from the provided {@link Iterable}
     * to its end, following the order presented by the iterator of the specified
     * {@link Iterable} (optional operation). The behavior of this operation is
     * undefined if the specified {@link Iterable} is altered while the operation
     * is ongoing. (Note that this will happen if the specified {@link Iterable}
     * is the same as this list, and it's not empty.)
     *
     * @param elements the {@link Iterable} containing elements to be added to this list
     * @return {@code true} if this list was modified due to the call
     * @throws UnsupportedOperationException if the {@code addAll} operation
     *         is not supported by this list
     * @throws ClassCastException if the class of an element within the specified
     *         {@link Iterable} prevents it from being added to this list
     * @throws NullPointerException if the specified {@link Iterable} contains one
     *         or more {@code null} elements, and this list does not allow null
     *         elements, or if the specified {@link Iterable} is {@code null}
     * @throws IllegalArgumentException if some characteristic of an element within
     *         the specified {@link Iterable} prevents it from being added to this list
     * @see #add(Object)
     */
    default boolean addAll(Iterable<? extends V> elements) {
        return Collection.super.addAll(elements);
    }

    /**
     * Extend this list by appending all elements from the provided {@link Container}
     * to its end, following the order presented by the iterator of the specified
     * {@link Container} (optional operation). The behavior of this operation is
     * undefined if the specified {@link Container} is altered while the operation
     * is ongoing. (Note that this will happen if the specified {@link Container}
     * is the same as this list, and it's not empty.)
     *
     * @param c the {@link Container} containing elements to be added to this list
     * @return {@code true} if this list was modified due to the call
     * @throws UnsupportedOperationException if the {@code addAll} operation
     *         is not supported by this list
     * @throws ClassCastException if the class of an element within the specified
     *         {@link Container} prevents it from being added to this list
     * @throws NullPointerException if the specified {@link Container} contains one
     *         or more {@code null} elements, and this list does not allow null
     *         elements, or if the specified {@link Container} is {@code null}
     * @throws IllegalArgumentException if some characteristic of an element within
     *         the specified {@link Container} prevents it from being added to this list
     * @see #add(Object)
     */
    @Override
    default boolean addAll(Container<? extends V> c) {
        return Collection.super.addAll(c);
    }

    /**
     * Extend this list by appending all elements from the provided {@link java.util.Collection}
     * to its end, following the order presented by the iterator of the specified
     * {@link java.util.Collection} (optional operation). The behavior of this operation is
     * undefined if the specified {@link java.util.Collection} is altered while the operation
     * is ongoing. (Note that this will happen if the specified {@link java.util.Collection}
     * is the same as this list, and it's not empty.)
     *
     * @param c the {@link java.util.Collection} containing elements to be added to this list
     * @return {@code true} if this list was modified due to the call
     * @throws UnsupportedOperationException if the {@code addAll} operation
     *         is not supported by this list
     * @throws ClassCastException if the class of an element within the specified
     *         {@link java.util.Collection} prevents it from being added to this list
     * @throws NullPointerException if the specified {@link java.util.Collection} contains one
     *         or more {@code null} elements, and this list does not allow null
     *         elements, or if the specified {@link java.util.Collection} is {@code null}
     * @throws IllegalArgumentException if some characteristic of an element within
     *         the specified {@link java.util.Collection} prevents it from being added to this list
     * @see #add(Object)
     */
    @Override
    boolean addAll(java.util.Collection<? extends V> c);

    /**
     * Extend this list by appending all elements from the provided {@link Collection}
     * to its end, following the order presented by the iterator of the specified
     * {@link Collection} (optional operation). The behavior of this operation is
     * undefined if the specified {@link Collection} is altered while the operation
     * is ongoing. (Note that this will happen if the specified {@link Collection}
     * is the same as this list, and it's not empty.)
     *
     * @param c the {@link Collection} containing elements to be added to this list
     * @return {@code true} if this list was modified due to the call
     * @throws UnsupportedOperationException if the {@code addAll} operation
     *         is not supported by this list
     * @throws ClassCastException if the class of an element within the specified
     *         {@link Collection} prevents it from being added to this list
     * @throws NullPointerException if the specified {@link Collection} contains one
     *         or more {@code null} elements, and this list does not allow null
     *         elements, or if the specified {@link Collection} is {@code null}
     * @throws IllegalArgumentException if some characteristic of an element within
     *         the specified {@link Collection} prevents it from being added to this list
     * @see #add(Object)
     */
    @Override
    default boolean addAll(Collection<? extends V> c) {
        return Collection.super.addAll(c);
    }

    /**
     * Insert all elements from the provided {@link Iterable} into this list
     * at the specified position (optional operation). This action shifts the
     * element currently at that position (if any) and all subsequent elements
     * to the right, increasing their indices. The newly added elements will
     * appear in this list in the order they are presented by the iterator of
     * the specified {@link Iterable}. The behavior of this operation is
     * undefined if the specified {@link Iterable} is altered while the operation
     * is in progress. (Note that this will occur if the specified {@link Iterable}
     * is the same as this list, and it's not empty.)
     *
     * @param index the index at which the first element from the
     *              specified {@link Iterable} will be inserted
     * @param elements the {@link Iterable} containing elements to be added
     *                to this list
     * @return {@code true} if this list was modified as a result of the call
     * @throws UnsupportedOperationException if the {@code addAll} operation
     *         is not supported by this list
     * @throws ClassCastException if the class of an element within the specified
     *         {@link Iterable} prevents it from being added to this list
     * @throws NullPointerException if the specified {@link Iterable} contains one
     *         or more {@code null} elements, and this list does not permit null
     *         elements, or if the specified {@link Iterable} is {@code null}
     * @throws IllegalArgumentException if some characteristic of an element within
     *         the specified {@link Iterable} prevents it from being added to this list
     * @throws IndexOutOfBoundsException if the index is not within the valid range
     *         ({@code index < 0 || index > size()})
     */
    default boolean addAll(int index, Iterable<? extends V> elements) {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException(format("Index: %d, Size: %d", index, size()));
        boolean modified = false;
        for (V o : elements) {
            add(index++, o); modified = true;
        } return modified;
    }

    /**
     * Insert all elements from the provided {@link Container} into this list
     * at the specified position (optional operation). This action shifts the
     * element currently at that position (if any) and all subsequent elements
     * to the right, increasing their indices. The newly added elements will
     * appear in this list in the order they are presented by the iterator of
     * the specified {@link Container}. The behavior of this operation is
     * undefined if the specified {@link Container} is altered while the operation
     * is in progress. (Note that this will occur if the specified {@link Container}
     * is the same as this list, and it's not empty.)
     *
     * @param index the index at which the first element from the
     *              specified {@link Container} will be inserted
     * @param c the {@link Container} containing elements to be added
     *                to this list
     * @return {@code true} if this list was modified as a result of the call
     * @throws UnsupportedOperationException if the {@code addAll} operation
     *         is not supported by this list
     * @throws ClassCastException if the class of an element within the specified
     *         {@link Container} prevents it from being added to this list
     * @throws NullPointerException if the specified {@link Container} contains one
     *         or more {@code null} elements, and this list does not permit null
     *         elements, or if the specified {@link Container} is {@code null}
     * @throws IllegalArgumentException if some characteristic of an element within
     *         the specified {@link Container} prevents it from being added to this list
     * @throws IndexOutOfBoundsException if the index is not within the valid range
     *         ({@code index < 0 || index > size()})
     */
    default boolean addAll(int index, Container<? extends V> c) {
        return addAll(index, (Iterable<? extends V>) c);
    }

    /**
     * Insert all elements from the provided {@link java.util.Collection} into this list
     * at the specified position (optional operation). This action shifts the
     * element currently at that position (if any) and all subsequent elements
     * to the right, increasing their indices. The newly added elements will
     * appear in this list in the order they are presented by the iterator of
     * the specified {@link java.util.Collection}. The behavior of this operation is
     * undefined if the specified {@link java.util.Collection} is altered while the operation
     * is in progress. (Note that this will occur if the specified {@link java.util.Collection}
     * is the same as this list, and it's not empty.)
     *
     * @param index the index at which the first element from the
     *              specified {@link java.util.Collection} will be inserted
     * @param c the {@link java.util.Collection} containing elements to be added
     *                to this list
     * @return {@code true} if this list was modified as a result of the call
     * @throws UnsupportedOperationException if the {@code addAll} operation
     *         is not supported by this list
     * @throws ClassCastException if the class of an element within the specified
     *         {@link java.util.Collection} prevents it from being added to this list
     * @throws NullPointerException if the specified {@link java.util.Collection} contains one
     *         or more {@code null} elements, and this list does not permit null
     *         elements, or if the specified {@link java.util.Collection} is {@code null}
     * @throws IllegalArgumentException if some characteristic of an element within
     *         the specified {@link java.util.Collection} prevents it from being added to this list
     * @throws IndexOutOfBoundsException if the index is not within the valid range
     *         ({@code index < 0 || index > size()})
     */
    @Override
    default boolean addAll(int index, java.util.Collection<? extends V> c) {
        return addAll(index, (Iterable<? extends V>) c);
    }

    /**
     * Insert all elements from the provided {@link Collection} into this list
     * at the specified position (optional operation). This action shifts the
     * element currently at that position (if any) and all subsequent elements
     * to the right, increasing their indices. The newly added elements will
     * appear in this list in the order they are presented by the iterator of
     * the specified {@link Collection}. The behavior of this operation is
     * undefined if the specified {@link Collection} is altered while the operation
     * is in progress. (Note that this will occur if the specified {@link Collection}
     * is the same as this list, and it's not empty.)
     *
     * @param index the index at which the first element from the
     *              specified {@link Collection} will be inserted
     * @param c the {@link Collection} containing elements to be added
     *                to this list
     * @return {@code true} if this list was modified as a result of the call
     * @throws UnsupportedOperationException if the {@code addAll} operation
     *         is not supported by this list
     * @throws ClassCastException if the class of an element within the specified
     *         {@link Collection} prevents it from being added to this list
     * @throws NullPointerException if the specified {@link Collection} contains one
     *         or more {@code null} elements, and this list does not permit null
     *         elements, or if the specified {@link Collection} is {@code null}
     * @throws IllegalArgumentException if some characteristic of an element within
     *         the specified {@link Collection} prevents it from being added to this list
     * @throws IndexOutOfBoundsException if the index is not within the valid range
     *         ({@code index < 0 || index > size()})
     */
    default boolean addAll(int index, Collection<? extends V> c) {
        return addAll(index, (java.util.Collection<? extends V>) c);
    }

    /**
     * Remove the first occurrence of the specified element from this list,
     * if it exists (optional operation). If this list does not contain
     * the element, it remains unchanged. In more precise terms, this method
     * eliminates the element with the lowest index 'i' such that
     * {@code Objects.equals(o, get(i))}
     * (if such an element is present). It returns {@code true} if this list
     * contained the specified element or, in other words, if this list
     * was altered due to the call.
     *
     * @param o the element to be removed from this list if it is present
     * @return {@code true} if this list contained the specified element
     * @throws ClassCastException if the type of the specified element
     *         is incompatible with this list
     *         (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified element is {@code null} and this
     *         list does not allow {@code null} elements
     *         (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws UnsupportedOperationException if the {@code remove} operation
     *         is not supported by this list
     */
    @Override
    default boolean remove(Object o) {
        return Collection.super.remove(o);
    }

    /**
     * {@inheritDoc}
     *
     * @param c {@inheritDoc}
     * @return {@inheritDoc}
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    boolean removeAll(java.util.Collection<?> c);

    /**
     * {@inheritDoc}
     *
     * @param c {@inheritDoc}
     * @return {@inheritDoc}
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    boolean retainAll(java.util.Collection<?> c);

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
        return Collection.super.contains(o);
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
        return Collection.super.containsAll(c);
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default Object[] toArray() {
        return Collection.super.toArray();
    }

    /**
     * {@inheritDoc}
     *
     * @param a {@inheritDoc}
     * @param <T> {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ArrayStoreException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    default <T> T[] toArray(T[] a) {
        return Collection.super.toArray(a);
    }

    /**
     * Return a {@link ListIterator} for this List, enabling traversal over the elements
     * in their proper sequence.
     *
     * @return an iterator for this List, preserving the proper sequence of elements
     */
    @Override
    default ListIterator<V> iterator() {
        return listIterator();
    }

    /**
     * Retrieves a {@link ListIterator} that iterates over the elements in this List,
     * commencing at the specified position within the List.
     * The provided index indicates the initial element to be returned by the
     * first invocation of {@link ListIterator#next next}. Subsequently,
     * calling {@link ListIterator#previous previous} would yield the element
     * preceding the specified index.
     *
     * @param index the index of the first element to be retrieved by the
     *              list iterator (via a call to {@link ListIterator#next next})
     * @return a list iterator over the elements in this List, commencing
     * from the specified position within the List
     * @throws IndexOutOfBoundsException if the index is not within the valid range
     *                                   ({@code index < 0 || index > size()})
     */
    @Override
    default ListIterator<V> iterator(int index) {
        return listIterator(index);
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default ListIterator<V> listIterator() {
        return listIterator(0);
    }

    /**
     * {@inheritDoc}
     *
     * @param index {@inheritDoc}
     * @return {@inheritDoc}
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    ListIterator<V> listIterator(int index);

    /**
     * Returns a {@link ListIterator} that provides elements in reverse order, from the last (tail).
     *
     * @return a {@link ListIterator} for the elements in reverse order (from the tail)
     */
    @Override
    default ListIterator<V> descendingIterator() {
        return new ListIterator<V>() {

            final ListIterator<V> iterator = iterator(size());

            @Override public boolean hasNext() { return iterator.hasPrevious(); }
            @Override public V next() { return iterator.previous(); }
            @Override public boolean hasPrevious() { return iterator.hasNext(); }
            @Override public V previous() { return iterator.next(); }
            @Override public int nextIndex() { return iterator.previousIndex(); }
            @Override public int previousIndex() { return iterator.nextIndex(); }
            @Override public void remove() { iterator.remove(); }
            @Override public void set(V v) { iterator.set(v); }
            @Override public void add(V v) { iterator.add(v); }

            @Override public void forEachRemaining(Consumer<? super V> action) {
                iterator.forEachPreceding(action); }
            @Override public void forEachPreceding(Consumer<? super V> action) {
                iterator.forEachRemaining(action); }
        };
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default Spliterator<V> spliterator() {
        return java.util.List.super.spliterator();
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
    default int indexOf(Object o) {
        return Sequence.super.indexOf(o);
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
    default int lastIndexOf(Object o) {
        return Sequence.super.lastIndexOf(o);
    }

    /**
     * {@inheritDoc}
     *
     * @param fromIndex {@inheritDoc}
     * @param toIndex {@inheritDoc}
     * @return {@inheritDoc}
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    default List<V> sub(int fromIndex, int toIndex) {
        return subList(fromIndex, toIndex);
    }

    /**
     * {@inheritDoc}
     *
     * @param fromIndex {@inheritDoc}
     * @param toIndex {@inheritDoc}
     * @return {@inheritDoc}
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    List<V> subList(int fromIndex, int toIndex);
}
