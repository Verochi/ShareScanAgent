package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public final class Tables {
    public static final com.google.common.base.Function<? extends java.util.Map<?, ?>, ? extends java.util.Map<?, ?>> a = new com.google.common.collect.Tables.AnonymousClass1();

    /* renamed from: com.google.common.collect.Tables$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.google.common.base.Function<java.util.Map<java.lang.Object, java.lang.Object>, java.util.Map<java.lang.Object, java.lang.Object>> {
        @Override // com.google.common.base.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.util.Map<java.lang.Object, java.lang.Object> apply(java.util.Map<java.lang.Object, java.lang.Object> map) {
            return java.util.Collections.unmodifiableMap(map);
        }
    }

    public static abstract class AbstractCell<R, C, V> implements com.google.common.collect.Table.Cell<R, C, V> {
        @Override // com.google.common.collect.Table.Cell
        public boolean equals(java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.google.common.collect.Table.Cell)) {
                return false;
            }
            com.google.common.collect.Table.Cell cell = (com.google.common.collect.Table.Cell) obj;
            return com.google.common.base.Objects.equal(getRowKey(), cell.getRowKey()) && com.google.common.base.Objects.equal(getColumnKey(), cell.getColumnKey()) && com.google.common.base.Objects.equal(getValue(), cell.getValue());
        }

        @Override // com.google.common.collect.Table.Cell
        public int hashCode() {
            return com.google.common.base.Objects.hashCode(getRowKey(), getColumnKey(), getValue());
        }

        public java.lang.String toString() {
            return "(" + getRowKey() + "," + getColumnKey() + ")=" + getValue();
        }
    }

    public static final class ImmutableCell<R, C, V> extends com.google.common.collect.Tables.AbstractCell<R, C, V> implements java.io.Serializable {
        private static final long serialVersionUID = 0;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        private final C columnKey;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        private final R rowKey;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        private final V value;

        public ImmutableCell(@org.checkerframework.checker.nullness.compatqual.NullableDecl R r, @org.checkerframework.checker.nullness.compatqual.NullableDecl C c, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
            this.rowKey = r;
            this.columnKey = c;
            this.value = v;
        }

        @Override // com.google.common.collect.Table.Cell
        public C getColumnKey() {
            return this.columnKey;
        }

        @Override // com.google.common.collect.Table.Cell
        public R getRowKey() {
            return this.rowKey;
        }

        @Override // com.google.common.collect.Table.Cell
        public V getValue() {
            return this.value;
        }
    }

    public static class TransformedTable<R, C, V1, V2> extends com.google.common.collect.AbstractTable<R, C, V2> {
        public final com.google.common.collect.Table<R, C, V1> n;
        public final com.google.common.base.Function<? super V1, V2> t;

        /* renamed from: com.google.common.collect.Tables$TransformedTable$1, reason: invalid class name */
        public class AnonymousClass1 implements com.google.common.base.Function<com.google.common.collect.Table.Cell<R, C, V1>, com.google.common.collect.Table.Cell<R, C, V2>> {
            public AnonymousClass1() {
            }

            @Override // com.google.common.base.Function
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public com.google.common.collect.Table.Cell<R, C, V2> apply(com.google.common.collect.Table.Cell<R, C, V1> cell) {
                return com.google.common.collect.Tables.immutableCell(cell.getRowKey(), cell.getColumnKey(), com.google.common.collect.Tables.TransformedTable.this.t.apply(cell.getValue()));
            }
        }

        /* renamed from: com.google.common.collect.Tables$TransformedTable$2, reason: invalid class name */
        public class AnonymousClass2 implements com.google.common.base.Function<java.util.Map<C, V1>, java.util.Map<C, V2>> {
            public AnonymousClass2() {
            }

            @Override // com.google.common.base.Function
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public java.util.Map<C, V2> apply(java.util.Map<C, V1> map) {
                return com.google.common.collect.Maps.transformValues(map, com.google.common.collect.Tables.TransformedTable.this.t);
            }
        }

        /* renamed from: com.google.common.collect.Tables$TransformedTable$3, reason: invalid class name */
        public class AnonymousClass3 implements com.google.common.base.Function<java.util.Map<R, V1>, java.util.Map<R, V2>> {
            public AnonymousClass3() {
            }

            @Override // com.google.common.base.Function
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public java.util.Map<R, V2> apply(java.util.Map<R, V1> map) {
                return com.google.common.collect.Maps.transformValues(map, com.google.common.collect.Tables.TransformedTable.this.t);
            }
        }

        public TransformedTable(com.google.common.collect.Table<R, C, V1> table, com.google.common.base.Function<? super V1, V2> function) {
            this.n = (com.google.common.collect.Table) com.google.common.base.Preconditions.checkNotNull(table);
            this.t = (com.google.common.base.Function) com.google.common.base.Preconditions.checkNotNull(function);
        }

        @Override // com.google.common.collect.AbstractTable
        public java.util.Iterator<com.google.common.collect.Table.Cell<R, C, V2>> cellIterator() {
            return com.google.common.collect.Iterators.transform(this.n.cellSet().iterator(), i());
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public void clear() {
            this.n.clear();
        }

        @Override // com.google.common.collect.Table
        public java.util.Map<R, V2> column(C c) {
            return com.google.common.collect.Maps.transformValues(this.n.column(c), this.t);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public java.util.Set<C> columnKeySet() {
            return this.n.columnKeySet();
        }

        @Override // com.google.common.collect.Table
        public java.util.Map<C, java.util.Map<R, V2>> columnMap() {
            return com.google.common.collect.Maps.transformValues(this.n.columnMap(), new com.google.common.collect.Tables.TransformedTable.AnonymousClass3());
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public boolean contains(java.lang.Object obj, java.lang.Object obj2) {
            return this.n.contains(obj, obj2);
        }

        @Override // com.google.common.collect.AbstractTable
        public java.util.Collection<V2> createValues() {
            return com.google.common.collect.Collections2.transform(this.n.values(), this.t);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public V2 get(java.lang.Object obj, java.lang.Object obj2) {
            if (contains(obj, obj2)) {
                return this.t.apply(this.n.get(obj, obj2));
            }
            return null;
        }

        public com.google.common.base.Function<com.google.common.collect.Table.Cell<R, C, V1>, com.google.common.collect.Table.Cell<R, C, V2>> i() {
            return new com.google.common.collect.Tables.TransformedTable.AnonymousClass1();
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public V2 put(R r, C c, V2 v2) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public void putAll(com.google.common.collect.Table<? extends R, ? extends C, ? extends V2> table) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public V2 remove(java.lang.Object obj, java.lang.Object obj2) {
            if (contains(obj, obj2)) {
                return this.t.apply(this.n.remove(obj, obj2));
            }
            return null;
        }

        @Override // com.google.common.collect.Table
        public java.util.Map<C, V2> row(R r) {
            return com.google.common.collect.Maps.transformValues(this.n.row(r), this.t);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public java.util.Set<R> rowKeySet() {
            return this.n.rowKeySet();
        }

        @Override // com.google.common.collect.Table
        public java.util.Map<R, java.util.Map<C, V2>> rowMap() {
            return com.google.common.collect.Maps.transformValues(this.n.rowMap(), new com.google.common.collect.Tables.TransformedTable.AnonymousClass2());
        }

        @Override // com.google.common.collect.Table
        public int size() {
            return this.n.size();
        }
    }

    public static class TransposeTable<C, R, V> extends com.google.common.collect.AbstractTable<C, R, V> {
        public static final com.google.common.base.Function<com.google.common.collect.Table.Cell<?, ?, ?>, com.google.common.collect.Table.Cell<?, ?, ?>> t = new com.google.common.collect.Tables.TransposeTable.AnonymousClass1();
        public final com.google.common.collect.Table<R, C, V> n;

        /* renamed from: com.google.common.collect.Tables$TransposeTable$1, reason: invalid class name */
        public static class AnonymousClass1 implements com.google.common.base.Function<com.google.common.collect.Table.Cell<?, ?, ?>, com.google.common.collect.Table.Cell<?, ?, ?>> {
            @Override // com.google.common.base.Function
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public com.google.common.collect.Table.Cell<?, ?, ?> apply(com.google.common.collect.Table.Cell<?, ?, ?> cell) {
                return com.google.common.collect.Tables.immutableCell(cell.getColumnKey(), cell.getRowKey(), cell.getValue());
            }
        }

        public TransposeTable(com.google.common.collect.Table<R, C, V> table) {
            this.n = (com.google.common.collect.Table) com.google.common.base.Preconditions.checkNotNull(table);
        }

        @Override // com.google.common.collect.AbstractTable
        public java.util.Iterator<com.google.common.collect.Table.Cell<C, R, V>> cellIterator() {
            return com.google.common.collect.Iterators.transform(this.n.cellSet().iterator(), t);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public void clear() {
            this.n.clear();
        }

        @Override // com.google.common.collect.Table
        public java.util.Map<C, V> column(R r) {
            return this.n.row(r);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public java.util.Set<R> columnKeySet() {
            return this.n.rowKeySet();
        }

        @Override // com.google.common.collect.Table
        public java.util.Map<R, java.util.Map<C, V>> columnMap() {
            return this.n.rowMap();
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2) {
            return this.n.contains(obj2, obj);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public boolean containsColumn(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return this.n.containsRow(obj);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public boolean containsRow(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return this.n.containsColumn(obj);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public boolean containsValue(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return this.n.containsValue(obj);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public V get(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2) {
            return this.n.get(obj2, obj);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public V put(C c, R r, V v) {
            return this.n.put(r, c, v);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public void putAll(com.google.common.collect.Table<? extends C, ? extends R, ? extends V> table) {
            this.n.putAll(com.google.common.collect.Tables.transpose(table));
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public V remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2) {
            return this.n.remove(obj2, obj);
        }

        @Override // com.google.common.collect.Table
        public java.util.Map<R, V> row(C c) {
            return this.n.column(c);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public java.util.Set<C> rowKeySet() {
            return this.n.columnKeySet();
        }

        @Override // com.google.common.collect.Table
        public java.util.Map<C, java.util.Map<R, V>> rowMap() {
            return this.n.columnMap();
        }

        @Override // com.google.common.collect.Table
        public int size() {
            return this.n.size();
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public java.util.Collection<V> values() {
            return this.n.values();
        }
    }

    public static final class UnmodifiableRowSortedMap<R, C, V> extends com.google.common.collect.Tables.UnmodifiableTable<R, C, V> implements com.google.common.collect.RowSortedTable<R, C, V> {
        private static final long serialVersionUID = 0;

        public UnmodifiableRowSortedMap(com.google.common.collect.RowSortedTable<R, ? extends C, ? extends V> rowSortedTable) {
            super(rowSortedTable);
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.ForwardingTable, com.google.common.collect.ForwardingObject
        public com.google.common.collect.RowSortedTable<R, C, V> delegate() {
            return (com.google.common.collect.RowSortedTable) super.delegate();
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public java.util.SortedSet<R> rowKeySet() {
            return java.util.Collections.unmodifiableSortedSet(delegate().rowKeySet());
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public java.util.SortedMap<R, java.util.Map<C, V>> rowMap() {
            return java.util.Collections.unmodifiableSortedMap(com.google.common.collect.Maps.transformValues((java.util.SortedMap) delegate().rowMap(), com.google.common.collect.Tables.c()));
        }
    }

    public static class UnmodifiableTable<R, C, V> extends com.google.common.collect.ForwardingTable<R, C, V> implements java.io.Serializable {
        private static final long serialVersionUID = 0;
        final com.google.common.collect.Table<? extends R, ? extends C, ? extends V> delegate;

        public UnmodifiableTable(com.google.common.collect.Table<? extends R, ? extends C, ? extends V> table) {
            this.delegate = (com.google.common.collect.Table) com.google.common.base.Preconditions.checkNotNull(table);
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public java.util.Set<com.google.common.collect.Table.Cell<R, C, V>> cellSet() {
            return java.util.Collections.unmodifiableSet(super.cellSet());
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public void clear() {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public java.util.Map<R, V> column(@org.checkerframework.checker.nullness.compatqual.NullableDecl C c) {
            return java.util.Collections.unmodifiableMap(super.column(c));
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public java.util.Set<C> columnKeySet() {
            return java.util.Collections.unmodifiableSet(super.columnKeySet());
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public java.util.Map<C, java.util.Map<R, V>> columnMap() {
            return java.util.Collections.unmodifiableMap(com.google.common.collect.Maps.transformValues(super.columnMap(), com.google.common.collect.Tables.c()));
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.ForwardingObject
        public com.google.common.collect.Table<R, C, V> delegate() {
            return this.delegate;
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public V put(@org.checkerframework.checker.nullness.compatqual.NullableDecl R r, @org.checkerframework.checker.nullness.compatqual.NullableDecl C c, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public void putAll(com.google.common.collect.Table<? extends R, ? extends C, ? extends V> table) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public V remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public java.util.Map<C, V> row(@org.checkerframework.checker.nullness.compatqual.NullableDecl R r) {
            return java.util.Collections.unmodifiableMap(super.row(r));
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public java.util.Set<R> rowKeySet() {
            return java.util.Collections.unmodifiableSet(super.rowKeySet());
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public java.util.Map<R, java.util.Map<C, V>> rowMap() {
            return java.util.Collections.unmodifiableMap(com.google.common.collect.Maps.transformValues(super.rowMap(), com.google.common.collect.Tables.c()));
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public java.util.Collection<V> values() {
            return java.util.Collections.unmodifiableCollection(super.values());
        }
    }

    public static boolean b(com.google.common.collect.Table<?, ?, ?> table, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj == table) {
            return true;
        }
        if (obj instanceof com.google.common.collect.Table) {
            return table.cellSet().equals(((com.google.common.collect.Table) obj).cellSet());
        }
        return false;
    }

    public static <K, V> com.google.common.base.Function<java.util.Map<K, V>, java.util.Map<K, V>> c() {
        return (com.google.common.base.Function<java.util.Map<K, V>, java.util.Map<K, V>>) a;
    }

    public static <R, C, V> com.google.common.collect.Table.Cell<R, C, V> immutableCell(@org.checkerframework.checker.nullness.compatqual.NullableDecl R r, @org.checkerframework.checker.nullness.compatqual.NullableDecl C c, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
        return new com.google.common.collect.Tables.ImmutableCell(r, c, v);
    }

    @com.google.common.annotations.Beta
    public static <R, C, V> com.google.common.collect.Table<R, C, V> newCustomTable(java.util.Map<R, java.util.Map<C, V>> map, com.google.common.base.Supplier<? extends java.util.Map<C, V>> supplier) {
        com.google.common.base.Preconditions.checkArgument(map.isEmpty());
        com.google.common.base.Preconditions.checkNotNull(supplier);
        return new com.google.common.collect.StandardTable(map, supplier);
    }

    public static <R, C, V> com.google.common.collect.Table<R, C, V> synchronizedTable(com.google.common.collect.Table<R, C, V> table) {
        return com.google.common.collect.Synchronized.z(table, null);
    }

    @com.google.common.annotations.Beta
    public static <R, C, V1, V2> com.google.common.collect.Table<R, C, V2> transformValues(com.google.common.collect.Table<R, C, V1> table, com.google.common.base.Function<? super V1, V2> function) {
        return new com.google.common.collect.Tables.TransformedTable(table, function);
    }

    public static <R, C, V> com.google.common.collect.Table<C, R, V> transpose(com.google.common.collect.Table<R, C, V> table) {
        return table instanceof com.google.common.collect.Tables.TransposeTable ? ((com.google.common.collect.Tables.TransposeTable) table).n : new com.google.common.collect.Tables.TransposeTable(table);
    }

    @com.google.common.annotations.Beta
    public static <R, C, V> com.google.common.collect.RowSortedTable<R, C, V> unmodifiableRowSortedTable(com.google.common.collect.RowSortedTable<R, ? extends C, ? extends V> rowSortedTable) {
        return new com.google.common.collect.Tables.UnmodifiableRowSortedMap(rowSortedTable);
    }

    public static <R, C, V> com.google.common.collect.Table<R, C, V> unmodifiableTable(com.google.common.collect.Table<? extends R, ? extends C, ? extends V> table) {
        return new com.google.common.collect.Tables.UnmodifiableTable(table);
    }
}
