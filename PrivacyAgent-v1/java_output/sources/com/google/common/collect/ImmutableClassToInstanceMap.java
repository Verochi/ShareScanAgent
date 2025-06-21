package com.google.common.collect;

@com.google.errorprone.annotations.Immutable(containerOf = {"B"})
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public final class ImmutableClassToInstanceMap<B> extends com.google.common.collect.ForwardingMap<java.lang.Class<? extends B>, B> implements com.google.common.collect.ClassToInstanceMap<B>, java.io.Serializable {
    private static final com.google.common.collect.ImmutableClassToInstanceMap<java.lang.Object> EMPTY = new com.google.common.collect.ImmutableClassToInstanceMap<>(com.google.common.collect.ImmutableMap.of());
    private final com.google.common.collect.ImmutableMap<java.lang.Class<? extends B>, B> delegate;

    public static final class Builder<B> {
        public final com.google.common.collect.ImmutableMap.Builder<java.lang.Class<? extends B>, B> a = com.google.common.collect.ImmutableMap.builder();

        public static <B, T extends B> T a(java.lang.Class<T> cls, B b) {
            return (T) com.google.common.primitives.Primitives.wrap(cls).cast(b);
        }

        public com.google.common.collect.ImmutableClassToInstanceMap<B> build() {
            com.google.common.collect.ImmutableMap<java.lang.Class<? extends B>, B> build = this.a.build();
            return build.isEmpty() ? com.google.common.collect.ImmutableClassToInstanceMap.of() : new com.google.common.collect.ImmutableClassToInstanceMap<>(build, null);
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public <T extends B> com.google.common.collect.ImmutableClassToInstanceMap.Builder<B> put(java.lang.Class<T> cls, T t) {
            this.a.put(cls, t);
            return this;
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public <T extends B> com.google.common.collect.ImmutableClassToInstanceMap.Builder<B> putAll(java.util.Map<? extends java.lang.Class<? extends T>, ? extends T> map) {
            for (java.util.Map.Entry<? extends java.lang.Class<? extends T>, ? extends T> entry : map.entrySet()) {
                java.lang.Class<? extends T> key = entry.getKey();
                this.a.put(key, a(key, entry.getValue()));
            }
            return this;
        }
    }

    private ImmutableClassToInstanceMap(com.google.common.collect.ImmutableMap<java.lang.Class<? extends B>, B> immutableMap) {
        this.delegate = immutableMap;
    }

    public /* synthetic */ ImmutableClassToInstanceMap(com.google.common.collect.ImmutableMap immutableMap, com.google.common.collect.ImmutableClassToInstanceMap.AnonymousClass1 anonymousClass1) {
        this(immutableMap);
    }

    public static <B> com.google.common.collect.ImmutableClassToInstanceMap.Builder<B> builder() {
        return new com.google.common.collect.ImmutableClassToInstanceMap.Builder<>();
    }

    public static <B, S extends B> com.google.common.collect.ImmutableClassToInstanceMap<B> copyOf(java.util.Map<? extends java.lang.Class<? extends S>, ? extends S> map) {
        return map instanceof com.google.common.collect.ImmutableClassToInstanceMap ? (com.google.common.collect.ImmutableClassToInstanceMap) map : new com.google.common.collect.ImmutableClassToInstanceMap.Builder().putAll(map).build();
    }

    public static <B> com.google.common.collect.ImmutableClassToInstanceMap<B> of() {
        return (com.google.common.collect.ImmutableClassToInstanceMap<B>) EMPTY;
    }

    public static <B, T extends B> com.google.common.collect.ImmutableClassToInstanceMap<B> of(java.lang.Class<T> cls, T t) {
        return new com.google.common.collect.ImmutableClassToInstanceMap<>(com.google.common.collect.ImmutableMap.of(cls, t));
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public java.util.Map<java.lang.Class<? extends B>, B> delegate() {
        return this.delegate;
    }

    @Override // com.google.common.collect.ClassToInstanceMap
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public <T extends B> T getInstance(java.lang.Class<T> cls) {
        return this.delegate.get(com.google.common.base.Preconditions.checkNotNull(cls));
    }

    @Override // com.google.common.collect.ClassToInstanceMap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @java.lang.Deprecated
    public <T extends B> T putInstance(java.lang.Class<T> cls, T t) {
        throw new java.lang.UnsupportedOperationException();
    }

    public java.lang.Object readResolve() {
        return isEmpty() ? of() : this;
    }
}
