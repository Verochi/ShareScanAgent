package com.google.common.collect;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public final class ArrayTable<R, C, V> extends com.google.common.collect.AbstractTable<R, C, V> implements java.io.Serializable {
    private static final long serialVersionUID = 0;
    private final V[][] array;
    private final com.google.common.collect.ImmutableMap<C, java.lang.Integer> columnKeyToIndex;
    private final com.google.common.collect.ImmutableList<C> columnList;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    private transient com.google.common.collect.ArrayTable<R, C, V>.ColumnMap columnMap;
    private final com.google.common.collect.ImmutableMap<R, java.lang.Integer> rowKeyToIndex;
    private final com.google.common.collect.ImmutableList<R> rowList;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    private transient com.google.common.collect.ArrayTable<R, C, V>.RowMap rowMap;

    /* renamed from: com.google.common.collect.ArrayTable$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.common.collect.AbstractIndexedListIterator<com.google.common.collect.Table.Cell<R, C, V>> {
        public AnonymousClass1(int i) {
            super(i);
        }

        @Override // com.google.common.collect.AbstractIndexedListIterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.common.collect.Table.Cell<R, C, V> a(int i) {
            return com.google.common.collect.ArrayTable.this.getCell(i);
        }
    }

    /* renamed from: com.google.common.collect.ArrayTable$2, reason: invalid class name */
    public class AnonymousClass2 extends com.google.common.collect.Tables.AbstractCell<R, C, V> {
        public final int n;
        public final int t;
        public final /* synthetic */ int u;

        public AnonymousClass2(int i) {
            this.u = i;
            this.n = i / com.google.common.collect.ArrayTable.this.columnList.size();
            this.t = i % com.google.common.collect.ArrayTable.this.columnList.size();
        }

        @Override // com.google.common.collect.Table.Cell
        public C getColumnKey() {
            return (C) com.google.common.collect.ArrayTable.this.columnList.get(this.t);
        }

        @Override // com.google.common.collect.Table.Cell
        public R getRowKey() {
            return (R) com.google.common.collect.ArrayTable.this.rowList.get(this.n);
        }

        @Override // com.google.common.collect.Table.Cell
        public V getValue() {
            return (V) com.google.common.collect.ArrayTable.this.at(this.n, this.t);
        }
    }

    /* renamed from: com.google.common.collect.ArrayTable$3, reason: invalid class name */
    public class AnonymousClass3 extends com.google.common.collect.AbstractIndexedListIterator<V> {
        public AnonymousClass3(int i) {
            super(i);
        }

        @Override // com.google.common.collect.AbstractIndexedListIterator
        public V a(int i) {
            return (V) com.google.common.collect.ArrayTable.this.getValue(i);
        }
    }

    public static abstract class ArrayMap<K, V> extends com.google.common.collect.Maps.IteratorBasedAbstractMap<K, V> {
        public final com.google.common.collect.ImmutableMap<K, java.lang.Integer> n;

        /* renamed from: com.google.common.collect.ArrayTable$ArrayMap$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.collect.AbstractMapEntry<K, V> {
            public final /* synthetic */ int n;

            public AnonymousClass1(int i) {
                this.n = i;
            }

            @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
            public K getKey() {
                return (K) com.google.common.collect.ArrayTable.ArrayMap.this.d(this.n);
            }

            @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
            public V getValue() {
                return (V) com.google.common.collect.ArrayTable.ArrayMap.this.f(this.n);
            }

            @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
            public V setValue(V v) {
                return (V) com.google.common.collect.ArrayTable.ArrayMap.this.g(this.n, v);
            }
        }

        /* renamed from: com.google.common.collect.ArrayTable$ArrayMap$2, reason: invalid class name */
        public class AnonymousClass2 extends com.google.common.collect.AbstractIndexedListIterator<java.util.Map.Entry<K, V>> {
            public AnonymousClass2(int i) {
                super(i);
            }

            @Override // com.google.common.collect.AbstractIndexedListIterator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public java.util.Map.Entry<K, V> a(int i) {
                return com.google.common.collect.ArrayTable.ArrayMap.this.b(i);
            }
        }

        public ArrayMap(com.google.common.collect.ImmutableMap<K, java.lang.Integer> immutableMap) {
            this.n = immutableMap;
        }

        public /* synthetic */ ArrayMap(com.google.common.collect.ImmutableMap immutableMap, com.google.common.collect.ArrayTable.AnonymousClass1 anonymousClass1) {
            this(immutableMap);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public java.util.Iterator<java.util.Map.Entry<K, V>> a() {
            return new com.google.common.collect.ArrayTable.ArrayMap.AnonymousClass2(size());
        }

        public java.util.Map.Entry<K, V> b(int i) {
            com.google.common.base.Preconditions.checkElementIndex(i, size());
            return new com.google.common.collect.ArrayTable.ArrayMap.AnonymousClass1(i);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return this.n.containsKey(obj);
        }

        public K d(int i) {
            return this.n.keySet().asList().get(i);
        }

        public abstract java.lang.String e();

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public abstract V f(int i);

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public abstract V g(int i, V v);

        @Override // java.util.AbstractMap, java.util.Map
        public V get(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            java.lang.Integer num = this.n.get(obj);
            if (num == null) {
                return null;
            }
            return f(num.intValue());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.n.isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public java.util.Set<K> keySet() {
            return this.n.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K k, V v) {
            java.lang.Integer num = this.n.get(k);
            if (num != null) {
                return g(num.intValue(), v);
            }
            throw new java.lang.IllegalArgumentException(e() + " " + k + " not in " + this.n.keySet());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(java.lang.Object obj) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.n.size();
        }
    }

    public class Column extends com.google.common.collect.ArrayTable.ArrayMap<R, V> {
        public final int t;

        public Column(int i) {
            super(com.google.common.collect.ArrayTable.this.rowKeyToIndex, null);
            this.t = i;
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        public java.lang.String e() {
            return "Row";
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        public V f(int i) {
            return (V) com.google.common.collect.ArrayTable.this.at(i, this.t);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        public V g(int i, V v) {
            return (V) com.google.common.collect.ArrayTable.this.set(i, this.t, v);
        }
    }

    public class ColumnMap extends com.google.common.collect.ArrayTable.ArrayMap<C, java.util.Map<R, V>> {
        public ColumnMap() {
            super(com.google.common.collect.ArrayTable.this.columnKeyToIndex, null);
        }

        public /* synthetic */ ColumnMap(com.google.common.collect.ArrayTable arrayTable, com.google.common.collect.ArrayTable.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        public java.lang.String e() {
            return "Column";
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public java.util.Map<R, V> f(int i) {
            return new com.google.common.collect.ArrayTable.Column(i);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap, java.util.AbstractMap, java.util.Map
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public java.util.Map<R, V> put(C c, java.util.Map<R, V> map) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public java.util.Map<R, V> g(int i, java.util.Map<R, V> map) {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    public class Row extends com.google.common.collect.ArrayTable.ArrayMap<C, V> {
        public final int t;

        public Row(int i) {
            super(com.google.common.collect.ArrayTable.this.columnKeyToIndex, null);
            this.t = i;
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        public java.lang.String e() {
            return "Column";
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        public V f(int i) {
            return (V) com.google.common.collect.ArrayTable.this.at(this.t, i);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        public V g(int i, V v) {
            return (V) com.google.common.collect.ArrayTable.this.set(this.t, i, v);
        }
    }

    public class RowMap extends com.google.common.collect.ArrayTable.ArrayMap<R, java.util.Map<C, V>> {
        public RowMap() {
            super(com.google.common.collect.ArrayTable.this.rowKeyToIndex, null);
        }

        public /* synthetic */ RowMap(com.google.common.collect.ArrayTable arrayTable, com.google.common.collect.ArrayTable.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        public java.lang.String e() {
            return "Row";
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public java.util.Map<C, V> f(int i) {
            return new com.google.common.collect.ArrayTable.Row(i);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap, java.util.AbstractMap, java.util.Map
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public java.util.Map<C, V> put(R r, java.util.Map<C, V> map) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public java.util.Map<C, V> g(int i, java.util.Map<C, V> map) {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    private ArrayTable(com.google.common.collect.ArrayTable<R, C, V> arrayTable) {
        com.google.common.collect.ImmutableList<R> immutableList = arrayTable.rowList;
        this.rowList = immutableList;
        com.google.common.collect.ImmutableList<C> immutableList2 = arrayTable.columnList;
        this.columnList = immutableList2;
        this.rowKeyToIndex = arrayTable.rowKeyToIndex;
        this.columnKeyToIndex = arrayTable.columnKeyToIndex;
        V[][] vArr = (V[][]) ((java.lang.Object[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) java.lang.Object.class, immutableList.size(), immutableList2.size()));
        this.array = vArr;
        for (int i = 0; i < this.rowList.size(); i++) {
            V[] vArr2 = arrayTable.array[i];
            java.lang.System.arraycopy(vArr2, 0, vArr[i], 0, vArr2.length);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ArrayTable(com.google.common.collect.Table<R, C, V> table) {
        this(table.rowKeySet(), table.columnKeySet());
        putAll(table);
    }

    private ArrayTable(java.lang.Iterable<? extends R> iterable, java.lang.Iterable<? extends C> iterable2) {
        com.google.common.collect.ImmutableList<R> copyOf = com.google.common.collect.ImmutableList.copyOf(iterable);
        this.rowList = copyOf;
        com.google.common.collect.ImmutableList<C> copyOf2 = com.google.common.collect.ImmutableList.copyOf(iterable2);
        this.columnList = copyOf2;
        com.google.common.base.Preconditions.checkArgument(copyOf.isEmpty() == copyOf2.isEmpty());
        this.rowKeyToIndex = com.google.common.collect.Maps.u(copyOf);
        this.columnKeyToIndex = com.google.common.collect.Maps.u(copyOf2);
        this.array = (V[][]) ((java.lang.Object[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) java.lang.Object.class, copyOf.size(), copyOf2.size()));
        eraseAll();
    }

    public static <R, C, V> com.google.common.collect.ArrayTable<R, C, V> create(com.google.common.collect.Table<R, C, V> table) {
        return table instanceof com.google.common.collect.ArrayTable ? new com.google.common.collect.ArrayTable<>((com.google.common.collect.ArrayTable) table) : new com.google.common.collect.ArrayTable<>(table);
    }

    public static <R, C, V> com.google.common.collect.ArrayTable<R, C, V> create(java.lang.Iterable<? extends R> iterable, java.lang.Iterable<? extends C> iterable2) {
        return new com.google.common.collect.ArrayTable<>(iterable, iterable2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.google.common.collect.Table.Cell<R, C, V> getCell(int i) {
        return new com.google.common.collect.ArrayTable.AnonymousClass2(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V getValue(int i) {
        return at(i / this.columnList.size(), i % this.columnList.size());
    }

    public V at(int i, int i2) {
        com.google.common.base.Preconditions.checkElementIndex(i, this.rowList.size());
        com.google.common.base.Preconditions.checkElementIndex(i2, this.columnList.size());
        return this.array[i][i2];
    }

    @Override // com.google.common.collect.AbstractTable
    public java.util.Iterator<com.google.common.collect.Table.Cell<R, C, V>> cellIterator() {
        return new com.google.common.collect.ArrayTable.AnonymousClass1(size());
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public java.util.Set<com.google.common.collect.Table.Cell<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @java.lang.Deprecated
    public void clear() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Table
    public java.util.Map<R, V> column(C c) {
        com.google.common.base.Preconditions.checkNotNull(c);
        java.lang.Integer num = this.columnKeyToIndex.get(c);
        return num == null ? com.google.common.collect.ImmutableMap.of() : new com.google.common.collect.ArrayTable.Column(num.intValue());
    }

    public com.google.common.collect.ImmutableList<C> columnKeyList() {
        return this.columnList;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public com.google.common.collect.ImmutableSet<C> columnKeySet() {
        return this.columnKeyToIndex.keySet();
    }

    @Override // com.google.common.collect.Table
    public java.util.Map<C, java.util.Map<R, V>> columnMap() {
        com.google.common.collect.ArrayTable<R, C, V>.ColumnMap columnMap = this.columnMap;
        if (columnMap != null) {
            return columnMap;
        }
        com.google.common.collect.ArrayTable<R, C, V>.ColumnMap columnMap2 = new com.google.common.collect.ArrayTable.ColumnMap(this, null);
        this.columnMap = columnMap2;
        return columnMap2;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2) {
        return containsRow(obj) && containsColumn(obj2);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsColumn(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return this.columnKeyToIndex.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsRow(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return this.rowKeyToIndex.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsValue(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        for (V[] vArr : this.array) {
            for (V v : vArr) {
                if (com.google.common.base.Objects.equal(obj, v)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return super.equals(obj);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public V erase(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2) {
        java.lang.Integer num = this.rowKeyToIndex.get(obj);
        java.lang.Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return set(num.intValue(), num2.intValue(), null);
    }

    public void eraseAll() {
        for (V[] vArr : this.array) {
            java.util.Arrays.fill(vArr, (java.lang.Object) null);
        }
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public V get(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2) {
        java.lang.Integer num = this.rowKeyToIndex.get(obj);
        java.lang.Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return at(num.intValue(), num2.intValue());
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean isEmpty() {
        return this.rowList.isEmpty() || this.columnList.isEmpty();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public V put(R r, C c, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
        com.google.common.base.Preconditions.checkNotNull(r);
        com.google.common.base.Preconditions.checkNotNull(c);
        java.lang.Integer num = this.rowKeyToIndex.get(r);
        com.google.common.base.Preconditions.checkArgument(num != null, "Row %s not in %s", r, this.rowList);
        java.lang.Integer num2 = this.columnKeyToIndex.get(c);
        com.google.common.base.Preconditions.checkArgument(num2 != null, "Column %s not in %s", c, this.columnList);
        return set(num.intValue(), num2.intValue(), v);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public void putAll(com.google.common.collect.Table<? extends R, ? extends C, ? extends V> table) {
        super.putAll(table);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @java.lang.Deprecated
    public V remove(java.lang.Object obj, java.lang.Object obj2) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Table
    public java.util.Map<C, V> row(R r) {
        com.google.common.base.Preconditions.checkNotNull(r);
        java.lang.Integer num = this.rowKeyToIndex.get(r);
        return num == null ? com.google.common.collect.ImmutableMap.of() : new com.google.common.collect.ArrayTable.Row(num.intValue());
    }

    public com.google.common.collect.ImmutableList<R> rowKeyList() {
        return this.rowList;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public com.google.common.collect.ImmutableSet<R> rowKeySet() {
        return this.rowKeyToIndex.keySet();
    }

    @Override // com.google.common.collect.Table
    public java.util.Map<R, java.util.Map<C, V>> rowMap() {
        com.google.common.collect.ArrayTable<R, C, V>.RowMap rowMap = this.rowMap;
        if (rowMap != null) {
            return rowMap;
        }
        com.google.common.collect.ArrayTable<R, C, V>.RowMap rowMap2 = new com.google.common.collect.ArrayTable.RowMap(this, null);
        this.rowMap = rowMap2;
        return rowMap2;
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public V set(int i, int i2, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
        com.google.common.base.Preconditions.checkElementIndex(i, this.rowList.size());
        com.google.common.base.Preconditions.checkElementIndex(i2, this.columnList.size());
        V[] vArr = this.array[i];
        V v2 = vArr[i2];
        vArr[i2] = v;
        return v2;
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return this.rowList.size() * this.columnList.size();
    }

    @com.google.common.annotations.GwtIncompatible
    public V[][] toArray(java.lang.Class<V> cls) {
        V[][] vArr = (V[][]) ((java.lang.Object[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) cls, this.rowList.size(), this.columnList.size()));
        for (int i = 0; i < this.rowList.size(); i++) {
            V[] vArr2 = this.array[i];
            java.lang.System.arraycopy(vArr2, 0, vArr[i], 0, vArr2.length);
        }
        return vArr;
    }

    @Override // com.google.common.collect.AbstractTable
    public /* bridge */ /* synthetic */ java.lang.String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public java.util.Collection<V> values() {
        return super.values();
    }

    @Override // com.google.common.collect.AbstractTable
    public java.util.Iterator<V> valuesIterator() {
        return new com.google.common.collect.ArrayTable.AnonymousClass3(size());
    }
}
