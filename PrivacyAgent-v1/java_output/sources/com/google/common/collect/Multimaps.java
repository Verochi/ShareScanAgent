package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public final class Multimaps {

    public static final class AsMap<K, V> extends com.google.common.collect.Maps.ViewCachingAbstractMap<K, java.util.Collection<V>> {

        @com.google.j2objc.annotations.Weak
        public final com.google.common.collect.Multimap<K, V> v;

        public class EntrySet extends com.google.common.collect.Maps.EntrySet<K, java.util.Collection<V>> {

            /* renamed from: com.google.common.collect.Multimaps$AsMap$EntrySet$1, reason: invalid class name */
            public class AnonymousClass1 implements com.google.common.base.Function<K, java.util.Collection<V>> {
                public AnonymousClass1() {
                }

                @Override // com.google.common.base.Function
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public java.util.Collection<V> apply(K k) {
                    return com.google.common.collect.Multimaps.AsMap.this.v.get(k);
                }
            }

            public EntrySet() {
            }

            @Override // com.google.common.collect.Maps.EntrySet
            public java.util.Map<K, java.util.Collection<V>> a() {
                return com.google.common.collect.Multimaps.AsMap.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public java.util.Iterator<java.util.Map.Entry<K, java.util.Collection<V>>> iterator() {
                return com.google.common.collect.Maps.i(com.google.common.collect.Multimaps.AsMap.this.v.keySet(), new com.google.common.collect.Multimaps.AsMap.EntrySet.AnonymousClass1());
            }

            @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(java.lang.Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                com.google.common.collect.Multimaps.AsMap.this.h(((java.util.Map.Entry) obj).getKey());
                return true;
            }
        }

        public AsMap(com.google.common.collect.Multimap<K, V> multimap) {
            this.v = (com.google.common.collect.Multimap) com.google.common.base.Preconditions.checkNotNull(multimap);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public java.util.Set<java.util.Map.Entry<K, java.util.Collection<V>>> a() {
            return new com.google.common.collect.Multimaps.AsMap.EntrySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.v.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(java.lang.Object obj) {
            return this.v.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public java.util.Collection<V> get(java.lang.Object obj) {
            if (containsKey(obj)) {
                return this.v.get(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public java.util.Collection<V> remove(java.lang.Object obj) {
            if (containsKey(obj)) {
                return this.v.removeAll(obj);
            }
            return null;
        }

        public void h(java.lang.Object obj) {
            this.v.keySet().remove(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.v.isEmpty();
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        /* renamed from: keySet */
        public java.util.Set<K> i() {
            return this.v.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.v.keySet().size();
        }
    }

    public static class CustomListMultimap<K, V> extends com.google.common.collect.AbstractListMultimap<K, V> {

        @com.google.common.annotations.GwtIncompatible
        private static final long serialVersionUID = 0;
        transient com.google.common.base.Supplier<? extends java.util.List<V>> factory;

        public CustomListMultimap(java.util.Map<K, java.util.Collection<V>> map, com.google.common.base.Supplier<? extends java.util.List<V>> supplier) {
            super(map);
            this.factory = (com.google.common.base.Supplier) com.google.common.base.Preconditions.checkNotNull(supplier);
        }

        @com.google.common.annotations.GwtIncompatible
        private void readObject(java.io.ObjectInputStream objectInputStream) throws java.io.IOException, java.lang.ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.factory = (com.google.common.base.Supplier) objectInputStream.readObject();
            setMap((java.util.Map) objectInputStream.readObject());
        }

        @com.google.common.annotations.GwtIncompatible
        private void writeObject(java.io.ObjectOutputStream objectOutputStream) throws java.io.IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(backingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        public java.util.Map<K, java.util.Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractListMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public java.util.List<V> createCollection() {
            return this.factory.get();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        public java.util.Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }
    }

    public static class CustomMultimap<K, V> extends com.google.common.collect.AbstractMapBasedMultimap<K, V> {

        @com.google.common.annotations.GwtIncompatible
        private static final long serialVersionUID = 0;
        transient com.google.common.base.Supplier<? extends java.util.Collection<V>> factory;

        public CustomMultimap(java.util.Map<K, java.util.Collection<V>> map, com.google.common.base.Supplier<? extends java.util.Collection<V>> supplier) {
            super(map);
            this.factory = (com.google.common.base.Supplier) com.google.common.base.Preconditions.checkNotNull(supplier);
        }

        @com.google.common.annotations.GwtIncompatible
        private void readObject(java.io.ObjectInputStream objectInputStream) throws java.io.IOException, java.lang.ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.factory = (com.google.common.base.Supplier) objectInputStream.readObject();
            setMap((java.util.Map) objectInputStream.readObject());
        }

        @com.google.common.annotations.GwtIncompatible
        private void writeObject(java.io.ObjectOutputStream objectOutputStream) throws java.io.IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(backingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        public java.util.Map<K, java.util.Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap
        public java.util.Collection<V> createCollection() {
            return this.factory.get();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        public java.util.Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap
        public <E> java.util.Collection<E> unmodifiableCollectionSubclass(java.util.Collection<E> collection) {
            return collection instanceof java.util.NavigableSet ? com.google.common.collect.Sets.unmodifiableNavigableSet((java.util.NavigableSet) collection) : collection instanceof java.util.SortedSet ? java.util.Collections.unmodifiableSortedSet((java.util.SortedSet) collection) : collection instanceof java.util.Set ? java.util.Collections.unmodifiableSet((java.util.Set) collection) : collection instanceof java.util.List ? java.util.Collections.unmodifiableList((java.util.List) collection) : java.util.Collections.unmodifiableCollection(collection);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap
        public java.util.Collection<V> wrapCollection(K k, java.util.Collection<V> collection) {
            return collection instanceof java.util.List ? wrapList(k, (java.util.List) collection, null) : collection instanceof java.util.NavigableSet ? new com.google.common.collect.AbstractMapBasedMultimap.WrappedNavigableSet(k, (java.util.NavigableSet) collection, null) : collection instanceof java.util.SortedSet ? new com.google.common.collect.AbstractMapBasedMultimap.WrappedSortedSet(k, (java.util.SortedSet) collection, null) : collection instanceof java.util.Set ? new com.google.common.collect.AbstractMapBasedMultimap.WrappedSet(k, (java.util.Set) collection) : new com.google.common.collect.AbstractMapBasedMultimap.WrappedCollection(k, collection, null);
        }
    }

    public static class CustomSetMultimap<K, V> extends com.google.common.collect.AbstractSetMultimap<K, V> {

        @com.google.common.annotations.GwtIncompatible
        private static final long serialVersionUID = 0;
        transient com.google.common.base.Supplier<? extends java.util.Set<V>> factory;

        public CustomSetMultimap(java.util.Map<K, java.util.Collection<V>> map, com.google.common.base.Supplier<? extends java.util.Set<V>> supplier) {
            super(map);
            this.factory = (com.google.common.base.Supplier) com.google.common.base.Preconditions.checkNotNull(supplier);
        }

        @com.google.common.annotations.GwtIncompatible
        private void readObject(java.io.ObjectInputStream objectInputStream) throws java.io.IOException, java.lang.ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.factory = (com.google.common.base.Supplier) objectInputStream.readObject();
            setMap((java.util.Map) objectInputStream.readObject());
        }

        @com.google.common.annotations.GwtIncompatible
        private void writeObject(java.io.ObjectOutputStream objectOutputStream) throws java.io.IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(backingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        public java.util.Map<K, java.util.Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public java.util.Set<V> createCollection() {
            return this.factory.get();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        public java.util.Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public <E> java.util.Collection<E> unmodifiableCollectionSubclass(java.util.Collection<E> collection) {
            return collection instanceof java.util.NavigableSet ? com.google.common.collect.Sets.unmodifiableNavigableSet((java.util.NavigableSet) collection) : collection instanceof java.util.SortedSet ? java.util.Collections.unmodifiableSortedSet((java.util.SortedSet) collection) : java.util.Collections.unmodifiableSet((java.util.Set) collection);
        }

        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public java.util.Collection<V> wrapCollection(K k, java.util.Collection<V> collection) {
            return collection instanceof java.util.NavigableSet ? new com.google.common.collect.AbstractMapBasedMultimap.WrappedNavigableSet(k, (java.util.NavigableSet) collection, null) : collection instanceof java.util.SortedSet ? new com.google.common.collect.AbstractMapBasedMultimap.WrappedSortedSet(k, (java.util.SortedSet) collection, null) : new com.google.common.collect.AbstractMapBasedMultimap.WrappedSet(k, (java.util.Set) collection);
        }
    }

    public static class CustomSortedSetMultimap<K, V> extends com.google.common.collect.AbstractSortedSetMultimap<K, V> {

        @com.google.common.annotations.GwtIncompatible
        private static final long serialVersionUID = 0;
        transient com.google.common.base.Supplier<? extends java.util.SortedSet<V>> factory;
        transient java.util.Comparator<? super V> valueComparator;

        public CustomSortedSetMultimap(java.util.Map<K, java.util.Collection<V>> map, com.google.common.base.Supplier<? extends java.util.SortedSet<V>> supplier) {
            super(map);
            this.factory = (com.google.common.base.Supplier) com.google.common.base.Preconditions.checkNotNull(supplier);
            this.valueComparator = supplier.get().comparator();
        }

        @com.google.common.annotations.GwtIncompatible
        private void readObject(java.io.ObjectInputStream objectInputStream) throws java.io.IOException, java.lang.ClassNotFoundException {
            objectInputStream.defaultReadObject();
            com.google.common.base.Supplier<? extends java.util.SortedSet<V>> supplier = (com.google.common.base.Supplier) objectInputStream.readObject();
            this.factory = supplier;
            this.valueComparator = supplier.get().comparator();
            setMap((java.util.Map) objectInputStream.readObject());
        }

        @com.google.common.annotations.GwtIncompatible
        private void writeObject(java.io.ObjectOutputStream objectOutputStream) throws java.io.IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(backingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        public java.util.Map<K, java.util.Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public java.util.SortedSet<V> createCollection() {
            return this.factory.get();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        public java.util.Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // com.google.common.collect.SortedSetMultimap
        public java.util.Comparator<? super V> valueComparator() {
            return this.valueComparator;
        }
    }

    public static abstract class Entries<K, V> extends java.util.AbstractCollection<java.util.Map.Entry<K, V>> {
        public abstract com.google.common.collect.Multimap<K, V> a();

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (!(obj instanceof java.util.Map.Entry)) {
                return false;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            return a().containsEntry(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (!(obj instanceof java.util.Map.Entry)) {
                return false;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            return a().remove(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return a().size();
        }
    }

    public static class Keys<K, V> extends com.google.common.collect.AbstractMultiset<K> {

        @com.google.j2objc.annotations.Weak
        public final com.google.common.collect.Multimap<K, V> n;

        /* renamed from: com.google.common.collect.Multimaps$Keys$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.collect.TransformedIterator<java.util.Map.Entry<K, java.util.Collection<V>>, com.google.common.collect.Multiset.Entry<K>> {

            /* renamed from: com.google.common.collect.Multimaps$Keys$1$1, reason: invalid class name and collision with other inner class name */
            public class C03421 extends com.google.common.collect.Multisets.AbstractEntry<K> {
                public final /* synthetic */ java.util.Map.Entry n;

                public C03421(java.util.Map.Entry entry) {
                    this.n = entry;
                }

                @Override // com.google.common.collect.Multiset.Entry
                public int getCount() {
                    return ((java.util.Collection) this.n.getValue()).size();
                }

                @Override // com.google.common.collect.Multiset.Entry
                public K getElement() {
                    return (K) this.n.getKey();
                }
            }

            public AnonymousClass1(java.util.Iterator it) {
                super(it);
            }

            @Override // com.google.common.collect.TransformedIterator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public com.google.common.collect.Multiset.Entry<K> a(java.util.Map.Entry<K, java.util.Collection<V>> entry) {
                return new com.google.common.collect.Multimaps.Keys.AnonymousClass1.C03421(entry);
            }
        }

        public Keys(com.google.common.collect.Multimap<K, V> multimap) {
            this.n = multimap;
        }

        @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.n.clear();
        }

        @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return this.n.containsKey(obj);
        }

        @Override // com.google.common.collect.Multiset
        public int count(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            java.util.Collection collection = (java.util.Collection) com.google.common.collect.Maps.G(this.n.asMap(), obj);
            if (collection == null) {
                return 0;
            }
            return collection.size();
        }

        @Override // com.google.common.collect.AbstractMultiset
        public int distinctElements() {
            return this.n.asMap().size();
        }

        @Override // com.google.common.collect.AbstractMultiset
        public java.util.Iterator<K> elementIterator() {
            throw new java.lang.AssertionError("should never be called");
        }

        @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public java.util.Set<K> elementSet() {
            return this.n.keySet();
        }

        @Override // com.google.common.collect.AbstractMultiset
        public java.util.Iterator<com.google.common.collect.Multiset.Entry<K>> entryIterator() {
            return new com.google.common.collect.Multimaps.Keys.AnonymousClass1(this.n.asMap().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
        public java.util.Iterator<K> iterator() {
            return com.google.common.collect.Maps.w(this.n.entries().iterator());
        }

        @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public int remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, int i) {
            com.google.common.collect.CollectPreconditions.b(i, "occurrences");
            if (i == 0) {
                return count(obj);
            }
            java.util.Collection collection = (java.util.Collection) com.google.common.collect.Maps.G(this.n.asMap(), obj);
            if (collection == null) {
                return 0;
            }
            int size = collection.size();
            if (i >= size) {
                collection.clear();
            } else {
                java.util.Iterator it = collection.iterator();
                for (int i2 = 0; i2 < i; i2++) {
                    it.next();
                    it.remove();
                }
            }
            return size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public int size() {
            return this.n.size();
        }
    }

    public static class MapMultimap<K, V> extends com.google.common.collect.AbstractMultimap<K, V> implements com.google.common.collect.SetMultimap<K, V>, java.io.Serializable {
        private static final long serialVersionUID = 7845222491160860175L;
        final java.util.Map<K, V> map;

        /* renamed from: com.google.common.collect.Multimaps$MapMultimap$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.collect.Sets.ImprovedAbstractSet<V> {
            public final /* synthetic */ java.lang.Object n;

            /* renamed from: com.google.common.collect.Multimaps$MapMultimap$1$1, reason: invalid class name and collision with other inner class name */
            public class C03431 implements java.util.Iterator<V> {
                public int n;

                public C03431() {
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    if (this.n == 0) {
                        com.google.common.collect.Multimaps.MapMultimap.AnonymousClass1 anonymousClass1 = com.google.common.collect.Multimaps.MapMultimap.AnonymousClass1.this;
                        if (com.google.common.collect.Multimaps.MapMultimap.this.map.containsKey(anonymousClass1.n)) {
                            return true;
                        }
                    }
                    return false;
                }

                @Override // java.util.Iterator
                public V next() {
                    if (!hasNext()) {
                        throw new java.util.NoSuchElementException();
                    }
                    this.n++;
                    com.google.common.collect.Multimaps.MapMultimap.AnonymousClass1 anonymousClass1 = com.google.common.collect.Multimaps.MapMultimap.AnonymousClass1.this;
                    return com.google.common.collect.Multimaps.MapMultimap.this.map.get(anonymousClass1.n);
                }

                @Override // java.util.Iterator
                public void remove() {
                    com.google.common.collect.CollectPreconditions.e(this.n == 1);
                    this.n = -1;
                    com.google.common.collect.Multimaps.MapMultimap.AnonymousClass1 anonymousClass1 = com.google.common.collect.Multimaps.MapMultimap.AnonymousClass1.this;
                    com.google.common.collect.Multimaps.MapMultimap.this.map.remove(anonymousClass1.n);
                }
            }

            public AnonymousClass1(java.lang.Object obj) {
                this.n = obj;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public java.util.Iterator<V> iterator() {
                return new com.google.common.collect.Multimaps.MapMultimap.AnonymousClass1.C03431();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return com.google.common.collect.Multimaps.MapMultimap.this.map.containsKey(this.n) ? 1 : 0;
            }
        }

        public MapMultimap(java.util.Map<K, V> map) {
            this.map = (java.util.Map) com.google.common.base.Preconditions.checkNotNull(map);
        }

        @Override // com.google.common.collect.Multimap
        public void clear() {
            this.map.clear();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean containsEntry(java.lang.Object obj, java.lang.Object obj2) {
            return this.map.entrySet().contains(com.google.common.collect.Maps.immutableEntry(obj, obj2));
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsKey(java.lang.Object obj) {
            return this.map.containsKey(obj);
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean containsValue(java.lang.Object obj) {
            return this.map.containsValue(obj);
        }

        @Override // com.google.common.collect.AbstractMultimap
        public java.util.Map<K, java.util.Collection<V>> createAsMap() {
            return new com.google.common.collect.Multimaps.AsMap(this);
        }

        @Override // com.google.common.collect.AbstractMultimap
        public java.util.Collection<java.util.Map.Entry<K, V>> createEntries() {
            throw new java.lang.AssertionError("unreachable");
        }

        @Override // com.google.common.collect.AbstractMultimap
        public java.util.Set<K> createKeySet() {
            return this.map.keySet();
        }

        @Override // com.google.common.collect.AbstractMultimap
        public com.google.common.collect.Multiset<K> createKeys() {
            return new com.google.common.collect.Multimaps.Keys(this);
        }

        @Override // com.google.common.collect.AbstractMultimap
        public java.util.Collection<V> createValues() {
            return this.map.values();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public java.util.Set<java.util.Map.Entry<K, V>> entries() {
            return this.map.entrySet();
        }

        @Override // com.google.common.collect.AbstractMultimap
        public java.util.Iterator<java.util.Map.Entry<K, V>> entryIterator() {
            return this.map.entrySet().iterator();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ java.util.Collection get(java.lang.Object obj) {
            return get((com.google.common.collect.Multimaps.MapMultimap<K, V>) obj);
        }

        @Override // com.google.common.collect.Multimap
        public java.util.Set<V> get(K k) {
            return new com.google.common.collect.Multimaps.MapMultimap.AnonymousClass1(k);
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean put(K k, V v) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean putAll(com.google.common.collect.Multimap<? extends K, ? extends V> multimap) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean putAll(K k, java.lang.Iterable<? extends V> iterable) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean remove(java.lang.Object obj, java.lang.Object obj2) {
            return this.map.entrySet().remove(com.google.common.collect.Maps.immutableEntry(obj, obj2));
        }

        @Override // com.google.common.collect.Multimap
        public java.util.Set<V> removeAll(java.lang.Object obj) {
            java.util.HashSet hashSet = new java.util.HashSet(2);
            if (!this.map.containsKey(obj)) {
                return hashSet;
            }
            hashSet.add(this.map.remove(obj));
            return hashSet;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ java.util.Collection replaceValues(java.lang.Object obj, java.lang.Iterable iterable) {
            return replaceValues((com.google.common.collect.Multimaps.MapMultimap<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public java.util.Set<V> replaceValues(K k, java.lang.Iterable<? extends V> iterable) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimap
        public int size() {
            return this.map.size();
        }
    }

    public static final class TransformedEntriesListMultimap<K, V1, V2> extends com.google.common.collect.Multimaps.TransformedEntriesMultimap<K, V1, V2> implements com.google.common.collect.ListMultimap<K, V2> {
        public TransformedEntriesListMultimap(com.google.common.collect.ListMultimap<K, V1> listMultimap, com.google.common.collect.Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            super(listMultimap, entryTransformer);
        }

        @Override // com.google.common.collect.Multimaps.TransformedEntriesMultimap
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public java.util.List<V2> a(K k, java.util.Collection<V1> collection) {
            return com.google.common.collect.Lists.transform((java.util.List) collection, com.google.common.collect.Maps.j(this.t, k));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.TransformedEntriesMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ java.util.Collection get(java.lang.Object obj) {
            return get((com.google.common.collect.Multimaps.TransformedEntriesListMultimap<K, V1, V2>) obj);
        }

        @Override // com.google.common.collect.Multimaps.TransformedEntriesMultimap, com.google.common.collect.Multimap
        public java.util.List<V2> get(K k) {
            return a(k, this.n.get(k));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.TransformedEntriesMultimap, com.google.common.collect.Multimap
        public java.util.List<V2> removeAll(java.lang.Object obj) {
            return a(obj, this.n.removeAll(obj));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.TransformedEntriesMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ java.util.Collection replaceValues(java.lang.Object obj, java.lang.Iterable iterable) {
            return replaceValues((com.google.common.collect.Multimaps.TransformedEntriesListMultimap<K, V1, V2>) obj, iterable);
        }

        @Override // com.google.common.collect.Multimaps.TransformedEntriesMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public java.util.List<V2> replaceValues(K k, java.lang.Iterable<? extends V2> iterable) {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    public static class TransformedEntriesMultimap<K, V1, V2> extends com.google.common.collect.AbstractMultimap<K, V2> {
        public final com.google.common.collect.Multimap<K, V1> n;
        public final com.google.common.collect.Maps.EntryTransformer<? super K, ? super V1, V2> t;

        /* renamed from: com.google.common.collect.Multimaps$TransformedEntriesMultimap$1, reason: invalid class name */
        public class AnonymousClass1 implements com.google.common.collect.Maps.EntryTransformer<K, java.util.Collection<V1>, java.util.Collection<V2>> {
            public AnonymousClass1() {
            }

            @Override // com.google.common.collect.Maps.EntryTransformer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public java.util.Collection<V2> transformEntry(K k, java.util.Collection<V1> collection) {
                return com.google.common.collect.Multimaps.TransformedEntriesMultimap.this.a(k, collection);
            }
        }

        public TransformedEntriesMultimap(com.google.common.collect.Multimap<K, V1> multimap, com.google.common.collect.Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            this.n = (com.google.common.collect.Multimap) com.google.common.base.Preconditions.checkNotNull(multimap);
            this.t = (com.google.common.collect.Maps.EntryTransformer) com.google.common.base.Preconditions.checkNotNull(entryTransformer);
        }

        public java.util.Collection<V2> a(K k, java.util.Collection<V1> collection) {
            com.google.common.base.Function j = com.google.common.collect.Maps.j(this.t, k);
            return collection instanceof java.util.List ? com.google.common.collect.Lists.transform((java.util.List) collection, j) : com.google.common.collect.Collections2.transform(collection, j);
        }

        @Override // com.google.common.collect.Multimap
        public void clear() {
            this.n.clear();
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsKey(java.lang.Object obj) {
            return this.n.containsKey(obj);
        }

        @Override // com.google.common.collect.AbstractMultimap
        public java.util.Map<K, java.util.Collection<V2>> createAsMap() {
            return com.google.common.collect.Maps.transformEntries(this.n.asMap(), new com.google.common.collect.Multimaps.TransformedEntriesMultimap.AnonymousClass1());
        }

        @Override // com.google.common.collect.AbstractMultimap
        public java.util.Collection<java.util.Map.Entry<K, V2>> createEntries() {
            return new com.google.common.collect.AbstractMultimap.Entries();
        }

        @Override // com.google.common.collect.AbstractMultimap
        public java.util.Set<K> createKeySet() {
            return this.n.keySet();
        }

        @Override // com.google.common.collect.AbstractMultimap
        public com.google.common.collect.Multiset<K> createKeys() {
            return this.n.keys();
        }

        @Override // com.google.common.collect.AbstractMultimap
        public java.util.Collection<V2> createValues() {
            return com.google.common.collect.Collections2.transform(this.n.entries(), com.google.common.collect.Maps.g(this.t));
        }

        @Override // com.google.common.collect.AbstractMultimap
        public java.util.Iterator<java.util.Map.Entry<K, V2>> entryIterator() {
            return com.google.common.collect.Iterators.transform(this.n.entries().iterator(), com.google.common.collect.Maps.f(this.t));
        }

        @Override // com.google.common.collect.Multimap
        public java.util.Collection<V2> get(K k) {
            return a(k, this.n.get(k));
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean isEmpty() {
            return this.n.isEmpty();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean put(K k, V2 v2) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean putAll(com.google.common.collect.Multimap<? extends K, ? extends V2> multimap) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean putAll(K k, java.lang.Iterable<? extends V2> iterable) {
            throw new java.lang.UnsupportedOperationException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean remove(java.lang.Object obj, java.lang.Object obj2) {
            return get(obj).remove(obj2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimap
        public java.util.Collection<V2> removeAll(java.lang.Object obj) {
            return a(obj, this.n.removeAll(obj));
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public java.util.Collection<V2> replaceValues(K k, java.lang.Iterable<? extends V2> iterable) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimap
        public int size() {
            return this.n.size();
        }
    }

    public static class UnmodifiableListMultimap<K, V> extends com.google.common.collect.Multimaps.UnmodifiableMultimap<K, V> implements com.google.common.collect.ListMultimap<K, V> {
        private static final long serialVersionUID = 0;

        public UnmodifiableListMultimap(com.google.common.collect.ListMultimap<K, V> listMultimap) {
            super(listMultimap);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        public com.google.common.collect.ListMultimap<K, V> delegate() {
            return (com.google.common.collect.ListMultimap) super.delegate();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ java.util.Collection get(java.lang.Object obj) {
            return get((com.google.common.collect.Multimaps.UnmodifiableListMultimap<K, V>) obj);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public java.util.List<V> get(K k) {
            return java.util.Collections.unmodifiableList(delegate().get((com.google.common.collect.ListMultimap<K, V>) k));
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public java.util.List<V> removeAll(java.lang.Object obj) {
            throw new java.lang.UnsupportedOperationException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ java.util.Collection replaceValues(java.lang.Object obj, java.lang.Iterable iterable) {
            return replaceValues((com.google.common.collect.Multimaps.UnmodifiableListMultimap<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public java.util.List<V> replaceValues(K k, java.lang.Iterable<? extends V> iterable) {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    public static class UnmodifiableMultimap<K, V> extends com.google.common.collect.ForwardingMultimap<K, V> implements java.io.Serializable {
        private static final long serialVersionUID = 0;
        final com.google.common.collect.Multimap<K, V> delegate;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        transient java.util.Collection<java.util.Map.Entry<K, V>> entries;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        transient java.util.Set<K> keySet;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        transient com.google.common.collect.Multiset<K> keys;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        transient java.util.Map<K, java.util.Collection<V>> map;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        transient java.util.Collection<V> values;

        /* renamed from: com.google.common.collect.Multimaps$UnmodifiableMultimap$1, reason: invalid class name */
        public class AnonymousClass1 implements com.google.common.base.Function<java.util.Collection<V>, java.util.Collection<V>> {
            public AnonymousClass1() {
            }

            @Override // com.google.common.base.Function
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public java.util.Collection<V> apply(java.util.Collection<V> collection) {
                return com.google.common.collect.Multimaps.g(collection);
            }
        }

        public UnmodifiableMultimap(com.google.common.collect.Multimap<K, V> multimap) {
            this.delegate = (com.google.common.collect.Multimap) com.google.common.base.Preconditions.checkNotNull(multimap);
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public java.util.Map<K, java.util.Collection<V>> asMap() {
            java.util.Map<K, java.util.Collection<V>> map = this.map;
            if (map != null) {
                return map;
            }
            java.util.Map<K, java.util.Collection<V>> unmodifiableMap = java.util.Collections.unmodifiableMap(com.google.common.collect.Maps.transformValues(this.delegate.asMap(), new com.google.common.collect.Multimaps.UnmodifiableMultimap.AnonymousClass1()));
            this.map = unmodifiableMap;
            return unmodifiableMap;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public void clear() {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        public com.google.common.collect.Multimap<K, V> delegate() {
            return this.delegate;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public java.util.Collection<java.util.Map.Entry<K, V>> entries() {
            java.util.Collection<java.util.Map.Entry<K, V>> collection = this.entries;
            if (collection != null) {
                return collection;
            }
            java.util.Collection<java.util.Map.Entry<K, V>> f = com.google.common.collect.Multimaps.f(this.delegate.entries());
            this.entries = f;
            return f;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public java.util.Collection<V> get(K k) {
            return com.google.common.collect.Multimaps.g(this.delegate.get(k));
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public java.util.Set<K> keySet() {
            java.util.Set<K> set = this.keySet;
            if (set != null) {
                return set;
            }
            java.util.Set<K> unmodifiableSet = java.util.Collections.unmodifiableSet(this.delegate.keySet());
            this.keySet = unmodifiableSet;
            return unmodifiableSet;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public com.google.common.collect.Multiset<K> keys() {
            com.google.common.collect.Multiset<K> multiset = this.keys;
            if (multiset != null) {
                return multiset;
            }
            com.google.common.collect.Multiset<K> unmodifiableMultiset = com.google.common.collect.Multisets.unmodifiableMultiset(this.delegate.keys());
            this.keys = unmodifiableMultiset;
            return unmodifiableMultiset;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public boolean put(K k, V v) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public boolean putAll(com.google.common.collect.Multimap<? extends K, ? extends V> multimap) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public boolean putAll(K k, java.lang.Iterable<? extends V> iterable) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public boolean remove(java.lang.Object obj, java.lang.Object obj2) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public java.util.Collection<V> removeAll(java.lang.Object obj) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public java.util.Collection<V> replaceValues(K k, java.lang.Iterable<? extends V> iterable) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public java.util.Collection<V> values() {
            java.util.Collection<V> collection = this.values;
            if (collection != null) {
                return collection;
            }
            java.util.Collection<V> unmodifiableCollection = java.util.Collections.unmodifiableCollection(this.delegate.values());
            this.values = unmodifiableCollection;
            return unmodifiableCollection;
        }
    }

    public static class UnmodifiableSetMultimap<K, V> extends com.google.common.collect.Multimaps.UnmodifiableMultimap<K, V> implements com.google.common.collect.SetMultimap<K, V> {
        private static final long serialVersionUID = 0;

        public UnmodifiableSetMultimap(com.google.common.collect.SetMultimap<K, V> setMultimap) {
            super(setMultimap);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        public com.google.common.collect.SetMultimap<K, V> delegate() {
            return (com.google.common.collect.SetMultimap) super.delegate();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public java.util.Set<java.util.Map.Entry<K, V>> entries() {
            return com.google.common.collect.Maps.M(delegate().entries());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ java.util.Collection get(java.lang.Object obj) {
            return get((com.google.common.collect.Multimaps.UnmodifiableSetMultimap<K, V>) obj);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public java.util.Set<V> get(K k) {
            return java.util.Collections.unmodifiableSet(delegate().get((com.google.common.collect.SetMultimap<K, V>) k));
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public java.util.Set<V> removeAll(java.lang.Object obj) {
            throw new java.lang.UnsupportedOperationException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ java.util.Collection replaceValues(java.lang.Object obj, java.lang.Iterable iterable) {
            return replaceValues((com.google.common.collect.Multimaps.UnmodifiableSetMultimap<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public java.util.Set<V> replaceValues(K k, java.lang.Iterable<? extends V> iterable) {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    public static class UnmodifiableSortedSetMultimap<K, V> extends com.google.common.collect.Multimaps.UnmodifiableSetMultimap<K, V> implements com.google.common.collect.SortedSetMultimap<K, V> {
        private static final long serialVersionUID = 0;

        public UnmodifiableSortedSetMultimap(com.google.common.collect.SortedSetMultimap<K, V> sortedSetMultimap) {
            super(sortedSetMultimap);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        public com.google.common.collect.SortedSetMultimap<K, V> delegate() {
            return (com.google.common.collect.SortedSetMultimap) super.delegate();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ java.util.Collection get(java.lang.Object obj) {
            return get((com.google.common.collect.Multimaps.UnmodifiableSortedSetMultimap<K, V>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ java.util.Set get(java.lang.Object obj) {
            return get((com.google.common.collect.Multimaps.UnmodifiableSortedSetMultimap<K, V>) obj);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public java.util.SortedSet<V> get(K k) {
            return java.util.Collections.unmodifiableSortedSet(delegate().get((com.google.common.collect.SortedSetMultimap<K, V>) k));
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public java.util.SortedSet<V> removeAll(java.lang.Object obj) {
            throw new java.lang.UnsupportedOperationException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ java.util.Collection replaceValues(java.lang.Object obj, java.lang.Iterable iterable) {
            return replaceValues((com.google.common.collect.Multimaps.UnmodifiableSortedSetMultimap<K, V>) obj, iterable);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public /* bridge */ /* synthetic */ java.util.Set replaceValues(java.lang.Object obj, java.lang.Iterable iterable) {
            return replaceValues((com.google.common.collect.Multimaps.UnmodifiableSortedSetMultimap<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public java.util.SortedSet<V> replaceValues(K k, java.lang.Iterable<? extends V> iterable) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.collect.SortedSetMultimap
        public java.util.Comparator<? super V> valueComparator() {
            return delegate().valueComparator();
        }
    }

    @com.google.common.annotations.Beta
    public static <K, V> java.util.Map<K, java.util.List<V>> asMap(com.google.common.collect.ListMultimap<K, V> listMultimap) {
        return listMultimap.asMap();
    }

    @com.google.common.annotations.Beta
    public static <K, V> java.util.Map<K, java.util.Collection<V>> asMap(com.google.common.collect.Multimap<K, V> multimap) {
        return multimap.asMap();
    }

    @com.google.common.annotations.Beta
    public static <K, V> java.util.Map<K, java.util.Set<V>> asMap(com.google.common.collect.SetMultimap<K, V> setMultimap) {
        return setMultimap.asMap();
    }

    @com.google.common.annotations.Beta
    public static <K, V> java.util.Map<K, java.util.SortedSet<V>> asMap(com.google.common.collect.SortedSetMultimap<K, V> sortedSetMultimap) {
        return sortedSetMultimap.asMap();
    }

    public static boolean c(com.google.common.collect.Multimap<?, ?> multimap, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj == multimap) {
            return true;
        }
        if (obj instanceof com.google.common.collect.Multimap) {
            return multimap.asMap().equals(((com.google.common.collect.Multimap) obj).asMap());
        }
        return false;
    }

    public static <K, V> com.google.common.collect.Multimap<K, V> d(com.google.common.collect.FilteredMultimap<K, V> filteredMultimap, com.google.common.base.Predicate<? super java.util.Map.Entry<K, V>> predicate) {
        return new com.google.common.collect.FilteredEntryMultimap(filteredMultimap.i(), com.google.common.base.Predicates.and(filteredMultimap.j(), predicate));
    }

    public static <K, V> com.google.common.collect.SetMultimap<K, V> e(com.google.common.collect.FilteredSetMultimap<K, V> filteredSetMultimap, com.google.common.base.Predicate<? super java.util.Map.Entry<K, V>> predicate) {
        return new com.google.common.collect.FilteredEntrySetMultimap(filteredSetMultimap.i(), com.google.common.base.Predicates.and(filteredSetMultimap.j(), predicate));
    }

    public static <K, V> java.util.Collection<java.util.Map.Entry<K, V>> f(java.util.Collection<java.util.Map.Entry<K, V>> collection) {
        return collection instanceof java.util.Set ? com.google.common.collect.Maps.M((java.util.Set) collection) : new com.google.common.collect.Maps.UnmodifiableEntries(java.util.Collections.unmodifiableCollection(collection));
    }

    public static <K, V> com.google.common.collect.Multimap<K, V> filterEntries(com.google.common.collect.Multimap<K, V> multimap, com.google.common.base.Predicate<? super java.util.Map.Entry<K, V>> predicate) {
        com.google.common.base.Preconditions.checkNotNull(predicate);
        return multimap instanceof com.google.common.collect.SetMultimap ? filterEntries((com.google.common.collect.SetMultimap) multimap, (com.google.common.base.Predicate) predicate) : multimap instanceof com.google.common.collect.FilteredMultimap ? d((com.google.common.collect.FilteredMultimap) multimap, predicate) : new com.google.common.collect.FilteredEntryMultimap((com.google.common.collect.Multimap) com.google.common.base.Preconditions.checkNotNull(multimap), predicate);
    }

    public static <K, V> com.google.common.collect.SetMultimap<K, V> filterEntries(com.google.common.collect.SetMultimap<K, V> setMultimap, com.google.common.base.Predicate<? super java.util.Map.Entry<K, V>> predicate) {
        com.google.common.base.Preconditions.checkNotNull(predicate);
        return setMultimap instanceof com.google.common.collect.FilteredSetMultimap ? e((com.google.common.collect.FilteredSetMultimap) setMultimap, predicate) : new com.google.common.collect.FilteredEntrySetMultimap((com.google.common.collect.SetMultimap) com.google.common.base.Preconditions.checkNotNull(setMultimap), predicate);
    }

    public static <K, V> com.google.common.collect.ListMultimap<K, V> filterKeys(com.google.common.collect.ListMultimap<K, V> listMultimap, com.google.common.base.Predicate<? super K> predicate) {
        if (!(listMultimap instanceof com.google.common.collect.FilteredKeyListMultimap)) {
            return new com.google.common.collect.FilteredKeyListMultimap(listMultimap, predicate);
        }
        com.google.common.collect.FilteredKeyListMultimap filteredKeyListMultimap = (com.google.common.collect.FilteredKeyListMultimap) listMultimap;
        return new com.google.common.collect.FilteredKeyListMultimap(filteredKeyListMultimap.i(), com.google.common.base.Predicates.and(filteredKeyListMultimap.t, predicate));
    }

    public static <K, V> com.google.common.collect.Multimap<K, V> filterKeys(com.google.common.collect.Multimap<K, V> multimap, com.google.common.base.Predicate<? super K> predicate) {
        if (multimap instanceof com.google.common.collect.SetMultimap) {
            return filterKeys((com.google.common.collect.SetMultimap) multimap, (com.google.common.base.Predicate) predicate);
        }
        if (multimap instanceof com.google.common.collect.ListMultimap) {
            return filterKeys((com.google.common.collect.ListMultimap) multimap, (com.google.common.base.Predicate) predicate);
        }
        if (!(multimap instanceof com.google.common.collect.FilteredKeyMultimap)) {
            return multimap instanceof com.google.common.collect.FilteredMultimap ? d((com.google.common.collect.FilteredMultimap) multimap, com.google.common.collect.Maps.y(predicate)) : new com.google.common.collect.FilteredKeyMultimap(multimap, predicate);
        }
        com.google.common.collect.FilteredKeyMultimap filteredKeyMultimap = (com.google.common.collect.FilteredKeyMultimap) multimap;
        return new com.google.common.collect.FilteredKeyMultimap(filteredKeyMultimap.n, com.google.common.base.Predicates.and(filteredKeyMultimap.t, predicate));
    }

    public static <K, V> com.google.common.collect.SetMultimap<K, V> filterKeys(com.google.common.collect.SetMultimap<K, V> setMultimap, com.google.common.base.Predicate<? super K> predicate) {
        if (!(setMultimap instanceof com.google.common.collect.FilteredKeySetMultimap)) {
            return setMultimap instanceof com.google.common.collect.FilteredSetMultimap ? e((com.google.common.collect.FilteredSetMultimap) setMultimap, com.google.common.collect.Maps.y(predicate)) : new com.google.common.collect.FilteredKeySetMultimap(setMultimap, predicate);
        }
        com.google.common.collect.FilteredKeySetMultimap filteredKeySetMultimap = (com.google.common.collect.FilteredKeySetMultimap) setMultimap;
        return new com.google.common.collect.FilteredKeySetMultimap(filteredKeySetMultimap.i(), com.google.common.base.Predicates.and(filteredKeySetMultimap.t, predicate));
    }

    public static <K, V> com.google.common.collect.Multimap<K, V> filterValues(com.google.common.collect.Multimap<K, V> multimap, com.google.common.base.Predicate<? super V> predicate) {
        return filterEntries(multimap, com.google.common.collect.Maps.S(predicate));
    }

    public static <K, V> com.google.common.collect.SetMultimap<K, V> filterValues(com.google.common.collect.SetMultimap<K, V> setMultimap, com.google.common.base.Predicate<? super V> predicate) {
        return filterEntries((com.google.common.collect.SetMultimap) setMultimap, com.google.common.collect.Maps.S(predicate));
    }

    public static <K, V> com.google.common.collect.SetMultimap<K, V> forMap(java.util.Map<K, V> map) {
        return new com.google.common.collect.Multimaps.MapMultimap(map);
    }

    public static <V> java.util.Collection<V> g(java.util.Collection<V> collection) {
        return collection instanceof java.util.SortedSet ? java.util.Collections.unmodifiableSortedSet((java.util.SortedSet) collection) : collection instanceof java.util.Set ? java.util.Collections.unmodifiableSet((java.util.Set) collection) : collection instanceof java.util.List ? java.util.Collections.unmodifiableList((java.util.List) collection) : java.util.Collections.unmodifiableCollection(collection);
    }

    public static <K, V> com.google.common.collect.ImmutableListMultimap<K, V> index(java.lang.Iterable<V> iterable, com.google.common.base.Function<? super V, K> function) {
        return index(iterable.iterator(), function);
    }

    public static <K, V> com.google.common.collect.ImmutableListMultimap<K, V> index(java.util.Iterator<V> it, com.google.common.base.Function<? super V, K> function) {
        com.google.common.base.Preconditions.checkNotNull(function);
        com.google.common.collect.ImmutableListMultimap.Builder builder = com.google.common.collect.ImmutableListMultimap.builder();
        while (it.hasNext()) {
            V next = it.next();
            com.google.common.base.Preconditions.checkNotNull(next, it);
            builder.put((com.google.common.collect.ImmutableListMultimap.Builder) function.apply(next), (K) next);
        }
        return builder.build();
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static <K, V, M extends com.google.common.collect.Multimap<K, V>> M invertFrom(com.google.common.collect.Multimap<? extends V, ? extends K> multimap, M m) {
        com.google.common.base.Preconditions.checkNotNull(m);
        for (java.util.Map.Entry<? extends V, ? extends K> entry : multimap.entries()) {
            m.put(entry.getValue(), entry.getKey());
        }
        return m;
    }

    public static <K, V> com.google.common.collect.ListMultimap<K, V> newListMultimap(java.util.Map<K, java.util.Collection<V>> map, com.google.common.base.Supplier<? extends java.util.List<V>> supplier) {
        return new com.google.common.collect.Multimaps.CustomListMultimap(map, supplier);
    }

    public static <K, V> com.google.common.collect.Multimap<K, V> newMultimap(java.util.Map<K, java.util.Collection<V>> map, com.google.common.base.Supplier<? extends java.util.Collection<V>> supplier) {
        return new com.google.common.collect.Multimaps.CustomMultimap(map, supplier);
    }

    public static <K, V> com.google.common.collect.SetMultimap<K, V> newSetMultimap(java.util.Map<K, java.util.Collection<V>> map, com.google.common.base.Supplier<? extends java.util.Set<V>> supplier) {
        return new com.google.common.collect.Multimaps.CustomSetMultimap(map, supplier);
    }

    public static <K, V> com.google.common.collect.SortedSetMultimap<K, V> newSortedSetMultimap(java.util.Map<K, java.util.Collection<V>> map, com.google.common.base.Supplier<? extends java.util.SortedSet<V>> supplier) {
        return new com.google.common.collect.Multimaps.CustomSortedSetMultimap(map, supplier);
    }

    public static <K, V> com.google.common.collect.ListMultimap<K, V> synchronizedListMultimap(com.google.common.collect.ListMultimap<K, V> listMultimap) {
        return com.google.common.collect.Synchronized.k(listMultimap, null);
    }

    public static <K, V> com.google.common.collect.Multimap<K, V> synchronizedMultimap(com.google.common.collect.Multimap<K, V> multimap) {
        return com.google.common.collect.Synchronized.m(multimap, null);
    }

    public static <K, V> com.google.common.collect.SetMultimap<K, V> synchronizedSetMultimap(com.google.common.collect.SetMultimap<K, V> setMultimap) {
        return com.google.common.collect.Synchronized.v(setMultimap, null);
    }

    public static <K, V> com.google.common.collect.SortedSetMultimap<K, V> synchronizedSortedSetMultimap(com.google.common.collect.SortedSetMultimap<K, V> sortedSetMultimap) {
        return com.google.common.collect.Synchronized.y(sortedSetMultimap, null);
    }

    public static <K, V1, V2> com.google.common.collect.ListMultimap<K, V2> transformEntries(com.google.common.collect.ListMultimap<K, V1> listMultimap, com.google.common.collect.Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new com.google.common.collect.Multimaps.TransformedEntriesListMultimap(listMultimap, entryTransformer);
    }

    public static <K, V1, V2> com.google.common.collect.Multimap<K, V2> transformEntries(com.google.common.collect.Multimap<K, V1> multimap, com.google.common.collect.Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new com.google.common.collect.Multimaps.TransformedEntriesMultimap(multimap, entryTransformer);
    }

    public static <K, V1, V2> com.google.common.collect.ListMultimap<K, V2> transformValues(com.google.common.collect.ListMultimap<K, V1> listMultimap, com.google.common.base.Function<? super V1, V2> function) {
        com.google.common.base.Preconditions.checkNotNull(function);
        return transformEntries((com.google.common.collect.ListMultimap) listMultimap, com.google.common.collect.Maps.h(function));
    }

    public static <K, V1, V2> com.google.common.collect.Multimap<K, V2> transformValues(com.google.common.collect.Multimap<K, V1> multimap, com.google.common.base.Function<? super V1, V2> function) {
        com.google.common.base.Preconditions.checkNotNull(function);
        return transformEntries(multimap, com.google.common.collect.Maps.h(function));
    }

    @java.lang.Deprecated
    public static <K, V> com.google.common.collect.ListMultimap<K, V> unmodifiableListMultimap(com.google.common.collect.ImmutableListMultimap<K, V> immutableListMultimap) {
        return (com.google.common.collect.ListMultimap) com.google.common.base.Preconditions.checkNotNull(immutableListMultimap);
    }

    public static <K, V> com.google.common.collect.ListMultimap<K, V> unmodifiableListMultimap(com.google.common.collect.ListMultimap<K, V> listMultimap) {
        return ((listMultimap instanceof com.google.common.collect.Multimaps.UnmodifiableListMultimap) || (listMultimap instanceof com.google.common.collect.ImmutableListMultimap)) ? listMultimap : new com.google.common.collect.Multimaps.UnmodifiableListMultimap(listMultimap);
    }

    @java.lang.Deprecated
    public static <K, V> com.google.common.collect.Multimap<K, V> unmodifiableMultimap(com.google.common.collect.ImmutableMultimap<K, V> immutableMultimap) {
        return (com.google.common.collect.Multimap) com.google.common.base.Preconditions.checkNotNull(immutableMultimap);
    }

    public static <K, V> com.google.common.collect.Multimap<K, V> unmodifiableMultimap(com.google.common.collect.Multimap<K, V> multimap) {
        return ((multimap instanceof com.google.common.collect.Multimaps.UnmodifiableMultimap) || (multimap instanceof com.google.common.collect.ImmutableMultimap)) ? multimap : new com.google.common.collect.Multimaps.UnmodifiableMultimap(multimap);
    }

    @java.lang.Deprecated
    public static <K, V> com.google.common.collect.SetMultimap<K, V> unmodifiableSetMultimap(com.google.common.collect.ImmutableSetMultimap<K, V> immutableSetMultimap) {
        return (com.google.common.collect.SetMultimap) com.google.common.base.Preconditions.checkNotNull(immutableSetMultimap);
    }

    public static <K, V> com.google.common.collect.SetMultimap<K, V> unmodifiableSetMultimap(com.google.common.collect.SetMultimap<K, V> setMultimap) {
        return ((setMultimap instanceof com.google.common.collect.Multimaps.UnmodifiableSetMultimap) || (setMultimap instanceof com.google.common.collect.ImmutableSetMultimap)) ? setMultimap : new com.google.common.collect.Multimaps.UnmodifiableSetMultimap(setMultimap);
    }

    public static <K, V> com.google.common.collect.SortedSetMultimap<K, V> unmodifiableSortedSetMultimap(com.google.common.collect.SortedSetMultimap<K, V> sortedSetMultimap) {
        return sortedSetMultimap instanceof com.google.common.collect.Multimaps.UnmodifiableSortedSetMultimap ? sortedSetMultimap : new com.google.common.collect.Multimaps.UnmodifiableSortedSetMultimap(sortedSetMultimap);
    }
}
