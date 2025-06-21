package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public final class EnumHashBiMap<K extends java.lang.Enum<K>, V> extends com.google.common.collect.AbstractBiMap<K, V> {

    @com.google.common.annotations.GwtIncompatible
    private static final long serialVersionUID = 0;
    private transient java.lang.Class<K> keyType;

    private EnumHashBiMap(java.lang.Class<K> cls) {
        super(new java.util.EnumMap(cls), com.google.common.collect.Maps.newHashMapWithExpectedSize(cls.getEnumConstants().length));
        this.keyType = cls;
    }

    public static <K extends java.lang.Enum<K>, V> com.google.common.collect.EnumHashBiMap<K, V> create(java.lang.Class<K> cls) {
        return new com.google.common.collect.EnumHashBiMap<>(cls);
    }

    public static <K extends java.lang.Enum<K>, V> com.google.common.collect.EnumHashBiMap<K, V> create(java.util.Map<K, ? extends V> map) {
        com.google.common.collect.EnumHashBiMap<K, V> create = create(com.google.common.collect.EnumBiMap.inferKeyType(map));
        create.putAll(map);
        return create;
    }

    @com.google.common.annotations.GwtIncompatible
    private void readObject(java.io.ObjectInputStream objectInputStream) throws java.io.IOException, java.lang.ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.keyType = (java.lang.Class) objectInputStream.readObject();
        setDelegates(new java.util.EnumMap(this.keyType), new java.util.HashMap((this.keyType.getEnumConstants().length * 3) / 2));
        com.google.common.collect.Serialization.b(this, objectInputStream);
    }

    @com.google.common.annotations.GwtIncompatible
    private void writeObject(java.io.ObjectOutputStream objectOutputStream) throws java.io.IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.keyType);
        com.google.common.collect.Serialization.i(this, objectOutputStream);
    }

    @Override // com.google.common.collect.AbstractBiMap
    public K checkKey(K k) {
        return (K) com.google.common.base.Preconditions.checkNotNull(k);
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

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public V forcePut(K k, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
        return (V) super.forcePut((com.google.common.collect.EnumHashBiMap<K, V>) k, (K) v);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.BiMap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ java.lang.Object forcePut(java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2) {
        return forcePut((com.google.common.collect.EnumHashBiMap<K, V>) obj, (java.lang.Enum) obj2);
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

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public V put(K k, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
        return (V) super.put((com.google.common.collect.EnumHashBiMap<K, V>) k, (K) v);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ java.lang.Object put(java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2) {
        return put((com.google.common.collect.EnumHashBiMap<K, V>) obj, (java.lang.Enum) obj2);
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    public /* bridge */ /* synthetic */ void putAll(java.util.Map map) {
        super.putAll(map);
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ java.lang.Object remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ java.util.Set values() {
        return super.values();
    }
}
