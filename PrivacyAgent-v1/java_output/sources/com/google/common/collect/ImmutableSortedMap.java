package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes22.dex */
public final class ImmutableSortedMap<K, V> extends com.google.common.collect.ImmutableSortedMapFauxverideShim<K, V> implements java.util.NavigableMap<K, V> {
    private static final long serialVersionUID = 0;
    private transient com.google.common.collect.ImmutableSortedMap<K, V> descendingMap;
    private final transient com.google.common.collect.RegularImmutableSortedSet<K> keySet;
    private final transient com.google.common.collect.ImmutableList<V> valueList;
    private static final java.util.Comparator<java.lang.Comparable> NATURAL_ORDER = com.google.common.collect.Ordering.natural();
    private static final com.google.common.collect.ImmutableSortedMap<java.lang.Comparable, java.lang.Object> NATURAL_EMPTY_MAP = new com.google.common.collect.ImmutableSortedMap<>(com.google.common.collect.ImmutableSortedSet.emptySet(com.google.common.collect.Ordering.natural()), com.google.common.collect.ImmutableList.of());

    /* renamed from: com.google.common.collect.ImmutableSortedMap$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.util.Comparator<java.util.Map.Entry<K, V>> {
        public final /* synthetic */ java.util.Comparator n;

        public AnonymousClass1(java.util.Comparator comparator) {
            this.n = comparator;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(java.util.Map.Entry<K, V> entry, java.util.Map.Entry<K, V> entry2) {
            return this.n.compare(entry.getKey(), entry2.getKey());
        }
    }

    /* renamed from: com.google.common.collect.ImmutableSortedMap$1EntrySet, reason: invalid class name */
    public class C1EntrySet extends com.google.common.collect.ImmutableMapEntrySet<K, V> {

