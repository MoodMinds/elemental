package org.moodminds.elemental;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

import static java.util.Objects.requireNonNull;

/**
 * An iterator that adds possibility to traverse in backward direction
 * with additional {@link #hasPrevious()} and {@link #previous()} methods.
 *
 * @param <V> the type of elements
 */
public interface PreviousIterator<V> extends Iterator<V> {

    /**
     * Determine whether this iterator has additional elements when moving
     * in the reverse direction, returning {@code true} if there are more
     * elements available for retrieval using {@link #previous} without
     * encountering an exception.
     *
     * @return {@code true} if there are more elements available for retrieval
     *         in the reverse direction, {@code false} otherwise
     */
    boolean hasPrevious();

    /**
     * Retrieve the element that precedes the current cursor position and
     * moves the cursor backward. This method can be used iteratively to
     * navigate backward through the sequence or can be mixed with calls
     * to {@link #next} to traverse back and forth. It's important to note
     * that alternating calls to {@code next} and {@code previous} will
     * yield the same element repeatedly.
     *
     * @return the element preceding the current cursor position
     * @throws NoSuchElementException if there are no previous elements
     *         in the iteration
     */
    V previous();

    /**
     * Execute the given action for each preceding element in reverse order,
     * processing all elements unless an exception is thrown by the action.
     * <p>
     * If the iteration order is defined, actions are applied in reverse.
     * Any exceptions thrown by the action are propagated to the caller.
     * <p>
     * Modifying the source during iteration (e.g., using {@link #remove remove}
     * or other mutator methods) results in undefined behavior, unless a subclass
     * explicitly allows concurrent modifications.
     * <p>
     * If the action throws an exception, the subsequent behavior of the iterator
     * is unspecified.
     *
     * @implSpec
     * The default implementation operates as follows:
     * <pre>{@code
     *     while (hasPrevious())
     *         action.accept(previous());
     * }</pre>
     *
     * @param action The action to perform on each element
     * @throws NullPointerException if the action is {@code null}
     */
    default void forEachPreceding(Consumer<? super V> action) {
        requireNonNull(action);
        while (hasPrevious())
            action.accept(previous());
    }
}
