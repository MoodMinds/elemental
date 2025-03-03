package org.moodminds.elemental;

/**
 * Ordered serves as the foundational interface for retrieving
 * logically grouped values based on their positional indices.
 *
 * @param <V> the type of values
 */
@FunctionalInterface
public interface Ordered<V> {

    /**
     * Retrieve a value by the specified index position.
     *
     * @param index the index position of the value
     * @return the value at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     * @throws RuntimeException in case of any error while accessing the value
     * @param <R> the type of return value
     */
    <R extends V> R get(int index);
}
