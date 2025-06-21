package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes22.dex */
public class ImmutableSetMultimap<K, V> extends com.google.common.collect.ImmutableMultimap<K, V> implements com.google.common.collect.SetMultimap<K, V> {

    @com.google.common.annotations.GwtIncompatible
    private static final long serialVersionUID = 0;
    private final transient com.google.common.collect.ImmutableSet<V> emptySet;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    private transient com.google.common.collect.ImmutableSet<java.util.Map.Entry<K, V>> entries;

    @com.google.j2objc.annotations.RetainedWith
    @com.google.errorprone.annotations.concurrent.LazyInit
    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    private transient com.google.common.collect.ImmutableSetMultimap<V, K> inverse;

    public static final class Builder<K, V> extends com.google.common.collect.ImmutableMultimap.Builder<K, V> {
        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public java.util.Collection<V> a() {
            return com.google.common.collect.Platform.g();
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public com.google.common.collect.ImmutableSetMultimap<K, V> build() {
            java.util.Collection entrySet = this.a.entrySet();
            java.util.Comparator<? super K> comparator = this.b;
            if (comparator != null) {
                entrySet = com.google.common.collect.Ordering.from(comparator).onKeys().immutableSortedCopy(entrySet);
            }
            return com.google.common.collect.ImmutableSetMultimap.fromMapEntries(entrySet, this.c);
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableSetMultimap.Builder<K, V> orderKeysBy(java.util.Comparator<? super K> comparator) {
            super.orderKeysBy((java.util.Comparator) comparator);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableSetMultimap.Builder<K, V> orderValuesBy(java.util.Comparator<? super V> comparator) {
            super.orderValuesBy((java.util.Comparator) comparator);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ com.google.common.collect.ImmutableMultimap.Builder put(java.lang.Object obj, java.lang.Object obj2) {
            return put((com.google.common.collect.ImmutableSetMultimap.Builder<K, V>) obj, obj2);
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableSetMultimap.Builder<K, V> put(K k, V v) {
            super.put((com.google.common.collect.ImmutableSetMultimap.Builder<K, V>) k, (K) v);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableSetMultimap.Builder<K, V> put(java.util.Map.Entry<? extends K, ? extends V> entry) {
            super.put((java.util.Map.Entry) entry);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ com.google.common.collect.ImmutableMultimap.Builder putAll(java.lang.Object obj, java.lang.Iterable iterable) {
            return putAll((com.google.common.collect.ImmutableSetMultimap.Builder<K, V>) obj, iterable);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ com.google.common.collect.ImmutableMultimap.Builder putAll(java.lang.Object obj, java.lang.Object[] objArr) {
            return putAll((com.google.common.collect.ImmutableSetMultimap.Builder<K, V>) obj, objArr);
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableSetMultimap.Builder<K, V> putAll(com.google.common.collect.Multimap<? extends K, ? extends V> multimap) {
            for (java.util.Map.Entry<? extends K, java.util.Collection<? extends V>> entry : multimap.asMap().entrySet()) {
                putAll((com.google.common.collect.ImmutableSetMultimap.Builder<K, V>) entry.getKey(), (java.lang.Iterable) entry.getValue());
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        @com.google.common.annotations.Beta
        public com.google.common.collect.ImmutableSetMultimap.Builder<K, V> putAll(java.lang.Iterable<? extends java.util.Map.Entry<? extends K, ? extends V>> iterable) {
            super.putAll((java.lang.Iterable) iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableSetMultimap.Builder<K, V> putAll(K k, java.lang.Iterable<? extends V> iterable) {
            super.putAll((com.google.common.collect.ImmutableSetMultimap.Builder<K, V>) k, (java.lang.Iterable) iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableSetMultimap.Builder<K, V> putAll(K k, V... vArr) {
            return putAll((com.google.common.collect.ImmutableSetMultimap.Builder<K, V>) k, (java.lang.Iterable) java.util.Arrays.asList(vArr));
        }
    }

    public static final class EntrySet<K, V> extends com.google.common.collect.ImmutableSet<java.util.Map.Entry<K, V>> {

        @com.google.j2objc.annotations.Weak
        private final transient com.google.common.collect.ImmutableSetMultimap<K, V> multimap;

        public EntrySet(com.google.common.collect.ImmutableSetMultimap<K, V> immutableSetMultimap) {
            this.multimap = immutableSetMultimap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (!(obj instanceof java.util.Map.Entry)) {
                return false;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            return this.multimap.containsEntry(entry.getKey(), entry.getValue());
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public com.google.common.collect.UnmodifiableIterator<java.util.Map.Entry<K, V>> iterator() {
            return this.multimap.entryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.multimap.size();
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static final class SetFieldSettersHolder {
        public static final com.google.common.collect.Serialization.FieldSetter<com.google.common.collect.ImmutableSetMultimap> a = com.google.common.collect.Serialization.a(com.google.common.collect.ImmutableSetMultimap.class, "emptySet");
    }

    public ImmutableSetMultimap(com.google.common.collect.ImmutableMap<K, com.google.common.collect.ImmutableSet<V>> immutableMap, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.util.Comparator<? super V> comparator) {
        super(immutableMap, i);
        this.emptySet = emptySet(comparator);
    }

    public static <K, V> com.google.common.collect.ImmutableSetMultimap.Builder<K, V> builder() {
        return new com.google.common.collect.ImmutableSetMultimap.Builder<>();
    }

    public static <K, V> com.google.common.collect.ImmutableSetMultimap<K, V> copyOf(com.google.common.collect.Multimap<? extends K, ? extends V> multimap) {
        return copyOf(multimap, null);
    }

    private static <K, V> com.google.common.collect.ImmutableSetMultimap<K, V> copyOf(com.google.common.collect.Multimap<? extends K, ? extends V> multimap, java.util.Comparator<? super V> comparator) {
        com.google.common.base.Preconditions.checkNotNull(multimap);
        if (multimap.isEmpty() && comparator == null) {
            return of();
        }
        if (multimap instanceof com.google.common.collect.ImmutableSetMultimap) {
            com.google.common.collect.ImmutableSetMultimap<K, V> immutableSetMultimap = (com.google.common.collect.ImmutableSetMultimap) multimap;
            if (!immutableSetMultimap.isPartialView()) {
                return immutableSetMultimap;
            }
        }
        return fromMapEntries(multimap.asMap().entrySet(), comparator);
    }

    @com.google.common.annotations.Beta
    public static <K, V> com.google.common.collect.ImmutableSetMultimap<K, V> copyOf(java.lang.Iterable<? extends java.util.Map.Entry<? extends K, ? extends V>> iterable) {
        return new com.google.common.collect.ImmutableSetMultimap.Builder().putAll((java.lang.Iterable) iterable).build();
    }

    private static <V> com.google.common.collect.ImmutableSet<V> emptySet(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.util.Comparator<? super V> comparator) {
        return comparator == null ? com.google.common.collect.ImmutableSet.of() : com.google.common.collect.ImmutableSortedSet.emptySet(comparator);
    }

    public static <K, V> com.google.common.collect.ImmutableSetMultimap<K, V> fromMapEntries(java.util.Collection<? extends java.util.Map.Entry<? extends K, ? extends java.util.Collection<? extends V>>> collection, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.util.Comparator<? super V> comparator) {
        if (collection.isEmpty()) {
            return of();
        }
        com.google.common.collect.ImmutableMap.Builder builder = new com.google.common.collect.ImmutableMap.Builder(collection.size());
        int i = 0;
        for (java.util.Map.Entry<? extends K, ? extends java.util.Collection<? extends V>> entry : collection) {
            K key = entry.getKey();
            com.google.common.collect.ImmutableSet valueSet = valueSet(comparator, entry.getValue());
            if (!valueSet.isEmpty()) {
                builder.put(key, valueSet);
                i += valueSet.size();
            }
        }
        return new com.google.common.collect.ImmutableSetMultimap<>(builder.build(), i, comparator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private com.google.common.collect.ImmutableSetMultimap<V, K> invert() {
        com.google.common.collect.ImmutableSetMultimap.Builder builder = builder();
        com.google.common.collect.UnmodifiableIterator it = entries().iterator();
        while (it.hasNext()) {
            java.util.Map.Entry entry = (java.util.Map.Entry) it.next();
            builder.put((com.google.common.collect.ImmutableSetMultimap.Builder) entry.getValue(), entry.getKey());
        }
        com.google.common.collect.ImmutableSetMultimap<V, K> build = builder.build();
        build.inverse = this;
        return build;
    }

    public static <K, V> com.google.common.collect.ImmutableSetMultimap<K, V> of() {
        return com.google.common.collect.EmptyImmutableSetMultimap.INSTANCE;
    }

    public static <K, V> com.google.common.collect.ImmutableSetMultimap<K, V> of(K k, V v) {
        com.google.common.collect.ImmutableSetMultimap.Builder builder = builder();
        builder.put((com.google.common.collect.ImmutableSetMultimap.Builder) k, (K) v);
        return builder.build();
    }

    public static <K, V> com.google.common.collect.ImmutableSetMultimap<K, V> of(K k, V v, K k2, V v2) {
        com.google.common.collect.ImmutableSetMultimap.Builder builder = builder();
        builder.put((com.google.common.collect.ImmutableSetMultimap.Builder) k, (K) v);
        builder.put((com.google.common.collect.ImmutableSetMultimap.Builder) k2, (K) v2);
        return builder.build();
    }

    public static <K, V> com.google.common.collect.ImmutableSetMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        com.google.common.collect.ImmutableSetMultimap.Builder builder = builder();
        builder.put((com.google.common.collect.ImmutableSetMultimap.Builder) k, (K) v);
        builder.put((com.google.common.collect.ImmutableSetMultimap.Builder) k2, (K) v2);
        builder.put((com.google.common.collect.ImmutableSetMultimap.Builder) k3, (K) v3);
        return builder.build();
    }

    public static <K, V> com.google.common.collect.ImmutableSetMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        com.google.common.collect.ImmutableSetMultimap.Builder builder = builder();
        builder.put((com.google.common.collect.ImmutableSetMultimap.Builder) k, (K) v);
        builder.put((com.google.common.collect.ImmutableSetMultimap.Builder) k2, (K) v2);
        builder.put((com.google.common.collect.ImmutableSetMultimap.Builder) k3, (K) v3);
        builder.put((com.google.common.collect.ImmutableSetMultimap.Builder) k4, (K) v4);
        return builder.build();
    }

    public static <K, V> com.google.common.collect.ImmutableSetMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        com.google.common.collect.ImmutableSetMultimap.Builder builder = builder();
        builder.put((com.google.common.collect.ImmutableSetMultimap.Builder) k, (K) v);
        builder.put((com.google.common.collect.ImmutableSetMultimap.Builder) k2, (K) v2);
        builder.put((com.google.common.collect.ImmutableSetMultimap.Builder) k3, (K) v3);
        builder.put((com.google.common.collect.ImmutableSetMultimap.Builder) k4, (K) v4);
        builder.put((com.google.common.collect.ImmutableSetMultimap.Builder) k5, (K) v5);
        return builder.build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.google.common.annotations.GwtIncompatible
    private void readObject(java.io.ObjectInputStream objectInputStream) throws java.io.IOException, java.lang.ClassNotFoundException {
        objectInputStream.defaultReadObject();
        java.util.Comparator comparator = (java.util.Comparator) objectInputStream.readObject();
        int readInt = objectInputStream.readInt();
        if (readInt < 0) {
            throw new java.io.InvalidObjectException("Invalid key count " + readInt);
        }
        com.google.common.collect.ImmutableMap.Builder builder = com.google.common.collect.ImmutableMap.builder();
        int i = 0;
        for (int i2 = 0; i2 < readInt; i2++) {
            java.lang.Object readObject = objectInputStream.readObject();
            int readInt2 = objectInputStream.readInt();
            if (readInt2 <= 0) {
                throw new java.io.InvalidObjectException("Invalid value count " + readInt2);
            }
            com.google.common.collect.ImmutableSet.Builder valuesBuilder = valuesBuilder(comparator);
            for (int i3 = 0; i3 < readInt2; i3++) {
                valuesBuilder.add((com.google.common.collect.ImmutableSet.Builder) objectInputStream.readObject());
            }
            com.google.common.collect.ImmutableSet build = valuesBuilder.build();
            if (build.size() != readInt2) {
                throw new java.io.InvalidObjectException("Duplicate key-value pairs exist for key " + readObject);
            }
            builder.put(readObject, build);
            i += readInt2;
        }
        try {
            com.google.common.collect.ImmutableMultimap.FieldSettersHolder.a.b(this, builder.build());
            com.google.common.collect.ImmutableMultimap.FieldSettersHolder.b.a(this, i);
            com.google.common.collect.ImmutableSetMultimap.SetFieldSettersHolder.a.b(this, emptySet(comparator));
        } catch (java.lang.IllegalArgumentException e) {
            throw ((java.io.InvalidObjectException) new java.io.InvalidObjectException(e.getMessage()).initCause(e));
        }
    }

    private static <V> com.google.common.collect.ImmutableSet<V> valueSet(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.util.Comparator<? super V> comparator, java.util.Collection<? extends V> collection) {
        return comparator == null ? com.google.common.collect.ImmutableSet.copyOf((java.util.Collection) collection) : com.google.common.collect.ImmutableSortedSet.copyOf((java.util.Comparator) comparator, (java.util.Collection) collection);
    }

    private static <V> com.google.common.collect.ImmutableSet.Builder<V> valuesBuilder(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.util.Comparator<? super V> comparator) {
        return comparator == null ? new com.google.common.collect.ImmutableSet.Builder<>() : new com.google.common.collect.ImmutableSortedSet.Builder(comparator);
    }

    @com.google.common.annotations.GwtIncompatible
    private void writeObject(java.io.ObjectOutputStream objectOutputStream) throws java.io.IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(valueComparator());
        com.google.common.collect.Serialization.j(this, objectOutputStream);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public com.google.common.collect.ImmutableSet<java.util.Map.Entry<K, V>> entries() {
        com.google.common.collect.ImmutableSet<java.util.Map.Entry<K, V>> immutableSet = this.entries;
        if (immutableSet != null) {
            return immutableSet;
        }
        com.google.common.collect.ImmutableSetMultimap.EntrySet entrySet = new com.google.common.collect.ImmutableSetMultimap.EntrySet(this);
        this.entries = entrySet;
        return entrySet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ com.google.common.collect.ImmutableCollection get(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return get((com.google.common.collect.ImmutableSetMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    public com.google.common.collect.ImmutableSet<V> get(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k) {
        return (com.google.common.collect.ImmutableSet) com.google.common.base.MoreObjects.firstNonNull((com.google.common.collect.ImmutableSet) this.map.get(k), this.emptySet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ java.util.Collection get(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return get((com.google.common.collect.ImmutableSetMultimap<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ java.util.Set get(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return get((com.google.common.collect.ImmutableSetMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public com.google.common.collect.ImmutableSetMultimap<V, K> inverse() {
        com.google.common.collect.ImmutableSetMultimap<V, K> immutableSetMultimap = this.inverse;
        if (immutableSetMultimap != null) {
            return immutableSetMultimap;
        }
        com.google.common.collect.ImmutableSetMultimap<V, K> invert = invert();
        this.inverse = invert;
        return invert;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @java.lang.Deprecated
    public com.google.common.collect.ImmutableSet<V> removeAll(java.lang.Object obj) {
        throw new java.lang.UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @java.lang.Deprecated
    public /* bridge */ /* synthetic */ com.google.common.collect.ImmutableCollection replaceValues(java.lang.Object obj, java.lang.Iterable iterable) {
        return replaceValues((com.google.common.collect.ImmutableSetMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @java.lang.Deprecated
    public com.google.common.collect.ImmutableSet<V> replaceValues(K k, java.lang.Iterable<? extends V> iterable) {
        throw new java.lang.UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @java.lang.Deprecated
    public /* bridge */ /* synthetic */ java.util.Collection replaceValues(java.lang.Object obj, java.lang.Iterable iterable) {
        return replaceValues((com.google.common.collect.ImmutableSetMultimap<K, V>) obj, iterable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @java.lang.Deprecated
    public /* bridge */ /* synthetic */ java.util.Set replaceValues(java.lang.Object obj, java.lang.Iterable iterable) {
        return replaceValues((com.google.common.collect.ImmutableSetMultimap<K, V>) obj, iterable);
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public java.util.Comparator<? super V> valueComparator() {
        com.google.common.collect.ImmutableSet<V> immutableSet = this.emptySet;
        if (immutableSet instanceof com.google.common.collect.ImmutableSortedSet) {
            return ((com.google.common.collect.ImmutableSortedSet) immutableSet).comparator();
        }
        return null;
    }
}
