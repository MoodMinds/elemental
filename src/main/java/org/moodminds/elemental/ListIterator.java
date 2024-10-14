package org.moodminds.elemental;

/**
 * A mutative extension of the {@link SequenceIterator} interface, which also extends
 * the {@link java.util.ListIterator} interface.
 *
 * @param <E> the type of elements
 */
public interface ListIterator<E> extends SequenceIterator<E>, java.util.ListIterator<E> {}
