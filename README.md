# Source of common Elementary abstractions

**Elemental** is a collection of essential abstractions as building blocks for your projects. It starts with immutable
interfaces and smoothly extends them to mutable ones, offering a comprehensive set of foundational elements for various use cases.

## Overview

The **Elemental** project aims to improve upon the Java Development Kit (JDK) by introducing immutable abstractions for various
data structures such as containers, sequences, associations, key-values, and tuples. These abstractions have been created
to eliminate the need for using the far-fetched concept of **Unmodifiable Collections** (and therefore **UnsupportedOperationException**)
and to make code clearer and more readable while encouraging immutability.

## Key Interfaces

### Immutable:

- **Container**: An immutable holder of values providing an immutable collection-like structure.
- **Ordered**: An interface for accessing logically grouped values based on their positional indices.
- **Sequence**: Extends **Container** and **Ordered**, providing an immutable list-like structure.
- **SequenceIterator**: An **java.util.Iterator**, adding information about **Sequence** indexes while traversing.
- **Tailed**: A Linear **Container**, providing additional access to elements at tail end.
- **TailedSequence**: Extends **Tailed** and **Sequence**, providing access to elements at both ends (head and tail) of the sequence.
- **TailedSequenceIterator**: Extends **SequenceIterator**, adding the possibility to traverse backward.
- **SortedContainer**: Extends **Container**, providing a sorted immutable collection-like structure.
- **NavigableContainer**: Extends **SortedContainer**, providing a navigable sorted immutable collection-like structure.
- **KeyValue**: A structure for key-value pairs without mutation methods.
- **Association**: An associative **Container** of **KeyValue**s providing an immutable map-like structure.
- **SortedAssociation**: Extends **Association**, providing a sorted immutable map-like structure.
- **NavigableAssociation**: Extends **SortedAssociation**, providing a navigable sorted immutable map-like structure.
- **Tuple**: An **Ordered** with width.
- **Tuple1**... up to **Tuple8**: Positionally parameterized extensions of **Tuple**.

### Mutable:

- **Collection**: A mutable **Container** that extends also **java.util.Collection**.
- **Queue**: A queue that extends **Collection** and **java.util.Queue**.
- **Deque**: A double ended queue that extends **Queue**, **Tailed** and **java.util.Deque**.
- **BlockingQueue**: A concurrent blocking **Queue** that extends also **java.util.concurrent.BlockingQueue**.
- **BlockingDeque**: A concurrent blocking **Deque** that extends also **BlockingQueue** and **java.util.concurrent.BlockingDeque**.
- **List**: A list that extends **Collection**, **TailedSequence** and **java.util.List**.
- **ListIterator**: A list iterator that extends **TailedSequenceIterator** and **java.util.ListIterator**.
- **SortedCollection**: A mutable **SortedContainer** that extends also **Collection**.
- **NavigableCollection**: A mutable **NavigableContainer** that extends also **SortedCollection**.
- **Set**: A distinct elements **Collection** that extends also **java.util.Set**.
- **SortedSet**: A distinct elements **SortedCollection** that extends also **Set** and **java.util.SortedSet**.
- **NavigableSet**: A distinct elements **NavigableCollection** that extends also **SortedSet** and **java.util.NavigableSet**.
- **Map**: A map that extends **Association** and **java.util.Map**.
- **Map.Entry**: A map entry that extends **KeyValue** and **java.util.Map.Entry**.
- **SortedMap**: A mutable **SortedAssociation** that extends also **java.util.SortedMap**.
- **NavigableMap**: A mutable **NavigableAssociation** that extends also **SortedMap** and **java.util.NavigableMap**.
- **ConcurrentMap**: A concurrent **Map** that extends also **java.util.concurrent.ConcurrentMap**.
- **ConcurrentNavigableMap**: A concurrent **NavigableMap** that extends also **ConcurrentMap** and **java.util.concurrent.ConcurrentNavigableMap**.


### Key Notes on the Container Interface

The **Container** interface defines two core methods: **getCount(Object o)** and **getAll(Object o)**.

- **getCount** returns the number of elements that match a given reference object.
- **getAll** provides a **java.util.Iterator** over all matching elements.

This interface is fundamentally designed to facilitate efficient (typically constant or logarithmic time)
access to elements based on an example object, and the implementation of the `getCount` and `getAll` methods adheres closely to this principle.

Unlike **java.util.Collection**, which serves as a base interface in the Java Development Kit (JDK), **Container** is specifically designed for direct implementations.
This is similar to how **java.util.HashSet** is a direct implementation of **java.util.Set**. However, an important distinction is that both **Container** and **Collection**
allow duplicate elements in their implementations, such as a hypothetical **HashContainer** and a mutable **HashCollection** (which is not itself a **java.util.Set**).

Furthermore, in the Java Development Kit (JDK), there is a notable limitation when it comes to having a sorted **java.util.Collection** that permits duplicates.
Unlike the **java.util.SortedSet**, which does not allow duplicates, and similar to the **java.util.List** that allows duplicates
but may disrupt the ordering contract of a **java.util.List**, this is where the concept of **SortedContainer** and mutable **SortedCollection**
come into play, particularly with theirs hypothetical implementations, such as **TreeContainer**
and mutable **TreeCollection** (which will not be **java.util.SortedSet** extensions).

## Getting Started

Include **Elemental** in your project by adding the dependency.

## Maven configuration

Artifacts can be found on [Maven Central](https://search.maven.org/) after publication.

```xml
<dependency>
    <groupId>org.moodminds.elemental</groupId>
    <artifactId>elemental</artifactId>
    <version>${version}</version>
</dependency>
```

## Building from Source

You may need to build from source to use **Elemental** (until it is in Maven Central) with Maven and JDK 1.8 at least.

## License
This project is going to be released under version 2.0 of the [Apache License][l].

[l]: https://www.apache.org/licenses/LICENSE-2.0