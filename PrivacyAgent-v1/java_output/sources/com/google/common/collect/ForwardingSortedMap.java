package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public abstract class ForwardingSortedMap<K, V> extends com.google.common.collect.ForwardingMap<K, V> implements java.util.SortedMap<K, V> {

    @com.google.common.annotations.Beta
    public class StandardKeySet extends com.google.common.collect.Maps.SortedKeySet<K, V> {
        public StandardKeySet() {
            super(com.google.common.collect.ForwardingSortedMap.this);
        }
    }

    private int unsafeCompare(java.lang.Object obj, java.lang.Object obj2) {
        java.util.Comparator<? super K> comparator = comparator();
        return comparator == null ? ((java.lang.Comparable) obj).compareTo(obj2) : comparator.compare(obj, obj2);
    }

    @Override // java.util.SortedMap
    public java.util.Comparator<? super K> comparator() {
        return delegate().comparator();
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public abstract java.util.SortedMap<K, V> delegate();

    @Override // java.util.SortedMap
    public K firstKey() {
        return delegate().firstKey();
    }

    @Override // java.util.SortedMap
    public java.util.SortedMap<K, V> headMap(K k) {
        return delegate().headMap(k);
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        return delegate().lastKey();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingMap
    @com.google.common.annotations.Beta
    public boolean standardContainsKey(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        try {
            return unsafeCompare(tailMap(obj).firstKey(), obj) == 0;
        } catch (java.lang.ClassCastException | java.lang.NullPointerException | java.util.NoSuchElementException unused) {
            return false;
        }
    }

    @com.google.common.annotations.Beta
    public java.util.SortedMap<K, V> standardSubMap(K k, K k2) {
        com.google.common.base.Preconditions.checkArgument(unsafeCompare(k, k2) <= 0, "fromKey must be <= toKey");
        return tailMap(k).headMap(k2);
    }

    @Override // java.util.SortedMap
    public java.util.SortedMap<K, V> subMap(K k, K k2) {
        return delegate().subMap(k, k2);
    }

    @Override // java.util.SortedMap
    public java.util.SortedMap<K, V> tailMap(K k) {
        return delegate().tailMap(k);
    }
}
