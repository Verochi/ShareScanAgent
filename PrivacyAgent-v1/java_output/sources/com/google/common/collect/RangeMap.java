package com.google.common.collect;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public interface RangeMap<K extends java.lang.Comparable, V> {
    java.util.Map<com.google.common.collect.Range<K>, V> asDescendingMapOfRanges();

    java.util.Map<com.google.common.collect.Range<K>, V> asMapOfRanges();

    void clear();

    boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj);

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    V get(K k);

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    java.util.Map.Entry<com.google.common.collect.Range<K>, V> getEntry(K k);

    int hashCode();

    void put(com.google.common.collect.Range<K> range, V v);

    void putAll(com.google.common.collect.RangeMap<K, V> rangeMap);

    void putCoalescing(com.google.common.collect.Range<K> range, V v);

    void remove(com.google.common.collect.Range<K> range);

    com.google.common.collect.Range<K> span();

    com.google.common.collect.RangeMap<K, V> subRangeMap(com.google.common.collect.Range<K> range);

    java.lang.String toString();
}
