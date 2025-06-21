package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public final class Maps {

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* renamed from: com.google.common.collect.Maps$1, reason: invalid class name */
    public static class AnonymousClass1<K, V> extends com.google.common.collect.TransformedIterator<java.util.Map.Entry<K, V>, K> {
        public AnonymousClass1(java.util.Iterator it) {
            super(it);
        }

        @Override // com.google.common.collect.TransformedIterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public K a(java.util.Map.Entry<K, V> entry) {
            return entry.getKey();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V1, V2] */
    /* renamed from: com.google.common.collect.Maps$10, reason: invalid class name */
    public static class AnonymousClass10<V1, V2> implements com.google.common.base.Function<V1, V2> {
        public final /* synthetic */ com.google.common.collect.Maps.EntryTransformer n;
        public final /* synthetic */ java.lang.Object t;

        public AnonymousClass10(com.google.common.collect.Maps.EntryTransformer entryTransformer, java.lang.Object obj) {
            this.n = entryTransformer;
            this.t = obj;
        }

        @Override // com.google.common.base.Function
        public V2 apply(@org.checkerframework.checker.nullness.compatqual.NullableDecl V1 v1) {
            return (V2) this.n.transformEntry(this.t, v1);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [K, V1, V2] */
    /* renamed from: com.google.common.collect.Maps$11, reason: invalid class name */
    public static class AnonymousClass11<K, V1, V2> implements com.google.common.base.Function<java.util.Map.Entry<K, V1>, V2> {
        public final /* synthetic */ com.google.common.collect.Maps.EntryTransformer n;

        public AnonymousClass11(com.google.common.collect.Maps.EntryTransformer entryTransformer) {
            this.n = entryTransformer;
        }

        @Override // com.google.common.base.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public V2 apply(java.util.Map.Entry<K, V1> entry) {
            return (V2) this.n.transformEntry(entry.getKey(), entry.getValue());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [K, V2] */
    /* renamed from: com.google.common.collect.Maps$12, reason: invalid class name */
    public static class AnonymousClass12<K, V2> extends com.google.common.collect.AbstractMapEntry<K, V2> {
        public final /* synthetic */ java.util.Map.Entry n;
        public final /* synthetic */ com.google.common.collect.Maps.EntryTransformer t;

        public AnonymousClass12(java.util.Map.Entry entry, com.google.common.collect.Maps.EntryTransformer entryTransformer) {
            this.n = entry;
            this.t = entryTransformer;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public K getKey() {
            return (K) this.n.getKey();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V2 getValue() {
            return (V2) this.t.transformEntry(this.n.getKey(), this.n.getValue());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [K, V1, V2] */
    /* renamed from: com.google.common.collect.Maps$13, reason: invalid class name */
    public static class AnonymousClass13<K, V1, V2> implements com.google.common.base.Function<java.util.Map.Entry<K, V1>, java.util.Map.Entry<K, V2>> {
        public final /* synthetic */ com.google.common.collect.Maps.EntryTransformer n;

        public AnonymousClass13(com.google.common.collect.Maps.EntryTransformer entryTransformer) {
            this.n = entryTransformer;
        }

        @Override // com.google.common.base.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.util.Map.Entry<K, V2> apply(java.util.Map.Entry<K, V1> entry) {
            return com.google.common.collect.Maps.J(this.n, entry);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* renamed from: com.google.common.collect.Maps$2, reason: invalid class name */
    public static class AnonymousClass2<K, V> extends com.google.common.collect.TransformedIterator<java.util.Map.Entry<K, V>, V> {
        public AnonymousClass2(java.util.Iterator it) {
            super(it);
        }

        @Override // com.google.common.collect.TransformedIterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public V a(java.util.Map.Entry<K, V> entry) {
            return entry.getValue();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* renamed from: com.google.common.collect.Maps$3, reason: invalid class name */
    public static class AnonymousClass3<K, V> extends com.google.common.collect.TransformedIterator<K, java.util.Map.Entry<K, V>> {
        public final /* synthetic */ com.google.common.base.Function t;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(java.util.Iterator it, com.google.common.base.Function function) {
            super(it);
            this.t = function;
        }

        @Override // com.google.common.collect.TransformedIterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public java.util.Map.Entry<K, V> a(K k) {
            return com.google.common.collect.Maps.immutableEntry(k, this.t.apply(k));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* renamed from: com.google.common.collect.Maps$4, reason: invalid class name */
    public static class AnonymousClass4<E> extends com.google.common.collect.ForwardingSet<E> {
        public final /* synthetic */ java.util.Set n;

        public AnonymousClass4(java.util.Set set) {
            this.n = set;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
        public boolean add(E e) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean addAll(java.util.Collection<? extends E> collection) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public java.util.Set<E> delegate() {
            return this.n;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* renamed from: com.google.common.collect.Maps$5, reason: invalid class name */
    public static class AnonymousClass5<E> extends com.google.common.collect.ForwardingSortedSet<E> {
        public final /* synthetic */ java.util.SortedSet n;

        public AnonymousClass5(java.util.SortedSet sortedSet) {
            this.n = sortedSet;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
        public boolean add(E e) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean addAll(java.util.Collection<? extends E> collection) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public java.util.SortedSet<E> delegate() {
            return this.n;
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public java.util.SortedSet<E> headSet(E e) {
            return com.google.common.collect.Maps.E(super.headSet(e));
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public java.util.SortedSet<E> subSet(E e, E e2) {
            return com.google.common.collect.Maps.E(super.subSet(e, e2));
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public java.util.SortedSet<E> tailSet(E e) {
            return com.google.common.collect.Maps.E(super.tailSet(e));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* renamed from: com.google.common.collect.Maps$6, reason: invalid class name */
    public static class AnonymousClass6<E> extends com.google.common.collect.ForwardingNavigableSet<E> {
        public final /* synthetic */ java.util.NavigableSet n;

        public AnonymousClass6(java.util.NavigableSet navigableSet) {
            this.n = navigableSet;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
        public boolean add(E e) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean addAll(java.util.Collection<? extends E> collection) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public java.util.NavigableSet<E> delegate() {
            return this.n;
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public java.util.NavigableSet<E> descendingSet() {
            return com.google.common.collect.Maps.C(super.descendingSet());
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public java.util.NavigableSet<E> headSet(E e, boolean z) {
            return com.google.common.collect.Maps.C(super.headSet(e, z));
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public java.util.SortedSet<E> headSet(E e) {
            return com.google.common.collect.Maps.E(super.headSet(e));
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public java.util.NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
            return com.google.common.collect.Maps.C(super.subSet(e, z, e2, z2));
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public java.util.SortedSet<E> subSet(E e, E e2) {
            return com.google.common.collect.Maps.E(super.subSet(e, e2));
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public java.util.NavigableSet<E> tailSet(E e, boolean z) {
            return com.google.common.collect.Maps.C(super.tailSet(e, z));
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public java.util.SortedSet<E> tailSet(E e) {
            return com.google.common.collect.Maps.E(super.tailSet(e));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* renamed from: com.google.common.collect.Maps$7, reason: invalid class name */
    public static class AnonymousClass7<K, V> extends com.google.common.collect.AbstractMapEntry<K, V> {
        public final /* synthetic */ java.util.Map.Entry n;

        public AnonymousClass7(java.util.Map.Entry entry) {
            this.n = entry;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public K getKey() {
            return (K) this.n.getKey();
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V getValue() {
            return (V) this.n.getValue();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* renamed from: com.google.common.collect.Maps$8, reason: invalid class name */
    public static class AnonymousClass8<K, V> extends com.google.common.collect.UnmodifiableIterator<java.util.Map.Entry<K, V>> {
        public final /* synthetic */ java.util.Iterator n;

        public AnonymousClass8(java.util.Iterator it) {
            this.n = it;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.util.Map.Entry<K, V> next() {
            return com.google.common.collect.Maps.K((java.util.Map.Entry) this.n.next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.n.hasNext();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [K, V1, V2] */
    /* renamed from: com.google.common.collect.Maps$9, reason: invalid class name */
    public static class AnonymousClass9<K, V1, V2> implements com.google.common.collect.Maps.EntryTransformer<K, V1, V2> {
        public final /* synthetic */ com.google.common.base.Function a;

        public AnonymousClass9(com.google.common.base.Function function) {
            this.a = function;
        }

        @Override // com.google.common.collect.Maps.EntryTransformer
        public V2 transformEntry(K k, V1 v1) {
            return (V2) this.a.apply(v1);
        }
    }

    public static abstract class AbstractFilteredMap<K, V> extends com.google.common.collect.Maps.ViewCachingAbstractMap<K, V> {
        public final java.util.Map<K, V> v;
        public final com.google.common.base.Predicate<? super java.util.Map.Entry<K, V>> w;

        public AbstractFilteredMap(java.util.Map<K, V> map, com.google.common.base.Predicate<? super java.util.Map.Entry<K, V>> predicate) {
            this.v = map;
            this.w = predicate;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(java.lang.Object obj) {
            return this.v.containsKey(obj) && e(obj, this.v.get(obj));
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public java.util.Collection<V> d() {
            return new com.google.common.collect.Maps.FilteredMapValues(this, this.v, this.w);
        }

        public boolean e(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
            return this.w.apply(com.google.common.collect.Maps.immutableEntry(obj, v));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(java.lang.Object obj) {
            V v = this.v.get(obj);
            if (v == null || !e(obj, v)) {
                return null;
            }
            return v;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return entrySet().isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K k, V v) {
            com.google.common.base.Preconditions.checkArgument(e(k, v));
            return this.v.put(k, v);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void putAll(java.util.Map<? extends K, ? extends V> map) {
            for (java.util.Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
                com.google.common.base.Preconditions.checkArgument(e(entry.getKey(), entry.getValue()));
            }
            this.v.putAll(map);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(java.lang.Object obj) {
            if (containsKey(obj)) {
                return this.v.remove(obj);
            }
            return null;
        }
    }

    public static class AsMapView<K, V> extends com.google.common.collect.Maps.ViewCachingAbstractMap<K, V> {
        public final java.util.Set<K> v;
        public final com.google.common.base.Function<? super K, V> w;

        /* renamed from: com.google.common.collect.Maps$AsMapView$1EntrySetImpl, reason: invalid class name */
        public class C1EntrySetImpl extends com.google.common.collect.Maps.EntrySet<K, V> {
            public C1EntrySetImpl() {
            }

            @Override // com.google.common.collect.Maps.EntrySet
            public java.util.Map<K, V> a() {
                return com.google.common.collect.Maps.AsMapView.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public java.util.Iterator<java.util.Map.Entry<K, V>> iterator() {
                return com.google.common.collect.Maps.i(com.google.common.collect.Maps.AsMapView.this.e(), com.google.common.collect.Maps.AsMapView.this.w);
            }
        }

        public AsMapView(java.util.Set<K> set, com.google.common.base.Function<? super K, V> function) {
            this.v = (java.util.Set) com.google.common.base.Preconditions.checkNotNull(set);
            this.w = (com.google.common.base.Function) com.google.common.base.Preconditions.checkNotNull(function);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public java.util.Set<java.util.Map.Entry<K, V>> a() {
            return new com.google.common.collect.Maps.AsMapView.C1EntrySetImpl();
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        /* renamed from: b */
        public java.util.Set<K> h() {
            return com.google.common.collect.Maps.D(e());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            e().clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return e().contains(obj);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public java.util.Collection<V> d() {
            return com.google.common.collect.Collections2.transform(this.v, this.w);
        }

        public java.util.Set<K> e() {
            return this.v;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (com.google.common.collect.Collections2.g(e(), obj)) {
                return this.w.apply(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (e().remove(obj)) {
                return this.w.apply(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return e().size();
        }
    }

    public static final class BiMapConverter<A, B> extends com.google.common.base.Converter<A, B> implements java.io.Serializable {
        private static final long serialVersionUID = 0;
        private final com.google.common.collect.BiMap<A, B> bimap;

        public BiMapConverter(com.google.common.collect.BiMap<A, B> biMap) {
            this.bimap = (com.google.common.collect.BiMap) com.google.common.base.Preconditions.checkNotNull(biMap);
        }

        private static <X, Y> Y convert(com.google.common.collect.BiMap<X, Y> biMap, X x) {
            Y y = biMap.get(x);
            com.google.common.base.Preconditions.checkArgument(y != null, "No non-null mapping present for input: %s", x);
            return y;
        }

        @Override // com.google.common.base.Converter
        public A doBackward(B b) {
            return (A) convert(this.bimap.inverse(), b);
        }

        @Override // com.google.common.base.Converter
        public B doForward(A a) {
            return (B) convert(this.bimap, a);
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (obj instanceof com.google.common.collect.Maps.BiMapConverter) {
                return this.bimap.equals(((com.google.common.collect.Maps.BiMapConverter) obj).bimap);
            }
            return false;
        }

        public int hashCode() {
            return this.bimap.hashCode();
        }

        public java.lang.String toString() {
            return "Maps.asConverter(" + this.bimap + ")";
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static abstract class DescendingMap<K, V> extends com.google.common.collect.ForwardingMap<K, V> implements java.util.NavigableMap<K, V> {

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        public transient java.util.Comparator<? super K> n;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        public transient java.util.Set<java.util.Map.Entry<K, V>> t;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        public transient java.util.NavigableSet<K> u;

        /* renamed from: com.google.common.collect.Maps$DescendingMap$1EntrySetImpl, reason: invalid class name */
        public class C1EntrySetImpl extends com.google.common.collect.Maps.EntrySet<K, V> {
            public C1EntrySetImpl() {
            }

            @Override // com.google.common.collect.Maps.EntrySet
            public java.util.Map<K, V> a() {
                return com.google.common.collect.Maps.DescendingMap.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public java.util.Iterator<java.util.Map.Entry<K, V>> iterator() {
                return com.google.common.collect.Maps.DescendingMap.this.entryIterator();
            }
        }

        public static <T> com.google.common.collect.Ordering<T> m(java.util.Comparator<T> comparator) {
            return com.google.common.collect.Ordering.from(comparator).reverse();
        }

        @Override // java.util.NavigableMap
        public java.util.Map.Entry<K, V> ceilingEntry(K k) {
            return l().floorEntry(k);
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k) {
            return l().floorKey(k);
        }

        @Override // java.util.SortedMap
        public java.util.Comparator<? super K> comparator() {
            java.util.Comparator<? super K> comparator = this.n;
            if (comparator != null) {
                return comparator;
            }
            java.util.Comparator<? super K> comparator2 = l().comparator();
            if (comparator2 == null) {
                comparator2 = com.google.common.collect.Ordering.natural();
            }
            com.google.common.collect.Ordering m = m(comparator2);
            this.n = m;
            return m;
        }

        @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public final java.util.Map<K, V> delegate() {
            return l();
        }

        @Override // java.util.NavigableMap
        public java.util.NavigableSet<K> descendingKeySet() {
            return l().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public java.util.NavigableMap<K, V> descendingMap() {
            return l();
        }

        public abstract java.util.Iterator<java.util.Map.Entry<K, V>> entryIterator();

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public java.util.Set<java.util.Map.Entry<K, V>> entrySet() {
            java.util.Set<java.util.Map.Entry<K, V>> set = this.t;
            if (set != null) {
                return set;
            }
            java.util.Set<java.util.Map.Entry<K, V>> k = k();
            this.t = k;
            return k;
        }

        @Override // java.util.NavigableMap
        public java.util.Map.Entry<K, V> firstEntry() {
            return l().lastEntry();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return l().lastKey();
        }

        @Override // java.util.NavigableMap
        public java.util.Map.Entry<K, V> floorEntry(K k) {
            return l().ceilingEntry(k);
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k) {
            return l().ceilingKey(k);
        }

        @Override // java.util.NavigableMap
        public java.util.NavigableMap<K, V> headMap(K k, boolean z) {
            return l().tailMap(k, z).descendingMap();
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public java.util.SortedMap<K, V> headMap(K k) {
            return headMap(k, false);
        }

        @Override // java.util.NavigableMap
        public java.util.Map.Entry<K, V> higherEntry(K k) {
            return l().lowerEntry(k);
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k) {
            return l().lowerKey(k);
        }

        public java.util.Set<java.util.Map.Entry<K, V>> k() {
            return new com.google.common.collect.Maps.DescendingMap.C1EntrySetImpl();
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public java.util.Set<K> keySet() {
            return navigableKeySet();
        }

        public abstract java.util.NavigableMap<K, V> l();

        @Override // java.util.NavigableMap
        public java.util.Map.Entry<K, V> lastEntry() {
            return l().firstEntry();
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return l().firstKey();
        }

        @Override // java.util.NavigableMap
        public java.util.Map.Entry<K, V> lowerEntry(K k) {
            return l().higherEntry(k);
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k) {
            return l().higherKey(k);
        }

        @Override // java.util.NavigableMap
        public java.util.NavigableSet<K> navigableKeySet() {
            java.util.NavigableSet<K> navigableSet = this.u;
            if (navigableSet != null) {
                return navigableSet;
            }
            com.google.common.collect.Maps.NavigableKeySet navigableKeySet = new com.google.common.collect.Maps.NavigableKeySet(this);
            this.u = navigableKeySet;
            return navigableKeySet;
        }

        @Override // java.util.NavigableMap
        public java.util.Map.Entry<K, V> pollFirstEntry() {
            return l().pollLastEntry();
        }

        @Override // java.util.NavigableMap
        public java.util.Map.Entry<K, V> pollLastEntry() {
            return l().pollFirstEntry();
        }

        @Override // java.util.NavigableMap
        public java.util.NavigableMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
            return l().subMap(k2, z2, k, z).descendingMap();
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public java.util.SortedMap<K, V> subMap(K k, K k2) {
            return subMap(k, true, k2, false);
        }

        @Override // java.util.NavigableMap
        public java.util.NavigableMap<K, V> tailMap(K k, boolean z) {
            return l().headMap(k, z).descendingMap();
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public java.util.SortedMap<K, V> tailMap(K k) {
            return tailMap(k, true);
        }

        @Override // com.google.common.collect.ForwardingObject
        public java.lang.String toString() {
            return standardToString();
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public java.util.Collection<V> values() {
            return new com.google.common.collect.Maps.Values(this);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class EntryFunction implements com.google.common.base.Function<java.util.Map.Entry<?, ?>, java.lang.Object> {
        private static final /* synthetic */ com.google.common.collect.Maps.EntryFunction[] $VALUES;
        public static final com.google.common.collect.Maps.EntryFunction KEY;
        public static final com.google.common.collect.Maps.EntryFunction VALUE;

        /* renamed from: com.google.common.collect.Maps$EntryFunction$1, reason: invalid class name */
        public enum AnonymousClass1 extends com.google.common.collect.Maps.EntryFunction {
            public AnonymousClass1(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.base.Function
            @org.checkerframework.checker.nullness.compatqual.NullableDecl
            public java.lang.Object apply(java.util.Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        }

        /* renamed from: com.google.common.collect.Maps$EntryFunction$2, reason: invalid class name */
        public enum AnonymousClass2 extends com.google.common.collect.Maps.EntryFunction {
            public AnonymousClass2(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.base.Function
            @org.checkerframework.checker.nullness.compatqual.NullableDecl
            public java.lang.Object apply(java.util.Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        }

        static {
            com.google.common.collect.Maps.EntryFunction.AnonymousClass1 anonymousClass1 = new com.google.common.collect.Maps.EntryFunction.AnonymousClass1("KEY", 0);
            KEY = anonymousClass1;
            com.google.common.collect.Maps.EntryFunction.AnonymousClass2 anonymousClass2 = new com.google.common.collect.Maps.EntryFunction.AnonymousClass2("VALUE", 1);
            VALUE = anonymousClass2;
            $VALUES = new com.google.common.collect.Maps.EntryFunction[]{anonymousClass1, anonymousClass2};
        }

        private EntryFunction(java.lang.String str, int i) {
        }

        public /* synthetic */ EntryFunction(java.lang.String str, int i, com.google.common.collect.Maps.AnonymousClass1 anonymousClass1) {
            this(str, i);
        }

        public static com.google.common.collect.Maps.EntryFunction valueOf(java.lang.String str) {
            return (com.google.common.collect.Maps.EntryFunction) java.lang.Enum.valueOf(com.google.common.collect.Maps.EntryFunction.class, str);
        }

        public static com.google.common.collect.Maps.EntryFunction[] values() {
            return (com.google.common.collect.Maps.EntryFunction[]) $VALUES.clone();
        }
    }

    public static abstract class EntrySet<K, V> extends com.google.common.collect.Sets.ImprovedAbstractSet<java.util.Map.Entry<K, V>> {
        public abstract java.util.Map<K, V> a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(java.lang.Object obj) {
            if (!(obj instanceof java.util.Map.Entry)) {
                return false;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            java.lang.Object key = entry.getKey();
            java.lang.Object G = com.google.common.collect.Maps.G(a(), key);
            if (com.google.common.base.Objects.equal(G, entry.getValue())) {
                return G != null || a().containsKey(key);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(java.lang.Object obj) {
            if (contains(obj)) {
                return a().keySet().remove(((java.util.Map.Entry) obj).getKey());
            }
            return false;
        }

        @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(java.util.Collection<?> collection) {
            try {
                return super.removeAll((java.util.Collection) com.google.common.base.Preconditions.checkNotNull(collection));
            } catch (java.lang.UnsupportedOperationException unused) {
                return com.google.common.collect.Sets.e(this, collection.iterator());
            }
        }

        @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(java.util.Collection<?> collection) {
            try {
                return super.retainAll((java.util.Collection) com.google.common.base.Preconditions.checkNotNull(collection));
            } catch (java.lang.UnsupportedOperationException unused) {
                java.util.HashSet newHashSetWithExpectedSize = com.google.common.collect.Sets.newHashSetWithExpectedSize(collection.size());
                for (java.lang.Object obj : collection) {
                    if (contains(obj)) {
                        newHashSetWithExpectedSize.add(((java.util.Map.Entry) obj).getKey());
                    }
                }
                return a().keySet().retainAll(newHashSetWithExpectedSize);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a().size();
        }
    }

    public interface EntryTransformer<K, V1, V2> {
        V2 transformEntry(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k, @org.checkerframework.checker.nullness.compatqual.NullableDecl V1 v1);
    }

    public static final class FilteredEntryBiMap<K, V> extends com.google.common.collect.Maps.FilteredEntryMap<K, V> implements com.google.common.collect.BiMap<K, V> {

        @com.google.j2objc.annotations.RetainedWith
        public final com.google.common.collect.BiMap<V, K> y;

        /* renamed from: com.google.common.collect.Maps$FilteredEntryBiMap$1, reason: invalid class name */
        public static class AnonymousClass1 implements com.google.common.base.Predicate<java.util.Map.Entry<V, K>> {
            public final /* synthetic */ com.google.common.base.Predicate n;

            public AnonymousClass1(com.google.common.base.Predicate predicate) {
                this.n = predicate;
            }

            @Override // com.google.common.base.Predicate
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean apply(java.util.Map.Entry<V, K> entry) {
                return this.n.apply(com.google.common.collect.Maps.immutableEntry(entry.getValue(), entry.getKey()));
            }
        }

        public FilteredEntryBiMap(com.google.common.collect.BiMap<K, V> biMap, com.google.common.base.Predicate<? super java.util.Map.Entry<K, V>> predicate) {
            super(biMap, predicate);
            this.y = new com.google.common.collect.Maps.FilteredEntryBiMap(biMap.inverse(), h(predicate), this);
        }

        public FilteredEntryBiMap(com.google.common.collect.BiMap<K, V> biMap, com.google.common.base.Predicate<? super java.util.Map.Entry<K, V>> predicate, com.google.common.collect.BiMap<V, K> biMap2) {
            super(biMap, predicate);
            this.y = biMap2;
        }

        public static <K, V> com.google.common.base.Predicate<java.util.Map.Entry<V, K>> h(com.google.common.base.Predicate<? super java.util.Map.Entry<K, V>> predicate) {
            return new com.google.common.collect.Maps.FilteredEntryBiMap.AnonymousClass1(predicate);
        }

        @Override // com.google.common.collect.BiMap
        public V forcePut(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
            com.google.common.base.Preconditions.checkArgument(e(k, v));
            return i().forcePut(k, v);
        }

        public com.google.common.collect.BiMap<K, V> i() {
            return (com.google.common.collect.BiMap) this.v;
        }

        @Override // com.google.common.collect.BiMap
        public com.google.common.collect.BiMap<V, K> inverse() {
            return this.y;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public java.util.Set<V> values() {
            return this.y.keySet();
        }
    }

    public static class FilteredEntryMap<K, V> extends com.google.common.collect.Maps.AbstractFilteredMap<K, V> {
        public final java.util.Set<java.util.Map.Entry<K, V>> x;

        public class EntrySet extends com.google.common.collect.ForwardingSet<java.util.Map.Entry<K, V>> {

            /* renamed from: com.google.common.collect.Maps$FilteredEntryMap$EntrySet$1, reason: invalid class name */
            public class AnonymousClass1 extends com.google.common.collect.TransformedIterator<java.util.Map.Entry<K, V>, java.util.Map.Entry<K, V>> {

                /* renamed from: com.google.common.collect.Maps$FilteredEntryMap$EntrySet$1$1, reason: invalid class name and collision with other inner class name */
                public class C03411 extends com.google.common.collect.ForwardingMapEntry<K, V> {
                    public final /* synthetic */ java.util.Map.Entry n;

                    public C03411(java.util.Map.Entry entry) {
                        this.n = entry;
                    }

                    @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
                    public java.util.Map.Entry<K, V> delegate() {
                        return this.n;
                    }

                    @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
                    public V setValue(V v) {
                        com.google.common.base.Preconditions.checkArgument(com.google.common.collect.Maps.FilteredEntryMap.this.e(getKey(), v));
                        return (V) super.setValue(v);
                    }
                }

                public AnonymousClass1(java.util.Iterator it) {
                    super(it);
                }

                @Override // com.google.common.collect.TransformedIterator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public java.util.Map.Entry<K, V> a(java.util.Map.Entry<K, V> entry) {
                    return new com.google.common.collect.Maps.FilteredEntryMap.EntrySet.AnonymousClass1.C03411(entry);
                }
            }

            public EntrySet() {
            }

            public /* synthetic */ EntrySet(com.google.common.collect.Maps.FilteredEntryMap filteredEntryMap, com.google.common.collect.Maps.AnonymousClass1 anonymousClass1) {
                this();
            }

            @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
            public java.util.Set<java.util.Map.Entry<K, V>> delegate() {
                return com.google.common.collect.Maps.FilteredEntryMap.this.x;
            }

            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public java.util.Iterator<java.util.Map.Entry<K, V>> iterator() {
                return new com.google.common.collect.Maps.FilteredEntryMap.EntrySet.AnonymousClass1(com.google.common.collect.Maps.FilteredEntryMap.this.x.iterator());
            }
        }

        public class KeySet extends com.google.common.collect.Maps.KeySet<K, V> {
            public KeySet() {
                super(com.google.common.collect.Maps.FilteredEntryMap.this);
            }

            @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(java.lang.Object obj) {
                if (!com.google.common.collect.Maps.FilteredEntryMap.this.containsKey(obj)) {
                    return false;
                }
                com.google.common.collect.Maps.FilteredEntryMap.this.v.remove(obj);
                return true;
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(java.util.Collection<?> collection) {
                com.google.common.collect.Maps.FilteredEntryMap filteredEntryMap = com.google.common.collect.Maps.FilteredEntryMap.this;
                return com.google.common.collect.Maps.FilteredEntryMap.f(filteredEntryMap.v, filteredEntryMap.w, collection);
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(java.util.Collection<?> collection) {
                com.google.common.collect.Maps.FilteredEntryMap filteredEntryMap = com.google.common.collect.Maps.FilteredEntryMap.this;
                return com.google.common.collect.Maps.FilteredEntryMap.g(filteredEntryMap.v, filteredEntryMap.w, collection);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public java.lang.Object[] toArray() {
                return com.google.common.collect.Lists.newArrayList(iterator()).toArray();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public <T> T[] toArray(T[] tArr) {
                return (T[]) com.google.common.collect.Lists.newArrayList(iterator()).toArray(tArr);
            }
        }

        public FilteredEntryMap(java.util.Map<K, V> map, com.google.common.base.Predicate<? super java.util.Map.Entry<K, V>> predicate) {
            super(map, predicate);
            this.x = com.google.common.collect.Sets.filter(map.entrySet(), this.w);
        }

        public static <K, V> boolean f(java.util.Map<K, V> map, com.google.common.base.Predicate<? super java.util.Map.Entry<K, V>> predicate, java.util.Collection<?> collection) {
            java.util.Iterator<java.util.Map.Entry<K, V>> it = map.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                java.util.Map.Entry<K, V> next = it.next();
                if (predicate.apply(next) && collection.contains(next.getKey())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        public static <K, V> boolean g(java.util.Map<K, V> map, com.google.common.base.Predicate<? super java.util.Map.Entry<K, V>> predicate, java.util.Collection<?> collection) {
            java.util.Iterator<java.util.Map.Entry<K, V>> it = map.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                java.util.Map.Entry<K, V> next = it.next();
                if (predicate.apply(next) && !collection.contains(next.getKey())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public java.util.Set<java.util.Map.Entry<K, V>> a() {
            return new com.google.common.collect.Maps.FilteredEntryMap.EntrySet(this, null);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        /* renamed from: b */
        public java.util.Set<K> h() {
            return new com.google.common.collect.Maps.FilteredEntryMap.KeySet();
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static class FilteredEntryNavigableMap<K, V> extends com.google.common.collect.AbstractNavigableMap<K, V> {
        public final java.util.NavigableMap<K, V> n;
        public final com.google.common.base.Predicate<? super java.util.Map.Entry<K, V>> t;
        public final java.util.Map<K, V> u;

        /* renamed from: com.google.common.collect.Maps$FilteredEntryNavigableMap$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.collect.Maps.NavigableKeySet<K, V> {
            public AnonymousClass1(java.util.NavigableMap navigableMap) {
                super(navigableMap);
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(java.util.Collection<?> collection) {
                return com.google.common.collect.Maps.FilteredEntryMap.f(com.google.common.collect.Maps.FilteredEntryNavigableMap.this.n, com.google.common.collect.Maps.FilteredEntryNavigableMap.this.t, collection);
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(java.util.Collection<?> collection) {
                return com.google.common.collect.Maps.FilteredEntryMap.g(com.google.common.collect.Maps.FilteredEntryNavigableMap.this.n, com.google.common.collect.Maps.FilteredEntryNavigableMap.this.t, collection);
            }
        }

        public FilteredEntryNavigableMap(java.util.NavigableMap<K, V> navigableMap, com.google.common.base.Predicate<? super java.util.Map.Entry<K, V>> predicate) {
            this.n = (java.util.NavigableMap) com.google.common.base.Preconditions.checkNotNull(navigableMap);
            this.t = predicate;
            this.u = new com.google.common.collect.Maps.FilteredEntryMap(navigableMap, predicate);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public java.util.Iterator<java.util.Map.Entry<K, V>> a() {
            return com.google.common.collect.Iterators.filter(this.n.entrySet().iterator(), this.t);
        }

        @Override // com.google.common.collect.AbstractNavigableMap
        public java.util.Iterator<java.util.Map.Entry<K, V>> b() {
            return com.google.common.collect.Iterators.filter(this.n.descendingMap().entrySet().iterator(), this.t);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.u.clear();
        }

        @Override // java.util.SortedMap
        public java.util.Comparator<? super K> comparator() {
            return this.n.comparator();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return this.u.containsKey(obj);
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        public java.util.NavigableMap<K, V> descendingMap() {
            return com.google.common.collect.Maps.filterEntries((java.util.NavigableMap) this.n.descendingMap(), (com.google.common.base.Predicate) this.t);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public java.util.Set<java.util.Map.Entry<K, V>> entrySet() {
            return this.u.entrySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public V get(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return this.u.get(obj);
        }

        @Override // java.util.NavigableMap
        public java.util.NavigableMap<K, V> headMap(K k, boolean z) {
            return com.google.common.collect.Maps.filterEntries((java.util.NavigableMap) this.n.headMap(k, z), (com.google.common.base.Predicate) this.t);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return !com.google.common.collect.Iterables.any(this.n.entrySet(), this.t);
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        public java.util.NavigableSet<K> navigableKeySet() {
            return new com.google.common.collect.Maps.FilteredEntryNavigableMap.AnonymousClass1(this);
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        public java.util.Map.Entry<K, V> pollFirstEntry() {
            return (java.util.Map.Entry) com.google.common.collect.Iterables.c(this.n.entrySet(), this.t);
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        public java.util.Map.Entry<K, V> pollLastEntry() {
            return (java.util.Map.Entry) com.google.common.collect.Iterables.c(this.n.descendingMap().entrySet(), this.t);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K k, V v) {
            return this.u.put(k, v);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void putAll(java.util.Map<? extends K, ? extends V> map) {
            this.u.putAll(map);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return this.u.remove(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.u.size();
        }

        @Override // java.util.NavigableMap
        public java.util.NavigableMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
            return com.google.common.collect.Maps.filterEntries((java.util.NavigableMap) this.n.subMap(k, z, k2, z2), (com.google.common.base.Predicate) this.t);
        }

        @Override // java.util.NavigableMap
        public java.util.NavigableMap<K, V> tailMap(K k, boolean z) {
            return com.google.common.collect.Maps.filterEntries((java.util.NavigableMap) this.n.tailMap(k, z), (com.google.common.base.Predicate) this.t);
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public java.util.Collection<V> values() {
            return new com.google.common.collect.Maps.FilteredMapValues(this, this.n, this.t);
        }
    }

    public static class FilteredEntrySortedMap<K, V> extends com.google.common.collect.Maps.FilteredEntryMap<K, V> implements java.util.SortedMap<K, V> {

        public class SortedKeySet extends com.google.common.collect.Maps.FilteredEntryMap<K, V>.KeySet implements java.util.SortedSet<K> {
            public SortedKeySet() {
                super();
            }

            @Override // java.util.SortedSet
            public java.util.Comparator<? super K> comparator() {
                return com.google.common.collect.Maps.FilteredEntrySortedMap.this.j().comparator();
            }

            @Override // java.util.SortedSet
            public K first() {
                return (K) com.google.common.collect.Maps.FilteredEntrySortedMap.this.firstKey();
            }

            @Override // java.util.SortedSet
            public java.util.SortedSet<K> headSet(K k) {
                return (java.util.SortedSet) com.google.common.collect.Maps.FilteredEntrySortedMap.this.headMap(k).keySet();
            }

            @Override // java.util.SortedSet
            public K last() {
                return (K) com.google.common.collect.Maps.FilteredEntrySortedMap.this.lastKey();
            }

            @Override // java.util.SortedSet
            public java.util.SortedSet<K> subSet(K k, K k2) {
                return (java.util.SortedSet) com.google.common.collect.Maps.FilteredEntrySortedMap.this.subMap(k, k2).keySet();
            }

            @Override // java.util.SortedSet
            public java.util.SortedSet<K> tailSet(K k) {
                return (java.util.SortedSet) com.google.common.collect.Maps.FilteredEntrySortedMap.this.tailMap(k).keySet();
            }
        }

        public FilteredEntrySortedMap(java.util.SortedMap<K, V> sortedMap, com.google.common.base.Predicate<? super java.util.Map.Entry<K, V>> predicate) {
            super(sortedMap, predicate);
        }

        @Override // java.util.SortedMap
        public java.util.Comparator<? super K> comparator() {
            return j().comparator();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return i().iterator().next();
        }

        @Override // com.google.common.collect.Maps.FilteredEntryMap, com.google.common.collect.Maps.ViewCachingAbstractMap
        public java.util.SortedSet<K> h() {
            return new com.google.common.collect.Maps.FilteredEntrySortedMap.SortedKeySet();
        }

        @Override // java.util.SortedMap
        public java.util.SortedMap<K, V> headMap(K k) {
            return new com.google.common.collect.Maps.FilteredEntrySortedMap(j().headMap(k), this.w);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public java.util.SortedSet<K> i() {
            return (java.util.SortedSet) super.i();
        }

        public java.util.SortedMap<K, V> j() {
            return (java.util.SortedMap) this.v;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            java.util.SortedMap<K, V> j = j();
            while (true) {
                K lastKey = j.lastKey();
                if (e(lastKey, this.v.get(lastKey))) {
                    return lastKey;
                }
                j = j().headMap(lastKey);
            }
        }

        @Override // java.util.SortedMap
        public java.util.SortedMap<K, V> subMap(K k, K k2) {
            return new com.google.common.collect.Maps.FilteredEntrySortedMap(j().subMap(k, k2), this.w);
        }

        @Override // java.util.SortedMap
        public java.util.SortedMap<K, V> tailMap(K k) {
            return new com.google.common.collect.Maps.FilteredEntrySortedMap(j().tailMap(k), this.w);
        }
    }

    public static class FilteredKeyMap<K, V> extends com.google.common.collect.Maps.AbstractFilteredMap<K, V> {
        public final com.google.common.base.Predicate<? super K> x;

        public FilteredKeyMap(java.util.Map<K, V> map, com.google.common.base.Predicate<? super K> predicate, com.google.common.base.Predicate<? super java.util.Map.Entry<K, V>> predicate2) {
            super(map, predicate2);
            this.x = predicate;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public java.util.Set<java.util.Map.Entry<K, V>> a() {
            return com.google.common.collect.Sets.filter(this.v.entrySet(), this.w);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        /* renamed from: b */
        public java.util.Set<K> h() {
            return com.google.common.collect.Sets.filter(this.v.keySet(), this.x);
        }

        @Override // com.google.common.collect.Maps.AbstractFilteredMap, java.util.AbstractMap, java.util.Map
        public boolean containsKey(java.lang.Object obj) {
            return this.v.containsKey(obj) && this.x.apply(obj);
        }
    }

    public static final class FilteredMapValues<K, V> extends com.google.common.collect.Maps.Values<K, V> {
        public final java.util.Map<K, V> t;
        public final com.google.common.base.Predicate<? super java.util.Map.Entry<K, V>> u;

        public FilteredMapValues(java.util.Map<K, V> map, java.util.Map<K, V> map2, com.google.common.base.Predicate<? super java.util.Map.Entry<K, V>> predicate) {
            super(map);
            this.t = map2;
            this.u = predicate;
        }

        @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
        public boolean remove(java.lang.Object obj) {
            java.util.Iterator<java.util.Map.Entry<K, V>> it = this.t.entrySet().iterator();
            while (it.hasNext()) {
                java.util.Map.Entry<K, V> next = it.next();
                if (this.u.apply(next) && com.google.common.base.Objects.equal(next.getValue(), obj)) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(java.util.Collection<?> collection) {
            java.util.Iterator<java.util.Map.Entry<K, V>> it = this.t.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                java.util.Map.Entry<K, V> next = it.next();
                if (this.u.apply(next) && collection.contains(next.getValue())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(java.util.Collection<?> collection) {
            java.util.Iterator<java.util.Map.Entry<K, V>> it = this.t.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                java.util.Map.Entry<K, V> next = it.next();
                if (this.u.apply(next) && !collection.contains(next.getValue())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public java.lang.Object[] toArray() {
            return com.google.common.collect.Lists.newArrayList(iterator()).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) com.google.common.collect.Lists.newArrayList(iterator()).toArray(tArr);
        }
    }

    public static abstract class IteratorBasedAbstractMap<K, V> extends java.util.AbstractMap<K, V> {

        /* renamed from: com.google.common.collect.Maps$IteratorBasedAbstractMap$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.collect.Maps.EntrySet<K, V> {
            public AnonymousClass1() {
            }

            @Override // com.google.common.collect.Maps.EntrySet
            public java.util.Map<K, V> a() {
                return com.google.common.collect.Maps.IteratorBasedAbstractMap.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public java.util.Iterator<java.util.Map.Entry<K, V>> iterator() {
                return com.google.common.collect.Maps.IteratorBasedAbstractMap.this.a();
            }
        }

        public abstract java.util.Iterator<java.util.Map.Entry<K, V>> a();

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            com.google.common.collect.Iterators.c(a());
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public java.util.Set<java.util.Map.Entry<K, V>> entrySet() {
            return new com.google.common.collect.Maps.IteratorBasedAbstractMap.AnonymousClass1();
        }
    }

    public static class KeySet<K, V> extends com.google.common.collect.Sets.ImprovedAbstractSet<K> {

        @com.google.j2objc.annotations.Weak
        public final java.util.Map<K, V> n;

        public KeySet(java.util.Map<K, V> map) {
            this.n = (java.util.Map) com.google.common.base.Preconditions.checkNotNull(map);
        }

        /* renamed from: a */
        public java.util.Map<K, V> b() {
            return this.n;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            b().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(java.lang.Object obj) {
            return b().containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return b().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<K> iterator() {
            return com.google.common.collect.Maps.w(b().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(java.lang.Object obj) {
            if (!contains(obj)) {
                return false;
            }
            b().remove(obj);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return b().size();
        }
    }

    public static class MapDifferenceImpl<K, V> implements com.google.common.collect.MapDifference<K, V> {
        public final java.util.Map<K, V> a;
        public final java.util.Map<K, V> b;
        public final java.util.Map<K, V> c;
        public final java.util.Map<K, com.google.common.collect.MapDifference.ValueDifference<V>> d;

        public MapDifferenceImpl(java.util.Map<K, V> map, java.util.Map<K, V> map2, java.util.Map<K, V> map3, java.util.Map<K, com.google.common.collect.MapDifference.ValueDifference<V>> map4) {
            this.a = com.google.common.collect.Maps.N(map);
            this.b = com.google.common.collect.Maps.N(map2);
            this.c = com.google.common.collect.Maps.N(map3);
            this.d = com.google.common.collect.Maps.N(map4);
        }

        @Override // com.google.common.collect.MapDifference
        public boolean areEqual() {
            return this.a.isEmpty() && this.b.isEmpty() && this.d.isEmpty();
        }

        @Override // com.google.common.collect.MapDifference
        public java.util.Map<K, com.google.common.collect.MapDifference.ValueDifference<V>> entriesDiffering() {
            return this.d;
        }

        @Override // com.google.common.collect.MapDifference
        public java.util.Map<K, V> entriesInCommon() {
            return this.c;
        }

        @Override // com.google.common.collect.MapDifference
        public java.util.Map<K, V> entriesOnlyOnLeft() {
            return this.a;
        }

        @Override // com.google.common.collect.MapDifference
        public java.util.Map<K, V> entriesOnlyOnRight() {
            return this.b;
        }

        @Override // com.google.common.collect.MapDifference
        public boolean equals(java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.google.common.collect.MapDifference)) {
                return false;
            }
            com.google.common.collect.MapDifference mapDifference = (com.google.common.collect.MapDifference) obj;
            return entriesOnlyOnLeft().equals(mapDifference.entriesOnlyOnLeft()) && entriesOnlyOnRight().equals(mapDifference.entriesOnlyOnRight()) && entriesInCommon().equals(mapDifference.entriesInCommon()) && entriesDiffering().equals(mapDifference.entriesDiffering());
        }

        @Override // com.google.common.collect.MapDifference
        public int hashCode() {
            return com.google.common.base.Objects.hashCode(entriesOnlyOnLeft(), entriesOnlyOnRight(), entriesInCommon(), entriesDiffering());
        }

        public java.lang.String toString() {
            if (areEqual()) {
                return "equal";
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder("not equal");
            if (!this.a.isEmpty()) {
                sb.append(": only on left=");
                sb.append(this.a);
            }
            if (!this.b.isEmpty()) {
                sb.append(": only on right=");
                sb.append(this.b);
            }
            if (!this.d.isEmpty()) {
                sb.append(": value differences=");
                sb.append(this.d);
            }
            return sb.toString();
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static final class NavigableAsMapView<K, V> extends com.google.common.collect.AbstractNavigableMap<K, V> {
        public final java.util.NavigableSet<K> n;
        public final com.google.common.base.Function<? super K, V> t;

        public NavigableAsMapView(java.util.NavigableSet<K> navigableSet, com.google.common.base.Function<? super K, V> function) {
            this.n = (java.util.NavigableSet) com.google.common.base.Preconditions.checkNotNull(navigableSet);
            this.t = (com.google.common.base.Function) com.google.common.base.Preconditions.checkNotNull(function);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public java.util.Iterator<java.util.Map.Entry<K, V>> a() {
            return com.google.common.collect.Maps.i(this.n, this.t);
        }

        @Override // com.google.common.collect.AbstractNavigableMap
        public java.util.Iterator<java.util.Map.Entry<K, V>> b() {
            return descendingMap().entrySet().iterator();
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.n.clear();
        }

        @Override // java.util.SortedMap
        public java.util.Comparator<? super K> comparator() {
            return this.n.comparator();
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        public java.util.NavigableMap<K, V> descendingMap() {
            return com.google.common.collect.Maps.asMap((java.util.NavigableSet) this.n.descendingSet(), (com.google.common.base.Function) this.t);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public V get(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (com.google.common.collect.Collections2.g(this.n, obj)) {
                return this.t.apply(obj);
            }
            return null;
        }

        @Override // java.util.NavigableMap
        public java.util.NavigableMap<K, V> headMap(K k, boolean z) {
            return com.google.common.collect.Maps.asMap((java.util.NavigableSet) this.n.headSet(k, z), (com.google.common.base.Function) this.t);
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        public java.util.NavigableSet<K> navigableKeySet() {
            return com.google.common.collect.Maps.C(this.n);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.n.size();
        }

        @Override // java.util.NavigableMap
        public java.util.NavigableMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
            return com.google.common.collect.Maps.asMap((java.util.NavigableSet) this.n.subSet(k, z, k2, z2), (com.google.common.base.Function) this.t);
        }

        @Override // java.util.NavigableMap
        public java.util.NavigableMap<K, V> tailMap(K k, boolean z) {
            return com.google.common.collect.Maps.asMap((java.util.NavigableSet) this.n.tailSet(k, z), (com.google.common.base.Function) this.t);
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static class NavigableKeySet<K, V> extends com.google.common.collect.Maps.SortedKeySet<K, V> implements java.util.NavigableSet<K> {
        public NavigableKeySet(java.util.NavigableMap<K, V> navigableMap) {
            super(navigableMap);
        }

        @Override // com.google.common.collect.Maps.SortedKeySet
        /* renamed from: c, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public java.util.NavigableMap<K, V> b() {
            return (java.util.NavigableMap) this.n;
        }

        @Override // java.util.NavigableSet
        public K ceiling(K k) {
            return a().ceilingKey(k);
        }

        @Override // java.util.NavigableSet
        public java.util.Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public java.util.NavigableSet<K> descendingSet() {
            return a().descendingKeySet();
        }

        @Override // java.util.NavigableSet
        public K floor(K k) {
            return a().floorKey(k);
        }

        @Override // java.util.NavigableSet
        public java.util.NavigableSet<K> headSet(K k, boolean z) {
            return a().headMap(k, z).navigableKeySet();
        }

        @Override // com.google.common.collect.Maps.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        public java.util.SortedSet<K> headSet(K k) {
            return headSet(k, false);
        }

        @Override // java.util.NavigableSet
        public K higher(K k) {
            return a().higherKey(k);
        }

        @Override // java.util.NavigableSet
        public K lower(K k) {
            return a().lowerKey(k);
        }

        @Override // java.util.NavigableSet
        public K pollFirst() {
            return (K) com.google.common.collect.Maps.x(a().pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        public K pollLast() {
            return (K) com.google.common.collect.Maps.x(a().pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public java.util.NavigableSet<K> subSet(K k, boolean z, K k2, boolean z2) {
            return a().subMap(k, z, k2, z2).navigableKeySet();
        }

        @Override // com.google.common.collect.Maps.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        public java.util.SortedSet<K> subSet(K k, K k2) {
            return subSet(k, true, k2, false);
        }

        @Override // java.util.NavigableSet
        public java.util.NavigableSet<K> tailSet(K k, boolean z) {
            return a().tailMap(k, z).navigableKeySet();
        }

        @Override // com.google.common.collect.Maps.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        public java.util.SortedSet<K> tailSet(K k) {
            return tailSet(k, true);
        }
    }

    public static class SortedAsMapView<K, V> extends com.google.common.collect.Maps.AsMapView<K, V> implements java.util.SortedMap<K, V> {
        public SortedAsMapView(java.util.SortedSet<K> sortedSet, com.google.common.base.Function<? super K, V> function) {
            super(sortedSet, function);
        }

        @Override // java.util.SortedMap
        public java.util.Comparator<? super K> comparator() {
            return e().comparator();
        }

        @Override // com.google.common.collect.Maps.AsMapView
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public java.util.SortedSet<K> e() {
            return (java.util.SortedSet) super.e();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return e().first();
        }

        @Override // java.util.SortedMap
        public java.util.SortedMap<K, V> headMap(K k) {
            return com.google.common.collect.Maps.asMap((java.util.SortedSet) e().headSet(k), (com.google.common.base.Function) this.w);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        /* renamed from: keySet */
        public java.util.Set<K> i() {
            return com.google.common.collect.Maps.E(e());
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return e().last();
        }

        @Override // java.util.SortedMap
        public java.util.SortedMap<K, V> subMap(K k, K k2) {
            return com.google.common.collect.Maps.asMap((java.util.SortedSet) e().subSet(k, k2), (com.google.common.base.Function) this.w);
        }

        @Override // java.util.SortedMap
        public java.util.SortedMap<K, V> tailMap(K k) {
            return com.google.common.collect.Maps.asMap((java.util.SortedSet) e().tailSet(k), (com.google.common.base.Function) this.w);
        }
    }

    public static class SortedKeySet<K, V> extends com.google.common.collect.Maps.KeySet<K, V> implements java.util.SortedSet<K> {
        public SortedKeySet(java.util.SortedMap<K, V> sortedMap) {
            super(sortedMap);
        }

        @Override // com.google.common.collect.Maps.KeySet
        public java.util.SortedMap<K, V> b() {
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
            return new com.google.common.collect.Maps.SortedKeySet(b().headMap(k));
        }

        @Override // java.util.SortedSet
        public K last() {
            return b().lastKey();
        }

        public java.util.SortedSet<K> subSet(K k, K k2) {
            return new com.google.common.collect.Maps.SortedKeySet(b().subMap(k, k2));
        }

        public java.util.SortedSet<K> tailSet(K k) {
            return new com.google.common.collect.Maps.SortedKeySet(b().tailMap(k));
        }
    }

    public static class SortedMapDifferenceImpl<K, V> extends com.google.common.collect.Maps.MapDifferenceImpl<K, V> implements com.google.common.collect.SortedMapDifference<K, V> {
        public SortedMapDifferenceImpl(java.util.SortedMap<K, V> sortedMap, java.util.SortedMap<K, V> sortedMap2, java.util.SortedMap<K, V> sortedMap3, java.util.SortedMap<K, com.google.common.collect.MapDifference.ValueDifference<V>> sortedMap4) {
            super(sortedMap, sortedMap2, sortedMap3, sortedMap4);
        }

        @Override // com.google.common.collect.Maps.MapDifferenceImpl, com.google.common.collect.MapDifference
        public java.util.SortedMap<K, com.google.common.collect.MapDifference.ValueDifference<V>> entriesDiffering() {
            return (java.util.SortedMap) super.entriesDiffering();
        }

        @Override // com.google.common.collect.Maps.MapDifferenceImpl, com.google.common.collect.MapDifference
        public java.util.SortedMap<K, V> entriesInCommon() {
            return (java.util.SortedMap) super.entriesInCommon();
        }

        @Override // com.google.common.collect.Maps.MapDifferenceImpl, com.google.common.collect.MapDifference
        public java.util.SortedMap<K, V> entriesOnlyOnLeft() {
            return (java.util.SortedMap) super.entriesOnlyOnLeft();
        }

        @Override // com.google.common.collect.Maps.MapDifferenceImpl, com.google.common.collect.MapDifference
        public java.util.SortedMap<K, V> entriesOnlyOnRight() {
            return (java.util.SortedMap) super.entriesOnlyOnRight();
        }
    }

    public static class TransformedEntriesMap<K, V1, V2> extends com.google.common.collect.Maps.IteratorBasedAbstractMap<K, V2> {
        public final java.util.Map<K, V1> n;
        public final com.google.common.collect.Maps.EntryTransformer<? super K, ? super V1, V2> t;

        public TransformedEntriesMap(java.util.Map<K, V1> map, com.google.common.collect.Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            this.n = (java.util.Map) com.google.common.base.Preconditions.checkNotNull(map);
            this.t = (com.google.common.collect.Maps.EntryTransformer) com.google.common.base.Preconditions.checkNotNull(entryTransformer);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public java.util.Iterator<java.util.Map.Entry<K, V2>> a() {
            return com.google.common.collect.Iterators.transform(this.n.entrySet().iterator(), com.google.common.collect.Maps.f(this.t));
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.n.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(java.lang.Object obj) {
            return this.n.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V2 get(java.lang.Object obj) {
            V1 v1 = this.n.get(obj);
            if (v1 != null || this.n.containsKey(obj)) {
                return this.t.transformEntry(obj, v1);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public java.util.Set<K> keySet() {
            return this.n.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V2 remove(java.lang.Object obj) {
            if (this.n.containsKey(obj)) {
                return this.t.transformEntry(obj, this.n.remove(obj));
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.n.size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public java.util.Collection<V2> values() {
            return new com.google.common.collect.Maps.Values(this);
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static class TransformedEntriesNavigableMap<K, V1, V2> extends com.google.common.collect.Maps.TransformedEntriesSortedMap<K, V1, V2> implements java.util.NavigableMap<K, V2> {
        public TransformedEntriesNavigableMap(java.util.NavigableMap<K, V1> navigableMap, com.google.common.collect.Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            super(navigableMap, entryTransformer);
        }

        @Override // java.util.NavigableMap
        public java.util.Map.Entry<K, V2> ceilingEntry(K k) {
            return h(b().ceilingEntry(k));
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k) {
            return b().ceilingKey(k);
        }

        @Override // com.google.common.collect.Maps.TransformedEntriesSortedMap
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public java.util.NavigableMap<K, V1> b() {
            return (java.util.NavigableMap) super.b();
        }

        @Override // java.util.NavigableMap
        public java.util.NavigableSet<K> descendingKeySet() {
            return b().descendingKeySet();
        }

        @Override // java.util.NavigableMap
        public java.util.NavigableMap<K, V2> descendingMap() {
            return com.google.common.collect.Maps.transformEntries((java.util.NavigableMap) b().descendingMap(), (com.google.common.collect.Maps.EntryTransformer) this.t);
        }

        @Override // com.google.common.collect.Maps.TransformedEntriesSortedMap, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public java.util.NavigableMap<K, V2> headMap(K k) {
            return headMap(k, false);
        }

        @Override // com.google.common.collect.Maps.TransformedEntriesSortedMap, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public java.util.NavigableMap<K, V2> subMap(K k, K k2) {
            return subMap(k, true, k2, false);
        }

        @Override // java.util.NavigableMap
        public java.util.Map.Entry<K, V2> firstEntry() {
            return h(b().firstEntry());
        }

        @Override // java.util.NavigableMap
        public java.util.Map.Entry<K, V2> floorEntry(K k) {
            return h(b().floorEntry(k));
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k) {
            return b().floorKey(k);
        }

        @Override // com.google.common.collect.Maps.TransformedEntriesSortedMap, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public java.util.NavigableMap<K, V2> tailMap(K k) {
            return tailMap(k, true);
        }

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public final java.util.Map.Entry<K, V2> h(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.util.Map.Entry<K, V1> entry) {
            if (entry == null) {
                return null;
            }
            return com.google.common.collect.Maps.J(this.t, entry);
        }

        @Override // java.util.NavigableMap
        public java.util.NavigableMap<K, V2> headMap(K k, boolean z) {
            return com.google.common.collect.Maps.transformEntries((java.util.NavigableMap) b().headMap(k, z), (com.google.common.collect.Maps.EntryTransformer) this.t);
        }

        @Override // java.util.NavigableMap
        public java.util.Map.Entry<K, V2> higherEntry(K k) {
            return h(b().higherEntry(k));
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k) {
            return b().higherKey(k);
        }

        @Override // java.util.NavigableMap
        public java.util.Map.Entry<K, V2> lastEntry() {
            return h(b().lastEntry());
        }

        @Override // java.util.NavigableMap
        public java.util.Map.Entry<K, V2> lowerEntry(K k) {
            return h(b().lowerEntry(k));
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k) {
            return b().lowerKey(k);
        }

        @Override // java.util.NavigableMap
        public java.util.NavigableSet<K> navigableKeySet() {
            return b().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public java.util.Map.Entry<K, V2> pollFirstEntry() {
            return h(b().pollFirstEntry());
        }

        @Override // java.util.NavigableMap
        public java.util.Map.Entry<K, V2> pollLastEntry() {
            return h(b().pollLastEntry());
        }

        @Override // java.util.NavigableMap
        public java.util.NavigableMap<K, V2> subMap(K k, boolean z, K k2, boolean z2) {
            return com.google.common.collect.Maps.transformEntries((java.util.NavigableMap) b().subMap(k, z, k2, z2), (com.google.common.collect.Maps.EntryTransformer) this.t);
        }

        @Override // java.util.NavigableMap
        public java.util.NavigableMap<K, V2> tailMap(K k, boolean z) {
            return com.google.common.collect.Maps.transformEntries((java.util.NavigableMap) b().tailMap(k, z), (com.google.common.collect.Maps.EntryTransformer) this.t);
        }
    }

    public static class TransformedEntriesSortedMap<K, V1, V2> extends com.google.common.collect.Maps.TransformedEntriesMap<K, V1, V2> implements java.util.SortedMap<K, V2> {
        public TransformedEntriesSortedMap(java.util.SortedMap<K, V1> sortedMap, com.google.common.collect.Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            super(sortedMap, entryTransformer);
        }

        public java.util.SortedMap<K, V1> b() {
            return (java.util.SortedMap) this.n;
        }

        @Override // java.util.SortedMap
        public java.util.Comparator<? super K> comparator() {
            return b().comparator();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return b().firstKey();
        }

        public java.util.SortedMap<K, V2> headMap(K k) {
            return com.google.common.collect.Maps.transformEntries((java.util.SortedMap) b().headMap(k), (com.google.common.collect.Maps.EntryTransformer) this.t);
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return b().lastKey();
        }

        public java.util.SortedMap<K, V2> subMap(K k, K k2) {
            return com.google.common.collect.Maps.transformEntries((java.util.SortedMap) b().subMap(k, k2), (com.google.common.collect.Maps.EntryTransformer) this.t);
        }

        public java.util.SortedMap<K, V2> tailMap(K k) {
            return com.google.common.collect.Maps.transformEntries((java.util.SortedMap) b().tailMap(k), (com.google.common.collect.Maps.EntryTransformer) this.t);
        }
    }

    public static class UnmodifiableBiMap<K, V> extends com.google.common.collect.ForwardingMap<K, V> implements com.google.common.collect.BiMap<K, V>, java.io.Serializable {
        private static final long serialVersionUID = 0;
        final com.google.common.collect.BiMap<? extends K, ? extends V> delegate;

        @com.google.j2objc.annotations.RetainedWith
        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        com.google.common.collect.BiMap<V, K> inverse;
        final java.util.Map<K, V> unmodifiableMap;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        transient java.util.Set<V> values;

        public UnmodifiableBiMap(com.google.common.collect.BiMap<? extends K, ? extends V> biMap, @org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.collect.BiMap<V, K> biMap2) {
            this.unmodifiableMap = java.util.Collections.unmodifiableMap(biMap);
            this.delegate = biMap;
            this.inverse = biMap2;
        }

        @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public java.util.Map<K, V> delegate() {
            return this.unmodifiableMap;
        }

        @Override // com.google.common.collect.BiMap
        public V forcePut(K k, V v) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.collect.BiMap
        public com.google.common.collect.BiMap<V, K> inverse() {
            com.google.common.collect.BiMap<V, K> biMap = this.inverse;
            if (biMap != null) {
                return biMap;
            }
            com.google.common.collect.Maps.UnmodifiableBiMap unmodifiableBiMap = new com.google.common.collect.Maps.UnmodifiableBiMap(this.delegate.inverse(), this);
            this.inverse = unmodifiableBiMap;
            return unmodifiableBiMap;
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public java.util.Set<V> values() {
            java.util.Set<V> set = this.values;
            if (set != null) {
                return set;
            }
            java.util.Set<V> unmodifiableSet = java.util.Collections.unmodifiableSet(this.delegate.values());
            this.values = unmodifiableSet;
            return unmodifiableSet;
        }
    }

    public static class UnmodifiableEntries<K, V> extends com.google.common.collect.ForwardingCollection<java.util.Map.Entry<K, V>> {
        public final java.util.Collection<java.util.Map.Entry<K, V>> n;

        public UnmodifiableEntries(java.util.Collection<java.util.Map.Entry<K, V>> collection) {
            this.n = collection;
        }

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public java.util.Collection<java.util.Map.Entry<K, V>> delegate() {
            return this.n;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<java.util.Map.Entry<K, V>> iterator() {
            return com.google.common.collect.Maps.L(this.n.iterator());
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public java.lang.Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }
    }

    public static class UnmodifiableEntrySet<K, V> extends com.google.common.collect.Maps.UnmodifiableEntries<K, V> implements java.util.Set<java.util.Map.Entry<K, V>> {
        public UnmodifiableEntrySet(java.util.Set<java.util.Map.Entry<K, V>> set) {
            super(set);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return com.google.common.collect.Sets.a(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return com.google.common.collect.Sets.b(this);
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static class UnmodifiableNavigableMap<K, V> extends com.google.common.collect.ForwardingSortedMap<K, V> implements java.util.NavigableMap<K, V>, java.io.Serializable {
        private final java.util.NavigableMap<K, ? extends V> delegate;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        private transient com.google.common.collect.Maps.UnmodifiableNavigableMap<K, V> descendingMap;

        public UnmodifiableNavigableMap(java.util.NavigableMap<K, ? extends V> navigableMap) {
            this.delegate = navigableMap;
        }

        public UnmodifiableNavigableMap(java.util.NavigableMap<K, ? extends V> navigableMap, com.google.common.collect.Maps.UnmodifiableNavigableMap<K, V> unmodifiableNavigableMap) {
            this.delegate = navigableMap;
            this.descendingMap = unmodifiableNavigableMap;
        }

        @Override // java.util.NavigableMap
        public java.util.Map.Entry<K, V> ceilingEntry(K k) {
            return com.google.common.collect.Maps.O(this.delegate.ceilingEntry(k));
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k) {
            return this.delegate.ceilingKey(k);
        }

        @Override // com.google.common.collect.ForwardingSortedMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public java.util.SortedMap<K, V> delegate() {
            return java.util.Collections.unmodifiableSortedMap(this.delegate);
        }

        @Override // java.util.NavigableMap
        public java.util.NavigableSet<K> descendingKeySet() {
            return com.google.common.collect.Sets.unmodifiableNavigableSet(this.delegate.descendingKeySet());
        }

        @Override // java.util.NavigableMap
        public java.util.NavigableMap<K, V> descendingMap() {
            com.google.common.collect.Maps.UnmodifiableNavigableMap<K, V> unmodifiableNavigableMap = this.descendingMap;
            if (unmodifiableNavigableMap != null) {
                return unmodifiableNavigableMap;
            }
            com.google.common.collect.Maps.UnmodifiableNavigableMap<K, V> unmodifiableNavigableMap2 = new com.google.common.collect.Maps.UnmodifiableNavigableMap<>(this.delegate.descendingMap(), this);
            this.descendingMap = unmodifiableNavigableMap2;
            return unmodifiableNavigableMap2;
        }

        @Override // java.util.NavigableMap
        public java.util.Map.Entry<K, V> firstEntry() {
            return com.google.common.collect.Maps.O(this.delegate.firstEntry());
        }

        @Override // java.util.NavigableMap
        public java.util.Map.Entry<K, V> floorEntry(K k) {
            return com.google.common.collect.Maps.O(this.delegate.floorEntry(k));
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k) {
            return this.delegate.floorKey(k);
        }

        @Override // java.util.NavigableMap
        public java.util.NavigableMap<K, V> headMap(K k, boolean z) {
            return com.google.common.collect.Maps.unmodifiableNavigableMap(this.delegate.headMap(k, z));
        }

        @Override // com.google.common.collect.ForwardingSortedMap, java.util.SortedMap
        public java.util.SortedMap<K, V> headMap(K k) {
            return headMap(k, false);
        }

        @Override // java.util.NavigableMap
        public java.util.Map.Entry<K, V> higherEntry(K k) {
            return com.google.common.collect.Maps.O(this.delegate.higherEntry(k));
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k) {
            return this.delegate.higherKey(k);
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public java.util.Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public java.util.Map.Entry<K, V> lastEntry() {
            return com.google.common.collect.Maps.O(this.delegate.lastEntry());
        }

        @Override // java.util.NavigableMap
        public java.util.Map.Entry<K, V> lowerEntry(K k) {
            return com.google.common.collect.Maps.O(this.delegate.lowerEntry(k));
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k) {
            return this.delegate.lowerKey(k);
        }

        @Override // java.util.NavigableMap
        public java.util.NavigableSet<K> navigableKeySet() {
            return com.google.common.collect.Sets.unmodifiableNavigableSet(this.delegate.navigableKeySet());
        }

        @Override // java.util.NavigableMap
        public final java.util.Map.Entry<K, V> pollFirstEntry() {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.util.NavigableMap
        public final java.util.Map.Entry<K, V> pollLastEntry() {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.util.NavigableMap
        public java.util.NavigableMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
            return com.google.common.collect.Maps.unmodifiableNavigableMap(this.delegate.subMap(k, z, k2, z2));
        }

        @Override // com.google.common.collect.ForwardingSortedMap, java.util.SortedMap
        public java.util.SortedMap<K, V> subMap(K k, K k2) {
            return subMap(k, true, k2, false);
        }

        @Override // java.util.NavigableMap
        public java.util.NavigableMap<K, V> tailMap(K k, boolean z) {
            return com.google.common.collect.Maps.unmodifiableNavigableMap(this.delegate.tailMap(k, z));
        }

        @Override // com.google.common.collect.ForwardingSortedMap, java.util.SortedMap
        public java.util.SortedMap<K, V> tailMap(K k) {
            return tailMap(k, true);
        }
    }

    public static class ValueDifferenceImpl<V> implements com.google.common.collect.MapDifference.ValueDifference<V> {

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public final V a;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public final V b;

        public ValueDifferenceImpl(@org.checkerframework.checker.nullness.compatqual.NullableDecl V v, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v2) {
            this.a = v;
            this.b = v2;
        }

        public static <V> com.google.common.collect.MapDifference.ValueDifference<V> a(@org.checkerframework.checker.nullness.compatqual.NullableDecl V v, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v2) {
            return new com.google.common.collect.Maps.ValueDifferenceImpl(v, v2);
        }

        @Override // com.google.common.collect.MapDifference.ValueDifference
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (!(obj instanceof com.google.common.collect.MapDifference.ValueDifference)) {
                return false;
            }
            com.google.common.collect.MapDifference.ValueDifference valueDifference = (com.google.common.collect.MapDifference.ValueDifference) obj;
            return com.google.common.base.Objects.equal(this.a, valueDifference.leftValue()) && com.google.common.base.Objects.equal(this.b, valueDifference.rightValue());
        }

        @Override // com.google.common.collect.MapDifference.ValueDifference
        public int hashCode() {
            return com.google.common.base.Objects.hashCode(this.a, this.b);
        }

        @Override // com.google.common.collect.MapDifference.ValueDifference
        public V leftValue() {
            return this.a;
        }

        @Override // com.google.common.collect.MapDifference.ValueDifference
        public V rightValue() {
            return this.b;
        }

        public java.lang.String toString() {
            return "(" + this.a + ", " + this.b + ")";
        }
    }

    public static class Values<K, V> extends java.util.AbstractCollection<V> {

        @com.google.j2objc.annotations.Weak
        public final java.util.Map<K, V> n;

        public Values(java.util.Map<K, V> map) {
            this.n = (java.util.Map) com.google.common.base.Preconditions.checkNotNull(map);
        }

        public final java.util.Map<K, V> a() {
            return this.n;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return a().containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public java.util.Iterator<V> iterator() {
            return com.google.common.collect.Maps.Q(a().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(java.lang.Object obj) {
            try {
                return super.remove(obj);
            } catch (java.lang.UnsupportedOperationException unused) {
                for (java.util.Map.Entry<K, V> entry : a().entrySet()) {
                    if (com.google.common.base.Objects.equal(obj, entry.getValue())) {
                        a().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(java.util.Collection<?> collection) {
            try {
                return super.removeAll((java.util.Collection) com.google.common.base.Preconditions.checkNotNull(collection));
            } catch (java.lang.UnsupportedOperationException unused) {
                java.util.HashSet newHashSet = com.google.common.collect.Sets.newHashSet();
                for (java.util.Map.Entry<K, V> entry : a().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        newHashSet.add(entry.getKey());
                    }
                }
                return a().keySet().removeAll(newHashSet);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(java.util.Collection<?> collection) {
            try {
                return super.retainAll((java.util.Collection) com.google.common.base.Preconditions.checkNotNull(collection));
            } catch (java.lang.UnsupportedOperationException unused) {
                java.util.HashSet newHashSet = com.google.common.collect.Sets.newHashSet();
                for (java.util.Map.Entry<K, V> entry : a().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        newHashSet.add(entry.getKey());
                    }
                }
                return a().keySet().retainAll(newHashSet);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return a().size();
        }
    }

    @com.google.common.annotations.GwtCompatible
    public static abstract class ViewCachingAbstractMap<K, V> extends java.util.AbstractMap<K, V> {

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        public transient java.util.Set<java.util.Map.Entry<K, V>> n;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        public transient java.util.Set<K> t;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        public transient java.util.Collection<V> u;

        public abstract java.util.Set<java.util.Map.Entry<K, V>> a();

        /* renamed from: b */
        public java.util.Set<K> h() {
            return new com.google.common.collect.Maps.KeySet(this);
        }

        public java.util.Collection<V> d() {
            return new com.google.common.collect.Maps.Values(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public java.util.Set<java.util.Map.Entry<K, V>> entrySet() {
            java.util.Set<java.util.Map.Entry<K, V>> set = this.n;
            if (set != null) {
                return set;
            }
            java.util.Set<java.util.Map.Entry<K, V>> a = a();
            this.n = a;
            return a;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: keySet */
        public java.util.Set<K> i() {
            java.util.Set<K> set = this.t;
            if (set != null) {
                return set;
            }
            java.util.Set<K> h = h();
            this.t = h;
            return h;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public java.util.Collection<V> values() {
            java.util.Collection<V> collection = this.u;
            if (collection != null) {
                return collection;
            }
            java.util.Collection<V> d = d();
            this.u = d;
            return d;
        }
    }

    public static <K, V> void A(java.util.Map<K, V> map, java.util.Map<? extends K, ? extends V> map2) {
        for (java.util.Map.Entry<? extends K, ? extends V> entry : map2.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
    }

    public static <K, V> boolean B(java.util.Collection<java.util.Map.Entry<K, V>> collection, java.lang.Object obj) {
        if (obj instanceof java.util.Map.Entry) {
            return collection.remove(K((java.util.Map.Entry) obj));
        }
        return false;
    }

    @com.google.common.annotations.GwtIncompatible
    public static <E> java.util.NavigableSet<E> C(java.util.NavigableSet<E> navigableSet) {
        return new com.google.common.collect.Maps.AnonymousClass6(navigableSet);
    }

    public static <E> java.util.Set<E> D(java.util.Set<E> set) {
        return new com.google.common.collect.Maps.AnonymousClass4(set);
    }

    public static <E> java.util.SortedSet<E> E(java.util.SortedSet<E> sortedSet) {
        return new com.google.common.collect.Maps.AnonymousClass5(sortedSet);
    }

    public static boolean F(java.util.Map<?, ?> map, java.lang.Object obj) {
        com.google.common.base.Preconditions.checkNotNull(map);
        try {
            return map.containsKey(obj);
        } catch (java.lang.ClassCastException | java.lang.NullPointerException unused) {
            return false;
        }
    }

    public static <V> V G(java.util.Map<?, V> map, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        com.google.common.base.Preconditions.checkNotNull(map);
        try {
            return map.get(obj);
        } catch (java.lang.ClassCastException | java.lang.NullPointerException unused) {
            return null;
        }
    }

    public static <V> V H(java.util.Map<?, V> map, java.lang.Object obj) {
        com.google.common.base.Preconditions.checkNotNull(map);
        try {
            return map.remove(obj);
        } catch (java.lang.ClassCastException | java.lang.NullPointerException unused) {
            return null;
        }
    }

    public static java.lang.String I(java.util.Map<?, ?> map) {
        java.lang.StringBuilder f = com.google.common.collect.Collections2.f(map.size());
        f.append('{');
        boolean z = true;
        for (java.util.Map.Entry<?, ?> entry : map.entrySet()) {
            if (!z) {
                f.append(", ");
            }
            f.append(entry.getKey());
            f.append(com.alipay.sdk.m.n.a.h);
            f.append(entry.getValue());
            z = false;
        }
        f.append('}');
        return f.toString();
    }

    public static <V2, K, V1> java.util.Map.Entry<K, V2> J(com.google.common.collect.Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer, java.util.Map.Entry<K, V1> entry) {
        com.google.common.base.Preconditions.checkNotNull(entryTransformer);
        com.google.common.base.Preconditions.checkNotNull(entry);
        return new com.google.common.collect.Maps.AnonymousClass12(entry, entryTransformer);
    }

    public static <K, V> java.util.Map.Entry<K, V> K(java.util.Map.Entry<? extends K, ? extends V> entry) {
        com.google.common.base.Preconditions.checkNotNull(entry);
        return new com.google.common.collect.Maps.AnonymousClass7(entry);
    }

    public static <K, V> com.google.common.collect.UnmodifiableIterator<java.util.Map.Entry<K, V>> L(java.util.Iterator<java.util.Map.Entry<K, V>> it) {
        return new com.google.common.collect.Maps.AnonymousClass8(it);
    }

    public static <K, V> java.util.Set<java.util.Map.Entry<K, V>> M(java.util.Set<java.util.Map.Entry<K, V>> set) {
        return new com.google.common.collect.Maps.UnmodifiableEntrySet(java.util.Collections.unmodifiableSet(set));
    }

    public static <K, V> java.util.Map<K, V> N(java.util.Map<K, ? extends V> map) {
        return map instanceof java.util.SortedMap ? java.util.Collections.unmodifiableSortedMap((java.util.SortedMap) map) : java.util.Collections.unmodifiableMap(map);
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public static <K, V> java.util.Map.Entry<K, V> O(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.util.Map.Entry<K, ? extends V> entry) {
        if (entry == null) {
            return null;
        }
        return K(entry);
    }

    public static <V> com.google.common.base.Function<java.util.Map.Entry<?, V>, V> P() {
        return com.google.common.collect.Maps.EntryFunction.VALUE;
    }

    public static <K, V> java.util.Iterator<V> Q(java.util.Iterator<java.util.Map.Entry<K, V>> it) {
        return new com.google.common.collect.Maps.AnonymousClass2(it);
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public static <V> V R(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.util.Map.Entry<?, V> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    public static <V> com.google.common.base.Predicate<java.util.Map.Entry<?, V>> S(com.google.common.base.Predicate<? super V> predicate) {
        return com.google.common.base.Predicates.compose(predicate, P());
    }

    public static <A, B> com.google.common.base.Converter<A, B> asConverter(com.google.common.collect.BiMap<A, B> biMap) {
        return new com.google.common.collect.Maps.BiMapConverter(biMap);
    }

    public static <K, V> java.util.Map<K, V> asMap(java.util.Set<K> set, com.google.common.base.Function<? super K, V> function) {
        return new com.google.common.collect.Maps.AsMapView(set, function);
    }

    @com.google.common.annotations.GwtIncompatible
    public static <K, V> java.util.NavigableMap<K, V> asMap(java.util.NavigableSet<K> navigableSet, com.google.common.base.Function<? super K, V> function) {
        return new com.google.common.collect.Maps.NavigableAsMapView(navigableSet, function);
    }

    public static <K, V> java.util.SortedMap<K, V> asMap(java.util.SortedSet<K> sortedSet, com.google.common.base.Function<? super K, V> function) {
        return new com.google.common.collect.Maps.SortedAsMapView(sortedSet, function);
    }

    public static <K, V> com.google.common.collect.MapDifference<K, V> difference(java.util.Map<? extends K, ? extends V> map, java.util.Map<? extends K, ? extends V> map2) {
        return map instanceof java.util.SortedMap ? difference((java.util.SortedMap) map, (java.util.Map) map2) : difference(map, map2, com.google.common.base.Equivalence.equals());
    }

    public static <K, V> com.google.common.collect.MapDifference<K, V> difference(java.util.Map<? extends K, ? extends V> map, java.util.Map<? extends K, ? extends V> map2, com.google.common.base.Equivalence<? super V> equivalence) {
        com.google.common.base.Preconditions.checkNotNull(equivalence);
        java.util.LinkedHashMap newLinkedHashMap = newLinkedHashMap();
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(map2);
        java.util.LinkedHashMap newLinkedHashMap2 = newLinkedHashMap();
        java.util.LinkedHashMap newLinkedHashMap3 = newLinkedHashMap();
        o(map, map2, equivalence, newLinkedHashMap, linkedHashMap, newLinkedHashMap2, newLinkedHashMap3);
        return new com.google.common.collect.Maps.MapDifferenceImpl(newLinkedHashMap, linkedHashMap, newLinkedHashMap2, newLinkedHashMap3);
    }

    public static <K, V> com.google.common.collect.SortedMapDifference<K, V> difference(java.util.SortedMap<K, ? extends V> sortedMap, java.util.Map<? extends K, ? extends V> map) {
        com.google.common.base.Preconditions.checkNotNull(sortedMap);
        com.google.common.base.Preconditions.checkNotNull(map);
        java.util.Comparator z = z(sortedMap.comparator());
        java.util.TreeMap newTreeMap = newTreeMap(z);
        java.util.TreeMap newTreeMap2 = newTreeMap(z);
        newTreeMap2.putAll(map);
        java.util.TreeMap newTreeMap3 = newTreeMap(z);
        java.util.TreeMap newTreeMap4 = newTreeMap(z);
        o(sortedMap, map, com.google.common.base.Equivalence.equals(), newTreeMap, newTreeMap2, newTreeMap3, newTreeMap4);
        return new com.google.common.collect.Maps.SortedMapDifferenceImpl(newTreeMap, newTreeMap2, newTreeMap3, newTreeMap4);
    }

    public static <K, V1, V2> com.google.common.base.Function<java.util.Map.Entry<K, V1>, java.util.Map.Entry<K, V2>> f(com.google.common.collect.Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        com.google.common.base.Preconditions.checkNotNull(entryTransformer);
        return new com.google.common.collect.Maps.AnonymousClass13(entryTransformer);
    }

    public static <K, V> com.google.common.collect.BiMap<K, V> filterEntries(com.google.common.collect.BiMap<K, V> biMap, com.google.common.base.Predicate<? super java.util.Map.Entry<K, V>> predicate) {
        com.google.common.base.Preconditions.checkNotNull(biMap);
        com.google.common.base.Preconditions.checkNotNull(predicate);
        return biMap instanceof com.google.common.collect.Maps.FilteredEntryBiMap ? q((com.google.common.collect.Maps.FilteredEntryBiMap) biMap, predicate) : new com.google.common.collect.Maps.FilteredEntryBiMap(biMap, predicate);
    }

    public static <K, V> java.util.Map<K, V> filterEntries(java.util.Map<K, V> map, com.google.common.base.Predicate<? super java.util.Map.Entry<K, V>> predicate) {
        com.google.common.base.Preconditions.checkNotNull(predicate);
        return map instanceof com.google.common.collect.Maps.AbstractFilteredMap ? r((com.google.common.collect.Maps.AbstractFilteredMap) map, predicate) : new com.google.common.collect.Maps.FilteredEntryMap((java.util.Map) com.google.common.base.Preconditions.checkNotNull(map), predicate);
    }

    @com.google.common.annotations.GwtIncompatible
    public static <K, V> java.util.NavigableMap<K, V> filterEntries(java.util.NavigableMap<K, V> navigableMap, com.google.common.base.Predicate<? super java.util.Map.Entry<K, V>> predicate) {
        com.google.common.base.Preconditions.checkNotNull(predicate);
        return navigableMap instanceof com.google.common.collect.Maps.FilteredEntryNavigableMap ? s((com.google.common.collect.Maps.FilteredEntryNavigableMap) navigableMap, predicate) : new com.google.common.collect.Maps.FilteredEntryNavigableMap((java.util.NavigableMap) com.google.common.base.Preconditions.checkNotNull(navigableMap), predicate);
    }

    public static <K, V> java.util.SortedMap<K, V> filterEntries(java.util.SortedMap<K, V> sortedMap, com.google.common.base.Predicate<? super java.util.Map.Entry<K, V>> predicate) {
        com.google.common.base.Preconditions.checkNotNull(predicate);
        return sortedMap instanceof com.google.common.collect.Maps.FilteredEntrySortedMap ? t((com.google.common.collect.Maps.FilteredEntrySortedMap) sortedMap, predicate) : new com.google.common.collect.Maps.FilteredEntrySortedMap((java.util.SortedMap) com.google.common.base.Preconditions.checkNotNull(sortedMap), predicate);
    }

    public static <K, V> com.google.common.collect.BiMap<K, V> filterKeys(com.google.common.collect.BiMap<K, V> biMap, com.google.common.base.Predicate<? super K> predicate) {
        com.google.common.base.Preconditions.checkNotNull(predicate);
        return filterEntries((com.google.common.collect.BiMap) biMap, y(predicate));
    }

    public static <K, V> java.util.Map<K, V> filterKeys(java.util.Map<K, V> map, com.google.common.base.Predicate<? super K> predicate) {
        com.google.common.base.Preconditions.checkNotNull(predicate);
        com.google.common.base.Predicate y = y(predicate);
        return map instanceof com.google.common.collect.Maps.AbstractFilteredMap ? r((com.google.common.collect.Maps.AbstractFilteredMap) map, y) : new com.google.common.collect.Maps.FilteredKeyMap((java.util.Map) com.google.common.base.Preconditions.checkNotNull(map), predicate, y);
    }

    @com.google.common.annotations.GwtIncompatible
    public static <K, V> java.util.NavigableMap<K, V> filterKeys(java.util.NavigableMap<K, V> navigableMap, com.google.common.base.Predicate<? super K> predicate) {
        return filterEntries((java.util.NavigableMap) navigableMap, y(predicate));
    }

    public static <K, V> java.util.SortedMap<K, V> filterKeys(java.util.SortedMap<K, V> sortedMap, com.google.common.base.Predicate<? super K> predicate) {
        return filterEntries((java.util.SortedMap) sortedMap, y(predicate));
    }

    public static <K, V> com.google.common.collect.BiMap<K, V> filterValues(com.google.common.collect.BiMap<K, V> biMap, com.google.common.base.Predicate<? super V> predicate) {
        return filterEntries((com.google.common.collect.BiMap) biMap, S(predicate));
    }

    public static <K, V> java.util.Map<K, V> filterValues(java.util.Map<K, V> map, com.google.common.base.Predicate<? super V> predicate) {
        return filterEntries(map, S(predicate));
    }

    @com.google.common.annotations.GwtIncompatible
    public static <K, V> java.util.NavigableMap<K, V> filterValues(java.util.NavigableMap<K, V> navigableMap, com.google.common.base.Predicate<? super V> predicate) {
        return filterEntries((java.util.NavigableMap) navigableMap, S(predicate));
    }

    public static <K, V> java.util.SortedMap<K, V> filterValues(java.util.SortedMap<K, V> sortedMap, com.google.common.base.Predicate<? super V> predicate) {
        return filterEntries((java.util.SortedMap) sortedMap, S(predicate));
    }

    @com.google.common.annotations.GwtIncompatible
    public static com.google.common.collect.ImmutableMap<java.lang.String, java.lang.String> fromProperties(java.util.Properties properties) {
        com.google.common.collect.ImmutableMap.Builder builder = com.google.common.collect.ImmutableMap.builder();
        java.util.Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            java.lang.String str = (java.lang.String) propertyNames.nextElement();
            builder.put(str, properties.getProperty(str));
        }
        return builder.build();
    }

    public static <K, V1, V2> com.google.common.base.Function<java.util.Map.Entry<K, V1>, V2> g(com.google.common.collect.Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        com.google.common.base.Preconditions.checkNotNull(entryTransformer);
        return new com.google.common.collect.Maps.AnonymousClass11(entryTransformer);
    }

    public static <K, V1, V2> com.google.common.collect.Maps.EntryTransformer<K, V1, V2> h(com.google.common.base.Function<? super V1, V2> function) {
        com.google.common.base.Preconditions.checkNotNull(function);
        return new com.google.common.collect.Maps.AnonymousClass9(function);
    }

    public static <K, V> java.util.Iterator<java.util.Map.Entry<K, V>> i(java.util.Set<K> set, com.google.common.base.Function<? super K, V> function) {
        return new com.google.common.collect.Maps.AnonymousClass3(set.iterator(), function);
    }

    @com.google.common.annotations.GwtCompatible(serializable = true)
    public static <K, V> java.util.Map.Entry<K, V> immutableEntry(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
        return new com.google.common.collect.ImmutableEntry(k, v);
    }

    @com.google.common.annotations.GwtCompatible(serializable = true)
    public static <K extends java.lang.Enum<K>, V> com.google.common.collect.ImmutableMap<K, V> immutableEnumMap(java.util.Map<K, ? extends V> map) {
        if (map instanceof com.google.common.collect.ImmutableEnumMap) {
            return (com.google.common.collect.ImmutableEnumMap) map;
        }
        java.util.Iterator<java.util.Map.Entry<K, ? extends V>> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return com.google.common.collect.ImmutableMap.of();
        }
        java.util.Map.Entry<K, ? extends V> next = it.next();
        K key = next.getKey();
        V value = next.getValue();
        com.google.common.collect.CollectPreconditions.a(key, value);
        java.util.EnumMap enumMap = new java.util.EnumMap(key.getDeclaringClass());
        enumMap.put((java.util.EnumMap) key, (K) value);
        while (it.hasNext()) {
            java.util.Map.Entry<K, ? extends V> next2 = it.next();
            K key2 = next2.getKey();
            V value2 = next2.getValue();
            com.google.common.collect.CollectPreconditions.a(key2, value2);
            enumMap.put((java.util.EnumMap) key2, (K) value2);
        }
        return com.google.common.collect.ImmutableEnumMap.asImmutable(enumMap);
    }

    public static <K, V1, V2> com.google.common.base.Function<V1, V2> j(com.google.common.collect.Maps.EntryTransformer<? super K, V1, V2> entryTransformer, K k) {
        com.google.common.base.Preconditions.checkNotNull(entryTransformer);
        return new com.google.common.collect.Maps.AnonymousClass10(entryTransformer, k);
    }

    public static int k(int i) {
        if (i < 3) {
            com.google.common.collect.CollectPreconditions.b(i, "expectedSize");
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static <K, V> boolean l(java.util.Collection<java.util.Map.Entry<K, V>> collection, java.lang.Object obj) {
        if (obj instanceof java.util.Map.Entry) {
            return collection.contains(K((java.util.Map.Entry) obj));
        }
        return false;
    }

    public static boolean m(java.util.Map<?, ?> map, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return com.google.common.collect.Iterators.contains(w(map.entrySet().iterator()), obj);
    }

    public static boolean n(java.util.Map<?, ?> map, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return com.google.common.collect.Iterators.contains(Q(map.entrySet().iterator()), obj);
    }

    public static <K, V> java.util.concurrent.ConcurrentMap<K, V> newConcurrentMap() {
        return new java.util.concurrent.ConcurrentHashMap();
    }

    public static <K extends java.lang.Enum<K>, V> java.util.EnumMap<K, V> newEnumMap(java.lang.Class<K> cls) {
        return new java.util.EnumMap<>((java.lang.Class) com.google.common.base.Preconditions.checkNotNull(cls));
    }

    public static <K extends java.lang.Enum<K>, V> java.util.EnumMap<K, V> newEnumMap(java.util.Map<K, ? extends V> map) {
        return new java.util.EnumMap<>(map);
    }

    public static <K, V> java.util.HashMap<K, V> newHashMap() {
        return new java.util.HashMap<>();
    }

    public static <K, V> java.util.HashMap<K, V> newHashMap(java.util.Map<? extends K, ? extends V> map) {
        return new java.util.HashMap<>(map);
    }

    public static <K, V> java.util.HashMap<K, V> newHashMapWithExpectedSize(int i) {
        return new java.util.HashMap<>(k(i));
    }

    public static <K, V> java.util.IdentityHashMap<K, V> newIdentityHashMap() {
        return new java.util.IdentityHashMap<>();
    }

    public static <K, V> java.util.LinkedHashMap<K, V> newLinkedHashMap() {
        return new java.util.LinkedHashMap<>();
    }

    public static <K, V> java.util.LinkedHashMap<K, V> newLinkedHashMap(java.util.Map<? extends K, ? extends V> map) {
        return new java.util.LinkedHashMap<>(map);
    }

    public static <K, V> java.util.LinkedHashMap<K, V> newLinkedHashMapWithExpectedSize(int i) {
        return new java.util.LinkedHashMap<>(k(i));
    }

    public static <K extends java.lang.Comparable, V> java.util.TreeMap<K, V> newTreeMap() {
        return new java.util.TreeMap<>();
    }

    public static <C, K extends C, V> java.util.TreeMap<K, V> newTreeMap(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.util.Comparator<C> comparator) {
        return new java.util.TreeMap<>(comparator);
    }

    public static <K, V> java.util.TreeMap<K, V> newTreeMap(java.util.SortedMap<K, ? extends V> sortedMap) {
        return new java.util.TreeMap<>((java.util.SortedMap) sortedMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> void o(java.util.Map<? extends K, ? extends V> map, java.util.Map<? extends K, ? extends V> map2, com.google.common.base.Equivalence<? super V> equivalence, java.util.Map<K, V> map3, java.util.Map<K, V> map4, java.util.Map<K, V> map5, java.util.Map<K, com.google.common.collect.MapDifference.ValueDifference<V>> map6) {
        for (java.util.Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            if (map2.containsKey(key)) {
                V remove = map4.remove(key);
                if (equivalence.equivalent(value, remove)) {
                    map5.put(key, value);
                } else {
                    map6.put(key, com.google.common.collect.Maps.ValueDifferenceImpl.a(value, remove));
                }
            } else {
                map3.put(key, value);
            }
        }
    }

    public static boolean p(java.util.Map<?, ?> map, java.lang.Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof java.util.Map) {
            return map.entrySet().equals(((java.util.Map) obj).entrySet());
        }
        return false;
    }

    public static <K, V> com.google.common.collect.BiMap<K, V> q(com.google.common.collect.Maps.FilteredEntryBiMap<K, V> filteredEntryBiMap, com.google.common.base.Predicate<? super java.util.Map.Entry<K, V>> predicate) {
        return new com.google.common.collect.Maps.FilteredEntryBiMap(filteredEntryBiMap.i(), com.google.common.base.Predicates.and(filteredEntryBiMap.w, predicate));
    }

    public static <K, V> java.util.Map<K, V> r(com.google.common.collect.Maps.AbstractFilteredMap<K, V> abstractFilteredMap, com.google.common.base.Predicate<? super java.util.Map.Entry<K, V>> predicate) {
        return new com.google.common.collect.Maps.FilteredEntryMap(abstractFilteredMap.v, com.google.common.base.Predicates.and(abstractFilteredMap.w, predicate));
    }

    @com.google.common.annotations.GwtIncompatible
    public static <K, V> java.util.NavigableMap<K, V> s(com.google.common.collect.Maps.FilteredEntryNavigableMap<K, V> filteredEntryNavigableMap, com.google.common.base.Predicate<? super java.util.Map.Entry<K, V>> predicate) {
        return new com.google.common.collect.Maps.FilteredEntryNavigableMap(filteredEntryNavigableMap.n, com.google.common.base.Predicates.and(filteredEntryNavigableMap.t, predicate));
    }

    @com.google.common.annotations.Beta
    @com.google.common.annotations.GwtIncompatible
    public static <K extends java.lang.Comparable<? super K>, V> java.util.NavigableMap<K, V> subMap(java.util.NavigableMap<K, V> navigableMap, com.google.common.collect.Range<K> range) {
        if (navigableMap.comparator() != null && navigableMap.comparator() != com.google.common.collect.Ordering.natural() && range.hasLowerBound() && range.hasUpperBound()) {
            com.google.common.base.Preconditions.checkArgument(navigableMap.comparator().compare(range.lowerEndpoint(), range.upperEndpoint()) <= 0, "map is using a custom comparator which is inconsistent with the natural ordering.");
        }
        if (range.hasLowerBound() && range.hasUpperBound()) {
            K lowerEndpoint = range.lowerEndpoint();
            com.google.common.collect.BoundType lowerBoundType = range.lowerBoundType();
            com.google.common.collect.BoundType boundType = com.google.common.collect.BoundType.CLOSED;
            return navigableMap.subMap(lowerEndpoint, lowerBoundType == boundType, range.upperEndpoint(), range.upperBoundType() == boundType);
        }
        if (range.hasLowerBound()) {
            return navigableMap.tailMap(range.lowerEndpoint(), range.lowerBoundType() == com.google.common.collect.BoundType.CLOSED);
        }
        if (range.hasUpperBound()) {
            return navigableMap.headMap(range.upperEndpoint(), range.upperBoundType() == com.google.common.collect.BoundType.CLOSED);
        }
        return (java.util.NavigableMap) com.google.common.base.Preconditions.checkNotNull(navigableMap);
    }

    public static <K, V> com.google.common.collect.BiMap<K, V> synchronizedBiMap(com.google.common.collect.BiMap<K, V> biMap) {
        return com.google.common.collect.Synchronized.g(biMap, null);
    }

    @com.google.common.annotations.GwtIncompatible
    public static <K, V> java.util.NavigableMap<K, V> synchronizedNavigableMap(java.util.NavigableMap<K, V> navigableMap) {
        return com.google.common.collect.Synchronized.o(navigableMap);
    }

    public static <K, V> java.util.SortedMap<K, V> t(com.google.common.collect.Maps.FilteredEntrySortedMap<K, V> filteredEntrySortedMap, com.google.common.base.Predicate<? super java.util.Map.Entry<K, V>> predicate) {
        return new com.google.common.collect.Maps.FilteredEntrySortedMap(filteredEntrySortedMap.j(), com.google.common.base.Predicates.and(filteredEntrySortedMap.w, predicate));
    }

    public static <K, V> com.google.common.collect.ImmutableMap<K, V> toMap(java.lang.Iterable<K> iterable, com.google.common.base.Function<? super K, V> function) {
        return toMap(iterable.iterator(), function);
    }

    public static <K, V> com.google.common.collect.ImmutableMap<K, V> toMap(java.util.Iterator<K> it, com.google.common.base.Function<? super K, V> function) {
        com.google.common.base.Preconditions.checkNotNull(function);
        java.util.LinkedHashMap newLinkedHashMap = newLinkedHashMap();
        while (it.hasNext()) {
            K next = it.next();
            newLinkedHashMap.put(next, function.apply(next));
        }
        return com.google.common.collect.ImmutableMap.copyOf((java.util.Map) newLinkedHashMap);
    }

    public static <K, V1, V2> java.util.Map<K, V2> transformEntries(java.util.Map<K, V1> map, com.google.common.collect.Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new com.google.common.collect.Maps.TransformedEntriesMap(map, entryTransformer);
    }

    @com.google.common.annotations.GwtIncompatible
    public static <K, V1, V2> java.util.NavigableMap<K, V2> transformEntries(java.util.NavigableMap<K, V1> navigableMap, com.google.common.collect.Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new com.google.common.collect.Maps.TransformedEntriesNavigableMap(navigableMap, entryTransformer);
    }

    public static <K, V1, V2> java.util.SortedMap<K, V2> transformEntries(java.util.SortedMap<K, V1> sortedMap, com.google.common.collect.Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new com.google.common.collect.Maps.TransformedEntriesSortedMap(sortedMap, entryTransformer);
    }

    public static <K, V1, V2> java.util.Map<K, V2> transformValues(java.util.Map<K, V1> map, com.google.common.base.Function<? super V1, V2> function) {
        return transformEntries(map, h(function));
    }

    @com.google.common.annotations.GwtIncompatible
    public static <K, V1, V2> java.util.NavigableMap<K, V2> transformValues(java.util.NavigableMap<K, V1> navigableMap, com.google.common.base.Function<? super V1, V2> function) {
        return transformEntries((java.util.NavigableMap) navigableMap, h(function));
    }

    public static <K, V1, V2> java.util.SortedMap<K, V2> transformValues(java.util.SortedMap<K, V1> sortedMap, com.google.common.base.Function<? super V1, V2> function) {
        return transformEntries((java.util.SortedMap) sortedMap, h(function));
    }

    public static <E> com.google.common.collect.ImmutableMap<E, java.lang.Integer> u(java.util.Collection<E> collection) {
        com.google.common.collect.ImmutableMap.Builder builder = new com.google.common.collect.ImmutableMap.Builder(collection.size());
        java.util.Iterator<E> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            builder.put(it.next(), java.lang.Integer.valueOf(i));
            i++;
        }
        return builder.build();
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static <K, V> com.google.common.collect.ImmutableMap<K, V> uniqueIndex(java.lang.Iterable<V> iterable, com.google.common.base.Function<? super V, K> function) {
        return uniqueIndex(iterable.iterator(), function);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static <K, V> com.google.common.collect.ImmutableMap<K, V> uniqueIndex(java.util.Iterator<V> it, com.google.common.base.Function<? super V, K> function) {
        com.google.common.base.Preconditions.checkNotNull(function);
        com.google.common.collect.ImmutableMap.Builder builder = com.google.common.collect.ImmutableMap.builder();
        while (it.hasNext()) {
            V next = it.next();
            builder.put(function.apply(next), next);
        }
        try {
            return builder.build();
        } catch (java.lang.IllegalArgumentException e) {
            throw new java.lang.IllegalArgumentException(e.getMessage() + ". To index multiple values under a key, use Multimaps.index.");
        }
    }

    public static <K, V> com.google.common.collect.BiMap<K, V> unmodifiableBiMap(com.google.common.collect.BiMap<? extends K, ? extends V> biMap) {
        return new com.google.common.collect.Maps.UnmodifiableBiMap(biMap, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.google.common.annotations.GwtIncompatible
    public static <K, V> java.util.NavigableMap<K, V> unmodifiableNavigableMap(java.util.NavigableMap<K, ? extends V> navigableMap) {
        com.google.common.base.Preconditions.checkNotNull(navigableMap);
        return navigableMap instanceof com.google.common.collect.Maps.UnmodifiableNavigableMap ? navigableMap : new com.google.common.collect.Maps.UnmodifiableNavigableMap(navigableMap);
    }

    public static <K> com.google.common.base.Function<java.util.Map.Entry<K, ?>, K> v() {
        return com.google.common.collect.Maps.EntryFunction.KEY;
    }

    public static <K, V> java.util.Iterator<K> w(java.util.Iterator<java.util.Map.Entry<K, V>> it) {
        return new com.google.common.collect.Maps.AnonymousClass1(it);
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public static <K> K x(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.util.Map.Entry<K, ?> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getKey();
    }

    public static <K> com.google.common.base.Predicate<java.util.Map.Entry<K, ?>> y(com.google.common.base.Predicate<? super K> predicate) {
        return com.google.common.base.Predicates.compose(predicate, v());
    }

    public static <E> java.util.Comparator<? super E> z(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.util.Comparator<? super E> comparator) {
        return comparator != null ? comparator : com.google.common.collect.Ordering.natural();
    }
}
