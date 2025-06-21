package com.google.common.collect;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
abstract class AbstractNavigableMap<K, V> extends com.google.common.collect.Maps.IteratorBasedAbstractMap<K, V> implements java.util.NavigableMap<K, V> {

    public final class DescendingMap extends com.google.common.collect.Maps.DescendingMap<K, V> {
        public DescendingMap() {
        }

        public /* synthetic */ DescendingMap(com.google.common.collect.AbstractNavigableMap abstractNavigableMap, com.google.common.collect.AbstractNavigableMap.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.common.collect.Maps.DescendingMap
        public java.util.Iterator<java.util.Map.Entry<K, V>> entryIterator() {
            return com.google.common.collect.AbstractNavigableMap.this.b();
        }

        @Override // com.google.common.collect.Maps.DescendingMap
        public java.util.NavigableMap<K, V> l() {
            return com.google.common.collect.AbstractNavigableMap.this;
        }
    }

    public abstract java.util.Iterator<java.util.Map.Entry<K, V>> b();

    @Override // java.util.NavigableMap
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public java.util.Map.Entry<K, V> ceilingEntry(K k) {
        return tailMap(k, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K k) {
        return (K) com.google.common.collect.Maps.x(ceilingEntry(k));
    }

    @Override // java.util.NavigableMap
    public java.util.NavigableSet<K> descendingKeySet() {
        return descendingMap().navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public java.util.NavigableMap<K, V> descendingMap() {
        return new com.google.common.collect.AbstractNavigableMap.DescendingMap(this, null);
    }

    @Override // java.util.NavigableMap
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public java.util.Map.Entry<K, V> firstEntry() {
        return (java.util.Map.Entry) com.google.common.collect.Iterators.getNext(a(), null);
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        java.util.Map.Entry<K, V> firstEntry = firstEntry();
        if (firstEntry != null) {
            return firstEntry.getKey();
        }
        throw new java.util.NoSuchElementException();
    }

    @Override // java.util.NavigableMap
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public java.util.Map.Entry<K, V> floorEntry(K k) {
        return headMap(k, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K floorKey(K k) {
        return (K) com.google.common.collect.Maps.x(floorEntry(k));
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public java.util.SortedMap<K, V> headMap(K k) {
        return headMap(k, false);
    }

    @Override // java.util.NavigableMap
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public java.util.Map.Entry<K, V> higherEntry(K k) {
        return tailMap(k, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K higherKey(K k) {
        return (K) com.google.common.collect.Maps.x(higherEntry(k));
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public java.util.Set<K> keySet() {
        return navigableKeySet();
    }

    @Override // java.util.NavigableMap
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public java.util.Map.Entry<K, V> lastEntry() {
        return (java.util.Map.Entry) com.google.common.collect.Iterators.getNext(b(), null);
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        java.util.Map.Entry<K, V> lastEntry = lastEntry();
        if (lastEntry != null) {
            return lastEntry.getKey();
        }
        throw new java.util.NoSuchElementException();
    }

    @Override // java.util.NavigableMap
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public java.util.Map.Entry<K, V> lowerEntry(K k) {
        return headMap(k, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K k) {
        return (K) com.google.common.collect.Maps.x(lowerEntry(k));
    }

    @Override // java.util.NavigableMap
    public java.util.NavigableSet<K> navigableKeySet() {
        return new com.google.common.collect.Maps.NavigableKeySet(this);
    }

    @Override // java.util.NavigableMap
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public java.util.Map.Entry<K, V> pollFirstEntry() {
        return (java.util.Map.Entry) com.google.common.collect.Iterators.k(a());
    }

    @Override // java.util.NavigableMap
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public java.util.Map.Entry<K, V> pollLastEntry() {
        return (java.util.Map.Entry) com.google.common.collect.Iterators.k(b());
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public java.util.SortedMap<K, V> subMap(K k, K k2) {
        return subMap(k, true, k2, false);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public java.util.SortedMap<K, V> tailMap(K k) {
        return tailMap(k, true);
    }
}
