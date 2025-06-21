package com.google.common.collect;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public abstract class ForwardingNavigableMap<K, V> extends com.google.common.collect.ForwardingSortedMap<K, V> implements java.util.NavigableMap<K, V> {

    @com.google.common.annotations.Beta
    public class StandardDescendingMap extends com.google.common.collect.Maps.DescendingMap<K, V> {

        /* renamed from: com.google.common.collect.ForwardingNavigableMap$StandardDescendingMap$1, reason: invalid class name */
        public class AnonymousClass1 implements java.util.Iterator<java.util.Map.Entry<K, V>> {
            public java.util.Map.Entry<K, V> n = null;
            public java.util.Map.Entry<K, V> t;

            public AnonymousClass1() {
                this.t = com.google.common.collect.ForwardingNavigableMap.StandardDescendingMap.this.l().lastEntry();
            }

            @Override // java.util.Iterator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public java.util.Map.Entry<K, V> next() {
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException();
                }
                try {
                    java.util.Map.Entry<K, V> entry = this.t;
                    this.n = entry;
                    this.t = com.google.common.collect.ForwardingNavigableMap.StandardDescendingMap.this.l().lowerEntry(this.t.getKey());
                    return entry;
                } catch (java.lang.Throwable th) {
                    this.n = this.t;
                    this.t = com.google.common.collect.ForwardingNavigableMap.StandardDescendingMap.this.l().lowerEntry(this.t.getKey());
                    throw th;
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.t != null;
            }

            @Override // java.util.Iterator
            public void remove() {
                com.google.common.collect.CollectPreconditions.e(this.n != null);
                com.google.common.collect.ForwardingNavigableMap.StandardDescendingMap.this.l().remove(this.n.getKey());
                this.n = null;
            }
        }

        public StandardDescendingMap() {
        }

        @Override // com.google.common.collect.Maps.DescendingMap
        public java.util.Iterator<java.util.Map.Entry<K, V>> entryIterator() {
            return new com.google.common.collect.ForwardingNavigableMap.StandardDescendingMap.AnonymousClass1();
        }

        @Override // com.google.common.collect.Maps.DescendingMap
        public java.util.NavigableMap<K, V> l() {
            return com.google.common.collect.ForwardingNavigableMap.this;
        }
    }

    @com.google.common.annotations.Beta
    public class StandardNavigableKeySet extends com.google.common.collect.Maps.NavigableKeySet<K, V> {
        public StandardNavigableKeySet() {
            super(com.google.common.collect.ForwardingNavigableMap.this);
        }
    }

    @Override // java.util.NavigableMap
    public java.util.Map.Entry<K, V> ceilingEntry(K k) {
        return delegate().ceilingEntry(k);
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K k) {
        return delegate().ceilingKey(k);
    }

    @Override // com.google.common.collect.ForwardingSortedMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public abstract java.util.NavigableMap<K, V> delegate();

    @Override // java.util.NavigableMap
    public java.util.NavigableSet<K> descendingKeySet() {
        return delegate().descendingKeySet();
    }

    @Override // java.util.NavigableMap
    public java.util.NavigableMap<K, V> descendingMap() {
        return delegate().descendingMap();
    }

    @Override // java.util.NavigableMap
    public java.util.Map.Entry<K, V> firstEntry() {
        return delegate().firstEntry();
    }

    @Override // java.util.NavigableMap
    public java.util.Map.Entry<K, V> floorEntry(K k) {
        return delegate().floorEntry(k);
    }

    @Override // java.util.NavigableMap
    public K floorKey(K k) {
        return delegate().floorKey(k);
    }

    @Override // java.util.NavigableMap
    public java.util.NavigableMap<K, V> headMap(K k, boolean z) {
        return delegate().headMap(k, z);
    }

    @Override // java.util.NavigableMap
    public java.util.Map.Entry<K, V> higherEntry(K k) {
        return delegate().higherEntry(k);
    }

    @Override // java.util.NavigableMap
    public K higherKey(K k) {
        return delegate().higherKey(k);
    }

    @Override // java.util.NavigableMap
    public java.util.Map.Entry<K, V> lastEntry() {
        return delegate().lastEntry();
    }

    @Override // java.util.NavigableMap
    public java.util.Map.Entry<K, V> lowerEntry(K k) {
        return delegate().lowerEntry(k);
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K k) {
        return delegate().lowerKey(k);
    }

    @Override // java.util.NavigableMap
    public java.util.NavigableSet<K> navigableKeySet() {
        return delegate().navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public java.util.Map.Entry<K, V> pollFirstEntry() {
        return delegate().pollFirstEntry();
    }

    @Override // java.util.NavigableMap
    public java.util.Map.Entry<K, V> pollLastEntry() {
        return delegate().pollLastEntry();
    }

    public java.util.Map.Entry<K, V> standardCeilingEntry(K k) {
        return tailMap(k, true).firstEntry();
    }

    public K standardCeilingKey(K k) {
        return (K) com.google.common.collect.Maps.x(ceilingEntry(k));
    }

    @com.google.common.annotations.Beta
    public java.util.NavigableSet<K> standardDescendingKeySet() {
        return descendingMap().navigableKeySet();
    }

    public java.util.Map.Entry<K, V> standardFirstEntry() {
        return (java.util.Map.Entry) com.google.common.collect.Iterables.getFirst(entrySet(), null);
    }

    public K standardFirstKey() {
        java.util.Map.Entry<K, V> firstEntry = firstEntry();
        if (firstEntry != null) {
            return firstEntry.getKey();
        }
        throw new java.util.NoSuchElementException();
    }

    public java.util.Map.Entry<K, V> standardFloorEntry(K k) {
        return headMap(k, true).lastEntry();
    }

    public K standardFloorKey(K k) {
        return (K) com.google.common.collect.Maps.x(floorEntry(k));
    }

    public java.util.SortedMap<K, V> standardHeadMap(K k) {
        return headMap(k, false);
    }

    public java.util.Map.Entry<K, V> standardHigherEntry(K k) {
        return tailMap(k, false).firstEntry();
    }

    public K standardHigherKey(K k) {
        return (K) com.google.common.collect.Maps.x(higherEntry(k));
    }

    public java.util.Map.Entry<K, V> standardLastEntry() {
        return (java.util.Map.Entry) com.google.common.collect.Iterables.getFirst(descendingMap().entrySet(), null);
    }

    public K standardLastKey() {
        java.util.Map.Entry<K, V> lastEntry = lastEntry();
        if (lastEntry != null) {
            return lastEntry.getKey();
        }
        throw new java.util.NoSuchElementException();
    }

    public java.util.Map.Entry<K, V> standardLowerEntry(K k) {
        return headMap(k, false).lastEntry();
    }

    public K standardLowerKey(K k) {
        return (K) com.google.common.collect.Maps.x(lowerEntry(k));
    }

    public java.util.Map.Entry<K, V> standardPollFirstEntry() {
        return (java.util.Map.Entry) com.google.common.collect.Iterators.k(entrySet().iterator());
    }

    public java.util.Map.Entry<K, V> standardPollLastEntry() {
        return (java.util.Map.Entry) com.google.common.collect.Iterators.k(descendingMap().entrySet().iterator());
    }

    @Override // com.google.common.collect.ForwardingSortedMap
    public java.util.SortedMap<K, V> standardSubMap(K k, K k2) {
        return subMap(k, true, k2, false);
    }

    public java.util.SortedMap<K, V> standardTailMap(K k) {
        return tailMap(k, true);
    }

    @Override // java.util.NavigableMap
    public java.util.NavigableMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
        return delegate().subMap(k, z, k2, z2);
    }

    @Override // java.util.NavigableMap
    public java.util.NavigableMap<K, V> tailMap(K k, boolean z) {
        return delegate().tailMap(k, z);
    }
}
