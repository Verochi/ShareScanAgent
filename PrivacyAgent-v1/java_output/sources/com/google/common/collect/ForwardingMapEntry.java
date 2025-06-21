package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public abstract class ForwardingMapEntry<K, V> extends com.google.common.collect.ForwardingObject implements java.util.Map.Entry<K, V> {
    @Override // com.google.common.collect.ForwardingObject
    public abstract java.util.Map.Entry<K, V> delegate();

    @Override // java.util.Map.Entry
    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return delegate().equals(obj);
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        return delegate().getKey();
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return delegate().getValue();
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        return delegate().hashCode();
    }

    public V setValue(V v) {
        return delegate().setValue(v);
    }

    public boolean standardEquals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (!(obj instanceof java.util.Map.Entry)) {
            return false;
        }
        java.util.Map.Entry entry = (java.util.Map.Entry) obj;
        return com.google.common.base.Objects.equal(getKey(), entry.getKey()) && com.google.common.base.Objects.equal(getValue(), entry.getValue());
    }

    public int standardHashCode() {
        K key = getKey();
        V value = getValue();
        return (key == null ? 0 : key.hashCode()) ^ (value != null ? value.hashCode() : 0);
    }

    @com.google.common.annotations.Beta
    public java.lang.String standardToString() {
        return getKey() + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + getValue();
    }
}
