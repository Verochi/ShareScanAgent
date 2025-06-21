package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(serializable = true)
/* loaded from: classes22.dex */
public class TreeBasedTable<R, C, V> extends com.google.common.collect.StandardRowSortedTable<R, C, V> {
    private static final long serialVersionUID = 0;
    private final java.util.Comparator<? super C> columnComparator;

    /* renamed from: com.google.common.collect.TreeBasedTable$1, reason: invalid class name */
    public class AnonymousClass1 implements com.google.common.base.Function<java.util.Map<C, V>, java.util.Iterator<C>> {
        public AnonymousClass1() {
        }

        @Override // com.google.common.base.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.util.Iterator<C> apply(java.util.Map<C, V> map) {
            return map.keySet().iterator();
        }
    }

    /* renamed from: com.google.common.collect.TreeBasedTable$2, reason: invalid class name */
    public class AnonymousClass2 extends com.google.common.collect.AbstractIterator<C> {

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public C u;
        public final /* synthetic */ java.util.Iterator v;
        public final /* synthetic */ java.util.Comparator w;

        public AnonymousClass2(java.util.Iterator it, java.util.Comparator comparator) {
            this.v = it;
            this.w = comparator;
        }

        @Override // com.google.common.collect.AbstractIterator
        public C computeNext() {
            while (this.v.hasNext()) {
                C c = (C) this.v.next();
                C c2 = this.u;
                if (!(c2 != null && this.w.compare(c, c2) == 0)) {
                    this.u = c;
                    return c;
                }
            }
            this.u = null;
            return endOfData();
        }
    }

    public static class Factory<C, V> implements com.google.common.base.Supplier<java.util.TreeMap<C, V>>, java.io.Serializable {
        private static final long serialVersionUID = 0;
        final java.util.Comparator<? super C> comparator;

        public Factory(java.util.Comparator<? super C> comparator) {
            this.comparator = comparator;
        }

        @Override // com.google.common.base.Supplier
        public java.util.TreeMap<C, V> get() {
            return new java.util.TreeMap<>(this.comparator);
        }
    }

    public class TreeRow extends com.google.common.collect.StandardTable<R, C, V>.Row implements java.util.SortedMap<C, V> {

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public final C v;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public final C w;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public transient java.util.SortedMap<C, V> x;

        public TreeRow(com.google.common.collect.TreeBasedTable treeBasedTable, R r) {
            this(r, null, null);
        }

        public TreeRow(R r, @org.checkerframework.checker.nullness.compatqual.NullableDecl C c, @org.checkerframework.checker.nullness.compatqual.NullableDecl C c2) {
            super(r);
            this.v = c;
            this.w = c2;
            com.google.common.base.Preconditions.checkArgument(c == null || c2 == null || h(c, c2) <= 0);
        }

        @Override // java.util.SortedMap
        public java.util.Comparator<? super C> comparator() {
            return com.google.common.collect.TreeBasedTable.this.columnComparator();
        }

        @Override // com.google.common.collect.StandardTable.Row, java.util.AbstractMap, java.util.Map
        public boolean containsKey(java.lang.Object obj) {
            return k(obj) && super.containsKey(obj);
        }

        @Override // com.google.common.collect.StandardTable.Row
        public void e() {
            if (l() == null || !this.x.isEmpty()) {
                return;
            }
            com.google.common.collect.TreeBasedTable.this.backingMap.remove(this.n);
            this.x = null;
            this.t = null;
        }

        @Override // java.util.SortedMap
        public C firstKey() {
            if (b() != null) {
                return b().firstKey();
            }
            throw new java.util.NoSuchElementException();
        }

        @Override // com.google.common.collect.StandardTable.Row
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public java.util.SortedMap<C, V> b() {
            return (java.util.SortedMap) super.b();
        }

        public int h(java.lang.Object obj, java.lang.Object obj2) {
            return comparator().compare(obj, obj2);
        }

        @Override // java.util.SortedMap
        public java.util.SortedMap<C, V> headMap(C c) {
            com.google.common.base.Preconditions.checkArgument(k(com.google.common.base.Preconditions.checkNotNull(c)));
            return new com.google.common.collect.TreeBasedTable.TreeRow(this.n, this.v, c);
        }

        @Override // com.google.common.collect.StandardTable.Row
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public java.util.SortedMap<C, V> d() {
            java.util.SortedMap<C, V> l = l();
            if (l == null) {
                return null;
            }
            C c = this.v;
            if (c != null) {
                l = l.tailMap(c);
            }
            C c2 = this.w;
            return c2 != null ? l.headMap(c2) : l;
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public java.util.SortedSet<C> keySet() {
            return new com.google.common.collect.Maps.SortedKeySet(this);
        }

        public boolean k(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            C c;
            C c2;
            return obj != null && ((c = this.v) == null || h(c, obj) <= 0) && ((c2 = this.w) == null || h(c2, obj) > 0);
        }

        public java.util.SortedMap<C, V> l() {
            java.util.SortedMap<C, V> sortedMap = this.x;
            if (sortedMap == null || (sortedMap.isEmpty() && com.google.common.collect.TreeBasedTable.this.backingMap.containsKey(this.n))) {
                this.x = (java.util.SortedMap) com.google.common.collect.TreeBasedTable.this.backingMap.get(this.n);
            }
            return this.x;
        }

        @Override // java.util.SortedMap
        public C lastKey() {
            if (b() != null) {
                return b().lastKey();
            }
            throw new java.util.NoSuchElementException();
        }

        @Override // com.google.common.collect.StandardTable.Row, java.util.AbstractMap, java.util.Map
        public V put(C c, V v) {
            com.google.common.base.Preconditions.checkArgument(k(com.google.common.base.Preconditions.checkNotNull(c)));
            return (V) super.put(c, v);
        }

        @Override // java.util.SortedMap
        public java.util.SortedMap<C, V> subMap(C c, C c2) {
            com.google.common.base.Preconditions.checkArgument(k(com.google.common.base.Preconditions.checkNotNull(c)) && k(com.google.common.base.Preconditions.checkNotNull(c2)));
            return new com.google.common.collect.TreeBasedTable.TreeRow(this.n, c, c2);
        }

        @Override // java.util.SortedMap
        public java.util.SortedMap<C, V> tailMap(C c) {
            com.google.common.base.Preconditions.checkArgument(k(com.google.common.base.Preconditions.checkNotNull(c)));
            return new com.google.common.collect.TreeBasedTable.TreeRow(this.n, c, this.w);
        }
    }

    public TreeBasedTable(java.util.Comparator<? super R> comparator, java.util.Comparator<? super C> comparator2) {
        super(new java.util.TreeMap(comparator), new com.google.common.collect.TreeBasedTable.Factory(comparator2));
        this.columnComparator = comparator2;
    }

    public static <R extends java.lang.Comparable, C extends java.lang.Comparable, V> com.google.common.collect.TreeBasedTable<R, C, V> create() {
        return new com.google.common.collect.TreeBasedTable<>(com.google.common.collect.Ordering.natural(), com.google.common.collect.Ordering.natural());
    }

    public static <R, C, V> com.google.common.collect.TreeBasedTable<R, C, V> create(com.google.common.collect.TreeBasedTable<R, C, ? extends V> treeBasedTable) {
        com.google.common.collect.TreeBasedTable<R, C, V> treeBasedTable2 = new com.google.common.collect.TreeBasedTable<>(treeBasedTable.rowComparator(), treeBasedTable.columnComparator());
        treeBasedTable2.putAll(treeBasedTable);
        return treeBasedTable2;
    }

    public static <R, C, V> com.google.common.collect.TreeBasedTable<R, C, V> create(java.util.Comparator<? super R> comparator, java.util.Comparator<? super C> comparator2) {
        com.google.common.base.Preconditions.checkNotNull(comparator);
        com.google.common.base.Preconditions.checkNotNull(comparator2);
        return new com.google.common.collect.TreeBasedTable<>(comparator, comparator2);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ java.util.Set cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ java.util.Map column(java.lang.Object obj) {
        return super.column(obj);
    }

    @java.lang.Deprecated
    public java.util.Comparator<? super C> columnComparator() {
        return this.columnComparator;
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ java.util.Set columnKeySet() {
        return super.columnKeySet();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ java.util.Map columnMap() {
        return super.columnMap();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2) {
        return super.contains(obj, obj2);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsColumn(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return super.containsColumn(obj);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsRow(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return super.containsRow(obj);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsValue(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.StandardTable
    public java.util.Iterator<C> createColumnKeyIterator() {
        java.util.Comparator<? super C> columnComparator = columnComparator();
        return new com.google.common.collect.TreeBasedTable.AnonymousClass2(com.google.common.collect.Iterators.mergeSorted(com.google.common.collect.Iterables.transform(this.backingMap.values(), new com.google.common.collect.TreeBasedTable.AnonymousClass1()), columnComparator), columnComparator);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ java.lang.Object get(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2) {
        return super.get(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ java.lang.Object put(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
        return super.put(obj, obj2, obj3);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ void putAll(com.google.common.collect.Table table) {
        super.putAll(table);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ java.lang.Object remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2) {
        return super.remove(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ java.util.Map row(java.lang.Object obj) {
        return row((com.google.common.collect.TreeBasedTable<R, C, V>) obj);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public java.util.SortedMap<C, V> row(R r) {
        return new com.google.common.collect.TreeBasedTable.TreeRow(this, r);
    }

    @java.lang.Deprecated
    public java.util.Comparator<? super R> rowComparator() {
        return rowKeySet().comparator();
    }

    @Override // com.google.common.collect.StandardRowSortedTable, com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public java.util.SortedSet<R> rowKeySet() {
        return super.rowKeySet();
    }

    @Override // com.google.common.collect.StandardRowSortedTable, com.google.common.collect.StandardTable, com.google.common.collect.Table
    public java.util.SortedMap<R, java.util.Map<C, V>> rowMap() {
        return super.rowMap();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.AbstractTable
    public /* bridge */ /* synthetic */ java.lang.String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ java.util.Collection values() {
        return super.values();
    }
}