        /* renamed from: com.google.common.collect.ImmutableSortedMap$1EntrySet$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.collect.ImmutableList<java.util.Map.Entry<K, V>> {
            public AnonymousClass1() {
            }

            @Override // java.util.List
            public java.util.Map.Entry<K, V> get(int i) {
                return new java.util.AbstractMap.SimpleImmutableEntry(com.google.common.collect.ImmutableSortedMap.this.keySet.asList().get(i), com.google.common.collect.ImmutableSortedMap.this.valueList.get(i));
            }

            @Override // com.google.common.collect.ImmutableCollection
            public boolean isPartialView() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return com.google.common.collect.ImmutableSortedMap.this.size();
            }
        }

        public C1EntrySet() {
        }

        @Override // com.google.common.collect.ImmutableSet
        public com.google.common.collect.ImmutableList<java.util.Map.Entry<K, V>> createAsList() {
            return new com.google.common.collect.ImmutableSortedMap.C1EntrySet.AnonymousClass1();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public com.google.common.collect.UnmodifiableIterator<java.util.Map.Entry<K, V>> iterator() {
            return asList().iterator();
        }

        @Override // com.google.common.collect.ImmutableMapEntrySet
        public com.google.common.collect.ImmutableMap<K, V> map() {
            return com.google.common.collect.ImmutableSortedMap.this;
        }
    }

    public static class Builder<K, V> extends com.google.common.collect.ImmutableMap.Builder<K, V> {
        public transient java.lang.Object[] e;
        public transient java.lang.Object[] f;
        public final java.util.Comparator<? super K> g;

        public Builder(java.util.Comparator<? super K> comparator) {
            this(comparator, 4);
        }

        public Builder(java.util.Comparator<? super K> comparator, int i) {
            this.g = (java.util.Comparator) com.google.common.base.Preconditions.checkNotNull(comparator);
            this.e = new java.lang.Object[i];
            this.f = new java.lang.Object[i];
        }

        private void a(int i) {
            java.lang.Object[] objArr = this.e;
            if (i > objArr.length) {
                int a = com.google.common.collect.ImmutableCollection.Builder.a(objArr.length, i);
                this.e = java.util.Arrays.copyOf(this.e, a);
                this.f = java.util.Arrays.copyOf(this.f, a);
            }
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public com.google.common.collect.ImmutableSortedMap<K, V> build() {
            int i = this.c;
            if (i == 0) {
                return com.google.common.collect.ImmutableSortedMap.emptyMap(this.g);
            }
            if (i == 1) {
                return com.google.common.collect.ImmutableSortedMap.of(this.g, this.e[0], this.f[0]);
            }
            java.lang.Object[] copyOf = java.util.Arrays.copyOf(this.e, i);
            java.util.Arrays.sort(copyOf, this.g);
            java.lang.Object[] objArr = new java.lang.Object[this.c];
            for (int i2 = 0; i2 < this.c; i2++) {
                if (i2 > 0) {
                    int i3 = i2 - 1;
                    if (this.g.compare(copyOf[i3], copyOf[i2]) == 0) {
                        throw new java.lang.IllegalArgumentException("keys required to be distinct but compared as equal: " + copyOf[i3] + " and " + copyOf[i2]);
                    }
                }
                objArr[java.util.Arrays.binarySearch(copyOf, this.e[i2], this.g)] = this.f[i2];
            }
            return new com.google.common.collect.ImmutableSortedMap<>(new com.google.common.collect.RegularImmutableSortedSet(com.google.common.collect.ImmutableList.asImmutableList(copyOf), this.g), com.google.common.collect.ImmutableList.asImmutableList(objArr));
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        @com.google.common.annotations.Beta
        @java.lang.Deprecated
        public com.google.common.collect.ImmutableSortedMap.Builder<K, V> orderEntriesByValue(java.util.Comparator<? super V> comparator) {
            throw new java.lang.UnsupportedOperationException("Not available on ImmutableSortedMap.Builder");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMap.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ com.google.common.collect.ImmutableMap.Builder put(java.lang.Object obj, java.lang.Object obj2) {
            return put((com.google.common.collect.ImmutableSortedMap.Builder<K, V>) obj, obj2);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableSortedMap.Builder<K, V> put(K k, V v) {
            a(this.c + 1);
            com.google.common.collect.CollectPreconditions.a(k, v);
            java.lang.Object[] objArr = this.e;
            int i = this.c;
            objArr[i] = k;
            this.f[i] = v;
            this.c = i + 1;
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableSortedMap.Builder<K, V> put(java.util.Map.Entry<? extends K, ? extends V> entry) {
            super.put((java.util.Map.Entry) entry);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        @com.google.common.annotations.Beta
        public com.google.common.collect.ImmutableSortedMap.Builder<K, V> putAll(java.lang.Iterable<? extends java.util.Map.Entry<? extends K, ? extends V>> iterable) {
            super.putAll((java.lang.Iterable) iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableSortedMap.Builder<K, V> putAll(java.util.Map<? extends K, ? extends V> map) {
            super.putAll((java.util.Map) map);
            return this;
        }
    }

    public static class SerializedForm extends com.google.common.collect.ImmutableMap.SerializedForm {
        private static final long serialVersionUID = 0;
        private final java.util.Comparator<java.lang.Object> comparator;

        public SerializedForm(com.google.common.collect.ImmutableSortedMap<?, ?> immutableSortedMap) {
            super(immutableSortedMap);
            this.comparator = immutableSortedMap.comparator();
        }

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        public java.lang.Object readResolve() {
            return createMap(new com.google.common.collect.ImmutableSortedMap.Builder(this.comparator));
        }
    }

    public ImmutableSortedMap(com.google.common.collect.RegularImmutableSortedSet<K> regularImmutableSortedSet, com.google.common.collect.ImmutableList<V> immutableList) {
        this(regularImmutableSortedSet, immutableList, null);
    }

    public ImmutableSortedMap(com.google.common.collect.RegularImmutableSortedSet<K> regularImmutableSortedSet, com.google.common.collect.ImmutableList<V> immutableList, com.google.common.collect.ImmutableSortedMap<K, V> immutableSortedMap) {
        this.keySet = regularImmutableSortedSet;
        this.valueList = immutableList;
        this.descendingMap = immutableSortedMap;
    }

    @com.google.common.annotations.Beta
    public static <K, V> com.google.common.collect.ImmutableSortedMap<K, V> copyOf(java.lang.Iterable<? extends java.util.Map.Entry<? extends K, ? extends V>> iterable) {
        return copyOf(iterable, (com.google.common.collect.Ordering) NATURAL_ORDER);
    }

    @com.google.common.annotations.Beta
    public static <K, V> com.google.common.collect.ImmutableSortedMap<K, V> copyOf(java.lang.Iterable<? extends java.util.Map.Entry<? extends K, ? extends V>> iterable, java.util.Comparator<? super K> comparator) {
        return fromEntries((java.util.Comparator) com.google.common.base.Preconditions.checkNotNull(comparator), false, iterable);
    }

    public static <K, V> com.google.common.collect.ImmutableSortedMap<K, V> copyOf(java.util.Map<? extends K, ? extends V> map) {
        return copyOfInternal(map, (com.google.common.collect.Ordering) NATURAL_ORDER);
    }

    public static <K, V> com.google.common.collect.ImmutableSortedMap<K, V> copyOf(java.util.Map<? extends K, ? extends V> map, java.util.Comparator<? super K> comparator) {
        return copyOfInternal(map, (java.util.Comparator) com.google.common.base.Preconditions.checkNotNull(comparator));
    }

    private static <K, V> com.google.common.collect.ImmutableSortedMap<K, V> copyOfInternal(java.util.Map<? extends K, ? extends V> map, java.util.Comparator<? super K> comparator) {
        boolean z = false;
        if (map instanceof java.util.SortedMap) {
            java.util.Comparator<? super K> comparator2 = ((java.util.SortedMap) map).comparator();
            if (comparator2 != null) {
                z = comparator.equals(comparator2);
            } else if (comparator == NATURAL_ORDER) {
                z = true;
            }
        }
        if (z && (map instanceof com.google.common.collect.ImmutableSortedMap)) {
            com.google.common.collect.ImmutableSortedMap<K, V> immutableSortedMap = (com.google.common.collect.ImmutableSortedMap) map;
            if (!immutableSortedMap.isPartialView()) {
                return immutableSortedMap;
            }
        }
        return fromEntries(comparator, z, map.entrySet());
    }

    public static <K, V> com.google.common.collect.ImmutableSortedMap<K, V> copyOfSorted(java.util.SortedMap<K, ? extends V> sortedMap) {
        java.util.Comparator<? super K> comparator = sortedMap.comparator();
        if (comparator == null) {
            comparator = NATURAL_ORDER;
        }
        if (sortedMap instanceof com.google.common.collect.ImmutableSortedMap) {
            com.google.common.collect.ImmutableSortedMap<K, V> immutableSortedMap = (com.google.common.collect.ImmutableSortedMap) sortedMap;
            if (!immutableSortedMap.isPartialView()) {
                return immutableSortedMap;
            }
        }
        return fromEntries(comparator, true, sortedMap.entrySet());
    }

    public static <K, V> com.google.common.collect.ImmutableSortedMap<K, V> emptyMap(java.util.Comparator<? super K> comparator) {
        return com.google.common.collect.Ordering.natural().equals(comparator) ? of() : new com.google.common.collect.ImmutableSortedMap<>(com.google.common.collect.ImmutableSortedSet.emptySet(comparator), com.google.common.collect.ImmutableList.of());
    }

    private static <K, V> com.google.common.collect.ImmutableSortedMap<K, V> fromEntries(java.util.Comparator<? super K> comparator, boolean z, java.lang.Iterable<? extends java.util.Map.Entry<? extends K, ? extends V>> iterable) {
        java.util.Map.Entry[] entryArr = (java.util.Map.Entry[]) com.google.common.collect.Iterables.g(iterable, com.google.common.collect.ImmutableMap.EMPTY_ENTRY_ARRAY);
        return fromEntries(comparator, z, entryArr, entryArr.length);
    }

    private static <K, V> com.google.common.collect.ImmutableSortedMap<K, V> fromEntries(java.util.Comparator<? super K> comparator, boolean z, java.util.Map.Entry<K, V>[] entryArr, int i) {
        if (i == 0) {
            return emptyMap(comparator);
        }
        if (i == 1) {
            return of(comparator, entryArr[0].getKey(), entryArr[0].getValue());
        }
        java.lang.Object[] objArr = new java.lang.Object[i];
        java.lang.Object[] objArr2 = new java.lang.Object[i];
        if (z) {
            for (int i2 = 0; i2 < i; i2++) {
                K key = entryArr[i2].getKey();
                V value = entryArr[i2].getValue();
                com.google.common.collect.CollectPreconditions.a(key, value);
                objArr[i2] = key;
                objArr2[i2] = value;
            }
        } else {
            java.util.Arrays.sort(entryArr, 0, i, new com.google.common.collect.ImmutableSortedMap.AnonymousClass1(comparator));
            java.lang.Object key2 = entryArr[0].getKey();
            objArr[0] = key2;
            V value2 = entryArr[0].getValue();
            objArr2[0] = value2;
            com.google.common.collect.CollectPreconditions.a(objArr[0], value2);
            int i3 = 1;
            while (i3 < i) {
                java.lang.Object key3 = entryArr[i3].getKey();
                V value3 = entryArr[i3].getValue();
                com.google.common.collect.CollectPreconditions.a(key3, value3);
                objArr[i3] = key3;
                objArr2[i3] = value3;
                com.google.common.collect.ImmutableMap.checkNoConflict(comparator.compare(key2, key3) != 0, "key", entryArr[i3 - 1], entryArr[i3]);
                i3++;
                key2 = key3;
            }
        }
        return new com.google.common.collect.ImmutableSortedMap<>(new com.google.common.collect.RegularImmutableSortedSet(com.google.common.collect.ImmutableList.asImmutableList(objArr), comparator), com.google.common.collect.ImmutableList.asImmutableList(objArr2));
    }

    private com.google.common.collect.ImmutableSortedMap<K, V> getSubMap(int i, int i2) {
        return (i == 0 && i2 == size()) ? this : i == i2 ? emptyMap(comparator()) : new com.google.common.collect.ImmutableSortedMap<>(this.keySet.getSubSet(i, i2), this.valueList.subList(i, i2));
    }

    public static <K extends java.lang.Comparable<?>, V> com.google.common.collect.ImmutableSortedMap.Builder<K, V> naturalOrder() {
        return new com.google.common.collect.ImmutableSortedMap.Builder<>(com.google.common.collect.Ordering.natural());
    }

    public static <K, V> com.google.common.collect.ImmutableSortedMap<K, V> of() {
        return (com.google.common.collect.ImmutableSortedMap<K, V>) NATURAL_EMPTY_MAP;
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static com.google.common.collect.ImmutableSortedMap of(java.lang.Comparable comparable, java.lang.Object obj) {
        return of(com.google.common.collect.Ordering.natural(), comparable, obj);
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static com.google.common.collect.ImmutableSortedMap of(java.lang.Comparable comparable, java.lang.Object obj, java.lang.Comparable comparable2, java.lang.Object obj2) {
        return ofEntries(com.google.common.collect.ImmutableMap.entryOf(comparable, obj), com.google.common.collect.ImmutableMap.entryOf(comparable2, obj2));
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static com.google.common.collect.ImmutableSortedMap of(java.lang.Comparable comparable, java.lang.Object obj, java.lang.Comparable comparable2, java.lang.Object obj2, java.lang.Comparable comparable3, java.lang.Object obj3) {
        return ofEntries(com.google.common.collect.ImmutableMap.entryOf(comparable, obj), com.google.common.collect.ImmutableMap.entryOf(comparable2, obj2), com.google.common.collect.ImmutableMap.entryOf(comparable3, obj3));
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static com.google.common.collect.ImmutableSortedMap of(java.lang.Comparable comparable, java.lang.Object obj, java.lang.Comparable comparable2, java.lang.Object obj2, java.lang.Comparable comparable3, java.lang.Object obj3, java.lang.Comparable comparable4, java.lang.Object obj4) {
        return ofEntries(com.google.common.collect.ImmutableMap.entryOf(comparable, obj), com.google.common.collect.ImmutableMap.entryOf(comparable2, obj2), com.google.common.collect.ImmutableMap.entryOf(comparable3, obj3), com.google.common.collect.ImmutableMap.entryOf(comparable4, obj4));
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static com.google.common.collect.ImmutableSortedMap of(java.lang.Comparable comparable, java.lang.Object obj, java.lang.Comparable comparable2, java.lang.Object obj2, java.lang.Comparable comparable3, java.lang.Object obj3, java.lang.Comparable comparable4, java.lang.Object obj4, java.lang.Comparable comparable5, java.lang.Object obj5) {
        return ofEntries(com.google.common.collect.ImmutableMap.entryOf(comparable, obj), com.google.common.collect.ImmutableMap.entryOf(comparable2, obj2), com.google.common.collect.ImmutableMap.entryOf(comparable3, obj3), com.google.common.collect.ImmutableMap.entryOf(comparable4, obj4), com.google.common.collect.ImmutableMap.entryOf(comparable5, obj5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> com.google.common.collect.ImmutableSortedMap<K, V> of(java.util.Comparator<? super K> comparator, K k, V v) {
        return new com.google.common.collect.ImmutableSortedMap<>(new com.google.common.collect.RegularImmutableSortedSet(com.google.common.collect.ImmutableList.of(k), (java.util.Comparator) com.google.common.base.Preconditions.checkNotNull(comparator)), com.google.common.collect.ImmutableList.of(v));
    }

    private static <K extends java.lang.Comparable<? super K>, V> com.google.common.collect.ImmutableSortedMap<K, V> ofEntries(java.util.Map.Entry<K, V>... entryArr) {
        return fromEntries(com.google.common.collect.Ordering.natural(), false, entryArr, entryArr.length);
    }

    public static <K, V> com.google.common.collect.ImmutableSortedMap.Builder<K, V> orderedBy(java.util.Comparator<K> comparator) {
        return new com.google.common.collect.ImmutableSortedMap.Builder<>(comparator);
    }

    public static <K extends java.lang.Comparable<?>, V> com.google.common.collect.ImmutableSortedMap.Builder<K, V> reverseOrder() {
        return new com.google.common.collect.ImmutableSortedMap.Builder<>(com.google.common.collect.Ordering.natural().reverse());
    }

    @Override // java.util.NavigableMap
    public java.util.Map.Entry<K, V> ceilingEntry(K k) {
        return tailMap((com.google.common.collect.ImmutableSortedMap<K, V>) k, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K k) {
        return (K) com.google.common.collect.Maps.x(ceilingEntry(k));
    }

    @Override // java.util.SortedMap
    public java.util.Comparator<? super K> comparator() {
        return keySet().comparator();
    }

    @Override // com.google.common.collect.ImmutableMap
    public com.google.common.collect.ImmutableSet<java.util.Map.Entry<K, V>> createEntrySet() {
        return isEmpty() ? com.google.common.collect.ImmutableSet.of() : new com.google.common.collect.ImmutableSortedMap.C1EntrySet();
    }

    @Override // com.google.common.collect.ImmutableMap
    public com.google.common.collect.ImmutableSet<K> createKeySet() {
        throw new java.lang.AssertionError("should never be called");
    }

    @Override // com.google.common.collect.ImmutableMap
    public com.google.common.collect.ImmutableCollection<V> createValues() {
        throw new java.lang.AssertionError("should never be called");
    }

    @Override // java.util.NavigableMap
    public com.google.common.collect.ImmutableSortedSet<K> descendingKeySet() {
        return this.keySet.descendingSet();
    }

    @Override // java.util.NavigableMap
    public com.google.common.collect.ImmutableSortedMap<K, V> descendingMap() {
        com.google.common.collect.ImmutableSortedMap<K, V> immutableSortedMap = this.descendingMap;
        return immutableSortedMap == null ? isEmpty() ? emptyMap(com.google.common.collect.Ordering.from(comparator()).reverse()) : new com.google.common.collect.ImmutableSortedMap<>((com.google.common.collect.RegularImmutableSortedSet) this.keySet.descendingSet(), this.valueList.reverse(), this) : immutableSortedMap;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public com.google.common.collect.ImmutableSet<java.util.Map.Entry<K, V>> entrySet() {
        return super.entrySet();
    }

    @Override // java.util.NavigableMap
    public java.util.Map.Entry<K, V> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return entrySet().asList().get(0);
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        return keySet().first();
    }

    @Override // java.util.NavigableMap
    public java.util.Map.Entry<K, V> floorEntry(K k) {
        return headMap((com.google.common.collect.ImmutableSortedMap<K, V>) k, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K floorKey(K k) {
        return (K) com.google.common.collect.Maps.x(floorEntry(k));
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        int indexOf = this.keySet.indexOf(obj);
        if (indexOf == -1) {
            return null;
        }
        return this.valueList.get(indexOf);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public com.google.common.collect.ImmutableSortedMap<K, V> headMap(K k) {
        return headMap((com.google.common.collect.ImmutableSortedMap<K, V>) k, false);
    }

    @Override // java.util.NavigableMap
    public com.google.common.collect.ImmutableSortedMap<K, V> headMap(K k, boolean z) {
        return getSubMap(0, this.keySet.headIndex(com.google.common.base.Preconditions.checkNotNull(k), z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ java.util.NavigableMap headMap(java.lang.Object obj, boolean z) {
        return headMap((com.google.common.collect.ImmutableSortedMap<K, V>) obj, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap, java.util.SortedMap
    public /* bridge */ /* synthetic */ java.util.SortedMap headMap(java.lang.Object obj) {
        return headMap((com.google.common.collect.ImmutableSortedMap<K, V>) obj);
    }

