package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(serializable = true)
/* loaded from: classes22.dex */
class ImmutableEntry<K, V> extends com.google.common.collect.AbstractMapEntry<K, V> implements java.io.Serializable {
    private static final long serialVersionUID = 0;

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    final K key;

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    final V value;

    public ImmutableEntry(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
        this.key = k;
        this.value = v;
    }

    @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public final K getKey() {
        return this.key;
    }

    @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public final V getValue() {
        return this.value;
    }

    @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
    public final V setValue(V v) {
        throw new java.lang.UnsupportedOperationException();
    }
}
