package org.moodminds.elemental;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A {@link Ended double-ended} {@link Queue}, which also extends the {@link java.util.Deque} interface.
 *
 * @param <V> the type of elements
 */
public interface Deque<V> extends Queue<V>, Ended<V>, java.util.Deque<V> {

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default V poll() {
        return Queue.super.poll();
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default V element() {
        return Queue.super.element();
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default V peek() {
        return Queue.super.peek();
    }

    /**
     * {@inheritDoc}
     *
     * @param v {@inheritDoc}
     * @throws IllegalStateException {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    default void push(V v) {
        addFirst(v);
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @throws NoSuchElementException {@inheritDoc}
     */
    @Override
    default V pop() {
        return removeFirst();
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default V pollFirst() {
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
    default V getFirst() {
        return Ended.super.getFirst();
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default V peekFirst() {
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
    default V getLast() {
        return Ended.super.getLast();
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default V peekLast() {
        Iterator<V> it = descendingIterator(); return it.hasNext() ? it.next() : null;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default V pollLast() {
        Iterator<V> it = descendingIterator();
        if (it.hasNext()) {
            V value = it.next(); it.remove(); return value;
        } return null;
    }

    /**
     * {@inheritDoc}
     *
     * @param v {@inheritDoc}
     * @throws IllegalStateException {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    default void addLast(V v) {
        add(v);
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
    default boolean addAll(java.util.Collection<? extends V> c) {
        return Queue.super.addAll(c);
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @throws NoSuchElementException {@inheritDoc}
     */
    @Override
    default V remove() {
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
    default V removeFirst() {
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
    default V removeLast() {
        Iterator<V> it = descendingIterator(); V value = it.next(); it.remove(); return value;
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
        Iterator<V> it = getAllDescending(o);
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
