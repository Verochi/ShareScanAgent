package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
final class ImmutableMapKeySet<K, V> extends com.google.common.collect.IndexedImmutableSet<K> {
    private final com.google.common.collect.ImmutableMap<K, V> map;

    @com.google.common.annotations.GwtIncompatible
    public static class KeySetSerializedForm<K> implements java.io.Serializable {
        private static final long serialVersionUID = 0;
        final com.google.common.collect.ImmutableMap<K, ?> map;

        public KeySetSerializedForm(com.google.common.collect.ImmutableMap<K, ?> immutableMap) {
            this.map = immutableMap;
        }

        public java.lang.Object readResolve() {
            return this.map.keySet();
        }
    }

    public ImmutableMapKeySet(com.google.common.collect.ImmutableMap<K, V> immutableMap) {
        this.map = immutableMap;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // com.google.common.collect.IndexedImmutableSet
    public K get(int i) {
        return this.map.entrySet().asList().get(i).getKey();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return true;
    }

    @Override // com.google.common.collect.IndexedImmutableSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public com.google.common.collect.UnmodifiableIterator<K> iterator() {
        return this.map.keyIterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.map.size();
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    @com.google.common.annotations.GwtIncompatible
    public java.lang.Object writeReplace() {
        return new com.google.common.collect.ImmutableMapKeySet.KeySetSerializedForm(this.map);
    }
}
