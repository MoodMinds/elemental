package org.moodminds.elemental;

/**
 * Represents a 1-value width {@link Tuple}.
 *
 * @param <V> the type of the value
 */
public interface Tuple1<V> extends Tuple {

    /**
     * Return the value.
     *
     * @return the value
     * @throws RuntimeException in case of any error while accessing the value
     */
    default V get1st() {
        return Ordered.get1st(this);
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default int width() {
        return 1;
    }
}
