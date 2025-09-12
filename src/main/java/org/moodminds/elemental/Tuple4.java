package org.moodminds.elemental;

/**
 * Represents a 4-values width {@link Tuple}.
 *
 * @param <V1> the type of value 1
 * @param <V2> the type of value 2
 * @param <V3> the type of value 3
 * @param <V4> the type of value 4
 */
public interface Tuple4<V1, V2, V3, V4> extends Tuple {

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
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default int width() {
        return 4;
    }
}
