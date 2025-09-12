package org.moodminds.elemental;

/**
 * Represents a 2-values width {@link Tuple}.
 *
 * @param <V1> the type of value 1
 * @param <V2> the type of value 2
 */
public interface Tuple2<V1, V2> extends Tuple {

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
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default int width() {
        return 2;
    }
}
