package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
abstract class AbstractTable<R, C, V> implements com.google.common.collect.Table<R, C, V> {

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    private transient java.util.Set<com.google.common.collect.Table.Cell<R, C, V>> cellSet;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    private transient java.util.Collection<V> values;

    /* renamed from: com.google.common.collect.AbstractTable$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.common.collect.TransformedIterator<com.google.common.collect.Table.Cell<R, C, V>, V> {
        public AnonymousClass1(java.util.Iterator it) {
            super(it);
        }

        @Override // com.google.common.collect.TransformedIterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public V a(com.google.common.collect.Table.Cell<R, C, V> cell) {
            return cell.getValue();
        }
    }

    public class CellSet extends java.util.AbstractSet<com.google.common.collect.Table.Cell<R, C, V>> {
        public CellSet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            com.google.common.collect.AbstractTable.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(java.lang.Object obj) {
            if (!(obj instanceof com.google.common.collect.Table.Cell)) {
                return false;
            }
            com.google.common.collect.Table.Cell cell = (com.google.common.collect.Table.Cell) obj;
            java.util.Map map = (java.util.Map) com.google.common.collect.Maps.G(com.google.common.collect.AbstractTable.this.rowMap(), cell.getRowKey());
            return map != null && com.google.common.collect.Collections2.g(map.entrySet(), com.google.common.collect.Maps.immutableEntry(cell.getColumnKey(), cell.getValue()));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<com.google.common.collect.Table.Cell<R, C, V>> iterator() {
            return com.google.common.collect.AbstractTable.this.cellIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (!(obj instanceof com.google.common.collect.Table.Cell)) {
                return false;
            }
            com.google.common.collect.Table.Cell cell = (com.google.common.collect.Table.Cell) obj;
            java.util.Map map = (java.util.Map) com.google.common.collect.Maps.G(com.google.common.collect.AbstractTable.this.rowMap(), cell.getRowKey());
            return map != null && com.google.common.collect.Collections2.h(map.entrySet(), com.google.common.collect.Maps.immutableEntry(cell.getColumnKey(), cell.getValue()));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return com.google.common.collect.AbstractTable.this.size();
        }
    }

    public class Values extends java.util.AbstractCollection<V> {
        public Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            com.google.common.collect.AbstractTable.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(java.lang.Object obj) {
            return com.google.common.collect.AbstractTable.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public java.util.Iterator<V> iterator() {
            return com.google.common.collect.AbstractTable.this.valuesIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return com.google.common.collect.AbstractTable.this.size();
        }
    }

    public abstract java.util.Iterator<com.google.common.collect.Table.Cell<R, C, V>> cellIterator();

    @Override // com.google.common.collect.Table
    public java.util.Set<com.google.common.collect.Table.Cell<R, C, V>> cellSet() {
        java.util.Set<com.google.common.collect.Table.Cell<R, C, V>> set = this.cellSet;
        if (set != null) {
            return set;
        }
        java.util.Set<com.google.common.collect.Table.Cell<R, C, V>> createCellSet = createCellSet();
        this.cellSet = createCellSet;
        return createCellSet;
    }

    @Override // com.google.common.collect.Table
    public void clear() {
        com.google.common.collect.Iterators.c(cellSet().iterator());
    }

    @Override // com.google.common.collect.Table
    public java.util.Set<C> columnKeySet() {
        return columnMap().keySet();
    }

    @Override // com.google.common.collect.Table
    public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2) {
        java.util.Map map = (java.util.Map) com.google.common.collect.Maps.G(rowMap(), obj);
        return map != null && com.google.common.collect.Maps.F(map, obj2);
    }

    @Override // com.google.common.collect.Table
    public boolean containsColumn(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return com.google.common.collect.Maps.F(columnMap(), obj);
    }

    @Override // com.google.common.collect.Table
    public boolean containsRow(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return com.google.common.collect.Maps.F(rowMap(), obj);
    }

    @Override // com.google.common.collect.Table
    public boolean containsValue(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        java.util.Iterator<java.util.Map<C, V>> it = rowMap().values().iterator();
        while (it.hasNext()) {
            if (it.next().containsValue(obj)) {
                return true;
            }
        }
        return false;
    }

    public java.util.Set<com.google.common.collect.Table.Cell<R, C, V>> createCellSet() {
        return new com.google.common.collect.AbstractTable.CellSet();
    }

    public java.util.Collection<V> createValues() {
        return new com.google.common.collect.AbstractTable.Values();
    }

    @Override // com.google.common.collect.Table
    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return com.google.common.collect.Tables.b(this, obj);
    }

    @Override // com.google.common.collect.Table
    public V get(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2) {
        java.util.Map map = (java.util.Map) com.google.common.collect.Maps.G(rowMap(), obj);
        if (map == null) {
            return null;
        }
        return (V) com.google.common.collect.Maps.G(map, obj2);
    }

    @Override // com.google.common.collect.Table
    public int hashCode() {
        return cellSet().hashCode();
    }

    @Override // com.google.common.collect.Table
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // com.google.common.collect.Table
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public V put(R r, C c, V v) {
        return row(r).put(c, v);
    }

    @Override // com.google.common.collect.Table
    public void putAll(com.google.common.collect.Table<? extends R, ? extends C, ? extends V> table) {
        for (com.google.common.collect.Table.Cell<? extends R, ? extends C, ? extends V> cell : table.cellSet()) {
            put(cell.getRowKey(), cell.getColumnKey(), cell.getValue());
        }
    }

    @Override // com.google.common.collect.Table
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public V remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2) {
        java.util.Map map = (java.util.Map) com.google.common.collect.Maps.G(rowMap(), obj);
        if (map == null) {
            return null;
        }
        return (V) com.google.common.collect.Maps.H(map, obj2);
    }

    @Override // com.google.common.collect.Table
    public java.util.Set<R> rowKeySet() {
        return rowMap().keySet();
    }

    public java.lang.String toString() {
        return rowMap().toString();
    }

    @Override // com.google.common.collect.Table
    public java.util.Collection<V> values() {
        java.util.Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        java.util.Collection<V> createValues = createValues();
        this.values = createValues;
        return createValues;
    }

    public java.util.Iterator<V> valuesIterator() {
        return new com.google.common.collect.AbstractTable.AnonymousClass1(cellSet().iterator());
    }
}
