package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
abstract class AbstractMapBasedMultimap<K, V> extends com.google.common.collect.AbstractMultimap<K, V> implements java.io.Serializable {
    private static final long serialVersionUID = 2447537837011683357L;
    private transient java.util.Map<K, java.util.Collection<V>> map;
    private transient int totalSize;

    /* renamed from: com.google.common.collect.AbstractMapBasedMultimap$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.common.collect.AbstractMapBasedMultimap<K, V>.Itr<V> {
        public AnonymousClass1() {
            super();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.Itr
        public V a(K k, V v) {
            return v;
        }
    }

    /* renamed from: com.google.common.collect.AbstractMapBasedMultimap$2, reason: invalid class name */
    public class AnonymousClass2 extends com.google.common.collect.AbstractMapBasedMultimap<K, V>.Itr<java.util.Map.Entry<K, V>> {
        public AnonymousClass2() {
            super();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.Itr
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public java.util.Map.Entry<K, V> a(K k, V v) {
            return com.google.common.collect.Maps.immutableEntry(k, v);
        }
    }

    public class AsMap extends com.google.common.collect.Maps.ViewCachingAbstractMap<K, java.util.Collection<V>> {
        public final transient java.util.Map<K, java.util.Collection<V>> v;

        public class AsMapEntries extends com.google.common.collect.Maps.EntrySet<K, java.util.Collection<V>> {
            public AsMapEntries() {
            }

            @Override // com.google.common.collect.Maps.EntrySet
            public java.util.Map<K, java.util.Collection<V>> a() {
                return com.google.common.collect.AbstractMapBasedMultimap.AsMap.this;
            }

            @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(java.lang.Object obj) {
                return com.google.common.collect.Collections2.g(com.google.common.collect.AbstractMapBasedMultimap.AsMap.this.v.entrySet(), obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public java.util.Iterator<java.util.Map.Entry<K, java.util.Collection<V>>> iterator() {
                return com.google.common.collect.AbstractMapBasedMultimap.AsMap.this.new AsMapIterator();
            }

            @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(java.lang.Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                com.google.common.collect.AbstractMapBasedMultimap.this.removeValuesForKey(((java.util.Map.Entry) obj).getKey());
                return true;
            }
        }

        public class AsMapIterator implements java.util.Iterator<java.util.Map.Entry<K, java.util.Collection<V>>> {
            public final java.util.Iterator<java.util.Map.Entry<K, java.util.Collection<V>>> n;

            @org.checkerframework.checker.nullness.compatqual.NullableDecl
            public java.util.Collection<V> t;

            public AsMapIterator() {
                this.n = com.google.common.collect.AbstractMapBasedMultimap.AsMap.this.v.entrySet().iterator();
            }

            @Override // java.util.Iterator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public java.util.Map.Entry<K, java.util.Collection<V>> next() {
                java.util.Map.Entry<K, java.util.Collection<V>> next = this.n.next();
                this.t = next.getValue();
                return com.google.common.collect.AbstractMapBasedMultimap.AsMap.this.g(next);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.n.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                com.google.common.collect.CollectPreconditions.e(this.t != null);
                this.n.remove();
                com.google.common.collect.AbstractMapBasedMultimap.this.totalSize -= this.t.size();
                this.t.clear();
                this.t = null;
            }
        }

