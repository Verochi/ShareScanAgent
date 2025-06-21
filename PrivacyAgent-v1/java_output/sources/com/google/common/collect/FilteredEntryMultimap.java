package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
class FilteredEntryMultimap<K, V> extends com.google.common.collect.AbstractMultimap<K, V> implements com.google.common.collect.FilteredMultimap<K, V> {
    public final com.google.common.collect.Multimap<K, V> n;
    public final com.google.common.base.Predicate<? super java.util.Map.Entry<K, V>> t;

    public class AsMap extends com.google.common.collect.Maps.ViewCachingAbstractMap<K, java.util.Collection<V>> {

        /* renamed from: com.google.common.collect.FilteredEntryMultimap$AsMap$1EntrySetImpl, reason: invalid class name */
        public class C1EntrySetImpl extends com.google.common.collect.Maps.EntrySet<K, java.util.Collection<V>> {

            /* renamed from: com.google.common.collect.FilteredEntryMultimap$AsMap$1EntrySetImpl$1, reason: invalid class name */
            public class AnonymousClass1 extends com.google.common.collect.AbstractIterator<java.util.Map.Entry<K, java.util.Collection<V>>> {
                public final java.util.Iterator<java.util.Map.Entry<K, java.util.Collection<V>>> u;

                public AnonymousClass1() {
                    this.u = com.google.common.collect.FilteredEntryMultimap.this.n.asMap().entrySet().iterator();
                }

                @Override // com.google.common.collect.AbstractIterator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public java.util.Map.Entry<K, java.util.Collection<V>> computeNext() {
                    while (this.u.hasNext()) {
                        java.util.Map.Entry<K, java.util.Collection<V>> next = this.u.next();
                        K key = next.getKey();
                        java.util.Collection b = com.google.common.collect.FilteredEntryMultimap.b(next.getValue(), new com.google.common.collect.FilteredEntryMultimap.ValuePredicate(key));
                        if (!b.isEmpty()) {
                            return com.google.common.collect.Maps.immutableEntry(key, b);
                        }
                    }
                    return endOfData();
                }
            }

            public C1EntrySetImpl() {
            }

            @Override // com.google.common.collect.Maps.EntrySet
            public java.util.Map<K, java.util.Collection<V>> a() {
                return com.google.common.collect.FilteredEntryMultimap.AsMap.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public java.util.Iterator<java.util.Map.Entry<K, java.util.Collection<V>>> iterator() {
                return new com.google.common.collect.FilteredEntryMultimap.AsMap.C1EntrySetImpl.AnonymousClass1();
            }

            @Override // com.google.common.collect.Maps.EntrySet, com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(java.util.Collection<?> collection) {
                return com.google.common.collect.FilteredEntryMultimap.this.c(com.google.common.base.Predicates.in(collection));
            }

            @Override // com.google.common.collect.Maps.EntrySet, com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(java.util.Collection<?> collection) {
                return com.google.common.collect.FilteredEntryMultimap.this.c(com.google.common.base.Predicates.not(com.google.common.base.Predicates.in(collection)));
            }

