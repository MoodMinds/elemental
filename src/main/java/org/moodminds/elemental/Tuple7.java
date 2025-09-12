package org.moodminds.elemental;

/**
 * Represents a 7-values width {@link Tuple}.
 *
 * @param <V1> the type of value 1
 * @param <V2> the type of value 2
 * @param <V3> the type of value 3
 * @param <V4> the type of value 4
 * @param <V5> the type of value 5
 * @param <V6> the type of value 6
 * @param <V7> the type of value 7
 */
public interface Tuple7<V1, V2, V3, V4, V5, V6, V7> extends Tuple {

    /**
     * Return the value 1.
     *
     * @return value 1
     * @throws RuntimeException in case of any error while accessing the value
     */
    default V1 get1st() {
        return Ordered.get1st(this);
    }

    /**
     * Return the value 2.
     *
     * @return value 2
     * @throws RuntimeException in case of any error while accessing the value
     */
    default V2 get2nd() {
        return Ordered.get2nd(this);
    }

    /**
     * Return the value 3.
     *
     * @return value 3
     * @throws RuntimeException in case of any error while accessing the value
     */
    default V3 get3rd() {
        return Ordered.get3rd(this);
    }

    /**
     * Return the value 4.
     *
     * @return value 4
     * @throws RuntimeException in case of any error while accessing the value
     */
    default V4 get4th() {
        return Ordered.get4th(this);
    }

    /**
     * Return the value 5.
     *
     * @return value 5
     * @throws RuntimeException in case of any error while accessing the value
     */
    default V5 get5th() {
        return Ordered.get5th(this);
    }

    /**
     * Return the value 6.
     *
     * @return value 6
     * @throws RuntimeException in case of any error while accessing the value
     */
    default V6 get6th() {
        return Ordered.get6th(this);
    }

    /**
     * Return the value 7.
     *
     * @return value 7
     * @throws RuntimeException in case of any error while accessing the value
     */
    default V7 get7th() {
        return Ordered.get7th(this);
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default int width() {
        return 7;
    }
}
