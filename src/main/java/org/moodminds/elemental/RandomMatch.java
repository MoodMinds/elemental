package org.moodminds.elemental;

/**
 * Marker interface used by implementations of {@link Container} to indicate
 * support for presumably efficient (typically constant or logarithmic time) random
 * element matching based on the provided example object. The primary goal of this
 * interface is to enable generic algorithms to tailor their behavior for optimal
 * performance when applied to both randomly and sequentially matching containers.
 * <p>
 * Generic container algorithms are advised to check whether the given container
 * is an {@code instanceof RandomMatch} before applying an algorithm that may
 * exhibit suboptimal performance on a sequentially matching container. They should
 * adjust their behavior as necessary to ensure satisfactory performance.
 * <p>
 * As a general guideline, it is recommended for a {@link Container} implementation
 * to implement this interface if the execution time of the following random match loop:
 * <pre>
 *     for (Iterator i = container.iterator(); i.hasNext(); ) {
 *         int count = container.getCount(i.next());
 *     }
 * </pre>
 * runs faster than the corresponding sequential match loop:
 * <pre>
 *     for (Iterator i = container.iterator(); i.hasNext(); ) {
 *         int count = 0;
 *         for (Iterator m = container.iterator(); m.hasNext(); )
 *              if (Objects.equals(i.next(), m.next()))
 *                  count++;
 *     }
 * </pre>
 *
 * @see Container#getCount(Object)
 */
public interface RandomMatch {}
