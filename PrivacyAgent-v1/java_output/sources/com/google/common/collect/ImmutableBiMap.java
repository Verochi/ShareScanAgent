package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes22.dex */
public abstract class ImmutableBiMap<K, V> extends com.google.common.collect.ImmutableMap<K, V> implements com.google.common.collect.BiMap<K, V> {

    public static final class Builder<K, V> extends com.google.common.collect.ImmutableMap.Builder<K, V> {
        public Builder() {
        }

        public Builder(int i) {
            super(i);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public com.google.common.collect.ImmutableBiMap<K, V> build() {
            if (this.c == 0) {
                return com.google.common.collect.ImmutableBiMap.of();
            }
            b();
            this.d = true;
            return new com.google.common.collect.RegularImmutableBiMap(this.b, this.c);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        @com.google.common.annotations.Beta
        public com.google.common.collect.ImmutableBiMap.Builder<K, V> orderEntriesByValue(java.util.Comparator<? super V> comparator) {
            super.orderEntriesByValue((java.util.Comparator) comparator);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableBiMap.Builder<K, V> put(K k, V v) {
            super.put((com.google.common.collect.ImmutableBiMap.Builder<K, V>) k, (K) v);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableBiMap.Builder<K, V> put(java.util.Map.Entry<? extends K, ? extends V> entry) {
            super.put((java.util.Map.Entry) entry);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMap.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ com.google.common.collect.ImmutableMap.Builder put(java.lang.Object obj, java.lang.Object obj2) {
            return put((com.google.common.collect.ImmutableBiMap.Builder<K, V>) obj, obj2);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        @com.google.common.annotations.Beta
        public com.google.common.collect.ImmutableBiMap.Builder<K, V> putAll(java.lang.Iterable<? extends java.util.Map.Entry<? extends K, ? extends V>> iterable) {
            super.putAll((java.lang.Iterable) iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableBiMap.Builder<K, V> putAll(java.util.Map<? extends K, ? extends V> map) {
            super.putAll((java.util.Map) map);
            return this;
        }
    }

    public static class SerializedForm extends com.google.common.collect.ImmutableMap.SerializedForm {
        private static final long serialVersionUID = 0;

        public SerializedForm(com.google.common.collect.ImmutableBiMap<?, ?> immutableBiMap) {
            super(immutableBiMap);
        }

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        public java.lang.Object readResolve() {
            return createMap(new com.google.common.collect.ImmutableBiMap.Builder());
        }
    }

    public static <K, V> com.google.common.collect.ImmutableBiMap.Builder<K, V> builder() {
        return new com.google.common.collect.ImmutableBiMap.Builder<>();
    }

    @com.google.common.annotations.Beta
    public static <K, V> com.google.common.collect.ImmutableBiMap.Builder<K, V> builderWithExpectedSize(int i) {
        com.google.common.collect.CollectPreconditions.b(i, "expectedSize");
        return new com.google.common.collect.ImmutableBiMap.Builder<>(i);
    }

    @com.google.common.annotations.Beta
    public static <K, V> com.google.common.collect.ImmutableBiMap<K, V> copyOf(java.lang.Iterable<? extends java.util.Map.Entry<? extends K, ? extends V>> iterable) {
        return new com.google.common.collect.ImmutableBiMap.Builder(iterable instanceof java.util.Collection ? ((java.util.Collection) iterable).size() : 4).putAll((java.lang.Iterable) iterable).build();
    }

    public static <K, V> com.google.common.collect.ImmutableBiMap<K, V> copyOf(java.util.Map<? extends K, ? extends V> map) {
        if (map instanceof com.google.common.collect.ImmutableBiMap) {
            com.google.common.collect.ImmutableBiMap<K, V> immutableBiMap = (com.google.common.collect.ImmutableBiMap) map;
            if (!immutableBiMap.isPartialView()) {
                return immutableBiMap;
            }
        }
        return copyOf((java.lang.Iterable) map.entrySet());
    }

    public static <K, V> com.google.common.collect.ImmutableBiMap<K, V> of() {
        return com.google.common.collect.RegularImmutableBiMap.EMPTY;
    }

    public static <K, V> com.google.common.collect.ImmutableBiMap<K, V> of(K k, V v) {
        com.google.common.collect.CollectPreconditions.a(k, v);
        return new com.google.common.collect.RegularImmutableBiMap(new java.lang.Object[]{k, v}, 1);
    }

    public static <K, V> com.google.common.collect.ImmutableBiMap<K, V> of(K k, V v, K k2, V v2) {
        com.google.common.collect.CollectPreconditions.a(k, v);
        com.google.common.collect.CollectPreconditions.a(k2, v2);
        return new com.google.common.collect.RegularImmutableBiMap(new java.lang.Object[]{k, v, k2, v2}, 2);
    }

    public static <K, V> com.google.common.collect.ImmutableBiMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        com.google.common.collect.CollectPreconditions.a(k, v);
        com.google.common.collect.CollectPreconditions.a(k2, v2);
        com.google.common.collect.CollectPreconditions.a(k3, v3);
        return new com.google.common.collect.RegularImmutableBiMap(new java.lang.Object[]{k, v, k2, v2, k3, v3}, 3);
    }

    public static <K, V> com.google.common.collect.ImmutableBiMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        com.google.common.collect.CollectPreconditions.a(k, v);
        com.google.common.collect.CollectPreconditions.a(k2, v2);
        com.google.common.collect.CollectPreconditions.a(k3, v3);
        com.google.common.collect.CollectPreconditions.a(k4, v4);
        return new com.google.common.collect.RegularImmutableBiMap(new java.lang.Object[]{k, v, k2, v2, k3, v3, k4, v4}, 4);
    }

    public static <K, V> com.google.common.collect.ImmutableBiMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        com.google.common.collect.CollectPreconditions.a(k, v);
        com.google.common.collect.CollectPreconditions.a(k2, v2);
        com.google.common.collect.CollectPreconditions.a(k3, v3);
        com.google.common.collect.CollectPreconditions.a(k4, v4);
        com.google.common.collect.CollectPreconditions.a(k5, v5);
        return new com.google.common.collect.RegularImmutableBiMap(new java.lang.Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5}, 5);
    }

    @Override // com.google.common.collect.ImmutableMap
    public final com.google.common.collect.ImmutableSet<V> createValues() {
        throw new java.lang.AssertionError("should never be called");
    }

    @Override // com.google.common.collect.BiMap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @java.lang.Deprecated
    public V forcePut(K k, V v) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.common.collect.BiMap
    public abstract com.google.common.collect.ImmutableBiMap<V, K> inverse();

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public com.google.common.collect.ImmutableSet<V> values() {
        return inverse().keySet();
    }

    @Override // com.google.common.collect.ImmutableMap
    public java.lang.Object writeReplace() {
        return new com.google.common.collect.ImmutableBiMap.SerializedForm(this);
    }
}
