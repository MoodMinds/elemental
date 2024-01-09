package org.moodminds.elemental;

/**
 * A navigable extension of the {@link SortedSet} interface, which also
 * extends the {@link NavigableCollection} and {@link java.util.NavigableSet} interfaces.
 *
 * @param <V> the type of elements
 */
public interface NavigableSet<V> extends SortedSet<V>, NavigableCollection<V>,
        java.util.NavigableSet<V> {

    /**
     * {@inheritDoc}
     *
     * @param e {@inheritDoc}
     * @return {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    default V lower(V e) {
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
    default V floor(V e) {
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
    default V ceiling(V e) {
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
    default V higher(V e) {
        return NavigableCollection.super.higher(e);
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    default NavigableSet<V> descending() {
        return descendingSet();
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    NavigableSet<V> descendingSet();

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
    default NavigableSet<V> sub(V fromElement, boolean fromInclusive, V toElement, boolean toInclusive) {
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
    NavigableSet<V> subSet(V fromElement, boolean fromInclusive, V toElement, boolean toInclusive);

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
    default NavigableSet<V> head(V toElement, boolean inclusive) {
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
    NavigableSet<V> headSet(V toElement, boolean inclusive);

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
    default NavigableSet<V> tail(V fromElement, boolean inclusive) {
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
    NavigableSet<V> tailSet(V fromElement, boolean inclusive);

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
    default SortedSet<V> sub(V fromElement, V toElement) {
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
    SortedSet<V> subSet(V fromElement, V toElement);

    /**
     * {@inheritDoc}
     *
     * @param toElement {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    default SortedSet<V> head(V toElement) {
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
    SortedSet<V> headSet(V toElement);

    /**
     * {@inheritDoc}
     *
     * @param fromElement {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    default SortedSet<V> tail(V fromElement) {
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
    SortedSet<V> tailSet(V fromElement);
}
