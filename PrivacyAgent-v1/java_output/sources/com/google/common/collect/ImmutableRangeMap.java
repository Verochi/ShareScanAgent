package com.google.common.collect;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public class ImmutableRangeMap<K extends java.lang.Comparable<?>, V> implements com.google.common.collect.RangeMap<K, V>, java.io.Serializable {
    private static final com.google.common.collect.ImmutableRangeMap<java.lang.Comparable<?>, java.lang.Object> EMPTY = new com.google.common.collect.ImmutableRangeMap<>(com.google.common.collect.ImmutableList.of(), com.google.common.collect.ImmutableList.of());
    private static final long serialVersionUID = 0;
    private final transient com.google.common.collect.ImmutableList<com.google.common.collect.Range<K>> ranges;
    private final transient com.google.common.collect.ImmutableList<V> values;

    /* renamed from: com.google.common.collect.ImmutableRangeMap$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.common.collect.ImmutableList<com.google.common.collect.Range<K>> {
        final /* synthetic */ int val$len;
        final /* synthetic */ int val$off;
        final /* synthetic */ com.google.common.collect.Range val$range;

        public AnonymousClass1(int i, int i2, com.google.common.collect.Range range) {
            this.val$len = i;
            this.val$off = i2;
            this.val$range = range;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        public com.google.common.collect.Range<K> get(int i) {
            com.google.common.base.Preconditions.checkElementIndex(i, this.val$len);
            return (i == 0 || i == this.val$len + (-1)) ? ((com.google.common.collect.Range) com.google.common.collect.ImmutableRangeMap.this.ranges.get(i + this.val$off)).intersection(this.val$range) : (com.google.common.collect.Range) com.google.common.collect.ImmutableRangeMap.this.ranges.get(i + this.val$off);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.val$len;
        }
    }

    /* renamed from: com.google.common.collect.ImmutableRangeMap$2, reason: invalid class name */
    public class AnonymousClass2 extends com.google.common.collect.ImmutableRangeMap<K, V> {
        final /* synthetic */ com.google.common.collect.ImmutableRangeMap val$outer;
        final /* synthetic */ com.google.common.collect.Range val$range;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(com.google.common.collect.ImmutableList immutableList, com.google.common.collect.ImmutableList immutableList2, com.google.common.collect.Range range, com.google.common.collect.ImmutableRangeMap immutableRangeMap) {
            super(immutableList, immutableList2);
            this.val$range = range;
            this.val$outer = immutableRangeMap;
        }

        @Override // com.google.common.collect.ImmutableRangeMap, com.google.common.collect.RangeMap
        public /* bridge */ /* synthetic */ java.util.Map asDescendingMapOfRanges() {
            return super.asDescendingMapOfRanges();
        }

        @Override // com.google.common.collect.ImmutableRangeMap, com.google.common.collect.RangeMap
        public /* bridge */ /* synthetic */ java.util.Map asMapOfRanges() {
            return super.asMapOfRanges();
        }

        @Override // com.google.common.collect.ImmutableRangeMap, com.google.common.collect.RangeMap
        public com.google.common.collect.ImmutableRangeMap<K, V> subRangeMap(com.google.common.collect.Range<K> range) {
            return this.val$range.isConnected(range) ? this.val$outer.subRangeMap((com.google.common.collect.Range) range.intersection(this.val$range)) : com.google.common.collect.ImmutableRangeMap.of();
        }
    }

    public static final class Builder<K extends java.lang.Comparable<?>, V> {
        public final java.util.List<java.util.Map.Entry<com.google.common.collect.Range<K>, V>> a = com.google.common.collect.Lists.newArrayList();

        public com.google.common.collect.ImmutableRangeMap<K, V> build() {
            java.util.Collections.sort(this.a, com.google.common.collect.Range.rangeLexOrdering().onKeys());
            com.google.common.collect.ImmutableList.Builder builder = new com.google.common.collect.ImmutableList.Builder(this.a.size());
            com.google.common.collect.ImmutableList.Builder builder2 = new com.google.common.collect.ImmutableList.Builder(this.a.size());
            for (int i = 0; i < this.a.size(); i++) {
                com.google.common.collect.Range<K> key = this.a.get(i).getKey();
                if (i > 0) {
                    com.google.common.collect.Range<K> key2 = this.a.get(i - 1).getKey();
                    if (key.isConnected(key2) && !key.intersection(key2).isEmpty()) {
                        throw new java.lang.IllegalArgumentException("Overlapping ranges: range " + key2 + " overlaps with entry " + key);
                    }
                }
                builder.add((com.google.common.collect.ImmutableList.Builder) key);
                builder2.add((com.google.common.collect.ImmutableList.Builder) this.a.get(i).getValue());
            }
            return new com.google.common.collect.ImmutableRangeMap<>(builder.build(), builder2.build());
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableRangeMap.Builder<K, V> put(com.google.common.collect.Range<K> range, V v) {
            com.google.common.base.Preconditions.checkNotNull(range);
            com.google.common.base.Preconditions.checkNotNull(v);
            com.google.common.base.Preconditions.checkArgument(!range.isEmpty(), "Range must not be empty, but was %s", range);
            this.a.add(com.google.common.collect.Maps.immutableEntry(range, v));
            return this;
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableRangeMap.Builder<K, V> putAll(com.google.common.collect.RangeMap<K, ? extends V> rangeMap) {
            for (java.util.Map.Entry<com.google.common.collect.Range<K>, ? extends V> entry : rangeMap.asMapOfRanges().entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
            return this;
        }
    }

    public static class SerializedForm<K extends java.lang.Comparable<?>, V> implements java.io.Serializable {
        private static final long serialVersionUID = 0;
        private final com.google.common.collect.ImmutableMap<com.google.common.collect.Range<K>, V> mapOfRanges;

        public SerializedForm(com.google.common.collect.ImmutableMap<com.google.common.collect.Range<K>, V> immutableMap) {
            this.mapOfRanges = immutableMap;
        }

        public java.lang.Object createRangeMap() {
            com.google.common.collect.ImmutableRangeMap.Builder builder = new com.google.common.collect.ImmutableRangeMap.Builder();
            com.google.common.collect.UnmodifiableIterator<java.util.Map.Entry<com.google.common.collect.Range<K>, V>> it = this.mapOfRanges.entrySet().iterator();
            while (it.hasNext()) {
                java.util.Map.Entry<com.google.common.collect.Range<K>, V> next = it.next();
                builder.put(next.getKey(), next.getValue());
            }
            return builder.build();
        }

        public java.lang.Object readResolve() {
            return this.mapOfRanges.isEmpty() ? com.google.common.collect.ImmutableRangeMap.of() : createRangeMap();
        }
    }

    public ImmutableRangeMap(com.google.common.collect.ImmutableList<com.google.common.collect.Range<K>> immutableList, com.google.common.collect.ImmutableList<V> immutableList2) {
        this.ranges = immutableList;
        this.values = immutableList2;
    }

    public static <K extends java.lang.Comparable<?>, V> com.google.common.collect.ImmutableRangeMap.Builder<K, V> builder() {
        return new com.google.common.collect.ImmutableRangeMap.Builder<>();
    }

    public static <K extends java.lang.Comparable<?>, V> com.google.common.collect.ImmutableRangeMap<K, V> copyOf(com.google.common.collect.RangeMap<K, ? extends V> rangeMap) {
        if (rangeMap instanceof com.google.common.collect.ImmutableRangeMap) {
            return (com.google.common.collect.ImmutableRangeMap) rangeMap;
        }
        java.util.Map<com.google.common.collect.Range<K>, ? extends V> asMapOfRanges = rangeMap.asMapOfRanges();
        com.google.common.collect.ImmutableList.Builder builder = new com.google.common.collect.ImmutableList.Builder(asMapOfRanges.size());
        com.google.common.collect.ImmutableList.Builder builder2 = new com.google.common.collect.ImmutableList.Builder(asMapOfRanges.size());
        for (java.util.Map.Entry<com.google.common.collect.Range<K>, ? extends V> entry : asMapOfRanges.entrySet()) {
            builder.add((com.google.common.collect.ImmutableList.Builder) entry.getKey());
            builder2.add((com.google.common.collect.ImmutableList.Builder) entry.getValue());
        }
        return new com.google.common.collect.ImmutableRangeMap<>(builder.build(), builder2.build());
    }

    public static <K extends java.lang.Comparable<?>, V> com.google.common.collect.ImmutableRangeMap<K, V> of() {
        return (com.google.common.collect.ImmutableRangeMap<K, V>) EMPTY;
    }

    public static <K extends java.lang.Comparable<?>, V> com.google.common.collect.ImmutableRangeMap<K, V> of(com.google.common.collect.Range<K> range, V v) {
        return new com.google.common.collect.ImmutableRangeMap<>(com.google.common.collect.ImmutableList.of(range), com.google.common.collect.ImmutableList.of(v));
    }

    @Override // com.google.common.collect.RangeMap
    public com.google.common.collect.ImmutableMap<com.google.common.collect.Range<K>, V> asDescendingMapOfRanges() {
        return this.ranges.isEmpty() ? com.google.common.collect.ImmutableMap.of() : new com.google.common.collect.ImmutableSortedMap(new com.google.common.collect.RegularImmutableSortedSet(this.ranges.reverse(), com.google.common.collect.Range.rangeLexOrdering().reverse()), this.values.reverse());
    }

    @Override // com.google.common.collect.RangeMap
    public com.google.common.collect.ImmutableMap<com.google.common.collect.Range<K>, V> asMapOfRanges() {
        return this.ranges.isEmpty() ? com.google.common.collect.ImmutableMap.of() : new com.google.common.collect.ImmutableSortedMap(new com.google.common.collect.RegularImmutableSortedSet(this.ranges, com.google.common.collect.Range.rangeLexOrdering()), this.values);
    }

    @Override // com.google.common.collect.RangeMap
    @java.lang.Deprecated
    public void clear() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeMap
    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj instanceof com.google.common.collect.RangeMap) {
            return asMapOfRanges().equals(((com.google.common.collect.RangeMap) obj).asMapOfRanges());
        }
        return false;
    }

    @Override // com.google.common.collect.RangeMap
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public V get(K k) {
        int a = com.google.common.collect.SortedLists.a(this.ranges, com.google.common.collect.Range.lowerBoundFn(), com.google.common.collect.Cut.belowValue(k), com.google.common.collect.SortedLists.KeyPresentBehavior.ANY_PRESENT, com.google.common.collect.SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (a != -1 && this.ranges.get(a).contains(k)) {
            return this.values.get(a);
        }
        return null;
    }

    @Override // com.google.common.collect.RangeMap
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public java.util.Map.Entry<com.google.common.collect.Range<K>, V> getEntry(K k) {
        int a = com.google.common.collect.SortedLists.a(this.ranges, com.google.common.collect.Range.lowerBoundFn(), com.google.common.collect.Cut.belowValue(k), com.google.common.collect.SortedLists.KeyPresentBehavior.ANY_PRESENT, com.google.common.collect.SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (a == -1) {
            return null;
        }
        com.google.common.collect.Range<K> range = this.ranges.get(a);
        if (range.contains(k)) {
            return com.google.common.collect.Maps.immutableEntry(range, this.values.get(a));
        }
        return null;
    }

    @Override // com.google.common.collect.RangeMap
    public int hashCode() {
        return asMapOfRanges().hashCode();
    }

    @Override // com.google.common.collect.RangeMap
    @java.lang.Deprecated
    public void put(com.google.common.collect.Range<K> range, V v) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeMap
    @java.lang.Deprecated
    public void putAll(com.google.common.collect.RangeMap<K, V> rangeMap) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeMap
    @java.lang.Deprecated
    public void putCoalescing(com.google.common.collect.Range<K> range, V v) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeMap
    @java.lang.Deprecated
    public void remove(com.google.common.collect.Range<K> range) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeMap
    public com.google.common.collect.Range<K> span() {
        if (this.ranges.isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        return com.google.common.collect.Range.create(this.ranges.get(0).lowerBound, this.ranges.get(r1.size() - 1).upperBound);
    }

    @Override // com.google.common.collect.RangeMap
    public com.google.common.collect.ImmutableRangeMap<K, V> subRangeMap(com.google.common.collect.Range<K> range) {
        if (((com.google.common.collect.Range) com.google.common.base.Preconditions.checkNotNull(range)).isEmpty()) {
            return of();
        }
        if (this.ranges.isEmpty() || range.encloses(span())) {
            return this;
        }
        com.google.common.collect.ImmutableList<com.google.common.collect.Range<K>> immutableList = this.ranges;
        com.google.common.base.Function upperBoundFn = com.google.common.collect.Range.upperBoundFn();
        com.google.common.collect.Cut<K> cut = range.lowerBound;
        com.google.common.collect.SortedLists.KeyPresentBehavior keyPresentBehavior = com.google.common.collect.SortedLists.KeyPresentBehavior.FIRST_AFTER;
        com.google.common.collect.SortedLists.KeyAbsentBehavior keyAbsentBehavior = com.google.common.collect.SortedLists.KeyAbsentBehavior.NEXT_HIGHER;
        int a = com.google.common.collect.SortedLists.a(immutableList, upperBoundFn, cut, keyPresentBehavior, keyAbsentBehavior);
        int a2 = com.google.common.collect.SortedLists.a(this.ranges, com.google.common.collect.Range.lowerBoundFn(), range.upperBound, com.google.common.collect.SortedLists.KeyPresentBehavior.ANY_PRESENT, keyAbsentBehavior);
        return a >= a2 ? of() : new com.google.common.collect.ImmutableRangeMap.AnonymousClass2(new com.google.common.collect.ImmutableRangeMap.AnonymousClass1(a2 - a, a, range), this.values.subList(a, a2), range, this);
    }

    @Override // com.google.common.collect.RangeMap
    public java.lang.String toString() {
        return asMapOfRanges().toString();
    }

    public java.lang.Object writeReplace() {
        return new com.google.common.collect.ImmutableRangeMap.SerializedForm(asMapOfRanges());
    }
}
