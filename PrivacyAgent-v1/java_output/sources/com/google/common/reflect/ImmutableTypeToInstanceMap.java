package com.google.common.reflect;

@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public final class ImmutableTypeToInstanceMap<B> extends com.google.common.collect.ForwardingMap<com.google.common.reflect.TypeToken<? extends B>, B> implements com.google.common.reflect.TypeToInstanceMap<B> {
    public final com.google.common.collect.ImmutableMap<com.google.common.reflect.TypeToken<? extends B>, B> n;

    @com.google.common.annotations.Beta
    public static final class Builder<B> {
        public final com.google.common.collect.ImmutableMap.Builder<com.google.common.reflect.TypeToken<? extends B>, B> a;

        public Builder() {
            this.a = com.google.common.collect.ImmutableMap.builder();
        }

        public /* synthetic */ Builder(com.google.common.reflect.ImmutableTypeToInstanceMap.AnonymousClass1 anonymousClass1) {
            this();
        }

        public com.google.common.reflect.ImmutableTypeToInstanceMap<B> build() {
            return new com.google.common.reflect.ImmutableTypeToInstanceMap<>(this.a.build(), null);
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public <T extends B> com.google.common.reflect.ImmutableTypeToInstanceMap.Builder<B> put(com.google.common.reflect.TypeToken<T> typeToken, T t) {
            this.a.put(typeToken.rejectTypeVariables(), t);
            return this;
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public <T extends B> com.google.common.reflect.ImmutableTypeToInstanceMap.Builder<B> put(java.lang.Class<T> cls, T t) {
            this.a.put(com.google.common.reflect.TypeToken.of((java.lang.Class) cls), t);
            return this;
        }
    }

    public ImmutableTypeToInstanceMap(com.google.common.collect.ImmutableMap<com.google.common.reflect.TypeToken<? extends B>, B> immutableMap) {
        this.n = immutableMap;
    }

    public /* synthetic */ ImmutableTypeToInstanceMap(com.google.common.collect.ImmutableMap immutableMap, com.google.common.reflect.ImmutableTypeToInstanceMap.AnonymousClass1 anonymousClass1) {
        this(immutableMap);
    }

    public static <B> com.google.common.reflect.ImmutableTypeToInstanceMap.Builder<B> builder() {
        return new com.google.common.reflect.ImmutableTypeToInstanceMap.Builder<>(null);
    }

    public static <B> com.google.common.reflect.ImmutableTypeToInstanceMap<B> of() {
        return new com.google.common.reflect.ImmutableTypeToInstanceMap<>(com.google.common.collect.ImmutableMap.of());
    }

    public final <T extends B> T a(com.google.common.reflect.TypeToken<T> typeToken) {
        return this.n.get(typeToken);
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public java.util.Map<com.google.common.reflect.TypeToken<? extends B>, B> delegate() {
        return this.n;
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    public <T extends B> T getInstance(com.google.common.reflect.TypeToken<T> typeToken) {
        return (T) a(typeToken.rejectTypeVariables());
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    public <T extends B> T getInstance(java.lang.Class<T> cls) {
        return (T) a(com.google.common.reflect.TypeToken.of((java.lang.Class) cls));
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @java.lang.Deprecated
    public B put(com.google.common.reflect.TypeToken<? extends B> typeToken, B b) {
        throw new java.lang.UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @java.lang.Deprecated
    public /* bridge */ /* synthetic */ java.lang.Object put(java.lang.Object obj, java.lang.Object obj2) {
        return put((com.google.common.reflect.TypeToken<? extends com.google.common.reflect.TypeToken<? extends B>>) obj, (com.google.common.reflect.TypeToken<? extends B>) obj2);
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    @java.lang.Deprecated
    public void putAll(java.util.Map<? extends com.google.common.reflect.TypeToken<? extends B>, ? extends B> map) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @java.lang.Deprecated
    public <T extends B> T putInstance(com.google.common.reflect.TypeToken<T> typeToken, T t) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @java.lang.Deprecated
    public <T extends B> T putInstance(java.lang.Class<T> cls, T t) {
        throw new java.lang.UnsupportedOperationException();
    }
}
