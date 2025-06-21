package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
abstract class AbstractMapEntry<K, V> implements java.util.Map.Entry<K, V> {
    @Override // java.util.Map.Entry
    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (!(obj instanceof java.util.Map.Entry)) {
            return false;
        }
        java.util.Map.Entry entry = (java.util.Map.Entry) obj;
        return com.google.common.base.Objects.equal(getKey(), entry.getKey()) && com.google.common.base.Objects.equal(getValue(), entry.getValue());
    }

    @Override // java.util.Map.Entry
    public abstract K getKey();

    @Override // java.util.Map.Entry
    public abstract V getValue();

    @Override // java.util.Map.Entry
    public int hashCode() {
        K key = getKey();
        V value = getValue();
        return (key == null ? 0 : key.hashCode()) ^ (value != null ? value.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public V setValue(V v) {
        throw new java.lang.UnsupportedOperationException();
    }

    public java.lang.String toString() {
        return getKey() + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + getValue();
    }
}
