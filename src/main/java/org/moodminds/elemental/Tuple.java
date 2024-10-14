package org.moodminds.elemental;

/**
 * Represents a tuple in the most generic sense - an {@link Ordered} with width (length).
 * This interface solely focuses on the aspect of accessing elements and does not dictate
 * a specific structural form. Implementations may not only represent distinct structures
 * but also serve as retrieval objects.
 */
public interface Tuple extends Ordered<Object> {

    /**
     * Calculate and return the hash code value for this Tuple. While the {@code Tuple}
     * interface serves at least as an accessor to values and does not impose additional
     * requirements on the general contract of the {@code Object.hashCode} method, specific
     * implementations may introduce additional considerations.
     *
     * @return the computed hash code value for this Tuple
     */
    int hashCode();

    /**
     * Compare this Tuple with the provided object for equality. While the {@code Tuple}
     * interface serves at least as an accessor to values and does not impose additional
     * requirements on the general contract of the {@code Object.equals} method, specific
     * implementations may introduce additional considerations.
     *
     * @param o the object to be compared with this Tuple for equality
     * @return {@code true} if the provided object is equal to this Tuple
     */
    boolean equals(Object o);

    /**
     * Return the width of this Tuple.
     *
     * @return the width of this Tuple
     */
    int width();
}
