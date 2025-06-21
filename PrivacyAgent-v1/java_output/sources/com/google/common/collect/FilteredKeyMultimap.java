package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
class FilteredKeyMultimap<K, V> extends com.google.common.collect.AbstractMultimap<K, V> implements com.google.common.collect.FilteredMultimap<K, V> {
    public final com.google.common.collect.Multimap<K, V> n;
    public final com.google.common.base.Predicate<? super K> t;

    public static class AddRejectingList<K, V> extends com.google.common.collect.ForwardingList<V> {
        public final K n;

        public AddRejectingList(K k) {
            this.n = k;
        }

        @Override // com.google.common.collect.ForwardingList, java.util.List
        public void add(int i, V v) {
            com.google.common.base.Preconditions.checkPositionIndex(i, 0);
            throw new java.lang.IllegalArgumentException("Key does not satisfy predicate: " + this.n);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
        public boolean add(V v) {
            add(0, v);
            return true;
        }

        @Override // com.google.common.collect.ForwardingList, java.util.List
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public boolean addAll(int i, java.util.Collection<? extends V> collection) {
            com.google.common.base.Preconditions.checkNotNull(collection);
            com.google.common.base.Preconditions.checkPositionIndex(i, 0);
            throw new java.lang.IllegalArgumentException("Key does not satisfy predicate: " + this.n);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean addAll(java.util.Collection<? extends V> collection) {
            addAll(0, collection);
            return true;
        }

        @Override // com.google.common.collect.ForwardingList, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public java.util.List<V> delegate() {
            return java.util.Collections.emptyList();
        }
    }

    public static class AddRejectingSet<K, V> extends com.google.common.collect.ForwardingSet<V> {
        public final K n;

        public AddRejectingSet(K k) {
            this.n = k;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
        public boolean add(V v) {
            throw new java.lang.IllegalArgumentException("Key does not satisfy predicate: " + this.n);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean addAll(java.util.Collection<? extends V> collection) {
            com.google.common.base.Preconditions.checkNotNull(collection);
            throw new java.lang.IllegalArgumentException("Key does not satisfy predicate: " + this.n);
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public java.util.Set<V> delegate() {
            return java.util.Collections.emptySet();
        }
    }

    public class Entries extends com.google.common.collect.ForwardingCollection<java.util.Map.Entry<K, V>> {
        public Entries() {
        }

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public java.util.Collection<java.util.Map.Entry<K, V>> delegate() {
            return com.google.common.collect.Collections2.filter(com.google.common.collect.FilteredKeyMultimap.this.n.entries(), com.google.common.collect.FilteredKeyMultimap.this.j());
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (!(obj instanceof java.util.Map.Entry)) {
                return false;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            if (com.google.common.collect.FilteredKeyMultimap.this.n.containsKey(entry.getKey()) && com.google.common.collect.FilteredKeyMultimap.this.t.apply((java.lang.Object) entry.getKey())) {
                return com.google.common.collect.FilteredKeyMultimap.this.n.remove(entry.getKey(), entry.getValue());
            }
            return false;
        }
    }

    public FilteredKeyMultimap(com.google.common.collect.Multimap<K, V> multimap, com.google.common.base.Predicate<? super K> predicate) {
        this.n = (com.google.common.collect.Multimap) com.google.common.base.Preconditions.checkNotNull(multimap);
        this.t = (com.google.common.base.Predicate) com.google.common.base.Preconditions.checkNotNull(predicate);
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        keySet().clear();
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (this.n.containsKey(obj)) {
            return this.t.apply(obj);
        }
        return false;
    }

    @Override // com.google.common.collect.AbstractMultimap
    public java.util.Map<K, java.util.Collection<V>> createAsMap() {
        return com.google.common.collect.Maps.filterKeys(this.n.asMap(), this.t);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public java.util.Collection<java.util.Map.Entry<K, V>> createEntries() {
        return new com.google.common.collect.FilteredKeyMultimap.Entries();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public java.util.Set<K> createKeySet() {
        return com.google.common.collect.Sets.filter(this.n.keySet(), this.t);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public com.google.common.collect.Multiset<K> createKeys() {
        return com.google.common.collect.Multisets.filter(this.n.keys(), this.t);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public java.util.Collection<V> createValues() {
        return new com.google.common.collect.FilteredMultimapValues(this);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public java.util.Iterator<java.util.Map.Entry<K, V>> entryIterator() {
        throw new java.lang.AssertionError("should never be called");
    }

    @Override // com.google.common.collect.Multimap
    public java.util.Collection<V> get(K k) {
        return this.t.apply(k) ? this.n.get(k) : this.n instanceof com.google.common.collect.SetMultimap ? new com.google.common.collect.FilteredKeyMultimap.AddRejectingSet(k) : new com.google.common.collect.FilteredKeyMultimap.AddRejectingList(k);
    }

    public com.google.common.collect.Multimap<K, V> i() {
        return this.n;
    }

    @Override // com.google.common.collect.FilteredMultimap
    public com.google.common.base.Predicate<? super java.util.Map.Entry<K, V>> j() {
        return com.google.common.collect.Maps.y(this.t);
    }

    public java.util.Collection<V> k() {
        return this.n instanceof com.google.common.collect.SetMultimap ? com.google.common.collect.ImmutableSet.of() : com.google.common.collect.ImmutableList.of();
    }

    @Override // com.google.common.collect.Multimap
    public java.util.Collection<V> removeAll(java.lang.Object obj) {
        return containsKey(obj) ? this.n.removeAll(obj) : k();
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        java.util.Iterator<java.util.Collection<V>> it = asMap().values().iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().size();
        }
        return i;
    }
}
