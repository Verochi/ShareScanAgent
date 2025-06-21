package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes22.dex */
public abstract class ImmutableMap<K, V> implements java.util.Map<K, V>, java.io.Serializable {
    static final java.util.Map.Entry<?, ?>[] EMPTY_ENTRY_ARRAY = new java.util.Map.Entry[0];

    @com.google.errorprone.annotations.concurrent.LazyInit
    private transient com.google.common.collect.ImmutableSet<java.util.Map.Entry<K, V>> entrySet;

    @com.google.j2objc.annotations.RetainedWith
    @com.google.errorprone.annotations.concurrent.LazyInit
    private transient com.google.common.collect.ImmutableSet<K> keySet;

    @com.google.errorprone.annotations.concurrent.LazyInit
    private transient com.google.common.collect.ImmutableSetMultimap<K, V> multimapView;

    @com.google.j2objc.annotations.RetainedWith
    @com.google.errorprone.annotations.concurrent.LazyInit
    private transient com.google.common.collect.ImmutableCollection<V> values;

    /* renamed from: com.google.common.collect.ImmutableMap$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.common.collect.UnmodifiableIterator<K> {
        public final /* synthetic */ com.google.common.collect.UnmodifiableIterator n;

        public AnonymousClass1(com.google.common.collect.UnmodifiableIterator unmodifiableIterator) {
            this.n = unmodifiableIterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.n.hasNext();
        }

