package org.moodminds.elemental;

/**
 * Represents a 5-values width {@link Tuple}.
 *
 * @param <V1> the type of value 1
 * @param <V2> the type of value 2
 * @param <V3> the type of value 3
 * @param <V4> the type of value 4
 * @param <V5> the type of value 5
 */
public interface Tuple5<V1, V2, V3, V4, V5> extends Tuple {

    /**
     * Return the value 1.
     *
     * @return value 1
     * @throws RuntimeException in case of any error while accessing the value
     */
    default V1 get1st() {
        return get(0);
    }

    /**
     * Return the value 2.
     *
     * @return value 2
     * @throws RuntimeException in case of any error while accessing the value
     */
    default V2 get2nd() {
        return get(1);
    }

    /**
     * Return the value 3.
     *
     * @return value 3
     * @throws RuntimeException in case of any error while accessing the value
     */
    default V3 get3rd() {
        return get(2);
    }

    /**
     * Return the value 4.
     *
     * @return value 4
     * @throws RuntimeException in case of any error while accessing the value
     */
    default V4 get4th() {
        return get(3);
    }

    /**
     * Return the value 5.
     *
     * @return value 5
     * @throws RuntimeException in case of any error while accessing the value
     */
    default V5 get5th() {
        return get(4);
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default int width() {
        return 5;
    }
}
