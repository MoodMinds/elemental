package org.moodminds.elemental;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * An object for traversing elements of a Source.
 *
 * @param <V> the type of elements
 */
@FunctionalInterface
public interface Advancer<V> {

    /**
     * Move to the next element in the current {@link Thread} and apply
     * the specified {@link Consumer} to handle the element. Return {@code true}
     * if the advancement succeeds, or {@code false} otherwise. If {@code false}
     * is returned, it indicates that there no more elements remain behind
     * to advance to, and all subsequent calls to this method will also
     * return {@code false}.
     *
     * @param consumer the specified {@link Consumer} action
     * @return {@code true} if the advancement succeeds, {@code false} otherwise
     */
    boolean next(Consumer<? super V> consumer);

    /**
     * Execute the provided {@link Consumer} action for each remaining element,
     * sequentially in the current {@link Thread}, until all elements have been processed.
     *
     * @param consumer the specified {@link Consumer} action
     */
    default void each(Consumer<? super V> consumer) {
        while (true) if (!next(consumer)) return;
    }

    /**
     * Return an idle Advancer.
     *
     * @return an idle Advancer
     * @param <V> the type of values
     */
    static <V> Advancer<V> advancer() {
        return consumer -> false;
    }

    /**
     * Return an Advancer of the given values.
     *
     * @param values the given values
     * @return an Advancer of the given values.
     * @param <V> the type of values
     */
    @SafeVarargs
    static <V> Advancer<V> advancer(V... values) {
        return new Advancer<V>() {

            private int index = values.length;

            @Override public boolean next(Consumer<? super V> consumer) {
                if (index > 0) {
                    consumer.accept(values[--index]); return true;
                } return false; }
        };
    }

    /**
     * Return an Advancer backed by the specified {@link Iterator}.
     *
     * @param iterator the specified {@link Iterator}
     * @return an Advancer backed by the specified {@link Iterator}
     * @param <V> the type of elements
     */
    static <V> Advancer<V> advancer(Iterator<? extends V> iterator) {
        return consumer -> {
            if (!iterator.hasNext()) return false;
            consumer.accept(iterator.next()); return true;
        };
    }
}

