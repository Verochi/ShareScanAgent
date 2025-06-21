package com.google.common.collect;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public final class MutableClassToInstanceMap<B> extends com.google.common.collect.ForwardingMap<java.lang.Class<? extends B>, B> implements com.google.common.collect.ClassToInstanceMap<B>, java.io.Serializable {
    private final java.util.Map<java.lang.Class<? extends B>, B> delegate;

    /* renamed from: com.google.common.collect.MutableClassToInstanceMap$1, reason: invalid class name */
    public static class AnonymousClass1 extends com.google.common.collect.ForwardingMapEntry<java.lang.Class<? extends B>, B> {
        public final /* synthetic */ java.util.Map.Entry n;

        public AnonymousClass1(java.util.Map.Entry entry) {
            this.n = entry;
        }

        @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
        public java.util.Map.Entry<java.lang.Class<? extends B>, B> delegate() {
            return this.n;
        }

        @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
        public B setValue(B b) {
            return (B) super.setValue(com.google.common.collect.MutableClassToInstanceMap.cast(getKey(), b));
        }
    }

    /* renamed from: com.google.common.collect.MutableClassToInstanceMap$2, reason: invalid class name */
    public class AnonymousClass2 extends com.google.common.collect.ForwardingSet<java.util.Map.Entry<java.lang.Class<? extends B>, B>> {

        /* renamed from: com.google.common.collect.MutableClassToInstanceMap$2$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.collect.TransformedIterator<java.util.Map.Entry<java.lang.Class<? extends B>, B>, java.util.Map.Entry<java.lang.Class<? extends B>, B>> {
            public AnonymousClass1(java.util.Iterator it) {
                super(it);
            }

            @Override // com.google.common.collect.TransformedIterator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public java.util.Map.Entry<java.lang.Class<? extends B>, B> a(java.util.Map.Entry<java.lang.Class<? extends B>, B> entry) {
                return com.google.common.collect.MutableClassToInstanceMap.checkedEntry(entry);
            }
        }

        public AnonymousClass2() {
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public java.util.Set<java.util.Map.Entry<java.lang.Class<? extends B>, B>> delegate() {
            return com.google.common.collect.MutableClassToInstanceMap.this.delegate().entrySet();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<java.util.Map.Entry<java.lang.Class<? extends B>, B>> iterator() {
            return new com.google.common.collect.MutableClassToInstanceMap.AnonymousClass2.AnonymousClass1(delegate().iterator());
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

    public static final class SerializedForm<B> implements java.io.Serializable {
        private static final long serialVersionUID = 0;
        private final java.util.Map<java.lang.Class<? extends B>, B> backingMap;

        public SerializedForm(java.util.Map<java.lang.Class<? extends B>, B> map) {
            this.backingMap = map;
        }

        public java.lang.Object readResolve() {
            return com.google.common.collect.MutableClassToInstanceMap.create(this.backingMap);
        }
    }

    private MutableClassToInstanceMap(java.util.Map<java.lang.Class<? extends B>, B> map) {
        this.delegate = (java.util.Map) com.google.common.base.Preconditions.checkNotNull(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static <B, T extends B> T cast(java.lang.Class<T> cls, B b) {
        return (T) com.google.common.primitives.Primitives.wrap(cls).cast(b);
    }

    public static <B> java.util.Map.Entry<java.lang.Class<? extends B>, B> checkedEntry(java.util.Map.Entry<java.lang.Class<? extends B>, B> entry) {
        return new com.google.common.collect.MutableClassToInstanceMap.AnonymousClass1(entry);
    }

    public static <B> com.google.common.collect.MutableClassToInstanceMap<B> create() {
        return new com.google.common.collect.MutableClassToInstanceMap<>(new java.util.HashMap());
    }

    public static <B> com.google.common.collect.MutableClassToInstanceMap<B> create(java.util.Map<java.lang.Class<? extends B>, B> map) {
        return new com.google.common.collect.MutableClassToInstanceMap<>(map);
    }

    private java.lang.Object writeReplace() {
        return new com.google.common.collect.MutableClassToInstanceMap.SerializedForm(delegate());
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public java.util.Map<java.lang.Class<? extends B>, B> delegate() {
        return this.delegate;
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public java.util.Set<java.util.Map.Entry<java.lang.Class<? extends B>, B>> entrySet() {
        return new com.google.common.collect.MutableClassToInstanceMap.AnonymousClass2();
    }

    @Override // com.google.common.collect.ClassToInstanceMap
    public <T extends B> T getInstance(java.lang.Class<T> cls) {
        return (T) cast(cls, get(cls));
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public B put(java.lang.Class<? extends B> cls, B b) {
        return (B) super.put((com.google.common.collect.MutableClassToInstanceMap<B>) cls, (java.lang.Class<? extends B>) cast(cls, b));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ java.lang.Object put(java.lang.Object obj, java.lang.Object obj2) {
        return put((java.lang.Class<? extends java.lang.Class<? extends B>>) obj, (java.lang.Class<? extends B>) obj2);
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    public void putAll(java.util.Map<? extends java.lang.Class<? extends B>, ? extends B> map) {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(map);
        for (java.util.Map.Entry entry : linkedHashMap.entrySet()) {
            cast((java.lang.Class) entry.getKey(), entry.getValue());
        }
        super.putAll(linkedHashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ClassToInstanceMap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public <T extends B> T putInstance(java.lang.Class<T> cls, T t) {
        return (T) cast(cls, put((java.lang.Class<? extends java.lang.Class<T>>) cls, (java.lang.Class<T>) t));
    }
}