            @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return com.google.common.collect.Iterators.size(iterator());
            }
        }

        /* renamed from: com.google.common.collect.FilteredEntryMultimap$AsMap$1KeySetImpl, reason: invalid class name */
        public class C1KeySetImpl extends com.google.common.collect.Maps.KeySet<K, java.util.Collection<V>> {
            public C1KeySetImpl() {
                super(com.google.common.collect.FilteredEntryMultimap.AsMap.this);
            }

            @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
                return com.google.common.collect.FilteredEntryMultimap.AsMap.this.remove(obj) != null;
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(java.util.Collection<?> collection) {
                return com.google.common.collect.FilteredEntryMultimap.this.c(com.google.common.collect.Maps.y(com.google.common.base.Predicates.in(collection)));
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(java.util.Collection<?> collection) {
                return com.google.common.collect.FilteredEntryMultimap.this.c(com.google.common.collect.Maps.y(com.google.common.base.Predicates.not(com.google.common.base.Predicates.in(collection))));
            }
        }

        /* renamed from: com.google.common.collect.FilteredEntryMultimap$AsMap$1ValuesImpl, reason: invalid class name */
        public class C1ValuesImpl extends com.google.common.collect.Maps.Values<K, java.util.Collection<V>> {
            public C1ValuesImpl() {
                super(com.google.common.collect.FilteredEntryMultimap.AsMap.this);
            }

            @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
            public boolean remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
                if (!(obj instanceof java.util.Collection)) {
                    return false;
                }
                java.util.Collection collection = (java.util.Collection) obj;
                java.util.Iterator<java.util.Map.Entry<K, java.util.Collection<V>>> it = com.google.common.collect.FilteredEntryMultimap.this.n.asMap().entrySet().iterator();
                while (it.hasNext()) {
                    java.util.Map.Entry<K, java.util.Collection<V>> next = it.next();
                    java.util.Collection b = com.google.common.collect.FilteredEntryMultimap.b(next.getValue(), new com.google.common.collect.FilteredEntryMultimap.ValuePredicate(next.getKey()));
                    if (!b.isEmpty() && collection.equals(b)) {
                        if (b.size() == next.getValue().size()) {
                            it.remove();
                            return true;
                        }
                        b.clear();
                        return true;
                    }
                }
                return false;
            }

            @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(java.util.Collection<?> collection) {
                return com.google.common.collect.FilteredEntryMultimap.this.c(com.google.common.collect.Maps.S(com.google.common.base.Predicates.in(collection)));
            }

            @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(java.util.Collection<?> collection) {
                return com.google.common.collect.FilteredEntryMultimap.this.c(com.google.common.collect.Maps.S(com.google.common.base.Predicates.not(com.google.common.base.Predicates.in(collection))));
            }
        }

        public AsMap() {
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public java.util.Set<java.util.Map.Entry<K, java.util.Collection<V>>> a() {
            return new com.google.common.collect.FilteredEntryMultimap.AsMap.C1EntrySetImpl();
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        /* renamed from: b */
        public java.util.Set<K> h() {
            return new com.google.common.collect.FilteredEntryMultimap.AsMap.C1KeySetImpl();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            com.google.common.collect.FilteredEntryMultimap.this.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return get(obj) != null;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public java.util.Collection<java.util.Collection<V>> d() {
            return new com.google.common.collect.FilteredEntryMultimap.AsMap.C1ValuesImpl();
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public java.util.Collection<V> get(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            java.util.Collection<V> collection = com.google.common.collect.FilteredEntryMultimap.this.n.asMap().get(obj);
            if (collection == null) {
                return null;
            }
            java.util.Collection<V> b = com.google.common.collect.FilteredEntryMultimap.b(collection, new com.google.common.collect.FilteredEntryMultimap.ValuePredicate(obj));
            if (b.isEmpty()) {
                return null;
            }
            return b;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public java.util.Collection<V> remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            java.util.Collection<V> collection = com.google.common.collect.FilteredEntryMultimap.this.n.asMap().get(obj);
            if (collection == null) {
                return null;
            }
            java.util.ArrayList newArrayList = com.google.common.collect.Lists.newArrayList();
            java.util.Iterator<V> it = collection.iterator();
            while (it.hasNext()) {
                V next = it.next();
                if (com.google.common.collect.FilteredEntryMultimap.this.d(obj, next)) {
                    it.remove();
                    newArrayList.add(next);
                }
            }
            if (newArrayList.isEmpty()) {
                return null;
            }
            return com.google.common.collect.FilteredEntryMultimap.this.n instanceof com.google.common.collect.SetMultimap ? java.util.Collections.unmodifiableSet(com.google.common.collect.Sets.newLinkedHashSet(newArrayList)) : java.util.Collections.unmodifiableList(newArrayList);
        }
    }

    public class Keys extends com.google.common.collect.Multimaps.Keys<K, V> {

        /* renamed from: com.google.common.collect.FilteredEntryMultimap$Keys$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.collect.Multisets.EntrySet<K> {

            /* renamed from: com.google.common.collect.FilteredEntryMultimap$Keys$1$1, reason: invalid class name and collision with other inner class name */
            public class C03391 implements com.google.common.base.Predicate<java.util.Map.Entry<K, java.util.Collection<V>>> {
                public final /* synthetic */ com.google.common.base.Predicate n;

                public C03391(com.google.common.base.Predicate predicate) {
                    this.n = predicate;
                }

                @Override // com.google.common.base.Predicate
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public boolean apply(java.util.Map.Entry<K, java.util.Collection<V>> entry) {
                    return this.n.apply(com.google.common.collect.Multisets.immutableEntry(entry.getKey(), entry.getValue().size()));
                }
            }

            public AnonymousClass1() {
            }

            @Override // com.google.common.collect.Multisets.EntrySet
            public com.google.common.collect.Multiset<K> a() {
                return com.google.common.collect.FilteredEntryMultimap.Keys.this;
            }

            public final boolean b(com.google.common.base.Predicate<? super com.google.common.collect.Multiset.Entry<K>> predicate) {
                return com.google.common.collect.FilteredEntryMultimap.this.c(new com.google.common.collect.FilteredEntryMultimap.Keys.AnonymousClass1.C03391(predicate));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public java.util.Iterator<com.google.common.collect.Multiset.Entry<K>> iterator() {
                return com.google.common.collect.FilteredEntryMultimap.Keys.this.entryIterator();
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(java.util.Collection<?> collection) {
                return b(com.google.common.base.Predicates.in(collection));
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(java.util.Collection<?> collection) {
                return b(com.google.common.base.Predicates.not(com.google.common.base.Predicates.in(collection)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return com.google.common.collect.FilteredEntryMultimap.this.keySet().size();
            }
        }

        public Keys() {
            super(com.google.common.collect.FilteredEntryMultimap.this);
        }

        @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public java.util.Set<com.google.common.collect.Multiset.Entry<K>> entrySet() {
            return new com.google.common.collect.FilteredEntryMultimap.Keys.AnonymousClass1();
        }

        @Override // com.google.common.collect.Multimaps.Keys, com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public int remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, int i) {
            com.google.common.collect.CollectPreconditions.b(i, "occurrences");
            if (i == 0) {
                return count(obj);
            }
            java.util.Collection<V> collection = com.google.common.collect.FilteredEntryMultimap.this.n.asMap().get(obj);
            int i2 = 0;
            if (collection == null) {
                return 0;
            }
            java.util.Iterator<V> it = collection.iterator();
            while (it.hasNext()) {
                if (com.google.common.collect.FilteredEntryMultimap.this.d(obj, it.next()) && (i2 = i2 + 1) <= i) {
                    it.remove();
                }
            }
            return i2;
        }
    }

    public final class ValuePredicate implements com.google.common.base.Predicate<V> {
        public final K n;

        public ValuePredicate(K k) {
            this.n = k;
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
            return com.google.common.collect.FilteredEntryMultimap.this.d(this.n, v);
        }
    }

    public FilteredEntryMultimap(com.google.common.collect.Multimap<K, V> multimap, com.google.common.base.Predicate<? super java.util.Map.Entry<K, V>> predicate) {
        this.n = (com.google.common.collect.Multimap) com.google.common.base.Preconditions.checkNotNull(multimap);
        this.t = (com.google.common.base.Predicate) com.google.common.base.Preconditions.checkNotNull(predicate);
    }

    public static <E> java.util.Collection<E> b(java.util.Collection<E> collection, com.google.common.base.Predicate<? super E> predicate) {
        return collection instanceof java.util.Set ? com.google.common.collect.Sets.filter((java.util.Set) collection, predicate) : com.google.common.collect.Collections2.filter(collection, predicate);
    }

    public boolean c(com.google.common.base.Predicate<? super java.util.Map.Entry<K, java.util.Collection<V>>> predicate) {
        java.util.Iterator<java.util.Map.Entry<K, java.util.Collection<V>>> it = this.n.asMap().entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            java.util.Map.Entry<K, java.util.Collection<V>> next = it.next();
            K key = next.getKey();
            java.util.Collection b = b(next.getValue(), new com.google.common.collect.FilteredEntryMultimap.ValuePredicate(key));
            if (!b.isEmpty() && predicate.apply(com.google.common.collect.Maps.immutableEntry(key, b))) {
                if (b.size() == next.getValue().size()) {
                    it.remove();
                } else {
                    b.clear();
                }
                z = true;
            }
        }
        return z;
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        entries().clear();
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return asMap().get(obj) != null;
    }

    @Override // com.google.common.collect.AbstractMultimap
    public java.util.Map<K, java.util.Collection<V>> createAsMap() {
        return new com.google.common.collect.FilteredEntryMultimap.AsMap();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public java.util.Collection<java.util.Map.Entry<K, V>> createEntries() {
        return b(this.n.entries(), this.t);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public java.util.Set<K> createKeySet() {
        return asMap().keySet();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public com.google.common.collect.Multiset<K> createKeys() {
        return new com.google.common.collect.FilteredEntryMultimap.Keys();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public java.util.Collection<V> createValues() {
        return new com.google.common.collect.FilteredMultimapValues(this);
    }

    public final boolean d(K k, V v) {
        return this.t.apply(com.google.common.collect.Maps.immutableEntry(k, v));
    }

    @Override // com.google.common.collect.AbstractMultimap
    public java.util.Iterator<java.util.Map.Entry<K, V>> entryIterator() {
        throw new java.lang.AssertionError("should never be called");
    }

    @Override // com.google.common.collect.Multimap
    public java.util.Collection<V> get(K k) {
        return b(this.n.get(k), new com.google.common.collect.FilteredEntryMultimap.ValuePredicate(k));
    }

    @Override // com.google.common.collect.FilteredMultimap
    public com.google.common.collect.Multimap<K, V> i() {
        return this.n;
    }

    @Override // com.google.common.collect.FilteredMultimap
    public com.google.common.base.Predicate<? super java.util.Map.Entry<K, V>> j() {
        return this.t;
    }

    public java.util.Collection<V> k() {
        return this.n instanceof com.google.common.collect.SetMultimap ? java.util.Collections.emptySet() : java.util.Collections.emptyList();
    }

    @Override // com.google.common.collect.Multimap
    public java.util.Collection<V> removeAll(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return (java.util.Collection) com.google.common.base.MoreObjects.firstNonNull(asMap().remove(obj), k());
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return entries().size();
    }
}