        public AsMap(java.util.Map<K, java.util.Collection<V>> map) {
            this.v = map;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public java.util.Set<java.util.Map.Entry<K, java.util.Collection<V>>> a() {
            return new com.google.common.collect.AbstractMapBasedMultimap.AsMap.AsMapEntries();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            if (this.v == com.google.common.collect.AbstractMapBasedMultimap.this.map) {
                com.google.common.collect.AbstractMapBasedMultimap.this.clear();
            } else {
                com.google.common.collect.Iterators.c(new com.google.common.collect.AbstractMapBasedMultimap.AsMap.AsMapIterator());
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(java.lang.Object obj) {
            return com.google.common.collect.Maps.F(this.v, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public java.util.Collection<V> get(java.lang.Object obj) {
            java.util.Collection<V> collection = (java.util.Collection) com.google.common.collect.Maps.G(this.v, obj);
            if (collection == null) {
                return null;
            }
            return com.google.common.collect.AbstractMapBasedMultimap.this.wrapCollection(obj, collection);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return this == obj || this.v.equals(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public java.util.Collection<V> remove(java.lang.Object obj) {
            java.util.Collection<V> remove = this.v.remove(obj);
            if (remove == null) {
                return null;
            }
            java.util.Collection<V> createCollection = com.google.common.collect.AbstractMapBasedMultimap.this.createCollection();
            createCollection.addAll(remove);
            com.google.common.collect.AbstractMapBasedMultimap.this.totalSize -= remove.size();
            remove.clear();
            return createCollection;
        }

        public java.util.Map.Entry<K, java.util.Collection<V>> g(java.util.Map.Entry<K, java.util.Collection<V>> entry) {
            K key = entry.getKey();
            return com.google.common.collect.Maps.immutableEntry(key, com.google.common.collect.AbstractMapBasedMultimap.this.wrapCollection(key, entry.getValue()));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.v.hashCode();
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        /* renamed from: keySet */
        public java.util.Set<K> i() {
            return com.google.common.collect.AbstractMapBasedMultimap.this.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.v.size();
        }

        @Override // java.util.AbstractMap
        public java.lang.String toString() {
            return this.v.toString();
        }
    }

    public abstract class Itr<T> implements java.util.Iterator<T> {
        public final java.util.Iterator<java.util.Map.Entry<K, java.util.Collection<V>>> n;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public K t = null;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        public java.util.Collection<V> u = null;
        public java.util.Iterator<V> v = com.google.common.collect.Iterators.h();

        public Itr() {
            this.n = com.google.common.collect.AbstractMapBasedMultimap.this.map.entrySet().iterator();
        }

        public abstract T a(K k, V v);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.n.hasNext() || this.v.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.v.hasNext()) {
                java.util.Map.Entry<K, java.util.Collection<V>> next = this.n.next();
                this.t = next.getKey();
                java.util.Collection<V> value = next.getValue();
                this.u = value;
                this.v = value.iterator();
            }
            return a(this.t, this.v.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            this.v.remove();
            if (this.u.isEmpty()) {
                this.n.remove();
            }
            com.google.common.collect.AbstractMapBasedMultimap.access$210(com.google.common.collect.AbstractMapBasedMultimap.this);
        }
    }

    public class KeySet extends com.google.common.collect.Maps.KeySet<K, java.util.Collection<V>> {

        /* renamed from: com.google.common.collect.AbstractMapBasedMultimap$KeySet$1, reason: invalid class name */
        public class AnonymousClass1 implements java.util.Iterator<K> {

            @org.checkerframework.checker.nullness.compatqual.NullableDecl
            public java.util.Map.Entry<K, java.util.Collection<V>> n;
            public final /* synthetic */ java.util.Iterator t;

            public AnonymousClass1(java.util.Iterator it) {
                this.t = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.t.hasNext();
            }

            @Override // java.util.Iterator
            public K next() {
                java.util.Map.Entry<K, java.util.Collection<V>> entry = (java.util.Map.Entry) this.t.next();
                this.n = entry;
                return entry.getKey();
            }

            @Override // java.util.Iterator
            public void remove() {
                com.google.common.collect.CollectPreconditions.e(this.n != null);
                java.util.Collection<V> value = this.n.getValue();
                this.t.remove();
                com.google.common.collect.AbstractMapBasedMultimap.this.totalSize -= value.size();
                value.clear();
                this.n = null;
            }
        }

        public KeySet(java.util.Map<K, java.util.Collection<V>> map) {
            super(map);
        }

        @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            com.google.common.collect.Iterators.c(iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(java.util.Collection<?> collection) {
            return b().keySet().containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return this == obj || b().keySet().equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return b().keySet().hashCode();
        }

        @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<K> iterator() {
            return new com.google.common.collect.AbstractMapBasedMultimap.KeySet.AnonymousClass1(b().entrySet().iterator());
        }

        @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(java.lang.Object obj) {
            int i;
            java.util.Collection<V> remove = b().remove(obj);
            if (remove != null) {
                i = remove.size();
                remove.clear();
                com.google.common.collect.AbstractMapBasedMultimap.this.totalSize -= i;
            } else {
                i = 0;
            }
            return i > 0;
        }
    }

    public class NavigableAsMap extends com.google.common.collect.AbstractMapBasedMultimap<K, V>.SortedAsMap implements java.util.NavigableMap<K, java.util.Collection<V>> {
        public NavigableAsMap(java.util.NavigableMap<K, java.util.Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableMap
        public java.util.Map.Entry<K, java.util.Collection<V>> ceilingEntry(K k) {
            java.util.Map.Entry<K, java.util.Collection<V>> ceilingEntry = j().ceilingEntry(k);
            if (ceilingEntry == null) {
                return null;
            }
            return g(ceilingEntry);
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k) {
            return j().ceilingKey(k);
        }

        @Override // java.util.NavigableMap
        public java.util.NavigableSet<K> descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public java.util.NavigableMap<K, java.util.Collection<V>> descendingMap() {
            return new com.google.common.collect.AbstractMapBasedMultimap.NavigableAsMap(j().descendingMap());
        }

        @Override // java.util.NavigableMap
        public java.util.Map.Entry<K, java.util.Collection<V>> firstEntry() {
            java.util.Map.Entry<K, java.util.Collection<V>> firstEntry = j().firstEntry();
            if (firstEntry == null) {
                return null;
            }
            return g(firstEntry);
        }

        @Override // java.util.NavigableMap
        public java.util.Map.Entry<K, java.util.Collection<V>> floorEntry(K k) {
            java.util.Map.Entry<K, java.util.Collection<V>> floorEntry = j().floorEntry(k);
            if (floorEntry == null) {
                return null;
            }
            return g(floorEntry);
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k) {
            return j().floorKey(k);
        }

        @Override // java.util.NavigableMap
        public java.util.NavigableMap<K, java.util.Collection<V>> headMap(K k, boolean z) {
            return new com.google.common.collect.AbstractMapBasedMultimap.NavigableAsMap(j().headMap(k, z));
        }

        @Override // java.util.NavigableMap
        public java.util.Map.Entry<K, java.util.Collection<V>> higherEntry(K k) {
            java.util.Map.Entry<K, java.util.Collection<V>> higherEntry = j().higherEntry(k);
            if (higherEntry == null) {
                return null;
            }
            return g(higherEntry);
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k) {
            return j().higherKey(k);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap
        /* renamed from: k, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public java.util.NavigableSet<K> h() {
            return new com.google.common.collect.AbstractMapBasedMultimap.NavigableKeySet(j());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, com.google.common.collect.AbstractMapBasedMultimap.AsMap, com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        /* renamed from: keySet, reason: merged with bridge method [inline-methods] */
        public java.util.NavigableSet<K> i() {
            return (java.util.NavigableSet) super.i();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public java.util.NavigableMap<K, java.util.Collection<V>> headMap(K k) {
            return headMap(k, false);
        }

        @Override // java.util.NavigableMap
        public java.util.Map.Entry<K, java.util.Collection<V>> lastEntry() {
            java.util.Map.Entry<K, java.util.Collection<V>> lastEntry = j().lastEntry();
            if (lastEntry == null) {
                return null;
            }
            return g(lastEntry);
        }

        @Override // java.util.NavigableMap
        public java.util.Map.Entry<K, java.util.Collection<V>> lowerEntry(K k) {
            java.util.Map.Entry<K, java.util.Collection<V>> lowerEntry = j().lowerEntry(k);
            if (lowerEntry == null) {
                return null;
            }
            return g(lowerEntry);
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k) {
            return j().lowerKey(k);
        }

        public java.util.Map.Entry<K, java.util.Collection<V>> m(java.util.Iterator<java.util.Map.Entry<K, java.util.Collection<V>>> it) {
            if (!it.hasNext()) {
                return null;
            }
            java.util.Map.Entry<K, java.util.Collection<V>> next = it.next();
            java.util.Collection<V> createCollection = com.google.common.collect.AbstractMapBasedMultimap.this.createCollection();
            createCollection.addAll(next.getValue());
            it.remove();
            return com.google.common.collect.Maps.immutableEntry(next.getKey(), com.google.common.collect.AbstractMapBasedMultimap.this.unmodifiableCollectionSubclass(createCollection));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public java.util.NavigableMap<K, java.util.Collection<V>> j() {
            return (java.util.NavigableMap) super.j();
        }

        @Override // java.util.NavigableMap
        public java.util.NavigableSet<K> navigableKeySet() {
            return i();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public java.util.NavigableMap<K, java.util.Collection<V>> subMap(K k, K k2) {
            return subMap(k, true, k2, false);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public java.util.NavigableMap<K, java.util.Collection<V>> tailMap(K k) {
            return tailMap(k, true);
        }

        @Override // java.util.NavigableMap
        public java.util.Map.Entry<K, java.util.Collection<V>> pollFirstEntry() {
            return m(entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public java.util.Map.Entry<K, java.util.Collection<V>> pollLastEntry() {
            return m(descendingMap().entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public java.util.NavigableMap<K, java.util.Collection<V>> subMap(K k, boolean z, K k2, boolean z2) {
            return new com.google.common.collect.AbstractMapBasedMultimap.NavigableAsMap(j().subMap(k, z, k2, z2));
        }

        @Override // java.util.NavigableMap
        public java.util.NavigableMap<K, java.util.Collection<V>> tailMap(K k, boolean z) {
            return new com.google.common.collect.AbstractMapBasedMultimap.NavigableAsMap(j().tailMap(k, z));
        }
    }

    public class NavigableKeySet extends com.google.common.collect.AbstractMapBasedMultimap<K, V>.SortedKeySet implements java.util.NavigableSet<K> {
        public NavigableKeySet(java.util.NavigableMap<K, java.util.Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public java.util.NavigableSet<K> headSet(K k) {
            return headSet(k, false);
        }

        @Override // java.util.NavigableSet
        public K ceiling(K k) {
            return b().ceilingKey(k);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public java.util.NavigableMap<K, java.util.Collection<V>> b() {
            return (java.util.NavigableMap) super.b();
        }

        @Override // java.util.NavigableSet
        public java.util.Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public java.util.NavigableSet<K> descendingSet() {
            return new com.google.common.collect.AbstractMapBasedMultimap.NavigableKeySet(b().descendingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public java.util.NavigableSet<K> subSet(K k, K k2) {
            return subSet(k, true, k2, false);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public java.util.NavigableSet<K> tailSet(K k) {
            return tailSet(k, true);
        }

        @Override // java.util.NavigableSet
        public K floor(K k) {
            return b().floorKey(k);
        }

        @Override // java.util.NavigableSet
        public java.util.NavigableSet<K> headSet(K k, boolean z) {
            return new com.google.common.collect.AbstractMapBasedMultimap.NavigableKeySet(b().headMap(k, z));
        }

        @Override // java.util.NavigableSet
        public K higher(K k) {
            return b().higherKey(k);
        }

        @Override // java.util.NavigableSet
        public K lower(K k) {
            return b().lowerKey(k);
        }

        @Override // java.util.NavigableSet
        public K pollFirst() {
            return (K) com.google.common.collect.Iterators.k(iterator());
        }

        @Override // java.util.NavigableSet
        public K pollLast() {
            return (K) com.google.common.collect.Iterators.k(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public java.util.NavigableSet<K> subSet(K k, boolean z, K k2, boolean z2) {
            return new com.google.common.collect.AbstractMapBasedMultimap.NavigableKeySet(b().subMap(k, z, k2, z2));
        }

        @Override // java.util.NavigableSet
        public java.util.NavigableSet<K> tailSet(K k, boolean z) {
            return new com.google.common.collect.AbstractMapBasedMultimap.NavigableKeySet(b().tailMap(k, z));
        }
    }

    public class RandomAccessWrappedList extends com.google.common.collect.AbstractMapBasedMultimap<K, V>.WrappedList implements java.util.RandomAccess {
        public RandomAccessWrappedList(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k, java.util.List<V> list, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.collect.AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection) {
            super(k, list, wrappedCollection);
        }
    }

    public class SortedAsMap extends com.google.common.collect.AbstractMapBasedMultimap<K, V>.AsMap implements java.util.SortedMap<K, java.util.Collection<V>> {

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        public java.util.SortedSet<K> x;

        public SortedAsMap(java.util.SortedMap<K, java.util.Collection<V>> sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedMap
        public java.util.Comparator<? super K> comparator() {
            return j().comparator();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return j().firstKey();
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public java.util.SortedSet<K> h() {
            return new com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet(j());
        }

        public java.util.SortedMap<K, java.util.Collection<V>> headMap(K k) {
            return new com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap(j().headMap(k));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.AsMap, com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public java.util.SortedSet<K> i() {
            java.util.SortedSet<K> sortedSet = this.x;
            if (sortedSet != null) {
                return sortedSet;
            }
            java.util.SortedSet<K> h = h();
            this.x = h;
            return h;
        }

        public java.util.SortedMap<K, java.util.Collection<V>> j() {
            return (java.util.SortedMap) this.v;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return j().lastKey();
        }

        public java.util.SortedMap<K, java.util.Collection<V>> subMap(K k, K k2) {
            return new com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap(j().subMap(k, k2));
        }

        public java.util.SortedMap<K, java.util.Collection<V>> tailMap(K k) {
            return new com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap(j().tailMap(k));
        }
    }

    public class SortedKeySet extends com.google.common.collect.AbstractMapBasedMultimap<K, V>.KeySet implements java.util.SortedSet<K> {
        public SortedKeySet(java.util.SortedMap<K, java.util.Collection<V>> sortedMap) {
            super(sortedMap);
        }

        public java.util.SortedMap<K, java.util.Collection<V>> b() {
            return (java.util.SortedMap) super.b();
        }

        @Override // java.util.SortedSet
        public java.util.Comparator<? super K> comparator() {
            return b().comparator();
        }

        @Override // java.util.SortedSet
        public K first() {
            return b().firstKey();
        }

        public java.util.SortedSet<K> headSet(K k) {
            return new com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet(b().headMap(k));
        }

        @Override // java.util.SortedSet
        public K last() {
            return b().lastKey();
        }

        public java.util.SortedSet<K> subSet(K k, K k2) {
            return new com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet(b().subMap(k, k2));
        }

        public java.util.SortedSet<K> tailSet(K k) {
            return new com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet(b().tailMap(k));
        }
    }

    public class WrappedCollection extends java.util.AbstractCollection<V> {

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public final K n;
        public java.util.Collection<V> t;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public final com.google.common.collect.AbstractMapBasedMultimap<K, V>.WrappedCollection u;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public final java.util.Collection<V> v;

        public class WrappedIterator implements java.util.Iterator<V> {
            public final java.util.Iterator<V> n;
            public final java.util.Collection<V> t;

            public WrappedIterator() {
                java.util.Collection<V> collection = com.google.common.collect.AbstractMapBasedMultimap.WrappedCollection.this.t;
                this.t = collection;
                this.n = com.google.common.collect.AbstractMapBasedMultimap.iteratorOrListIterator(collection);
            }

            public WrappedIterator(java.util.Iterator<V> it) {
                this.t = com.google.common.collect.AbstractMapBasedMultimap.WrappedCollection.this.t;
                this.n = it;
            }

            public java.util.Iterator<V> a() {
                b();
                return this.n;
            }

            public void b() {
                com.google.common.collect.AbstractMapBasedMultimap.WrappedCollection.this.e();
                if (com.google.common.collect.AbstractMapBasedMultimap.WrappedCollection.this.t != this.t) {
                    throw new java.util.ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                b();
                return this.n.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                b();
                return this.n.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.n.remove();
                com.google.common.collect.AbstractMapBasedMultimap.access$210(com.google.common.collect.AbstractMapBasedMultimap.this);
                com.google.common.collect.AbstractMapBasedMultimap.WrappedCollection.this.f();
            }
        }

        public WrappedCollection(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k, java.util.Collection<V> collection, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.collect.AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection) {
            this.n = k;
            this.t = collection;
            this.u = wrappedCollection;
            this.v = wrappedCollection == null ? null : wrappedCollection.c();
        }

        public void a() {
            com.google.common.collect.AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection = this.u;
            if (wrappedCollection != null) {
                wrappedCollection.a();
            } else {
                com.google.common.collect.AbstractMapBasedMultimap.this.map.put(this.n, this.t);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(V v) {
            e();
            boolean isEmpty = this.t.isEmpty();
            boolean add = this.t.add(v);
            if (add) {
                com.google.common.collect.AbstractMapBasedMultimap.access$208(com.google.common.collect.AbstractMapBasedMultimap.this);
                if (isEmpty) {
                    a();
                }
            }
            return add;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(java.util.Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = this.t.addAll(collection);
            if (addAll) {
                int size2 = this.t.size();
                com.google.common.collect.AbstractMapBasedMultimap.this.totalSize += size2 - size;
                if (size == 0) {
                    a();
                }
            }
            return addAll;
        }

        public com.google.common.collect.AbstractMapBasedMultimap<K, V>.WrappedCollection b() {
            return this.u;
        }

        public java.util.Collection<V> c() {
            return this.t;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            int size = size();
            if (size == 0) {
                return;
            }
            this.t.clear();
            com.google.common.collect.AbstractMapBasedMultimap.this.totalSize -= size;
            f();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(java.lang.Object obj) {
            e();
            return this.t.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(java.util.Collection<?> collection) {
            e();
            return this.t.containsAll(collection);
        }

        K d() {
            return this.n;
        }

        public void e() {
            java.util.Collection<V> collection;
            com.google.common.collect.AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection = this.u;
            if (wrappedCollection != null) {
                wrappedCollection.e();
                if (this.u.c() != this.v) {
                    throw new java.util.ConcurrentModificationException();
                }
            } else {
                if (!this.t.isEmpty() || (collection = (java.util.Collection) com.google.common.collect.AbstractMapBasedMultimap.this.map.get(this.n)) == null) {
                    return;
                }
                this.t = collection;
            }
        }

        @Override // java.util.Collection
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            e();
            return this.t.equals(obj);
        }

        public void f() {
            com.google.common.collect.AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection = this.u;
            if (wrappedCollection != null) {
                wrappedCollection.f();
            } else if (this.t.isEmpty()) {
                com.google.common.collect.AbstractMapBasedMultimap.this.map.remove(this.n);
            }
        }

        @Override // java.util.Collection
        public int hashCode() {
            e();
            return this.t.hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public java.util.Iterator<V> iterator() {
            e();
            return new com.google.common.collect.AbstractMapBasedMultimap.WrappedCollection.WrappedIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(java.lang.Object obj) {
            e();
            boolean remove = this.t.remove(obj);
            if (remove) {
                com.google.common.collect.AbstractMapBasedMultimap.access$210(com.google.common.collect.AbstractMapBasedMultimap.this);
                f();
            }
            return remove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(java.util.Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean removeAll = this.t.removeAll(collection);
            if (removeAll) {
                int size2 = this.t.size();
                com.google.common.collect.AbstractMapBasedMultimap.this.totalSize += size2 - size;
                f();
            }
            return removeAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(java.util.Collection<?> collection) {
            com.google.common.base.Preconditions.checkNotNull(collection);
            int size = size();
            boolean retainAll = this.t.retainAll(collection);
            if (retainAll) {
                int size2 = this.t.size();
                com.google.common.collect.AbstractMapBasedMultimap.this.totalSize += size2 - size;
                f();
            }
            return retainAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            e();
            return this.t.size();
        }

        @Override // java.util.AbstractCollection
        public java.lang.String toString() {
            e();
            return this.t.toString();
        }
    }

    public class WrappedList extends com.google.common.collect.AbstractMapBasedMultimap<K, V>.WrappedCollection implements java.util.List<V> {

        public class WrappedListIterator extends com.google.common.collect.AbstractMapBasedMultimap<K, V>.WrappedCollection.WrappedIterator implements java.util.ListIterator<V> {
            public WrappedListIterator() {
                super();
            }

            public WrappedListIterator(int i) {
                super(com.google.common.collect.AbstractMapBasedMultimap.WrappedList.this.g().listIterator(i));
            }

            @Override // java.util.ListIterator
            public void add(V v) {
                boolean isEmpty = com.google.common.collect.AbstractMapBasedMultimap.WrappedList.this.isEmpty();
                c().add(v);
                com.google.common.collect.AbstractMapBasedMultimap.access$208(com.google.common.collect.AbstractMapBasedMultimap.this);
                if (isEmpty) {
                    com.google.common.collect.AbstractMapBasedMultimap.WrappedList.this.a();
                }
            }

            public final java.util.ListIterator<V> c() {
                return (java.util.ListIterator) a();
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return c().hasPrevious();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return c().nextIndex();
            }

            @Override // java.util.ListIterator
            public V previous() {
                return c().previous();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return c().previousIndex();
            }

            @Override // java.util.ListIterator
            public void set(V v) {
                c().set(v);
            }
        }

        public WrappedList(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k, java.util.List<V> list, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.collect.AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection) {
            super(k, list, wrappedCollection);
        }

        @Override // java.util.List
        public void add(int i, V v) {
            e();
            boolean isEmpty = c().isEmpty();
            g().add(i, v);
            com.google.common.collect.AbstractMapBasedMultimap.access$208(com.google.common.collect.AbstractMapBasedMultimap.this);
            if (isEmpty) {
                a();
            }
        }

        @Override // java.util.List
        public boolean addAll(int i, java.util.Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = g().addAll(i, collection);
            if (addAll) {
                int size2 = c().size();
                com.google.common.collect.AbstractMapBasedMultimap.this.totalSize += size2 - size;
                if (size == 0) {
                    a();
                }
            }
            return addAll;
        }

        public java.util.List<V> g() {
            return (java.util.List) c();
        }

        @Override // java.util.List
        public V get(int i) {
            e();
            return g().get(i);
        }

        @Override // java.util.List
        public int indexOf(java.lang.Object obj) {
            e();
            return g().indexOf(obj);
        }

        @Override // java.util.List
        public int lastIndexOf(java.lang.Object obj) {
            e();
            return g().lastIndexOf(obj);
        }

        @Override // java.util.List
        public java.util.ListIterator<V> listIterator() {
            e();
            return new com.google.common.collect.AbstractMapBasedMultimap.WrappedList.WrappedListIterator();
        }

        @Override // java.util.List
        public java.util.ListIterator<V> listIterator(int i) {
            e();
            return new com.google.common.collect.AbstractMapBasedMultimap.WrappedList.WrappedListIterator(i);
        }

        @Override // java.util.List
        public V remove(int i) {
            e();
            V remove = g().remove(i);
            com.google.common.collect.AbstractMapBasedMultimap.access$210(com.google.common.collect.AbstractMapBasedMultimap.this);
            f();
            return remove;
        }

        @Override // java.util.List
        public V set(int i, V v) {
            e();
            return g().set(i, v);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        public java.util.List<V> subList(int i, int i2) {
            e();
            return com.google.common.collect.AbstractMapBasedMultimap.this.wrapList(d(), g().subList(i, i2), b() == null ? this : b());
        }
    }

    public class WrappedNavigableSet extends com.google.common.collect.AbstractMapBasedMultimap<K, V>.WrappedSortedSet implements java.util.NavigableSet<V> {
        public WrappedNavigableSet(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k, java.util.NavigableSet<V> navigableSet, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.collect.AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection) {
            super(k, navigableSet, wrappedCollection);
        }

        @Override // java.util.NavigableSet
        public V ceiling(V v) {
            return g().ceiling(v);
        }

        @Override // java.util.NavigableSet
        public java.util.Iterator<V> descendingIterator() {
            return new com.google.common.collect.AbstractMapBasedMultimap.WrappedCollection.WrappedIterator(g().descendingIterator());
        }

        @Override // java.util.NavigableSet
        public java.util.NavigableSet<V> descendingSet() {
            return i(g().descendingSet());
        }

        @Override // java.util.NavigableSet
        public V floor(V v) {
            return g().floor(v);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.WrappedSortedSet
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public java.util.NavigableSet<V> g() {
            return (java.util.NavigableSet) super.g();
        }

        @Override // java.util.NavigableSet
        public java.util.NavigableSet<V> headSet(V v, boolean z) {
            return i(g().headSet(v, z));
        }

        @Override // java.util.NavigableSet
        public V higher(V v) {
            return g().higher(v);
        }

        public final java.util.NavigableSet<V> i(java.util.NavigableSet<V> navigableSet) {
            return new com.google.common.collect.AbstractMapBasedMultimap.WrappedNavigableSet(this.n, navigableSet, b() == null ? this : b());
        }

        @Override // java.util.NavigableSet
        public V lower(V v) {
            return g().lower(v);
        }

        @Override // java.util.NavigableSet
        public V pollFirst() {
            return (V) com.google.common.collect.Iterators.k(iterator());
        }

        @Override // java.util.NavigableSet
        public V pollLast() {
            return (V) com.google.common.collect.Iterators.k(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public java.util.NavigableSet<V> subSet(V v, boolean z, V v2, boolean z2) {
            return i(g().subSet(v, z, v2, z2));
        }

        @Override // java.util.NavigableSet
        public java.util.NavigableSet<V> tailSet(V v, boolean z) {
            return i(g().tailSet(v, z));
        }
    }

    public class WrappedSet extends com.google.common.collect.AbstractMapBasedMultimap<K, V>.WrappedCollection implements java.util.Set<V> {
        public WrappedSet(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k, java.util.Set<V> set) {
            super(k, set, null);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.WrappedCollection, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(java.util.Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean d = com.google.common.collect.Sets.d((java.util.Set) this.t, collection);
            if (d) {
                int size2 = this.t.size();
                com.google.common.collect.AbstractMapBasedMultimap.this.totalSize += size2 - size;
                f();
            }
            return d;
        }
    }

    public class WrappedSortedSet extends com.google.common.collect.AbstractMapBasedMultimap<K, V>.WrappedCollection implements java.util.SortedSet<V> {
        public WrappedSortedSet(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k, java.util.SortedSet<V> sortedSet, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.collect.AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection) {
            super(k, sortedSet, wrappedCollection);
        }

        @Override // java.util.SortedSet
        public java.util.Comparator<? super V> comparator() {
            return g().comparator();
        }

        @Override // java.util.SortedSet
        public V first() {
            e();
            return g().first();
        }

        public java.util.SortedSet<V> g() {
            return (java.util.SortedSet) c();
        }

        @Override // java.util.SortedSet
        public java.util.SortedSet<V> headSet(V v) {
            e();
            return new com.google.common.collect.AbstractMapBasedMultimap.WrappedSortedSet(d(), g().headSet(v), b() == null ? this : b());
        }

        @Override // java.util.SortedSet
        public V last() {
            e();
            return g().last();
        }

        @Override // java.util.SortedSet
        public java.util.SortedSet<V> subSet(V v, V v2) {
            e();
            return new com.google.common.collect.AbstractMapBasedMultimap.WrappedSortedSet(d(), g().subSet(v, v2), b() == null ? this : b());
        }

        @Override // java.util.SortedSet
        public java.util.SortedSet<V> tailSet(V v) {
            e();
            return new com.google.common.collect.AbstractMapBasedMultimap.WrappedSortedSet(d(), g().tailSet(v), b() == null ? this : b());
        }
    }

    public AbstractMapBasedMultimap(java.util.Map<K, java.util.Collection<V>> map) {
        com.google.common.base.Preconditions.checkArgument(map.isEmpty());
        this.map = map;
    }

    public static /* synthetic */ int access$208(com.google.common.collect.AbstractMapBasedMultimap abstractMapBasedMultimap) {
        int i = abstractMapBasedMultimap.totalSize;
        abstractMapBasedMultimap.totalSize = i + 1;
        return i;
    }

    public static /* synthetic */ int access$210(com.google.common.collect.AbstractMapBasedMultimap abstractMapBasedMultimap) {
        int i = abstractMapBasedMultimap.totalSize;
        abstractMapBasedMultimap.totalSize = i - 1;
        return i;
    }

    private java.util.Collection<V> getOrCreateCollection(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k) {
        java.util.Collection<V> collection = this.map.get(k);
        if (collection != null) {
            return collection;
        }
        java.util.Collection<V> createCollection = createCollection(k);
        this.map.put(k, createCollection);
        return createCollection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> java.util.Iterator<E> iteratorOrListIterator(java.util.Collection<E> collection) {
        return collection instanceof java.util.List ? ((java.util.List) collection).listIterator() : collection.iterator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeValuesForKey(java.lang.Object obj) {
        java.util.Collection collection = (java.util.Collection) com.google.common.collect.Maps.H(this.map, obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.totalSize -= size;
        }
    }

    public java.util.Map<K, java.util.Collection<V>> backingMap() {
        return this.map;
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        java.util.Iterator<java.util.Collection<V>> it = this.map.values().iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.map.clear();
        this.totalSize = 0;
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public java.util.Map<K, java.util.Collection<V>> createAsMap() {
        return new com.google.common.collect.AbstractMapBasedMultimap.AsMap(this.map);
    }

    public abstract java.util.Collection<V> createCollection();

    public java.util.Collection<V> createCollection(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k) {
        return createCollection();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public java.util.Collection<java.util.Map.Entry<K, V>> createEntries() {
        return this instanceof com.google.common.collect.SetMultimap ? new com.google.common.collect.AbstractMultimap.EntrySet() : new com.google.common.collect.AbstractMultimap.Entries();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public java.util.Set<K> createKeySet() {
        return new com.google.common.collect.AbstractMapBasedMultimap.KeySet(this.map);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public com.google.common.collect.Multiset<K> createKeys() {
        return new com.google.common.collect.Multimaps.Keys(this);
    }

    public final java.util.Map<K, java.util.Collection<V>> createMaybeNavigableAsMap() {
        java.util.Map<K, java.util.Collection<V>> map = this.map;
        return map instanceof java.util.NavigableMap ? new com.google.common.collect.AbstractMapBasedMultimap.NavigableAsMap((java.util.NavigableMap) this.map) : map instanceof java.util.SortedMap ? new com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap((java.util.SortedMap) this.map) : new com.google.common.collect.AbstractMapBasedMultimap.AsMap(this.map);
    }

    public final java.util.Set<K> createMaybeNavigableKeySet() {
        java.util.Map<K, java.util.Collection<V>> map = this.map;
        return map instanceof java.util.NavigableMap ? new com.google.common.collect.AbstractMapBasedMultimap.NavigableKeySet((java.util.NavigableMap) this.map) : map instanceof java.util.SortedMap ? new com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet((java.util.SortedMap) this.map) : new com.google.common.collect.AbstractMapBasedMultimap.KeySet(this.map);
    }

    public java.util.Collection<V> createUnmodifiableEmptyCollection() {
        return (java.util.Collection<V>) unmodifiableCollectionSubclass(createCollection());
    }

    @Override // com.google.common.collect.AbstractMultimap
    public java.util.Collection<V> createValues() {
        return new com.google.common.collect.AbstractMultimap.Values();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public java.util.Collection<java.util.Map.Entry<K, V>> entries() {
        return super.entries();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public java.util.Iterator<java.util.Map.Entry<K, V>> entryIterator() {
        return new com.google.common.collect.AbstractMapBasedMultimap.AnonymousClass2();
    }

    @Override // com.google.common.collect.Multimap
    public java.util.Collection<V> get(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k) {
        java.util.Collection<V> collection = this.map.get(k);
        if (collection == null) {
            collection = createCollection(k);
        }
        return wrapCollection(k, collection);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public boolean put(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
        java.util.Collection<V> collection = this.map.get(k);
        if (collection != null) {
            if (!collection.add(v)) {
                return false;
            }
            this.totalSize++;
            return true;
        }
        java.util.Collection<V> createCollection = createCollection(k);
        if (!createCollection.add(v)) {
            throw new java.lang.AssertionError("New Collection violated the Collection spec");
        }
        this.totalSize++;
        this.map.put(k, createCollection);
        return true;
    }

    @Override // com.google.common.collect.Multimap
    public java.util.Collection<V> removeAll(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        java.util.Collection<V> remove = this.map.remove(obj);
        if (remove == null) {
            return createUnmodifiableEmptyCollection();
        }
        java.util.Collection createCollection = createCollection();
        createCollection.addAll(remove);
        this.totalSize -= remove.size();
        remove.clear();
        return (java.util.Collection<V>) unmodifiableCollectionSubclass(createCollection);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public java.util.Collection<V> replaceValues(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k, java.lang.Iterable<? extends V> iterable) {
        java.util.Iterator<? extends V> it = iterable.iterator();
        if (!it.hasNext()) {
            return removeAll(k);
        }
        java.util.Collection<V> orCreateCollection = getOrCreateCollection(k);
        java.util.Collection<V> createCollection = createCollection();
        createCollection.addAll(orCreateCollection);
        this.totalSize -= orCreateCollection.size();
        orCreateCollection.clear();
        while (it.hasNext()) {
            if (orCreateCollection.add(it.next())) {
                this.totalSize++;
            }
        }
        return (java.util.Collection<V>) unmodifiableCollectionSubclass(createCollection);
    }

    public final void setMap(java.util.Map<K, java.util.Collection<V>> map) {
        this.map = map;
        this.totalSize = 0;
        for (java.util.Collection<V> collection : map.values()) {
            com.google.common.base.Preconditions.checkArgument(!collection.isEmpty());
            this.totalSize += collection.size();
        }
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return this.totalSize;
    }

    public <E> java.util.Collection<E> unmodifiableCollectionSubclass(java.util.Collection<E> collection) {
        return java.util.Collections.unmodifiableCollection(collection);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public java.util.Iterator<V> valueIterator() {
        return new com.google.common.collect.AbstractMapBasedMultimap.AnonymousClass1();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public java.util.Collection<V> values() {
        return super.values();
    }

    public java.util.Collection<V> wrapCollection(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k, java.util.Collection<V> collection) {
        return new com.google.common.collect.AbstractMapBasedMultimap.WrappedCollection(k, collection, null);
    }

    public final java.util.List<V> wrapList(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k, java.util.List<V> list, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.collect.AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection) {
        return list instanceof java.util.RandomAccess ? new com.google.common.collect.AbstractMapBasedMultimap.RandomAccessWrappedList(k, list, wrappedCollection) : new com.google.common.collect.AbstractMapBasedMultimap.WrappedList(k, list, wrappedCollection);
    }
}