    @Override // java.util.NavigableMap
    public java.util.Map.Entry<K, V> higherEntry(K k) {
        return tailMap((com.google.common.collect.ImmutableSortedMap<K, V>) k, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K higherKey(K k) {
        return (K) com.google.common.collect.Maps.x(higherEntry(k));
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return this.keySet.isPartialView() || this.valueList.isPartialView();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public com.google.common.collect.ImmutableSortedSet<K> keySet() {
        return this.keySet;
    }

    @Override // java.util.NavigableMap
    public java.util.Map.Entry<K, V> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return entrySet().asList().get(size() - 1);
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        return keySet().last();
    }

    @Override // java.util.NavigableMap
    public java.util.Map.Entry<K, V> lowerEntry(K k) {
        return headMap((com.google.common.collect.ImmutableSortedMap<K, V>) k, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K k) {
        return (K) com.google.common.collect.Maps.x(lowerEntry(k));
    }

    @Override // java.util.NavigableMap
    public com.google.common.collect.ImmutableSortedSet<K> navigableKeySet() {
        return this.keySet;
    }

    @Override // java.util.NavigableMap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @java.lang.Deprecated
    public final java.util.Map.Entry<K, V> pollFirstEntry() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.util.NavigableMap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @java.lang.Deprecated
    public final java.util.Map.Entry<K, V> pollLastEntry() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.util.Map
    public int size() {
        return this.valueList.size();
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public com.google.common.collect.ImmutableSortedMap<K, V> subMap(K k, K k2) {
        return subMap((boolean) k, true, (boolean) k2, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public com.google.common.collect.ImmutableSortedMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
        com.google.common.base.Preconditions.checkNotNull(k);
        com.google.common.base.Preconditions.checkNotNull(k2);
        com.google.common.base.Preconditions.checkArgument(comparator().compare(k, k2) <= 0, "expected fromKey <= toKey but %s > %s", k, k2);
        return headMap((com.google.common.collect.ImmutableSortedMap<K, V>) k2, z2).tailMap((com.google.common.collect.ImmutableSortedMap<K, V>) k, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ java.util.NavigableMap subMap(java.lang.Object obj, boolean z, java.lang.Object obj2, boolean z2) {
        return subMap((boolean) obj, z, (boolean) obj2, z2);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public com.google.common.collect.ImmutableSortedMap<K, V> tailMap(K k) {
        return tailMap((com.google.common.collect.ImmutableSortedMap<K, V>) k, true);
    }

    @Override // java.util.NavigableMap
    public com.google.common.collect.ImmutableSortedMap<K, V> tailMap(K k, boolean z) {
        return getSubMap(this.keySet.tailIndex(com.google.common.base.Preconditions.checkNotNull(k), z), size());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ java.util.NavigableMap tailMap(java.lang.Object obj, boolean z) {
        return tailMap((com.google.common.collect.ImmutableSortedMap<K, V>) obj, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap, java.util.SortedMap
    public /* bridge */ /* synthetic */ java.util.SortedMap tailMap(java.lang.Object obj) {
        return tailMap((com.google.common.collect.ImmutableSortedMap<K, V>) obj);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public com.google.common.collect.ImmutableCollection<V> values() {
        return this.valueList;
    }

    @Override // com.google.common.collect.ImmutableMap
    public java.lang.Object writeReplace() {
        return new com.google.common.collect.ImmutableSortedMap.SerializedForm(this);
    }
}
