package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes22.dex */
final class ImmutableEnumMap<K extends java.lang.Enum<K>, V> extends com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap<K, V> {
    private final transient java.util.EnumMap<K, V> delegate;

    public static class EnumSerializedForm<K extends java.lang.Enum<K>, V> implements java.io.Serializable {
        private static final long serialVersionUID = 0;
        final java.util.EnumMap<K, V> delegate;

        public EnumSerializedForm(java.util.EnumMap<K, V> enumMap) {
            this.delegate = enumMap;
        }

        public java.lang.Object readResolve() {
            return new com.google.common.collect.ImmutableEnumMap(this.delegate, null);
        }
    }

    private ImmutableEnumMap(java.util.EnumMap<K, V> enumMap) {
        this.delegate = enumMap;
        com.google.common.base.Preconditions.checkArgument(!enumMap.isEmpty());
    }

    public /* synthetic */ ImmutableEnumMap(java.util.EnumMap enumMap, com.google.common.collect.ImmutableEnumMap.AnonymousClass1 anonymousClass1) {
        this(enumMap);
    }

    public static <K extends java.lang.Enum<K>, V> com.google.common.collect.ImmutableMap<K, V> asImmutable(java.util.EnumMap<K, V> enumMap) {
        int size = enumMap.size();
        if (size == 0) {
            return com.google.common.collect.ImmutableMap.of();
        }
        if (size != 1) {
            return new com.google.common.collect.ImmutableEnumMap(enumMap);
        }
        java.util.Map.Entry entry = (java.util.Map.Entry) com.google.common.collect.Iterables.getOnlyElement(enumMap.entrySet());
        return com.google.common.collect.ImmutableMap.of(entry.getKey(), entry.getValue());
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean containsKey(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return this.delegate.containsKey(obj);
    }

    @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
    public com.google.common.collect.UnmodifiableIterator<java.util.Map.Entry<K, V>> entryIterator() {
        return com.google.common.collect.Maps.L(this.delegate.entrySet().iterator());
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof com.google.common.collect.ImmutableEnumMap) {
            obj = ((com.google.common.collect.ImmutableEnumMap) obj).delegate;
        }
        return this.delegate.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(java.lang.Object obj) {
        return this.delegate.get(obj);
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableMap
    public com.google.common.collect.UnmodifiableIterator<K> keyIterator() {
        return com.google.common.collect.Iterators.unmodifiableIterator(this.delegate.keySet().iterator());
    }

    @Override // java.util.Map
    public int size() {
        return this.delegate.size();
    }

    @Override // com.google.common.collect.ImmutableMap
    public java.lang.Object writeReplace() {
        return new com.google.common.collect.ImmutableEnumMap.EnumSerializedForm(this.delegate);
    }
}
