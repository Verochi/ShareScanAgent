package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
class SingletonImmutableTable<R, C, V> extends com.google.common.collect.ImmutableTable<R, C, V> {
    final C singleColumnKey;
    final R singleRowKey;
    final V singleValue;

    public SingletonImmutableTable(com.google.common.collect.Table.Cell<R, C, V> cell) {
        this(cell.getRowKey(), cell.getColumnKey(), cell.getValue());
    }

    public SingletonImmutableTable(R r, C c, V v) {
        this.singleRowKey = (R) com.google.common.base.Preconditions.checkNotNull(r);
        this.singleColumnKey = (C) com.google.common.base.Preconditions.checkNotNull(c);
        this.singleValue = (V) com.google.common.base.Preconditions.checkNotNull(v);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public com.google.common.collect.ImmutableMap<R, V> column(C c) {
        com.google.common.base.Preconditions.checkNotNull(c);
        return containsColumn(c) ? com.google.common.collect.ImmutableMap.of(this.singleRowKey, (java.lang.Object) this.singleValue) : com.google.common.collect.ImmutableMap.of();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ java.util.Map column(java.lang.Object obj) {
        return column((com.google.common.collect.SingletonImmutableTable<R, C, V>) obj);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public com.google.common.collect.ImmutableMap<C, java.util.Map<R, V>> columnMap() {
        return com.google.common.collect.ImmutableMap.of(this.singleColumnKey, com.google.common.collect.ImmutableMap.of(this.singleRowKey, (java.lang.Object) this.singleValue));
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractTable
    public com.google.common.collect.ImmutableSet<com.google.common.collect.Table.Cell<R, C, V>> createCellSet() {
        return com.google.common.collect.ImmutableSet.of(com.google.common.collect.ImmutableTable.cellOf(this.singleRowKey, this.singleColumnKey, this.singleValue));
    }

    @Override // com.google.common.collect.ImmutableTable
    public com.google.common.collect.ImmutableTable.SerializedForm createSerializedForm() {
        return com.google.common.collect.ImmutableTable.SerializedForm.create(this, new int[]{0}, new int[]{0});
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractTable
    public com.google.common.collect.ImmutableCollection<V> createValues() {
        return com.google.common.collect.ImmutableSet.of(this.singleValue);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public com.google.common.collect.ImmutableMap<R, java.util.Map<C, V>> rowMap() {
        return com.google.common.collect.ImmutableMap.of(this.singleRowKey, com.google.common.collect.ImmutableMap.of(this.singleColumnKey, (java.lang.Object) this.singleValue));
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return 1;
    }
}
