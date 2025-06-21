package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public abstract class ImmutableMultimap<K, V> extends com.google.common.collect.BaseImmutableMultimap<K, V> implements java.io.Serializable {
    private static final long serialVersionUID = 0;
    final transient com.google.common.collect.ImmutableMap<K, ? extends com.google.common.collect.ImmutableCollection<V>> map;
    final transient int size;

    /* renamed from: com.google.common.collect.ImmutableMultimap$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.common.collect.UnmodifiableIterator<java.util.Map.Entry<K, V>> {
        public final java.util.Iterator<? extends java.util.Map.Entry<K, ? extends com.google.common.collect.ImmutableCollection<V>>> n;
        public K t = null;
        public java.util.Iterator<V> u = com.google.common.collect.Iterators.f();

        public AnonymousClass1() {
            this.n = com.google.common.collect.ImmutableMultimap.this.map.entrySet().iterator();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.util.Map.Entry<K, V> next() {
            if (!this.u.hasNext()) {
                java.util.Map.Entry<K, ? extends com.google.common.collect.ImmutableCollection<V>> next = this.n.next();
                this.t = next.getKey();
                this.u = next.getValue().iterator();
            }
            return com.google.common.collect.Maps.immutableEntry(this.t, this.u.next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.u.hasNext() || this.n.hasNext();
        }
    }

    /* renamed from: com.google.common.collect.ImmutableMultimap$2, reason: invalid class name */
    public class AnonymousClass2 extends com.google.common.collect.UnmodifiableIterator<V> {
        public java.util.Iterator<? extends com.google.common.collect.ImmutableCollection<V>> n;
        public java.util.Iterator<V> t = com.google.common.collect.Iterators.f();

        public AnonymousClass2() {
            this.n = com.google.common.collect.ImmutableMultimap.this.map.values().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.t.hasNext() || this.n.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            if (!this.t.hasNext()) {
                this.t = this.n.next().iterator();
            }
            return this.t.next();
        }
    }

    public static class Builder<K, V> {
        public java.util.Map<K, java.util.Collection<V>> a = com.google.common.collect.Platform.h();

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        public java.util.Comparator<? super K> b;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        public java.util.Comparator<? super V> c;

        public java.util.Collection<V> a() {
            return new java.util.ArrayList();
        }

        public com.google.common.collect.ImmutableMultimap<K, V> build() {
            java.util.Collection entrySet = this.a.entrySet();
            java.util.Comparator<? super K> comparator = this.b;
            if (comparator != null) {
                entrySet = com.google.common.collect.Ordering.from(comparator).onKeys().immutableSortedCopy(entrySet);
            }
            return com.google.common.collect.ImmutableListMultimap.fromMapEntries(entrySet, this.c);
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableMultimap.Builder<K, V> orderKeysBy(java.util.Comparator<? super K> comparator) {
            this.b = (java.util.Comparator) com.google.common.base.Preconditions.checkNotNull(comparator);
            return this;
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableMultimap.Builder<K, V> orderValuesBy(java.util.Comparator<? super V> comparator) {
            this.c = (java.util.Comparator) com.google.common.base.Preconditions.checkNotNull(comparator);
            return this;
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableMultimap.Builder<K, V> put(K k, V v) {
            com.google.common.collect.CollectPreconditions.a(k, v);
            java.util.Collection<V> collection = this.a.get(k);
            if (collection == null) {
                java.util.Map<K, java.util.Collection<V>> map = this.a;
                java.util.Collection<V> a = a();
                map.put(k, a);
                collection = a;
            }
            collection.add(v);
            return this;
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableMultimap.Builder<K, V> put(java.util.Map.Entry<? extends K, ? extends V> entry) {
            return put(entry.getKey(), entry.getValue());
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableMultimap.Builder<K, V> putAll(com.google.common.collect.Multimap<? extends K, ? extends V> multimap) {
            for (java.util.Map.Entry<? extends K, java.util.Collection<? extends V>> entry : multimap.asMap().entrySet()) {
                putAll((com.google.common.collect.ImmutableMultimap.Builder<K, V>) entry.getKey(), entry.getValue());
            }
            return this;
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        @com.google.common.annotations.Beta
        public com.google.common.collect.ImmutableMultimap.Builder<K, V> putAll(java.lang.Iterable<? extends java.util.Map.Entry<? extends K, ? extends V>> iterable) {
            java.util.Iterator<? extends java.util.Map.Entry<? extends K, ? extends V>> it = iterable.iterator();
            while (it.hasNext()) {
                put(it.next());
            }
            return this;
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableMultimap.Builder<K, V> putAll(K k, java.lang.Iterable<? extends V> iterable) {
            if (k == null) {
                throw new java.lang.NullPointerException("null key in entry: null=" + com.google.common.collect.Iterables.toString(iterable));
            }
            java.util.Collection<V> collection = this.a.get(k);
            if (collection != null) {
                for (V v : iterable) {
                    com.google.common.collect.CollectPreconditions.a(k, v);
                    collection.add(v);
                }
                return this;
            }
            java.util.Iterator<? extends V> it = iterable.iterator();
            if (!it.hasNext()) {
                return this;
            }
            java.util.Collection<V> a = a();
            while (it.hasNext()) {
                V next = it.next();
                com.google.common.collect.CollectPreconditions.a(k, next);
                a.add(next);
            }
            this.a.put(k, a);
            return this;
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableMultimap.Builder<K, V> putAll(K k, V... vArr) {
            return putAll((com.google.common.collect.ImmutableMultimap.Builder<K, V>) k, java.util.Arrays.asList(vArr));
        }
    }

    public static class EntryCollection<K, V> extends com.google.common.collect.ImmutableCollection<java.util.Map.Entry<K, V>> {
        private static final long serialVersionUID = 0;

        @com.google.j2objc.annotations.Weak
        final com.google.common.collect.ImmutableMultimap<K, V> multimap;

        public EntryCollection(com.google.common.collect.ImmutableMultimap<K, V> immutableMultimap) {
            this.multimap = immutableMultimap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(java.lang.Object obj) {
            if (!(obj instanceof java.util.Map.Entry)) {
                return false;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            return this.multimap.containsEntry(entry.getKey(), entry.getValue());
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return this.multimap.isPartialView();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public com.google.common.collect.UnmodifiableIterator<java.util.Map.Entry<K, V>> iterator() {
            return this.multimap.entryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.multimap.size();
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static class FieldSettersHolder {
        public static final com.google.common.collect.Serialization.FieldSetter<com.google.common.collect.ImmutableMultimap> a = com.google.common.collect.Serialization.a(com.google.common.collect.ImmutableMultimap.class, "map");
        public static final com.google.common.collect.Serialization.FieldSetter<com.google.common.collect.ImmutableMultimap> b = com.google.common.collect.Serialization.a(com.google.common.collect.ImmutableMultimap.class, com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE);
    }

    public class Keys extends com.google.common.collect.ImmutableMultiset<K> {
        public Keys() {
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return com.google.common.collect.ImmutableMultimap.this.containsKey(obj);
        }

        @Override // com.google.common.collect.Multiset
        public int count(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            com.google.common.collect.ImmutableCollection<V> immutableCollection = com.google.common.collect.ImmutableMultimap.this.map.get(obj);
            if (immutableCollection == null) {
                return 0;
            }
            return immutableCollection.size();
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
        public com.google.common.collect.ImmutableSet<K> elementSet() {
            return com.google.common.collect.ImmutableMultimap.this.keySet();
        }

        @Override // com.google.common.collect.ImmutableMultiset
        public com.google.common.collect.Multiset.Entry<K> getEntry(int i) {
            java.util.Map.Entry<K, ? extends com.google.common.collect.ImmutableCollection<V>> entry = com.google.common.collect.ImmutableMultimap.this.map.entrySet().asList().get(i);
            return com.google.common.collect.Multisets.immutableEntry(entry.getKey(), entry.getValue().size());
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public int size() {
            return com.google.common.collect.ImmutableMultimap.this.size();
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
        @com.google.common.annotations.GwtIncompatible
        public java.lang.Object writeReplace() {
            return new com.google.common.collect.ImmutableMultimap.KeysSerializedForm(com.google.common.collect.ImmutableMultimap.this);
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static final class KeysSerializedForm implements java.io.Serializable {
        final com.google.common.collect.ImmutableMultimap<?, ?> multimap;

        public KeysSerializedForm(com.google.common.collect.ImmutableMultimap<?, ?> immutableMultimap) {
            this.multimap = immutableMultimap;
        }

        public java.lang.Object readResolve() {
            return this.multimap.keys();
        }
    }

    public static final class Values<K, V> extends com.google.common.collect.ImmutableCollection<V> {
        private static final long serialVersionUID = 0;

        @com.google.j2objc.annotations.Weak
        private final transient com.google.common.collect.ImmutableMultimap<K, V> multimap;

        public Values(com.google.common.collect.ImmutableMultimap<K, V> immutableMultimap) {
            this.multimap = immutableMultimap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return this.multimap.containsValue(obj);
        }

        @Override // com.google.common.collect.ImmutableCollection
        @com.google.common.annotations.GwtIncompatible
        public int copyIntoArray(java.lang.Object[] objArr, int i) {
            com.google.common.collect.UnmodifiableIterator<? extends com.google.common.collect.ImmutableCollection<V>> it = this.multimap.map.values().iterator();
            while (it.hasNext()) {
                i = it.next().copyIntoArray(objArr, i);
            }
            return i;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public com.google.common.collect.UnmodifiableIterator<V> iterator() {
            return this.multimap.valueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.multimap.size();
        }
    }

    public ImmutableMultimap(com.google.common.collect.ImmutableMap<K, ? extends com.google.common.collect.ImmutableCollection<V>> immutableMap, int i) {
        this.map = immutableMap;
        this.size = i;
    }

    public static <K, V> com.google.common.collect.ImmutableMultimap.Builder<K, V> builder() {
        return new com.google.common.collect.ImmutableMultimap.Builder<>();
    }

    public static <K, V> com.google.common.collect.ImmutableMultimap<K, V> copyOf(com.google.common.collect.Multimap<? extends K, ? extends V> multimap) {
        if (multimap instanceof com.google.common.collect.ImmutableMultimap) {
            com.google.common.collect.ImmutableMultimap<K, V> immutableMultimap = (com.google.common.collect.ImmutableMultimap) multimap;
            if (!immutableMultimap.isPartialView()) {
                return immutableMultimap;
            }
        }
        return com.google.common.collect.ImmutableListMultimap.copyOf((com.google.common.collect.Multimap) multimap);
    }

    @com.google.common.annotations.Beta
    public static <K, V> com.google.common.collect.ImmutableMultimap<K, V> copyOf(java.lang.Iterable<? extends java.util.Map.Entry<? extends K, ? extends V>> iterable) {
        return com.google.common.collect.ImmutableListMultimap.copyOf((java.lang.Iterable) iterable);
    }

    public static <K, V> com.google.common.collect.ImmutableMultimap<K, V> of() {
        return com.google.common.collect.ImmutableListMultimap.of();
    }

    public static <K, V> com.google.common.collect.ImmutableMultimap<K, V> of(K k, V v) {
        return com.google.common.collect.ImmutableListMultimap.of((java.lang.Object) k, (java.lang.Object) v);
    }

    public static <K, V> com.google.common.collect.ImmutableMultimap<K, V> of(K k, V v, K k2, V v2) {
        return com.google.common.collect.ImmutableListMultimap.of((java.lang.Object) k, (java.lang.Object) v, (java.lang.Object) k2, (java.lang.Object) v2);
    }

    public static <K, V> com.google.common.collect.ImmutableMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        return com.google.common.collect.ImmutableListMultimap.of((java.lang.Object) k, (java.lang.Object) v, (java.lang.Object) k2, (java.lang.Object) v2, (java.lang.Object) k3, (java.lang.Object) v3);
    }

    public static <K, V> com.google.common.collect.ImmutableMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        return com.google.common.collect.ImmutableListMultimap.of((java.lang.Object) k, (java.lang.Object) v, (java.lang.Object) k2, (java.lang.Object) v2, (java.lang.Object) k3, (java.lang.Object) v3, (java.lang.Object) k4, (java.lang.Object) v4);
    }

    public static <K, V> com.google.common.collect.ImmutableMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return com.google.common.collect.ImmutableListMultimap.of((java.lang.Object) k, (java.lang.Object) v, (java.lang.Object) k2, (java.lang.Object) v2, (java.lang.Object) k3, (java.lang.Object) v3, (java.lang.Object) k4, (java.lang.Object) v4, (java.lang.Object) k5, (java.lang.Object) v5);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public com.google.common.collect.ImmutableMap<K, java.util.Collection<V>> asMap() {
        return this.map;
    }

    @Override // com.google.common.collect.Multimap
    @java.lang.Deprecated
    public void clear() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsEntry(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public boolean containsValue(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return obj != null && super.containsValue(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public java.util.Map<K, java.util.Collection<V>> createAsMap() {
        throw new java.lang.AssertionError("should never be called");
    }

    @Override // com.google.common.collect.AbstractMultimap
    public com.google.common.collect.ImmutableCollection<java.util.Map.Entry<K, V>> createEntries() {
        return new com.google.common.collect.ImmutableMultimap.EntryCollection(this);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public java.util.Set<K> createKeySet() {
        throw new java.lang.AssertionError("unreachable");
    }

    @Override // com.google.common.collect.AbstractMultimap
    public com.google.common.collect.ImmutableMultiset<K> createKeys() {
        return new com.google.common.collect.ImmutableMultimap.Keys();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public com.google.common.collect.ImmutableCollection<V> createValues() {
        return new com.google.common.collect.ImmutableMultimap.Values(this);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public com.google.common.collect.ImmutableCollection<java.util.Map.Entry<K, V>> entries() {
        return (com.google.common.collect.ImmutableCollection) super.entries();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public com.google.common.collect.UnmodifiableIterator<java.util.Map.Entry<K, V>> entryIterator() {
        return new com.google.common.collect.ImmutableMultimap.AnonymousClass1();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.Multimap
    public abstract com.google.common.collect.ImmutableCollection<V> get(K k);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ java.util.Collection get(java.lang.Object obj) {
        return get((com.google.common.collect.ImmutableMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public abstract com.google.common.collect.ImmutableMultimap<V, K> inverse();

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public boolean isPartialView() {
        return this.map.isPartialView();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public com.google.common.collect.ImmutableSet<K> keySet() {
        return this.map.keySet();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public com.google.common.collect.ImmutableMultiset<K> keys() {
        return (com.google.common.collect.ImmutableMultiset) super.keys();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @java.lang.Deprecated
    public boolean put(K k, V v) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @java.lang.Deprecated
    public boolean putAll(com.google.common.collect.Multimap<? extends K, ? extends V> multimap) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @java.lang.Deprecated
    public boolean putAll(K k, java.lang.Iterable<? extends V> iterable) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @java.lang.Deprecated
    public boolean remove(java.lang.Object obj, java.lang.Object obj2) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multimap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @java.lang.Deprecated
    public com.google.common.collect.ImmutableCollection<V> removeAll(java.lang.Object obj) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @java.lang.Deprecated
    public com.google.common.collect.ImmutableCollection<V> replaceValues(K k, java.lang.Iterable<? extends V> iterable) {
        throw new java.lang.UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @java.lang.Deprecated
    public /* bridge */ /* synthetic */ java.util.Collection replaceValues(java.lang.Object obj, java.lang.Iterable iterable) {
        return replaceValues((com.google.common.collect.ImmutableMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.AbstractMultimap
    public /* bridge */ /* synthetic */ java.lang.String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public com.google.common.collect.UnmodifiableIterator<V> valueIterator() {
        return new com.google.common.collect.ImmutableMultimap.AnonymousClass2();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public com.google.common.collect.ImmutableCollection<V> values() {
        return (com.google.common.collect.ImmutableCollection) super.values();
    }
}