        @Override // java.util.Iterator
        public K next() {
            return (K) ((java.util.Map.Entry) this.n.next()).getKey();
        }
    }

    public static class Builder<K, V> {

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        public java.util.Comparator<? super V> a;
        public java.lang.Object[] b;
        public int c;
        public boolean d;

        public Builder() {
            this(4);
        }

        public Builder(int i) {
            this.b = new java.lang.Object[i * 2];
            this.c = 0;
            this.d = false;
        }

        public final void a(int i) {
            int i2 = i * 2;
            java.lang.Object[] objArr = this.b;
            if (i2 > objArr.length) {
                this.b = java.util.Arrays.copyOf(objArr, com.google.common.collect.ImmutableCollection.Builder.a(objArr.length, i2));
                this.d = false;
            }
        }

        public void b() {
            int i;
            if (this.a != null) {
                if (this.d) {
                    this.b = java.util.Arrays.copyOf(this.b, this.c * 2);
                }
                java.util.Map.Entry[] entryArr = new java.util.Map.Entry[this.c];
                int i2 = 0;
                while (true) {
                    i = this.c;
                    if (i2 >= i) {
                        break;
                    }
                    java.lang.Object[] objArr = this.b;
                    int i3 = i2 * 2;
                    entryArr[i2] = new java.util.AbstractMap.SimpleImmutableEntry(objArr[i3], objArr[i3 + 1]);
                    i2++;
                }
                java.util.Arrays.sort(entryArr, 0, i, com.google.common.collect.Ordering.from(this.a).onResultOf(com.google.common.collect.Maps.P()));
                for (int i4 = 0; i4 < this.c; i4++) {
                    int i5 = i4 * 2;
                    this.b[i5] = entryArr[i4].getKey();
                    this.b[i5 + 1] = entryArr[i4].getValue();
                }
            }
        }

        public com.google.common.collect.ImmutableMap<K, V> build() {
            b();
            this.d = true;
            return com.google.common.collect.RegularImmutableMap.create(this.c, this.b);
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        @com.google.common.annotations.Beta
        public com.google.common.collect.ImmutableMap.Builder<K, V> orderEntriesByValue(java.util.Comparator<? super V> comparator) {
            com.google.common.base.Preconditions.checkState(this.a == null, "valueComparator was already set");
            this.a = (java.util.Comparator) com.google.common.base.Preconditions.checkNotNull(comparator, "valueComparator");
            return this;
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableMap.Builder<K, V> put(K k, V v) {
            a(this.c + 1);
            com.google.common.collect.CollectPreconditions.a(k, v);
            java.lang.Object[] objArr = this.b;
            int i = this.c;
            objArr[i * 2] = k;
            objArr[(i * 2) + 1] = v;
            this.c = i + 1;
            return this;
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableMap.Builder<K, V> put(java.util.Map.Entry<? extends K, ? extends V> entry) {
            return put(entry.getKey(), entry.getValue());
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        @com.google.common.annotations.Beta
        public com.google.common.collect.ImmutableMap.Builder<K, V> putAll(java.lang.Iterable<? extends java.util.Map.Entry<? extends K, ? extends V>> iterable) {
            if (iterable instanceof java.util.Collection) {
                a(this.c + ((java.util.Collection) iterable).size());
            }
            java.util.Iterator<? extends java.util.Map.Entry<? extends K, ? extends V>> it = iterable.iterator();
            while (it.hasNext()) {
                put(it.next());
            }
            return this;
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableMap.Builder<K, V> putAll(java.util.Map<? extends K, ? extends V> map) {
            return putAll(map.entrySet());
        }
    }

    public static abstract class IteratorBasedImmutableMap<K, V> extends com.google.common.collect.ImmutableMap<K, V> {

        /* renamed from: com.google.common.collect.ImmutableMap$IteratorBasedImmutableMap$1EntrySetImpl, reason: invalid class name */
        public class C1EntrySetImpl extends com.google.common.collect.ImmutableMapEntrySet<K, V> {
            public C1EntrySetImpl() {
            }

            @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
            public com.google.common.collect.UnmodifiableIterator<java.util.Map.Entry<K, V>> iterator() {
                return com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap.this.entryIterator();
            }

            @Override // com.google.common.collect.ImmutableMapEntrySet
            public com.google.common.collect.ImmutableMap<K, V> map() {
                return com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap.this;
            }
        }

        @Override // com.google.common.collect.ImmutableMap
        public com.google.common.collect.ImmutableSet<java.util.Map.Entry<K, V>> createEntrySet() {
            return new com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap.C1EntrySetImpl();
        }

        @Override // com.google.common.collect.ImmutableMap
        public com.google.common.collect.ImmutableSet<K> createKeySet() {
            return new com.google.common.collect.ImmutableMapKeySet(this);
        }

        @Override // com.google.common.collect.ImmutableMap
        public com.google.common.collect.ImmutableCollection<V> createValues() {
            return new com.google.common.collect.ImmutableMapValues(this);
        }

        public abstract com.google.common.collect.UnmodifiableIterator<java.util.Map.Entry<K, V>> entryIterator();

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ java.util.Set entrySet() {
            return super.entrySet();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ java.util.Set keySet() {
            return super.keySet();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ java.util.Collection values() {
            return super.values();
        }
    }

    public final class MapViewOfValuesAsSingletonSets extends com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap<K, com.google.common.collect.ImmutableSet<V>> {

        /* renamed from: com.google.common.collect.ImmutableMap$MapViewOfValuesAsSingletonSets$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.collect.UnmodifiableIterator<java.util.Map.Entry<K, com.google.common.collect.ImmutableSet<V>>> {
            public final /* synthetic */ java.util.Iterator n;

            /* renamed from: com.google.common.collect.ImmutableMap$MapViewOfValuesAsSingletonSets$1$1, reason: invalid class name and collision with other inner class name */
            public class C03401 extends com.google.common.collect.AbstractMapEntry<K, com.google.common.collect.ImmutableSet<V>> {
                public final /* synthetic */ java.util.Map.Entry n;

                public C03401(java.util.Map.Entry entry) {
                    this.n = entry;
                }

                @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                public K getKey() {
                    return (K) this.n.getKey();
                }

                @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                /* renamed from: i, reason: merged with bridge method [inline-methods] */
                public com.google.common.collect.ImmutableSet<V> getValue() {
                    return com.google.common.collect.ImmutableSet.of(this.n.getValue());
                }
            }

            public AnonymousClass1(java.util.Iterator it) {
                this.n = it;
            }

            @Override // java.util.Iterator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public java.util.Map.Entry<K, com.google.common.collect.ImmutableSet<V>> next() {
                return new com.google.common.collect.ImmutableMap.MapViewOfValuesAsSingletonSets.AnonymousClass1.C03401((java.util.Map.Entry) this.n.next());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.n.hasNext();
            }
        }

        private MapViewOfValuesAsSingletonSets() {
        }

        public /* synthetic */ MapViewOfValuesAsSingletonSets(com.google.common.collect.ImmutableMap immutableMap, com.google.common.collect.ImmutableMap.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public boolean containsKey(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return com.google.common.collect.ImmutableMap.this.containsKey(obj);
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.common.collect.ImmutableMap
        public com.google.common.collect.ImmutableSet<K> createKeySet() {
            return com.google.common.collect.ImmutableMap.this.keySet();
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
        public com.google.common.collect.UnmodifiableIterator<java.util.Map.Entry<K, com.google.common.collect.ImmutableSet<V>>> entryIterator() {
            return new com.google.common.collect.ImmutableMap.MapViewOfValuesAsSingletonSets.AnonymousClass1(com.google.common.collect.ImmutableMap.this.entrySet().iterator());
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public com.google.common.collect.ImmutableSet<V> get(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            java.lang.Object obj2 = com.google.common.collect.ImmutableMap.this.get(obj);
            if (obj2 == null) {
                return null;
            }
            return com.google.common.collect.ImmutableSet.of(obj2);
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public int hashCode() {
            return com.google.common.collect.ImmutableMap.this.hashCode();
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isHashCodeFast() {
            return com.google.common.collect.ImmutableMap.this.isHashCodeFast();
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return com.google.common.collect.ImmutableMap.this.isPartialView();
        }

        @Override // java.util.Map
        public int size() {
            return com.google.common.collect.ImmutableMap.this.size();
        }
    }

    public static class SerializedForm implements java.io.Serializable {
        private static final long serialVersionUID = 0;
        private final java.lang.Object[] keys;
        private final java.lang.Object[] values;

        public SerializedForm(com.google.common.collect.ImmutableMap<?, ?> immutableMap) {
            this.keys = new java.lang.Object[immutableMap.size()];
            this.values = new java.lang.Object[immutableMap.size()];
            com.google.common.collect.UnmodifiableIterator<java.util.Map.Entry<?, ?>> it = immutableMap.entrySet().iterator();
            int i = 0;
            while (it.hasNext()) {
                java.util.Map.Entry<?, ?> next = it.next();
                this.keys[i] = next.getKey();
                this.values[i] = next.getValue();
                i++;
            }
        }

        public java.lang.Object createMap(com.google.common.collect.ImmutableMap.Builder<java.lang.Object, java.lang.Object> builder) {
            int i = 0;
            while (true) {
                java.lang.Object[] objArr = this.keys;
                if (i >= objArr.length) {
                    return builder.build();
                }
                builder.put(objArr[i], this.values[i]);
                i++;
            }
        }

        public java.lang.Object readResolve() {
            return createMap(new com.google.common.collect.ImmutableMap.Builder<>(this.keys.length));
        }
    }

    public static <K, V> com.google.common.collect.ImmutableMap.Builder<K, V> builder() {
        return new com.google.common.collect.ImmutableMap.Builder<>();
    }

    @com.google.common.annotations.Beta
    public static <K, V> com.google.common.collect.ImmutableMap.Builder<K, V> builderWithExpectedSize(int i) {
        com.google.common.collect.CollectPreconditions.b(i, "expectedSize");
        return new com.google.common.collect.ImmutableMap.Builder<>(i);
    }

    public static void checkNoConflict(boolean z, java.lang.String str, java.util.Map.Entry<?, ?> entry, java.util.Map.Entry<?, ?> entry2) {
        if (!z) {
            throw conflictException(str, entry, entry2);
        }
    }

    public static java.lang.IllegalArgumentException conflictException(java.lang.String str, java.lang.Object obj, java.lang.Object obj2) {
        return new java.lang.IllegalArgumentException("Multiple entries with same " + str + ": " + obj + " and " + obj2);
    }

    @com.google.common.annotations.Beta
    public static <K, V> com.google.common.collect.ImmutableMap<K, V> copyOf(java.lang.Iterable<? extends java.util.Map.Entry<? extends K, ? extends V>> iterable) {
        com.google.common.collect.ImmutableMap.Builder builder = new com.google.common.collect.ImmutableMap.Builder(iterable instanceof java.util.Collection ? ((java.util.Collection) iterable).size() : 4);
        builder.putAll(iterable);
        return builder.build();
    }

    public static <K, V> com.google.common.collect.ImmutableMap<K, V> copyOf(java.util.Map<? extends K, ? extends V> map) {
        if ((map instanceof com.google.common.collect.ImmutableMap) && !(map instanceof java.util.SortedMap)) {
            com.google.common.collect.ImmutableMap<K, V> immutableMap = (com.google.common.collect.ImmutableMap) map;
            if (!immutableMap.isPartialView()) {
                return immutableMap;
            }
        }
        return copyOf(map.entrySet());
    }

    public static <K, V> java.util.Map.Entry<K, V> entryOf(K k, V v) {
        com.google.common.collect.CollectPreconditions.a(k, v);
        return new java.util.AbstractMap.SimpleImmutableEntry(k, v);
    }

    public static <K, V> com.google.common.collect.ImmutableMap<K, V> of() {
        return (com.google.common.collect.ImmutableMap<K, V>) com.google.common.collect.RegularImmutableMap.EMPTY;
    }

    public static <K, V> com.google.common.collect.ImmutableMap<K, V> of(K k, V v) {
        com.google.common.collect.CollectPreconditions.a(k, v);
        return com.google.common.collect.RegularImmutableMap.create(1, new java.lang.Object[]{k, v});
    }

    public static <K, V> com.google.common.collect.ImmutableMap<K, V> of(K k, V v, K k2, V v2) {
        com.google.common.collect.CollectPreconditions.a(k, v);
        com.google.common.collect.CollectPreconditions.a(k2, v2);
        return com.google.common.collect.RegularImmutableMap.create(2, new java.lang.Object[]{k, v, k2, v2});
    }

    public static <K, V> com.google.common.collect.ImmutableMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        com.google.common.collect.CollectPreconditions.a(k, v);
        com.google.common.collect.CollectPreconditions.a(k2, v2);
        com.google.common.collect.CollectPreconditions.a(k3, v3);
        return com.google.common.collect.RegularImmutableMap.create(3, new java.lang.Object[]{k, v, k2, v2, k3, v3});
    }

    public static <K, V> com.google.common.collect.ImmutableMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        com.google.common.collect.CollectPreconditions.a(k, v);
        com.google.common.collect.CollectPreconditions.a(k2, v2);
        com.google.common.collect.CollectPreconditions.a(k3, v3);
        com.google.common.collect.CollectPreconditions.a(k4, v4);
        return com.google.common.collect.RegularImmutableMap.create(4, new java.lang.Object[]{k, v, k2, v2, k3, v3, k4, v4});
    }

    public static <K, V> com.google.common.collect.ImmutableMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        com.google.common.collect.CollectPreconditions.a(k, v);
        com.google.common.collect.CollectPreconditions.a(k2, v2);
        com.google.common.collect.CollectPreconditions.a(k3, v3);
        com.google.common.collect.CollectPreconditions.a(k4, v4);
        com.google.common.collect.CollectPreconditions.a(k5, v5);
        return com.google.common.collect.RegularImmutableMap.create(5, new java.lang.Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5});
    }

    public com.google.common.collect.ImmutableSetMultimap<K, V> asMultimap() {
        if (isEmpty()) {
            return com.google.common.collect.ImmutableSetMultimap.of();
        }
        com.google.common.collect.ImmutableSetMultimap<K, V> immutableSetMultimap = this.multimapView;
        if (immutableSetMultimap != null) {
            return immutableSetMultimap;
        }
        com.google.common.collect.ImmutableSetMultimap<K, V> immutableSetMultimap2 = new com.google.common.collect.ImmutableSetMultimap<>(new com.google.common.collect.ImmutableMap.MapViewOfValuesAsSingletonSets(this, null), size(), null);
        this.multimapView = immutableSetMultimap2;
        return immutableSetMultimap2;
    }

    @Override // java.util.Map
    @java.lang.Deprecated
    public final void clear() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return values().contains(obj);
    }

    public abstract com.google.common.collect.ImmutableSet<java.util.Map.Entry<K, V>> createEntrySet();

    public abstract com.google.common.collect.ImmutableSet<K> createKeySet();

    public abstract com.google.common.collect.ImmutableCollection<V> createValues();

    @Override // java.util.Map
    public com.google.common.collect.ImmutableSet<java.util.Map.Entry<K, V>> entrySet() {
        com.google.common.collect.ImmutableSet<java.util.Map.Entry<K, V>> immutableSet = this.entrySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        com.google.common.collect.ImmutableSet<java.util.Map.Entry<K, V>> createEntrySet = createEntrySet();
        this.entrySet = createEntrySet;
        return createEntrySet;
    }

    @Override // java.util.Map
    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return com.google.common.collect.Maps.p(this, obj);
    }

    @Override // java.util.Map
    public abstract V get(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj);

    @Override // java.util.Map
    public final V getOrDefault(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    @Override // java.util.Map
    public int hashCode() {
        return com.google.common.collect.Sets.b(entrySet());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isHashCodeFast() {
        return false;
    }

    public abstract boolean isPartialView();

    public com.google.common.collect.UnmodifiableIterator<K> keyIterator() {
        return new com.google.common.collect.ImmutableMap.AnonymousClass1(entrySet().iterator());
    }

    @Override // java.util.Map
    public com.google.common.collect.ImmutableSet<K> keySet() {
        com.google.common.collect.ImmutableSet<K> immutableSet = this.keySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        com.google.common.collect.ImmutableSet<K> createKeySet = createKeySet();
        this.keySet = createKeySet;
        return createKeySet;
    }

    @Override // java.util.Map
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @java.lang.Deprecated
    public final V put(K k, V v) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.util.Map
    @java.lang.Deprecated
    public final void putAll(java.util.Map<? extends K, ? extends V> map) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.util.Map
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @java.lang.Deprecated
    public final V remove(java.lang.Object obj) {
        throw new java.lang.UnsupportedOperationException();
    }

    public java.lang.String toString() {
        return com.google.common.collect.Maps.I(this);
    }

    @Override // java.util.Map
    public com.google.common.collect.ImmutableCollection<V> values() {
        com.google.common.collect.ImmutableCollection<V> immutableCollection = this.values;
        if (immutableCollection != null) {
            return immutableCollection;
        }
        com.google.common.collect.ImmutableCollection<V> createValues = createValues();
        this.values = createValues;
        return createValues;
    }

    java.lang.Object writeReplace() {
        return new com.google.common.collect.ImmutableMap.SerializedForm(this);
    }
}
