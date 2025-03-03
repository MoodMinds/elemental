package org.moodminds.elemental;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A queue extension of the {@link Collection} interface, which also
 * extends the {@link java.util.Queue} interface.
 *
 * @param <E> the type of elements
 */
public interface Queue<E> extends Collection<E>, java.util.Queue<E> {

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @throws NoSuchElementException {@inheritDoc}
     */
    @Override
    default E remove() {
        Iterator<E> it = iterator(); E value = it.next(); it.remove(); return value;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default E poll() {
        Iterator<E> it = iterator();
        if (it.hasNext()) {
            E value = it.next(); it.remove(); return value;
        } return null;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @throws NoSuchElementException {@inheritDoc}
     */
    @Override
    default E element() {
        return iterator().next();
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default E peek() {
        Iterator<E> it = iterator(); return it.hasNext() ? it.next() : null;
    }
}
