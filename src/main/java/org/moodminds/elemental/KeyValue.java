package org.moodminds.elemental;

/**
 * Accessor to key-value pairs in the associative sense, indicating that a value is associated with a key.
 *
 * @param <K> the type of the key
 * @param <V> the type of the value
 */
public interface KeyValue<K, V> {

    /**
     * Return the key of the association.
     *
     * @return the key of the association
     * @param <R> the type of return key
     * @throws RuntimeException in case of any key retrieval error
     */
    <R extends K> R getKey();

    /**
     * Return the value of the association.
     *
     * @return the value of the association
     * @param <R> the type of return value
     * @throws RuntimeException in case of any value retrieval error
     */
    <R extends V> R getValue();

    /**
     * Return the hash code value for this KeyValue. While this interface does not
     * impose any specific {@code Object.hashCode} contract for KeyValue objects,
     * implementations may decide that the hash code of a KeyValue {@code kv} should
     * be defined as:
     * <pre>
     *     (kv.getKey()==null   ? 0 : kv.getKey().hashCode()) ^
     *     (kv.getValue()==null ? 0 : kv.getValue().hashCode())
     * </pre>
     *
     * @return the hash code value for this KeyValue
     */
    @Override
    int hashCode();

    /**
     * Compare the specified object with this KeyValue for equality. While this interface
     * does not impose any specific equality contract for KeyValue objects, implementations
     * may decide to return {@code true} if the given object also represents a key-value pair
     * and the two key-value pairs represent the same association. More formally, if two
     * key-values {@code kv1} and {@code kv2} represent the same association:
     * <pre>
     *     (kv1.getKey()==null ?
     *      kv2.getKey()==null : kv1.getKey().equals(kv2.getKey()))  &amp;&amp;
     *     (kv1.getValue()==null ?
     *      kv2.getValue()==null : kv1.getValue().equals(kv2.getValue()))
     * </pre>
     *
     * @param obj object to be compared for equality with this KeyValue
     * @return {@code true} if the specified object is equal to this KeyValue
     */
    boolean equals(Object obj);
}
