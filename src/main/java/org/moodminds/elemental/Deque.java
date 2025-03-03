package org.moodminds.elemental;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A {@link Tailed} {@link Queue}, which also extends the {@link java.util.Deque} interface.
 *
 * @param <E> the type of elements
 */
public interface Deque<E> extends Queue<E>, Tailed<E>, java.util.Deque<E> {

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default E poll() {
        return Queue.super.poll();
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default E element() {
        return Queue.super.element();
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default E peek() {
        return Queue.super.peek();
    }

    /**
     * {@inheritDoc}
     *
     * @param e {@inheritDoc}
     * @throws IllegalStateException {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    default void push(E e) {
        addFirst(e);
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @throws NoSuchElementException {@inheritDoc}
     */
    @Override
    default E pop() {
        return removeFirst();
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default E pollFirst() {
        return poll();
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @throws NoSuchElementException {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    default E getFirst() {
        return Tailed.super.getFirst();
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default E peekFirst() {
        return peek();
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @throws NoSuchElementException {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    default E getLast() {
        return Tailed.super.getLast();
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default E peekLast() {
        Iterator<E> it = descendingIterator(); return it.hasNext() ? it.next() : null;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default E pollLast() {
        Iterator<E> it = descendingIterator();
        if (it.hasNext()) {
            E value = it.next(); it.remove(); return value;
        } return null;
    }

    /**
     * {@inheritDoc}
     *
     * @param e {@inheritDoc}
     * @throws IllegalStateException {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    default void addLast(E e) {
        add(e);
    }

    /**
     * {@inheritDoc}
     *
     * @param c {@inheritDoc}
     * @return {@inheritDoc}
     * @throws IllegalStateException {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    default boolean addAll(java.util.Collection<? extends E> c) {
        return Queue.super.addAll(c);
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @throws NoSuchElementException {@inheritDoc}
     */
    @Override
    default E remove() {
        return Queue.super.remove();
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
    default boolean remove(Object o) {
        return Queue.super.remove(o);
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @throws NoSuchElementException {@inheritDoc}
     */
    @Override
    default E removeFirst() {
        return remove();
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
    default boolean removeFirstOccurrence(Object o) {
        return remove(o);
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @throws NoSuchElementException {@inheritDoc}
     */
    @Override
    default E removeLast() {
        Iterator<E> it = descendingIterator(); E value = it.next(); it.remove(); return value;
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
    default boolean removeLastOccurrence(Object o) {
        Iterator<E> it = getAllDescending(o);
        if (!it.hasNext())
            return false;
        it.next(); it.remove(); return true;
    }

    /**
     * {@inheritDoc}
     *
     * @param o {@inheritDoc}
     * @return {@code true} {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    default boolean contains(Object o) {
        return Queue.super.contains(o);
    }
}
