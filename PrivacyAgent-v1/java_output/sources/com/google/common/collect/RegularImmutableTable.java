package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
abstract class RegularImmutableTable<R, C, V> extends com.google.common.collect.ImmutableTable<R, C, V> {

    /* renamed from: com.google.common.collect.RegularImmutableTable$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.util.Comparator<com.google.common.collect.Table.Cell<R, C, V>> {
        public final /* synthetic */ java.util.Comparator n;
        public final /* synthetic */ java.util.Comparator t;

        public AnonymousClass1(java.util.Comparator comparator, java.util.Comparator comparator2) {
            this.n = comparator;
            this.t = comparator2;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.google.common.collect.Table.Cell<R, C, V> cell, com.google.common.collect.Table.Cell<R, C, V> cell2) {
            java.util.Comparator comparator = this.n;
            int compare = comparator == null ? 0 : comparator.compare(cell.getRowKey(), cell2.getRowKey());
            if (compare != 0) {
                return compare;
            }
            java.util.Comparator comparator2 = this.t;
            if (comparator2 == null) {
                return 0;
            }
            return comparator2.compare(cell.getColumnKey(), cell2.getColumnKey());
        }
    }

    public final class CellSet extends com.google.common.collect.IndexedImmutableSet<com.google.common.collect.Table.Cell<R, C, V>> {
        private CellSet() {
        }

        public /* synthetic */ CellSet(com.google.common.collect.RegularImmutableTable regularImmutableTable, com.google.common.collect.RegularImmutableTable.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (!(obj instanceof com.google.common.collect.Table.Cell)) {
                return false;
            }
            com.google.common.collect.Table.Cell cell = (com.google.common.collect.Table.Cell) obj;
            java.lang.Object obj2 = com.google.common.collect.RegularImmutableTable.this.get(cell.getRowKey(), cell.getColumnKey());
            return obj2 != null && obj2.equals(cell.getValue());
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        public com.google.common.collect.Table.Cell<R, C, V> get(int i) {
            return com.google.common.collect.RegularImmutableTable.this.getCell(i);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return com.google.common.collect.RegularImmutableTable.this.size();
        }
    }

    public final class Values extends com.google.common.collect.ImmutableList<V> {
        private Values() {
        }

        public /* synthetic */ Values(com.google.common.collect.RegularImmutableTable regularImmutableTable, com.google.common.collect.RegularImmutableTable.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.List
        public V get(int i) {
            return (V) com.google.common.collect.RegularImmutableTable.this.getValue(i);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return com.google.common.collect.RegularImmutableTable.this.size();
        }
    }

    public static <R, C, V> com.google.common.collect.RegularImmutableTable<R, C, V> forCells(java.lang.Iterable<com.google.common.collect.Table.Cell<R, C, V>> iterable) {
        return forCellsInternal(iterable, null, null);
    }

    public static <R, C, V> com.google.common.collect.RegularImmutableTable<R, C, V> forCells(java.util.List<com.google.common.collect.Table.Cell<R, C, V>> list, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.util.Comparator<? super R> comparator, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.util.Comparator<? super C> comparator2) {
        com.google.common.base.Preconditions.checkNotNull(list);
        if (comparator != null || comparator2 != null) {
            java.util.Collections.sort(list, new com.google.common.collect.RegularImmutableTable.AnonymousClass1(comparator, comparator2));
        }
        return forCellsInternal(list, comparator, comparator2);
    }

    private static <R, C, V> com.google.common.collect.RegularImmutableTable<R, C, V> forCellsInternal(java.lang.Iterable<com.google.common.collect.Table.Cell<R, C, V>> iterable, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.util.Comparator<? super R> comparator, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.util.Comparator<? super C> comparator2) {
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        java.util.LinkedHashSet linkedHashSet2 = new java.util.LinkedHashSet();
        com.google.common.collect.ImmutableList copyOf = com.google.common.collect.ImmutableList.copyOf(iterable);
        for (com.google.common.collect.Table.Cell<R, C, V> cell : iterable) {
            linkedHashSet.add(cell.getRowKey());
            linkedHashSet2.add(cell.getColumnKey());
        }
        return forOrderedComponents(copyOf, comparator == null ? com.google.common.collect.ImmutableSet.copyOf((java.util.Collection) linkedHashSet) : com.google.common.collect.ImmutableSet.copyOf((java.util.Collection) com.google.common.collect.ImmutableList.sortedCopyOf(comparator, linkedHashSet)), comparator2 == null ? com.google.common.collect.ImmutableSet.copyOf((java.util.Collection) linkedHashSet2) : com.google.common.collect.ImmutableSet.copyOf((java.util.Collection) com.google.common.collect.ImmutableList.sortedCopyOf(comparator2, linkedHashSet2)));
    }

    public static <R, C, V> com.google.common.collect.RegularImmutableTable<R, C, V> forOrderedComponents(com.google.common.collect.ImmutableList<com.google.common.collect.Table.Cell<R, C, V>> immutableList, com.google.common.collect.ImmutableSet<R> immutableSet, com.google.common.collect.ImmutableSet<C> immutableSet2) {
        return ((long) immutableList.size()) > (((long) immutableSet.size()) * ((long) immutableSet2.size())) / 2 ? new com.google.common.collect.DenseImmutableTable(immutableList, immutableSet, immutableSet2) : new com.google.common.collect.SparseImmutableTable(immutableList, immutableSet, immutableSet2);
    }

    public final void checkNoDuplicate(R r, C c, V v, V v2) {
        com.google.common.base.Preconditions.checkArgument(v == null, "Duplicate key: (row=%s, column=%s), values: [%s, %s].", r, c, v2, v);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractTable
    public final com.google.common.collect.ImmutableSet<com.google.common.collect.Table.Cell<R, C, V>> createCellSet() {
        return isEmpty() ? com.google.common.collect.ImmutableSet.of() : new com.google.common.collect.RegularImmutableTable.CellSet(this, null);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractTable
    public final com.google.common.collect.ImmutableCollection<V> createValues() {
        return isEmpty() ? com.google.common.collect.ImmutableList.of() : new com.google.common.collect.RegularImmutableTable.Values(this, null);
    }

    public abstract com.google.common.collect.Table.Cell<R, C, V> getCell(int i);

    public abstract V getValue(int i);
}
