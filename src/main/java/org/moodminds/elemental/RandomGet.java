package org.moodminds.elemental;

/**
 * Marker interface utilized by {@link Sequence} implementations to signify
 * support for fast (typically constant time) random element reading by their
 * position index. The main purpose of this interface is to enable generic
 * algorithms to adjust their behavior to ensure optimal performance when
 * applied to both random and sequential reading sequences.
 * <p>
 * Generic sequence algorithms are encouraged to check whether the given sequence
 * is an {@code instanceof RandomGet} before applying an algorithm that might
 * exhibit suboptimal performance on a sequential read sequence. They should
 * adapt their behavior as needed to guarantee acceptable performance.
 * <p>
 * It is acknowledged that the distinction between random and sequential reading
 * is often indistinct. For instance, certain {@link Sequence} implementations may
 * offer asymptotically linear access times for large datasets but constant read
 * times in practical scenarios. Such a {@link Sequence} implementation should
 * generally implement this interface. As a general guideline, it is recommended
 * for a {@link Sequence} implementation to implement this interface if the
 * execution time of the following random read loop:
 * <pre>
 *     for (int i = 0, n = sequence.size(); i &lt; n; i++)
 *         sequence.get(i);
 * </pre>
 * is approximately equivalent to that of this sequential read loop:
 * <pre>
 *     for (Iterator i = sequence.iterator(); i.hasNext(); )
 *         i.next();
 * </pre>
 *
 * @see Sequence#get(int)
 */
public interface RandomGet {}
