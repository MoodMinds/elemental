package org.moodminds.elemental;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A queue extension of the {@link Collection} interface, which also
 * extends the {@link java.util.Queue} interface.
 *
 * @param <V> the type of elements
 */
public interface Queue<V> extends Collection<V>, java.util.Queue<V> {

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @throws NoSuchElementException {@inheritDoc}
     */
    @Override
    default V element() {
        return iterator().next();
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default V peek() {
        Iterator<V> it = iterator(); return it.hasNext() ? it.next() : null;
    }
}
