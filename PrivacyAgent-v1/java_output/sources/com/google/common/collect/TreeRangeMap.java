package com.google.common.collect;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public final class TreeRangeMap<K extends java.lang.Comparable, V> implements com.google.common.collect.RangeMap<K, V> {
    public static final com.google.common.collect.RangeMap t = new com.google.common.collect.TreeRangeMap.AnonymousClass1();
    public final java.util.NavigableMap<com.google.common.collect.Cut<K>, com.google.common.collect.TreeRangeMap.RangeMapEntry<K, V>> n = com.google.common.collect.Maps.newTreeMap();

    /* renamed from: com.google.common.collect.TreeRangeMap$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.google.common.collect.RangeMap {
        @Override // com.google.common.collect.RangeMap
        public java.util.Map<com.google.common.collect.Range, java.lang.Object> asDescendingMapOfRanges() {
            return java.util.Collections.emptyMap();
        }

        @Override // com.google.common.collect.RangeMap
        public java.util.Map<com.google.common.collect.Range, java.lang.Object> asMapOfRanges() {
            return java.util.Collections.emptyMap();
        }

        @Override // com.google.common.collect.RangeMap
        public void clear() {
        }

        @Override // com.google.common.collect.RangeMap
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public java.lang.Object get(java.lang.Comparable comparable) {
            return null;
        }

        @Override // com.google.common.collect.RangeMap
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public java.util.Map.Entry<com.google.common.collect.Range, java.lang.Object> getEntry(java.lang.Comparable comparable) {
            return null;
        }

        @Override // com.google.common.collect.RangeMap
        public void put(com.google.common.collect.Range range, java.lang.Object obj) {
            com.google.common.base.Preconditions.checkNotNull(range);
            throw new java.lang.IllegalArgumentException("Cannot insert range " + range + " into an empty subRangeMap");
        }

        @Override // com.google.common.collect.RangeMap
        public void putAll(com.google.common.collect.RangeMap rangeMap) {
            if (!rangeMap.asMapOfRanges().isEmpty()) {
                throw new java.lang.IllegalArgumentException("Cannot putAll(nonEmptyRangeMap) into an empty subRangeMap");
            }
        }

        @Override // com.google.common.collect.RangeMap
        public void putCoalescing(com.google.common.collect.Range range, java.lang.Object obj) {
            com.google.common.base.Preconditions.checkNotNull(range);
            throw new java.lang.IllegalArgumentException("Cannot insert range " + range + " into an empty subRangeMap");
        }

        @Override // com.google.common.collect.RangeMap
        public void remove(com.google.common.collect.Range range) {
            com.google.common.base.Preconditions.checkNotNull(range);
        }

        @Override // com.google.common.collect.RangeMap
        public com.google.common.collect.Range span() {
            throw new java.util.NoSuchElementException();
        }

        @Override // com.google.common.collect.RangeMap
        public com.google.common.collect.RangeMap subRangeMap(com.google.common.collect.Range range) {
            com.google.common.base.Preconditions.checkNotNull(range);
            return this;
        }
    }

    public final class AsMapOfRanges extends com.google.common.collect.Maps.IteratorBasedAbstractMap<com.google.common.collect.Range<K>, V> {
        public final java.lang.Iterable<java.util.Map.Entry<com.google.common.collect.Range<K>, V>> n;

        public AsMapOfRanges(java.lang.Iterable<com.google.common.collect.TreeRangeMap.RangeMapEntry<K, V>> iterable) {
            this.n = iterable;
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public java.util.Iterator<java.util.Map.Entry<com.google.common.collect.Range<K>, V>> a() {
            return this.n.iterator();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return get(obj) != null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (!(obj instanceof com.google.common.collect.Range)) {
                return null;
            }
            com.google.common.collect.Range range = (com.google.common.collect.Range) obj;
            com.google.common.collect.TreeRangeMap.RangeMapEntry rangeMapEntry = (com.google.common.collect.TreeRangeMap.RangeMapEntry) com.google.common.collect.TreeRangeMap.this.n.get(range.lowerBound);
            if (rangeMapEntry == null || !rangeMapEntry.getKey().equals(range)) {
                return null;
            }
            return (V) rangeMapEntry.getValue();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return com.google.common.collect.TreeRangeMap.this.n.size();
        }
    }

    public static final class RangeMapEntry<K extends java.lang.Comparable, V> extends com.google.common.collect.AbstractMapEntry<com.google.common.collect.Range<K>, V> {
        public final com.google.common.collect.Range<K> n;
        public final V t;

        public RangeMapEntry(com.google.common.collect.Cut<K> cut, com.google.common.collect.Cut<K> cut2, V v) {
            this(com.google.common.collect.Range.create(cut, cut2), v);
        }

        public RangeMapEntry(com.google.common.collect.Range<K> range, V v) {
            this.n = range;
            this.t = v;
        }

        public boolean a(K k) {
            return this.n.contains(k);
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V getValue() {
            return this.t;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public com.google.common.collect.Range<K> getKey() {
            return this.n;
        }

        public com.google.common.collect.Cut<K> j() {
            return this.n.lowerBound;
        }

        public com.google.common.collect.Cut<K> k() {
            return this.n.upperBound;
        }
    }

    public class SubRangeMap implements com.google.common.collect.RangeMap<K, V> {
        public final com.google.common.collect.Range<K> n;

        /* renamed from: com.google.common.collect.TreeRangeMap$SubRangeMap$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.collect.TreeRangeMap<K, V>.SubRangeMap.SubRangeMapAsMap {

            /* renamed from: com.google.common.collect.TreeRangeMap$SubRangeMap$1$1, reason: invalid class name and collision with other inner class name */
            public class C03491 extends com.google.common.collect.AbstractIterator<java.util.Map.Entry<com.google.common.collect.Range<K>, V>> {
                public final /* synthetic */ java.util.Iterator u;

                public C03491(java.util.Iterator it) {
                    this.u = it;
                }

                @Override // com.google.common.collect.AbstractIterator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public java.util.Map.Entry<com.google.common.collect.Range<K>, V> computeNext() {
                    if (!this.u.hasNext()) {
                        return (java.util.Map.Entry) endOfData();
                    }
                    com.google.common.collect.TreeRangeMap.RangeMapEntry rangeMapEntry = (com.google.common.collect.TreeRangeMap.RangeMapEntry) this.u.next();
                    return rangeMapEntry.k().compareTo((com.google.common.collect.Cut) com.google.common.collect.TreeRangeMap.SubRangeMap.this.n.lowerBound) <= 0 ? (java.util.Map.Entry) endOfData() : com.google.common.collect.Maps.immutableEntry(rangeMapEntry.getKey().intersection(com.google.common.collect.TreeRangeMap.SubRangeMap.this.n), rangeMapEntry.getValue());
                }
            }

            public AnonymousClass1() {
                super();
            }

            @Override // com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap
            public java.util.Iterator<java.util.Map.Entry<com.google.common.collect.Range<K>, V>> b() {
                return com.google.common.collect.TreeRangeMap.SubRangeMap.this.n.isEmpty() ? com.google.common.collect.Iterators.f() : new com.google.common.collect.TreeRangeMap.SubRangeMap.AnonymousClass1.C03491(com.google.common.collect.TreeRangeMap.this.n.headMap(com.google.common.collect.TreeRangeMap.SubRangeMap.this.n.upperBound, false).descendingMap().values().iterator());
            }
        }

        public class SubRangeMapAsMap extends java.util.AbstractMap<com.google.common.collect.Range<K>, V> {

            /* renamed from: com.google.common.collect.TreeRangeMap$SubRangeMap$SubRangeMapAsMap$1, reason: invalid class name */
            public class AnonymousClass1 extends com.google.common.collect.Maps.KeySet<com.google.common.collect.Range<K>, V> {
                public AnonymousClass1(java.util.Map map) {
                    super(map);
                }

                @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
                    return com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap.this.remove(obj) != null;
                }

                @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean retainAll(java.util.Collection<?> collection) {
                    return com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap.this.d(com.google.common.base.Predicates.compose(com.google.common.base.Predicates.not(com.google.common.base.Predicates.in(collection)), com.google.common.collect.Maps.v()));
                }
            }

            /* renamed from: com.google.common.collect.TreeRangeMap$SubRangeMap$SubRangeMapAsMap$2, reason: invalid class name */
            public class AnonymousClass2 extends com.google.common.collect.Maps.EntrySet<com.google.common.collect.Range<K>, V> {
                public AnonymousClass2() {
                }

                @Override // com.google.common.collect.Maps.EntrySet
                public java.util.Map<com.google.common.collect.Range<K>, V> a() {
                    return com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap.this;
                }

                @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean isEmpty() {
                    return !iterator().hasNext();
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                public java.util.Iterator<java.util.Map.Entry<com.google.common.collect.Range<K>, V>> iterator() {
                    return com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap.this.b();
                }

                @Override // com.google.common.collect.Maps.EntrySet, com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean retainAll(java.util.Collection<?> collection) {
                    return com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap.this.d(com.google.common.base.Predicates.not(com.google.common.base.Predicates.in(collection)));
                }

                @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return com.google.common.collect.Iterators.size(iterator());
                }
            }

            /* renamed from: com.google.common.collect.TreeRangeMap$SubRangeMap$SubRangeMapAsMap$3, reason: invalid class name */
            public class AnonymousClass3 extends com.google.common.collect.AbstractIterator<java.util.Map.Entry<com.google.common.collect.Range<K>, V>> {
                public final /* synthetic */ java.util.Iterator u;

                public AnonymousClass3(java.util.Iterator it) {
                    this.u = it;
                }

                @Override // com.google.common.collect.AbstractIterator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public java.util.Map.Entry<com.google.common.collect.Range<K>, V> computeNext() {
                    while (this.u.hasNext()) {
                        com.google.common.collect.TreeRangeMap.RangeMapEntry rangeMapEntry = (com.google.common.collect.TreeRangeMap.RangeMapEntry) this.u.next();
                        if (rangeMapEntry.j().compareTo((com.google.common.collect.Cut) com.google.common.collect.TreeRangeMap.SubRangeMap.this.n.upperBound) >= 0) {
                            return (java.util.Map.Entry) endOfData();
                        }
                        if (rangeMapEntry.k().compareTo((com.google.common.collect.Cut) com.google.common.collect.TreeRangeMap.SubRangeMap.this.n.lowerBound) > 0) {
                            return com.google.common.collect.Maps.immutableEntry(rangeMapEntry.getKey().intersection(com.google.common.collect.TreeRangeMap.SubRangeMap.this.n), rangeMapEntry.getValue());
                        }
                    }
                    return (java.util.Map.Entry) endOfData();
                }
            }

            /* renamed from: com.google.common.collect.TreeRangeMap$SubRangeMap$SubRangeMapAsMap$4, reason: invalid class name */
            public class AnonymousClass4 extends com.google.common.collect.Maps.Values<com.google.common.collect.Range<K>, V> {
                public AnonymousClass4(java.util.Map map) {
                    super(map);
                }

                @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
                public boolean removeAll(java.util.Collection<?> collection) {
                    return com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap.this.d(com.google.common.base.Predicates.compose(com.google.common.base.Predicates.in(collection), com.google.common.collect.Maps.P()));
                }

                @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
                public boolean retainAll(java.util.Collection<?> collection) {
                    return com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap.this.d(com.google.common.base.Predicates.compose(com.google.common.base.Predicates.not(com.google.common.base.Predicates.in(collection)), com.google.common.collect.Maps.P()));
                }
            }

            public SubRangeMapAsMap() {
            }

            public java.util.Iterator<java.util.Map.Entry<com.google.common.collect.Range<K>, V>> b() {
                if (com.google.common.collect.TreeRangeMap.SubRangeMap.this.n.isEmpty()) {
                    return com.google.common.collect.Iterators.f();
                }
                return new com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap.AnonymousClass3(com.google.common.collect.TreeRangeMap.this.n.tailMap((com.google.common.collect.Cut) com.google.common.base.MoreObjects.firstNonNull(com.google.common.collect.TreeRangeMap.this.n.floorKey(com.google.common.collect.TreeRangeMap.SubRangeMap.this.n.lowerBound), com.google.common.collect.TreeRangeMap.SubRangeMap.this.n.lowerBound), true).values().iterator());
            }

            @Override // java.util.AbstractMap, java.util.Map
            public void clear() {
                com.google.common.collect.TreeRangeMap.SubRangeMap.this.clear();
            }

            @Override // java.util.AbstractMap, java.util.Map
            public boolean containsKey(java.lang.Object obj) {
                return get(obj) != null;
            }

            public final boolean d(com.google.common.base.Predicate<? super java.util.Map.Entry<com.google.common.collect.Range<K>, V>> predicate) {
                java.util.ArrayList newArrayList = com.google.common.collect.Lists.newArrayList();
                for (java.util.Map.Entry<com.google.common.collect.Range<K>, V> entry : entrySet()) {
                    if (predicate.apply(entry)) {
                        newArrayList.add(entry.getKey());
                    }
                }
                java.util.Iterator it = newArrayList.iterator();
                while (it.hasNext()) {
                    com.google.common.collect.TreeRangeMap.this.remove((com.google.common.collect.Range) it.next());
                }
                return !newArrayList.isEmpty();
            }

            @Override // java.util.AbstractMap, java.util.Map
            public java.util.Set<java.util.Map.Entry<com.google.common.collect.Range<K>, V>> entrySet() {
                return new com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap.AnonymousClass2();
            }

            @Override // java.util.AbstractMap, java.util.Map
            public V get(java.lang.Object obj) {
                com.google.common.collect.TreeRangeMap.RangeMapEntry rangeMapEntry;
                try {
                    if (obj instanceof com.google.common.collect.Range) {
                        com.google.common.collect.Range range = (com.google.common.collect.Range) obj;
                        if (com.google.common.collect.TreeRangeMap.SubRangeMap.this.n.encloses(range) && !range.isEmpty()) {
                            if (range.lowerBound.compareTo((com.google.common.collect.Cut) com.google.common.collect.TreeRangeMap.SubRangeMap.this.n.lowerBound) == 0) {
                                java.util.Map.Entry floorEntry = com.google.common.collect.TreeRangeMap.this.n.floorEntry(range.lowerBound);
                                rangeMapEntry = floorEntry != null ? (com.google.common.collect.TreeRangeMap.RangeMapEntry) floorEntry.getValue() : null;
                            } else {
                                rangeMapEntry = (com.google.common.collect.TreeRangeMap.RangeMapEntry) com.google.common.collect.TreeRangeMap.this.n.get(range.lowerBound);
                            }
                            if (rangeMapEntry != null && rangeMapEntry.getKey().isConnected(com.google.common.collect.TreeRangeMap.SubRangeMap.this.n) && rangeMapEntry.getKey().intersection(com.google.common.collect.TreeRangeMap.SubRangeMap.this.n).equals(range)) {
                                return (V) rangeMapEntry.getValue();
                            }
                        }
                    }
                } catch (java.lang.ClassCastException unused) {
                }
                return null;
            }

            @Override // java.util.AbstractMap, java.util.Map
            public java.util.Set<com.google.common.collect.Range<K>> keySet() {
                return new com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap.AnonymousClass1(this);
            }

            @Override // java.util.AbstractMap, java.util.Map
            public V remove(java.lang.Object obj) {
                V v = (V) get(obj);
                if (v == null) {
                    return null;
                }
                com.google.common.collect.TreeRangeMap.this.remove((com.google.common.collect.Range) obj);
                return v;
            }

            @Override // java.util.AbstractMap, java.util.Map
            public java.util.Collection<V> values() {
                return new com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap.AnonymousClass4(this);
            }
        }

        public SubRangeMap(com.google.common.collect.Range<K> range) {
            this.n = range;
        }

        @Override // com.google.common.collect.RangeMap
        public java.util.Map<com.google.common.collect.Range<K>, V> asDescendingMapOfRanges() {
            return new com.google.common.collect.TreeRangeMap.SubRangeMap.AnonymousClass1();
        }

        @Override // com.google.common.collect.RangeMap
        public java.util.Map<com.google.common.collect.Range<K>, V> asMapOfRanges() {
            return new com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap();
        }

        @Override // com.google.common.collect.RangeMap
        public void clear() {
            com.google.common.collect.TreeRangeMap.this.remove(this.n);
        }

        @Override // com.google.common.collect.RangeMap
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (obj instanceof com.google.common.collect.RangeMap) {
                return asMapOfRanges().equals(((com.google.common.collect.RangeMap) obj).asMapOfRanges());
            }
            return false;
        }

        @Override // com.google.common.collect.RangeMap
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public V get(K k) {
            if (this.n.contains(k)) {
                return (V) com.google.common.collect.TreeRangeMap.this.get(k);
            }
            return null;
        }

        @Override // com.google.common.collect.RangeMap
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public java.util.Map.Entry<com.google.common.collect.Range<K>, V> getEntry(K k) {
            java.util.Map.Entry<com.google.common.collect.Range<K>, V> entry;
            if (!this.n.contains(k) || (entry = com.google.common.collect.TreeRangeMap.this.getEntry(k)) == null) {
                return null;
            }
            return com.google.common.collect.Maps.immutableEntry(entry.getKey().intersection(this.n), entry.getValue());
        }

        @Override // com.google.common.collect.RangeMap
        public int hashCode() {
            return asMapOfRanges().hashCode();
        }

        @Override // com.google.common.collect.RangeMap
        public void put(com.google.common.collect.Range<K> range, V v) {
            com.google.common.base.Preconditions.checkArgument(this.n.encloses(range), "Cannot put range %s into a subRangeMap(%s)", range, this.n);
            com.google.common.collect.TreeRangeMap.this.put(range, v);
        }

        @Override // com.google.common.collect.RangeMap
        public void putAll(com.google.common.collect.RangeMap<K, V> rangeMap) {
            if (rangeMap.asMapOfRanges().isEmpty()) {
                return;
            }
            com.google.common.collect.Range<K> span = rangeMap.span();
            com.google.common.base.Preconditions.checkArgument(this.n.encloses(span), "Cannot putAll rangeMap with span %s into a subRangeMap(%s)", span, this.n);
            com.google.common.collect.TreeRangeMap.this.putAll(rangeMap);
        }

        @Override // com.google.common.collect.RangeMap
        public void putCoalescing(com.google.common.collect.Range<K> range, V v) {
            if (com.google.common.collect.TreeRangeMap.this.n.isEmpty() || range.isEmpty() || !this.n.encloses(range)) {
                put(range, v);
            } else {
                put(com.google.common.collect.TreeRangeMap.this.e(range, com.google.common.base.Preconditions.checkNotNull(v)).intersection(this.n), v);
            }
        }

        @Override // com.google.common.collect.RangeMap
        public void remove(com.google.common.collect.Range<K> range) {
            if (range.isConnected(this.n)) {
                com.google.common.collect.TreeRangeMap.this.remove(range.intersection(this.n));
            }
        }

        @Override // com.google.common.collect.RangeMap
        public com.google.common.collect.Range<K> span() {
            com.google.common.collect.Cut<K> cut;
            java.util.Map.Entry floorEntry = com.google.common.collect.TreeRangeMap.this.n.floorEntry(this.n.lowerBound);
            if (floorEntry == null || ((com.google.common.collect.TreeRangeMap.RangeMapEntry) floorEntry.getValue()).k().compareTo((com.google.common.collect.Cut) this.n.lowerBound) <= 0) {
                cut = (com.google.common.collect.Cut) com.google.common.collect.TreeRangeMap.this.n.ceilingKey(this.n.lowerBound);
                if (cut == null || cut.compareTo(this.n.upperBound) >= 0) {
                    throw new java.util.NoSuchElementException();
                }
            } else {
                cut = this.n.lowerBound;
            }
            java.util.Map.Entry lowerEntry = com.google.common.collect.TreeRangeMap.this.n.lowerEntry(this.n.upperBound);
            if (lowerEntry != null) {
                return com.google.common.collect.Range.create(cut, ((com.google.common.collect.TreeRangeMap.RangeMapEntry) lowerEntry.getValue()).k().compareTo((com.google.common.collect.Cut) this.n.upperBound) >= 0 ? this.n.upperBound : ((com.google.common.collect.TreeRangeMap.RangeMapEntry) lowerEntry.getValue()).k());
            }
            throw new java.util.NoSuchElementException();
        }

        @Override // com.google.common.collect.RangeMap
        public com.google.common.collect.RangeMap<K, V> subRangeMap(com.google.common.collect.Range<K> range) {
            return !range.isConnected(this.n) ? com.google.common.collect.TreeRangeMap.this.f() : com.google.common.collect.TreeRangeMap.this.subRangeMap(range.intersection(this.n));
        }

        @Override // com.google.common.collect.RangeMap
        public java.lang.String toString() {
            return asMapOfRanges().toString();
        }
    }

    public static <K extends java.lang.Comparable, V> com.google.common.collect.TreeRangeMap<K, V> create() {
        return new com.google.common.collect.TreeRangeMap<>();
    }

    public static <K extends java.lang.Comparable, V> com.google.common.collect.Range<K> d(com.google.common.collect.Range<K> range, V v, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.util.Map.Entry<com.google.common.collect.Cut<K>, com.google.common.collect.TreeRangeMap.RangeMapEntry<K, V>> entry) {
        return (entry != null && entry.getValue().getKey().isConnected(range) && entry.getValue().getValue().equals(v)) ? range.span(entry.getValue().getKey()) : range;
    }

    @Override // com.google.common.collect.RangeMap
    public java.util.Map<com.google.common.collect.Range<K>, V> asDescendingMapOfRanges() {
        return new com.google.common.collect.TreeRangeMap.AsMapOfRanges(this.n.descendingMap().values());
    }

    @Override // com.google.common.collect.RangeMap
    public java.util.Map<com.google.common.collect.Range<K>, V> asMapOfRanges() {
        return new com.google.common.collect.TreeRangeMap.AsMapOfRanges(this.n.values());
    }

    @Override // com.google.common.collect.RangeMap
    public void clear() {
        this.n.clear();
    }

    public final com.google.common.collect.Range<K> e(com.google.common.collect.Range<K> range, V v) {
        return d(d(range, v, this.n.lowerEntry(range.lowerBound)), v, this.n.floorEntry(range.upperBound));
    }

    @Override // com.google.common.collect.RangeMap
    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj instanceof com.google.common.collect.RangeMap) {
            return asMapOfRanges().equals(((com.google.common.collect.RangeMap) obj).asMapOfRanges());
        }
        return false;
    }

    public final com.google.common.collect.RangeMap<K, V> f() {
        return t;
    }

    public final void g(com.google.common.collect.Cut<K> cut, com.google.common.collect.Cut<K> cut2, V v) {
        this.n.put(cut, new com.google.common.collect.TreeRangeMap.RangeMapEntry<>(cut, cut2, v));
    }

    @Override // com.google.common.collect.RangeMap
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public V get(K k) {
        java.util.Map.Entry<com.google.common.collect.Range<K>, V> entry = getEntry(k);
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    @Override // com.google.common.collect.RangeMap
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public java.util.Map.Entry<com.google.common.collect.Range<K>, V> getEntry(K k) {
        java.util.Map.Entry<com.google.common.collect.Cut<K>, com.google.common.collect.TreeRangeMap.RangeMapEntry<K, V>> floorEntry = this.n.floorEntry(com.google.common.collect.Cut.belowValue(k));
        if (floorEntry == null || !floorEntry.getValue().a(k)) {
            return null;
        }
        return floorEntry.getValue();
    }

    @Override // com.google.common.collect.RangeMap
    public int hashCode() {
        return asMapOfRanges().hashCode();
    }

    @Override // com.google.common.collect.RangeMap
    public void put(com.google.common.collect.Range<K> range, V v) {
        if (range.isEmpty()) {
            return;
        }
        com.google.common.base.Preconditions.checkNotNull(v);
        remove(range);
        this.n.put(range.lowerBound, new com.google.common.collect.TreeRangeMap.RangeMapEntry<>(range, v));
    }

    @Override // com.google.common.collect.RangeMap
    public void putAll(com.google.common.collect.RangeMap<K, V> rangeMap) {
        for (java.util.Map.Entry<com.google.common.collect.Range<K>, V> entry : rangeMap.asMapOfRanges().entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.RangeMap
    public void putCoalescing(com.google.common.collect.Range<K> range, V v) {
        if (this.n.isEmpty()) {
            put(range, v);
        } else {
            put(e(range, com.google.common.base.Preconditions.checkNotNull(v)), v);
        }
    }

    @Override // com.google.common.collect.RangeMap
    public void remove(com.google.common.collect.Range<K> range) {
        if (range.isEmpty()) {
            return;
        }
        java.util.Map.Entry<com.google.common.collect.Cut<K>, com.google.common.collect.TreeRangeMap.RangeMapEntry<K, V>> lowerEntry = this.n.lowerEntry(range.lowerBound);
        if (lowerEntry != null) {
            com.google.common.collect.TreeRangeMap.RangeMapEntry<K, V> value = lowerEntry.getValue();
            if (value.k().compareTo(range.lowerBound) > 0) {
                if (value.k().compareTo(range.upperBound) > 0) {
                    g(range.upperBound, value.k(), lowerEntry.getValue().getValue());
                }
                g(value.j(), range.lowerBound, lowerEntry.getValue().getValue());
            }
        }
        java.util.Map.Entry<com.google.common.collect.Cut<K>, com.google.common.collect.TreeRangeMap.RangeMapEntry<K, V>> lowerEntry2 = this.n.lowerEntry(range.upperBound);
        if (lowerEntry2 != null) {
            com.google.common.collect.TreeRangeMap.RangeMapEntry<K, V> value2 = lowerEntry2.getValue();
            if (value2.k().compareTo(range.upperBound) > 0) {
                g(range.upperBound, value2.k(), lowerEntry2.getValue().getValue());
            }
        }
        this.n.subMap(range.lowerBound, range.upperBound).clear();
    }

    @Override // com.google.common.collect.RangeMap
    public com.google.common.collect.Range<K> span() {
        java.util.Map.Entry<com.google.common.collect.Cut<K>, com.google.common.collect.TreeRangeMap.RangeMapEntry<K, V>> firstEntry = this.n.firstEntry();
        java.util.Map.Entry<com.google.common.collect.Cut<K>, com.google.common.collect.TreeRangeMap.RangeMapEntry<K, V>> lastEntry = this.n.lastEntry();
        if (firstEntry != null) {
            return com.google.common.collect.Range.create(firstEntry.getValue().getKey().lowerBound, lastEntry.getValue().getKey().upperBound);
        }
        throw new java.util.NoSuchElementException();
    }

    @Override // com.google.common.collect.RangeMap
    public com.google.common.collect.RangeMap<K, V> subRangeMap(com.google.common.collect.Range<K> range) {
        return range.equals(com.google.common.collect.Range.all()) ? this : new com.google.common.collect.TreeRangeMap.SubRangeMap(range);
    }

    @Override // com.google.common.collect.RangeMap
    public java.lang.String toString() {
        return this.n.values().toString();
    }
}
