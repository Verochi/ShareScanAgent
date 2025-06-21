package com.google.common.collect;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public final class ImmutableRangeSet<C extends java.lang.Comparable> extends com.google.common.collect.AbstractRangeSet<C> implements java.io.Serializable {

    @com.google.errorprone.annotations.concurrent.LazyInit
    private transient com.google.common.collect.ImmutableRangeSet<C> complement;
    private final transient com.google.common.collect.ImmutableList<com.google.common.collect.Range<C>> ranges;
    private static final com.google.common.collect.ImmutableRangeSet<java.lang.Comparable<?>> EMPTY = new com.google.common.collect.ImmutableRangeSet<>(com.google.common.collect.ImmutableList.of());
    private static final com.google.common.collect.ImmutableRangeSet<java.lang.Comparable<?>> ALL = new com.google.common.collect.ImmutableRangeSet<>(com.google.common.collect.ImmutableList.of(com.google.common.collect.Range.all()));

    /* renamed from: com.google.common.collect.ImmutableRangeSet$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.common.collect.ImmutableList<com.google.common.collect.Range<C>> {
        final /* synthetic */ int val$fromIndex;
        final /* synthetic */ int val$length;
        final /* synthetic */ com.google.common.collect.Range val$range;

        public AnonymousClass1(int i, int i2, com.google.common.collect.Range range) {
            this.val$length = i;
            this.val$fromIndex = i2;
            this.val$range = range;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        public com.google.common.collect.Range<C> get(int i) {
            com.google.common.base.Preconditions.checkElementIndex(i, this.val$length);
            return (i == 0 || i == this.val$length + (-1)) ? ((com.google.common.collect.Range) com.google.common.collect.ImmutableRangeSet.this.ranges.get(i + this.val$fromIndex)).intersection(this.val$range) : (com.google.common.collect.Range) com.google.common.collect.ImmutableRangeSet.this.ranges.get(i + this.val$fromIndex);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.val$length;
        }
    }

    public final class AsSet extends com.google.common.collect.ImmutableSortedSet<C> {
        private final com.google.common.collect.DiscreteDomain<C> domain;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        private transient java.lang.Integer size;

        /* renamed from: com.google.common.collect.ImmutableRangeSet$AsSet$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.collect.AbstractIterator<C> {
            public final java.util.Iterator<com.google.common.collect.Range<C>> u;
            public java.util.Iterator<C> v = com.google.common.collect.Iterators.f();

            public AnonymousClass1() {
                this.u = com.google.common.collect.ImmutableRangeSet.this.ranges.iterator();
            }

            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public C computeNext() {
                while (!this.v.hasNext()) {
                    if (!this.u.hasNext()) {
                        return (C) endOfData();
                    }
                    this.v = com.google.common.collect.ContiguousSet.create(this.u.next(), com.google.common.collect.ImmutableRangeSet.AsSet.this.domain).iterator();
                }
                return this.v.next();
            }
        }

        /* renamed from: com.google.common.collect.ImmutableRangeSet$AsSet$2, reason: invalid class name */
        public class AnonymousClass2 extends com.google.common.collect.AbstractIterator<C> {
            public final java.util.Iterator<com.google.common.collect.Range<C>> u;
            public java.util.Iterator<C> v = com.google.common.collect.Iterators.f();

            public AnonymousClass2() {
                this.u = com.google.common.collect.ImmutableRangeSet.this.ranges.reverse().iterator();
            }

            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public C computeNext() {
                while (!this.v.hasNext()) {
                    if (!this.u.hasNext()) {
                        return (C) endOfData();
                    }
                    this.v = com.google.common.collect.ContiguousSet.create(this.u.next(), com.google.common.collect.ImmutableRangeSet.AsSet.this.domain).descendingIterator();
                }
                return this.v.next();
            }
        }

        public AsSet(com.google.common.collect.DiscreteDomain<C> discreteDomain) {
            super(com.google.common.collect.Ordering.natural());
            this.domain = discreteDomain;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                return com.google.common.collect.ImmutableRangeSet.this.contains((java.lang.Comparable) obj);
            } catch (java.lang.ClassCastException unused) {
                return false;
            }
        }

        @Override // com.google.common.collect.ImmutableSortedSet
        public com.google.common.collect.ImmutableSortedSet<C> createDescendingSet() {
            return new com.google.common.collect.DescendingImmutableSortedSet(this);
        }

        @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
        @com.google.common.annotations.GwtIncompatible("NavigableSet")
        public com.google.common.collect.UnmodifiableIterator<C> descendingIterator() {
            return new com.google.common.collect.ImmutableRangeSet.AsSet.AnonymousClass2();
        }

        @Override // com.google.common.collect.ImmutableSortedSet
        public com.google.common.collect.ImmutableSortedSet<C> headSetImpl(C c, boolean z) {
            return subSet(com.google.common.collect.Range.upTo(c, com.google.common.collect.BoundType.forBoolean(z)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSortedSet
        public int indexOf(java.lang.Object obj) {
            if (!contains(obj)) {
                return -1;
            }
            java.lang.Comparable comparable = (java.lang.Comparable) obj;
            com.google.common.collect.UnmodifiableIterator it = com.google.common.collect.ImmutableRangeSet.this.ranges.iterator();
            long j = 0;
            while (it.hasNext()) {
                if (((com.google.common.collect.Range) it.next()).contains(comparable)) {
                    return com.google.common.primitives.Ints.saturatedCast(j + com.google.common.collect.ContiguousSet.create(r3, this.domain).indexOf(comparable));
                }
                j += com.google.common.collect.ContiguousSet.create(r3, this.domain).size();
            }
            throw new java.lang.AssertionError("impossible");
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return com.google.common.collect.ImmutableRangeSet.this.ranges.isPartialView();
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public com.google.common.collect.UnmodifiableIterator<C> iterator() {
            return new com.google.common.collect.ImmutableRangeSet.AsSet.AnonymousClass1();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            java.lang.Integer num = this.size;
            if (num == null) {
                com.google.common.collect.UnmodifiableIterator it = com.google.common.collect.ImmutableRangeSet.this.ranges.iterator();
                long j = 0;
                while (it.hasNext()) {
                    j += com.google.common.collect.ContiguousSet.create((com.google.common.collect.Range) it.next(), this.domain).size();
                    if (j >= 2147483647L) {
                        break;
                    }
                }
                num = java.lang.Integer.valueOf(com.google.common.primitives.Ints.saturatedCast(j));
                this.size = num;
            }
            return num.intValue();
        }

        public com.google.common.collect.ImmutableSortedSet<C> subSet(com.google.common.collect.Range<C> range) {
            return com.google.common.collect.ImmutableRangeSet.this.subRangeSet((com.google.common.collect.Range) range).asSet(this.domain);
        }

        @Override // com.google.common.collect.ImmutableSortedSet
        public com.google.common.collect.ImmutableSortedSet<C> subSetImpl(C c, boolean z, C c2, boolean z2) {
            return (z || z2 || com.google.common.collect.Range.compareOrThrow(c, c2) != 0) ? subSet(com.google.common.collect.Range.range(c, com.google.common.collect.BoundType.forBoolean(z), c2, com.google.common.collect.BoundType.forBoolean(z2))) : com.google.common.collect.ImmutableSortedSet.of();
        }

        @Override // com.google.common.collect.ImmutableSortedSet
        public com.google.common.collect.ImmutableSortedSet<C> tailSetImpl(C c, boolean z) {
            return subSet(com.google.common.collect.Range.downTo(c, com.google.common.collect.BoundType.forBoolean(z)));
        }

        @Override // java.util.AbstractCollection
        public java.lang.String toString() {
            return com.google.common.collect.ImmutableRangeSet.this.ranges.toString();
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public java.lang.Object writeReplace() {
            return new com.google.common.collect.ImmutableRangeSet.AsSetSerializedForm(com.google.common.collect.ImmutableRangeSet.this.ranges, this.domain);
        }
    }

    public static class AsSetSerializedForm<C extends java.lang.Comparable> implements java.io.Serializable {
        private final com.google.common.collect.DiscreteDomain<C> domain;
        private final com.google.common.collect.ImmutableList<com.google.common.collect.Range<C>> ranges;

        public AsSetSerializedForm(com.google.common.collect.ImmutableList<com.google.common.collect.Range<C>> immutableList, com.google.common.collect.DiscreteDomain<C> discreteDomain) {
            this.ranges = immutableList;
            this.domain = discreteDomain;
        }

        public java.lang.Object readResolve() {
            return new com.google.common.collect.ImmutableRangeSet(this.ranges).asSet(this.domain);
        }
    }

    public static class Builder<C extends java.lang.Comparable<?>> {
        public final java.util.List<com.google.common.collect.Range<C>> a = com.google.common.collect.Lists.newArrayList();

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableRangeSet.Builder<C> add(com.google.common.collect.Range<C> range) {
            com.google.common.base.Preconditions.checkArgument(!range.isEmpty(), "range must not be empty, but was %s", range);
            this.a.add(range);
            return this;
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableRangeSet.Builder<C> addAll(com.google.common.collect.RangeSet<C> rangeSet) {
            return addAll(rangeSet.asRanges());
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableRangeSet.Builder<C> addAll(java.lang.Iterable<com.google.common.collect.Range<C>> iterable) {
            java.util.Iterator<com.google.common.collect.Range<C>> it = iterable.iterator();
            while (it.hasNext()) {
                add(it.next());
            }
            return this;
        }

        public com.google.common.collect.ImmutableRangeSet<C> build() {
            com.google.common.collect.ImmutableList.Builder builder = new com.google.common.collect.ImmutableList.Builder(this.a.size());
            java.util.Collections.sort(this.a, com.google.common.collect.Range.rangeLexOrdering());
            com.google.common.collect.PeekingIterator peekingIterator = com.google.common.collect.Iterators.peekingIterator(this.a.iterator());
            while (peekingIterator.hasNext()) {
                com.google.common.collect.Range range = (com.google.common.collect.Range) peekingIterator.next();
                while (peekingIterator.hasNext()) {
                    com.google.common.collect.Range<C> range2 = (com.google.common.collect.Range) peekingIterator.peek();
                    if (range.isConnected(range2)) {
                        com.google.common.base.Preconditions.checkArgument(range.intersection(range2).isEmpty(), "Overlapping ranges not permitted but found %s overlapping %s", range, range2);
                        range = range.span((com.google.common.collect.Range) peekingIterator.next());
                    }
                }
                builder.add((com.google.common.collect.ImmutableList.Builder) range);
            }
            com.google.common.collect.ImmutableList build = builder.build();
            return build.isEmpty() ? com.google.common.collect.ImmutableRangeSet.of() : (build.size() == 1 && ((com.google.common.collect.Range) com.google.common.collect.Iterables.getOnlyElement(build)).equals(com.google.common.collect.Range.all())) ? com.google.common.collect.ImmutableRangeSet.all() : new com.google.common.collect.ImmutableRangeSet<>(build);
        }
    }

    public final class ComplementRanges extends com.google.common.collect.ImmutableList<com.google.common.collect.Range<C>> {
        private final boolean positiveBoundedAbove;
        private final boolean positiveBoundedBelow;
        private final int size;

        /* JADX WARN: Multi-variable type inference failed */
        public ComplementRanges() {
            boolean hasLowerBound = ((com.google.common.collect.Range) com.google.common.collect.ImmutableRangeSet.this.ranges.get(0)).hasLowerBound();
            this.positiveBoundedBelow = hasLowerBound;
            boolean hasUpperBound = ((com.google.common.collect.Range) com.google.common.collect.Iterables.getLast(com.google.common.collect.ImmutableRangeSet.this.ranges)).hasUpperBound();
            this.positiveBoundedAbove = hasUpperBound;
            int size = com.google.common.collect.ImmutableRangeSet.this.ranges.size() - 1;
            size = hasLowerBound ? size + 1 : size;
            this.size = hasUpperBound ? size + 1 : size;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        public com.google.common.collect.Range<C> get(int i) {
            com.google.common.base.Preconditions.checkElementIndex(i, this.size);
            return com.google.common.collect.Range.create(this.positiveBoundedBelow ? i == 0 ? com.google.common.collect.Cut.belowAll() : ((com.google.common.collect.Range) com.google.common.collect.ImmutableRangeSet.this.ranges.get(i - 1)).upperBound : ((com.google.common.collect.Range) com.google.common.collect.ImmutableRangeSet.this.ranges.get(i)).upperBound, (this.positiveBoundedAbove && i == this.size + (-1)) ? com.google.common.collect.Cut.aboveAll() : ((com.google.common.collect.Range) com.google.common.collect.ImmutableRangeSet.this.ranges.get(i + (!this.positiveBoundedBelow ? 1 : 0))).lowerBound);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.size;
        }
    }

    public static final class SerializedForm<C extends java.lang.Comparable> implements java.io.Serializable {
        private final com.google.common.collect.ImmutableList<com.google.common.collect.Range<C>> ranges;

        public SerializedForm(com.google.common.collect.ImmutableList<com.google.common.collect.Range<C>> immutableList) {
            this.ranges = immutableList;
        }

        public java.lang.Object readResolve() {
            return this.ranges.isEmpty() ? com.google.common.collect.ImmutableRangeSet.of() : this.ranges.equals(com.google.common.collect.ImmutableList.of(com.google.common.collect.Range.all())) ? com.google.common.collect.ImmutableRangeSet.all() : new com.google.common.collect.ImmutableRangeSet(this.ranges);
        }
    }

    public ImmutableRangeSet(com.google.common.collect.ImmutableList<com.google.common.collect.Range<C>> immutableList) {
        this.ranges = immutableList;
    }

    private ImmutableRangeSet(com.google.common.collect.ImmutableList<com.google.common.collect.Range<C>> immutableList, com.google.common.collect.ImmutableRangeSet<C> immutableRangeSet) {
        this.ranges = immutableList;
        this.complement = immutableRangeSet;
    }

    public static <C extends java.lang.Comparable> com.google.common.collect.ImmutableRangeSet<C> all() {
        return ALL;
    }

    public static <C extends java.lang.Comparable<?>> com.google.common.collect.ImmutableRangeSet.Builder<C> builder() {
        return new com.google.common.collect.ImmutableRangeSet.Builder<>();
    }

    public static <C extends java.lang.Comparable> com.google.common.collect.ImmutableRangeSet<C> copyOf(com.google.common.collect.RangeSet<C> rangeSet) {
        com.google.common.base.Preconditions.checkNotNull(rangeSet);
        if (rangeSet.isEmpty()) {
            return of();
        }
        if (rangeSet.encloses(com.google.common.collect.Range.all())) {
            return all();
        }
        if (rangeSet instanceof com.google.common.collect.ImmutableRangeSet) {
            com.google.common.collect.ImmutableRangeSet<C> immutableRangeSet = (com.google.common.collect.ImmutableRangeSet) rangeSet;
            if (!immutableRangeSet.isPartialView()) {
                return immutableRangeSet;
            }
        }
        return new com.google.common.collect.ImmutableRangeSet<>(com.google.common.collect.ImmutableList.copyOf((java.util.Collection) rangeSet.asRanges()));
    }

    public static <C extends java.lang.Comparable<?>> com.google.common.collect.ImmutableRangeSet<C> copyOf(java.lang.Iterable<com.google.common.collect.Range<C>> iterable) {
        return new com.google.common.collect.ImmutableRangeSet.Builder().addAll(iterable).build();
    }

    private com.google.common.collect.ImmutableList<com.google.common.collect.Range<C>> intersectRanges(com.google.common.collect.Range<C> range) {
        if (this.ranges.isEmpty() || range.isEmpty()) {
            return com.google.common.collect.ImmutableList.of();
        }
        if (range.encloses(span())) {
            return this.ranges;
        }
        int a = range.hasLowerBound() ? com.google.common.collect.SortedLists.a(this.ranges, com.google.common.collect.Range.upperBoundFn(), range.lowerBound, com.google.common.collect.SortedLists.KeyPresentBehavior.FIRST_AFTER, com.google.common.collect.SortedLists.KeyAbsentBehavior.NEXT_HIGHER) : 0;
        int a2 = (range.hasUpperBound() ? com.google.common.collect.SortedLists.a(this.ranges, com.google.common.collect.Range.lowerBoundFn(), range.upperBound, com.google.common.collect.SortedLists.KeyPresentBehavior.FIRST_PRESENT, com.google.common.collect.SortedLists.KeyAbsentBehavior.NEXT_HIGHER) : this.ranges.size()) - a;
        return a2 == 0 ? com.google.common.collect.ImmutableList.of() : new com.google.common.collect.ImmutableRangeSet.AnonymousClass1(a2, a, range);
    }

    public static <C extends java.lang.Comparable> com.google.common.collect.ImmutableRangeSet<C> of() {
        return EMPTY;
    }

    public static <C extends java.lang.Comparable> com.google.common.collect.ImmutableRangeSet<C> of(com.google.common.collect.Range<C> range) {
        com.google.common.base.Preconditions.checkNotNull(range);
        return range.isEmpty() ? of() : range.equals(com.google.common.collect.Range.all()) ? all() : new com.google.common.collect.ImmutableRangeSet<>(com.google.common.collect.ImmutableList.of(range));
    }

    public static <C extends java.lang.Comparable<?>> com.google.common.collect.ImmutableRangeSet<C> unionOf(java.lang.Iterable<com.google.common.collect.Range<C>> iterable) {
        return copyOf(com.google.common.collect.TreeRangeSet.create(iterable));
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    @java.lang.Deprecated
    public void add(com.google.common.collect.Range<C> range) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    @java.lang.Deprecated
    public void addAll(com.google.common.collect.RangeSet<C> rangeSet) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    @java.lang.Deprecated
    public void addAll(java.lang.Iterable<com.google.common.collect.Range<C>> iterable) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeSet
    public com.google.common.collect.ImmutableSet<com.google.common.collect.Range<C>> asDescendingSetOfRanges() {
        return this.ranges.isEmpty() ? com.google.common.collect.ImmutableSet.of() : new com.google.common.collect.RegularImmutableSortedSet(this.ranges.reverse(), com.google.common.collect.Range.rangeLexOrdering().reverse());
    }

    @Override // com.google.common.collect.RangeSet
    public com.google.common.collect.ImmutableSet<com.google.common.collect.Range<C>> asRanges() {
        return this.ranges.isEmpty() ? com.google.common.collect.ImmutableSet.of() : new com.google.common.collect.RegularImmutableSortedSet(this.ranges, com.google.common.collect.Range.rangeLexOrdering());
    }

    public com.google.common.collect.ImmutableSortedSet<C> asSet(com.google.common.collect.DiscreteDomain<C> discreteDomain) {
        com.google.common.base.Preconditions.checkNotNull(discreteDomain);
        if (isEmpty()) {
            return com.google.common.collect.ImmutableSortedSet.of();
        }
        com.google.common.collect.Range<C> canonical = span().canonical(discreteDomain);
        if (!canonical.hasLowerBound()) {
            throw new java.lang.IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded below");
        }
        if (!canonical.hasUpperBound()) {
            try {
                discreteDomain.maxValue();
            } catch (java.util.NoSuchElementException unused) {
                throw new java.lang.IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded above");
            }
        }
        return new com.google.common.collect.ImmutableRangeSet.AsSet(discreteDomain);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.RangeSet
    public com.google.common.collect.ImmutableRangeSet<C> complement() {
        com.google.common.collect.ImmutableRangeSet<C> immutableRangeSet = this.complement;
        if (immutableRangeSet != null) {
            return immutableRangeSet;
        }
        if (this.ranges.isEmpty()) {
            com.google.common.collect.ImmutableRangeSet<C> all = all();
            this.complement = all;
            return all;
        }
        if (this.ranges.size() == 1 && this.ranges.get(0).equals(com.google.common.collect.Range.all())) {
            com.google.common.collect.ImmutableRangeSet<C> of = of();
            this.complement = of;
            return of;
        }
        com.google.common.collect.ImmutableRangeSet<C> immutableRangeSet2 = new com.google.common.collect.ImmutableRangeSet<>(new com.google.common.collect.ImmutableRangeSet.ComplementRanges(), this);
        this.complement = immutableRangeSet2;
        return immutableRangeSet2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean contains(java.lang.Comparable comparable) {
        return super.contains(comparable);
    }

    public com.google.common.collect.ImmutableRangeSet<C> difference(com.google.common.collect.RangeSet<C> rangeSet) {
        com.google.common.collect.TreeRangeSet create = com.google.common.collect.TreeRangeSet.create(this);
        create.removeAll(rangeSet);
        return copyOf(create);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public boolean encloses(com.google.common.collect.Range<C> range) {
        int b = com.google.common.collect.SortedLists.b(this.ranges, com.google.common.collect.Range.lowerBoundFn(), range.lowerBound, com.google.common.collect.Ordering.natural(), com.google.common.collect.SortedLists.KeyPresentBehavior.ANY_PRESENT, com.google.common.collect.SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        return b != -1 && this.ranges.get(b).encloses(range);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean enclosesAll(com.google.common.collect.RangeSet rangeSet) {
        return super.enclosesAll(rangeSet);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean enclosesAll(java.lang.Iterable iterable) {
        return super.enclosesAll(iterable);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return super.equals(obj);
    }

    public com.google.common.collect.ImmutableRangeSet<C> intersection(com.google.common.collect.RangeSet<C> rangeSet) {
        com.google.common.collect.TreeRangeSet create = com.google.common.collect.TreeRangeSet.create(this);
        create.removeAll(rangeSet.complement());
        return copyOf(create);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public boolean intersects(com.google.common.collect.Range<C> range) {
        int b = com.google.common.collect.SortedLists.b(this.ranges, com.google.common.collect.Range.lowerBoundFn(), range.lowerBound, com.google.common.collect.Ordering.natural(), com.google.common.collect.SortedLists.KeyPresentBehavior.ANY_PRESENT, com.google.common.collect.SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
        if (b < this.ranges.size() && this.ranges.get(b).isConnected(range) && !this.ranges.get(b).intersection(range).isEmpty()) {
            return true;
        }
        if (b > 0) {
            int i = b - 1;
            if (this.ranges.get(i).isConnected(range) && !this.ranges.get(i).intersection(range).isEmpty()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public boolean isEmpty() {
        return this.ranges.isEmpty();
    }

    public boolean isPartialView() {
        return this.ranges.isPartialView();
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public com.google.common.collect.Range<C> rangeContaining(C c) {
        int b = com.google.common.collect.SortedLists.b(this.ranges, com.google.common.collect.Range.lowerBoundFn(), com.google.common.collect.Cut.belowValue(c), com.google.common.collect.Ordering.natural(), com.google.common.collect.SortedLists.KeyPresentBehavior.ANY_PRESENT, com.google.common.collect.SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (b == -1) {
            return null;
        }
        com.google.common.collect.Range<C> range = this.ranges.get(b);
        if (range.contains(c)) {
            return range;
        }
        return null;
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    @java.lang.Deprecated
    public void remove(com.google.common.collect.Range<C> range) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    @java.lang.Deprecated
    public void removeAll(com.google.common.collect.RangeSet<C> rangeSet) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    @java.lang.Deprecated
    public void removeAll(java.lang.Iterable<com.google.common.collect.Range<C>> iterable) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeSet
    public com.google.common.collect.Range<C> span() {
        if (this.ranges.isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        return com.google.common.collect.Range.create(this.ranges.get(0).lowerBound, this.ranges.get(r1.size() - 1).upperBound);
    }

    @Override // com.google.common.collect.RangeSet
    public com.google.common.collect.ImmutableRangeSet<C> subRangeSet(com.google.common.collect.Range<C> range) {
        if (!isEmpty()) {
            com.google.common.collect.Range<C> span = span();
            if (range.encloses(span)) {
                return this;
            }
            if (range.isConnected(span)) {
                return new com.google.common.collect.ImmutableRangeSet<>(intersectRanges(range));
            }
        }
        return of();
    }

    public com.google.common.collect.ImmutableRangeSet<C> union(com.google.common.collect.RangeSet<C> rangeSet) {
        return unionOf(com.google.common.collect.Iterables.concat(asRanges(), rangeSet.asRanges()));
    }

    public java.lang.Object writeReplace() {
        return new com.google.common.collect.ImmutableRangeSet.SerializedForm(this.ranges);
    }
}
