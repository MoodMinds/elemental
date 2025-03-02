package org.moodminds.elemental;

/**
 * Represents a 3-values width {@link Tuple}.
 *
 * @param <V1> the type of value 1
 * @param <V2> the type of value 2
 * @param <V3> the type of value 3
 */
public interface Tuple3<V1, V2, V3> extends Tuple {

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
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default int width() {
        return 3;
    }
}
