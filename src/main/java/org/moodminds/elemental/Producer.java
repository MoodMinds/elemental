package org.moodminds.elemental;

import java.util.function.Consumer;

/**
 * A Producer of values to a specified {@link Consumer}.
 * This interface does not impose any contract for the number of values
 * or the {@link Thread} in which they are provided and the specified
 * {@link Consumer} should be ready to handle them in different {@link Thread}s.
 *
 * @param <V> the type of value(s)
 */
@FunctionalInterface
public interface Producer<V> {

    /**
     * Provide value(s) to the specified {@link Consumer}.
     *
     * @param consumer the specified {@link Consumer} of value(s)
     */
    void provide(Consumer<? super V> consumer);


    /**
     * Return idle Producer.
     *
     * @return idle Producer
     * @param <V> the type of values
     */
    static <V> Producer<V> producer() {
        return consumer -> {};
    }

    /**
     * Return sequential single-threaded Producer of the given values.
     *
     * @param values the given values
     * @return sequential single-threaded Producer of the given values
     * @param <V> the type of values
     */
    @SafeVarargs
    static <V> Producer<V> producer(V... values) {
        return consumer -> {
            for (V value : values) consumer.accept(value);
        };
    }
}

