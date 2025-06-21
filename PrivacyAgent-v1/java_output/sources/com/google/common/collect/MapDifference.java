package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public interface MapDifference<K, V> {

    public interface ValueDifference<V> {
        boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj);

        int hashCode();

        V leftValue();

        V rightValue();
    }

    boolean areEqual();

    java.util.Map<K, com.google.common.collect.MapDifference.ValueDifference<V>> entriesDiffering();

    java.util.Map<K, V> entriesInCommon();

    java.util.Map<K, V> entriesOnlyOnLeft();

    java.util.Map<K, V> entriesOnlyOnRight();

    boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj);

    int hashCode();
}
