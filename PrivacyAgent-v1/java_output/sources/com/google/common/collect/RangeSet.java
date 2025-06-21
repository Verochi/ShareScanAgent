package com.google.common.collect;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public interface RangeSet<C extends java.lang.Comparable> {
    void add(com.google.common.collect.Range<C> range);

    void addAll(com.google.common.collect.RangeSet<C> rangeSet);

    void addAll(java.lang.Iterable<com.google.common.collect.Range<C>> iterable);

    java.util.Set<com.google.common.collect.Range<C>> asDescendingSetOfRanges();

    java.util.Set<com.google.common.collect.Range<C>> asRanges();

    void clear();

    com.google.common.collect.RangeSet<C> complement();

    boolean contains(C c);

    boolean encloses(com.google.common.collect.Range<C> range);

    boolean enclosesAll(com.google.common.collect.RangeSet<C> rangeSet);

    boolean enclosesAll(java.lang.Iterable<com.google.common.collect.Range<C>> iterable);

    boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj);

    int hashCode();

    boolean intersects(com.google.common.collect.Range<C> range);

    boolean isEmpty();

    com.google.common.collect.Range<C> rangeContaining(C c);

    void remove(com.google.common.collect.Range<C> range);

    void removeAll(com.google.common.collect.RangeSet<C> rangeSet);

    void removeAll(java.lang.Iterable<com.google.common.collect.Range<C>> iterable);

    com.google.common.collect.Range<C> span();

    com.google.common.collect.RangeSet<C> subRangeSet(com.google.common.collect.Range<C> range);

    java.lang.String toString();
}
