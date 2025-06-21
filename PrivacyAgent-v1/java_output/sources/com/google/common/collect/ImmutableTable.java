package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public abstract class ImmutableTable<R, C, V> extends com.google.common.collect.AbstractTable<R, C, V> implements java.io.Serializable {

    public static final class Builder<R, C, V> {
        public final java.util.List<com.google.common.collect.Table.Cell<R, C, V>> a = com.google.common.collect.Lists.newArrayList();

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        public java.util.Comparator<? super R> b;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        public java.util.Comparator<? super C> c;

        public com.google.common.collect.ImmutableTable<R, C, V> build() {
            int size = this.a.size();
            return size != 0 ? size != 1 ? com.google.common.collect.RegularImmutableTable.forCells(this.a, this.b, this.c) : new com.google.common.collect.SingletonImmutableTable((com.google.common.collect.Table.Cell) com.google.common.collect.Iterables.getOnlyElement(this.a)) : com.google.common.collect.ImmutableTable.of();
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableTable.Builder<R, C, V> orderColumnsBy(java.util.Comparator<? super C> comparator) {
            this.c = (java.util.Comparator) com.google.common.base.Preconditions.checkNotNull(comparator, "columnComparator");
            return this;
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableTable.Builder<R, C, V> orderRowsBy(java.util.Comparator<? super R> comparator) {
            this.b = (java.util.Comparator) com.google.common.base.Preconditions.checkNotNull(comparator, "rowComparator");
            return this;
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableTable.Builder<R, C, V> put(com.google.common.collect.Table.Cell<? extends R, ? extends C, ? extends V> cell) {
            if (cell instanceof com.google.common.collect.Tables.ImmutableCell) {
                com.google.common.base.Preconditions.checkNotNull(cell.getRowKey(), "row");
                com.google.common.base.Preconditions.checkNotNull(cell.getColumnKey(), com.sensorsdata.sf.ui.view.UIProperty.type_column);
                com.google.common.base.Preconditions.checkNotNull(cell.getValue(), "value");
                this.a.add(cell);
            } else {
                put(cell.getRowKey(), cell.getColumnKey(), cell.getValue());
            }
            return this;
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableTable.Builder<R, C, V> put(R r, C c, V v) {
            this.a.add(com.google.common.collect.ImmutableTable.cellOf(r, c, v));
            return this;
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableTable.Builder<R, C, V> putAll(com.google.common.collect.Table<? extends R, ? extends C, ? extends V> table) {
            java.util.Iterator<com.google.common.collect.Table.Cell<? extends R, ? extends C, ? extends V>> it = table.cellSet().iterator();
            while (it.hasNext()) {
                put(it.next());
            }
            return this;
        }
    }

    public static final class SerializedForm implements java.io.Serializable {
        private static final long serialVersionUID = 0;
        private final int[] cellColumnIndices;
        private final int[] cellRowIndices;
        private final java.lang.Object[] cellValues;
        private final java.lang.Object[] columnKeys;
        private final java.lang.Object[] rowKeys;

        private SerializedForm(java.lang.Object[] objArr, java.lang.Object[] objArr2, java.lang.Object[] objArr3, int[] iArr, int[] iArr2) {
            this.rowKeys = objArr;
            this.columnKeys = objArr2;
            this.cellValues = objArr3;
            this.cellRowIndices = iArr;
            this.cellColumnIndices = iArr2;
        }

        public static com.google.common.collect.ImmutableTable.SerializedForm create(com.google.common.collect.ImmutableTable<?, ?, ?> immutableTable, int[] iArr, int[] iArr2) {
            return new com.google.common.collect.ImmutableTable.SerializedForm(immutableTable.rowKeySet().toArray(), immutableTable.columnKeySet().toArray(), immutableTable.values().toArray(), iArr, iArr2);
        }

        public java.lang.Object readResolve() {
            java.lang.Object[] objArr = this.cellValues;
            if (objArr.length == 0) {
                return com.google.common.collect.ImmutableTable.of();
            }
            int i = 0;
            if (objArr.length == 1) {
                return com.google.common.collect.ImmutableTable.of(this.rowKeys[0], this.columnKeys[0], objArr[0]);
            }
            com.google.common.collect.ImmutableList.Builder builder = new com.google.common.collect.ImmutableList.Builder(objArr.length);
            while (true) {
                java.lang.Object[] objArr2 = this.cellValues;
                if (i >= objArr2.length) {
                    return com.google.common.collect.RegularImmutableTable.forOrderedComponents(builder.build(), com.google.common.collect.ImmutableSet.copyOf(this.rowKeys), com.google.common.collect.ImmutableSet.copyOf(this.columnKeys));
                }
                builder.add((com.google.common.collect.ImmutableList.Builder) com.google.common.collect.ImmutableTable.cellOf(this.rowKeys[this.cellRowIndices[i]], this.columnKeys[this.cellColumnIndices[i]], objArr2[i]));
                i++;
            }
        }
    }

    public static <R, C, V> com.google.common.collect.ImmutableTable.Builder<R, C, V> builder() {
        return new com.google.common.collect.ImmutableTable.Builder<>();
    }

    public static <R, C, V> com.google.common.collect.Table.Cell<R, C, V> cellOf(R r, C c, V v) {
        return com.google.common.collect.Tables.immutableCell(com.google.common.base.Preconditions.checkNotNull(r, "rowKey"), com.google.common.base.Preconditions.checkNotNull(c, "columnKey"), com.google.common.base.Preconditions.checkNotNull(v, "value"));
    }

    public static <R, C, V> com.google.common.collect.ImmutableTable<R, C, V> copyOf(com.google.common.collect.Table<? extends R, ? extends C, ? extends V> table) {
        return table instanceof com.google.common.collect.ImmutableTable ? (com.google.common.collect.ImmutableTable) table : copyOf(table.cellSet());
    }

    private static <R, C, V> com.google.common.collect.ImmutableTable<R, C, V> copyOf(java.lang.Iterable<? extends com.google.common.collect.Table.Cell<? extends R, ? extends C, ? extends V>> iterable) {
        com.google.common.collect.ImmutableTable.Builder builder = builder();
        java.util.Iterator<? extends com.google.common.collect.Table.Cell<? extends R, ? extends C, ? extends V>> it = iterable.iterator();
        while (it.hasNext()) {
            builder.put(it.next());
        }
        return builder.build();
    }

    public static <R, C, V> com.google.common.collect.ImmutableTable<R, C, V> of() {
        return (com.google.common.collect.ImmutableTable<R, C, V>) com.google.common.collect.SparseImmutableTable.EMPTY;
    }

    public static <R, C, V> com.google.common.collect.ImmutableTable<R, C, V> of(R r, C c, V v) {
        return new com.google.common.collect.SingletonImmutableTable(r, c, v);
    }

    @Override // com.google.common.collect.AbstractTable
    public final com.google.common.collect.UnmodifiableIterator<com.google.common.collect.Table.Cell<R, C, V>> cellIterator() {
        throw new java.lang.AssertionError("should never be called");
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public com.google.common.collect.ImmutableSet<com.google.common.collect.Table.Cell<R, C, V>> cellSet() {
        return (com.google.common.collect.ImmutableSet) super.cellSet();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @java.lang.Deprecated
    public final void clear() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Table
    public com.google.common.collect.ImmutableMap<R, V> column(C c) {
        com.google.common.base.Preconditions.checkNotNull(c, "columnKey");
        return (com.google.common.collect.ImmutableMap) com.google.common.base.MoreObjects.firstNonNull((com.google.common.collect.ImmutableMap) columnMap().get(c), com.google.common.collect.ImmutableMap.of());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Table
    public /* bridge */ /* synthetic */ java.util.Map column(java.lang.Object obj) {
        return column((com.google.common.collect.ImmutableTable<R, C, V>) obj);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public com.google.common.collect.ImmutableSet<C> columnKeySet() {
        return columnMap().keySet();
    }

    @Override // com.google.common.collect.Table
    public abstract com.google.common.collect.ImmutableMap<C, java.util.Map<R, V>> columnMap();

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2) {
        return get(obj, obj2) != null;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsColumn(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return super.containsColumn(obj);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsRow(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return super.containsRow(obj);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsValue(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return values().contains(obj);
    }

    @Override // com.google.common.collect.AbstractTable
    public abstract com.google.common.collect.ImmutableSet<com.google.common.collect.Table.Cell<R, C, V>> createCellSet();

    public abstract com.google.common.collect.ImmutableTable.SerializedForm createSerializedForm();

    @Override // com.google.common.collect.AbstractTable
    public abstract com.google.common.collect.ImmutableCollection<V> createValues();

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ java.lang.Object get(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2) {
        return super.get(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @java.lang.Deprecated
    public final V put(R r, C c, V v) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @java.lang.Deprecated
    public final void putAll(com.google.common.collect.Table<? extends R, ? extends C, ? extends V> table) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @java.lang.Deprecated
    public final V remove(java.lang.Object obj, java.lang.Object obj2) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Table
    public com.google.common.collect.ImmutableMap<C, V> row(R r) {
        com.google.common.base.Preconditions.checkNotNull(r, "rowKey");
        return (com.google.common.collect.ImmutableMap) com.google.common.base.MoreObjects.firstNonNull((com.google.common.collect.ImmutableMap) rowMap().get(r), com.google.common.collect.ImmutableMap.of());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Table
    public /* bridge */ /* synthetic */ java.util.Map row(java.lang.Object obj) {
        return row((com.google.common.collect.ImmutableTable<R, C, V>) obj);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public com.google.common.collect.ImmutableSet<R> rowKeySet() {
        return rowMap().keySet();
    }

    @Override // com.google.common.collect.Table
    public abstract com.google.common.collect.ImmutableMap<R, java.util.Map<C, V>> rowMap();

    @Override // com.google.common.collect.AbstractTable
    public /* bridge */ /* synthetic */ java.lang.String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public com.google.common.collect.ImmutableCollection<V> values() {
        return (com.google.common.collect.ImmutableCollection) super.values();
    }

    @Override // com.google.common.collect.AbstractTable
    public final java.util.Iterator<V> valuesIterator() {
        throw new java.lang.AssertionError("should never be called");
    }

    public final java.lang.Object writeReplace() {
        return createSerializedForm();
    }
}
