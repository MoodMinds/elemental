package org.moodminds.elemental;

/**
 * Represents an 8-values width {@link Tuple}.
 *
 * @param <V1> the type of value 1
 * @param <V2> the type of value 2
 * @param <V3> the type of value 3
 * @param <V4> the type of value 4
 * @param <V5> the type of value 5
 * @param <V6> the type of value 6
 * @param <V7> the type of value 7
 * @param <V8> the type of value 8
 */
public interface Tuple8<V1, V2, V3, V4, V5, V6, V7, V8> extends Tuple {

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
     * Return the value 6.
     *
     * @return value 6
     * @throws RuntimeException in case of any error while accessing the value
     */
    default V6 get6th() {
        return get(5);
    }

    /**
     * Return the value 7.
     *
     * @return value 7
     * @throws RuntimeException in case of any error while accessing the value
     */
    default V7 get7th() {
        return get(6);
    }

    /**
     * Return the value 8.
     *
     * @return value 8
     * @throws RuntimeException in case of any error while accessing the value
     */
    default V8 get8th() {
        return get(7);
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default int width() {
        return 8;
    }
}
