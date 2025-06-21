package com.google.common.collect;

@com.google.errorprone.annotations.Immutable(containerOf = {"R", "C", androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_INTERRUPTED})
@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
final class DenseImmutableTable<R, C, V> extends com.google.common.collect.RegularImmutableTable<R, C, V> {
    private final int[] cellColumnIndices;
    private final int[] cellRowIndices;
    private final int[] columnCounts;
    private final com.google.common.collect.ImmutableMap<C, java.lang.Integer> columnKeyToIndex;
    private final com.google.common.collect.ImmutableMap<C, com.google.common.collect.ImmutableMap<R, V>> columnMap;
    private final int[] rowCounts;
    private final com.google.common.collect.ImmutableMap<R, java.lang.Integer> rowKeyToIndex;
    private final com.google.common.collect.ImmutableMap<R, com.google.common.collect.ImmutableMap<C, V>> rowMap;
    private final V[][] values;

    public final class Column extends com.google.common.collect.DenseImmutableTable.ImmutableArrayMap<R, V> {
        private final int columnIndex;

        public Column(int i) {
            super(com.google.common.collect.DenseImmutableTable.this.columnCounts[i]);
            this.columnIndex = i;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public V getValue(int i) {
            return (V) com.google.common.collect.DenseImmutableTable.this.values[i][this.columnIndex];
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public com.google.common.collect.ImmutableMap<R, java.lang.Integer> keyToIndex() {
            return com.google.common.collect.DenseImmutableTable.this.rowKeyToIndex;
        }
    }

    public final class ColumnMap extends com.google.common.collect.DenseImmutableTable.ImmutableArrayMap<C, com.google.common.collect.ImmutableMap<R, V>> {
        private ColumnMap() {
            super(com.google.common.collect.DenseImmutableTable.this.columnCounts.length);
        }

        public /* synthetic */ ColumnMap(com.google.common.collect.DenseImmutableTable denseImmutableTable, com.google.common.collect.DenseImmutableTable.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public com.google.common.collect.ImmutableMap<R, V> getValue(int i) {
            return new com.google.common.collect.DenseImmutableTable.Column(i);
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public com.google.common.collect.ImmutableMap<C, java.lang.Integer> keyToIndex() {
            return com.google.common.collect.DenseImmutableTable.this.columnKeyToIndex;
        }
    }

    public static abstract class ImmutableArrayMap<K, V> extends com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap<K, V> {
        private final int size;

        /* renamed from: com.google.common.collect.DenseImmutableTable$ImmutableArrayMap$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.collect.AbstractIterator<java.util.Map.Entry<K, V>> {
            public int u = -1;
            public final int v;

            public AnonymousClass1() {
                this.v = com.google.common.collect.DenseImmutableTable.ImmutableArrayMap.this.keyToIndex().size();
            }

            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public java.util.Map.Entry<K, V> computeNext() {
                int i = this.u;
                while (true) {
                    this.u = i + 1;
                    int i2 = this.u;
                    if (i2 >= this.v) {
                        return endOfData();
                    }
                    java.lang.Object value = com.google.common.collect.DenseImmutableTable.ImmutableArrayMap.this.getValue(i2);
                    if (value != null) {
                        return com.google.common.collect.Maps.immutableEntry(com.google.common.collect.DenseImmutableTable.ImmutableArrayMap.this.getKey(this.u), value);
                    }
                    i = this.u;
                }
            }
        }

        public ImmutableArrayMap(int i) {
            this.size = i;
        }

        private boolean isFull() {
            return this.size == keyToIndex().size();
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.common.collect.ImmutableMap
        public com.google.common.collect.ImmutableSet<K> createKeySet() {
            return isFull() ? keyToIndex().keySet() : super.createKeySet();
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
        public com.google.common.collect.UnmodifiableIterator<java.util.Map.Entry<K, V>> entryIterator() {
            return new com.google.common.collect.DenseImmutableTable.ImmutableArrayMap.AnonymousClass1();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public V get(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            java.lang.Integer num = keyToIndex().get(obj);
            if (num == null) {
                return null;
            }
            return getValue(num.intValue());
        }

        public K getKey(int i) {
            return keyToIndex().keySet().asList().get(i);
        }

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public abstract V getValue(int i);

        public abstract com.google.common.collect.ImmutableMap<K, java.lang.Integer> keyToIndex();

        @Override // java.util.Map
        public int size() {
            return this.size;
        }
    }

    public final class Row extends com.google.common.collect.DenseImmutableTable.ImmutableArrayMap<C, V> {
        private final int rowIndex;

        public Row(int i) {
            super(com.google.common.collect.DenseImmutableTable.this.rowCounts[i]);
            this.rowIndex = i;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public V getValue(int i) {
            return (V) com.google.common.collect.DenseImmutableTable.this.values[this.rowIndex][i];
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public com.google.common.collect.ImmutableMap<C, java.lang.Integer> keyToIndex() {
            return com.google.common.collect.DenseImmutableTable.this.columnKeyToIndex;
        }
    }

    public final class RowMap extends com.google.common.collect.DenseImmutableTable.ImmutableArrayMap<R, com.google.common.collect.ImmutableMap<C, V>> {
        private RowMap() {
            super(com.google.common.collect.DenseImmutableTable.this.rowCounts.length);
        }

        public /* synthetic */ RowMap(com.google.common.collect.DenseImmutableTable denseImmutableTable, com.google.common.collect.DenseImmutableTable.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public com.google.common.collect.ImmutableMap<C, V> getValue(int i) {
            return new com.google.common.collect.DenseImmutableTable.Row(i);
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public com.google.common.collect.ImmutableMap<R, java.lang.Integer> keyToIndex() {
            return com.google.common.collect.DenseImmutableTable.this.rowKeyToIndex;
        }
    }

    public DenseImmutableTable(com.google.common.collect.ImmutableList<com.google.common.collect.Table.Cell<R, C, V>> immutableList, com.google.common.collect.ImmutableSet<R> immutableSet, com.google.common.collect.ImmutableSet<C> immutableSet2) {
        this.values = (V[][]) ((java.lang.Object[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) java.lang.Object.class, immutableSet.size(), immutableSet2.size()));
        com.google.common.collect.ImmutableMap<R, java.lang.Integer> u = com.google.common.collect.Maps.u(immutableSet);
        this.rowKeyToIndex = u;
        com.google.common.collect.ImmutableMap<C, java.lang.Integer> u2 = com.google.common.collect.Maps.u(immutableSet2);
        this.columnKeyToIndex = u2;
        this.rowCounts = new int[u.size()];
        this.columnCounts = new int[u2.size()];
        int[] iArr = new int[immutableList.size()];
        int[] iArr2 = new int[immutableList.size()];
        for (int i = 0; i < immutableList.size(); i++) {
            com.google.common.collect.Table.Cell<R, C, V> cell = immutableList.get(i);
            R rowKey = cell.getRowKey();
            C columnKey = cell.getColumnKey();
            int intValue = this.rowKeyToIndex.get(rowKey).intValue();
            int intValue2 = this.columnKeyToIndex.get(columnKey).intValue();
            checkNoDuplicate(rowKey, columnKey, this.values[intValue][intValue2], cell.getValue());
            this.values[intValue][intValue2] = cell.getValue();
            int[] iArr3 = this.rowCounts;
            iArr3[intValue] = iArr3[intValue] + 1;
            int[] iArr4 = this.columnCounts;
            iArr4[intValue2] = iArr4[intValue2] + 1;
            iArr[i] = intValue;
            iArr2[i] = intValue2;
        }
        this.cellRowIndices = iArr;
        this.cellColumnIndices = iArr2;
        this.rowMap = new com.google.common.collect.DenseImmutableTable.RowMap(this, null);
        this.columnMap = new com.google.common.collect.DenseImmutableTable.ColumnMap(this, null);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public com.google.common.collect.ImmutableMap<C, java.util.Map<R, V>> columnMap() {
        return com.google.common.collect.ImmutableMap.copyOf((java.util.Map) this.columnMap);
    }

    @Override // com.google.common.collect.ImmutableTable
    public com.google.common.collect.ImmutableTable.SerializedForm createSerializedForm() {
        return com.google.common.collect.ImmutableTable.SerializedForm.create(this, this.cellRowIndices, this.cellColumnIndices);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public V get(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2) {
        java.lang.Integer num = this.rowKeyToIndex.get(obj);
        java.lang.Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return this.values[num.intValue()][num2.intValue()];
    }

    @Override // com.google.common.collect.RegularImmutableTable
    public com.google.common.collect.Table.Cell<R, C, V> getCell(int i) {
        int i2 = this.cellRowIndices[i];
        int i3 = this.cellColumnIndices[i];
        return com.google.common.collect.ImmutableTable.cellOf(rowKeySet().asList().get(i2), columnKeySet().asList().get(i3), this.values[i2][i3]);
    }

    @Override // com.google.common.collect.RegularImmutableTable
    public V getValue(int i) {
        return this.values[this.cellRowIndices[i]][this.cellColumnIndices[i]];
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public com.google.common.collect.ImmutableMap<R, java.util.Map<C, V>> rowMap() {
        return com.google.common.collect.ImmutableMap.copyOf((java.util.Map) this.rowMap);
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return this.cellRowIndices.length;
    }
}
