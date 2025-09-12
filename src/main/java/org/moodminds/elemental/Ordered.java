package org.moodminds.elemental;

/**
 * Ordered serves as the foundational interface for retrieving
 * logically grouped values based on their positional indices.
 *
 * @param <V> the type of values
 */
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


    /**
     * Retrieve the first value (index {@code 0}) from the given ordered accessor.
     *
     * @param ordered the ordered accessor to query
     * @param <V> the type of values
     * @param <R> the type of return value
     * @return the first value
     * @throws IndexOutOfBoundsException if no value exists at index {@code 0}
     * @throws RuntimeException in case of any error while accessing the value
     */
    static <V, R extends V> R get1st(Ordered<V> ordered) {
        return ordered.get(0);
    }

    /**
     * Retrieve the second value (index {@code 1}) from the given ordered accessor.
     *
     * @param ordered the ordered accessor to query
     * @param <V> the type of values
     * @param <R> the type of return value
     * @return the second value
     * @throws IndexOutOfBoundsException if no value exists at index {@code 1}
     * @throws RuntimeException in case of any error while accessing the value
     */
    static <V, R extends V> R get2nd(Ordered<V> ordered) {
        return ordered.get(1);
    }

    /**
     * Retrieve the third value (index {@code 2}) from the given ordered accessor.
     *
     * @param ordered the ordered accessor to query
     * @param <V> the type of values
     * @param <R> the type of return value
     * @return the third value
     * @throws IndexOutOfBoundsException if no value exists at index {@code 2}
     * @throws RuntimeException in case of any error while accessing the value
     */
    static <V, R extends V> R get3rd(Ordered<V> ordered) {
        return ordered.get(2);
    }

    /**
     * Retrieve the fourth value (index {@code 3}) from the given ordered accessor.
     *
     * @param ordered the ordered accessor to query
     * @param <V> the type of values
     * @param <R> the type of return value
     * @return the fourth value
     * @throws IndexOutOfBoundsException if no value exists at index {@code 3}
     * @throws RuntimeException in case of any error while accessing the value
     */
    static <V, R extends V> R get4th(Ordered<V> ordered) {
        return ordered.get(3);
    }

    /**
     * Retrieve the fifth value (index {@code 4}) from the given ordered accessor.
     *
     * @param ordered the ordered accessor to query
     * @param <V> the type of values
     * @param <R> the type of return value
     * @return the fifth value
     * @throws IndexOutOfBoundsException if no value exists at index {@code 4}
     * @throws RuntimeException in case of any error while accessing the value
     */
    static <V, R extends V> R get5th(Ordered<V> ordered) {
        return ordered.get(4);
    }

    /**
     * Retrieve the sixth value (index {@code 5}) from the given ordered accessor.
     *
     * @param ordered the ordered accessor to query
     * @param <V> the type of values
     * @param <R> the type of return value
     * @return the sixth value
     * @throws IndexOutOfBoundsException if no value exists at index {@code 5}
     * @throws RuntimeException in case of any error while accessing the value
     */
    static <V, R extends V> R get6th(Ordered<V> ordered) {
        return ordered.get(5);
    }

    /**
     * Retrieve the seventh value (index {@code 6}) from the given ordered accessor.
     *
     * @param ordered the ordered accessor to query
     * @param <V> the type of values
     * @param <R> the type of return value
     * @return the seventh value
     * @throws IndexOutOfBoundsException if no value exists at index {@code 6}
     * @throws RuntimeException in case of any error while accessing the value
     */
    static <V, R extends V> R get7th(Ordered<V> ordered) {
        return ordered.get(6);
    }

    /**
     * Retrieve the eighth value (index {@code 7}) from the given ordered accessor.
     *
     * @param ordered the ordered accessor to query
     * @param <V> the type of values
     * @param <R> the type of return value
     * @return the eighth value
     * @throws IndexOutOfBoundsException if no value exists at index {@code 7}
     * @throws RuntimeException in case of any error while accessing the value
     */
    static <V, R extends V> R get8th(Ordered<V> ordered) {
        return ordered.get(7);
    }
}
