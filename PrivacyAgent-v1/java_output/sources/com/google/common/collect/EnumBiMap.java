package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public final class EnumBiMap<K extends java.lang.Enum<K>, V extends java.lang.Enum<V>> extends com.google.common.collect.AbstractBiMap<K, V> {

    @com.google.common.annotations.GwtIncompatible
    private static final long serialVersionUID = 0;
    private transient java.lang.Class<K> keyType;
    private transient java.lang.Class<V> valueType;

    private EnumBiMap(java.lang.Class<K> cls, java.lang.Class<V> cls2) {
        super(new java.util.EnumMap(cls), new java.util.EnumMap(cls2));
        this.keyType = cls;
        this.valueType = cls2;
    }

    public static <K extends java.lang.Enum<K>, V extends java.lang.Enum<V>> com.google.common.collect.EnumBiMap<K, V> create(java.lang.Class<K> cls, java.lang.Class<V> cls2) {
        return new com.google.common.collect.EnumBiMap<>(cls, cls2);
    }

    public static <K extends java.lang.Enum<K>, V extends java.lang.Enum<V>> com.google.common.collect.EnumBiMap<K, V> create(java.util.Map<K, V> map) {
        com.google.common.collect.EnumBiMap<K, V> create = create(inferKeyType(map), inferValueType(map));
        create.putAll(map);
        return create;
    }

    public static <K extends java.lang.Enum<K>> java.lang.Class<K> inferKeyType(java.util.Map<K, ?> map) {
        if (map instanceof com.google.common.collect.EnumBiMap) {
            return ((com.google.common.collect.EnumBiMap) map).keyType();
        }
        if (map instanceof com.google.common.collect.EnumHashBiMap) {
            return ((com.google.common.collect.EnumHashBiMap) map).keyType();
        }
        com.google.common.base.Preconditions.checkArgument(!map.isEmpty());
        return map.keySet().iterator().next().getDeclaringClass();
    }

    private static <V extends java.lang.Enum<V>> java.lang.Class<V> inferValueType(java.util.Map<?, V> map) {
        if (map instanceof com.google.common.collect.EnumBiMap) {
            return ((com.google.common.collect.EnumBiMap) map).valueType;
        }
        com.google.common.base.Preconditions.checkArgument(!map.isEmpty());
        return map.values().iterator().next().getDeclaringClass();
    }

    @com.google.common.annotations.GwtIncompatible
    private void readObject(java.io.ObjectInputStream objectInputStream) throws java.io.IOException, java.lang.ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.keyType = (java.lang.Class) objectInputStream.readObject();
        this.valueType = (java.lang.Class) objectInputStream.readObject();
        setDelegates(new java.util.EnumMap(this.keyType), new java.util.EnumMap(this.valueType));
        com.google.common.collect.Serialization.b(this, objectInputStream);
    }

    @com.google.common.annotations.GwtIncompatible
    private void writeObject(java.io.ObjectOutputStream objectOutputStream) throws java.io.IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.keyType);
        objectOutputStream.writeObject(this.valueType);
        com.google.common.collect.Serialization.i(this, objectOutputStream);
    }

    @Override // com.google.common.collect.AbstractBiMap
    public K checkKey(K k) {
        return (K) com.google.common.base.Preconditions.checkNotNull(k);
    }

    @Override // com.google.common.collect.AbstractBiMap
    public V checkValue(V v) {
        return (V) com.google.common.base.Preconditions.checkNotNull(v);
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ boolean containsValue(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ java.util.Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.BiMap
    public /* bridge */ /* synthetic */ com.google.common.collect.BiMap inverse() {
        return super.inverse();
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ java.util.Set keySet() {
        return super.keySet();
    }

    public java.lang.Class<K> keyType() {
        return this.keyType;
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    public /* bridge */ /* synthetic */ void putAll(java.util.Map map) {
        super.putAll(map);
    }

    public java.lang.Class<V> valueType() {
        return this.valueType;
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ java.util.Set values() {
        return super.values();
    }
}
