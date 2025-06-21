package com.google.common.reflect;

@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public final class MutableTypeToInstanceMap<B> extends com.google.common.collect.ForwardingMap<com.google.common.reflect.TypeToken<? extends B>, B> implements com.google.common.reflect.TypeToInstanceMap<B> {
    public final java.util.Map<com.google.common.reflect.TypeToken<? extends B>, B> n = com.google.common.collect.Maps.newHashMap();

    public static final class UnmodifiableEntry<K, V> extends com.google.common.collect.ForwardingMapEntry<K, V> {
        public final java.util.Map.Entry<K, V> n;

        /* renamed from: com.google.common.reflect.MutableTypeToInstanceMap$UnmodifiableEntry$1, reason: invalid class name */
        public static class AnonymousClass1 extends com.google.common.collect.ForwardingSet<java.util.Map.Entry<K, V>> {
            public final /* synthetic */ java.util.Set n;

            public AnonymousClass1(java.util.Set set) {
                this.n = set;
            }

            @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
            public java.util.Set<java.util.Map.Entry<K, V>> delegate() {
                return this.n;
            }

            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public java.util.Iterator<java.util.Map.Entry<K, V>> iterator() {
                return com.google.common.reflect.MutableTypeToInstanceMap.UnmodifiableEntry.b(super.iterator());
            }

            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
            public java.lang.Object[] toArray() {
                return standardToArray();
            }

            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
            public <T> T[] toArray(T[] tArr) {
                return (T[]) standardToArray(tArr);
            }
        }

        /* renamed from: com.google.common.reflect.MutableTypeToInstanceMap$UnmodifiableEntry$2, reason: invalid class name */
        public static class AnonymousClass2 implements com.google.common.base.Function<java.util.Map.Entry<K, V>, java.util.Map.Entry<K, V>> {
            @Override // com.google.common.base.Function
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public java.util.Map.Entry<K, V> apply(java.util.Map.Entry<K, V> entry) {
                return new com.google.common.reflect.MutableTypeToInstanceMap.UnmodifiableEntry(entry, null);
            }
        }

        public UnmodifiableEntry(java.util.Map.Entry<K, V> entry) {
            this.n = (java.util.Map.Entry) com.google.common.base.Preconditions.checkNotNull(entry);
        }

        public /* synthetic */ UnmodifiableEntry(java.util.Map.Entry entry, com.google.common.reflect.MutableTypeToInstanceMap.AnonymousClass1 anonymousClass1) {
            this(entry);
        }

        public static <K, V> java.util.Iterator<java.util.Map.Entry<K, V>> b(java.util.Iterator<java.util.Map.Entry<K, V>> it) {
            return com.google.common.collect.Iterators.transform(it, new com.google.common.reflect.MutableTypeToInstanceMap.UnmodifiableEntry.AnonymousClass2());
        }

        public static <K, V> java.util.Set<java.util.Map.Entry<K, V>> d(java.util.Set<java.util.Map.Entry<K, V>> set) {
            return new com.google.common.reflect.MutableTypeToInstanceMap.UnmodifiableEntry.AnonymousClass1(set);
        }

        @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
        public java.util.Map.Entry<K, V> delegate() {
            return this.n;
        }

        @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
        public V setValue(V v) {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public final <T extends B> T a(com.google.common.reflect.TypeToken<T> typeToken) {
        return this.n.get(typeToken);
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public final <T extends B> T b(com.google.common.reflect.TypeToken<T> typeToken, @org.checkerframework.checker.nullness.compatqual.NullableDecl T t) {
        return this.n.put(typeToken, t);
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public java.util.Map<com.google.common.reflect.TypeToken<? extends B>, B> delegate() {
        return this.n;
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public java.util.Set<java.util.Map.Entry<com.google.common.reflect.TypeToken<? extends B>, B>> entrySet() {
        return com.google.common.reflect.MutableTypeToInstanceMap.UnmodifiableEntry.d(super.entrySet());
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public <T extends B> T getInstance(com.google.common.reflect.TypeToken<T> typeToken) {
        return (T) a(typeToken.rejectTypeVariables());
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public <T extends B> T getInstance(java.lang.Class<T> cls) {
        return (T) a(com.google.common.reflect.TypeToken.of((java.lang.Class) cls));
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @java.lang.Deprecated
    public B put(com.google.common.reflect.TypeToken<? extends B> typeToken, B b) {
        throw new java.lang.UnsupportedOperationException("Please use putInstance() instead.");
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
        throw new java.lang.UnsupportedOperationException("Please use putInstance() instead.");
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public <T extends B> T putInstance(com.google.common.reflect.TypeToken<T> typeToken, @org.checkerframework.checker.nullness.compatqual.NullableDecl T t) {
        return (T) b(typeToken.rejectTypeVariables(), t);
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public <T extends B> T putInstance(java.lang.Class<T> cls, @org.checkerframework.checker.nullness.compatqual.NullableDecl T t) {
        return (T) b(com.google.common.reflect.TypeToken.of((java.lang.Class) cls), t);
    }
}
