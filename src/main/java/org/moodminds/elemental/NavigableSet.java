package org.moodminds.elemental;

/**
 * A navigable extension of the {@link SortedSet} interface, which also
 * extends the {@link NavigableCollection} and {@link java.util.NavigableSet} interfaces.
 *
 * @param <E> the type of elements
 */
public interface NavigableSet<E> extends SortedSet<E>, NavigableCollection<E>,
        java.util.NavigableSet<E> {

    /**
     * {@inheritDoc}
     *
     * @param e {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    default E lower(E e) {
        return NavigableCollection.super.lower(e);
    }

    /**
     * {@inheritDoc}
     *
     * @param e {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    default E floor(E e) {
        return NavigableCollection.super.floor(e);
    }

    /**
     * {@inheritDoc}
     *
     * @param e {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    default E ceiling(E e) {
        return NavigableCollection.super.ceiling(e);
    }

    /**
     * {@inheritDoc}
     *
     * @param e {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    default E higher(E e) {
        return NavigableCollection.super.higher(e);
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default NavigableSet<E> descending() {
        return descendingSet();
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    NavigableSet<E> descendingSet();

    /**
     * {@inheritDoc}
     *
     * @param fromElement {@inheritDoc}
     * @param fromInclusive {@inheritDoc}
     * @param toElement {@inheritDoc}
     * @param toInclusive {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    default NavigableSet<E> sub(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
        return subSet(fromElement, fromInclusive, toElement, toInclusive);
    }

    /**
     * {@inheritDoc}
     *
     * @param fromElement {@inheritDoc}
     * @param fromInclusive {@inheritDoc}
     * @param toElement {@inheritDoc}
     * @param toInclusive {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive);

    /**
     * {@inheritDoc}
     *
     * @param toElement {@inheritDoc}
     * @param inclusive {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    default NavigableSet<E> head(E toElement, boolean inclusive) {
        return headSet(toElement, inclusive);
    }

    /**
     * {@inheritDoc}
     *
     * @param toElement {@inheritDoc}
     * @param inclusive {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    NavigableSet<E> headSet(E toElement, boolean inclusive);

    /**
     * {@inheritDoc}
     *
     * @param fromElement {@inheritDoc}
     * @param inclusive {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    default NavigableSet<E> tail(E fromElement, boolean inclusive) {
        return tailSet(fromElement, inclusive);
    }

    /**
     * {@inheritDoc}
     *
     * @param fromElement {@inheritDoc}
     * @param inclusive {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    NavigableSet<E> tailSet(E fromElement, boolean inclusive);

    /**
     * {@inheritDoc}
     *
     * @param fromElement {@inheritDoc}
     * @param toElement {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    default SortedSet<E> sub(E fromElement, E toElement) {
        return SortedSet.super.sub(fromElement, toElement);
    }

    /**
     * {@inheritDoc}
     *
     * @param fromElement {@inheritDoc}
     * @param toElement {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    SortedSet<E> subSet(E fromElement, E toElement);

    /**
     * {@inheritDoc}
     *
     * @param toElement {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    default SortedSet<E> head(E toElement) {
        return SortedSet.super.head(toElement);
    }

    /**
     * {@inheritDoc}
     *
     * @param toElement {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    SortedSet<E> headSet(E toElement);

    /**
     * {@inheritDoc}
     *
     * @param fromElement {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    default SortedSet<E> tail(E fromElement) {
        return SortedSet.super.tail(fromElement);
    }

    /**
     * {@inheritDoc}
     *
     * @param fromElement {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    SortedSet<E> tailSet(E fromElement);
}
