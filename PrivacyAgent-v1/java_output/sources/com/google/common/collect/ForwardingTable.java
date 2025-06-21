package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public abstract class ForwardingTable<R, C, V> extends com.google.common.collect.ForwardingObject implements com.google.common.collect.Table<R, C, V> {
    @Override // com.google.common.collect.Table
    public java.util.Set<com.google.common.collect.Table.Cell<R, C, V>> cellSet() {
        return delegate().cellSet();
    }

    @Override // com.google.common.collect.Table
    public void clear() {
        delegate().clear();
    }

    @Override // com.google.common.collect.Table
    public java.util.Map<R, V> column(C c) {
        return delegate().column(c);
    }

    @Override // com.google.common.collect.Table
    public java.util.Set<C> columnKeySet() {
        return delegate().columnKeySet();
    }

    @Override // com.google.common.collect.Table
    public java.util.Map<C, java.util.Map<R, V>> columnMap() {
        return delegate().columnMap();
    }

    @Override // com.google.common.collect.Table
    public boolean contains(java.lang.Object obj, java.lang.Object obj2) {
        return delegate().contains(obj, obj2);
    }

    @Override // com.google.common.collect.Table
    public boolean containsColumn(java.lang.Object obj) {
        return delegate().containsColumn(obj);
    }

    @Override // com.google.common.collect.Table
    public boolean containsRow(java.lang.Object obj) {
        return delegate().containsRow(obj);
    }

    @Override // com.google.common.collect.Table
    public boolean containsValue(java.lang.Object obj) {
        return delegate().containsValue(obj);
    }

    @Override // com.google.common.collect.ForwardingObject
    public abstract com.google.common.collect.Table<R, C, V> delegate();

    @Override // com.google.common.collect.Table
    public boolean equals(java.lang.Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @Override // com.google.common.collect.Table
    public V get(java.lang.Object obj, java.lang.Object obj2) {
        return delegate().get(obj, obj2);
    }

    @Override // com.google.common.collect.Table
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // com.google.common.collect.Table
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    @Override // com.google.common.collect.Table
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public V put(R r, C c, V v) {
        return delegate().put(r, c, v);
    }

    @Override // com.google.common.collect.Table
    public void putAll(com.google.common.collect.Table<? extends R, ? extends C, ? extends V> table) {
        delegate().putAll(table);
    }

    @Override // com.google.common.collect.Table
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public V remove(java.lang.Object obj, java.lang.Object obj2) {
        return delegate().remove(obj, obj2);
    }

    @Override // com.google.common.collect.Table
    public java.util.Map<C, V> row(R r) {
        return delegate().row(r);
    }

    @Override // com.google.common.collect.Table
    public java.util.Set<R> rowKeySet() {
        return delegate().rowKeySet();
    }

    @Override // com.google.common.collect.Table
    public java.util.Map<R, java.util.Map<C, V>> rowMap() {
        return delegate().rowMap();
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return delegate().size();
    }

    @Override // com.google.common.collect.Table
    public java.util.Collection<V> values() {
        return delegate().values();
    }
}
